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

import com.ibm.websphere.simplicity.application.AssetModule;
import com.ibm.websphere.simplicity.config.SessionManager.DeployedObjectConfigType;

/**
 * Provides a concrete API for modifying module settings in an application's deployment.xml file.
 */
public class ModuleDeployment extends ConfigObjectWrapper {
    
    private static Map<AssetModule, ModuleDeployment> instances = new HashMap<AssetModule, ModuleDeployment>();
    private static DeployedObjectConfigType type = DeployedObjectConfigType.WEBMODULECONFIG;
    
    private SessionManager manager = null;
    
    /**
     * A factory method for obtaining an ModuleDeployment for a particular module
     * @param module The module who's deployment configuration will be managed
     * @return A ModuleDeployment instance for the specified module
     */
    public static ModuleDeployment getInstance(AssetModule module) throws Exception {
        ModuleDeployment md = instances.get(module);
        if(md == null) {
            md = new ModuleDeployment(module);
            instances.put(module, md);
        }
        return md;
    }

    public ModuleDeployment(AssetModule module) throws Exception {
        super(module.getApplication().getScope());
        List<ConfigObject> deployments = ConfigObject.getConfigObjectList(module.getApplication().getScope(), ApplicationDeployment.getInstance(module.getApplication()).getConfigObject().getConfigIdentifier(), "ModuleDeployment");
        for(ConfigObject deployment : deployments) {
            String uri = deployment.getAttributeByName("uri").getValueAsString();
            if(module.getURI().indexOf(uri) != -1) {
                setConfigObject(deployment);
                break;
            }
        }
    }

    public void setStartingWeight(int startingWeight) throws Exception {
        setAttribute("startingWeight", startingWeight);
    }
    
    public int getStartingWeight() throws Exception {
        return getIntAttribute("startingWeight");
    }
    
    public SessionManager getSessionManager() throws Exception {
        if(this.manager == null) {
            this.manager = new SessionManager(this, type);
        }
        return manager;
    }
}
