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

package com.ibm.websphere.simplicity.config.securitydomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;

/**
 * Each entry in the login configuration must contain at least one login module. However, you can
 * define more than one login module for a login configuration. If you define more than one login
 * module for a login configuration, they are processed in the order that they are defined.
 */
public class JAASLoginModule implements Configurable {
	
	private static final String CHANGE_KEY_CUSTOM = "customProps";
	private static final String CHANGE_KEY_AUTH_STRATEGY = "authStrategy";
	private static final String CHANGE_KEY_CONFIG_OBJ = "configObj";
    
    private String moduleClassName;
    private AuthenticationStrategy authStrategy;
    private Map<String, String> customProps;
    protected ConfigObject configObj;
    private JAASLogin parent;
    protected static final String DELEGATE = "delegate";
    
    /**
     * Constructor
     * 
     * @param configObj {@link ConfigObject} representation of this module
     * @param parent {@link JAASLogin} parent
     */
    protected JAASLoginModule(ConfigObject configObj, JAASLogin parent) {
        this.configObj = configObj;
        this.parent = parent;
    }
    
    /**
     * Get the class name of the given login module.
     * 
     * @return The class name of the given login module.
     * @throws Exception
     */
    public String getModuleClassName() throws Exception {
        if(this.moduleClassName == null) {
            if(getProperties().get(DELEGATE) != null) {
                this.moduleClassName = getProperties().get(DELEGATE);
            } else {
                this.moduleClassName = this.configObj.getAttributeByName("moduleClassName").getValueAsString();
            }
        }
        return this.moduleClassName;
    }

    /**
     * Get the {@link AuthenticationStrategy}. A Java Authentication and Authorization Service
     * (JAAS) authentication provider supplies the authentication strategy. In JAAS, an
     * authentication strategy is implemented through the LoginModule interfac
     * 
     * @return The authentication strategy for the module
     * @throws Exception
     */
    public AuthenticationStrategy getAuthenticationStrategy() throws Exception {
        if(this.authStrategy == null) {
            this.authStrategy = AuthenticationStrategy.valueOf(this.configObj.getAttributeByName("authenticationStrategy").getValueAsString());
        }
        return this.authStrategy;
    }
    
    /**
     * Set the {@link AuthenticationStrategy}. A Java Authentication and Authorization Service
     * (JAAS) authentication provider supplies the authentication strategy. In JAAS, an
     * authentication strategy is implemented through the LoginModule interfac
     * 
     * @param strategy The strategy to use
     * @throws Exception
     */
    public void setAuthenticationStrategy(AuthenticationStrategy strategy) throws Exception {
        this.parent.getJAASLogins().getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_AUTH_STRATEGY, getAuthenticationStrategy());

        LoginModuleSettings options = new LoginModuleSettings();
        options.setLoginModule(getModuleClassName());
        options.setAuthStrategy(strategy);
        parent.configureJAASLoginModule(options);
        this.authStrategy = strategy;
    }
    
    /**
     * Get the properties of the login module
     * 
     * @return The properties of the module
     * @throws Exception
     */
    protected Map<String, String> getProperties() throws Exception {
        if(this.customProps == null) {
            this.customProps = new HashMap<String, String>();
            ArrayList<ConfigObject> props = this.configObj.getChildObjectsByDataType("Property");
            for(ConfigObject prop : props) {
                this.customProps.put(prop.getAttributeByName("name").getValueAsString(), prop.getAttributeByName("value").getValueAsString());
            }
        }
        return this.customProps;
    }
    
    /**
     * Get the custom properties for the login module. 
     * 
     * @return A Map of custom properties
     * @throws Exception
     */
    public Map<String, String> getCustomProperties() throws Exception {
        Map<String, String> customProperties = new HashMap<String, String>();
        Map<String, String> properties = getProperties();
        for(String property : properties.keySet()) {
            if(!property.equals(DELEGATE)) {
                customProperties.put(property, properties.get(property));
            }
        }
        return customProperties;
    }
    
    /**
     * Set custom properties for the login module. Use a null value to remove a property. Existing
     * properties not in the input map will not be affected.
     * 
     * @param customProperties The custom properties to set.
     * @throws Exception
     */
    public void setCustomProperties(Map<String, String> customProperties) throws Exception {
        this.parent.getJAASLogins().getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM, getProperties());

        LoginModuleSettings options = new LoginModuleSettings();
        options.setCustomProps(customProperties);
        options.setLoginModule(getModuleClassName());
        parent.configureJAASLoginModule(options);
        getProperties().putAll(customProperties);
    }
    
    /**
     * Set a custom property
     * 
     * @param property The property name
     * @param value The property value
     * @throws Exception
     */
    public void setCustomProperty(String property, String value) throws Exception {
        this.parent.getJAASLogins().getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM, getProperties());

        Map<String, String> props = new HashMap<String, String>();
        props.put(property, value);
        LoginModuleSettings options = new LoginModuleSettings();
        options.setCustomProps(props);
        options.setLoginModule(getModuleClassName());
        parent.configureJAASLoginModule(options);
        getProperties().put(property, value);
    }
    
    /**
     * Remove a custom property
     * 
     * @param property The name of the property to remove
     * @throws Exception
     */
    public void removeCustomProperty(String property) throws Exception {
        if(getProperties().get(property) == null) {
            throw new Exception("No property with name " + property + " exists.");
        }

        this.parent.getJAASLogins().getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM, getProperties());

        Map<String, String> props = new HashMap<String, String>();
        props.put(property, null);
        LoginModuleSettings options = new LoginModuleSettings();
        options.setCustomProps(props);
        options.setLoginModule(getModuleClassName());
        parent.configureJAASLoginModule(options);
        getProperties().remove(property);
    }
    
    /**
     * Returns true if a login module proxy is being used. If true, the Java Authentication and
     * Authorization Service (JAAS) loads the login module proxy class. JAAS then delegates calls to
     * the login module classes that are defined in the Module class name field.
     * 
     * @return true if a login module proxy is being used.
     * @throws Exception
     */
    public boolean usingLoginModuleProxy() throws Exception {
        return getProperties().get(DELEGATE) != null;
    }
    
    /**
     * Set whether or not a login module proxy should be used. If true, the Java Authentication and
     * Authorization Service (JAAS) loads the login module proxy class. JAAS then delegates calls to
     * the login module classes that are defined in the Module class name field.
     * 
     * @param useLoginModuleProxy true to use a login module proxy
     * @throws Exception
     */
    public void setUseLoginModuleProxy(boolean useLoginModuleProxy) throws Exception {
        // reflected through a custom property
        this.parent.getJAASLogins().getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM, getProperties());

        LoginModuleSettings options = new LoginModuleSettings();
        options.setUseLoginModuleProxy(useLoginModuleProxy);
        options.setLoginModule(getModuleClassName());
        parent.configureJAASLoginModule(options);
        if(useLoginModuleProxy && getJAASLogin().getJAASLogins().getSecurityDomain().isAtLeast70()) {
            setCustomProperty(DELEGATE, getModuleClassName());
        } else if(useLoginModuleProxy) {
            getProperties().put(DELEGATE, getModuleClassName());
        } else if(getJAASLogin().getJAASLogins().getSecurityDomain().isAtLeast70()){
            if(getProperties().containsKey(DELEGATE)) {
                removeCustomProperty(DELEGATE);
            }
        } else if(getProperties().containsKey(DELEGATE))
            getProperties().remove(DELEGATE);
    }
    
    /**
     * Get the {@link JAASLogin} parent class
     * 
     * @return The {@link JAASLogin} parent
     */
    public JAASLogin getJAASLogin() {
        return this.parent;
    }
    
    public void commit(HashMap<String, Object> values) {
    }
    
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_AUTH_STRATEGY)) {
                authStrategy = (AuthenticationStrategy)value;
            } else if(key.equals(CHANGE_KEY_CUSTOM)) {
                customProps = (Map)value;
            } else if(key.equals(CHANGE_KEY_CONFIG_OBJ)) {
                this.configObj = (ConfigObject)value;
            }
        }
    }
    
    protected void setConfigObject(ConfigObject configObject) throws Exception {
        this.parent.getJAASLogins().getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CONFIG_OBJ, this.configObj);
        this.configObj = configObject;
    }
    
}
	