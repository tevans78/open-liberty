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
 * Grants a group default access to all local destinations on the bus for the specified role.
 *   'bus': Bus name
 *   'role': The role name.  Allowable values are ( Sender | Receiver | Browser | Creator | IdentityAdopter )
 *   'group': Group name
 *   'uniqueName': The name that uniquely defines the user or group in the registry
 * The required parameters are found in the constructor.
 */
public class AddGroupToDefaultRole extends Command {

	private String bus;
	private String role;
	private String group;
	private String uniqueName;

	public AddGroupToDefaultRole(String bus, String role, String group) {
		super("addGroupToDefaultRole");
		this.bus = bus;
		this.role = role;
		this.group = group;
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
	 * The role name.  Allowable values are ( Sender | Receiver | Browser | Creator | IdentityAdopter )
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * The role name.  Allowable values are ( Sender | Receiver | Browser | Creator | IdentityAdopter )
	 */
	public void setRole(String value) {
		this.role = value;
	}

	/**
	 * Group name
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * Group name
	 */
	public void setGroup(String value) {
		this.group = value;
	}

	/**
	 * The name that uniquely defines the user or group in the registry
	 */
	public String getUniqueName() {
		return this.uniqueName;
	}

	/**
	 * The name that uniquely defines the user or group in the registry
	 */
	public void setUniqueName(String value) {
		this.uniqueName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("role", this.role);
		ret.put("group", this.group);
		if (this.uniqueName != null) {
			ret.put("uniqueName", this.uniqueName);
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
