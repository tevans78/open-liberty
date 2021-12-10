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

package com.ibm.websphere.simplicity.provider.websphere;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ibm.websphere.simplicity.AbstractSession;
import com.ibm.websphere.simplicity.ConfigIdentifier;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.commands.securityconfiguration.GetCSIInboundInfo;
import com.ibm.websphere.simplicity.commands.securityconfiguration.GetCSIOutboundInfo;
import com.ibm.websphere.simplicity.config.securitydomain.AdminCustomSettings;
import com.ibm.websphere.simplicity.config.securitydomain.AdminLDAPSettings;
import com.ibm.websphere.simplicity.config.securitydomain.AdminLocalOSSettings;
import com.ibm.websphere.simplicity.config.securitydomain.AdminWIMSettings;
import com.ibm.websphere.simplicity.config.securitydomain.CSIInboundSettings;
import com.ibm.websphere.simplicity.config.securitydomain.CSIOutboundSettings;
import com.ibm.websphere.simplicity.config.securitydomain.CommunicationType;
import com.ibm.websphere.simplicity.config.securitydomain.DomainCustomSettings;
import com.ibm.websphere.simplicity.config.securitydomain.DomainLDAPSettings;
import com.ibm.websphere.simplicity.config.securitydomain.DomainLocalOSSettings;
import com.ibm.websphere.simplicity.config.securitydomain.DomainWIMSettings;
import com.ibm.websphere.simplicity.config.securitydomain.InterceptorSettings;
import com.ibm.websphere.simplicity.config.securitydomain.JAASJ2CAuthenticationEntrySettings;
import com.ibm.websphere.simplicity.config.securitydomain.JAASLogin;
import com.ibm.websphere.simplicity.config.securitydomain.JAASLoginType;
import com.ibm.websphere.simplicity.config.securitydomain.LoginModuleSettings;
import com.ibm.websphere.simplicity.config.securitydomain.UserRealmType;
import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.ActiveSecuritySettingsWrapper;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.AuthorizationProviderSettings;
import com.ibm.websphere.simplicity.provider.websphere.config.securitydomain.TrustAssociationWrapper;
import com.ibm.websphere.simplicity.provider.websphere.config.usersgroups.UserAttributes;

/**
 * Provides security operation methods
 */
public abstract class SecurityOperationsProvider extends CategorizedOperationsBase {
    
    /**
     * Constructor
     * 
     * @param parent Parent {@link WebSphereOperationsProvider}
     */
    public SecurityOperationsProvider(WebSphereOperationsProvider parent) {
        super(parent);
    }
    
    /**
     * Get the active security settings for the global domain.
     * 
     * @param key The Scope to use for reference
     * @param session Session currently in use
     * @return An {@link ActiveSecuritySettingsWrapper} containing the current acive security settings for the global domain.
     * @throws Exception
     */
    public abstract ActiveSecuritySettingsWrapper getGlobalActiveSecuritySettings(Scope key, AbstractSession session) throws Exception;
    /**
     * Get the active security settings for a specific security domain.
     * 
     * @param key The Scope to use for reference
     * @param domainName The name of the domain to retrieve the settings for
     * @param session Session currently in use
     * @return An {@link ActiveSecuritySettingsWrapper} containing the current acive security settings for the domain.
     * @throws Exception
     */
    public abstract ActiveSecuritySettingsWrapper getDomainActiveSecuritySettings(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Set the active security settings for a security domain
     * 
     * @param key The Scope to use for reference
     * @param domainName The name of the domain to set the settings for
     * @param settings The settings to set
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> setAppActiveSecuritySettings(Scope key, String domainName, ActiveSecuritySettingsWrapper settings, AbstractSession session) throws Exception;
    /**
     * Set the active security settings for the global security domain
     * 
     * @param key The Scope to use for reference
     * @param settings The settings to set
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> setAdminActiveSecuritySettings(Scope key, ActiveSecuritySettingsWrapper settings, AbstractSession session) throws Exception;
    /**
     * Unset the active security settings for a domain. This method results in the domain reverting to the global domain settings.
     * 
     * @param key The Scope to use for reference
     * @param domainName The name of the domain to unset the settings for
     * @param securityAttribute The Class of the security attribute to unset
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unsetAppActiveSecuritySettings(Scope key, String domainName, Class securityAttribute, AbstractSession session) throws Exception;
    /**
     * Configure a custom user registry for a security domain
     * 
     * @param key The Scope to use for reference
     * @param domainName The name of the domain to configure the custom registry for
     * @param settings The custom user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAppCustomUserRegistry(Scope key, String domainName, DomainCustomSettings settings, AbstractSession session) throws Exception;
    /**
     * Configure a custom user registry for the global security domain
     * 
     * @param key The Scope to use for reference
     * @param settings The custom user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAdminCustomUserRegistry(Scope key, AdminCustomSettings settings, AbstractSession session) throws Exception;
    /**
     * Configure a local OS user registry for the global security domain
     * 
     * @param key The Scope to use for reference
     * @param settings The local OS user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAdminLocalOSUserRegistry(Scope key, AdminLocalOSSettings settings, AbstractSession session) throws Exception;
    /**
     * Configure a local OS user registry for a security domain
     * 
     * @param key The Scope to use for reference
     * @param domainName The name of the domain to configure the local OS registry for
     * @param settings The local OS user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAppLocalOSUserRegistry(Scope key, String domainName, DomainLocalOSSettings settings, AbstractSession session) throws Exception;
    /**
     * Configure an LDAP user registry for the global security domain
     * 
     * @param key The Scope to use for reference
     * @param settings The LDAP user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAdminLDAPUserRegistry(Scope key, AdminLDAPSettings settings, AbstractSession session) throws Exception;
    /**
     * Configure an LDAP user registry for a security domain
     * 
     * @param key The Scope to use for reference
     * @param domainName The name of the domain to configure the LDAP registry for
     * @param settings The LDAP user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAppLDAPUserRegistry(Scope key, String domainName, DomainLDAPSettings settings, AbstractSession session) throws Exception;
    /**
     * Configure a WIM user registry for the global security domain
     * 
     * @param key The Scope to use for reference
     * @param settings The WIM user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAdminWIMUserRegistry(Scope key, AdminWIMSettings settings, AbstractSession session) throws Exception;
    /**
     * Configure a WIM user registry for a security domain
     * 
     * @param key The Scope to use for reference
     * @param domainName The name of the domain to configure the WIM registry for
     * @param settings The WIM user registry settings
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAppWIMUserRegistry(Scope key, String domainName, DomainWIMSettings settings, AbstractSession session) throws Exception;
    /**
     * Create a file registry account for WIM
     * 
     * @param key The scope to use for reference
     * @param userId The user id to create the account with
     * @param password The password for the user
     * @param session Session currently in use
     * @return The results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> addFileRegistryAccount(Scope key, String userId, String password, AbstractSession session) throws Exception;
    /**
     * Get the config id for an LDAP user registry
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the registry from or null for the global domain
     * @param session Session currently in use
     * @return The {@link ConfigIdentifier} of the LDAP registry or null if the registry does not exist
     * @throws Exception
     */
    public abstract ConfigIdentifier getLDAPConfigId(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Get the config id for a custom user registry
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the registry from or null for the global domain
     * @param session Session currently in use
     * @return The {@link ConfigIdentifier} of the custom registry or null if the registry does not exist
     * @throws Exception
     */
    public abstract ConfigIdentifier getCustomConfigId(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Get the config id for a local OS user registry
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the registry from or null for the global domain
     * @param session Session currently in use
     * @return The {@link ConfigIdentifier} of the local OS registry or null if the registry does not exist
     * @throws Exception
     */
    public abstract ConfigIdentifier getLocalOSConfigId(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Get the config id for a WIM user registry
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the registry from or null for the global domain
     * @param session Session currently in use
     * @return The {@link ConfigIdentifier} of the WIM registry or null if the registry does not exist
     * @throws Exception
     */
    public abstract ConfigIdentifier getWIMConfigId(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Unconfigure a user registry from a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to unconfigure the registry in
     * @param type The type of registry to unconfigure
     * @return An {@link OperationResults} containing the results of the command
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unconfigureUserRegistry(Scope key, String domainName, UserRealmType type, AbstractSession session) throws Exception;
    /**
     * Get the trust association information for a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the info from or null for the global domain
     * @param session Session currently in use
     * @return A {@link TrustAssociationWrapper} containing the information or null if there is no configuration
     * @throws Exception
     */
    public abstract TrustAssociationWrapper getTrustAssocationInfo(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Configure trust association for a domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to configure or null for the global domain
     * @param settings The settings to configure
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureTrustAssociation(Scope key, String domainName, TrustAssociationWrapper settings, AbstractSession session) throws Exception;
    /**
     * Remove a trust association configuration for a domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to unconfigure
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unconfigureTrustAssociation(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Get the JAAS login entries for a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the entries from or null for the global domain
     * @param type The type of entries to get
     * @param session Session currently in use
     * @return A Set of JAAS login entry {@link ConfigIdentifier}s or null if there is no configuration
     * @throws Exception
     */
    public abstract Set<ConfigIdentifier> getJAASLoginEntries(Scope key, String domainName, JAASLoginType type, AbstractSession session) throws Exception;
    /**
     * Configure a JAAS login module
     * 
     * @param key The Scope to use for reference
     * @param login The {@link JAASLogin} parent
     * @param domainName The name of the domain to configure the module in or null for the global domain
     * @param options The options to use when creating the login module
     * @param session The Session currently in use
     * @return An {@link OperationResults} with the results of the configuration
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureJAASLoginModule(Scope key, JAASLogin login, String domainName, LoginModuleSettings options, AbstractSession session) throws Exception;
    /**
     * Remove a JAAS login module configuraion from a JAAS login
     * 
     * @param key The scope to use for reference
     * @param login The {@link JAASLogin} parent
     * @param moduleClassName The class name of the module to remove
     * @param domainName The name fo the domain to remove the module from or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unconfigureJAASLoginModule(Scope key, JAASLogin login, String moduleClassName, String domainName, AbstractSession session) throws Exception;
    /**
     * Configure a JAAS login
     * 
     * @param key The scope to use as reference
     * @param alias The JAAS login alias
     * @param type The type of JAAS login
     * @param domainName The name of the domain that the login resides or null for the global domain
     * @param loginModules A list of modules to specify order
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the configuration
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureJAASLogin(Scope key, String alias, JAASLoginType type, String domainName, List<String> loginModules, AbstractSession session) throws Exception;
    /**
     * Remove JAAS configurations from a security domain
     * 
     * @param key The scope to use as reference
     * @param type The type of JAAS login
     * @param domainName The name of the domain that the login resides or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unconfigureJAASLogin(Scope key, JAASLoginType type, String domainName, AbstractSession session) throws Exception;
    /**
     * Remove a JAAS login entry from the configuration
     * 
     * @param key The scope to use as reference
     * @param alias The JAAS login entry alias
     * @param type The type of login
     * @param domainName The name of the domain that the login resides or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} wih the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unconfigureJAASLoginEntry(Scope key, String alias, JAASLoginType type, String domainName, AbstractSession session) throws Exception;
    /**
     * Get the {@link ConfigIdentifier}s for the JAAS J2C authentication data entries for a domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the entries form or null for the global domain
     * @param session Session currently in use
     * @return A Set of {@link ConfigIdentifier}s or null of no J2C authentication data entries exist
     * @throws Exception
     */
    public abstract Set<ConfigIdentifier> getAuthDataEntries(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Create a JAAS J2C authentication data entry
     * 
     * @param key The scope to use for reference
     * @param settings The settings to use when creating the entry
     * @param domainName The name of the domain to create the entry in or null for the global domain
     * @param session Session currently in use
     * @return The {@link ConfigIdentifier} of the new authentication data entry
     * @throws Exception
     */
    public abstract OperationResults<ConfigIdentifier> createAuthenticationDataEntry(Scope key, JAASJ2CAuthenticationEntrySettings settings, String domainName, AbstractSession session) throws Exception;
    /**
     * Delete a JAAS J2C authentication data entry
     * 
     * @param key The scope to use for reference
     * @param alias The alias of the authentication entry to delete
     * @param domainName The name of the domain to delete the entry from or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> deleteAuthenticationDataEntry(Scope key, String alias, String domainName, AbstractSession session) throws Exception;
    /**
     * Modify a JAAS J2C authentication data entry
     * 
     * @param key The scope to use for reference
     * @param settings A {@link JAASJ2CAuthenticationEntrySettings} that contains the modified settings
     * @param domainName The name of the domain that contains the entry or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> modifyAuthenticationDataEntry(Scope key, JAASJ2CAuthenticationEntrySettings settings, String domainName, AbstractSession session) throws Exception;
    /**
     * Get the LTPA timout value for a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the timeout value for or null for the global domain
     * @param session Session currently in use
     * @return The LTPA timeout value or null if it is not set
     * @throws Exception
     */
    public abstract Integer getLTPATimeout(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Set the LTPA timeout value for a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to set the timeout for or null for the global security domain
     * @param timeout The LTPA timeout value
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> setLTPATimeout(Scope key, String domainName, Integer timeout, AbstractSession session) throws Exception;
    /**
     * Get the {@link ConfigIdentifier} for the authorization configuration that contains the
     * authorization provider
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the authorization config from or null for the global domain
     * @param session Session currently in use
     * @return The {@link ConfigIdentifier} of the authorization configuration or null if no configuration exists
     * @throws Exception
     */
    public abstract ConfigIdentifier getAuthorizationConfig(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Configure the authorization configuration for a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to configure authorization for or null for the global domain
     * @param useJACCProvider true if an external JACC provider should be used; false for the built-in provider
     * @param settings The settings to use when configuring the authorization configuration
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> configureAuthorizationConfig(Scope key, String domainName, Boolean useJACCProvider, AuthorizationProviderSettings settings, AbstractSession session) throws Exception;
    /**
     * Remove an authorization configuration from a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to remove the configuration from or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unconfigureAuthorizationConfig(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Map a resource to a security domain
     * 
     * @param key The scope to use for reference
     * @param resource The resource to map to the domain
     * @param domainName The name of the domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> mapResourceToSecurityDomain(Scope key, String resource, String domainName, AbstractSession session) throws Exception;
    /**
     * Get a List of the resources mapped to a security domain
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the resources for
     * @param session Session currently in use
     * @return A List of resources of the form Cell=cell:Node=node:Server=server
     * @throws Exception
     */
    public abstract List<String> listResourcesInDomain(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Remote a resource mapping from a security domain
     * 
     * @param key The scope to use as reference
     * @param resource The resource mapping String
     * @param domainName The name of the domain to remove the resource from
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> removeResourceFromSecurityDomain(Scope key, String resource, String domainName, AbstractSession session) throws Exception;
    /**
     * Create a security domain
     * 
     * @param key The scope to use for reference
     * @param name The name of the domain
     * @param description The description for the domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> createSecurityDomain(Scope key, String name, String description, AbstractSession session) throws Exception;
    /**
     * Delete a security domain
     * 
     * @param key The scope to use for reference
     * @param name The name of the domain to delete
     * @param force true if the domain should be deleted without checking for resources mapped to the domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> deleteSecurityDomain(Scope key, String name, boolean force, AbstractSession session) throws Exception;
    /**
     * Create a security domain by copying an existing domain
     * 
     * @param key The scope to use for reference
     * @param name The name of the domain to create
     * @param description The description for the domain
     * @param sourceName The name of the domain to copy
     * @param realmName The name of the realm in the new security domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> copySecurityDomain(Scope key, String name, String description, String sourceName, String realmName, AbstractSession session) throws Exception;
    /**
     * Create a security domain by copying the global domain
     * 
     * @param key The scope to use for reference
     * @param name The name of the domain to create
     * @param description The description for the domain
     * @param realmName The name of the realm in the new security domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> copyGlobalDomain(Scope key, String name, String description, String realmName, AbstractSession session) throws Exception;
    /**
     * Get the trusted realm names for a security domain
     * 
     * @param key The scope to use for reference
     * @param communicationType inbound or outbound
     * @param domainName The name of the domain to get the trusted realms for or null for the global domain
     * @param session Session currently in use
     * @return A Set of trusted realm names
     * @throws Exception
     */
    public abstract Set<String> getTrustedRealms(Scope key, CommunicationType communicationType, String domainName, AbstractSession session) throws Exception;
    /**
     * Add trusted realms to a securit domain
     * 
     * @param key The scope to use for reference
     * @param communicationType inbound or outbound
     * @param realms The names of the realms to trust
     * @param domainName The name of the domain to add trusted realms to or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> addTrustedRealms(Scope key, CommunicationType communicationType, Set<String> realms, String domainName, AbstractSession session) throws Exception;
    /**
     * Remove trusted realms from a security domain
     * 
     * @param key The scope to use for reference
     * @param communicationType inbound or outbound
     * @param realms The names of the realms to remove
     * @param domainName The name of the domain to add trusted realms to or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> removeTrustedRealms(Scope key, CommunicationType communicationType, Set<String> realms, String domainName, AbstractSession session) throws Exception;
    /**
     * Remove trusted realm configuration from a security domain
     * 
     * @param key The scope to use for reference
     * @param communicationType inbound or outbound
     * @param domainName The name of the domain to remove the configuration from or null for the global domain
     * @param session Session currently in use
     * @return An {@link OperationResults} with the results of the operation
     * @throws Exception
     */
    public abstract OperationResults<Boolean> unconfigureTrustedRealms(Scope key, CommunicationType communicationType, String domainName, AbstractSession session) throws Exception;
    /**
     * Convert the result of the {@link GetCSIInboundInfo} adminTask to the universal
     * {@link CSIInboundSettings}
     * 
     * @param adminTaskResult The result of the {@link GetCSIInboundInfo} adminTask
     * @return The correpsonding {@link CSIInboundSettings}
     */
    public abstract CSIInboundSettings getCSIv2InboundAttributes(Object adminTaskResult);
    /**
     * Convert the result of the {@link GetCSIOutboundInfo} adminTask to the universal
     * {@link CSIOutboundSettings}
     * 
     * @param adminTaskResult The result of the {@link GetCSIOutboundInfo} adminTask
     * @return The corresponding {@link CSIOutboundSettings}
     */
    public abstract CSIOutboundSettings getCSIv2OutboundAttributes(Object adminTaskResult);
    /**
     * Get the trust association interceptor attributes
     * 
     * @param key The scope to use for reference
     * @param domainName The name of the domain to get the interceptors for 
     * @param session Session currently in use
     * @return A Set of {@link InterceptorSettings}s containing the interceptor information
     * @throws Exception
     */
    public abstract Set<InterceptorSettings> getInterceptors(Scope key, String domainName, AbstractSession session) throws Exception;
    /**
     * Interpret the result of AdminTask.searchGroups() for the specific provider
     *  
     * @param result The result to interpret
     * @return A List of group unique names
     */
    public abstract List<String> getGroups(Object result) throws Exception;
    /**
     * Get the description of a user group
     * 
     * @param key The Scope to use for reference
     * @param groupUniqueName The unique name of the group to get the description for
     * @param session The Session currently in use
     * @return The description of the group
     * @throws Exception
     */
    public abstract String getGroupDescription(Scope key, String groupUniqueName, AbstractSession session) throws Exception;
    /**
     * Interprest the results of AdminTask.searchUsers() for the specific provider
     *  
     * @param result The result to interpret
     * @return A List of unique names of the users
     * @throws Exception
     */
    public abstract List<String> getUserUniqueNames(Object result) throws Exception;
    /**
     * Get the attributes for a WIM user
     * 
     * @param key The key to use for reference
     * @param uniqueName The unique name of the user
     * @param session The session currently in use
     * @return The attributes of the user
     * @throws Exception
     */
    public abstract UserAttributes getUserAttributes(Scope key, String uniqueName, AbstractSession session) throws Exception;
    /**
     * Get the group members of a group
     * 
     * @param key The Scope to use for reference
     * @param uniqueName The unique name of the group to get the members for
     * @param session Session currently in use
     * @return A HashSet containing the groups that are members of the group
     */
    public abstract HashSet<String> getGroupMembers(Scope key, String uniqueName, AbstractSession session) throws Exception;
    /**
     * Get the user members of a group
     * 
     * @param key The Scope to use for reference
     * @param uniqueName The unique name of the group to get the members for
     * @param session Session currently in use
     * @return A HashSet containing the users that are members of the group
     */
    public abstract HashSet<String> getUserMembers(Scope key, String uniqueName, AbstractSession session) throws Exception;
    /**
     * Get the groups that a group is a member of
     * 
     * @param key The Scope to use for reference
     * @param uniqueName The unique name of the group to get the groups for
     * @param session Session currently in use
     * @return A HashSet containing the unique IDs of the groups that the group is a member of
     * @throws Exception
     */
    public abstract HashSet<String> getMembershipOfGroup(Scope key, String uniqueName, AbstractSession session) throws Exception;
    /**
     * Get the groups that a user is a member of
     * 
     * @param key The Scope to use for reference
     * @param uniqueName The unique name of the user to get the groups for
     * @param session Session currently in use
     * @return A HashSet containing the unique IDs of the groups that the user is a member of
     * @throws Exception
     */
    public abstract HashSet<String> getMembershipOfUser(Scope key, String uniqueName, AbstractSession session) throws Exception;
}
