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
 * Grants a user access to a foreign bus from the local bus specified for the specified destination role.
 *   'bus': Bus name
 *   'foreignBus': Foreign Bus name
 *   'role': The role name.  Allowable values are ( Sender | IdentityAdopter )
 *   'user': User name
 *   'uniqueName': The name that uniquely defines the user or group in the registry
 * The required parameters are found in the constructor.
 */
public class AddUserToForeignBusRole extends Command {

	private String bus;
	private String foreignBus;
	private String role;
	private String user;
	private String uniqueName;

	public AddUserToForeignBusRole(String bus, String foreignBus, String role, String user) {
		super("addUserToForeignBusRole");
		this.bus = bus;
		this.foreignBus = foreignBus;
		this.role = role;
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
	 * Foreign Bus name
	 */
	public String getForeignBus() {
		return this.foreignBus;
	}

	/**
	 * Foreign Bus name
	 */
	public void setForeignBus(String value) {
		this.foreignBus = value;
	}

	/**
	 * The role name.  Allowable values are ( Sender | IdentityAdopter )
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * The role name.  Allowable values are ( Sender | IdentityAdopter )
	 */
	public void setRole(String value) {
		this.role = value;
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
		ret.put("foreignBus", this.foreignBus);
		ret.put("role", this.role);
		ret.put("user", this.user);
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
