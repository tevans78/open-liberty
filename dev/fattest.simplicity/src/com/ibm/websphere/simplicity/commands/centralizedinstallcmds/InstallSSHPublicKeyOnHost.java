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
 * Installs an SSH public key on a remote host.  After installation, the specified administrator can connect using the corresponding private key. Currently, only remote targets running OpenSSH or SunSSH servers are supported.
 *   'hostName': Specifies the domain-qualified host name of the remote host.
 *   'adminName': The login ID of an administrator of the remote host.
 *   'adminPassword': The login password of an administrator of the remote host.
 *   'publicKeyStore': The absolute path to the public key file on the deployment manager host in either IETF standard format or OpenSSH format.
 * The required parameters are found in the constructor.
 */
public class InstallSSHPublicKeyOnHost extends Command {

	private String hostName;
	private String adminName;
	private String adminPassword;
	private String publicKeyStore;

	public InstallSSHPublicKeyOnHost(String hostName, String adminName, String adminPassword, String publicKeyStore) {
		super("installSSHPublicKeyOnHost");
		this.hostName = hostName;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.publicKeyStore = publicKeyStore;
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
	 * The login password of an administrator of the remote host.
	 */
	public String getAdminPassword() {
		return this.adminPassword;
	}

	/**
	 * The login password of an administrator of the remote host.
	 */
	public void setAdminPassword(String value) {
		this.adminPassword = value;
	}

	/**
	 * The absolute path to the public key file on the deployment manager host in either IETF standard format or OpenSSH format.
	 */
	public String getPublicKeyStore() {
		return this.publicKeyStore;
	}

	/**
	 * The absolute path to the public key file on the deployment manager host in either IETF standard format or OpenSSH format.
	 */
	public void setPublicKeyStore(String value) {
		this.publicKeyStore = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("hostName", this.hostName);
		ret.put("adminName", this.adminName);
		ret.put("adminPassword", this.adminPassword);
		ret.put("publicKeyStore", this.publicKeyStore);
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
