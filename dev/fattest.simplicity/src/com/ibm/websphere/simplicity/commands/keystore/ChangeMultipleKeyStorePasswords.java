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
 * Change all the passwords for the keystores that use the password provided, which automatically saves the new passwords to the configuration.
 *   'newKeyStorePasswordVerify': Specifies the password for the keystore confirm entry.
 *   'newKeyStorePassword': Specifies the password for the keystore.
 *   'keyStorePassword': Specifies the password to open the keystore.
 * The required parameters are found in the constructor.
 */
public class ChangeMultipleKeyStorePasswords extends Command {

	private String newKeyStorePasswordVerify;
	private String newKeyStorePassword;
	private String keyStorePassword;

	public ChangeMultipleKeyStorePasswords(String newKeyStorePasswordVerify, String newKeyStorePassword, String keyStorePassword) {
		super("changeMultipleKeyStorePasswords");
		this.newKeyStorePasswordVerify = newKeyStorePasswordVerify;
		this.newKeyStorePassword = newKeyStorePassword;
		this.keyStorePassword = keyStorePassword;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("newKeyStorePasswordVerify", this.newKeyStorePasswordVerify);
		ret.put("newKeyStorePassword", this.newKeyStorePassword);
		ret.put("keyStorePassword", this.keyStorePassword);
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
