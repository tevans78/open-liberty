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

package com.ibm.websphere.simplicity.provider;

import java.util.Map;

import com.ibm.websphere.simplicity.config.securitydomain.LDAPServerType;
import com.ibm.websphere.simplicity.config.securitydomain.UserRealmSettings;

/**
 * This class is redundant with {@link UserRealmSettings} but we want to keep certain getters and
 * setters non-visible to the user in the public api depending on the registry type and the domain
 * for usability purposes. In the provider we need to be able to set the values. Only way to do make
 * setter methods always public to the provider but not the user is using this wrapper.
 */
public class UserRegistrySettingsWrapper {

    protected Boolean ignoreCase;
    protected Map<String, String> customProperties;
    protected String serverId;
    protected String primaryAdminId;
    protected String realmName;
    private String customRegistryClass;
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

    public String getBaseDN() {
        return baseDN;
    }
    public void setBaseDN(String baseDN) {
        this.baseDN = baseDN;
    }
    public String getBindDN() {
        return bindDN;
    }
    public void setBindDN(String bindDN) {
        this.bindDN = bindDN;
    }
    public String getBindPassword() {
        return bindPassword;
    }
    public void setBindPassword(String bindPassword) {
        this.bindPassword = bindPassword;
    }
    public String getCertificateFilter() {
        return certificateFilter;
    }
    public void setCertificateFilter(String certificateFilter) {
        this.certificateFilter = certificateFilter;
    }
    public String getCertificateMapMode() {
        return certificateMapMode;
    }
    public void setCertificateMapMode(String certificateMapMode) {
        this.certificateMapMode = certificateMapMode;
    }
    public String getGroupFilter() {
        return groupFilter;
    }
    public void setGroupFilter(String groupFilter) {
        this.groupFilter = groupFilter;
    }
    public String getGroupIdMap() {
        return groupIdMap;
    }
    public void setGroupIdMap(String groupIdMap) {
        this.groupIdMap = groupIdMap;
    }
    public String getGroupMemberIdMap() {
        return groupMemberIdMap;
    }
    public void setGroupMemberIdMap(String groupMemberIdMap) {
        this.groupMemberIdMap = groupMemberIdMap;
    }
    public String getKrbUserFilter() {
        return krbUserFilter;
    }
    public void setKrbUserFilter(String krbUserFilter) {
        this.krbUserFilter = krbUserFilter;
    }
    public String getLdapHost() {
        return ldapHost;
    }
    public void setLdapHost(String ldapHost) {
        this.ldapHost = ldapHost;
    }
    public Integer getLdapPort() {
        return ldapPort;
    }
    public void setLdapPort(Integer ldapPort) {
        this.ldapPort = ldapPort;
    }
    public LDAPServerType getLdapType() {
        return ldapType;
    }
    public void setLdapType(LDAPServerType ldapType) {
        this.ldapType = ldapType;
    }
    public Boolean getNestedGroupSearch() {
        return nestedGroupSearch;
    }
    public void setNestedGroupSearch(Boolean nestedGroupSearch) {
        this.nestedGroupSearch = nestedGroupSearch;
    }
    public Boolean getReuseConnection() {
        return reuseConnection;
    }
    public void setReuseConnection(Boolean reuseConnection) {
        this.reuseConnection = reuseConnection;
    }
    public Integer getSearchTimeout() {
        return searchTimeout;
    }
    public void setSearchTimeout(Integer searchTimeout) {
        this.searchTimeout = searchTimeout;
    }
    public String getSslConfig() {
        return sslConfig;
    }
    public void setSslConfig(String sslConfig) {
        this.sslConfig = sslConfig;
    }
    public Boolean getSslEnabled() {
        return sslEnabled;
    }
    public void setSslEnabled(Boolean sslEnabled) {
        this.sslEnabled = sslEnabled;
    }
    public String getUserFilter() {
        return userFilter;
    }
    public void setUserFilter(String userFilter) {
        this.userFilter = userFilter;
    }
    public String getUserIdMap() {
        return userIdMap;
    }
    public void setUserIdMap(String userIdMap) {
        this.userIdMap = userIdMap;
    }
    public String getCustomRegistryClass() {
        return customRegistryClass;
    }
    public void setCustomRegistryClass(String customRegistryClass) {
        this.customRegistryClass = customRegistryClass;
    }
    public Map<String, String> getCustomProperties() {
        return customProperties;
    }
    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }
    public Boolean getIgnoreCase() {
        return ignoreCase;
    }
    public void setIgnoreCase(Boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }
    public String getPrimaryAdminId() {
        return primaryAdminId;
    }
    public void setPrimaryAdminId(String primaryAdminId) {
        this.primaryAdminId = primaryAdminId;
    }
    public String getRealmName() {
        return realmName;
    }
    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }
    public String getServerId() {
        return serverId;
    }
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
}
