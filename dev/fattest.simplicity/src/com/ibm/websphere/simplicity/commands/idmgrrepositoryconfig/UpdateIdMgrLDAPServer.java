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

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates an LDAP server configuration of the LDAP repository configuration.
 *   'authentication': The authentication method to use.
 *   'bindDN': The binding distinguished name for the LDAP server.
 *   'bindPassword': The LDAP server binding password.
 *   'certificateFilter': If you specify the certificate map mode, use this property to specify the LDAP filter, which maps attributes in the client certificate to entries in LDAP.
 *   'certificateMapMode': Specifies whether to map X.509 certificates into an LDAP directory by exact distinguished name or certificate filter. Specify the certificate filter to use the specified certificate filter for the mapping.
 *   'connectTimeout': Connection timeout(in seconds)
 *   'connectionPool': LDAP connection pool
 *   'derefAliases': Controls how aliases are dereferenced. Possible values are always(default), never, finding, and searching.
 *   'host': The host name for the LDAP server.
 *   'id': The unique identifier of the repository.
 *   'ldapServerType': The type of LDAP server used.
 *   'port': The port number for the LDAP server.
 *   'primary_host': Primary host of the LDAP server.
 *   'referal': LDAP referral
 *   'sslConfiguration': Secure Sockets Layer (SSL) configuration
 *   'sslEnabled': Enable Secure Sockets Layer (SSL) for the LDAP server.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrLDAPServer extends Command {

	private String authentication;
	private String bindDN;
	private String bindPassword;
	private String certificateFilter;
	private String certificateMapMode;
	private Integer connectTimeout;
	private Boolean connectionPool;
	private String derefAliases;
	private String host;
	private String id;
	private String ldapServerType;
	private Integer port;
	private String primary_host;
	private String referal;
	private String sslConfiguration;
	private Boolean sslEnabled;

	public UpdateIdMgrLDAPServer(String host, String id) {
		super("updateIdMgrLDAPServer");
		this.host = host;
		this.id = id;
	}

	/**
	 * The authentication method to use.
	 */
	public String getAuthentication() {
		return this.authentication;
	}

	/**
	 * The authentication method to use.
	 */
	public void setAuthentication(String value) {
		this.authentication = value;
	}

	/**
	 * The binding distinguished name for the LDAP server.
	 */
	public String getBindDN() {
		return this.bindDN;
	}

	/**
	 * The binding distinguished name for the LDAP server.
	 */
	public void setBindDN(String value) {
		this.bindDN = value;
	}

	/**
	 * The LDAP server binding password.
	 */
	public String getBindPassword() {
		return this.bindPassword;
	}

	/**
	 * The LDAP server binding password.
	 */
	public void setBindPassword(String value) {
		this.bindPassword = value;
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
	 * Specifies whether to map X.509 certificates into an LDAP directory by exact distinguished name or certificate filter. Specify the certificate filter to use the specified certificate filter for the mapping.
	 */
	public String getCertificateMapMode() {
		return this.certificateMapMode;
	}

	/**
	 * Specifies whether to map X.509 certificates into an LDAP directory by exact distinguished name or certificate filter. Specify the certificate filter to use the specified certificate filter for the mapping.
	 */
	public void setCertificateMapMode(String value) {
		this.certificateMapMode = value;
	}

	/**
	 * Connection timeout(in seconds)
	 */
	public Integer getConnectTimeout() {
		return this.connectTimeout;
	}

	/**
	 * Connection timeout(in seconds)
	 */
	public void setConnectTimeout(Integer value) {
		this.connectTimeout = value;
	}

	/**
	 * LDAP connection pool
	 */
	public Boolean getConnectionPool() {
		return this.connectionPool;
	}

	/**
	 * LDAP connection pool
	 */
	public void setConnectionPool(Boolean value) {
		this.connectionPool = value;
	}

	/**
	 * Controls how aliases are dereferenced. Possible values are always(default), never, finding, and searching.
	 */
	public String getDerefAliases() {
		return this.derefAliases;
	}

	/**
	 * Controls how aliases are dereferenced. Possible values are always(default), never, finding, and searching.
	 */
	public void setDerefAliases(String value) {
		this.derefAliases = value;
	}

	/**
	 * The host name for the LDAP server.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * The host name for the LDAP server.
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * The type of LDAP server used.
	 */
	public String getLdapServerType() {
		return this.ldapServerType;
	}

	/**
	 * The type of LDAP server used.
	 */
	public void setLdapServerType(String value) {
		this.ldapServerType = value;
	}

	/**
	 * The port number for the LDAP server.
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * The port number for the LDAP server.
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * Primary host of the LDAP server.
	 */
	public String getPrimary_host() {
		return this.primary_host;
	}

	/**
	 * Primary host of the LDAP server.
	 */
	public void setPrimary_host(String value) {
		this.primary_host = value;
	}

	/**
	 * LDAP referral
	 */
	public String getReferal() {
		return this.referal;
	}

	/**
	 * LDAP referral
	 */
	public void setReferal(String value) {
		this.referal = value;
	}

	/**
	 * Secure Sockets Layer (SSL) configuration
	 */
	public String getSslConfiguration() {
		return this.sslConfiguration;
	}

	/**
	 * Secure Sockets Layer (SSL) configuration
	 */
	public void setSslConfiguration(String value) {
		this.sslConfiguration = value;
	}

	/**
	 * Enable Secure Sockets Layer (SSL) for the LDAP server.
	 */
	public Boolean getSslEnabled() {
		return this.sslEnabled;
	}

	/**
	 * Enable Secure Sockets Layer (SSL) for the LDAP server.
	 */
	public void setSslEnabled(Boolean value) {
		this.sslEnabled = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.authentication != null) {
			ret.put("authentication", this.authentication);
		}
		if (this.bindDN != null) {
			ret.put("bindDN", this.bindDN);
		}
		if (this.bindPassword != null) {
			ret.put("bindPassword", this.bindPassword);
		}
		if (this.certificateFilter != null) {
			ret.put("certificateFilter", this.certificateFilter);
		}
		if (this.certificateMapMode != null) {
			ret.put("certificateMapMode", this.certificateMapMode);
		}
		if (this.connectTimeout != null) {
			ret.put("connectTimeout", this.connectTimeout);
		}
		if (this.connectionPool != null) {
			ret.put("connectionPool", this.connectionPool);
		}
		if (this.derefAliases != null) {
			ret.put("derefAliases", this.derefAliases);
		}
		ret.put("host", this.host);
		ret.put("id", this.id);
		if (this.ldapServerType != null) {
			ret.put("ldapServerType", this.ldapServerType);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.primary_host != null) {
			ret.put("primary_host", this.primary_host);
		}
		if (this.referal != null) {
			ret.put("referal", this.referal);
		}
		if (this.sslConfiguration != null) {
			ret.put("sslConfiguration", this.sslConfiguration);
		}
		if (this.sslEnabled != null) {
			ret.put("sslEnabled", this.sslEnabled);
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
