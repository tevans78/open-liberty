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

package com.ibm.websphere.simplicity.commands.sibadminbussecurity;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists all the roles defined for a specified user.
 *   'bus': Bus name
 *   'user': User name
 *   'enhancedOutput': When set to true the result will be formatted in the advanced format. The enhanced format includes the config object type, the role, the bus or topic name, and the destination name separated by colons.
 * The required parameters are found in the constructor.
 */
public class ListAllRolesForUser extends Command {

	private String bus;
	private String user;
	private Boolean enhancedOutput = false;

	public ListAllRolesForUser(String bus, String user) {
		super("listAllRolesForUser");
		this.bus = bus;
		this.user = user;
	}

	/**
	 * Bus name
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus name
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * User name
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * User name
	 */
	public void setUser(String value) {
		this.user = value;
	}

	/**
	 * When set to true the result will be formatted in the advanced format. The enhanced format includes the config object type, the role, the bus or topic name, and the destination name separated by colons.
	 */
	public Boolean getEnhancedOutput() {
		return this.enhancedOutput;
	}

	/**
	 * When set to true the result will be formatted in the advanced format. The enhanced format includes the config object type, the role, the bus or topic name, and the destination name separated by colons.
	 */
	public void setEnhancedOutput(Boolean value) {
		this.enhancedOutput = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("user", this.user);
		if (this.enhancedOutput != null) {
			ret.put("enhancedOutput", this.enhancedOutput);
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
