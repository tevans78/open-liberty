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

package com.ibm.websphere.simplicity.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.application.Application;
import com.ibm.websphere.simplicity.application.types.AsyncRequestDispatchType;
import com.ibm.websphere.simplicity.config.SessionManager.DeployedObjectConfigType;

/**
 * Provides a concrete API for modifying application settings in an application's deployment.xml file.
 */
public class ApplicationDeployment extends ConfigObjectWrapper {

    private static Map<Application, ApplicationDeployment> instances = new HashMap<Application, ApplicationDeployment>();
    private static final DeployedObjectConfigType type = DeployedObjectConfigType.APPLICATIONCONFIG;
    
    private SessionManager sessionManager = null;
    
    /**
     * A factory method for obtaining an ApplicationDeployment for a particular application
     * @param application The application who's deployment configuration will be managed
     * @return An ApplicationDeployment instance for the specified application
     */
    public static ApplicationDeployment getInstance(Application application) throws Exception {
        ApplicationDeployment appDep = instances.get(application);
        if(appDep == null) {
            appDep = new ApplicationDeployment(application);
            instances.put(application, appDep);
        }
        return appDep;
    }
    
    private ApplicationDeployment(Application app) throws Exception {
        super(app.getScope());
        ConfigIdentifier configId = null;
        List<ConfigObject> deployments = ConfigObject.getConfigObjectList(app.getScope(), "ApplicationDeployment");
        for(ConfigObject deployment : deployments) {
            ConfigIdentifier temp = deployment.getConfigIdentifier();
            if(temp.toString().indexOf(app.getName() + "|deployment.xml") != -1) {
                configId = temp;
                setConfigObject(deployment);
                break;
            }
        }
        if(configId == null) 
            throw new IllegalArgumentException("An application with name " + app.getName() + " is not installed.");
    }
    
    public void setStartingWeight(int startingWeight) throws Exception {
        setAttribute("startingWeight", startingWeight);
    }
    
    public int getStaringWeight() throws Exception {
        return getIntAttribute("startingWeight");
    }
    
    public void setBinariesURL(String url) throws Exception {
        setAttribute("binariesURL", url);
    }
    
    public String getBinariesURL() throws Exception {
        return getStringAttribute("binariesURL");
    }
    
    public void setUseMetadataFromBinaries(boolean useMetadataFromBinaries) throws Exception {
        setAttribute("useMetadataFromBinaries", useMetadataFromBinaries);
    }
    
    public boolean getUseMetadateFromBinaries() throws Exception {
        return getBooleanAttribute("useMetadataFromBinaries");
    }
    
    public void setEnableDistribution(boolean enable) throws Exception {
        setAttribute("enableDistribution", enable);
    }
    
    public boolean getEnableDistribution() throws Exception {
        return getBooleanAttribute("enableDistribution");
    }
    
    public void setCreateMBeansForResources(boolean createMBeansForResources) throws Exception {
        setAttribute("createMBeansForResources", createMBeansForResources);
    }
    
    public boolean getCreateMBeansForResources() throws Exception {
        return getBooleanAttribute("createMBeansForResources");
    }
    
    public void setReloadEnabled(boolean reloadEnabled) throws Exception {
        setAttribute("reloadEnabled", reloadEnabled);
    }
    
    public boolean getreloadEnabled() throws Exception {
        return getBooleanAttribute("reloadEnabled");
    }
    
    public void setAppContextIDForSecurity(String appContextIDForSecurity) throws Exception {
        setAttribute("appContextIDForSecurity", appContextIDForSecurity);
    }
    
    public String getAppContextIDForSecurity() throws Exception {
        return getStringAttribute("appContextIDForSecurity");
    }
    
    public void setfilePermission(String filePermission) throws Exception {
        setAttribute("filePermission", filePermission);
    }
    
    public String getfilePermission() throws Exception {
        return getStringAttribute("filePermission");
    }
    
    public void setAllowDispatchRemoteInclude(boolean allowDispatchRemoteInclude) throws Exception {
        setAttribute("allowDispatchRemoteInclude", allowDispatchRemoteInclude);
    }
    
    public boolean getAllowDispatchRemoteInclude() throws Exception {
        return getBooleanAttribute("allowDispatchRemoteInclude");
    }
    
    public void setAllowServiceRemoteInclude(boolean allowServiceRemoteInclude) throws Exception {
        setAttribute("allowServiceRemoteInclude", allowServiceRemoteInclude);
    }
    
    public boolean getAllowServiceRemoteInclude() throws Exception {
        return getBooleanAttribute("allowServiceRemoteInclude");
    }
    
    public void setAsyncRequestDispatchType(AsyncRequestDispatchType asyncRequestDispatchType) throws Exception {
        setAttribute("asyncRequestDispatchType", asyncRequestDispatchType.getValue());
    }
    
    public String getAsyncRequestDispatchType() throws Exception {
        return getStringAttribute("asyncRequestDispatchType");
    }
    
    /**
     * Get the {@link SessionManager} Object to manage session manager attributes
     * @return A {@link SessionManager} instance
     * @throws Exception
     */
    public SessionManager getSessionManager() throws Exception {
        if(this.sessionManager == null) {
            this.sessionManager = new SessionManager(this, type);
        }
        return this.sessionManager;
    }
}
