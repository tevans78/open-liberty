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

package com.ibm.websphere.simplicity.commands.wizard;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Validates the connection to the specified LDAP server.
 *   'baseDN': Base distinguished name.
 *   'bindDN': Bind distinguished name.
 *   'bindPassword': Bind password.
 *   'hostname': Name of LDAP host machine.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'port': Port number of LDAP server.
 *   'sslAlias': SSL alias name.
 *   'sslEnabled': SSL enabled status.
 *   'type': Valid LDAP registry type.
 * The required parameters are found in the constructor.
 */
public class ValidateLDAPConnection extends Command {

	private String baseDN;
	private String bindDN;
	private String bindPassword;
	private String hostname;
	private String securityDomainName;
	private Integer port;
	private String sslAlias;
	private Boolean sslEnabled;
	private String type;

	public ValidateLDAPConnection(String hostname, Boolean sslEnabled, String type) {
		super("validateLDAPConnection");
		this.hostname = hostname;
		this.sslEnabled = sslEnabled;
		this.type = type;
	}

	/**
	 * Base distinguished name.
	 */
	public String getBaseDN() {
		return this.baseDN;
	}

	/**
	 * Base distinguished name.
	 */
	public void setBaseDN(String value) {
		this.baseDN = value;
	}

	/**
	 * Bind distinguished name.
	 */
	public String getBindDN() {
		return this.bindDN;
	}

	/**
	 * Bind distinguished name.
	 */
	public void setBindDN(String value) {
		this.bindDN = value;
	}

	/**
	 * Bind password.
	 */
	public String getBindPassword() {
		return this.bindPassword;
	}

	/**
	 * Bind password.
	 */
	public void setBindPassword(String value) {
		this.bindPassword = value;
	}

	/**
	 * Name of LDAP host machine.
	 */
	public String getHostname() {
		return this.hostname;
	}

	/**
	 * Name of LDAP host machine.
	 */
	public void setHostname(String value) {
		this.hostname = value;
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
	 * Port number of LDAP server.
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * Port number of LDAP server.
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * SSL alias name.
	 */
	public String getSslAlias() {
		return this.sslAlias;
	}

	/**
	 * SSL alias name.
	 */
	public void setSslAlias(String value) {
		this.sslAlias = value;
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
	 * Valid LDAP registry type.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Valid LDAP registry type.
	 */
	public void setType(String value) {
		this.type = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.baseDN != null) {
			ret.put("baseDN", this.baseDN);
		}
		if (this.bindDN != null) {
			ret.put("bindDN", this.bindDN);
		}
		if (this.bindPassword != null) {
			ret.put("bindPassword", this.bindPassword);
		}
		ret.put("hostname", this.hostname);
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.sslAlias != null) {
			ret.put("sslAlias", this.sslAlias);
		}
		ret.put("sslEnabled", this.sslEnabled);
		ret.put("type", this.type);
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
