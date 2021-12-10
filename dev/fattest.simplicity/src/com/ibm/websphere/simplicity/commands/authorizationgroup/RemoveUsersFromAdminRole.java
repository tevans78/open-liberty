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

package com.ibm.websphere.simplicity.commands.authorizationgroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Remove userids from one or more admin role in the AuthorizationGroup.
 *   'authorizationGroupName': Authorization Group
 *   'roleName': Name of the role.  &lt; administrator | configurator | operator | deployer | monitor &gt;
 *   'userids': User ID.
 * The required parameters are found in the constructor.
 */
public class RemoveUsersFromAdminRole extends Command {

	private String authorizationGroupName = "CellAuthorizationGroup";
	private String roleName;
	private java.lang.String[] userids;

	public RemoveUsersFromAdminRole(String roleName, java.lang.String[] userids) {
		super("removeUsersFromAdminRole");
		this.roleName = roleName;
		this.userids = userids;
	}

	/**
	 * Authorization Group
	 */
	public String getAuthorizationGroupName() {
		return this.authorizationGroupName;
	}

	/**
	 * Authorization Group
	 */
	public void setAuthorizationGroupName(String value) {
		this.authorizationGroupName = value;
	}

	/**
	 * Name of the role.  &lt; administrator | configurator | operator | deployer | monitor &gt;
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * Name of the role.  &lt; administrator | configurator | operator | deployer | monitor &gt;
	 */
	public void setRoleName(String value) {
		this.roleName = value;
	}

	/**
	 * User ID.
	 */
	public java.lang.String[] getUserids() {
		return this.userids;
	}

	/**
	 * User ID.
	 */
	public void setUserids(java.lang.String[] value) {
		this.userids = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.authorizationGroupName != null) {
			ret.put("authorizationGroupName", this.authorizationGroupName);
		}
		ret.put("roleName", this.roleName);
		ret.put("userids", this.userids);
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
