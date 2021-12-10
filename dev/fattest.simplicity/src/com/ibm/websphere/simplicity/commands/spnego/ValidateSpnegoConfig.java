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
 * Validates the SPNEGO Web authentication configuration.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'krb5Config': Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
 *   'krb5Keytab': Supply directory location and file name of the Kerberos keytab file.
 * The required parameters are found in the constructor.
 */
public class ValidateSpnegoConfig extends Command {

	private String securityDomainName;
	private String krb5Config;
	private String krb5Keytab;

	public ValidateSpnegoConfig(String krb5Config) {
		super("validateSpnegoConfig");
		this.krb5Config = krb5Config;
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
