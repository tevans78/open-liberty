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
 * Tests if a connection could be established using SSH private key with the remote host for the purpose of centralized install.
 *   'hostName': Specifies the domain-qualified host name of the remote host.
 *   'adminName': The login ID of an administrator of the remote host.
 *   'privateKeyStore': The absolute path to the private key file on the deployment manager host.
 *   'keyStorePassword': The optional password (also called passPhrase) used to protect the private key store.
 * The required parameters are found in the constructor.
 */
public class TestConnectionToHostUsingSSHKey extends Command {

	private String hostName;
	private String adminName;
	private String privateKeyStore;
	private String keyStorePassword;

	public TestConnectionToHostUsingSSHKey(String hostName, String adminName, String privateKeyStore) {
		super("testConnectionToHostUsingSSHKey");
		this.hostName = hostName;
		this.adminName = adminName;
		this.privateKeyStore = privateKeyStore;
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
	 * The absolute path to the private key file on the deployment manager host.
	 */
	public String getPrivateKeyStore() {
		return this.privateKeyStore;
	}

	/**
	 * The absolute path to the private key file on the deployment manager host.
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("hostName", this.hostName);
		ret.put("adminName", this.adminName);
		ret.put("privateKeyStore", this.privateKeyStore);
		if (this.keyStorePassword != null) {
			ret.put("keyStorePassword", this.keyStorePassword);
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
