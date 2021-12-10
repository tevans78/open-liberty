/*******************************************************************************
 * Copyright (c) 2011, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.application;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.Attribute;
import javax.management.ObjectName;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Cluster;
import com.ibm.websphere.simplicity.Node;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.RemoteFile;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.Server;
import com.ibm.websphere.simplicity.WebServer;
import com.ibm.websphere.simplicity.application.tasks.ApplicationTask;
import com.ibm.websphere.simplicity.application.types.UpdateContentType;
import com.ibm.websphere.simplicity.application.types.UpdateType;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.ObjectNameHelper;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.ApplicationOperationsProvider;
import com.ibm.websphere.simplicity.provider.websphere.MBeanOperationsProvider;
import com.ibm.websphere.simplicity.provider.websphere.WebSphereOperationsProvider;

public abstract class Application {

//	protected static Application create(ApplicationManager mgr, ApplicationType type, String name, Cell scope) throws Exception {
//		Application ret = null;
//		// Other application types?
//		switch(type) {
//			case Enterprise: ret = new EnterpriseApplication(mgr, name, scope);
//		}
//		return ret;
//	}

    protected static Class<?> c = Application.class;

    protected Cell scope;
    protected String name;
    protected ArchiveType archiveType = null;
    protected String installRoot;
    protected Boolean isInstalled = null;
    protected ApplicationType type;
    protected ApplicationManager applications;
    protected ApplicationOptions applicationOptions;
    protected Set<AssetModule> modules;

    protected Application(ApplicationManager mgr, ApplicationType type, String name, Cell scope) throws Exception {
        Log.entering(c, "WebSphereApplication");
        this.scope = scope;
        this.type = type;
        this.name = name;
        this.archiveType = ArchiveType.EAR;

        this.applications = mgr;
        this.isInstalled = isInstalled();
    }

    public abstract OperationResults<Boolean> stop() throws Exception;

    public abstract OperationResults<Boolean> start() throws Exception;

    public abstract OperationResults<Boolean> update(UpdateWrapper options) throws Exception;

    public abstract OperationResults<Boolean> edit(EditWrapper options) throws Exception;

    public abstract UpdateWrapper getUpdateWrapper() throws Exception;

    public abstract UpdateWrapper getUpdateWrapper(UpdateType updateType, RemoteFile contents, UpdateContentType contentType) throws Exception;

    @Deprecated
    public abstract UpdateWrapper getUpdateWrapper(RemoteFile file) throws Exception;

    public abstract EditWrapper getEditWrapper() throws Exception;

    public abstract EditWrapper getEditWrapper(AssetModule module) throws Exception;

    /**
     * @return The path to the binary files, with variables left intact.
     */
    public abstract String getDestinationPath();

    /**
     * @return The fully qualified path to the binary files, with variables expanded.
     */
    public abstract String getDestinationPath(Node node);

    /**
     * When installing an application in WebSphere, various options and
     * deployment scenarios mean that the application's deployment
     * descriptor (DD) can either a) not exist; b) exist in multiple
     * locations; or c) exist in a single file. This API retrieves the
     * contents of the DD regardless of the options used, though in
     * the case of a non-existent DD there is only an empty string.
     *
     * @return The contents of the application's deployment descriptor, if any.
     */
    public abstract String getDeploymentDescriptor() throws Exception;

    /**
     * @return The contents of the module's deployment descriptor, if any.
     */
    public abstract String getDeploymentDescriptor(AssetModule module) throws Exception;

    /**
     * @return The name of the application defined during installation.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return an enum that describes the type of archive that contains this application.
     */
    public ArchiveType getArchiveType() {
        return this.archiveType;
    }

    /**
     * @return An enum that describes the type of application represented by this instance.
     */
    public ApplicationType getApplicationType() {
        return this.type;
    }

    /**
     * Returns the root folder for the application installation. This is either
     * the default folder, or the one specified in AppDeploymentOptions during
     * installation.
     */
    public String getInstallLocation() {
        return getInstallLocation(null);
    }

    /**
     * Returns the root folder for the application installation. This is either
     * the default folder, or the one specified in AppDeploymentOptions during
     * installation. Any variables in the location are expanded based on the scope
     * passed in.
     *
     * @param scope The {@link Node} to get the install location for
     */
    public String getInstallLocation(Node scope) {
        try {
            Set<Server> servers = new HashSet<Server>();
            if (scope != null) {
                Set<AssetModule> modules = getModules();
                for (AssetModule module : modules) {
                    List<Scope> targets = module.getTargets();
                    for (Scope target : targets) {
                        if (target instanceof Cluster)
                            servers.addAll(((Cluster) target).getMembers());
                        else
                            servers.add((Server) target);
                    }
                }
                for (Server server : servers)
                    if (server.getNode().equals(scope)) {
                        return getInstallLocation(scope, null);
                    }
                throw new IllegalArgumentException("There are no targets for application " + this.getName() + " that belong to node " + scope.getName());
            } else {
                return getInstallLocation(scope, null);
            }
        } catch (Exception e) {
            // Need to eat this since the method wasn't originally defined with a throws clause
            Log.error(c, "getInstallLocation", e);
        }
        return null;
    }

    protected String getInstallLocation(Node scope, String installLocation) {
        try {
            if (installLocation == null)
                installLocation = this.getApplicationOptions().getAppDeploymentOptions().getInstallDirectory();

            if (scope != null)
                return scope.expandString(installLocation);
            else
                return installLocation.replace('\\', '/');
        } catch (Exception e) {
            Log.error(c, "getInstallLocation", e);
        }
        return null;
    }

    /**
     * @return A reference to the scope used to create this application.
     */
    public Scope getScope() {
        return this.scope;
    }

    /**
     * @return The full path of the archive on the cell's server.
     */
    public String getArchivePath() {
        return getInstallLocation() + "/" + getName() + ".ear";
    }

    /**
     * @param moduleName The name of the module whose existence will be checked.
     * @return True if the module exists in the installed application.
     * @throws Exception
     */
    public boolean moduleExists(String moduleName) throws Exception {
        Log.entering(c, "moduleExists", moduleName);
        boolean res = false;
        for (AssetModule module : getModules()) {
            if (module.getName().equalsIgnoreCase(moduleName)) {
                res = true;
                break;
            }
        }
        Log.exiting(c, "moduleExists", res);
        return res;
    }

    /**
     * @return True if the application is installed.
     * @throws Exception
     */
    public boolean isInstalled() throws Exception {
        Log.entering(c, "isInstalled");
        isInstalled = getApplicationProvider().checkIfAppExists(getScope(), this.getName(), getScope().getActiveSession());
        Log.exiting(c, "isInstalled", isInstalled);
        return isInstalled;
    }

    /**
     * Attempts to launch the application, and -- if successful -- waits up to
     * five minutes for the app to finish starting on all targets. If the launch
     * operation is not successful, the call will return immediately.
     *
     * @param wait True to wait synchronously for a successful launch.
     * @return An instance of OperationResults containing all startup information.
     * @throws Exception
     */
    public OperationResults<Boolean> start(boolean wait) throws Exception {
        // Default to three minutes
        return start(wait, 30000);
    }

    /**
     * Attempts to launch the application, and -- if successful -- waits up to
     * the specified timeout (ms) for the app to finish starting on all targets.
     * If the launch operation is not successful, the call will return immediately.
     *
     * @param wait    True to wait synchronously for a successful launch.
     * @param timeout The duration to wait for a successful launch in milliseconds.
     * @return An instance of OperationResults containing all startup information.
     * @throws Exception
     */
    public OperationResults<Boolean> start(boolean wait, long timeout) throws Exception {
        Log.entering(c, "start", new Object[] { wait, timeout });
        OperationResults<Boolean> result = start();
        if (!result.isSuccess())
            return result;

        if (wait) {
            ApplicationStatus state = waitForState(ApplicationStatus.STARTED, timeout);
            OperationResults<Boolean> tmp = new OperationResults<Boolean>(state == ApplicationStatus.STARTED);
            // Copy over notifications etc.
            OperationResults.setOperationResults(tmp, result);
            result = tmp;
        }
        Log.exiting(c, "start", result);
        return result;
    }

    /**
     * Attempts to stop the application, and -- if successful -- waits up to
     * five minutes for the app to finish stopping on all targets. If the stop
     * operation is not successful, the call will return immediately.
     *
     * @param wait True to wait synchronously for a complete stop.
     * @return An instance of OperationResults containing all shutdown information.
     * @throws Exception
     */
    public OperationResults<Boolean> stop(boolean wait) throws Exception {
        // Default to three minutes
        return stop(wait, 30000);
    }

    /**
     * Attempts to stop the application, and -- if successful -- waits up to
     * the specified timeout (ms) for the app to finish stopping on all targets.
     * If the stop operation is not successful, the call will return immediately.
     *
     * @param wait    True to wait synchronously for a complete stop.
     * @param timeout The duration to wait for a complete stop in milliseconds.
     * @return An instance of OperationResults containing all shutdown information.
     * @throws Exception
     */
    public OperationResults<Boolean> stop(boolean wait, long timeout) throws Exception {
        Log.entering(c, "stop", new Object[] { wait, timeout });
        OperationResults<Boolean> result = stop();
        if (!result.isSuccess())
            return result;

        if (wait) {
            ApplicationStatus state = waitForState(ApplicationStatus.STOPPED, timeout);
            OperationResults<Boolean> tmp = new OperationResults<Boolean>(state == ApplicationStatus.STOPPED);
            // Copy over notifications etc.
            OperationResults.setOperationResults(tmp, result);
            result = tmp;
        }
        Log.exiting(c, "stop", result);
        return result;
    }

    /**
     * This method returns true if the application is running on any of its deployed targets. Use
     * the {@link #getApplicationStatus()} to get the aggregate status of the application across all
     * deployed targets and the {@link #getApplicationStatus(Scope)} method to get the
     * status of the application on a particular target.
     * TODO This should call getApplicationStatus instead.
     *
     * @return True if the application is running on any of its deployed targets
     * @throws Exception
     */
    public boolean isStarted() throws Exception {
        Log.entering(c, "isStarted");
        ApplicationStatus result = this.getApplicationStatus();
        Log.exiting(c, "isStarted", (result == ApplicationStatus.STARTED));
        return (result == ApplicationStatus.STARTED);
    }

    /**
     * Check the status of an application on a particular server. This method returns
     * {@link ApplicationStatus#STARTED} if the application is running on the server. {@link ApplicationStatus#STOPPED} is
     * returned if the application is not running on the target and the server or the node manager
     * is running. {@link ApplicationStatus#UNKNOWN} is returned if the application is not running on the
     * server and the node manager is not available.
     *
     * @param server The {@link Server} to get the status of the application on
     * @return The status of the application on the particular server
     * @throws Exception
     */
    protected ApplicationStatus getApplicationStatus(Server server) throws Exception {
        final String method = "getServerSpecificApplicationStatus";
        if (server instanceof WebServer) {
            Log.finer(c, method, "The scope is a web server. They do not have a status");
            Log.exiting(c, method, ApplicationStatus.NA);
            return ApplicationStatus.NA;
        }
        Log.entering(c, method, server);
        ObjectNameHelper spec = ObjectNameHelper.getJ2EEApplication(server, this.name);
        MBeanOperationsProvider mbeanProvider = getOperationsProvider().getMBeanOperationsProvider();
        ObjectName mbean = mbeanProvider.queryObjectName(server, spec.toObjectName());
        ApplicationStatus ret = null;
        if (mbean != null) {
            Log.finer(c, method, "Found the MBean, querying the state.");
            String[] atts = new String[] { "state" };
            int state = (Integer) ((Attribute) mbeanProvider.getMBeanAttributes(server, mbean, atts).get(0)).getValue();
            Log.finer(c, method, "State value: " + state);
            switch (state) {
                case ApplicationStatus.RUNNING_STATE:
                    return ApplicationStatus.STARTED;
                case ApplicationStatus.STOPPED_STATE:
                    return ApplicationStatus.STOPPED;
                case ApplicationStatus.FAILED_STATE:
                    return ApplicationStatus.UNKNOWN;
                case ApplicationStatus.STARTING_STATE:
                    return ApplicationStatus.STARTING;
                case ApplicationStatus.STOPPING_STATE:
                    return ApplicationStatus.STOPPED;
                default:
                    return ApplicationStatus.UNKNOWN;
            }
        } else {
            Log.finer(c, method, "The app is not started on the server. Checking if server mbean is available.");
            spec = ObjectNameHelper.getServer(server.getNode().getName(), server.getName());
            mbean = getOperationsProvider().getMBeanOperationsProvider().queryObjectName(server, spec.toObjectName());
            if (mbean != null) {
                Log.finer(c, method, "The server mbean is available which means the application is stopped.");
                ret = ApplicationStatus.STOPPED;
            } else {
                Log.finer(c, method, "The server mbean is not available. Checking if the node manager MBean is available.");
                spec = ObjectNameHelper.getServer(server.getNode().getName(), server.getNode().getManager().getName());
                mbean = getOperationsProvider().getMBeanOperationsProvider().queryObjectName(server, spec.toObjectName());
                if (mbean != null) {
                    Log.finer(c, method, "The node manager mbean is available which means the application is stopped.");
                    ret = ApplicationStatus.STOPPED;
                } else {
                    Log.finer(c, method, "The node manager mbean is not available. The app status is unknown on the target.");
                    ret = ApplicationStatus.UNKNOWN;
                }
            }
        }
        Log.exiting(c, method, ret);
        return ret;
    }

    /**
     * Get the status of the application on the specified {@link Scope}. This method returns
     * {@link ApplicationStatus#STARTED} if the application is running on all the servers in the scope. If the
     * Scope is a {@link Cluster} all the members of the cluster are checked. This method returns
     * {@link ApplicationStatus#STOPPED} if the application is not running on any of the servers in the Scope
     * and at least one of the node manager servers is running. This method returns
     * {@link ApplicationStatus#UNKNOWN} if the application is not running on any of the servers in the Scope
     * and the node manager is not available. This method returns {@link ApplicationStatus#PARTIALLY_STARTED}
     * if the application is running on at least one of the servers in the scope but not all.
     *
     * @param scope The {@link Scope} to query
     * @return The aggregate status of the application on the specified Scope
     * @throws Exception
     */
    public ApplicationStatus getApplicationStatus(Scope scope) throws Exception {
        final String method = "getApplicationStatus";
        Log.entering(c, method, scope);
        Set<Scope> targets = this.getDeployedTargets();
        boolean valid = false;
        for (Scope target : targets) {
            if (scope.equals(target)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new Exception("The Scope " + scope.getName() + " is not a deployed target of this application.");
        }
        if (scope instanceof WebServer) {
            Log.finer(c, method, "The scope is a web server. They do not have a status");
            Log.exiting(c, method, ApplicationStatus.NA);
            return ApplicationStatus.NA;
        }
        int targetCount = 0;
        int startedCount = 0;
        int stoppedCount = 0;
        ApplicationStatus status = null;
        if (scope instanceof Cluster) {
            Log.finer(c, method, "Target is a cluster.");
            Set<Server> members = ((Cluster) scope).getMembers();
            for (Server member : members) {
                Log.finer(c, method, "Processing cluster member " + member.getName());
                targetCount++;
                status = getApplicationStatus(member);
                if (status == ApplicationStatus.STARTED) {
                    Log.finer(c, method, "Application is started on cluster member " + member.getName());
                    startedCount++;
                } else if (status == ApplicationStatus.STOPPED) {
                    Log.finer(c, method, "Application is stopped on cluster member " + member.getName());
                    stoppedCount++;
                } else {
                    Log.finer(c, method, "Application status is unknown on cluster member " + member.getName());
                }
            }
        } else {
            // server
            Log.finer(c, method, "Target is a server. Processing server " + scope.getName());
            targetCount++;
            status = getApplicationStatus((Server) scope);
            if (status == ApplicationStatus.STARTED) {
                Log.finer(c, method, "Application is started on server " + scope.getName());
                startedCount++;
            } else if (status == ApplicationStatus.STOPPED) {
                Log.finer(c, method, "Application is stopped on server " + scope.getName());
                stoppedCount++;
            } else {
                Log.finer(c, method, "Application status is unknown on server " + scope.getName());
            }
        }

        Log.finer(c, method, "targetCount: " + targetCount + ", startedCount: " + startedCount + ", stoppedCount: " + stoppedCount);
        if (targetCount == 0) {
            status = ApplicationStatus.NA;
        } else if (targetCount == startedCount) {
            status = ApplicationStatus.STARTED;
        } else if (startedCount == 0) {
            if (stoppedCount == 0) {
                status = ApplicationStatus.UNKNOWN;
            } else {
                status = ApplicationStatus.STOPPED;
            }
        } else {
            status = ApplicationStatus.PARTIALLY_STARTED;
        }

        Log.exiting(c, method, status);
        return status;
    }

    /**
     * Get the aggregate status of an application across all deployed targets. This method returns
     * {@link ApplicationStatus#STARTED} if the application is running on all deployed targets. This method
     * returns {@link ApplicationStatus#STOPPED} if the application is not running on any of the deployed
     * targets and the application status is not {@link ApplicationStatus#UNKNOWN} on at least one of the
     * targets. {@link ApplicationStatus#UNKNOWN} is returned if the manager server is not running on all the
     * nodes of all the deployed targets. {@link ApplicationStatus#PARTIALLY_STARTED} is returned if the
     * application is running on at least one target but not all targets.
     *
     * @return The status aggregate status of the application
     * @throws Exception
     */
    public ApplicationStatus getApplicationStatus() throws Exception {
        final String method = "getApplicationStatus";
        Log.entering(c, method);

        Set<Scope> targets = this.getDeployedTargets();
        ApplicationStatus status = null;
        ApplicationStatus current = null;
        for (Scope target : targets) {
            current = getApplicationStatus(target);
            if (current == ApplicationStatus.NA)
                continue;
            else if (status == null) {
                status = current;
                if (status == ApplicationStatus.PARTIALLY_STARTED) {
                    break;
                }
            } else if ((status == ApplicationStatus.STARTED && current != ApplicationStatus.STARTED)
                       || (status != ApplicationStatus.STARTED && current == ApplicationStatus.STARTED)) {
                status = ApplicationStatus.PARTIALLY_STARTED;
                break;
            } else if (status == ApplicationStatus.UNKNOWN && current == ApplicationStatus.STOPPED) {
                status = ApplicationStatus.STOPPED;
            } else {
                // do nothing
            }
            if (status == null)
                status = ApplicationStatus.UNKNOWN;
        }

        Log.exiting(c, method, status);
        return status;
    }

    /**
     * @return An object containing all of the settings for the application. Changing these values does *not* modify the installed application.
     * @throws Exception
     */
    public ApplicationOptions getApplicationOptions() throws Exception {
        Log.entering(c, "getApplicationOptions");
        if (this.applicationOptions == null) {
            retrieveDeploymentOptions();
            // If still null, the application is not yet installed
            if (this.applicationOptions == null)
                throw new Exception("Application options are null!");
        }
        Log.exiting(c, "getApplicationOptions", this.applicationOptions);
        return this.applicationOptions;
    }

    /**
     * @param module The module whose options will be retrieved.
     * @return An object containing all of the settings for the module. Changing these values does *not* modify the installed module.
     * @throws Exception
     */
    public ApplicationOptions getModuleOptions(AssetModule module) throws Exception {
        Log.entering(c, "getModuleOptions", module);
        if (this.applicationOptions == null) {
            retrieveDeploymentOptions(module);
            // If still null, the application is not yet installed
            if (this.applicationOptions == null)
                throw new Exception("Application options are null!");
        }
        Log.exiting(c, "getModuleOptions", this.applicationOptions);
        return this.applicationOptions;
    }

    /**
     * Returns a set of modules contained in the application.
     *
     * @return A set of modules.
     * @throws Exception
     */
    public Set<AssetModule> getModules() throws Exception {
        Log.entering(c, "getModules");
        if (this.modules == null) {
            List<ModuleInfo> moduleInfoList = getApplicationProvider().listModules(getScope(), this.getName(), null);
            this.modules = new HashSet<AssetModule>();
            for (ModuleInfo info : moduleInfoList) {
                AssetModule module = AssetModule.getModuleInstance(this, info.getName(), info.getUri());
                this.modules.add(module);
            }
        }
        Log.exiting(c, "getModules", this.modules);
        return this.modules;
    }

    /**
     * Get a set of all the unique scopes to which the modules of the application are deployed.
     *
     * @return A Set containing the targets to which the application is deployed.
     * @throws Exception
     */
    public Set<Scope> getDeployedTargets() throws Exception {
        final String method = "getDeployedTargets";
        Log.entering(c, method);
        Set<Scope> appTargets = new HashSet<Scope>();
        Set<AssetModule> modules = this.getModules();
        List<Scope> moduleTargets = null;
        for (AssetModule module : modules) {
            moduleTargets = module.getTargets();
            for (Scope target : moduleTargets) {
                appTargets.add(target);
            }
        }
        Log.exiting(c, method, appTargets);
        return appTargets;
    }

    /**
     * @return The ApplicationManager instance that manages this application.
     */
    public ApplicationManager getApplicationManager() {
        return this.applications;
    }

    protected WebSphereOperationsProvider getOperationsProvider() throws Exception {
        return OperationsProviderFactory.getProvider();
    }

    protected ApplicationOperationsProvider getApplicationProvider() throws Exception {
        return this.getOperationsProvider().getApplicationOperationsProvider();
    }

    protected void clearOptionsCache() {
        this.applicationOptions = null;
    }

    private void retrieveDeploymentOptions() throws Exception {
        Log.entering(c, "retrieveDeploymentOptions");
        try {
            if (isInstalled()) {
                List<ApplicationTask> tasks = getApplicationProvider().getApplicationInfo(getScope(), this.getName());
                this.applicationOptions = new ApplicationOptions(tasks, this.scope);
            }
        } catch (Exception e) {
            throw e;
        }
        Log.exiting(c, "retrieveDeploymentOptions", this.applicationOptions);
    }

    protected static List<ApplicationTask> retrieveDeploymentOptions(Cell cell, RemoteFile archive, String name) throws Exception {
        Log.entering(c, "retrieveDeploymentOptions");
        List<ApplicationTask> tasks = OperationsProviderFactory.getProvider().getApplicationOperationsProvider().getApplicationInfo(cell, archive, name);
        Log.exiting(c, "retrieveDeploymentOptions", tasks);
        return tasks;
    }

    private ApplicationOptions retrieveDeploymentOptions(AssetModule module) throws Exception {
        Log.entering(c, "retrieveDeploymentOptions", module);
        ApplicationOptions ret = null;
        try {
            if (isInstalled()) {
                List<ApplicationTask> tasks = getApplicationProvider().getModuleInfo(getScope(), this.getName(), module.getURI());
                ret = new ApplicationOptions(tasks, this.scope);
            }
        } catch (Exception e) {
            throw e;
        }
        Log.exiting(c, "retrieveDeploymentOptions", ret);
        return ret;
    }

    protected static List<ApplicationTask> retrieveDeploymentOptions(Cell cell, RemoteFile archive, String name, String moduleURI) throws Exception {
        Log.entering(c, "retrieveDeploymentOptions", new Object[] { cell, archive, name, moduleURI });
        List<ApplicationTask> tasks = OperationsProviderFactory.getProvider().getApplicationOperationsProvider().getModuleInfo(cell, name, moduleURI, archive);
        Log.exiting(c, "retrieveDeploymentOptions", tasks);
        return tasks;
    }

    private ApplicationStatus waitForState(ApplicationStatus expected, long timeout) throws Exception {
        ApplicationStatus result = ApplicationStatus.UNKNOWN;

        long end = System.currentTimeMillis() + timeout;
        while (System.currentTimeMillis() < end && result != expected) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            result = getApplicationStatus();
        }

        return result;
    }

}