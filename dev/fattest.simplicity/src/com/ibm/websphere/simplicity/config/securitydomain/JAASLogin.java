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
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * This abstract class is the parent class for {@link JAASSystemLogin}s and
 * {@link JAASApplicationLogin}s. Java(TM) Authentication and Authorization Service (JAAS) login
 * configurations are used by system resources including the authentication mechanism, principal
 * mapping, and credential mapping.
 */
public abstract class JAASLogin implements Configurable {
    
    private static final Class c = JAASLogin.class;
    private static final String CHANGE_KEY_MODULES = "loginModules";
    
    protected List<JAASLoginModule> loginModules;
    protected JAASLogins parent;
    protected JAASLoginType type;
    protected ConfigIdentifier configId;
    protected String alias;
    
    /**
     * Constructor
     * 
     * @param parent {@link JAASLogins} parent
     * @param type The type of login
     * @param configId The {@link ConfigIdentifier} of this login
     */
    protected JAASLogin(JAASLogins parent, JAASLoginType type, ConfigIdentifier configId) {
        this.parent = parent;
        this.type = type;
        this.configId = configId;
    }

    /**
     * Get the login modules of this login. This method returns the modules in the order that they
     * are processed.
     * 
     * @return A List of login modules
     * @throws Exception
     */
    public List<JAASLoginModule> getLoginModules() throws Exception {
        if(this.loginModules == null) {
            this.loginModules = new ArrayList<JAASLoginModule>();
            List<ConfigObject> modules = ConfigObject.getConfigObjectList(parent.getSecurityDomain().getCell(), this.configId, "JAASLoginModule");
            for(ConfigObject module : modules) {
                this.loginModules.add(new JAASLoginModule(module, this));
            }
        }
        return new ArrayList<JAASLoginModule>(this.loginModules);
    }
    
    /**
     * Get a specific login module using the module's class name
     * 
     * @param className The class name of the module to get
     * @return A {@link JAASLoginModule} with the specified class name or null if no module with that name exists
     * @throws Exception
     */
    public JAASLoginModule getLoginModuleByClassName(String className) throws Exception {
        List<JAASLoginModule> modules = getLoginModules();
        JAASLoginModule ret = null;
        for(JAASLoginModule module : modules) {
            if(module.getModuleClassName().equals(className)) {
                ret = module;
                break;
            }
        }
        return ret;
    }
    
    /**
     * Create a JAAS login module.
     * 
     * @param settings The settings to use when creating the module
     * @return An {@link OperationResults} containing the new {@link JAASLoginModule}
     * @throws Exception
     */
    public OperationResults<JAASLoginModule> createJAASLoginModule(LoginModuleSettings settings) throws Exception {
        final String method = "createJAASLoginModule";
        Log.entering(c, method, settings);
        if(getLoginModuleByClassName(settings.getLoginModule()) != null) {
            throw new Exception("A login module with class name " + settings.getLoginModule() + " already exists for JAAS login " + getAlias() + ".");
        }

        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_MODULES, getLoginModules());
        
        OperationResults<Boolean> results = configureJAASLoginModule(settings);
        OperationResults<JAASLoginModule> retResults = new OperationResults<JAASLoginModule>();
        retResults.setSuccess(results.isSuccess());
        retResults.setSystemErr(results.getSystemErr());
        retResults.setSystemOut(results.getSystemOut());
        retResults.addNotifications(results.getNotifications());
        if(results.getResult()) {
            JAASLoginModule ret = null;
            String loginModule = settings.getLoginModule();
            if(this.loginModules == null) {
                // initializing the modules will cause the new module to be loaded automatically
                Log.finer(c, method, "Getting login module by initializing internal List of modules.");
                ret = getLoginModuleByClassName(loginModule);
            } else {
                Log.finer(c, method, "Getting login module by searching the config and comparing class name.");
                ret = null;
                List<ConfigObject> modules = ConfigObject.getConfigObjectList(parent.getSecurityDomain().getCell(), this.configId, "JAASLoginModule");
                for(ConfigObject module : modules) {
                    ret = new JAASLoginModule(module, this);
                    if(ret.getModuleClassName().equals(loginModule)) {
                        this.loginModules.add(ret);
                        break;
                    }
                }
            }
            retResults.setResult(ret);
        } else {
            Log.finer(c, method, "The login module was not configured correctly.");
        }
        Log.exiting(c, method, retResults);
        return retResults;
    }
    
    /**
     * Delete a JAAS login module
     * 
     * @param moduleClassName The class name of the login module to delete
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public OperationResults<Boolean> deleteJAASLoginModule(String moduleClassName) throws Exception {
        final String method = "deleteJAASLoginModule";
        Log.entering(c, method, moduleClassName);
        if(getLoginModuleByClassName(moduleClassName) == null) {
            throw new Exception("A module with class name " + moduleClassName + " does not exist for JAAS login " + getAlias() + ".");
        }

        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_MODULES, getLoginModules());

        OperationResults<Boolean> results = new OperationResults<Boolean>();
        JAASLoginModule module = getLoginModuleByClassName(moduleClassName);
        if(getJAASLogins().getSecurityDomain().isAtLeast70()) {
            final Cell fcell = parent.getSecurityDomain().getCell();
            final JAASLogin flogin = this;
            final String fclassName = moduleClassName;
            final String fdomainName = parent.getSecurityDomain().getName();
            results = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unconfigureJAASLoginModule(fcell, flogin, fclassName, fdomainName, fcell.getActiveSession());
        } else {
            List<ConfigObject> modules = getEntryConfigObject().getChildObjectsByDataType("JAASLoginModule");
            ConfigObject toDelete = null;
            for(ConfigObject m : modules) {
                if(m.getAttributeByName("moduleClassName").getValueAsString().equals("com.ibm.ws.security.common.auth.module.proxy.WSLoginModuleProxy")) {
                    List<ConfigObject> props = m.getChildObjectsByDataType("Property");
                    for(ConfigObject prop : props) {
                        if(prop.getAttributeByName("value").getValueAsString().equals(moduleClassName)) {
                            toDelete = m;
                            break;
                        }
                    }
                    if(toDelete != null)
                        break;
                } else if(m.getAttributeByName("moduleClassName").getValueAsString().equals(moduleClassName)){
                    toDelete = m;
                }
            }
            toDelete.delete();
            results.setResult(true);
            results.setSuccess(true);
        }
        if(results.getResult()) {
            removeJAASLoginModule(module.getModuleClassName());
        }
        Log.exiting(c, method, results.getResult());
        return results;
    }
    
    /**
     * Remove a login module from the internal Set
     * 
     * @param moduleClassName The class name of the module to remove
     * @throws Exception
     */
    protected void removeJAASLoginModule(String moduleClassName) throws Exception {
        JAASLoginModule rem = getLoginModuleByClassName(moduleClassName);
        if(rem != null) {
            this.loginModules.remove(rem);
        }
    }
    
    /**
     * Set the order that the login modules are processed by the system.
     * 
     * @param moduleNames A List of module names in the order to set them
     * @throws Exception
     */
    public void setLoginModuleOrder(List<String> moduleNames) throws Exception {
        final String method = "setLoginModuleOrder";
        Log.entering(c, method, moduleNames);
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_MODULES, getLoginModules());
        
        List<String> validNames = new ArrayList<String>();
        List<JAASLoginModule> mods = getLoginModules();
        for(JAASLoginModule module : mods) {
            validNames.add(module.getModuleClassName());
        }
        if(!new HashSet<String>(validNames).equals(new HashSet<String>(moduleNames)))
            throw new Exception("All module names for this JAAS login must be in the moduleNames list.");
        if(validNames.equals(moduleNames)) {
            Log.finer(c, method, "No reordering is actually needed.");
            Log.exiting(c, method);
            return;
        }

        List<JAASLoginModule> temp = new ArrayList<JAASLoginModule>();
        for(String moduleName : moduleNames) {
            temp.add(getLoginModuleByClassName(moduleName));
        }
        configureJAASLogin(moduleNames);
        this.loginModules = temp;
        // this causes the config ID to change
        List<ConfigObject> modules = ConfigObject.getConfigObjectList(parent.getSecurityDomain().getCell(), this.configId, "JAASLoginModule");
        for(ConfigObject module : modules) {
            getLoginModuleByClassName(new JAASLoginModule(module, this).getModuleClassName()).setConfigObject(module);
        }
        Log.exiting(c, method);
    }
    
    /**
     * Configure a JAAS login module
     * 
     * @param settings The settings to use when configuring the module
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    protected OperationResults<Boolean> configureJAASLoginModule(LoginModuleSettings settings) throws Exception {
        final String method = "configureJAASLoginModule";
        Log.entering(c, method, settings);
        if(settings.getLoginModule() == null || settings.getLoginModule().length() < 1) {
            throw new IllegalArgumentException("Login module must be specified.");
        }
        OperationResults<Boolean> results = new OperationResults<Boolean>();
        if(getJAASLogins().getSecurityDomain().isAtLeast70()) {
            final Cell fcell = parent.getSecurityDomain().getCell();
            final JAASLogin flogin = this;
            final String fname = parent.getSecurityDomain().getName();
            final LoginModuleSettings foptions = settings;
            results = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureJAASLoginModule(fcell, flogin, fname, foptions, fcell.getActiveSession());
        } else {
            ConfigObject module = null;
            if(getLoginModuleByClassName(settings.getLoginModule()) == null)
                module = ConfigObject.createConfigObject(getJAASLogins().getSecurityDomain().getCell(), "JAASLoginModule", getEntryConfigObject());
            else {
                List<ConfigObject> modules = getEntryConfigObject().getChildObjectsByDataType("JAASLoginModule");
                for(ConfigObject m : modules) {
                    if(m.getAttributeByName("moduleClassName").getValueAsString().equals("com.ibm.ws.security.common.auth.module.proxy.WSLoginModuleProxy")) {
                        List<ConfigObject> properties = m.getChildObjectsByDataType("Property");
                        for(ConfigObject prop : properties) {
                            if(prop.getAttributeByName("name").getValueAsString().equals(JAASLoginModule.DELEGATE) && prop.getAttributeByName("value").getValueAsString().equals(settings.getLoginModule())) {
                                module = m;
                                break;
                            }
                        }
                    } else if(m.getAttributeByName("moduleClassName").getValueAsString().equals(settings.getLoginModule()))
                        module = m;
                    if(module != null) 
                        break;
                }
            }
            if(settings.getUseLoginModuleProxy() != null && settings.getUseLoginModuleProxy()) {
                module.getAttributeByName("moduleClassName").setValue("com.ibm.ws.security.common.auth.module.proxy.WSLoginModuleProxy");
                List<ConfigObject> properties = module.getChildObjectsByDataType("Property");
                ConfigObject property = null;
                for(ConfigObject prop : properties) {
                    if(prop.getAttributeByName("name") != null && prop.getAttributeByName("name").getValueAsString().equals(JAASLoginModule.DELEGATE)) {
                        property = prop;
                        break;
                    }
                }
                if(property == null)
                    property = ConfigObject.createConfigObject(getJAASLogins().getSecurityDomain().getCell(), "Property", module);
                property.getAttributeByName("name").setValue(JAASLoginModule.DELEGATE);
                property.getAttributeByName("value").setValue(settings.getLoginModule());
            } else {
                module.getAttributeByName("moduleClassName").setValue(settings.getLoginModule());
                if(settings.getUseLoginModuleProxy() != null) {
                    ConfigObject property = null;
                    List<ConfigObject> properties = module.getChildObjectsByDataType("Property");
                    for(ConfigObject prop : properties) {
                        if(prop.getAttributeByName("name") != null && prop.getAttributeByName("name").getValueAsString().equals(JAASLoginModule.DELEGATE)) {
                            property = prop;
                            break;
                        }
                    }
                    if(property != null)
                        property.delete();
                }
            }
            if(settings.getAuthStrategy() != null)
                module.getAttributeByName("authenticationStrategy").setValue(settings.getAuthStrategy().toString());
            if(settings.getCustomProps() != null) {
                Map<String, String> props = new HashMap<String, String>(settings.getCustomProps());
                ConfigObject property = null;
                List<ConfigObject> properties = module.getChildObjectsByDataType("Property");
                for(ConfigObject prop : properties) {
                    String name = null;
                    if(prop.getAttributeByName("name") != null)
                        name = prop.getAttributeByName("name").getValueAsString();
                    if(name != null && props.containsKey(name) && props.get(name) != null) {
                        // change the value
                        prop.getAttributeByName("value").setValue(props.get(name));
                        props.remove(name);
                    } else if(name != null&& props.containsKey(name)) {
                        // delete the value
                        prop.delete();
                        props.remove(name);
                    } // for some reason when creating a new login it has a property; this doesn't get written to the config though
                }
                for(String prop : props.keySet()) { // new properties
                    property = ConfigObject.createConfigObject(getJAASLogins().getSecurityDomain().getCell(), "Property", module);
                    property.getAttributeByName("name").setValue(prop);
                    property.getAttributeByName("value").setValue(props.get(prop));
                }
            }
            results.setResult(true);
            results.setSuccess(true);
        }
        
        Log.exiting(c, method, results.getResult());
        return results;
    }
    
    protected ConfigObject getEntryConfigObject() throws Exception {
        List<ConfigObject> entries = getJAASLogins().getJAASLoginsConfigObject().getChildObjectsByDataType("JAASConfigurationEntry");
        for(ConfigObject entry : entries) {
            if(entry.getAttributeByName("alias").getValueAsString().equals(this.alias))
                return entry;
        }
        return null;
    }

    /**
     * Get the {@link JAASLogins} parent
     * 
     * @return The parent class of this login
     */
    public JAASLogins getJAASLogins() {
        return parent;
    }

    /**
     * Get the {@link ConfigIdentifier} of this login
     * 
     * @return The {@link ConfigIdentifier} of this login
     */
    public ConfigIdentifier getConfigId() {
        return configId;
    }

    /**
     * Get the type of this login
     * 
     * @return The type of this login
     */
    public JAASLoginType getType() {
        return type;
    }

    /**
     * Get the alias name for the Java(TM) Authentication and Authorization Service (JAAS) login.
     * 
     * @return The login's alias
     * @throws Exception
     */
    public String getAlias() throws Exception {
        if(this.alias == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            this.alias = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "alias").toString();
        }
        return this.alias;
    }
    
    /**
     * Configure this JAAS login. Really all this does is set the login module order.
     * 
     * @param alias The alias of the login to configure
     * @param loginModules A List of module names in the order that they should be set
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    protected void configureJAASLogin(List<String> loginModules) throws Exception {
        final String method = "createJAASLogin";
        Log.entering(c, method, alias);
        
        if(getJAASLogins().getSecurityDomain().isAtLeast70()) {
            final Cell fcell = this.parent.getSecurityDomain().getCell();
            final String falias = alias;
            final JAASLoginType ftype = this.type;
            final String fname = this.parent.getSecurityDomain().getName();
            final List<String> flist = loginModules;
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureJAASLogin(fcell, falias, ftype, fname, flist, fcell.getActiveSession());
        } else {
            // we need to delete the modules and recreate them to order them
            List<JAASLoginModule> modules = new ArrayList<JAASLoginModule>();
            for(String module : loginModules) {
                modules.add(getLoginModuleByClassName(module));
            }
            LoginModuleSettings settings = null;
            for(JAASLoginModule module : modules) {
                settings = new LoginModuleSettings();
                settings.setAuthStrategy(module.getAuthenticationStrategy());
                settings.setCustomProps(module.getCustomProperties());
                settings.setLoginModule(module.getModuleClassName());
                settings.setUseLoginModuleProxy(module.usingLoginModuleProxy());
                deleteJAASLoginModule(module.getModuleClassName());
                createJAASLoginModule(settings);
            }
        }
        Log.exiting(c, method);
    }
    
    public void commit(HashMap<String, Object> values) {
    }
    
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_MODULES)) {
	            loginModules = (List)value;
	        }
        }
    }
}
