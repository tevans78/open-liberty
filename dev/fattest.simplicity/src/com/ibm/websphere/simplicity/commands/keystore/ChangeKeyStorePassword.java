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

package com.ibm.websphere.simplicity.commands.keystore;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Change the password of a keystore. This will automatically save the new password to the configuration.
 *   'scopeName': Specifies the management scope.
 *   'newKeyStorePasswordVerify': Specifies the password for the keystore confirm entry.
 *   'newKeyStorePassword': Specifies the password for the keystore.
 *   'keyStorePassword': Specifies the password to open the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 * The required parameters are found in the constructor.
 */
public class ChangeKeyStorePassword extends Command {

	private String scopeName;
	private String newKeyStorePasswordVerify;
	private String newKeyStorePassword;
	private String keyStorePassword;
	private String keyStoreName;

	public ChangeKeyStorePassword(String newKeyStorePasswordVerify, String newKeyStorePassword, String keyStorePassword, String keyStoreName) {
		super("changeKeyStorePassword");
		this.newKeyStorePasswordVerify = newKeyStorePasswordVerify;
		this.newKeyStorePassword = newKeyStorePassword;
		this.keyStorePassword = keyStorePassword;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the password for the keystore confirm entry.
	 */
	public String getNewKeyStorePasswordVerify() {
		return this.newKeyStorePasswordVerify;
	}

	/**
	 * Specifies the password for the keystore confirm entry.
	 */
	public void setNewKeyStorePasswordVerify(String value) {
		this.newKeyStorePasswordVerify = value;
	}

	/**
	 * Specifies the password for the keystore.
	 */
	public String getNewKeyStorePassword() {
		return this.newKeyStorePassword;
	}

	/**
	 * Specifies the password for the keystore.
	 */
	public void setNewKeyStorePassword(String value) {
		this.newKeyStorePassword = value;
	}

	/**
	 * Specifies the password to open the keystore.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to open the keystore.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("newKeyStorePasswordVerify", this.newKeyStorePasswordVerify);
		ret.put("newKeyStorePassword", this.newKeyStorePassword);
		ret.put("keyStorePassword", this.keyStorePassword);
		ret.put("keyStoreName", this.keyStoreName);
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
