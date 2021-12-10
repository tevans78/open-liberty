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

import java.util.List;


/**
 * Provides a concrete API for modifying session manager settings in an application's deployment.xml file or server's server.xml file
 */
public class SessionManager extends ConfigObjectWrapper {
    
    public enum DeployedObjectConfigType {

        APPLICATIONCONFIG("ApplicationConfig"),
        WEBMODULECONFIG("WebModuleConfig");
        
        private String type;
        
        private DeployedObjectConfigType(String type) {
            this.type = type;
        }
        
        public String getType() {
            return this.type;
        }
    }

    
    private TuningParams tuningParams = null;
    private CookieSettings cookieSettings = null;
    
    /**
     * Constructor for applications and application modules
     * @param parent The parent application or module
     * @param type The type of parent
     * @throws Exception
     */
    protected SessionManager(ConfigObjectWrapper parent, DeployedObjectConfigType type) throws Exception {
        super(parent.getScope());
        ConfigObject config = ConfigObject.getConfigObject(parent.getScope(), parent.getConfigObject().getConfigIdentifier(), type.getType());
        if(config == null) {
            config = ConfigObject.createConfigObject(parent.getScope(), type.getType(), parent.getConfigObject());
            ConfigObject sessionManager = ConfigObject.createConfigObject(parent.getScope(), "SessionManager", config);
            List<ConfigObject> atts = sessionManager.getAttributes();
            for(ConfigObject att : atts) {
                att.setValue(att.getMetadata().getDefaultValue());
            }
            ConfigObject tuningParams = ConfigObject.createConfigObject(parent.getScope(), "TuningParams", sessionManager);
            atts = tuningParams.getAttributes();
            for(ConfigObject att : atts) {
                att.setValue(att.getMetadata().getDefaultValue());
            }
            ConfigObject cookieSettings = ConfigObject.createConfigObject(parent.getScope(), "Cookie", sessionManager);
            atts = cookieSettings.getAttributes();
            for(ConfigObject att : atts) {
                att.setValue(att.getMetadata().getDefaultValue());
            }
            setConfigObject(sessionManager);
        } else {
            setConfigObject(ConfigObject.getConfigObject(parent.getScope(), config.getConfigIdentifier(), "SessionManager"));
        }
    }
    
    protected SessionManager(WebContainer parent) throws Exception {
        super(parent.getScope());
        setConfigObject(ConfigObject.getConfigObject(parent.getScope(), parent.getConfigObject().getConfigIdentifier(), "SessionManager"));
    }
    
    public void setEnable(boolean enable) throws Exception {
        setAttribute("enable", enable);
    }
    
    public boolean getEnable() throws Exception {
        return getBooleanAttribute("enable");
    }
    
    public void setenableUrlRewriting(boolean enableUrlRewriting) throws Exception {
        setAttribute("enableUrlRewriting", enableUrlRewriting);
    }
    
    public boolean getEnableUrlRewriting() throws Exception {
        return getBooleanAttribute("enableUrlRewriting");
    }
    
    public void setEnableCookies(boolean enableCookies) throws Exception {
        setAttribute("enableCookies", enableCookies);
    }
    
    public boolean getEnableCookies() throws Exception {
        return getBooleanAttribute("enableCookies");
    }
    
    public void setEnableSSLTracking(boolean enableSSLTracking) throws Exception {
        setAttribute("enableSSLTracking", enableSSLTracking);
    }
    
    public boolean getEnableSSLTracking() throws Exception {
        return getBooleanAttribute("enableSSLTracking");
    }
    
    public void setEnableProtocolSwitchRewriting(boolean enableProtocolSwitchRewriting) throws Exception {
        setAttribute("enableProtocolSwitchRewriting", enableProtocolSwitchRewriting);
    }
    
    public boolean getEnableProtocolSwitchRewriting() throws Exception {
        return getBooleanAttribute("enableProtocolSwitchRewriting");
    }
    
    public void setSessionPersistenceMode(SessionPersistenceMode sessionPersistenceMode) throws Exception {
        setAttribute("sessionPersistenceMode", sessionPersistenceMode.toString().toLowerCase());
    }
    
    public String getSessionPersistenceMode() throws Exception {
        return getStringAttribute("sessionPersistenceMode");
    }
    
    public void setEnableSecurityIntegration(boolean enableSecurityIntegration) throws Exception {
        setAttribute("enableSecurityIntegration", enableSecurityIntegration);
    }
    
    public boolean getEnableSecurityIntegration() throws Exception {
        return getBooleanAttribute("enableSecurityIntegration");
    }
    
    public void setAllowSerializedSessionAccess(boolean allowSerializedSessionAccess) throws Exception {
        setAttribute("allowSerializedSessionAccess", allowSerializedSessionAccess);
    }
    
    public boolean getAllowSerializedSessionAccess() throws Exception {
        return getBooleanAttribute("allowSerializedSessionAccess");
    }
    
    /**
     * Get the {@link TuningParams} instance for this SessionManager
     * @return The {@link TuningParams} instance
     * @throws Exception
     */
    public TuningParams getTuningParams() throws Exception {
        if(this.tuningParams == null) {
            this.tuningParams = new TuningParams(this);
        }
        return this.tuningParams;
    }
    
    /**
     * Get the {@link CookieSettings} instance for this SessionManager
     * @return The {@link CookieSettings} instance
     * @throws Exception
     */
    public CookieSettings getCookieSettings() throws Exception {
        if(this.cookieSettings == null) {
            this.cookieSettings = new CookieSettings(this);
        }
        return this.cookieSettings;
    }
    
    public enum SessionPersistenceMode {
        NONE,
        DATABASE;
    }
    
    /**
     * Provides a concrete API for modifying tuning parameter settings in an application's deployment.xml file or server's server.xml
     */
    public class TuningParams extends ConfigObjectWrapper {

        protected TuningParams(SessionManager parent) throws Exception {
            super(parent.getConfigObject().getScope());
            setConfigObject(parent.getConfigObject().getChildObjectsByDataType("TuningParams").get(0));
        }
        
        public void setMaxInMemorySessionCount(int maxInMemorySessionCount) throws Exception {
            setAttribute("maxInMemorySessionCount", maxInMemorySessionCount);
        }
        
        public int getMaxInMemorySessionCount() throws Exception {
            return getIntAttribute("maxInMemorySessionCount");
        }
        
        public void setAllowOverflow(boolean allowOverflow) throws Exception {
            setAttribute("allowOverflow", allowOverflow);
        }
        
        public boolean getAllowOverflow() throws Exception {
            return getBooleanAttribute("allowOverflow");
        }
        
        public void setInvalidationTimeout(int invalidationTimeout) throws Exception {
            setAttribute("invalidationTimeout", invalidationTimeout);
        }
        
        public int getInvalidationTimeout() throws Exception {
            return getIntAttribute("invalidationTimeout");
        }
    }

    /**
     * Provides a concrete API for modifying cookie settings in an application's deployment.xml file or server's server.xml file
     */
    public class CookieSettings extends ConfigObjectWrapper {
        
        protected CookieSettings(SessionManager parent) throws Exception {
            super(parent.getConfigObject().getScope());
            setConfigObject(parent.getConfigObject().getChildObjectsByDataType("Cookie").get(0));
        }
        
        public void setMaximumAge(int maximumAge) throws Exception {
            setAttribute("maximumAge", maximumAge);
        }
        
        public Integer getMaximumAge() throws Exception {
            return getIntAttribute("maximumAge");
        }
        
        public void setName(String name) throws Exception {
            setAttribute("name", name);
        }
        
        public String getName() throws Exception {
            return getStringAttribute("name");
        }
        
        public void setDomain(String domain) throws Exception {
            setAttribute("domain", domain);
        }
        
        public String getDomain() throws Exception {
            return getStringAttribute("domain");
        }
        
        public void setPath(String path) throws Exception {
            setAttribute("path", path);
        }
        
        public String getPath() throws Exception {
            return getStringAttribute("path");
        }
        
        public void setSecure(boolean secure) throws Exception {
            setAttribute("secure", secure);
        }
        
        public Boolean getSecure() throws Exception {
            return getBooleanAttribute("secure");
        }
    }
}
