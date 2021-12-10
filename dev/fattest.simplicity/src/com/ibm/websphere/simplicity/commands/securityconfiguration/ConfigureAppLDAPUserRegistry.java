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

package com.ibm.websphere.simplicity.commands.securityconfiguration;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Configures an LDAP user registry in an application security domain
 *   'verifyRegistry': Check that the user registry is configured correctly to perform user registry lookups.
 *   'certificateFilter': If you specify the certificate map mode, use this property to specify the LDAP filter, which maps attributes in the client certificate to entries in LDAP.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'sslEnabled': SSL enabled status.
 *   'sslConfig': SSL configuration to use for a security LDAP connection.
 *   'customProperties': Add, modify, or remove custom properties on the security object.
 *   'groupFilter': Specifies an LDAP filter clause for searching the user registry for groups.
 *   'userFilter': Specifies an LDAP filter clause for searching the user registry for users.
 *   'groupMemberIdMap': Specifies an LDAP filter that identifies user to group memberships.
 *   'groupIdMap': Specifies an LDAP filter that maps the short name of a group to an LDAP entry.
 *   'userIdMap': Specifies an LDAP filter that maps the short name of a user to an LDAP entry.
 *   'ignoreCase': Specifies that a case-insensitive authorization check be performed: true/false.
 *   'realmName': Name of the realm.
 *   'searchTimeout': Specifies the timeout value, in seconds, for an LDAP server to respond before canceling a request.
 *   'certificateMapMode': Specifies whether to map X.509 certificates into an LDAP directory by EXACT_DN or CERTIFICATE_FILTER. Specify CERTIFICATE_FILTER to use the specified certificate filter for the mapping.
 *   'reuseConnection': Specifies, by default, that the application server reuses the LDAP connection.
 *   'nestedGroupSearch': Specify true to perform a recursive nested group search and false not to perform a recursive nested group search.
 *   'ldapServerType': Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
 *   'baseDN': Supply a valid LDAP base distinguished name.
 *   'bindDN': Supply a valid LDAP bind distinguished name.
 *   'bindPassword': Supply a valid LDAP bind password.
 *   'ldapHost': Supply a valid LDAP host name for the LDAP server.
 *   'ldapPort': Supply a valid port number for the LDAP server.
 *   'krbUserFilter': The kerberos user filter used to search for users when kerberos authentication mechanism is enabled.
 * The required parameters are found in the constructor.
 */
public class ConfigureAppLDAPUserRegistry extends Command {

	private Boolean verifyRegistry = true;
	private String certificateFilter;
	private String securityDomainName;
	private Boolean sslEnabled;
	private String sslConfig;
	private String customProperties;
	private String groupFilter;
	private String userFilter;
	private String groupMemberIdMap;
	private String groupIdMap;
	private String userIdMap;
	private Boolean ignoreCase;
	private String realmName;
	private Long searchTimeout;
	private String certificateMapMode;
	private Boolean reuseConnection;
	private Boolean nestedGroupSearch;
	private String ldapServerType;
	private String baseDN;
	private String bindDN;
	private String bindPassword;
	private String ldapHost;
	private String ldapPort;
	private String krbUserFilter;

	public ConfigureAppLDAPUserRegistry(String securityDomainName) {
		super("configureAppLDAPUserRegistry");
		this.securityDomainName = securityDomainName;
	}

	/**
	 * Check that the user registry is configured correctly to perform user registry lookups.
	 */
	public Boolean getVerifyRegistry() {
		return this.verifyRegistry;
	}

	/**
	 * Check that the user registry is configured correctly to perform user registry lookups.
	 */
	public void setVerifyRegistry(Boolean value) {
		this.verifyRegistry = value;
	}

	/**
	 * If you specify the certificate map mode, use this property to specify the LDAP filter, which maps attributes in the client certificate to entries in LDAP.
	 */
	public String getCertificateFilter() {
		return this.certificateFilter;
	}

	/**
	 * If you specify the certificate map mode, use this property to specify the LDAP filter, which maps attributes in the client certificate to entries in LDAP.
	 */
	public void setCertificateFilter(String value) {
		this.certificateFilter = value;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * SSL enabled status.
	 */
	public Boolean getSslEnabled() {
		return this.sslEnabled;
	}

	/**
	 * SSL enabled status.
	 */
	public void setSslEnabled(Boolean value) {
		this.sslEnabled = value;
	}

	/**
	 * SSL configuration to use for a security LDAP connection.
	 */
	public String getSslConfig() {
		return this.sslConfig;
	}

	/**
	 * SSL configuration to use for a security LDAP connection.
	 */
	public void setSslConfig(String value) {
		this.sslConfig = value;
	}

	/**
	 * Add, modify, or remove custom properties on the security object.
	 */
	public String getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Add, modify, or remove custom properties on the security object.
	 */
	public void setCustomProperties(String value) {
		this.customProperties = value;
	}

	/**
	 * Specifies an LDAP filter clause for searching the user registry for groups.
	 */
	public String getGroupFilter() {
		return this.groupFilter;
	}

	/**
	 * Specifies an LDAP filter clause for searching the user registry for groups.
	 */
	public void setGroupFilter(String value) {
		this.groupFilter = value;
	}

	/**
	 * Specifies an LDAP filter clause for searching the user registry for users.
	 */
	public String getUserFilter() {
		return this.userFilter;
	}

	/**
	 * Specifies an LDAP filter clause for searching the user registry for users.
	 */
	public void setUserFilter(String value) {
		this.userFilter = value;
	}

	/**
	 * Specifies an LDAP filter that identifies user to group memberships.
	 */
	public String getGroupMemberIdMap() {
		return this.groupMemberIdMap;
	}

	/**
	 * Specifies an LDAP filter that identifies user to group memberships.
	 */
	public void setGroupMemberIdMap(String value) {
		this.groupMemberIdMap = value;
	}

	/**
	 * Specifies an LDAP filter that maps the short name of a group to an LDAP entry.
	 */
	public String getGroupIdMap() {
		return this.groupIdMap;
	}

	/**
	 * Specifies an LDAP filter that maps the short name of a group to an LDAP entry.
	 */
	public void setGroupIdMap(String value) {
		this.groupIdMap = value;
	}

	/**
	 * Specifies an LDAP filter that maps the short name of a user to an LDAP entry.
	 */
	public String getUserIdMap() {
		return this.userIdMap;
	}

	/**
	 * Specifies an LDAP filter that maps the short name of a user to an LDAP entry.
	 */
	public void setUserIdMap(String value) {
		this.userIdMap = value;
	}

	/**
	 * Specifies that a case-insensitive authorization check be performed: true/false.
	 */
	public Boolean getIgnoreCase() {
		return this.ignoreCase;
	}

	/**
	 * Specifies that a case-insensitive authorization check be performed: true/false.
	 */
	public void setIgnoreCase(Boolean value) {
		this.ignoreCase = value;
	}

	/**
	 * Name of the realm.
	 */
	public String getRealmName() {
		return this.realmName;
	}

	/**
	 * Name of the realm.
	 */
	public void setRealmName(String value) {
		this.realmName = value;
	}

	/**
	 * Specifies the timeout value, in seconds, for an LDAP server to respond before canceling a request.
	 */
	public Long getSearchTimeout() {
		return this.searchTimeout;
	}

	/**
	 * Specifies the timeout value, in seconds, for an LDAP server to respond before canceling a request.
	 */
	public void setSearchTimeout(Long value) {
		this.searchTimeout = value;
	}

	/**
	 * Specifies whether to map X.509 certificates into an LDAP directory by EXACT_DN or CERTIFICATE_FILTER. Specify CERTIFICATE_FILTER to use the specified certificate filter for the mapping.
	 */
	public String getCertificateMapMode() {
		return this.certificateMapMode;
	}

	/**
	 * Specifies whether to map X.509 certificates into an LDAP directory by EXACT_DN or CERTIFICATE_FILTER. Specify CERTIFICATE_FILTER to use the specified certificate filter for the mapping.
	 */
	public void setCertificateMapMode(String value) {
		this.certificateMapMode = value;
	}

	/**
	 * Specifies, by default, that the application server reuses the LDAP connection.
	 */
	public Boolean getReuseConnection() {
		return this.reuseConnection;
	}

	/**
	 * Specifies, by default, that the application server reuses the LDAP connection.
	 */
	public void setReuseConnection(Boolean value) {
		this.reuseConnection = value;
	}

	/**
	 * Specify true to perform a recursive nested group search and false not to perform a recursive nested group search.
	 */
	public Boolean getNestedGroupSearch() {
		return this.nestedGroupSearch;
	}

	/**
	 * Specify true to perform a recursive nested group search and false not to perform a recursive nested group search.
	 */
	public void setNestedGroupSearch(Boolean value) {
		this.nestedGroupSearch = value;
	}

	/**
	 * Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
	 */
	public String getLdapServerType() {
		return this.ldapServerType;
	}

	/**
	 * Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
	 */
	public void setLdapServerType(String value) {
		this.ldapServerType = value;
	}

	/**
	 * Supply a valid LDAP base distinguished name.
	 */
	public String getBaseDN() {
		return this.baseDN;
	}

	/**
	 * Supply a valid LDAP base distinguished name.
	 */
	public void setBaseDN(String value) {
		this.baseDN = value;
	}

	/**
	 * Supply a valid LDAP bind distinguished name.
	 */
	public String getBindDN() {
		return this.bindDN;
	}

	/**
	 * Supply a valid LDAP bind distinguished name.
	 */
	public void setBindDN(String value) {
		this.bindDN = value;
	}

	/**
	 * Supply a valid LDAP bind password.
	 */
	public String getBindPassword() {
		return this.bindPassword;
	}

	/**
	 * Supply a valid LDAP bind password.
	 */
	public void setBindPassword(String value) {
		this.bindPassword = value;
	}

	/**
	 * Supply a valid LDAP host name for the LDAP server.
	 */
	public String getLdapHost() {
		return this.ldapHost;
	}

	/**
	 * Supply a valid LDAP host name for the LDAP server.
	 */
	public void setLdapHost(String value) {
		this.ldapHost = value;
	}

	/**
	 * Supply a valid port number for the LDAP server.
	 */
	public String getLdapPort() {
		return this.ldapPort;
	}

	/**
	 * Supply a valid port number for the LDAP server.
	 */
	public void setLdapPort(String value) {
		this.ldapPort = value;
	}

	/**
	 * The kerberos user filter used to search for users when kerberos authentication mechanism is enabled.
	 */
	public String getKrbUserFilter() {
		return this.krbUserFilter;
	}

	/**
	 * The kerberos user filter used to search for users when kerberos authentication mechanism is enabled.
	 */
	public void setKrbUserFilter(String value) {
		this.krbUserFilter = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.verifyRegistry != null) {
			ret.put("verifyRegistry", this.verifyRegistry);
		}
		if (this.certificateFilter != null) {
			ret.put("certificateFilter", this.certificateFilter);
		}
		ret.put("securityDomainName", this.securityDomainName);
		if (this.sslEnabled != null) {
			ret.put("sslEnabled", this.sslEnabled);
		}
		if (this.sslConfig != null) {
			ret.put("sslConfig", this.sslConfig);
		}
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.groupFilter != null) {
			ret.put("groupFilter", this.groupFilter);
		}
		if (this.userFilter != null) {
			ret.put("userFilter", this.userFilter);
		}
		if (this.groupMemberIdMap != null) {
			ret.put("groupMemberIdMap", this.groupMemberIdMap);
		}
		if (this.groupIdMap != null) {
			ret.put("groupIdMap", this.groupIdMap);
		}
		if (this.userIdMap != null) {
			ret.put("userIdMap", this.userIdMap);
		}
		if (this.ignoreCase != null) {
			ret.put("ignoreCase", this.ignoreCase);
		}
		if (this.realmName != null) {
			ret.put("realmName", this.realmName);
		}
		if (this.searchTimeout != null) {
			ret.put("searchTimeout", this.searchTimeout);
		}
		if (this.certificateMapMode != null) {
			ret.put("certificateMapMode", this.certificateMapMode);
		}
		if (this.reuseConnection != null) {
			ret.put("reuseConnection", this.reuseConnection);
		}
		if (this.nestedGroupSearch != null) {
			ret.put("nestedGroupSearch", this.nestedGroupSearch);
		}
		if (this.ldapServerType != null) {
			ret.put("ldapServerType", this.ldapServerType);
		}
		if (this.baseDN != null) {
			ret.put("baseDN", this.baseDN);
		}
		if (this.bindDN != null) {
			ret.put("bindDN", this.bindDN);
		}
		if (this.bindPassword != null) {
			ret.put("bindPassword", this.bindPassword);
		}
		if (this.ldapHost != null) {
			ret.put("ldapHost", this.ldapHost);
		}
		if (this.ldapPort != null) {
			ret.put("ldapPort", this.ldapPort);
		}
		if (this.krbUserFilter != null) {
			ret.put("krbUserFilter", this.krbUserFilter);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
