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
import java.util.List;
import java.util.Map;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.AuthorizationProviderSettings;

/**
 * The application server provides a default authorization engine that performs all of the
 * authorization decisions. In addition, the application server also supports an external
 * authorization provider using the JACC specification to replace the default authorization engine
 * for Java Platform, Enterprise Edition (Java EE) applications.
 */
public class AuthorizationProvider implements Configurable {
    
    private static final Class c = AuthorizationProvider.class;
    private static final String CHANGE_KEY_NAME = "name";
    private static final String CHANGE_KEY_DESC = "desc";
    private static final String CHANGE_KEY_J2EE = "j2ee";
    private static final String CHANGE_KEY_POLICY = "policy";
    private static final String CHANGE_KEY_ROLE = "role";
    private static final String CHANGE_KEY_EJB_ARGS = "ejbargs";
    private static final String CHANGE_KEY_INIT_JACC = "initjacc";
    private static final String CHANGE_KEY_DYNAMIC_MODULE = "dynamicmodule";
    private static final String CHANGE_KEY_CUSTOM = "custom";
    
    private AuthorizationConfig parent;
    private ConfigObject configObject;
    private String name;
    private String description;
    private String j2eePolicyImplClassName;
    private String policyConfigurationFactoryImplClassName;
    private String roleConfigurationFactoryImplClassName;
    private Boolean requiresEJBArgumentsPolicyContextHandler;
    private String initializeJACCProviderClassName;
    private Boolean supportsDynamicModuleUpdates;
    private Map<String, String> customProperties;
    
    /**
     * Constructor
     * 
     * @param parent The {@link AuthorizationConfig} that this belongs to
     * @param configObject A {@link ConfigObject} representatin of the provider
     */
    protected AuthorizationProvider(AuthorizationConfig parent, ConfigObject configObject) {
        this.parent = parent;
        this.configObject = configObject;
    }
    
    /**
     * Get the {@link AuthorizationConfig} parent of this provider
     * 
     * @return The parent of this provider
     */
    public AuthorizationConfig getAuthorizationConfig() {
        return this.parent;
    }
    
    /**
     * Get the name of the AuthorizationProvider
     * 
     * @return The name of the provider
     * @throws Exception
     */
    public String getName() throws Exception {
        if(this.name == null) {
            this.name = this.configObject.getAttributeByName("name").getValueAsString();
        }
        return this.name;
    }
    
    /**
     * Set the name of the AuthorizationProvider. The name uniquely identifies the provider
     * 
     * @param name The name to set
     * @throws Exception
     */
    public void setName(String name) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_NAME, getName());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setName(name);
        configureAuthorizationProvider(settings);
        this.name = name;
    }

    /**
     * Get the optional description
     * 
     * @return The description of the provider
     * @throws Exception
     */
    public String getDescription() throws Exception {
        if(this.description == null) {
            this.description = this.configObject.getAttributeByName("description").getValueAsString();
        }
        return this.description;
    }

    /**
     * Set the optional description
     * 
     * @param description The description to set
     * @throws Exception
     */
    public void setDescription(String description) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_DESC, getDescription());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setDescription(description);
        configureAuthorizationProvider(settings);
        this.description = description;
    }

    /**
     * Specifies a fully qualified class name that represents the
     * javax.security.jacc.policy.provider property as per the JACC specification. The class
     * represents the provider-specific implementation of the java.security.Policy abstract methods.
     * 
     * @return The policy class name
     * @throws Exception
     */
    public String getJ2EEPolicyImplClassName() throws Exception {
        if(this.j2eePolicyImplClassName == null) {
            this.j2eePolicyImplClassName = this.configObject.getAttributeByName("j2eePolicyImplClassName").getValueAsString();
        }
        return this.j2eePolicyImplClassName;
    }

    /**
     * Set the policy class name. Specifies a fully qualified class name that represents the
     * javax.security.jacc.policy.provider property as per the JACC specification. The class
     * represents the provider-specific implementation of the java.security.Policy abstract methods.
     * 
     * @param j2eePolicyImplClassName The class name to set
     * @throws Exception
     */
    public void setJ2EEPolicyImplClassName(String j2eePolicyImplClassName) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_J2EE, getJ2EEPolicyImplClassName());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setJ2eePolicyImplClassName(j2eePolicyImplClassName);
        configureAuthorizationProvider(settings);
        this.j2eePolicyImplClassName = j2eePolicyImplClassName;
    }

    /**
     * Specifies a fully qualified class name that represents the
     * javax.security.jacc.PolicyConfigurationFactory.provider property as per the JACC
     * specification. The class represents the provider-specific implementation of the
     * javax.security.jacc.PolicyConfigurationFactory abstract methods.
     * 
     * @return The policy configuration factory class name
     * @throws Exception
     */
    public String getPolicyConfigurationFactoryImplClassName() throws Exception {
        if(this.policyConfigurationFactoryImplClassName == null) {
            this.policyConfigurationFactoryImplClassName = this.configObject.getAttributeByName("policyConfigurationFactoryImplClassName").getValueAsString();
        }
        return this.policyConfigurationFactoryImplClassName;
    }

    /**
     * Set the policy configuration factory class name. Specifies a fully qualified class name that
     * represents the javax.security.jacc.PolicyConfigurationFactory.provider property as per the
     * JACC specification. The class represents the provider-specific implementation of the
     * javax.security.jacc.PolicyConfigurationFactory abstract methods.
     * 
     * @param policyConfigurationFactoryImplClassName The class name to set.
     * @throws Exception
     */
    public void setPolicyConfigurationFactoryImplClassName(String policyConfigurationFactoryImplClassName) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_POLICY, getPolicyConfigurationFactoryImplClassName());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setPolicyConfigurationFactoryImplClassName(policyConfigurationFactoryImplClassName);
        configureAuthorizationProvider(settings);
        this.policyConfigurationFactoryImplClassName = policyConfigurationFactoryImplClassName;
    }

    /**
     * Specifies a fully qualified class name that implements the
     * com.ibm.wsspi.security.authorization.RoleConfigurationFactory interface.
     * 
     * @return The role configuration factory class name
     * @throws Exception
     */
    public String getRoleConfigurationFactoryImplClassName() throws Exception {
        if(this.roleConfigurationFactoryImplClassName == null) {
            this.roleConfigurationFactoryImplClassName = this.configObject.getAttributeByName("roleConfigurationFactoryImplClassName").getValueAsString();
        }
        return this.roleConfigurationFactoryImplClassName;
    }

    /**
     * Specifies a fully qualified class name that implements the
     * com.ibm.wsspi.security.authorization.RoleConfigurationFactory interface.
     * 
     * @param roleConfigurationFactoryImplClassName The class name to set
     * @throws Exception
     */
    public void setRoleConfigurationFactoryImplClassName(String roleConfigurationFactoryImplClassName) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_ROLE, getRoleConfigurationFactoryImplClassName());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setRoleConfigurationFactoryImplClassName(roleConfigurationFactoryImplClassName);
        configureAuthorizationProvider(settings);
        this.roleConfigurationFactoryImplClassName = roleConfigurationFactoryImplClassName;
    }

    /**
     * Returns whether the provider requires the EJBArgumentsPolicyContextHandler handler to make
     * access decisions.
     * 
     * @return true if the provider requires the EJBArgumentsPolicyContextHandler handler to make
     *         access decisions.
     * @throws Exception
     */
    public Boolean getRequiresEJBArgumentsPolicyContextHandler() throws Exception {
        if(this.requiresEJBArgumentsPolicyContextHandler == null) {
            this.requiresEJBArgumentsPolicyContextHandler = this.configObject.getAttributeByName("requiresEJBArgumentsPolicyContextHandler").getValueAsBoolean();
        }
        return this.requiresEJBArgumentsPolicyContextHandler;
    }

    /**
     * Set whether the provider requires the EJBArgumentsPolicyContextHandler handler to make access
     * decisions.
     * 
     * @param requiresEJBArgumentsPolicyContextHandler true if provider requires the
     *            EJBArgumentsPolicyContextHandler handler to make access decisions.
     * @throws Exception
     */
    public void setRequiresEJBArgumentsPolicyContextHandler(boolean requiresEJBArgumentsPolicyContextHandler)
            throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_EJB_ARGS, getRequiresEJBArgumentsPolicyContextHandler());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setRequiresEJBArgumentsPolicyContextHandler(requiresEJBArgumentsPolicyContextHandler);
        configureAuthorizationProvider(settings);
        this.requiresEJBArgumentsPolicyContextHandler = requiresEJBArgumentsPolicyContextHandler;
    }

    /**
     * Returns the class name that implements the com.ibm.wsspi.security.authorization.InitializeJACCProvider interface.
     * 
     * @return The initialize JACC provider class name
     * @throws Exception
     */
    public String getInitializeJACCProviderClassName() throws Exception {
        if(this.initializeJACCProviderClassName == null) {
            this.initializeJACCProviderClassName = this.configObject.getAttributeByName("initializeJACCProviderClassName").getValueAsString();
        }
        return this.initializeJACCProviderClassName;
    }

    /**
     * Set the class name that implements the
     * com.ibm.wsspi.security.authorization.InitializeJACCProvider interface.
     * 
     * @param initializeJACCProviderClassName The class name to set
     * @throws Exception
     */
    public void setInitializeJACCProviderClassName(String initializeJACCProviderClassName) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_INIT_JACC, getInitializeJACCProviderClassName());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setInitializeJACCProviderClassName(initializeJACCProviderClassName);
        configureAuthorizationProvider(settings);
        this.initializeJACCProviderClassName = initializeJACCProviderClassName;
    }

    /**
     * Returns whether you can apply changes made to security policies of Web modules in a running
     * application, dynamically without affecting the rest of the application.
     * 
     * @return true if dynamic update is supported
     * @throws Exception
     */
    public Boolean getSupportsDynamicModuleUpdates() throws Exception {
        if(this.supportsDynamicModuleUpdates == null) {
            this.supportsDynamicModuleUpdates = this.configObject.getAttributeByName("supportsDynamicModuleUpdates").getValueAsBoolean();
        }
        return this.supportsDynamicModuleUpdates;
    }

    /**
     * Set whether you can apply changes made to security policies of Web modules in a running
     * application, dynamically without affecting the rest of the application.
     * 
     * @param supportsDynamicModuleUpdates true to support dynamic update
     * @throws Exception
     */
    public void setSupportsDynamicModuleUpdates(Boolean supportsDynamicModuleUpdates) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_DYNAMIC_MODULE, getSupportsDynamicModuleUpdates());

        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setSupportsDynamicModuleUpdates(supportsDynamicModuleUpdates);
        configureAuthorizationProvider(settings);
        this.supportsDynamicModuleUpdates = supportsDynamicModuleUpdates;
    }

    /**
     * Get the custom properties. These properties are propagated to the provider during the startup
     * process when the provider initialization class name is initialized. If the provider does not
     * implement the provider initialization class name as described previously, the properties are
     * not used.
     * 
     * @return The custom properties for the provider
     * @throws Exception
     */
    public Map<String, String> getCustomProperties() throws Exception {
        if(this.customProperties == null) {
            this.customProperties = new HashMap<String, String>();
            ArrayList<ConfigObject> properties = this.configObject.getChildObjectsByDataType("Property");
            for(ConfigObject property : properties) {
                this.customProperties.put(property.getAttributeByName("name").getValueAsString(), property.getAttributeByName("value").getValueAsString());
            }
        }
        return new HashMap<String, String>(this.customProperties);
    }

    /**
     * Set a custom property for the provider. These properties are propagated to the provider
     * during the startup process when the provider initialization class name is initialized. If the
     * provider does not implement the provider initialization class name as described previously,
     * the properties are not used.
     * 
     * @param property The property name
     * @param value The property value
     * @throws Exception
     */
    public void setCustomProperty(String property, String value) throws Exception {
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM, getCustomProperties());

        Map<String, String> props = new HashMap<String, String>();
        props.put(property, value);
        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setCustomProperties(props);
        configureAuthorizationProvider(settings);
        this.customProperties.put(property, value);
    }
    
    /**
     * Remove a custom property. These properties are propagated to the provider during the startup
     * process when the provider initialization class name is initialized. If the provider does not
     * implement the provider initialization class name as described previously, the properties are
     * not used.
     * 
     * @param property The name of the property to remove
     * @throws Exception
     */
    public void removeCustomProperty(String property) throws Exception {
        if (getCustomProperties().get(property) == null) {
            throw new Exception("Property with name " + property + " does not exist.");
        }
        SecurityDomain domain = getAuthorizationConfig().getSecurityDomain();
        domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM, getCustomProperties());

        Map<String, String> props = new HashMap<String, String>();
        props.put(property, null);
        AuthorizationProviderSettings settings = new AuthorizationProviderSettings();
        settings.setCustomProperties(props);
        configureAuthorizationProvider(settings);
        this.customProperties.remove(property);
    }
    
    /**
     * Configure the authorization provider
     * 
     * @param settings The settings to configure
     * @throws Exception
     */
    protected void configureAuthorizationProvider(AuthorizationProviderSettings settings) throws Exception {
        final String method = "configureAuthorizationProvider";
        Log.entering(c, method, settings);

        Cell cell = parent.getSecurityDomain().getCell();
        String name = parent.getSecurityDomain().getName();
        Boolean useJACCProvider = null;
        if(this.getAuthorizationConfig().getSecurityDomain().isAtLeast70())
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAuthorizationConfig(cell, name, useJACCProvider, settings, cell.getActiveSession());
        else {
            if(settings.getDescription() != null)
                this.configObject.getAttributeByName("description").setValue(settings.getDescription());
            if(settings.getInitializeJACCProviderClassName() != null)
                this.configObject.getAttributeByName("initializeJACCProviderClassName").setValue(settings.getInitializeJACCProviderClassName());
            if(settings.getJ2eePolicyImplClassName() != null)
                this.configObject.getAttributeByName("j2eePolicyImplClassName").setValue(settings.getJ2eePolicyImplClassName());
            if(settings.getName() != null)
                this.configObject.getAttributeByName("name").setValue(settings.getName());
            if(settings.getPolicyConfigurationFactoryImplClassName() != null)
                this.configObject.getAttributeByName("policyConfigurationFactoryImplClassName").setValue(settings.getPolicyConfigurationFactoryImplClassName());
            if(settings.getRequiresEJBArgumentsPolicyContextHandler() != null)
                this.configObject.getAttributeByName("requiresEJBArgumentsPolicyContextHandler").setValue(settings.getRequiresEJBArgumentsPolicyContextHandler());
            if(settings.getRoleConfigurationFactoryImplClassName() != null)
                this.configObject.getAttributeByName("roleConfigurationFactoryImplClassName").setValue(settings.getRoleConfigurationFactoryImplClassName());
            if(settings.getSupportsDynamicModuleUpdates() != null)
                this.configObject.getAttributeByName("supportsDynamicModuleUpdates").setValue(settings.getSupportsDynamicModuleUpdates());
            if(settings.getCustomProperties() != null) {
                List<ConfigObject> currentProps = this.configObject.getChildObjectsByDataType("Property");
                Map<String, String> propsToSet = new HashMap<String, String>(settings.getCustomProperties());
                String propName = null;
                ConfigObject value = null;
                ConfigObject next = null;
                for(ConfigObject current : currentProps) {
                    propName = current.getAttributeByName("name").getValueAsString();
                    value = current.getAttributeByName("value");
                    if(propsToSet.containsKey(propName)) {
                        if(propsToSet.get(propName) == null) {
                            // property has been deleted
                            current.delete();
                        } else if(!value.getValueAsString().equals(propsToSet.get(propName))) {
                            // value has changed
                            value.setValue(propsToSet.get(propName));
                        } // else they set the property with the same value as before
                        propsToSet.remove(propName); // we're done with it
                    } // property not being altered
                }
                // anything left over is new
                for(String newProp : propsToSet.keySet()) {
                    next = ConfigObject.createConfigObject(this.configObject.getScope(), "Property", this.configObject);
                    next.getAttributeByName("name").setValue(newProp);
                    next.getAttributeByName("value").setValue(propsToSet.get(newProp));
                    next.getAttributeByName("required").setValue(false);
                }
            }
        }
        
        Log.exiting(c, method);
    }
    
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_NAME)) {
                this.name = (String)value;
            } else if(key.equals(CHANGE_KEY_DESC)) {
                this.description = (String)value;
            } else if(key.equals(CHANGE_KEY_J2EE)) {
                this.j2eePolicyImplClassName = (String)value;
            } else if(key.equals(CHANGE_KEY_POLICY)) {
                this.policyConfigurationFactoryImplClassName = (String)value;
            } else if(key.equals(CHANGE_KEY_ROLE)) {
                this.roleConfigurationFactoryImplClassName = (String)value;
            } else if(key.equals(CHANGE_KEY_EJB_ARGS)) {
                this.requiresEJBArgumentsPolicyContextHandler = (Boolean)value;
            } else if(key.equals(CHANGE_KEY_INIT_JACC)) {
                this.initializeJACCProviderClassName = (String)value;
            } else if(key.equals(CHANGE_KEY_DYNAMIC_MODULE)) {
                this.supportsDynamicModuleUpdates = (Boolean)value;
            } else if(key.equals(CHANGE_KEY_CUSTOM)) {
                this.customProperties = (Map)value;
            }
        }
    }
    
    public void commit(HashMap<String, Object> values) throws Exception {
    }
}
