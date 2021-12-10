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
import java.util.Map;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.AuthorizationProviderSettings;

/**
 * This class contains authorization provider settings
 */
public class AuthorizationConfig extends SecurityDomainAttribute implements Configurable {
    
    private static final Class c = AuthorizationConfig.class;
    private static final String CHANGE_KEY_JAAC_PROVIDER = "useJACCProvider";
    private static final String CHANGE_KEY_AUTH_PROVIDER = "authProvider";
    
    private AuthorizationProvider authProvider;
    private ConfigIdentifier configId;
    private Boolean usingExternalJAACProvider;

    /**
     * Constructor
     * 
     * @param domain The parent {@link SecurityDomain}
     */
	protected AuthorizationConfig(SecurityDomain domain) {
		super(domain);
	}

    /**
     * Get the {@link AuthorizationProvider} currently in use
     * 
     * @return The {@link AuthorizationProvider} or null if no authorization provider is configured
     *         for the domain
     * @throws Exception
     */
	public AuthorizationProvider getAuthorizationProvider() throws Exception {
        if(this.authProvider == null) {
            ConfigObject provider = ConfigObject.getConfigObject(getSecurityDomain().getCell(), getAuthorizationConfig(), "AuthorizationProvider");
            this.authProvider = new AuthorizationProvider(this, provider);
        }
        return this.authProvider;
    }
    
    /**
     * Get whether or not an external JAAC provider is being used.
     * 
     * @return true if an external JAAC provider is being used, false if the built-in provider is
     *         being used, or null if there is no authorization provider configured for the domain
     * @throws Exception
     */
    public Boolean getUseExternalJAACProvider() throws Exception {
        if(usingExternalJAACProvider == null && globalSettingsInUse()) {
            return null;
        } else if(usingExternalJAACProvider == null) {
            Cell cell = getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            this.usingExternalJAACProvider = Boolean.valueOf(OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, this.configId, "useJACCProvider").toString()); 
        }
        return this.usingExternalJAACProvider;
    }
    
    /**
     * Set whether or not to use an external JAAC provider.
     * 
     * @param useJAACProvider true to use an external JAAC provider, false to use the built-in provider
     * @throws Exception
     */
    public void setUseExternalJAACProvider(boolean useJAACProvider) throws Exception {
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_JAAC_PROVIDER, getUseExternalJAACProvider());
        configureAuthorizationProvider(useJAACProvider);
        this.usingExternalJAACProvider = useJAACProvider;
    }
    
    /**
     * Configure the authorization provider
     * 
     * @param useExternalJAACProvider true to use an external JAAC provider
     * @throws Exception
     */
    protected void configureAuthorizationProvider(boolean useExternalJAACProvider) throws Exception {
        final String method = "configureAuthorizationProvider";
        Log.entering(c, method, useExternalJAACProvider);

        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_AUTH_PROVIDER, getAuthorizationProvider());
        if(this.getSecurityDomain().isAtLeast70())
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAuthorizationConfig(getSecurityDomain().getCell(), getSecurityDomain().getName(), useExternalJAACProvider, new AuthorizationProviderSettings(), getSecurityDomain().getCell().getActiveSession());
        else
            ConfigObject
                .getConfigObject(getSecurityDomain().getCell(), getSecurityDomain().getconfigObject().getConfigIdentifier(), "AuthorizationConfig")
                    .getAttributeByName("useJACCProvider").setValue(useExternalJAACProvider);
        
        Log.exiting(c, method);
    }
    
    /**
     * Get the {@link ConfigIdentifier} of this authorization configuration
     * 
     * @return The {@link ConfigIdentifier} of this authorization configuration
     * @throws Exception
     */
    protected ConfigIdentifier getAuthorizationConfig() throws Exception{
        if(this.configId == null) {
            if(this.getSecurityDomain().isAtLeast70()) {
                Cell cell = getSecurityDomain().getCell();
                String name = getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                this.configId = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getAuthorizationConfig(cell, name, session);
            } else {
                this.configId = this.getSecurityDomain().getconfigObject().getChildObjectsByDataType("AuthorizationConfig").get(0).getConfigIdentifier(); // should only be one
            }
        }
        return this.configId;
    }

    @Override
    public boolean globalSettingsInUse() throws Exception {
        return getAuthorizationConfig() == null;
    }

    @Override
    public void useGlobalDomainSettings() throws Exception {
        final String method = "useGlobalDomainSettings";
        Log.entering(c, method);
        
        if(getSecurityDomain() instanceof GlobalSecurityDomain) {
            Log.finer(c, method, "This is the global security domain. Nothing to do.");
            Log.exiting(c, method);
            return;
        }
        
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_JAAC_PROVIDER, getUseExternalJAACProvider());
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_AUTH_PROVIDER, getAuthorizationProvider());
        
        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unconfigureAuthorizationConfig(getSecurityDomain().getCell(), getSecurityDomain().getName(), getSecurityDomain().getCell().getActiveSession());
        this.configId = null;
        this.authProvider = null;
        this.usingExternalJAACProvider = null;
        
        Log.entering(c, method);
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_JAAC_PROVIDER)) {
                this.usingExternalJAACProvider = (Boolean)value;
            } else if(key.equals(CHANGE_KEY_AUTH_PROVIDER)) {
                this.authProvider = (AuthorizationProvider)value;
            }
        }
    }
    
}
