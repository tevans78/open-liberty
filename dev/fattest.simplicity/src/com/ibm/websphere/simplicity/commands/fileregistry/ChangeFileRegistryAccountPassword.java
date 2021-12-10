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

package com.ibm.websphere.simplicity.commands.fileregistry;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Change the password of an account in the file registry.
 *   'password': User's password
 *   'uniqueName': User's fully qualified unique name
 *   'userId': User's ID
 * The required parameters are found in the constructor.
 */
public class ChangeFileRegistryAccountPassword extends Command {

	private String password;
	private String uniqueName;
	private String userId;

	public ChangeFileRegistryAccountPassword(String password, String userId) {
		super("changeFileRegistryAccountPassword");
		this.password = password;
		this.userId = userId;
	}

	/**
	 * User's password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * User's password
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * User's fully qualified unique name
	 */
	public String getUniqueName() {
		return this.uniqueName;
	}

	/**
	 * User's fully qualified unique name
	 */
	public void setUniqueName(String value) {
		this.uniqueName = value;
	}

	/**
	 * User's ID
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * User's ID
	 */
	public void setUserId(String value) {
		this.userId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("password", this.password);
		if (this.uniqueName != null) {
			ret.put("uniqueName", this.uniqueName);
		}
		ret.put("userId", this.userId);
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
