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
 * List personal certificate aliases in a keystore file
 *   'keyFilePath': Specifies the full path to the keystore file.
 *   'keyFilePassword': Specifies the password to the keystore file.
 *   'keyFileType': Specifies the type of the keystore file.
 * The required parameters are found in the constructor.
 */
public class ListKeyFileAliases extends Command {

	private String keyFilePath;
	private String keyFilePassword;
	private String keyFileType;

	public ListKeyFileAliases(String keyFilePath, String keyFilePassword, String keyFileType) {
		super("listKeyFileAliases");
		this.keyFilePath = keyFilePath;
		this.keyFilePassword = keyFilePassword;
		this.keyFileType = keyFileType;
	}

	/**
	 * Specifies the full path to the keystore file.
	 */
	public String getKeyFilePath() {
		return this.keyFilePath;
	}

	/**
	 * Specifies the full path to the keystore file.
	 */
	public void setKeyFilePath(String value) {
		this.keyFilePath = value;
	}

	/**
	 * Specifies the password to the keystore file.
	 */
	public String getKeyFilePassword() {
		return this.keyFilePassword;
	}

	/**
	 * Specifies the password to the keystore file.
	 */
	public void setKeyFilePassword(String value) {
		this.keyFilePassword = value;
	}

	/**
	 * Specifies the type of the keystore file.
	 */
	public String getKeyFileType() {
		return this.keyFileType;
	}

	/**
	 * Specifies the type of the keystore file.
	 */
	public void setKeyFileType(String value) {
		this.keyFileType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("keyFilePath", this.keyFilePath);
		ret.put("keyFilePassword", this.keyFilePassword);
		ret.put("keyFileType", this.keyFileType);
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
