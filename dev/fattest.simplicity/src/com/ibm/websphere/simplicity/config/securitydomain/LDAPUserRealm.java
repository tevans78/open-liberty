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
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * This class represents an LDAP user realm. Uses the Lightweight Directory Access Protocol (LDAP)
 * user registry settings when users and groups reside in an external LDAP directory.
 */
public class LDAPUserRealm extends UserRealm {

	public static final String CHANGE_KEY_SEARCH_TIMEOUT = "searchTimeout";
	public static final String CHANGE_KEY_SSL_CONFIG = "sslConfig";
	public static final String CHANGE_KEY_SSL_ENABLED = "sslEnabled";
	public static final String CHANGE_KEY_KRB_USER_FILTER = "krbUserFilter";
	public static final String CHANGE_KEY_CERT_FILTER = "certFilter";
	public static final String CHANGE_KEY_CERT_MAP_MODE = "certMapMode";
	public static final String CHANGE_KEY_GROUP_MAP = "groupMap";
	public static final String CHANGE_KEY_GROUP_MEMBER_MAP = "groupMemberMap";
	public static final String CHANGE_KEY_USER_MAP = "userMap";
	public static final String CHANGE_KEY_GROUP_FILTER = "groupFilter";
	public static final String CHANGE_KEY_USER_FILTER = "userFilter";
	public static final String CHANGE_KEY_REUSE_CONN = "reuseConn";
	public static final String CHANGE_KEY_BIND_DN = "bindDn";
	public static final String CHANGE_KEY_BASE_DN = "baseDn";
	public static final String CHANGE_KEY_LDAP_TYPE = "ldapType";
	public static final String CHANGE_KEY_LDAP_PORT = "ldapPort";
	public static final String CHANGE_KEY_LDAP_HOST = "ldapHost";

    /**
     * Constructor
     * 
     * @param parent The {@link UserRealms} parent class
     * @param configId The {@link ConfigIdentifier} of the realm
     * @throws Exception
     */
    protected LDAPUserRealm(UserRealms parent, ConfigIdentifier configId) throws Exception {
        super(parent, UserRealmType.LDAPUserRegistry, configId);
    }
    
    /**
     * Get the host ID (IP address or domain name service (DNS) name) of the LDAP server.
     * 
     * @return The LDAP hostname
     * @throws Exception
     */
    public String getLDAPHost() throws Exception {
        if(getAttributes().getLdapHost() == null) {
            ConfigObject hosts = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "EndPoint");
            ConfigObject host = hosts.getAttributeByName("host");
            getAttributes().setLdapHost(host.getValueAsString());
        }
        return getAttributes().getLdapHost();
    }

    /**
     * Set the host ID (IP address or domain name service (DNS) name) of the LDAP server.
     * 
     * @param ldapHost The hostname to set
     * @throws Exception
     */
    public void setLDAPHost(String ldapHost) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LDAP_HOST, getLDAPHost());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setLdapHost(ldapHost);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setLdapHost(ldapHost);
    }
    
    /**
     * Get the host port of the LDAP server.
     * 
     * @return The port of the LDAP server
     * @throws Exception
     */
    public int getLDAPPort() throws Exception {
        if(getAttributes().getLdapPort() == null) {
            ConfigObject hosts = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "EndPoint");
            ConfigObject host = hosts.getAttributeByName("port");
            getAttributes().setLdapPort(host.getValueAsInt());
        }
        return getAttributes().getLdapPort();
    }

    /**
     * Set the host port of the LDAP server.
     * 
     * @param ldapPort The port number to set
     * @throws Exception
     */
    public void setLDAPPort(int ldapPort) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LDAP_PORT, getLDAPPort());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setLdapPort(ldapPort);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setLdapPort(ldapPort);
    }
    
    /**
     * Get the type of LDAP server to which you connect.
     * 
     * @return The type of the server
     * @throws Exception
     */
    public LDAPServerType getLDAPType() throws Exception {
        if(getAttributes().getLdapType() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            String type = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "type").toString();
            getAttributes().setLdapType(LDAPServerType.valueOf(type));
        }
        return getAttributes().getLdapType();
    }

    /**
     * Set the type of LDAP server to which you connect.
     * 
     * @param ldapType The type of LDAP server to connect to
     * @throws Exception
     */
    public void setLDAPType(LDAPServerType ldapType) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_LDAP_TYPE, getLDAPType());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setLdapType(ldapType);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setLdapType(ldapType);
    }
    
    /**
     * Get the base distinguished name (DN) of the directory service, which indicates the starting
     * point for LDAP searches of the directory service. In most cases, bind DN and bind password
     * are needed. However, when anonymous bind can satisfy all of the required functions, bind DN
     * and bind password are not needed.
     * 
     * @return The base distinguished name
     * @throws Exception
     */
    public String getBaseDN() throws Exception {
        if(getAttributes().getBaseDN() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            getAttributes().setBaseDN(OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "baseDN").toString());
        }
        return getAttributes().getBaseDN();
    }

    /**
     * Set the base distinguished name (DN) of the directory service, which indicates the starting
     * point for LDAP searches of the directory service. In most cases, bind DN and bind password
     * are needed. However, when anonymous bind can satisfy all of the required functions, bind DN
     * and bind password are not needed.
     * 
     * @param baseDN The base distinguished name to set
     * @throws Exception
     */
    public void setBaseDN(String baseDN) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_BASE_DN, getBaseDN());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setBaseDN(baseDN);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setBaseDN(baseDN);
    }
    
    /**
     * Get the DN for the application server to use when binding to the directory service.
     * 
     * @return The bind DN
     * @throws Exception
     */
    public String getBindDN() throws Exception {
        if(getAttributes().getBindDN() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            getAttributes().setBindDN(OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "bindDN").toString());
        }
        return getAttributes().getBindDN();
    }

    /**
     * Set the DN for the application server to use when binding to the directory service.
     * 
     * @param bindDN The bind DN to use
     * @param bindPassword The associated password
     * @throws Exception
     */
    public void setBindDN(String bindDN, String bindPassword) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_BIND_DN, getBindDN());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setBindDN(bindDN);
        settings.setBindPassword(bindPassword);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setBindDN(bindDN);
    }

    /**
     * Set the password for the application server to use when binding to the directory service.
     * 
     * @param bindPassword The password to use
     * @throws Exception
     */
    public void setBindPassword(String bindPassword) throws Exception {
        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setBindPassword(bindPassword);
        parent.configureUserRealm(type, settings, false);
    }
    
    /**
     * Get the timeout value in seconds for a Lightweight Directory Access Protocol (LDAP) server to
     * respond before stopping a request.
     * 
     * @return The timeout value
     * @throws Exception
     */
    public int getSearchTimeout() throws Exception {
        if(getAttributes().getSearchTimeout() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            String timeout = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "searchTimeout").toString();
            getAttributes().setSearchTimeout(new Integer(timeout));
        }
        return getAttributes().getSearchTimeout();
    }

    /**
     * Set the timeout value in seconds for a Lightweight Directory Access Protocol (LDAP) server to
     * respond before stopping a request.
     * 
     * @param searchTimeout The timeout value to set
     * @throws Exception
     */
    public void setSearchTimeout(int searchTimeout) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_SEARCH_TIMEOUT, getSearchTimeout());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setSearchTimeout(searchTimeout);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setSearchTimeout(searchTimeout);
    }
    
    /**
     * Get whether the server reuses the LDAP connection. Clear this option only in rare situations
     * where a router is used to distribute requests to multiple LDAP servers and when the router
     * does not support affinity.
     * 
     * @return true if the server reuses the LDAP connection
     * @throws Exception
     */
    public boolean getReuseConnection() throws Exception {
        if(getAttributes().getReuseConnection() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            String reuse = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "reuseConnection").toString();
            getAttributes().setReuseConnection(new Boolean(reuse));
        }
        return getAttributes().getReuseConnection();
    }

    /**
     * Set whether the server reuses the LDAP connection. Clear this option only in rare situations
     * where a router is used to distribute requests to multiple LDAP servers and when the router
     * does not support affinity.
     * 
     * @param reuseConnection true to reuse the LDAP connection
     * @throws Exception
     */
    public void setReuseConnection(boolean reuseConnection) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_REUSE_CONN, getReuseConnection());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setReuseConnection(reuseConnection);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setReuseConnection(reuseConnection);
    }
    
    /**
     * Get the LDAP user filter that searches the user registry for users. This option is typically
     * used for security role-to-user assignments and specifies the property by which to look up
     * users in the directory service.
     * 
     * @return The user filter
     * @throws Exception
     */
    public String getUserFilter() throws Exception {
        if(getAttributes().getUserFilter() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject userFilter = searchFilter.getAttributeByName("userFilter");
            getAttributes().setUserFilter(userFilter.getValueAsString());
        }
        return getAttributes().getUserFilter();
    }

    /**
     * Set the LDAP user filter that searches the user registry for users. This option is typically
     * used for security role-to-user assignments and specifies the property by which to look up
     * users in the directory service.
     * 
     * @param userFilter The user filter value to set
     * @throws Exception
     */
    public void setUserFilter(String userFilter) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_USER_FILTER, getUserFilter());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setUserFilter(userFilter);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setUserFilter(userFilter);
    }
    
    /**
     * Get the LDAP group filter that searches the user registry for groups. This option is
     * typically used for security role-to-group assignments and specifies the property by which to
     * look up groups in the directory service.
     * 
     * @return The group filter
     * @throws Exception
     */
    public String getGroupFilter() throws Exception {
        if(getAttributes().getGroupFilter() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject groupFilter = searchFilter.getAttributeByName("groupFilter");
            getAttributes().setGroupFilter(groupFilter.getValueAsString());
        }
        return getAttributes().getGroupFilter();
    }

    /**
     * the LDAP group filter that searches the user registry for groups. This option is typically
     * used for security role-to-group assignments and specifies the property by which to look up
     * groups in the directory service.
     * 
     * @param groupFilter The group filter value to set
     * @throws Exception
     */
    public void setGroupFilter(String groupFilter) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_GROUP_FILTER, getGroupFilter());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setGroupFilter(groupFilter);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setGroupFilter(groupFilter);
    }
    
    /**
     * Get the LDAP filter that maps the short name of a user to an LDAP entry.
     * 
     * @return The user ID map
     * @throws Exception
     */
    public String getUserIdMap() throws Exception {
        if(getAttributes().getUserIdMap() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject userIdMap = searchFilter.getAttributeByName("userIdMap");
            getAttributes().setUserIdMap(userIdMap.getValueAsString());
        }
        return getAttributes().getUserIdMap();
    }

    /**
     * Set the LDAP filter that maps the short name of a user to an LDAP entry.
     * 
     * @param userIdMap The user ID map value to set
     * @throws Exception
     */
    public void setUserIdMap(String userIdMap) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_USER_MAP, getUserIdMap());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setUserIdMap(userIdMap);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setUserIdMap(userIdMap);
    }
    
    /**
     * Get the LDAP filter that maps the short name of a group to an LDAP entry.
     * 
     * @return The group ID map
     * @throws Exception
     */
    public String getGroupIdMap() throws Exception {
        if(getAttributes().getGroupIdMap() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject groupIdMap = searchFilter.getAttributeByName("groupIdMap");
            getAttributes().setUserIdMap(groupIdMap.getValueAsString());
        }
        return getAttributes().getUserIdMap();
    }

    /**
     * Set the LDAP filter that maps the short name of a group to an LDAP entry.
     * 
     * @param groupIdMap The group ID map value to set
     * @throws Exception
     */
    public void setGroupIdMap(String groupIdMap) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_GROUP_MAP, getGroupIdMap());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setGroupIdMap(groupIdMap);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setGroupIdMap(groupIdMap);
    }
    
    /**
     * Get the LDAP filter that identifies user-to-group relationships.
     * 
     * @return The group member ID map
     * @throws Exception
     */
    public String getGroupMemberIdMap() throws Exception {
        if(getAttributes().getGroupMemberIdMap() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject groupMemberIdMap = searchFilter.getAttributeByName("groupMemberIdMap");
            getAttributes().setGroupMemberIdMap(groupMemberIdMap.getValueAsString());
        }
        return getAttributes().getGroupMemberIdMap();
    }

    /**
     * Set the LDAP filter that identifies user-to-group relationships.
     * 
     * @param groupMemberIdMap The group member ID map value to set
     * @throws Exception
     */
    public void setGroupMemberIdMap(String groupMemberIdMap) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_GROUP_MEMBER_MAP, getGroupMemberIdMap());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setGroupMemberIdMap(groupMemberIdMap);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setGroupMemberIdMap(groupMemberIdMap);
    }
    
    /**
     * Get whether to map X.509 certificates into an LDAP directory by EXACT_DN or CERTIFICATE_FILTER.
     * 
     * @return The certificate map mode
     * @throws Exception
     */
    public String getCertificateMapMode() throws Exception {
        if(getAttributes().getCertificateMapMode() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject certificateMapMode = searchFilter.getAttributeByName("certificateMapMode");
            getAttributes().setCertificateMapMode(certificateMapMode.getValueAsString());
        }
        return getAttributes().getCertificateMapMode();
    }

    /**
     * Set whether to map X.509 certificates into an LDAP directory by EXACT_DN or
     * CERTIFICATE_FILTER. Specify CERTIFICATE_FILTER to use the specified certificate filter for
     * the mapping.
     * 
     * @param certificateMapMode The certificate map mode to set
     * @throws Exception
     */
    public void setCertificateMapMode(String certificateMapMode) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CERT_MAP_MODE, getCertificateMapMode());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setCertificateMapMode(certificateMapMode);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setCertificateMapMode(certificateMapMode);
    }
    
    /**
     * Get the filter certificate mapping property for the LDAP filter. The filter is used to map
     * attributes in the client certificate to entries in the LDAP registry.
     * 
     * @return The certificate filter
     * @throws Exception
     */
    public String getCertificateFilter() throws Exception {
        if(getAttributes().getCertificateFilter() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject certificateFilter = searchFilter.getAttributeByName("certificateFilter");
            getAttributes().setCertificateFilter(certificateFilter.getValueAsString());
        }
        return getAttributes().getCertificateFilter();
    }

    /**
     * the filter certificate mapping property for the LDAP filter. The filter is used to map
     * attributes in the client certificate to entries in the LDAP registry.
     * 
     * @param certificateFilter The certificate filter value to set
     * @throws Exception
     */
    public void setCertificateFilter(String certificateFilter) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CERT_FILTER, getCertificateFilter());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setCertificateFilter(certificateFilter);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setCertificateFilter(certificateFilter);
    }
    
    /**
     * Get the Kerberos user filter value.
     *  
     * @return The Kerberos user filter
     * @throws Exception
     */
    public String getKrbUserFilter() throws Exception {
        if(getAttributes().getKrbUserFilter() == null) {
            ConfigObject searchFilter = ConfigObject.getConfigObject(parent.getSecurityDomain().getCell(), configId, "LDAPSearchFilter");
            ConfigObject krbFilter = searchFilter.getAttributeByName("krbUserFilter");
            getAttributes().setKrbUserFilter(krbFilter.getValueAsString());
        }
        return getAttributes().getKrbUserFilter();
    }

    /**
     * Set the Kerberos user filter value. This value can be modified when Kerberos is configured
     * and is active as one of the preferred authentication mechanisms.
     * 
     * @param krbUserFilter The Kerberos filter value to set
     * @throws Exception
     */
    public void setKrbUserFilter(String krbUserFilter) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_KRB_USER_FILTER, getKrbUserFilter());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setKrbUserFilter(krbUserFilter);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setKrbUserFilter(krbUserFilter);
    }
    
    /**
     * Get whether secure socket communication is enabled to the Lightweight Directory Access
     * Protocol (LDAP) server.
     * 
     * @return true if SSL communication is enabled
     * @throws Exception
     */
    public boolean getSslEnabled() throws Exception {
        if(getAttributes().getSslEnabled() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            String enabled = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "sslEnabled").toString();
            getAttributes().setSslEnabled(new Boolean(enabled));
        }
        return getAttributes().getSslEnabled();
    }

    /**
     * Set whether secure socket communication is enabled to the Lightweight Directory Access
     * Protocol (LDAP) server.
     * 
     * @param sslEnabled true to enable SSL communication
     * @throws Exception
     */
    public void setSslEnabled(boolean sslEnabled) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_SSL_CONFIG, getSslConfig());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setSslEnabled(sslEnabled);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setSslEnabled(sslEnabled);
    }
    
    /**
     * Get the SSL configuration alias to use for LDAP outbound SSL communications.
     * 
     * @return The SSL configuration alias
     * @throws Exception
     */
    public String getSslConfig() throws Exception {
        if(getAttributes().getSslConfig() == null) {
            Cell cell = parent.getSecurityDomain().getCell();
            AbstractSession session = cell.getWorkspace().getSession();
            String config = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().getAttribute(cell, session, configId, "sslConfig").toString();
            getAttributes().setSslConfig(config);
        }
        return getAttributes().getSslConfig();
    }

    /**
     * Set the SSL configuration alias to use for LDAP outbound SSL communications.
     * 
     * @param sslConfig The SSL configuration alias to set
     * @throws Exception
     */
    public void setSslConfig(String sslConfig) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_SSL_CONFIG, getSslConfig());

        LDAPSettings settings = (LDAPSettings)getEmptyAttributes();
        settings.setSslConfig(sslConfig);
        parent.configureUserRealm(type, settings, false);
        getAttributes().setSslConfig(sslConfig);
    }
    
    /**
     * Get the attributes of this realm
     * 
     * @return The attributes of the realm
     */
    private LDAPSettings getAttributes() {
        return (LDAPSettings)getRealmAttributes();
    }

    public void commit(HashMap<String, Object> values) {
    	super.commit(values);
    }

    public void rollback(HashMap<String, Object> values) {
    	super.rollback(values);
        for(Map.Entry<String, Object> entry : values.entrySet()) {
        	String key = entry.getKey();
        	Object value = entry.getValue();
        	
            if(key.equals(CHANGE_KEY_LDAP_HOST)) {
                getAttributes().setLdapHost((String)value);
            } else if(key.equals(CHANGE_KEY_LDAP_PORT)) {
                getAttributes().setLdapPort((Integer)value);
            } else if(key.equals(CHANGE_KEY_LDAP_TYPE)) {
                getAttributes().setLdapType((LDAPServerType)value);
            } else if(key.equals(CHANGE_KEY_BASE_DN)) {
                getAttributes().setBaseDN((String)value);
            } else if(key.equals(CHANGE_KEY_BIND_DN)) {
                getAttributes().setBindDN((String)value);
            } else if(key.equals(CHANGE_KEY_SEARCH_TIMEOUT)) {
                getAttributes().setSearchTimeout((Integer)value);
            } else if(key.equals(CHANGE_KEY_REUSE_CONN)) {
                getAttributes().setReuseConnection((Boolean)value);
            } else if(key.equals(CHANGE_KEY_USER_FILTER)) {
                getAttributes().setUserFilter((String)value);
            } else if(key.equals(CHANGE_KEY_GROUP_FILTER)) {
                getAttributes().setGroupFilter((String)value);
            } else if(key.equals(CHANGE_KEY_USER_MAP)) {
                getAttributes().setUserIdMap((String)value);
            } else if(key.equals(CHANGE_KEY_GROUP_MAP)) {
                getAttributes().setGroupIdMap((String)value);
            } else if(key.equals(CHANGE_KEY_GROUP_MEMBER_MAP)) {
                getAttributes().setGroupMemberIdMap((String)value);
            } else if(key.equals(CHANGE_KEY_CERT_MAP_MODE)) {
                getAttributes().setCertificateMapMode((String)value);
            } else if(key.equals(CHANGE_KEY_CERT_FILTER)) {
                getAttributes().setCertificateFilter((String)value);
            } else if(key.equals(CHANGE_KEY_KRB_USER_FILTER)) {
                getAttributes().setKrbUserFilter((String)value);
            } else if(key.equals(CHANGE_KEY_SSL_ENABLED)) {
                getAttributes().setSslEnabled((Boolean)value);
            } else if(key.equals(CHANGE_KEY_SSL_CONFIG)) {
                getAttributes().setSslConfig((String)value);
            }
        }
    }

}
