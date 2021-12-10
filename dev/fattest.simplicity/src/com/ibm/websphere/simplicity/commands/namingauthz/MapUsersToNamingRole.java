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

package com.ibm.websphere.simplicity.commands.namingauthz;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Map users to the naming roles
 *   'roleName': Name of the Naming role: &lt;CosNamingRead | CosNamingWrite | CosNamingCreate | CosNamingDelete&gt;
 *   'accessids': AccessIds of the users &lt;user:realmName/uniqueID&gt; 	To add multiple values use space separated names enclosed by quotes(" "). The order of the accessids list should match accordingly with the order of the userids list. 	Example: "user:default/111 user:default/222"
 *   'userids': User names 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -userids "user1 user2"
 * The required parameters are found in the constructor.
 */
public class MapUsersToNamingRole extends Command {

	private String roleName;
	private java.lang.String[] accessids;
	private java.lang.String[] userids;

	public MapUsersToNamingRole(String roleName) {
		super("mapUsersToNamingRole");
		this.roleName = roleName;
	}

	/**
	 * Name of the Naming role: &lt;CosNamingRead | CosNamingWrite | CosNamingCreate | CosNamingDelete&gt;
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * Name of the Naming role: &lt;CosNamingRead | CosNamingWrite | CosNamingCreate | CosNamingDelete&gt;
	 */
	public void setRoleName(String value) {
		this.roleName = value;
	}

	/**
	 * AccessIds of the users &lt;user:realmName/uniqueID&gt; 	To add multiple values use space separated names enclosed by quotes(" "). The order of the accessids list should match accordingly with the order of the userids list. 	Example: "user:default/111 user:default/222"
	 */
	public java.lang.String[] getAccessids() {
		return this.accessids;
	}

	/**
	 * AccessIds of the users &lt;user:realmName/uniqueID&gt; 	To add multiple values use space separated names enclosed by quotes(" "). The order of the accessids list should match accordingly with the order of the userids list. 	Example: "user:default/111 user:default/222"
	 */
	public void setAccessids(java.lang.String[] value) {
		this.accessids = value;
	}

	/**
	 * User names 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -userids "user1 user2"
	 */
	public java.lang.String[] getUserids() {
		return this.userids;
	}

	/**
	 * User names 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -userids "user1 user2"
	 */
	public void setUserids(java.lang.String[] value) {
		this.userids = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("roleName", this.roleName);
		if (this.accessids != null) {
			ret.put("accessids", this.accessids);
		}
		if (this.userids != null) {
			ret.put("userids", this.userids);
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
