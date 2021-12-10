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
 * Installs specified maintenance on the target host.
 *   'packageName': Specifies the short name of the software package.
 *   'fileList': Specifies a comma-separated list of maintenance pak files to be installed on the remote target. For pre-defined maintenance package this list is ignored.
 *   'hostName': Specifies the domain-qualified host name of the remote host.
 *   'installLocation': The absolute path of the directory on the target workstation where the software was installed. Specify this only if there are multiple install locations known within the current cell on the same host.
 *   'adminName': The login ID of an administrator of the remote host.
 *   'adminPassword': The login password of an administrator of the remote host. (Either the adminPassword or the privateKeyStore must be specified for authentication.)
 *   'privateKeyStore': The absolute path to the private key file on the deployment manager host. (Either the privateKeyStore or the adminPassword must be specified for authentication.)
 *   'keyStorePassword': The optional password (also called passPhrase) used to protect the private key store.
 *   'specialParms': optional name-value pairs for other parameters that may be required.  Information on any required name-value pairs should be obtained from the provider of the software package.
 *   'tempDir': The directory path on the target host which the centralized installation manager could use as temporary work space. If this parameter is omitted, the centralized installation manager will use the native temporary directory of the target host.
 *   'acceptLicense': Specifies if the terms of the license agreement is accepted. Specify "true" to indicate that you have reviewed and agree to the terms of the IBM International Program License Agreement accompanying this program. If you do not agree to these terms, do not specify "true" and you will not be allowed to proceed with the installation of this program or package.  To view the license agreement and license information for the program, use the showLicenseAgreement AdminTask command.
 * The required parameters are found in the constructor.
 */
public class InstallMaintenance extends Command {

	private String packageName;
	private String fileList;
	private String hostName;
	private String installLocation;
	private String adminName;
	private String adminPassword;
	private String privateKeyStore;
	private String keyStorePassword;
	private java.util.Properties specialParms;
	private String tempDir;
	private Boolean acceptLicense;

	public InstallMaintenance(String packageName, String hostName, String adminName, Boolean acceptLicense) {
		super("installMaintenance");
		this.packageName = packageName;
		this.hostName = hostName;
		this.adminName = adminName;
		this.acceptLicense = acceptLicense;
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
	 * Specifies a comma-separated list of maintenance pak files to be installed on the remote target. For pre-defined maintenance package this list is ignored.
	 */
	public String getFileList() {
		return this.fileList;
	}

	/**
	 * Specifies a comma-separated list of maintenance pak files to be installed on the remote target. For pre-defined maintenance package this list is ignored.
	 */
	public void setFileList(String value) {
		this.fileList = value;
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
	 * The absolute path of the directory on the target workstation where the software was installed. Specify this only if there are multiple install locations known within the current cell on the same host.
	 */
	public String getInstallLocation() {
		return this.installLocation;
	}

	/**
	 * The absolute path of the directory on the target workstation where the software was installed. Specify this only if there are multiple install locations known within the current cell on the same host.
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

	/**
	 * The directory path on the target host which the centralized installation manager could use as temporary work space. If this parameter is omitted, the centralized installation manager will use the native temporary directory of the target host.
	 */
	public String getTempDir() {
		return this.tempDir;
	}

	/**
	 * The directory path on the target host which the centralized installation manager could use as temporary work space. If this parameter is omitted, the centralized installation manager will use the native temporary directory of the target host.
	 */
	public void setTempDir(String value) {
		this.tempDir = value;
	}

	/**
	 * Specifies if the terms of the license agreement is accepted. Specify "true" to indicate that you have reviewed and agree to the terms of the IBM International Program License Agreement accompanying this program. If you do not agree to these terms, do not specify "true" and you will not be allowed to proceed with the installation of this program or package.  To view the license agreement and license information for the program, use the showLicenseAgreement AdminTask command.
	 */
	public Boolean getAcceptLicense() {
		return this.acceptLicense;
	}

	/**
	 * Specifies if the terms of the license agreement is accepted. Specify "true" to indicate that you have reviewed and agree to the terms of the IBM International Program License Agreement accompanying this program. If you do not agree to these terms, do not specify "true" and you will not be allowed to proceed with the installation of this program or package.  To view the license agreement and license information for the program, use the showLicenseAgreement AdminTask command.
	 */
	public void setAcceptLicense(Boolean value) {
		this.acceptLicense = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("packageName", this.packageName);
		if (this.fileList != null) {
			ret.put("fileList", this.fileList);
		}
		ret.put("hostName", this.hostName);
		if (this.installLocation != null) {
			ret.put("installLocation", this.installLocation);
		}
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
		if (this.tempDir != null) {
			ret.put("tempDir", this.tempDir);
		}
		ret.put("acceptLicense", this.acceptLicense);
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
