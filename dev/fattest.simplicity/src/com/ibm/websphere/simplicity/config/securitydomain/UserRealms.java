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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.exception.NotImplementedException;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.ActiveSecuritySettingsWrapper;

/**
 * This class contains the user realm attributes for a security domain.
 *
 */
public class UserRealms extends SecurityDomainAttribute implements Configurable {
    
    private static final Class c = UserRealms.class;
    private static final String CHANGE_KEY_CUSTOM_REALM = "customRealm";
    private static final String CHANGE_KEY_LDAP_REALM = "ldapRealm";
    private static final String CHANGE_KEY_WIM_REALM = "wimRealm";
    private static final String CHANGE_KEY_LOCALOS_REALM = "localOSRealm";

    private CustomUserRealm customRegistry;
    private LocalOSUserRealm localOSRegistry;
    private LDAPUserRealm ldapRegistry;
    private WIMUserRealm wimRegistry;
    
    /**
     * Constructor
     * 
     * @param domain The {@link SecurityDomain} parent
     */
	protected UserRealms(SecurityDomain domain) {
		super(domain);
	}
	
    /**
     * Get the custom user realm (registry) configuration for the domain
     * 
     * @return The {@link CustomUserRealm} for this domain or null if the custom realm is not
     *         configured for the domain
     * @throws Exception
     */
    public CustomUserRealm getCustomRealm() throws Exception {
        if(this.customRegistry == null) {
            ConfigIdentifier configId = null;
            if(getSecurityDomain().isAtLeast70()) {
                Cell cell = this.getSecurityDomain().getCell();
                String domain = this.getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                configId = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getCustomConfigId(cell, domain, session);
            } else
                configId = getRealmConfigObject(UserRealmType.CustomUserRegistry).getConfigIdentifier();
            if(configId != null) {
                this.customRegistry = new CustomUserRealm(this, configId);
            }
        }
        return this.customRegistry;
    }

    /**
     * Get the local OS user realm (registry) configuration for the domain
     * 
     * @return The {@link LocalOSUserRealm} for this domain or null if the local OS realm is not
     *         configured for the domain
     * @throws Exception
     */
    public LocalOSUserRealm getLocalOSRealm() throws Exception {
        if(this.localOSRegistry == null) {
            ConfigIdentifier configId = null;
            if(getSecurityDomain().isAtLeast70()) {
                Cell cell = this.getSecurityDomain().getCell();
                String domain = this.getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                configId = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getLocalOSConfigId(cell, domain, session);
            } else
                configId = getRealmConfigObject(UserRealmType.LocalOSUserRegistry).getConfigIdentifier();
            if(configId != null) {
                this.localOSRegistry =   new LocalOSUserRealm(this, configId);
            }
        }
        return this.localOSRegistry;
    }
    
    /**
     * Get the LDAP user realm (registry) configuration for the domain
     * 
     * @return The {@link LDAPUserRealm} for this domain or null if the LDAP realm is not
     *         configured for the domain
     * @throws Exception
     */
    public LDAPUserRealm getLDAPRealm() throws Exception {
        if(this.ldapRegistry == null) {
            ConfigIdentifier configId = null;
            if(getSecurityDomain().isAtLeast70()) {
                Cell cell = this.getSecurityDomain().getCell();
                String domain = this.getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                configId = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getLDAPConfigId(cell, domain, session);
            } else
                configId = getRealmConfigObject(UserRealmType.LDAPUserRegistry).getConfigIdentifier();
            if(configId != null) {
                this.ldapRegistry = new LDAPUserRealm(this, configId);
            }
        }
        return this.ldapRegistry;
    }

    /**
     * Get the WIM user realm (registry) configuration for the domain
     * 
     * @return The {@link WIMUserRealm} for this domain or null if the WIM realm is not
     *         configured for the domain
     * @throws Exception
     */
    public WIMUserRealm getWIMRealm() throws Exception {
        if(this.wimRegistry == null) {
            ConfigIdentifier configId = null;
            if(getSecurityDomain().isAtLeast70()) {
                Cell cell = this.getSecurityDomain().getCell();
                String domain = this.getSecurityDomain().getName();
                AbstractSession session = cell.getWorkspace().getSession();
                configId = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getWIMConfigId(cell, domain, session);
            } else
                configId = getRealmConfigObject(UserRealmType.WIMUserRegistry).getConfigIdentifier();
            if(configId != null) {
                this.wimRegistry = new WIMUserRealm(this, configId);
            }
        }
        return this.wimRegistry;
    }
    
    /**
     * Get the current active realm for the domain
     * 
     * @return The currently active {@link UserRealm} or null if there is no current realm
     *         configuration for the domain
     * @throws Exception
     */
    public UserRealm getActiveUserRealm() throws Exception {
        String activeString = getSecurityDomain().getActiveSecuritySettings().getActiveUserRegistry();
        if(activeString != null) {
            UserRealmType active = UserRealmType.valueOf(activeString);
            if(active == UserRealmType.CustomUserRegistry) {
                return getCustomRealm();
            }
            if(active == UserRealmType.LocalOSUserRegistry) {
                return getLocalOSRealm();
            }
            if(active == UserRealmType.LDAPUserRegistry) {
                return getLDAPRealm();
            }
            if(active == UserRealmType.WIMUserRegistry) {
                return getWIMRealm();
            }
        }
        return null;
    }
    
    /**
     * Make a user realm active for this domain. The user realm must first be configured.
     * 
     * @param type The type of the realm to make active
     * @throws Exception
     */
    public void setActiveUserRealm(UserRealmType type) throws Exception {
        ActiveSecuritySettingsWrapper settings = new ActiveSecuritySettingsWrapper();
        settings.setActiveUserRegistry(type.toString());
        getSecurityDomain().applyActiveSecuritySettings(settings);
    }
    
    /**
     * Configure a user realm for the domain. When calling this method, if the registry of the
     * specified type is already configured, the internal pointer to the realm is reset. Use this
     * method to configure a realm for the first time or to completely reset the realm. To simply
     * change attributes on an existing configured realm, use the getter methods of this class such
     * as {@link #getLDAPRealm()} to get the configured realm and fine tune the attributes of the
     * realm.<br/><br/> 
     * 
     * When configuring a realm in the global domain, use one of the Admin* sub
     * classes of {@link UserRealmSettings} (ex: {@link AdminLDAPSettings}). When configuring a
     * realm in an application security domain, use of of the Domain* sub classes of
     * {@link UserRealmSettings} (ex: {@link DomainLDAPSettings}). These objects have different
     * settings available that are valid for the domain that is being configured.
     * 
     * @param type The type of realm to configure
     * @param settings The settings to use when configuring the realm
     * @throws Exception
     */
    public void configureRealm(UserRealmType type, UserRealmSettings settings) throws Exception {
        if((settings instanceof AdminUserRegistrySettings) && ((((AdminUserRegistrySettings)settings).getPrimaryAdminId() == null) || (((AdminUserRegistrySettings)settings).getPrimaryAdminId().length() == 0)))
            throw new Exception("Primary admin ID must be specified.");
        
    	switch(type) {
    		case CustomUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM_REALM, getCustomRealm());
    			break;
    		case LDAPUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LDAP_REALM, getLDAPRealm());
    			break;
    		case LocalOSUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LOCALOS_REALM, getLocalOSRealm());
    			break;
    		case WIMUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_WIM_REALM, getWIMRealm());
    			break;
    	}

        configureUserRealm(type, settings, true);
        
        switch(type) {
        	case CustomUserRegistry:
                this.customRegistry = null;
        		break;
        	case LDAPUserRegistry:
                this.ldapRegistry = null;
        		break;
        	case LocalOSUserRegistry:
                this.localOSRegistry = null;
        		break;
        	case WIMUserRegistry:
                this.wimRegistry = null;
        		break;
        }
    }

    /**
     * Configure the WIM user realm for the domain. This method use the primary admin Id and
     * fileRegistryPassword to create a file registry account needed for WIM prior to configuring
     * the WIM realm. When calling this method, if the WIM realm is already configured, the internal
     * pointer to the realm is reset. Use this method to the realm for the first time or to
     * completely reset the realm. To simply change attributes of the configured realm, use the
     * {@link #getWIMRealm()} method to get the configured realm and fine tune the attributes of the
     * realm.<br/><br/>
     * 
     * When configuring a realm in the global domain, use one of the Admin* sub
     * classes of {@link UserRealmSettings} (ex: {@link AdminWIMSettings}). When configuring a
     * realm in an application security domain, use of of the Domain* sub classes of
     * {@link UserRealmSettings} (ex: {@link DomainWIMSettings}). These objects have different
     * settings available that are valid for the domain that is being configured.
     * 
     * @param settings The WIM user realm settings
     * @param fileRegistryPassword The password to use when creating the file registry account
     * @throws Exception
     */
    public void configureRealm(AdminWIMSettings settings, String fileRegistryPassword) throws Exception {
        final String method = "configureRegistry";
        Log.entering(c, method, new Object[]{settings, fileRegistryPassword});
        
        if(settings.getPrimaryAdminId() == null || settings.getPrimaryAdminId().length() == 0)
            throw new Exception("Primary admin ID must be specified.");
        
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_WIM_REALM, getWIMRealm());

        Log.finer(c, method, "Creating the file registry account.");
        final Cell fcell = getSecurityDomain().getCell();
        final String fuser = settings.getPrimaryAdminId();
        final String fpassword = fileRegistryPassword;
        try {
            OperationsProviderFactory.getProvider().getSecurityOperationsProvider().addFileRegistryAccount(fcell, fuser, fpassword, fcell.getActiveSession());
        } catch (Exception e) {
            if (e.getMessage().indexOf("An entity with same unique name") != -1) {
                // if we got an exception adding the the same user, ignore it
                Log.finer(c, method, "User registry account is already created.");
            } else {
                throw e;
            }
        }
        configureRealm(UserRealmType.WIMUserRegistry, settings);
        this.wimRegistry = null;
        
        Log.exiting(c, method);
    }
    
    /**
     * Remove a configuration for a realm from the domain.
     * 
     * @param type The type of realm to remove from the domain
     * @throws Exception
     */
    public void unconfigureRealm(UserRealmType type) throws Exception {
        final String method = "unconfigureRegistry";
        Log.entering(c, method, type);
        
    	switch(type) {
    		case CustomUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM_REALM, getCustomRealm());
    			break;
    		case LDAPUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LDAP_REALM, getLDAPRealm());
    			break;
    		case LocalOSUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LOCALOS_REALM, getLocalOSRealm());
    			break;
    		case WIMUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_WIM_REALM, getWIMRealm());
    			break;
    	}

        final Cell fcell = getSecurityDomain().getCell();
        final String fname = getSecurityDomain().getName();
        final UserRealmType ftype = type;
        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unconfigureUserRegistry(fcell, fname, ftype, fcell.getActiveSession());
        Log.finer(c, method, "Registry unconfigured successfully.");

        switch(type) {
        	case CustomUserRegistry:
                this.customRegistry = null;
        		break;
        	case LDAPUserRegistry:
                this.ldapRegistry = null;
        		break;
        	case LocalOSUserRegistry:
                this.localOSRegistry = null;
        		break;
        	case WIMUserRegistry:
                this.wimRegistry = null;
        		break;
        }
        Log.exiting(c, method);
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
        
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM_REALM, getCustomRealm());
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LDAP_REALM, getLDAPRealm());
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LOCALOS_REALM, getLocalOSRealm());
        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_WIM_REALM, getWIMRealm());

        // first unset the active registry
        getSecurityDomain().unsetAppActiveSecuritySettings(c);
        // next unconfigure all the domains
        unconfigureRealm(UserRealmType.CustomUserRegistry);
        unconfigureRealm(UserRealmType.LocalOSUserRegistry);
        unconfigureRealm(UserRealmType.LDAPUserRegistry);
        unconfigureRealm(UserRealmType.WIMUserRegistry);
        // last unconfigure the trusted realms
        unconfigureTrustedRealms(true);
        unconfigureTrustedRealms(false);
        Log.exiting(c, method);
    }

    @Override
    public boolean globalSettingsInUse() throws Exception {
        return ((getSecurityDomain() instanceof GlobalSecurityDomain) || (getActiveUserRealm() == null));
    }
    
    /*
     * Not caching trusted realms at the moment
     */
    /**
     * Get the names of the trusted realms for this domain. This realm will accept messages from
     * trusted realms and will not accept messages from untrusted realms.
     * 
     * @param inbound true to get the realms that are granted inbound trust, false for outbound
     * @return A Set containing the names of the trusted realms for the domain
     */
    public Set<String> getTrustedRealmNames(boolean inbound) throws Exception {
        final String method = "getTrustedRealmNames";
        Log.entering(c, method, inbound);
        
        if(!getSecurityDomain().isAtLeast70())
            throw new Exception("Trusted realms are supported on WAS70 or later.");
        
        CommunicationType communicationType = (inbound ? CommunicationType.INBOUND : CommunicationType.OUTBOUND);
        Cell cell = getSecurityDomain().getCell();
        String name = getSecurityDomain().getName();
        AbstractSession session = cell.getWorkspace().getSession();
        Set<String> trustedRealms = OperationsProviderFactory.getProvider().getSecurityOperationsProvider().getTrustedRealms(cell, communicationType, name, session);
        
        Log.exiting(c, method, trustedRealms);
        return trustedRealms;
    }
    
    /**
     * Add trusted realms for this domain. This realm will accept messages from trusted realms and
     * will not accept messages from untrusted realms.
     * 
     * @param inbound true to add realms that are granted inbound trust, false for outbound
     * @param realms A Set containing the names of the realms to add trust for
     * @throws Exception
     */
    public void addTrustedRealms(boolean inbound, Set<String> realms) throws Exception {
        final String method = "addTrustedRealms";
        Log.entering(c, method, new Object[]{inbound, realms});
        
        if(!getSecurityDomain().isAtLeast70())
            throw new Exception("Trusted realms are supported on WAS70 or later.");
        
        final Cell fcell = getSecurityDomain().getCell();
        final CommunicationType ftype = (inbound ? CommunicationType.INBOUND : CommunicationType.OUTBOUND);
        final Set<String> frealms = realms;
        final String fname = getSecurityDomain().getName();
        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().addTrustedRealms(fcell, ftype, frealms, fname, fcell.getActiveSession());
        
        Log.exiting(c, method);
    }
    
    /**
     * Remove trusted realms from this domain. This realm will accept messages from trusted realms
     * and will not accept messages from untrusted realms.
     * 
     * @param inbound true to remove realms that are granted inbound trust, false for outbound
     * @param realms A Set containing the names of the realms to remove trust for
     * @throws Exception
     */
    public void removeTrustedRealms(boolean inbound, Set<String> realms) throws Exception {
        final String method = "removeTrustedRealms";
        Log.entering(c, method, new Object[]{inbound, realms});
        
        if(!getSecurityDomain().isAtLeast70())
            throw new Exception("Trusted realms are supported on WAS70 or later.");
        
        final Cell fcell = getSecurityDomain().getCell();
        final CommunicationType ftype = (inbound ? CommunicationType.INBOUND : CommunicationType.OUTBOUND);
        final Set<String> frealms = realms;
        final String fname = getSecurityDomain().getName();
        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().removeTrustedRealms(fcell, ftype, frealms, fname, fcell.getActiveSession());

        Log.exiting(c, method);
    }
    
    /**
     * Remove the trusted realm configuration for the domain.
     * 
     * @param inbound true to remove inbound trust configuration, false for outbound
     * @throws Exception
     */
    private void unconfigureTrustedRealms(boolean inbound) throws Exception {
        final String method = "unconfigureTrustedRealms";
        Log.entering(c, method, inbound);
        
        if(!getSecurityDomain().isAtLeast70())
            throw new Exception("Trusted realms are supported on WAS70 or later.");
        
        final Cell fcell = getSecurityDomain().getCell();
        final CommunicationType ftype = (inbound ? CommunicationType.INBOUND : CommunicationType.OUTBOUND);
        final String fname = getSecurityDomain().getName();
        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().unconfigureTrustedRealms(fcell, ftype, fname, fcell.getActiveSession());
        

        Log.exiting(c, method);
    }
    
    /**
     * Configure a 6.1 realm
     * 
     * @param type type of realm
     * @param settings realm settings
     * @param newConfig whether or not this is a new configuration
     * @throws Exception
     */
    protected void configureRealm(UserRealmType type, UserRealmSettings csettings, boolean newConfig) throws Exception {
        ConfigObject reg = getRealmConfigObject(type);
        if(csettings.getPrimaryAdminId() != null) {
            reg.getAttributeByName("primaryAdminId").setValue(csettings.getPrimaryAdminId());
        }
        if(type == UserRealmType.CustomUserRegistry && csettings.getCustomProperties() != null)
            reg.getAttributeByName("customRegistryClassName").setValue(((AdminCustomSettings)csettings).getCustomRegistryClass());
        if(csettings.getAutoGenerateServerId() != null && csettings.getAutoGenerateServerId()) {
            reg.getAttributeByName("serverId").setValue("simplicity_" + new Date().getTime());
            reg.getAttributeByName("serverPassword").setValue("simplicity_" + new Date().getTime());
            reg.getAttributeByName("useRegistryServerId").setValue(false);
        } else
            reg.getAttributeByName("useRegistryServerId").setValue(true);
        if(csettings.getCustomProperties() != null && csettings.getCustomProperties().size() > 0) {
            List<ConfigObject> currentProps = reg.getChildObjectsByDataType("Property");
            Map<String, String> propsToSet = new HashMap<String, String>(csettings.getCustomProperties());
            String name = null;
            ConfigObject value = null;
            ConfigObject next = null;
            for(ConfigObject current : currentProps) {
                name = current.getAttributeByName("name").getValueAsString();
                value = current.getAttributeByName("value");
                if(propsToSet.containsKey(name)) {
                    if(propsToSet.get(name) == null) {
                        // property has been deleted
                        current.delete();
                    } else if(!value.getValueAsString().equals(propsToSet.get(name))) {
                        // value has changed
                        value.setValue(propsToSet.get(name));
                    } // else they set the property with the same value as before
                    propsToSet.remove(name); // we're done with it
                } // property not being altered
            }
            // anything left over is new
            for(String newProp : propsToSet.keySet()) {
                next = ConfigObject.createConfigObject(getSecurityDomain().getCell(), "Property", reg);
                next.getAttributeByName("name").setValue(newProp);
                next.getAttributeByName("value").setValue(propsToSet.get(newProp));
                next.getAttributeByName("required").setValue(false);
            }
        }
        if(csettings.getIgnoreCase() != null) {
            reg.getAttributeByName("ignoreCase").setValue(csettings.getIgnoreCase());
        }
        if(csettings.getServerId() != null) {
            reg.getAttributeByName("serverId").setValue(csettings.getServerId());
        }
        if(csettings.getServerIdPassword() != null) {
            reg.getAttributeByName("serverPassword").setValue(csettings.getServerIdPassword());
        }
        if(type == UserRealmType.LDAPUserRegistry) {
            LDAPSettings ldapSettings = (LDAPSettings)csettings;
            ConfigObject searchFilter = reg.getChildObjectListByName("searchFilter").get(0);
            ConfigObject hosts = reg.getChildObjectListByName("hosts").get(0);
            if(ldapSettings.getBaseDN() != null) {
                reg.getAttributeByName("baseDN").setValue(ldapSettings.getBaseDN());
            }
            if(ldapSettings.getBindDN() != null) {
                reg.getAttributeByName("bindDN").setValue(ldapSettings.getBindDN());
            }
            if(ldapSettings.getBindDN() != null) {
                reg.getAttributeByName("bindDN").setValue(ldapSettings.getBindDN());
            }
            if(ldapSettings.getCertificateFilter() != null) {
                searchFilter.getAttributeByName("certificateFilter").setValue(ldapSettings.getCertificateFilter());
            }
            if(ldapSettings.getCertificateMapMode() != null) {
                searchFilter.getAttributeByName("certificateMapMode").setValue(ldapSettings.getCertificateMapMode());
            }
            if(ldapSettings.getGroupFilter() != null) {
                searchFilter.getAttributeByName("groupFilter").setValue(ldapSettings.getGroupFilter());
            }
            if(ldapSettings.getGroupIdMap() != null) {
                searchFilter.getAttributeByName("groupIdMap").setValue(ldapSettings.getGroupIdMap());
            }
            if(ldapSettings.getGroupMemberIdMap() != null) {
                searchFilter.getAttributeByName("groupMemberIdMap").setValue(ldapSettings.getGroupMemberIdMap());
            }
            if(ldapSettings.getLdapHost() != null) {
                hosts.getAttributeByName("host").setValue(ldapSettings.getLdapHost());
            }
            if(ldapSettings.getLdapPort() != null) {
                hosts.getAttributeByName("port").setValue(ldapSettings.getLdapPort());
            }
            if(ldapSettings.getReuseConnection() != null) {
                reg.getAttributeByName("reuseConnection").setValue(ldapSettings.getReuseConnection());
            }
            if(ldapSettings.getSearchTimeout() != null) {
                reg.getAttributeByName("searchTimeout").setValue((long)ldapSettings.getSearchTimeout());
            }
            if(ldapSettings.getSslConfig() != null) {
                reg.getAttributeByName("sslConfig").setValue(ldapSettings.getSslConfig());
            }
            if(ldapSettings.getSslEnabled() != null) {
                reg.getAttributeByName("sslEnabled").setValue(ldapSettings.getSslEnabled());
            }
            if(ldapSettings.getUserFilter() != null) {
                searchFilter.getAttributeByName("userFilter").setValue(ldapSettings.getUserFilter());
            }
            if(ldapSettings.getUserIdMap() != null) {
                searchFilter.getAttributeByName("userIdMap").setValue(ldapSettings.getUserIdMap());
            }
            if(ldapSettings.getLdapType() != null) {
                reg.getAttributeByName("type").setValue(ldapSettings.getLdapType().toString());
            }
        }
        if(csettings.getRealmName() != null) {
            reg.getAttributeByName("realm").setValue(csettings.getRealmName());
        }  else if(!(csettings instanceof AdminCustomSettings) && !(csettings instanceof DomainCustomSettings)) {
            String realm = reg.getAttributeByName("realm").getValueAsString();
            if(realm.trim().length() == 0) {
                String realmName = null;
                if((csettings instanceof AdminLDAPSettings) || (csettings instanceof DomainLDAPSettings)) {
                    LDAPSettings ldapSettings = (LDAPSettings)csettings;
                    realmName = ldapSettings.getLdapHost()+":"+ldapSettings.getLdapPort();
                } else if((csettings instanceof AdminLocalOSSettings) || (csettings instanceof DomainLocalOSSettings)) {
                    realmName = "localOSRealm_"+(new Date()).getTime();
                } else { // federated repositories
                    realmName = "defaultWIMFileBasedRealm";
                }
                reg.getAttributeByName("realm").setValue(realmName);
            }
        }
        if(csettings.getVerifyRegistry() != null && csettings.getVerifyRegistry()) {
            throw new NotImplementedException("verifyRegistry is not implemented for WAS 6.1 and earlier. Please send information on how to do this and open a bug in bugzilla.");
        }
    }

    /**
     * Configure a user realm for the domain
     * 
     * @param type The type of user realm to configure
     * @param settings The user realm settings
     * @throws Exception
     */
    protected void configureUserRealm(UserRealmType type, UserRealmSettings settings, boolean newConfig) throws Exception {
        final String method = "configureUserRealm";
        Log.entering(c, method, new Object[]{type, settings});
        
        if((domain instanceof GlobalSecurityDomain)) {
            if(type == UserRealmType.CustomUserRegistry && !(settings instanceof AdminCustomSettings))  {
                throw new IllegalArgumentException("The global security domain custom registry can only be configured using AdminCustomSettings.");
            } else if(type == UserRealmType.LocalOSUserRegistry && !(settings instanceof AdminLocalOSSettings))  {
                throw new IllegalArgumentException("The global security domain local OS registry can only be configured using AdminLocalOSSettings.");
            } else if(type == UserRealmType.LDAPUserRegistry && !(settings instanceof AdminLDAPSettings))  {
                throw new IllegalArgumentException("The global security domain LDAP registry can only be configured using AdminLDAPSettings.");
            } else if(type == UserRealmType.WIMUserRegistry && !(settings instanceof AdminWIMSettings))  {
                throw new IllegalArgumentException("The global security domain WIM registry can only be configured using AdminWIMSettings.");
            } 
        }
        if(!(domain instanceof GlobalSecurityDomain)) {
            if(type == UserRealmType.CustomUserRegistry && !(settings instanceof DomainCustomSettings)) {
                throw new IllegalArgumentException("A non-global security domain custom registry can only be configured using DomainCustomSettings.");
            } else if(type == UserRealmType.LocalOSUserRegistry && !(settings instanceof DomainLocalOSSettings)) {
                throw new IllegalArgumentException("A non-global security domain local OS registry can only be configured using DomainLocalOSSettings.");
            } else if(type == UserRealmType.LDAPUserRegistry && !(settings instanceof DomainLDAPSettings)) {
                throw new IllegalArgumentException("A non-global security domain LDAP registry can only be configured using DomainLDAPSettings.");
            } else if(type == UserRealmType.WIMUserRegistry && !(settings instanceof DomainWIMSettings)) {
                throw new IllegalArgumentException("A non-global security domain WIM registry can only be configured using DomainWIMSettings.");
            }
        }
        
        final Cell fcell = domain.getCell();
        final String fname = domain.getName();
        final UserRealmSettings fsettings = settings;

        switch(type) {
    		case CustomUserRegistry:
    	        this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOM_REALM, getCustomRealm());
                
    	        if(domain instanceof GlobalSecurityDomain) {
                    Log.finer(c, method, "Configuring the custom user registry for the global domain.");
                    if(getSecurityDomain().isAtLeast70())
                        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAdminCustomUserRegistry(fcell, (AdminCustomSettings)fsettings, fcell.getActiveSession());
                    else
                        configureRealm(type, settings, newConfig);
                } else {
                    Log.finer(c, method, "Configuring the custom user registry for the domain " + domain.getName() + ".");
                    OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAppCustomUserRegistry(fcell, fname, (DomainCustomSettings)fsettings, fcell.getActiveSession());
                }
    			break;
    		case LDAPUserRegistry:
                this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LDAP_REALM, getLDAPRealm());

                if(domain instanceof GlobalSecurityDomain) {
                    Log.finer(c, method, "Configuring the LDAP user registry for the global domain.");
                    if(getSecurityDomain().isAtLeast70())
                        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAdminLDAPUserRegistry(fcell, (AdminLDAPSettings)fsettings, fcell.getActiveSession());
                    else
                        configureRealm(type, settings, newConfig);
                } else {
                    Log.finer(c, method, "Configuring the LDAP user registry for the domain " + domain.getName() + ".");
                    OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAppLDAPUserRegistry(fcell, fname, (DomainLDAPSettings)fsettings, fcell.getActiveSession());
                }
    			break;
    		case LocalOSUserRegistry:
                this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LOCALOS_REALM, getLocalOSRealm());

                if(domain instanceof GlobalSecurityDomain) {
                    Log.finer(c, method, "Configuring the local OS user registry for the global domain.");
                    if(getSecurityDomain().isAtLeast70())
                        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAdminLocalOSUserRegistry(fcell, (AdminLocalOSSettings)fsettings, fcell.getActiveSession());
                    else
                        configureRealm(type, settings, newConfig);
                } else {
                    Log.finer(c, method, "Configuring the local OS user registry for the domain " + domain.getName() + ".");
                    OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAppLocalOSUserRegistry(fcell, fname, (DomainLocalOSSettings)fsettings, fcell.getActiveSession());
                }
    			break;
    		case WIMUserRegistry:
                this.domain.getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_WIM_REALM, getWIMRealm());

                if(domain instanceof GlobalSecurityDomain) {
                    Log.finer(c, method, "Configuring the WIM user registry for the global domain.");
                    if(getSecurityDomain().isAtLeast70())
                        OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAdminWIMUserRegistry(fcell, (AdminWIMSettings)fsettings, fcell.getActiveSession());
                    else
                        configureRealm(type, settings, newConfig);
                } else {
                    Log.finer(c, method, "Configuring the WIM user registry for the global domain.");
                    OperationsProviderFactory.getProvider().getSecurityOperationsProvider().configureAppWIMUserRegistry(fcell, fname, (DomainWIMSettings)fsettings, fcell.getActiveSession());
                }
    			break;
    	}

        Log.exiting(c, method);
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_CUSTOM_REALM)) {
                this.customRegistry = (CustomUserRealm)value;
            } else if(key.equals(CHANGE_KEY_LOCALOS_REALM)) {
                this.localOSRegistry = (LocalOSUserRealm)value;
            } else if(key.equals(CHANGE_KEY_LDAP_REALM)) {
                this.ldapRegistry = (LDAPUserRealm)value;
            } else if(key.equals(CHANGE_KEY_WIM_REALM)) {
                this.wimRegistry = (WIMUserRealm)value;
            }
        }
    } 
    
    protected ConfigObject getRealmConfigObject(UserRealmType type) throws Exception {
        List<ConfigObject> realms = getSecurityDomain().getconfigObject().getChildObjectsByDataType("UserRegistry");
        for(ConfigObject realm : realms) {
            if(realm.getMetadata().getDataType().equals(type.toString())) {
                return realm;
            }
        }
        return null;
    }
}
