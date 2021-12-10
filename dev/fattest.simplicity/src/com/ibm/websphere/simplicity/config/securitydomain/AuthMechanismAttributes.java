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

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.ActiveSecuritySettingsWrapper;

/**
 * This class contains the various cache settings that must be applied at the domain level.
 */
public class AuthMechanismAttributes extends SecurityDomainAttribute implements Configurable {
    
    private static final Class c = AuthMechanismAttributes.class;
    private static final String CHANGE_KEY_LTPA = "ltpa";
    
    protected static final int DEFAULT_CACHE_TIMEOUT = 600;
    protected static final String AUTHENTICATION_CACHE_ENABLED = "com.ibm.websphere.security.util.authCacheEnabled";
    protected static final String AUTHENTICATION_CACHE_SIZE = "com.ibm.websphere.security.util.authCacheSize";
    protected static final String AUTHENTICATION_CACHE_MAX_SIZE = "com.ibm.websphere.security.util.authCacheMaxSize";
    protected static final String USE_CUSTOM_CACHE_KEYS = "com.ibm.websphere.security.util.authCacheCustomKeySupport";
    
    private Integer ltpaTimeout;

    /**
     * Constructor
     * 
     * @param domain The {@link SecurityDomain} parent
     */
	protected AuthMechanismAttributes(SecurityDomain domain) {
		super(domain);
	}

    /**
     * Get the LTPA timeout value. Any token that is created in the security domain when accessing
     * user applications is created with this expiration time.
     * 
     * @return The LTPA timeout value or null if there is no
     *         {@link AuthMechanismAttributes} configuraion for the domain
     * @throws Exception
     */
    public Integer getLTPATimeout() throws Exception {
        if(this.ltpaTimeout == null) {
            Cell cell = getSecurityDomain().getCell();
            if(this.getSecurityDomain() instanceof GlobalSecurityDomain && this.getSecurityDomain().isAtLeast70()) {
                String domainName = getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                this.ltpaTimeout = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getLTPATimeout(cell, domainName, session);
            } else { // 6.1 or earlier
                ConfigObject security = this.getSecurityDomain().getconfigObject();
                ArrayList<ConfigObject> authMechs = security.getChildObjectsByDataType("AuthMechanism");
                for(ConfigObject authMech : authMechs) {
                    if(authMech.getMetadata().getDataType().equals("LTPA")) {
                        this.ltpaTimeout = Integer.parseInt(authMech.getAttributeByName("timeout").getValue().toString());
                        break;
                    }
                }
            }
        }
        return new Integer(this.ltpaTimeout);
    }
    
    /**
     * Set the LTPA timeout value. Any token that is created in the security domain when accessing
     * user applications is created with this expiration time.
     * 
     * @param timeout The timeout value to set
     * @throws Exception
     */
    public void setLTPATimeout(int timeout) throws Exception {
        final String method = "setLTPATimeout";
        Log.entering(c, method, timeout);
        
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LTPA, getLTPATimeout());
        
        if(getSecurityDomain().isAtLeast70())
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().setLTPATimeout(getSecurityDomain().getCell(), getSecurityDomain().getName(), timeout, getSecurityDomain().getCell().getActiveSession());
        else {
            ConfigObject security = this.getSecurityDomain().getconfigObject();
            ArrayList<ConfigObject> authMechs = security.getChildObjectsByDataType("AuthMechanism");
            for(ConfigObject authMech : authMechs) {
                if(authMech.getMetadata().getDataType().equals("LTPA")) {
                    authMech.getAttributeByName("timeout").setValue((long)timeout);
                }
            }
        }
            
        this.ltpaTimeout = timeout;
        
        Log.exiting(c, method);
    }
    
    /**
     * Get whether or not user names returned by methods such as getUserPrincipal( ) are qualified
     * with the security realm (user registry) used by applications in the security domain.
     * 
     * @return Whether or not qualified user names are used or null if there is no
     *         {@link AuthMechanismAttributes} configuraion for the domain
     * @throws Exception
     */
    public Boolean getUseQualifiedUserNames() throws Exception {
        return getSecurityDomain().getActiveSecuritySettings().getUseDomainQualifiedUserNames();
    }
    
    /**
     * Set whether or not user names returned by methods such as getUserPrincipal( ) are qualified
     * with the security realm (user registry) used by applications in the security domain.
     * 
     * @param useQualifiedUserNames true to use qualified user names
     * @throws Exception
     */
    public void setUseQualifiedUserNames(boolean useQualifiedUserNames) throws Exception {
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setUseDomainQualifiedUserNames(useQualifiedUserNames);
        getSecurityDomain().applyActiveSecuritySettings(settings);
    }
    
    /**
     * Get whether authentication cache is enabled. When this choice is disabled, the performance is
     * impacted since whenever a user is authenticated the user registry is accessed to gather
     * information about the user, new tokens are then created for the user.
     * 
     * @return Whenter or not authentication cache is enabled
     * @throws Exception
     */
    public Boolean getAuthenticationCacheEnabled() throws Exception {
        if(!globalSettingsInUse() || getSecurityDomain() instanceof GlobalSecurityDomain) {
            String value = getSecurityDomain().getCustomProperties().get(AUTHENTICATION_CACHE_ENABLED);
            return (value == null || !value.equalsIgnoreCase("false"));
        }
        return null;
    }
    
    /**
     * Enable authentication cache. When this choice is disabled, the performance is impacted since
     * whenever a user is authenticated the user registry is accessed to gather information about
     * the user, new tokens are then created for the user.
     * 
     * @param useBasicAuthenticationCacheKeys true to cache the userName and the one-way hashed
     *            password as the key lookup in the cache. Disable this only if you do want this
     *            information to be stored in the cache. If this is disabled, every time a user logs
     *            in with userName and password, the user registry is accessed, which impacts
     *            performance.
     * @throws Exception
     */
    public void enableAuthenticationCache(boolean useBasicAuthenticationCacheKeys) throws Exception {
        // this affects ltpa timeout; lets make sure it is set to dirty
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LTPA, getLTPATimeout());

        if(getSecurityDomain().getActiveSecuritySettings().getCacheTimeout() == null) {
            ActiveSecuritySettingsWrapper settings = null;
            settings = new ActiveSecuritySettingsWrapper();
            settings.setCacheTimeout(DEFAULT_CACHE_TIMEOUT);
            getSecurityDomain().applyActiveSecuritySettings(settings);
        }
        if(!useBasicAuthenticationCacheKeys) {
            getSecurityDomain().setCustomProperty(AUTHENTICATION_CACHE_ENABLED, "BasicAuthDisabled");
        } else  {
            getSecurityDomain().setCustomProperty(AUTHENTICATION_CACHE_ENABLED, null);
        }
    }
    
    /**
     * Disable authentication cache. When this choice is disabled, the performance is impacted since
     * whenever a user is authenticated the user registry is accessed to gather information about
     * the user, new tokens are then created for the user.
     * 
     * @throws Exception
     */
    public void disableAuthenticationCache() throws Exception {
        getSecurityDomain().setCustomProperty(AUTHENTICATION_CACHE_ENABLED, "false");
    }
    
    /**
     * Get whether or not the userName and the one-way hashed password are cached as the key lookup in the cache.
     * 
     * @return true if basic authentication cache keys are used
     * @throws Exception
     */
    public Boolean getUseBasicAuthenticationCacheKeys() throws Exception {
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            String value = getSecurityDomain().getCustomProperties().get("com.ibm.websphere.security.util.authCacheEnabled");
            return (!(value != null && value.equals("BasicAuthDisabled")));
        }
        return null;
    }
    
    /**
     * Get the time period at which the authenticated credential in the cache expires.
     * 
     * @return The time period at which the authenticated credential in the cache expires or null if
     *         there is no {@link AuthMechanismAttributes} configuration for the domain.
     * @throws Exception
     */
    public Integer getCacheTimeout() throws Exception {
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            return getSecurityDomain().getActiveSecuritySettings().getCacheTimeout();
        }
        return null;
    }
    
    /**
     * Set the time period at which the authenticated credential in the cache expires.
     * 
     * @param timeout The timeout value to set
     * @throws Exception
     */
    public void setCacheTimeout(int timeout) throws Exception {
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
            settings.setCacheTimeout(timeout);
            getSecurityDomain().applyActiveSecuritySettings(settings);
        } else {
            throw new Exception("Authentication cache is not enabled.");
        }
    }
    
    /**
     * Get the initial size of the hash table caches. A higher number of available hash values might
     * decrease the occurrence of hash collisions.
     * 
     * @return The initial cache size
     * @throws Exception
     */
    public Integer getInitialCacheSize() throws Exception {
        final String method = "getInitialCacheSize";
        Log.entering(c, method);
        
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            String value = getSecurityDomain().getCustomProperties().get(AUTHENTICATION_CACHE_SIZE);
            Log.finer(c, method, "value: " + value);
            Integer ret = null;
            try {
                ret = Integer.valueOf(value);
            } catch(NumberFormatException e) {
            	// Default value for com.ibm.websphere.security.util.authCacheSize
                ret = 200;
            }
            
            Log.exiting(c, method, ret);
            return ret;
        }
        Log.exiting(c, method, null);
        return null;
    }
    
    /**
     * Set the initial size of the hash table caches. A higher number of available hash values might decrease the occurrence of hash collisions.
     * 
     * @param size The size of the cache to set
     * @throws Exception
     */
    public void setInitialCacheSize(int size) throws Exception {
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            getSecurityDomain().setCustomProperty(AUTHENTICATION_CACHE_SIZE, "" + size);
        } else {
            throw new Exception("Authentication cache is not enabled.");
        }
    }
    
    /**
     * Get the maximum size of the cache. After this limit is reached, the least used entries are
     * removed from the cache to make space for the new entries.
     * 
     * @return The maximum cache size
     * @throws Exception
     */
    public Integer getMaximumCacheSize() throws Exception {
        final String method = "getMaximumCacheSize";
        Log.entering(c, method);
        
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            String value = getSecurityDomain().getCustomProperties().get(AUTHENTICATION_CACHE_MAX_SIZE);
            Log.finer(c, method, "value: " + value);
            Integer ret = null;
            try {
                ret = Integer.valueOf(value);
            } catch(NumberFormatException e) {
            	// Default for com.ibm.websphere.security.util.authCacheMaxSize
                ret = 25000;
            }
            
            Log.exiting(c, method, ret);
            return ret;
        }
        
        Log.exiting(c, method, null);
        return null;
    }
    
    /**
     * Set the maximum size of the cache. After this limit is reached, the least used entries are
     * removed from the cache to make space for the new entries.
     * 
     * @param size The maximum size to set
     * @throws Exception
     */
    public void setMaximumCacheSize(int size) throws Exception {
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            getSecurityDomain().setCustomProperty(AUTHENTICATION_CACHE_MAX_SIZE, "" + size);
        } else {
            throw new Exception("Authentication cache is not enabled.");
        }
    }
    
    /**
     * Custom cache keys to be used as the key lookups in the authentication cache.
     * 
     * @return true if custom cache keys are being used
     * @throws Exception
     */
    public Boolean getUseCustomCacheKeys() throws Exception {
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            String value = getSecurityDomain().getCustomProperties().get(USE_CUSTOM_CACHE_KEYS);
            return !(value != null && value.equals("false"));
        }
        return null;
    }
    
    /**
     * Custom cache keys to be used as the key lookups in the authentication cache.
     * 
     * @param useCustomCacheKeys true to use custom cache keys
     * @throws Exception
     */
    public void setUseCustomCacheKeys(boolean useCustomCacheKeys) throws Exception {
        if(getAuthenticationCacheEnabled() != null && getAuthenticationCacheEnabled().equals(true)) {
            getSecurityDomain().setCustomProperty(USE_CUSTOM_CACHE_KEYS, "" + useCustomCacheKeys);
        } else {
            throw new Exception("Authentication cache is not enabled.");
        }
    }
    
    @Override
    public boolean globalSettingsInUse() throws Exception {
        return ((getSecurityDomain() instanceof GlobalSecurityDomain) 
                || (getLTPATimeout() == null && getUseQualifiedUserNames() == null && getSecurityDomain().getActiveSecuritySettings().getCacheTimeout() == null));
    }

    @Override
    public void useGlobalDomainSettings() throws Exception {
        final String method = "useGlobalDomainSettings";
        Log.entering(c, method);
        
        getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LTPA, getLTPATimeout());
        
        if(!(this.getSecurityDomain() instanceof GlobalSecurityDomain)) {
            getSecurityDomain().unsetAppActiveSecuritySettings(c);
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().setLTPATimeout(getSecurityDomain().getCell(), getSecurityDomain().getName(), null, getSecurityDomain().getCell().getActiveSession());
            this.ltpaTimeout = null;
            Map<String, String> customProps = new HashMap<String, String>();
            customProps.put(AUTHENTICATION_CACHE_ENABLED, null);
            customProps.put(AUTHENTICATION_CACHE_SIZE, null);
            customProps.put(AUTHENTICATION_CACHE_MAX_SIZE, null);
            customProps.put(USE_CUSTOM_CACHE_KEYS, null);
            getSecurityDomain().setCustomProperties(customProps);
        } else {
            Log.finer(c, method, "Nothing to do for the global domain.");
        }
        
        Log.exiting(c, method);
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_LTPA)) {
            	ltpaTimeout = (Integer)value;
            }
        }
    }
    
}
