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
 * This command creates a Kerberos configuration file (krb5.ini or krb5.conf).
 *   'realm': Supply Kerberos realm name.
 *   'encryption': Supply encryption type (default: rc4-hmac des-cbc-md5).
 *   'krbPath': Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
 *   'keytabPath': Supply directory location and file name of the Kerberos keytab file.
 *   'kdcHost': Supply host name of the Kerberos Key Distribution Center.
 *   'kdcPort': Supply port number of the Kerberos Key Distribution Center (default: 88).
 *   'dns': Supply the Domain Name Service (DNS).
 * The required parameters are found in the constructor.
 */
public class CreateKrbConfigFile extends Command {

	private String realm;
	private String encryption;
	private String krbPath;
	private String keytabPath;
	private String kdcHost;
	private Integer kdcPort;
	private String dns;

	public CreateKrbConfigFile(String realm, String krbPath, String keytabPath, String kdcHost, String dns) {
		super("createKrbConfigFile");
		this.realm = realm;
		this.krbPath = krbPath;
		this.keytabPath = keytabPath;
		this.kdcHost = kdcHost;
		this.dns = dns;
	}

	/**
	 * Supply Kerberos realm name.
	 */
	public String getRealm() {
		return this.realm;
	}

	/**
	 * Supply Kerberos realm name.
	 */
	public void setRealm(String value) {
		this.realm = value;
	}

	/**
	 * Supply encryption type (default: rc4-hmac des-cbc-md5).
	 */
	public String getEncryption() {
		return this.encryption;
	}

	/**
	 * Supply encryption type (default: rc4-hmac des-cbc-md5).
	 */
	public void setEncryption(String value) {
		this.encryption = value;
	}

	/**
	 * Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
	 */
	public String getKrbPath() {
		return this.krbPath;
	}

	/**
	 * Supply directory location and file name of the configuration (krb5.ini or krb5.conf) file.
	 */
	public void setKrbPath(String value) {
		this.krbPath = value;
	}

	/**
	 * Supply directory location and file name of the Kerberos keytab file.
	 */
	public String getKeytabPath() {
		return this.keytabPath;
	}

	/**
	 * Supply directory location and file name of the Kerberos keytab file.
	 */
	public void setKeytabPath(String value) {
		this.keytabPath = value;
	}

	/**
	 * Supply host name of the Kerberos Key Distribution Center.
	 */
	public String getKdcHost() {
		return this.kdcHost;
	}

	/**
	 * Supply host name of the Kerberos Key Distribution Center.
	 */
	public void setKdcHost(String value) {
		this.kdcHost = value;
	}

	/**
	 * Supply port number of the Kerberos Key Distribution Center (default: 88).
	 */
	public Integer getKdcPort() {
		return this.kdcPort;
	}

	/**
	 * Supply port number of the Kerberos Key Distribution Center (default: 88).
	 */
	public void setKdcPort(Integer value) {
		this.kdcPort = value;
	}

	/**
	 * Supply the Domain Name Service (DNS).
	 */
	public String getDns() {
		return this.dns;
	}

	/**
	 * Supply the Domain Name Service (DNS).
	 */
	public void setDns(String value) {
		this.dns = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("realm", this.realm);
		if (this.encryption != null) {
			ret.put("encryption", this.encryption);
		}
		ret.put("krbPath", this.krbPath);
		ret.put("keytabPath", this.keytabPath);
		ret.put("kdcHost", this.kdcHost);
		if (this.kdcPort != null) {
			ret.put("kdcPort", this.kdcPort);
		}
		ret.put("dns", this.dns);
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
