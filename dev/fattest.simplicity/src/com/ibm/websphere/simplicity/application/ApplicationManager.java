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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.ObjectName;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.RemoteFile;
import com.ibm.websphere.simplicity.application.tasks.ApplicationTask;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.exception.ApplicationAlreadyInstalledException;
import com.ibm.websphere.simplicity.exception.ApplicationNotInstalledException;
import com.ibm.websphere.simplicity.exception.NullArgumentException;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.ObjectNameHelper;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.WebSphereOperationsProvider;

/**
 * Maintains state information for applications running on the cell,
 * and provides APIs to install and uninstall applications.
 */
public class ApplicationManager implements Configurable {

    private static Class<?> c = ApplicationManager.class;
    private static final String CHANGE_KEY_APPS = "applications";

    protected Cell scope;
    protected Set<Application> applications;

    public ApplicationManager(Cell scope) throws Exception {
        this.scope = scope;
    }

    /**
     * @param type The type of application install root you want to retrieve.
     * @return The root path to which applications of the specified type are installed.
     * @throws Exception
     */
    public String getInstallLocation(ApplicationType type) throws Exception {
        String path = scope.getConfigPath();
        switch (type) {
            case Asset:
                path += "assets";
                break;
//			case BLA:
//				path += "/blas";
//				break;
//			case Enterprise:
//				path += "applications";
//				break;
        }
        return path;
    }

    /**
     * Installing an application has a few steps, the most important of which is
     * setting the options prior to installation. The install wrapper provides
     * access to those options. When you are ready to install, call
     * ApplicationManager.install(InstallWrapper).
     * <p>
     * The app file parameter can point to any file on any machine, as long as
     * it's accessible from the local machine. Simplicity will perform the
     * necessary copy operations to install the application.
     *
     * @param appFile A pointer to the application file to install.
     * @return An InstallWrapper instance in which application options can be set.
     * @throws Exception
     */
    public InstallWrapper getInstallWrapper(RemoteFile appFile) throws Exception {
        if (!appFile.getName().endsWith(".ear"))
            throw new Exception("This API is valid only for EAR-type archives.  Please use the alternative getInstallWrapper API for other archive types.");
        return getInstallWrapper(appFile, ArchiveType.EAR);
    }

    public InstallWrapper getInstallWrapper(RemoteFile appFile, ArchiveType archiveType) throws Exception {
        if (!archiveType.equals(ArchiveType.EAR))
            appFile = getOperationsProvider().getApplicationOperationsProvider().createEarWrapper(scope, appFile, null);
        List<ApplicationTask> tasks = getOperationsProvider().getApplicationOperationsProvider().getApplicationInfo(scope, appFile, null);
        InstallWrapper ret = new InstallWrapper(appFile, tasks, scope, archiveType);
        return ret;
    }

    /**
     * @param name The name of the application.
     * @return True if the specified application is installed on the cell from which this ApplicationManager instance was obtained.
     * @throws Exception
     */
    public boolean isInstalled(String name) throws Exception {
        List<String> list = getApplicationNames();
        for (String s : list)
            if (s.equals(name))
                return true;
        return false;
    }

    /**
     * @return A list of names of applications installed on the cell from which this ApplicationManager was obtained.
     * @throws Exception
     */
    public List<String> getApplicationNames() throws Exception {
        Log.entering(c, "getList");
        List<String> result = OperationsProviderFactory.getProvider().getApplicationOperationsProvider().listApplications(scope, scope.getScopeHelper());
        Log.exiting(c, "getList", result.toArray());
        return result;
    }

    /**
     * Get the currently installed {@link Application}s
     *
     * @return A Set of {@link Application}s representing the currently
     *         installed apps
     * @throws Exception
     */
    public Set<Application> getApplications() throws Exception {
        final String method = "getApplications";
        Log.entering(c, method);
        if (this.applications == null) {
            List<String> appNames = this.getApplicationNames();
            this.applications = new HashSet<Application>();
            for (String appName : appNames) {
                // TODO Will need to update this for other application types...
                //this.addApplication(Application.create(this, ApplicationType.Enterprise, appName, this.scope));
            }
        }
        Log.exiting(c, method, this.applications);
        return new HashSet<Application>(this.applications);
    }

    /**
     * @return The ObjectName reference to the application management mbean running on this ApplicationManager instance's cell.
     * @throws Exception
     */
    public ObjectName getAppMgmtMBean() throws Exception {
        ObjectName pattern = ObjectNameHelper.getApplicationManagement(scope).toObjectName();
        ObjectName on = OperationsProviderFactory.getProvider().getMBeanOperationsProvider().queryObjectName(scope, pattern);
        if (on == null) {
            Log.finer(c, "getAppMgmtMBean", "Returning null AppManagement mbean");
        }
        return on;
    }

    /**
     * Performs all of the steps necessary to prepare, copy and install the application
     * defined by the options parameter.
     *
     * @param appName The name of the application to be installed.
     * @param options The settings for the application to be installed
     * @return An OperationResults instance for an application installation. That instance will contain a reference to the newly installed app.
     * @throws Exception
     */
    public OperationResults<Application> install(String appName, InstallWrapper options) throws Exception {
        options.getAppDeploymentOptions().setApplicationName(appName);
        return install(options);
    }

    /**
     * Get an {@link Application} that has the specified name
     *
     * @param name
     *                 The name of the application to get
     * @return The {@link Application} with the specified name or null if no
     *         application with that name exists
     * @throws Exception
     */
    public Application getApplicationByName(String name) throws Exception {
        final String method = "getApplicationByName";
        Log.entering(c, method, name);
        Set<Application> apps = this.getApplications();
        for (Application app : apps) {
            if (app.getName().equalsIgnoreCase(name)) {
                Log.exiting(c, method, app);
                return app;
            }
        }
        return null;
    }

    /**
     * Performs all of the steps necessary to prepare, copy and install the application
     * defined by the options parameter.
     *
     * @param options The settings for the application to be installed
     * @return An OperationResults instance for an application installation. That instance will contain a reference to the newly installed app.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public OperationResults<Application> install(InstallWrapper options) throws Exception {
        Log.entering(c, "install", options);
        if (options == null)
            throw new NullArgumentException("options");

        final String appName = options.getAppDeploymentOptions().getApplicationName();

        if (isInstalled(appName))
            throw new ApplicationAlreadyInstalledException(appName);

        ensureMinimumInstallOptions(appName, options);

        scope.getWorkspace().registerConfigChange(this, CHANGE_KEY_APPS, getApplications());

        final Cell fcell = this.scope;
        final RemoteFile fearFile = options.getEarFile();
        final InstallWrapper fwrapper = options;
        Log.finer(c, "install", "Performing installation", options.toTaskString());
        OperationResults<Application> results = OperationsProviderFactory.getProvider().getApplicationOperationsProvider().installApplication(fcell, appName, fearFile, fwrapper,
                                                                                                                                              fcell.getActiveSession());

//        Application app = null;
//        if (results.isSuccess()) {
//            app = Application.create(this, ApplicationType.Enterprise, appName, this.scope);
//            results.setResult(app);
//            this.addApplication(app);
//        }
        Log.exiting(c, "install", results.isSuccess());
        return results;
    }

    /**
     * Add an Application to the internal Set
     *
     * @param app
     *                The Application to add
     */
    protected void addApplication(Application app) {
        if (this.applications == null) {
            this.applications = new HashSet<Application>();
        }
        this.applications.add(app);
    }

    /**
     * Performs the steps necessary to uninstall an application from the cell.
     *
     * @param appName The name of the application to uninstall.
     * @return An OperationResults instance containing information about the uninstall, including whether it was successful.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public OperationResults<Boolean> uninstall(String appName) throws Exception {
        final String method = "uninstall";
        Log.entering(c, method, appName);

        if (!isInstalled(appName)) {
            throw new ApplicationNotInstalledException(appName);
        }

        scope.getWorkspace().registerConfigChange(this, CHANGE_KEY_APPS, getApplications());

        final Cell fcell = this.scope;
        final String fappName = appName;
        OperationResults<Boolean> results = OperationsProviderFactory.getProvider().getApplicationOperationsProvider().uninstallApplication(fcell, fappName,
                                                                                                                                            fcell.getActiveSession());

        results.setResult(results.isSuccess());
        this.removeApplication(this.getApplicationByName(appName));

        Log.exiting(c, method, results.isSuccess());
        return results;
    }

    /**
     * Remove an Application from the internal Set
     *
     * @param app
     *                The Application to remove
     * @throws Exception
     */
    protected void removeApplication(Application app) throws Exception {
        if (this.applications != null && app != null) {
            this.applications.remove(app);
        }
    }

    protected WebSphereOperationsProvider getOperationsProvider() throws Exception {
        return OperationsProviderFactory.getProvider();
    }

    private void ensureMinimumInstallOptions(String appName, InstallWrapper options) throws Exception {
        if (appName == null)
            throw new Exception("You must provide an application name for installation.");
        if (options.getEarFile() == null)
            throw new Exception("You must specify a location for the archive to be installed.");
    }

    /**
     * For internal use only.
     */
    @Override
    public void commit(HashMap<String, Object> values) throws Exception {
    }

    /**
     * For internal use only.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.equals(CHANGE_KEY_APPS)) {
                this.applications = (Set) value;
            }
        }
    }

}
