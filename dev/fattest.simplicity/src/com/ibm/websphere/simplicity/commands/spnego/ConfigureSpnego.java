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

package com.ibm.websphere.simplicity.commands.spnego;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command configures SPNEGO Web Authentication in the security configuration.
 *   'allowAppAuthMethodFallback': Indicates whether or not to allow fall back to application authentication mechanism.
 *   'enabled': Indicate whether or not enable SPNEGO Web authentication.
 *   'dynamicReload': Indicates whether or not to enable dynamic reload for SPNEGO Web authentication filters.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'krb5Config': Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
 *   'krb5Keytab': Supply directory location and file name of the Kerberos keytab file.
 * The required parameters are found in the constructor.
 */
public class ConfigureSpnego extends Command {

	private Boolean allowAppAuthMethodFallback = false;
	private Boolean enabled = true;
	private Boolean dynamicReload = false;
	private String securityDomainName;
	private String krb5Config;
	private String krb5Keytab;

	public ConfigureSpnego(String krb5Config) {
		super("configureSpnego");
		this.krb5Config = krb5Config;
	}

	/**
	 * Indicates whether or not to allow fall back to application authentication mechanism.
	 */
	public Boolean getAllowAppAuthMethodFallback() {
		return this.allowAppAuthMethodFallback;
	}

	/**
	 * Indicates whether or not to allow fall back to application authentication mechanism.
	 */
	public void setAllowAppAuthMethodFallback(Boolean value) {
		this.allowAppAuthMethodFallback = value;
	}

	/**
	 * Indicate whether or not enable SPNEGO Web authentication.
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * Indicate whether or not enable SPNEGO Web authentication.
	 */
	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	/**
	 * Indicates whether or not to enable dynamic reload for SPNEGO Web authentication filters.
	 */
	public Boolean getDynamicReload() {
		return this.dynamicReload;
	}

	/**
	 * Indicates whether or not to enable dynamic reload for SPNEGO Web authentication filters.
	 */
	public void setDynamicReload(Boolean value) {
		this.dynamicReload = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.allowAppAuthMethodFallback != null) {
			ret.put("allowAppAuthMethodFallback", this.allowAppAuthMethodFallback);
		}
		if (this.enabled != null) {
			ret.put("enabled", this.enabled);
		}
		if (this.dynamicReload != null) {
			ret.put("dynamicReload", this.dynamicReload);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		ret.put("krb5Config", this.krb5Config);
		if (this.krb5Keytab != null) {
			ret.put("krb5Keytab", this.krb5Keytab);
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
