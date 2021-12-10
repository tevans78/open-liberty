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

package com.ibm.websphere.simplicity.commands.spnegotai;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Validates the Kerberos configuration data either in the global security configuration file security.xml or specified as an input parameters.
 *   'checkConfigOnly': Check without validate of the Kerberos configuration, must use Global security for this check.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'serverId': Server identity used for internal process communications
 *   'krb5Spn': Specifies the Kerberos service principal name in the Kerberos keytab file.
 *   'serverIdPassword': Specifies the password that is used for the server identity.
 *   'krb5Config': Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
 *   'krb5Keytab': Supply directory location and file name of the Kerberos keytab file.
 *   'krb5Realm': Supply value for Kerberos realm name.
 *   'useGlobalSecurityConfig': Using the Global Security configuration (security.xml) data instead of input parameters.
 *   'validateKrbRealm': Validate the Kerberos realm against the default Kerberos realm in the Kerberos configuration file (krb5.ini/krb5.conf).
 * The required parameters are found in the constructor.
 */
public class ValidateKrbConfig extends Command {

	private Boolean checkConfigOnly = true;
	private String securityDomainName;
	private String serverId;
	private String krb5Spn;
	private String serverIdPassword;
	private String krb5Config;
	private String krb5Keytab;
	private String krb5Realm;
	private Boolean useGlobalSecurityConfig = true;
	private Boolean validateKrbRealm = true;

	public ValidateKrbConfig(Boolean useGlobalSecurityConfig) {
		super("validateKrbConfig");
		this.useGlobalSecurityConfig = useGlobalSecurityConfig;
	}

	/**
	 * Check without validate of the Kerberos configuration, must use Global security for this check.
	 */
	public Boolean getCheckConfigOnly() {
		return this.checkConfigOnly;
	}

	/**
	 * Check without validate of the Kerberos configuration, must use Global security for this check.
	 */
	public void setCheckConfigOnly(Boolean value) {
		this.checkConfigOnly = value;
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
	 * Server identity used for internal process communications
	 */
	public String getServerId() {
		return this.serverId;
	}

	/**
	 * Server identity used for internal process communications
	 */
	public void setServerId(String value) {
		this.serverId = value;
	}

	/**
	 * Specifies the Kerberos service principal name in the Kerberos keytab file.
	 */
	public String getKrb5Spn() {
		return this.krb5Spn;
	}

	/**
	 * Specifies the Kerberos service principal name in the Kerberos keytab file.
	 */
	public void setKrb5Spn(String value) {
		this.krb5Spn = value;
	}

	/**
	 * Specifies the password that is used for the server identity.
	 */
	public String getServerIdPassword() {
		return this.serverIdPassword;
	}

	/**
	 * Specifies the password that is used for the server identity.
	 */
	public void setServerIdPassword(String value) {
		this.serverIdPassword = value;
	}

	/**
	 * Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
	 */
	public String getKrb5Config() {
		return this.krb5Config;
	}

	/**
	 * Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
	 */
	public void setKrb5Config(String value) {
		this.krb5Config = value;
	}

	/**
	 * Supply directory location and file name of the Kerberos keytab file.
	 */
	public String getKrb5Keytab() {
		return this.krb5Keytab;
	}

	/**
	 * Supply directory location and file name of the Kerberos keytab file.
	 */
	public void setKrb5Keytab(String value) {
		this.krb5Keytab = value;
	}

	/**
	 * Supply value for Kerberos realm name.
	 */
	public String getKrb5Realm() {
		return this.krb5Realm;
	}

	/**
	 * Supply value for Kerberos realm name.
	 */
	public void setKrb5Realm(String value) {
		this.krb5Realm = value;
	}

	/**
	 * Using the Global Security configuration (security.xml) data instead of input parameters.
	 */
	public Boolean getUseGlobalSecurityConfig() {
		return this.useGlobalSecurityConfig;
	}

	/**
	 * Using the Global Security configuration (security.xml) data instead of input parameters.
	 */
	public void setUseGlobalSecurityConfig(Boolean value) {
		this.useGlobalSecurityConfig = value;
	}

	/**
	 * Validate the Kerberos realm against the default Kerberos realm in the Kerberos configuration file (krb5.ini/krb5.conf).
	 */
	public Boolean getValidateKrbRealm() {
		return this.validateKrbRealm;
	}

	/**
	 * Validate the Kerberos realm against the default Kerberos realm in the Kerberos configuration file (krb5.ini/krb5.conf).
	 */
	public void setValidateKrbRealm(Boolean value) {
		this.validateKrbRealm = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.checkConfigOnly != null) {
			ret.put("checkConfigOnly", this.checkConfigOnly);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.serverId != null) {
			ret.put("serverId", this.serverId);
		}
		if (this.krb5Spn != null) {
			ret.put("krb5Spn", this.krb5Spn);
		}
		if (this.serverIdPassword != null) {
			ret.put("serverIdPassword", this.serverIdPassword);
		}
		if (this.krb5Config != null) {
			ret.put("krb5Config", this.krb5Config);
		}
		if (this.krb5Keytab != null) {
			ret.put("krb5Keytab", this.krb5Keytab);
		}
		if (this.krb5Realm != null) {
			ret.put("krb5Realm", this.krb5Realm);
		}
		ret.put("useGlobalSecurityConfig", this.useGlobalSecurityConfig);
		if (this.validateKrbRealm != null) {
			ret.put("validateKrbRealm", this.validateKrbRealm);
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
