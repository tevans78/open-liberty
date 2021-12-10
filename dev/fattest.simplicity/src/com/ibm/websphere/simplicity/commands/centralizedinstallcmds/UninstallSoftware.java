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

package com.ibm.websphere.simplicity.commands.centralizedinstallcmds;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Uninstalls the specified software package from the target host.
 *   'packageName': Specifies the short name of the software package.
 *   'hostName': Specifies the domain-qualified host name of the remote host.
 *   'platformType': The platform type of the remote host.  Must be one of: "Windows", "AIX", "HP-UX", "Linux", "OS400" or "Solaris". This parameter is not case-sensitive.
 *   'installLocation': The absolute path of the directory on the target workstation where the software was installed.
 *   'adminName': The login ID of an administrator of the remote host.
 *   'adminPassword': The login password of an administrator of the remote host. (Either the adminPassword or the privateKeyStore must be specified for authentication.)
 *   'privateKeyStore': The absolute path to the private key file on the deployment manager host. (Either the privateKeyStore or the adminPassword must be specified for authentication.)
 *   'keyStorePassword': The optional password (also called passPhrase) used to protect the private key store.
 *   'specialParms': optional name-value pairs for other parameters that may be required.  Information on any required name-value pairs should be obtained from the provider of the software package.
 * The required parameters are found in the constructor.
 */
public class UninstallSoftware extends Command {

	private String packageName;
	private String hostName;
	private String platformType;
	private String installLocation;
	private String adminName;
	private String adminPassword;
	private String privateKeyStore;
	private String keyStorePassword;
	private java.util.Properties specialParms;

	public UninstallSoftware(String packageName, String hostName, String platformType, String installLocation, String adminName) {
		super("uninstallSoftware");
		this.packageName = packageName;
		this.hostName = hostName;
		this.platformType = platformType;
		this.installLocation = installLocation;
		this.adminName = adminName;
	}

	/**
	 * Specifies the short name of the software package.
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * Specifies the short name of the software package.
	 */
	public void setPackageName(String value) {
		this.packageName = value;
	}

	/**
	 * Specifies the domain-qualified host name of the remote host.
	 */
	public String getHostName() {
		return this.hostName;
	}

	/**
	 * Specifies the domain-qualified host name of the remote host.
	 */
	public void setHostName(String value) {
		this.hostName = value;
	}

	/**
	 * The platform type of the remote host.  Must be one of: "Windows", "AIX", "HP-UX", "Linux", "OS400" or "Solaris". This parameter is not case-sensitive.
	 */
	public String getPlatformType() {
		return this.platformType;
	}

	/**
	 * The platform type of the remote host.  Must be one of: "Windows", "AIX", "HP-UX", "Linux", "OS400" or "Solaris". This parameter is not case-sensitive.
	 */
	public void setPlatformType(String value) {
		this.platformType = value;
	}

	/**
	 * The absolute path of the directory on the target workstation where the software was installed.
	 */
	public String getInstallLocation() {
		return this.installLocation;
	}

	/**
	 * The absolute path of the directory on the target workstation where the software was installed.
	 */
	public void setInstallLocation(String value) {
		this.installLocation = value;
	}

	/**
	 * The login ID of an administrator of the remote host.
	 */
	public String getAdminName() {
		return this.adminName;
	}

	/**
	 * The login ID of an administrator of the remote host.
	 */
	public void setAdminName(String value) {
		this.adminName = value;
	}

	/**
	 * The login password of an administrator of the remote host. (Either the adminPassword or the privateKeyStore must be specified for authentication.)
	 */
	public String getAdminPassword() {
		return this.adminPassword;
	}

	/**
	 * The login password of an administrator of the remote host. (Either the adminPassword or the privateKeyStore must be specified for authentication.)
	 */
	public void setAdminPassword(String value) {
		this.adminPassword = value;
	}

	/**
	 * The absolute path to the private key file on the deployment manager host. (Either the privateKeyStore or the adminPassword must be specified for authentication.)
	 */
	public String getPrivateKeyStore() {
		return this.privateKeyStore;
	}

	/**
	 * The absolute path to the private key file on the deployment manager host. (Either the privateKeyStore or the adminPassword must be specified for authentication.)
	 */
	public void setPrivateKeyStore(String value) {
		this.privateKeyStore = value;
	}

	/**
	 * The optional password (also called passPhrase) used to protect the private key store.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * The optional password (also called passPhrase) used to protect the private key store.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * optional name-value pairs for other parameters that may be required.  Information on any required name-value pairs should be obtained from the provider of the software package.
	 */
	public java.util.Properties getSpecialParms() {
		return this.specialParms;
	}

	/**
	 * optional name-value pairs for other parameters that may be required.  Information on any required name-value pairs should be obtained from the provider of the software package.
	 */
	public void setSpecialParms(java.util.Properties value) {
		this.specialParms = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("packageName", this.packageName);
		ret.put("hostName", this.hostName);
		ret.put("platformType", this.platformType);
		ret.put("installLocation", this.installLocation);
		ret.put("adminName", this.adminName);
		if (this.adminPassword != null) {
			ret.put("adminPassword", this.adminPassword);
		}
		if (this.privateKeyStore != null) {
			ret.put("privateKeyStore", this.privateKeyStore);
		}
		if (this.keyStorePassword != null) {
			ret.put("keyStorePassword", this.keyStorePassword);
		}
		if (this.specialParms != null) {
			ret.put("specialParms", this.specialParms);
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
