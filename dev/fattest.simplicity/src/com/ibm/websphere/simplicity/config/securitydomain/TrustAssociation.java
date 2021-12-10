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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.securityconfiguration.ConfigureInterceptor;
import com.ibm.websphere.simplicity.commands.securityconfiguration.UnconfigureInterceptor;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.TrustAssociationWrapper;

/**
 * This class contains the trust association attributes for a domain. Trust association is used to
 * connect reversed proxy servers to the application servers.
 */
public class TrustAssociation extends SecurityDomainAttribute implements Configurable {
    
    private static final Class c = TrustAssociation.class;
    private static final String CHANGE_KEY_ENABLED = "enabled";
    private static final String CHANGE_KEY_INTERCEPTORS = "interceptors";
	
	private TrustAssociationWrapper settings;
    private Set<Interceptor> interceptors;

    /**
     * Constructor
     * 
     * @param domain The {@link SecurityDomain} parent
     */
	protected TrustAssociation(SecurityDomain domain) {
		super(domain);
	}

    /**
     * Returns true if the integration of IBM WebSphere Application Server security and third-party
     * security servers is enabled.
     * 
     * @return true if trust association is enabled
     * @throws Exception
     */
    public Boolean isEnabled() throws Exception {
        if(getSettings() != null) {
            return getSettings().getEnabled();
        }
        return null;
    }

    /**
     * Enable or disable trust association. A reverse proxy server can act as a front-end
     * authentication server while the product applies its own authorization policy onto the
     * resulting credentials that are passed by the proxy server.
     * 
     * @param enabled true to enable, false to disable
     * @throws Exception
     */
    public void setEnabled(boolean enabled) throws Exception {
        final String method = "setEnabled";
        Log.entering(c, method, enabled);
        
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_ENABLED, isEnabled());
        
        if(getSecurityDomain().isAtLeast70()) {
            final Cell fcell = getSecurityDomain().getCell();
            final String fname = getSecurityDomain().getName();
            final TrustAssociationWrapper fsettings= new TrustAssociationWrapper();
            fsettings.setEnabled(enabled);
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureTrustAssociation(fcell, fname, fsettings, fcell.getActiveSession());
        } else {
            getTrustAssociationConfigObject().getAttributeByName("enabled").setValue(enabled);
        }
        
        getSettings().setEnabled(enabled);
        Log.exiting(c, method);
    }
    
    /**
     * Create a new trust association {@link Interceptor}
     * 
     * @param settings The settings to configure the {@link Interceptor} with
     * @return The {@link OperationResults}
     * @throws Exception
     */
    public OperationResults<Interceptor> createInterceptor(InterceptorSettings settings) throws Exception {
        final String method = "createInterceptor";
        Log.entering(c, method, settings);
        
        if(settings.getClassName() == null || settings.getClassName().length() == 0)
            throw new Exception("A className must be specified.");
        if(getInterceptorByClassName(settings.getClassName()) != null)
            throw new Exception("An Interceptor with className " + settings.getClassName() + " already exists.");
        
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_INTERCEPTORS, getInterceptors());
        
        OperationResults<Interceptor> ret = new OperationResults<Interceptor>();
        Interceptor result = configureInterceptor(settings);
        if(this.getSecurityDomain().isAtLeast70()) {
            ret.setResult(new Interceptor(this, settings));
        } else {
            ret.setResult(result);
        }
        this.interceptors.add(ret.getResult());
        
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Delete an Interceptor
     * 
     * @param className The class name of the interceptor to delete
     * @throws Exception If the deletion fails
     */
    public void deleteInterceptor(String className) throws Exception {
        final String method = "deleteInterceptor";
        Log.entering(c, method, className);

        if(className == null || className.length() == 0)
            throw new Exception("A className must be specified.");
        if(getInterceptorByClassName(className) == null)
            throw new Exception("No interceptor with className " + className + " exists.");
        
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_INTERCEPTORS, getInterceptors());
        
        Interceptor interceptor = getInterceptorByClassName(className);
        if(getSecurityDomain().isAtLeast70()) {
            UnconfigureInterceptor adminTask = new UnconfigureInterceptor(className);
            if(!(getSecurityDomain() instanceof GlobalSecurityDomain))
                adminTask.setSecurityDomainName(getSecurityDomain().getName());
            adminTask.run(getSecurityDomain().getCell());
        } else {
            interceptor.getConfigObject().delete();
        }
        this.interceptors.remove(interceptor);
        
        Log.exiting(c, method);
    }
    
    /**
     * Get the trust association interceptor implementations.
     * 
     * @return A Set of trust association interceptor implementations
     * @throws Exception
     */
    public Set<Interceptor> getInterceptors() throws Exception {
        final String method = "getInterceptors";
        Log.entering(c, method);
        if(this.interceptors == null) {
            this.interceptors = new HashSet<Interceptor>();
            if(this.getSecurityDomain().isAtLeast70()) {
                Cell key = this.getSecurityDomain().getCell();
                String domainName = this.getSecurityDomain().getName();
                AbstractSession session = key.getActiveSession();
                Set<InterceptorSettings> interceptors = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getInterceptors(key, domainName, session);
                for(InterceptorSettings interceptor : interceptors)
                    this.interceptors.add(new Interceptor(this, interceptor));
            } else {
                List<ConfigObject> interceptors = getTrustAssociationConfigObject().getChildObjectsByDataType("TAInterceptor");
                for(ConfigObject interceptor : interceptors)
                    this.interceptors.add(new Interceptor(this, interceptor));
            }
        }
        return this.interceptors;
    }
    
    /**
     * Get a specific {@link Interceptor}
     * 
     * @param name The name of the interceptor to get
     * @return The specified {@link Interceptor} or null if no {@link Interceptor} with the specified name exists
     * @throws Exception
     */
    public Interceptor getInterceptorByClassName(String name) throws Exception {
        Set<Interceptor> interceptors = getInterceptors();
        for(Interceptor interceptor : interceptors)
            if(interceptor.getClassName().equals(name))
                return interceptor;
        return null;
    }

    @Override
    public void useGlobalDomainSettings() throws Exception {
        final String method = "useGlobalDomainSettings";
        Log.entering(c, method);

        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_ENABLED, isEnabled());

        if(!(getSecurityDomain() instanceof GlobalSecurityDomain)) {
            final Cell fcell = getSecurityDomain().getCell();
            final String fname = getSecurityDomain().getName();
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unconfigureTrustAssociation(fcell, fname, fcell.getActiveSession());
            this.settings = null;
        } else {
            Log.finer(c, method, "This is the global security domain. Nothing to do.");
        }
        Log.exiting(c, method);
    }
    
    @Override
    public boolean globalSettingsInUse() throws Exception {
        return ((getSecurityDomain() instanceof GlobalSecurityDomain) || (isEnabled() == null));
    }

    /**
     * Get the trust association attributes
     * 
     * @return A {@link TrustAssociationWrapper} containing the attributes
     * @throws Exception
     */
    private TrustAssociationWrapper getSettings() throws Exception {
        if(this.settings == null) {
            if(getSecurityDomain().isAtLeast70()) {
                Cell cell = this.getSecurityDomain().getCell();
                String domain = this.getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                this.settings = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getTrustAssocationInfo(cell, domain, session);
            } else {
                this.settings = new TrustAssociationWrapper();
                this.settings.setEnabled(getTrustAssociationConfigObject().getAttributeByName("enabled").getValueAsBoolean());
            }
        }
        return this.settings;
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_ENABLED)) {
		        getSettings().setEnabled((Boolean)value);
		    } else if(key.equals(CHANGE_KEY_INTERCEPTORS)) {
		        this.interceptors = (Set)value;
            }
        }
    }
    
    protected ConfigObject getTrustAssociationConfigObject() throws Exception {
        List<ConfigObject> authMechs = getSecurityDomain().getconfigObject().getChildObjectsByDataType("AuthMechanism");
        ConfigObject authMech = null;
        for(ConfigObject auth : authMechs) {
            if(auth.getMetadata().getDataType().equals("LTPA")) {
                authMech = auth;
                break;
            }
        }
        return authMech.getChildObjectsByDataType("TrustAssociation").get(0);
    }
    
    protected Interceptor configureInterceptor(InterceptorSettings wrapper) throws Exception {
        final String method = "configureInterceptor70";
        Log.entering(c, method, wrapper);
        
        Interceptor interceptor = getInterceptorByClassName(wrapper.getClassName());
        if(getSecurityDomain().isAtLeast70()) {
            ConfigureInterceptor adminTask = new ConfigureInterceptor(wrapper.getClassName());
            if(wrapper.getCustomProps() != null && wrapper.getCustomProps().size() > 0) {
                Map<String, String> customProps = wrapper.getCustomProps();
                String propsString = "";
                for(String prop : customProps.keySet()) {
                    if(customProps.get(prop) != null)
                        propsString += ("\""+prop+"="+customProps.get(prop)+"\",");
                    else
                        propsString += ("\""+prop+"=,");
                }
                propsString = propsString.substring(0, propsString.length()-1);
                adminTask.setCustomProperties(propsString);
            }
            if(!(getSecurityDomain() instanceof GlobalSecurityDomain))
                adminTask.setSecurityDomainName(getSecurityDomain().getName());
            adminTask.run(getSecurityDomain().getCell());
        } else {
            ConfigObject trustAss = getTrustAssociationConfigObject();
            if(interceptor == null) {
                // we are creating a new one
                ConfigObject newInterceptor = ConfigObject.createConfigObject(getSecurityDomain().getCell(), "TAInterceptor", trustAss);
                newInterceptor.getAttributeByName("interceptorClassName").setValue(wrapper.getClassName());
                Map<String, String> props = wrapper.getCustomProps();
                if(props != null) {
                    ConfigObject property = null;
                    for(String prop : props.keySet()) {
                        property = ConfigObject.createConfigObject(getSecurityDomain().getCell(), "Property", newInterceptor);
                        property.getAttributeByName("name").setValue(prop);
                        property.getAttributeByName("value").setValue(props.get(prop));
                    }
                }
                interceptor = new Interceptor(this, newInterceptor);
            } else {
                // we are modifying an existing one
                ConfigObject interceptorObj = interceptor.getConfigObject();
                // can't modify the name
                Map<String, String> props = wrapper.getCustomProps();
                if(props != null) {
                    List<ConfigObject> customProperties = interceptorObj.getChildObjectsByDataType("Property");
                    String name = null;
                    for(ConfigObject property : customProperties) {
                        name = property.getAttributeByName("name").getValueAsString().trim();
                        if(props.containsKey(name) && props.get(name) != null) {
                            // we are modifying an existing property
                            property.getAttributeByName("value").setValue(props.get(name));
                            props.remove(name);
                        } else if(props.containsKey(name)) {
                            // we are deleting a property
                            property.delete();
                            props.remove(name);
                        } // property is not modified
                    }
                    // now process new properties
                    if(props.size() > 0) {
                        ConfigObject newProp = null;
                        for(String property : props.keySet()) {
                            newProp = ConfigObject.createConfigObject(getSecurityDomain().getCell(), "Property", interceptorObj);
                            newProp.getAttributeByName("name").setValue(property);
                            newProp.getAttributeByName("value").setValue(props.get(property));
                        }
                    }
                }
            }
        }
        
        Log.exiting(c, method, interceptor);
        return interceptor;
    }
}
