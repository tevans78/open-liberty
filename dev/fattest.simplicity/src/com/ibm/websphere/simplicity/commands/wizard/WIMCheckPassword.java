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

package com.ibm.websphere.simplicity.commands.wizard;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Validates the user/pasword in the WIM user registry
 *   'username': Supply a user name.
 *   'password': Supply a user password.
 * The required parameters are found in the constructor.
 */
public class WIMCheckPassword extends Command {

	private String username;
	private String password;

	public WIMCheckPassword(String username, String password) {
		super("WIMCheckPassword");
		this.username = username;
		this.password = password;
	}

	/**
	 * Supply a user name.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Supply a user name.
	 */
	public void setUsername(String value) {
		this.username = value;
	}

	/**
	 * Supply a user password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Supply a user password.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("username", this.username);
		ret.put("password", this.password);
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
