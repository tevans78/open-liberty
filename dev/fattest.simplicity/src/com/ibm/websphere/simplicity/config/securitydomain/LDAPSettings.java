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


/**
 * This class conains LDAP configuration settings.
 *
 */
public abstract class LDAPSettings extends UserRealmSettings {

    private LDAPServerType ldapType;
    private String ldapHost;
    private Integer ldapPort;
    private String baseDN;
    private String bindDN;
    private String bindPassword;
    private Integer searchTimeout;
    private Boolean reuseConnection;
    private String userFilter;
    private String groupFilter;
    private String userIdMap;
    private String groupIdMap;
    private String groupMemberIdMap;
    private String certificateMapMode;
    private String certificateFilter;
    private String krbUserFilter;
    private Boolean nestedGroupSearch;
    private Boolean sslEnabled;
    private String sslConfig;

    /**
     * Specifies the base distinguished name (DN) of the directory service, which indicates the
     * starting point for LDAP searches of the directory service. In most cases, bind DN and bind
     * password are needed. However, when anonymous bind can satisfy all of the required functions,
     * bind DN and bind password are not needed.
     * 
     * @return The base distinguished name
     */
    public String getBaseDN() {
        return baseDN;
    }

    /**
     * Specifies the base distinguished name (DN) of the directory service, which indicates the
     * starting point for LDAP searches of the directory service. In most cases, bind DN and bind
     * password are needed. However, when anonymous bind can satisfy all of the required functions,
     * bind DN and bind password are not needed.
     * 
     * @param baseDN The base distinguished name to use
     */
    public void setBaseDN(String baseDN) {
        this.baseDN = baseDN;
    }

    /**
     * Specifies the distinguished name for the application server, which is used to bind to the
     * directory service.
     * 
     * @return The distinguished name for the application server
     */
    public String getBindDN() {
        return bindDN;
    }

    /**
     * Specifies the distinguished name for the application server, which is used to bind to the
     * directory service.
     * 
     * @param bindDN The distinguished name for the application server to use
     */
    public void setBindDN(String bindDN) {
        this.bindDN = bindDN;
    }

    /**
     * Specifies the binding DN password for the LDAP server.
     * 
     * @return The binding DN password
     */
    public String getBindPassword() {
        return bindPassword;
    }

    /**
     * Specifies the binding DN password for the LDAP server.
     * 
     * @param bindPassword The binding DN password to use
     */
    public void setBindPassword(String bindPassword) {
        this.bindPassword = bindPassword;
    }

    /**
     * Specifies the filter certificate mapping property for the LDAP filter. The filter is used to
     * map attributes in the client certificate to entries in the LDAP registry.
     * 
     * @return The filter certificate mapping property
     */
    public String getCertificateFilter() {
        return certificateFilter;
    }

    /**
     * Specifies the filter certificate mapping property for the LDAP filter. The filter is used to
     * map attributes in the client certificate to entries in the LDAP registry.
     * 
     * @param certificateFilter The filter certificate mapping property to use
     */
    public void setCertificateFilter(String certificateFilter) {
        this.certificateFilter = certificateFilter;
    }

    /**
     * Specifies whether to map X.509 certificates into an LDAP directory by EXACT_DN or
     * CERTIFICATE_FILTER. Specify CERTIFICATE_FILTER to use the specified certificate filter for
     * the mapping.
     * 
     * @return The certificate map mode setting
     */
    public String getCertificateMapMode() {
        return certificateMapMode;
    }

    /**
     * Specifies whether to map X.509 certificates into an LDAP directory by EXACT_DN or
     * CERTIFICATE_FILTER. Specify CERTIFICATE_FILTER to use the specified certificate filter for
     * the mapping.
     * 
     * @param certificateMapMode The certificate map mode
     */
    public void setCertificateMapMode(String certificateMapMode) {
        this.certificateMapMode = certificateMapMode;
    }

    /**
     * Specifies the LDAP filter clause that the system uses to search the user registry for groups.
     * The default value is the default group filter for the LDAP server type.
     * 
     * @return The group filter setting
     */
    public String getGroupFilter() {
        return groupFilter;
    }

    /**
     * Specifies the LDAP filter clause that the system uses to search the user registry for groups.
     * The default value is the default group filter for the LDAP server type.
     * 
     * @param groupFilter The group filter to use
     */
    public void setGroupFilter(String groupFilter) {
        this.groupFilter = groupFilter;
    }

    /**
     * Specifies the LDAP filter that maps the short name of a group to an LDAP entry. The default
     * value is the default group filter for the LDAP server type.
     * 
     * @return The group Id map
     */
    public String getGroupIdMap() {
        return groupIdMap;
    }

    /**
     * Specifies the LDAP filter that maps the short name of a group to an LDAP entry. The default
     * value is the default group filter for the LDAP server type.
     * 
     * @param groupIdMap The group Id map to use
     */
    public void setGroupIdMap(String groupIdMap) {
        this.groupIdMap = groupIdMap;
    }

    /**
     * Specifies the LDAP filter that identifies users to group memberships.
     * 
     * @return The group member Id map
     */
    public String getGroupMemberIdMap() {
        return groupMemberIdMap;
    }

    /**
     * Specifies the LDAP filter that identifies users to group memberships.
     * 
     * @param groupMemberIdMap The group member Id map to use
     */
    public void setGroupMemberIdMap(String groupMemberIdMap) {
        this.groupMemberIdMap = groupMemberIdMap;
    }

    /**
     * Specifies the default value is the default user filter for the LDAP server type.
     * 
     * @return The krbUserFilter
     */
    public String getKrbUserFilter() {
        return krbUserFilter;
    }

    /**
     * Specifies the default value is the default user filter for the LDAP server type.
     * 
     * @param krbUserFilter The krbUserFilter to use
     */
    public void setKrbUserFilter(String krbUserFilter) {
        this.krbUserFilter = krbUserFilter;
    }

    /**
     * Specifies the host name of the LDAP server.
     * 
     * @return The LDAP server host
     */
    public String getLdapHost() {
        return ldapHost;
    }

    /**
     * Specifies the host name of the LDAP server.
     * 
     * @param ldapHost The LDAP server host
     */
    public void setLdapHost(String ldapHost) {
        this.ldapHost = ldapHost;
    }

    /**
     * Specifies the port that the system uses to access the LDAP server. The default value is 389.
     * 
     * @return The LDAP port number
     */
    public Integer getLdapPort() {
        return ldapPort;
    }

    /**
     * Specifies the port that the system uses to access the LDAP server. The default value is 389.
     * 
     * @param ldapPort The LDAP port number to use
     */
    public void setLdapPort(Integer ldapPort) {
        this.ldapPort = ldapPort;
    }

    /**
     * Specifies the type of LDAP server. The default type is
     * {@link LDAPServerType#IBM_DIRECTORY_SERVER}
     * 
     * @return The LDAP server type
     */
    public LDAPServerType getLdapType() {
        return ldapType;
    }

    /**
     * Specifies the type of LDAP server. The default type is
     * {@link LDAPServerType#IBM_DIRECTORY_SERVER}
     * 
     * @param ldapType The LDAP server type to use
     */
    public void setLdapType(LDAPServerType ldapType) {
        this.ldapType = ldapType;
    }

    /**
     * Specifies whether to perform a recursive nested group search. Specify true to perform a
     * recursive nested group search, or specify false to disable recursive nested group searching.
     * 
     * @return The nested group search setting
     */
    public Boolean getNestedGroupSearch() {
        return nestedGroupSearch;
    }

    /**
     * Specifies whether to perform a recursive nested group search. Specify true to perform a
     * recursive nested group search, or specify false to disable recursive nested group searching.
     * 
     * @param nestedGroupSearch true to perform a recursive nested group search
     */
    public void setNestedGroupSearch(Boolean nestedGroupSearch) {
        this.nestedGroupSearch = nestedGroupSearch;
    }

    /**
     * Specifies whether the server reuses the LDAP connection. By default, this option is enabled.
     * Specify false for this parameter only in rare situations where a router is used to distribute
     * requests to multiple LDAP servers and when the router does not support affinity.
     * 
     * @return The reuseConnection setting
     */
    public Boolean getReuseConnection() {
        return reuseConnection;
    }

    /**
     * Specifies whether the server reuses the LDAP connection. By default, this option is enabled.
     * Specify false for this parameter only in rare situations where a router is used to distribute
     * requests to multiple LDAP servers and when the router does not support affinity.
     * 
     * @param reuseConnection true to reuse the LDAP connection
     */
    public void setReuseConnection(Boolean reuseConnection) {
        this.reuseConnection = reuseConnection;
    }

    /**
     * Specifies the timeout value in seconds for an LDAP server to respond before stopping a
     * request. The default value is 120 seconds.
     * 
     * @return The search timeout
     */
    public Integer getSearchTimeout() {
        return searchTimeout;
    }

    /**
     * Specifies the timeout value in seconds for an LDAP server to respond before stopping a
     * request. The default value is 120 seconds.
     * 
     * @param searchTimeout The search timeout to use
     */
    public void setSearchTimeout(Integer searchTimeout) {
        this.searchTimeout = searchTimeout;
    }

    /**
     * Specifies the SSL configuration alias to use for the secure LDAP connection.
     * 
     * @return The SSL configuration alias
     */
    public String getSslConfig() {
        return sslConfig;
    }

    /**
     * Specifies the SSL configuration alias to use for the secure LDAP connection.
     * 
     * @param sslConfig The SSL configuration alias to use
     */
    public void setSslConfig(String sslConfig) {
        this.sslConfig = sslConfig;
    }

    /**
     * Specifies whether to enable Secure Sockets Layer (SSL). Specify true to enable an SSL
     * connection to the LDAP server.
     * 
     * @return the SSL enabled setting
     */
    public Boolean getSslEnabled() {
        return sslEnabled;
    }

    /**
     * Specifies whether to enable Secure Sockets Layer (SSL). Specify true to enable an SSL
     * connection to the LDAP server.
     * 
     * @param sslEnabled true to enable an SSL connection
     */
    public void setSslEnabled(Boolean sslEnabled) {
        this.sslEnabled = sslEnabled;
    }

    /**
     * Specifies the LDAP filter clause that the system uses to search the user registry for users.
     * The default value is the default user filter for the LDAP server type.
     * 
     * @return The lDAP filter clause
     */
    public String getUserFilter() {
        return userFilter;
    }

    /**
     * Specifies the LDAP filter clause that the system uses to search the user registry for users.
     * The default value is the default user filter for the LDAP server type.
     * 
     * @param userFilter The LDAP filter clause to use
     */
    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter;
    }

    /**
     * Specifies the LDAP filter that maps the short name of a user to an LDAP entry. The default
     * value is the default user filter for the LDAP server type.
     * 
     * @return The user Id map
     */
    public String getUserIdMap() {
        return userIdMap;
    }

    /**
     * Specifies the LDAP filter that maps the short name of a user to an LDAP entry. The default
     * value is the default user filter for the LDAP server type.
     * 
     * @param userIdMap The user Id amp to use
     */
    public void setUserIdMap(String userIdMap) {
        this.userIdMap = userIdMap;
    }

}
