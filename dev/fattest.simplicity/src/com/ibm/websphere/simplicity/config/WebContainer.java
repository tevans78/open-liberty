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
import java.util.Map;

import com.ibm.websphere.simplicity.ApplicationServer;

/**
 * Provides a concrete API for modifying web container settings in an application server's server.xml file.
 */
public class WebContainer extends ConfigObjectWrapper {
    
    private static Map<ApplicationServer, WebContainer> instances = new HashMap<ApplicationServer, WebContainer>();
    
    /**
     * Factory method for obtaining a WebContainer instance
     * @param scope The {@link ApplicationServer} who's web container will be managed
     * @return A WebContainer instance
     * @throws Exception
     */
    public static WebContainer getInstance(ApplicationServer scope) throws Exception {
        WebContainer wc = instances.get(scope);
        if(wc == null) {
            wc = new WebContainer(scope);
            instances.put(scope, wc);
        }
        return wc;
    }
    
    private SessionManager sessionManager = null;

    protected WebContainer(ApplicationServer scope) throws Exception {
        super(scope);
        setConfigObject(ConfigObject.getConfigObject(scope, scope.getConfigId(), "WebContainer"));
    }

    public void setSessionAffinityTimeout(int sessionAffinityTimeout) throws Exception {
        setAttribute("sessionAffinityTimeout", sessionAffinityTimeout);
    }
    
    public Integer getSessionAffinityTimeout() throws Exception {
        return getIntAttribute("sessionAffinityTimeout");
    }
    
    public void setDefaultVirtualHostName(String defaultVirtualHostName) throws Exception {
        setAttribute("defaultVirtualHostName", defaultVirtualHostName);
    }
    
    public String getDefaultVirtualHostName() throws Exception {
        return getStringAttribute("defaultVirtualHostName");
    }
    
    public void setEnableServletCaching(boolean enableServletCaching) throws Exception {
        setAttribute("enableServletCaching", enableServletCaching);
    }
    
    public Boolean getEnableServletCaching() throws Exception {
        return getBooleanAttribute("enableServletCaching");
    }
    
    public SessionManager getSessionManager() throws Exception {
        if(this.sessionManager == null)
            sessionManager = new SessionManager(this);
        return this.sessionManager;
    }
}
