/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.provider.websphere;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.Cluster;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.RemoteFile;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.ScopeHelper;
import com.ibm.websphere.simplicity.Server;
import com.ibm.websphere.simplicity.WebServer;
import com.ibm.websphere.simplicity.application.Application;
import com.ibm.websphere.simplicity.application.AssetModule;
import com.ibm.websphere.simplicity.application.EditWrapper;
import com.ibm.websphere.simplicity.application.InstallWrapper;
import com.ibm.websphere.simplicity.application.ModuleInfo;
import com.ibm.websphere.simplicity.application.UpdateWrapper;
import com.ibm.websphere.simplicity.application.tasks.ApplicationTask;
import com.ibm.websphere.simplicity.cluster.ClusterType;
import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;

public abstract class ApplicationOperationsProvider extends CategorizedOperationsBase {

    public ApplicationOperationsProvider(WebSphereOperationsProvider parent) {
		super(parent);
	}
    
    /**
     * Scans the configuration repository to determine whether an application
     * is installed at a certain scope.  Installed applications will appear in
     * the serverindex.xml file under the servers to which it has been deployed.
     * The AppManagement MBean will do this scan server-side, or it can be done
     * client-side via the ConfigObject API.
     * @param key The WebSphere scope to scan for app existence.
     * @param name The name of the application to look for.
     * @param session
     * @return True if the application is deployed to the provided WebSphere scope.
     * @throws Exception
     */
	public abstract boolean checkIfAppExists(Scope key, String name, AbstractSession session) throws Exception;
	
	/**
	 * Zips up the deployed application folder, and stores the resulting zip
	 * file in a specified location on the server.  The specified location is
	 * relative to the node being targeted, and has only one caveat: in an
	 * Admin Agent topology, the exported application will reside under the 
	 * Admin Agent's install root, not the server to which the application was
	 * installed.
	 * <p>
	 * The original application is not affected by an export operation.
	 * @param key The WebSphere scope from which to export the application.
	 * @param name The application to export.
	 * @param targetPath The relative path to store the zip file.
	 * @param options (?)
	 * @return results of the operation
	 * @throws Exception
	 */
	public abstract OperationResults<Boolean> exportApplication(Scope key, String name, String targetPath, Hashtable options) throws Exception;
	
	/**
	 * Retrieves all of the information collected by WebSphere during the
	 * installation process.  This includes such information as Java version,
	 * module-to-server mappings, servlet settings, data sources, and so on.
	 * @param key The WebSphere scope in which to scan for the application.
	 * @param name The name of the application whose information will be retrieved.
	 * @return A list of objects containing application deployment data.
	 * @throws Exception
	 */
    public abstract List<ApplicationTask> getApplicationInfo(Scope key, String name) throws Exception;
    
	/**
	 * Retrieves all of the information collected by WebSphere during the
	 * installation process.  This includes such information as Java version,
	 * module-to-server mappings, servlet settings, data sources, and so on.
	 * @param key The WebSphere cell in which to scan for the application.
	 * @param archive The ear file to get the application info for
	 * @param name The application name
	 * @return A list of objects containing application deployment data.
	 * @throws Exception
	 */
    public abstract List<ApplicationTask> getApplicationInfo(Cell key, RemoteFile archive, String name) throws Exception;
    
    /**
	 * Retrieves all of the deployment information for the specified module
	 * for the installation process.  This includes such information as Java 
	 * version, module-to-server mappings, servlet settings, data sources, 
	 * and so on.
	 * @param key The WebSphere scope in which to scan for the application.
	 * @param name The name of the application whose information will be retrieved.
     * @param moduleURI The URI of the module file within the app
     * @return A list of objects containing module deployment data.
     * @throws Exception
     */
    public abstract List<ApplicationTask> getModuleInfo(Scope key, String name, String moduleURI) throws Exception;
    /**
	 * Retrieves all of the deployment information for the specified module
	 * for the installation process.  This includes such information as Java 
	 * version, module-to-server mappings, servlet settings, data sources, 
	 * and so on.
	 * @param key The WebSphere scope in which to scan for the application.
	 * @param name The name of the application whose information will be retrieved.
     * @param moduleURI The URI of the module file within the app
     * @param archive The war file to get the application info for
     * @return A list of objects containing module deployment data.
     * @throws Exception
     */
    public abstract List<ApplicationTask> getModuleInfo(Cell key, String name, String moduleURI, RemoteFile archive) throws Exception;
    /**
     * Installs the application from the specified location in pathToArchive to
     * WebSphere servers using the supplied deployment options.
     * 
     * @param key The WebSphere cell in which to install the application.
     * @param appName The application name
     * @param earFile The ear file to install
     * @param options
     * @param session
     * @return An instance of OperationResults indicating success or failure.
     * @throws Exception
     */
    public abstract OperationResults installApplication(Cell key, String appName, RemoteFile earFile, InstallWrapper options, AbstractSession session) throws Exception;

    /**
     * Validates the application options so far as they're currently set.
     * 
     * @param key The WebSphere cell in which to install the application.
     * @param appName The application name
     * @param earFile The ear file to install
     * @param options
     * @param session
     * @return An instance of OperationResults indicating success or failure.
     * @throws Exception
     */
    public abstract OperationResults validateApplication(Cell key, RemoteFile earFile, InstallWrapper options, AbstractSession session) throws Exception;

    /**
     * Validates the application options so far as they're currently set.
     * 
     * @param key The WebSphere cell in which to install the application.
     * @param appName The application name
     * @param earFile The ear file to install
     * @param options
     * @param session
     * @return An instance of OperationResults indicating success or failure.
     * @throws Exception
     */
    public abstract OperationResults validateApplication(Cell key, RemoteFile earFile, UpdateWrapper options, AbstractSession session) throws Exception;

    /**
     * Retrieves a list of names of applications that have been installed to the
     * specified WebSphere scope.  (Note: this could be incorrect, and instead
     * return a list of all applications installed to the entire cell.)
     * <p>
     * <b>AppOpProvider docs need correction.</b>
     * @param key The WebSphere scope in which to scan for the applications.
     * @param scope
     * @return A list of names of installed application.
     * @throws Exception
     */
    public abstract List<String> listApplications(Scope key, ScopeHelper scope) throws Exception;
    
    /**
     * Obtains a list of the modules that comprise the target application.
     * @param key
     * @param name
     * @param session
     * @return A list of the modules that comprise the target application
     * @throws Exception
     */
    public abstract List<ModuleInfo> listModules(Scope key, String name, AbstractSession session) throws Exception;
    
    /**
     * Attempts to start an application on all the targets of the app
     * @param app
     * @return The results of the operation
     * @throws Exception
     */
    public OperationResults startApplication(Application app) throws Exception {
        return startStopApplication(app, true);
    }
    
    public OperationResults stopApplication(Application app) throws Exception {
        return startStopApplication(app, false);
    }
    
    public OperationResults startStopApplication(Application app, boolean start) throws Exception {
        Set<AssetModule> modules = app.getModules();
        List<Scope> currentTargets = null;
        Set<Scope> targets = new HashSet<Scope>();
        OperationResults cumulative = new OperationResults();
        cumulative.setSuccess(true);
        OperationResults current = null;
        // find all the targets; don't duplicate; not sure if .equals works on our Scopes so I'll use a String as a key into a Map
        for(AssetModule module : modules) {
            currentTargets = module.getTargets();
            targets.addAll(currentTargets);
        }
        for(Scope scope : targets) {
            current = startStopApplication(scope, app.getName(), start);
            // update cumulative result
            if(!current.isSuccess()) {
                cumulative.setSuccess(false);
            }
            if(current.getNotifications() != null) {
                cumulative.addNotifications(current.getNotifications());
            }
            if(current.getSystemOut() != null) {
                if(cumulative.getSystemOut() == null) {
                    cumulative.setSystemOut(current.getSystemOut());
                } else {
                    cumulative.setSystemOut(cumulative.getSystemOut() + System.getProperty("line.separator") + current.getSystemOut());
                }
            }
            if(current.getSystemErr() != null) {
                if(cumulative.getSystemErr() == null) {
                    cumulative.setSystemErr(current.getSystemErr());
                } else {
                    cumulative.setSystemErr(cumulative.getSystemErr() + System.getProperty("line.separator") + current.getSystemErr());
                }
            }
        }
        return cumulative;
    }
    
    public OperationResults startStopApplication(Scope scope, String appName, boolean start) throws Exception {
        Map<String, Scope> targetMap = new HashMap<String, Scope>();
        OperationResults cumulative = new OperationResults();
        cumulative.setSuccess(true);
        OperationResults current = null;
        String key = null;
        if(scope instanceof ApplicationServer) {
            key = ((ApplicationServer)scope).getMappingName();
            if(targetMap.get(key) == null) {
                targetMap.put(key, scope);
            }
        } else if(scope instanceof WebServer) {
            // do nothing
        } else if(scope instanceof Cluster && ((Cluster)scope).getType() == ClusterType.APPLICATION_SERVER){
            Set<Server> servers = ((Cluster)scope).getMembers();
            for(Server server : servers) {
                key = ((ApplicationServer)server).getMappingName();
                scope = server;
                if(targetMap.get(key) == null) {
                    targetMap.put(key, scope);
                }
            }
        } else {
            throw new Exception("Invalide Scope. Valid Scopes are ApplicationServer and Application Server Clusters.");
        }
                
        Server target;
        for(String mapping : targetMap.keySet()) {
            target = (Server)targetMap.get(mapping);
            if(start) {
                current = startApplication(target, appName);
            } else {
                current = stopApplication(target, appName);
            }
            // update cumulative result
            if(!current.isSuccess()) {
                cumulative.setSuccess(false);
            }
            if(current.getNotifications() != null) {
                cumulative.addNotifications(current.getNotifications());
            }
            if(current.getSystemOut() != null) {
                if(cumulative.getSystemOut() == null) {
                    cumulative.setSystemOut(current.getSystemOut());
                } else {
                    cumulative.setSystemOut(cumulative.getSystemOut() + System.getProperty("line.separator") + current.getSystemOut());
                }
            }
            if(current.getSystemErr() != null) {
                if(cumulative.getSystemErr() == null) {
                    cumulative.setSystemErr(current.getSystemErr());
                } else {
                    cumulative.setSystemErr(cumulative.getSystemErr() + System.getProperty("line.separator") + current.getSystemErr());
                }
            }
        }
        
        return cumulative;
    }
    
    /**
     * Attempts to start the application on the specified targets.
     * @param key
     * @param appName
     * @return TODO
     * @throws Exception
     */
    public abstract OperationResults startApplication(Server key, String appName) throws Exception;
    
    /**
     * Attempts to stop the application on all of the specified server targets.
     * @param key
     * @param appName
     * @return TODO
     * @throws Exception
     */
    public abstract OperationResults stopApplication(Server key, String appName) throws Exception;
    
    /**
     * Installs the application from the specified location in pathToArchive to
     * WebSphere servers using the supplied deployment options.
	 * @param key Any scope in the WebSphere cell in which to install the application.
     * @param appName The application to uninstall.
     * @return An instance of OperationResults indicating success or failure.
     * @throws Exception
     */
    public abstract OperationResults uninstallApplication(Scope key, String appName, AbstractSession session) throws Exception;
    
    /**
     * TODO
     * @param key
     * @param name
     * @param options
     * @param session
     * @return TODO
     * @throws Exception
     */
    public abstract OperationResults updateApplication(Cell key, String name, UpdateWrapper options, AbstractSession session) throws Exception;
    
    /**
     * Tests to see if the application has been distributed and is ready to be run.
     * 
     * @param key The Scope that provides context for the operation
     * @param ignoreUnknownState If true, any node or server with unknown state is not included in the final ready return
     * @param appName The name of the application to check
     * @param session
     * @return true if the application is ready; false otherwise.
     * @throws Exception
     */
    public abstract boolean isAppReady(Scope key, boolean ignoreUnknownState, String appName, AbstractSession session) throws Exception;
    
    /**
     * Saves the new application or module options to the WAS repository.
     * @param key The cell in which the application or module is installed.
     * @param name The name of the application to update.
     * @param options The new options to be committed.
     * @param session The session in which to temporarily store the values.
     * @return An OperationResults instance indicating success or failure.
     * @throws Exception
     */
    public abstract OperationResults editApplication(Cell key, String name, EditWrapper options, AbstractSession session) throws Exception;

    /**
     * Takes a non-ear module (war, sar, rar, etc) and creates an ear file with
     * that module inside.  This implementation is for non-war files since it
     * lacks the contextRoot parameter.
     * @param key The cell in which the target application is installed.
     * @param appFile The module file to be wrapped in an ear.
     * @param contentUri The target URI of the module in the installed application.
     * @return A RemoteFile pointing to the newly created ear file.
     * @throws Exception
     */
    public abstract RemoteFile createEarWrapper(Cell key, RemoteFile appFile, String contentUri) throws Exception;

    /**
     * Takes a non-ear module (war, sar, rar, etc) and creates an ear file with
     * that module inside.  This implementation is for war files specifically.
     * @param key The cell in which the target application is installed.
     * @param appFile The module file to be wrapped in an ear.
     * @param contentUri The target URI of the module in the installed application.
     * @param contextRoot The context root for the web module.
     * @return A RemoteFile pointing to the newly created ear file.
     * @throws Exception
     */
    public abstract RemoteFile createEarWrapper(Cell key, RemoteFile appFile, String contentUri, String contextRoot) throws Exception;
    
    /**
     * Returns the contents of the deployment descriptor for the application or
     * module.  WebSphere performs any merging necessary for partial DDs.
     * @param key The cell in which the application is installed.
     * @param applicationName The name of the application.
     * @param ddPath The path to a deployment descriptor (application or module).
     * @param moduleName Optional. The name of the module whose DD will be returned. If this is null, the application's DD will be returned.
     * @return The deployment descriptor as a string.
     * @throws Exception
     */
    public abstract String getDeploymentDescriptor(Cell key, String applicationName, String ddPath, String moduleName) throws Exception;

}
