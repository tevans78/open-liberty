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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Returns the access ID for the registry server ID.
 *   'realmName': Specifies the name of the security realm whose access ID will be returned..
 * The required parameters are found in the constructor.
 */
public class GetAccessIdFromServerId extends Command {

	private String realmName;

	public GetAccessIdFromServerId() {
		super("getAccessIdFromServerId");
	}

	/**
	 * Specifies the name of the security realm whose access ID will be returned..
	 */
	public String getRealmName() {
		return this.realmName;
	}

	/**
	 * Specifies the name of the security realm whose access ID will be returned..
	 */
	public void setRealmName(String value) {
		this.realmName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.realmName != null) {
			ret.put("realmName", this.realmName);
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
