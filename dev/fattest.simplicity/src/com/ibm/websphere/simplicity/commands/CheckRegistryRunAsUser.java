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
 * Checks if the provided runas user is valid.  True is return if the runas user is valid and false if it is not.
 *   'groupList': Pipe separated list of groups to check the runas user against.
 *   'userList': Pipe separated list of users to check the runas user against.
 *   'resourceName': Specifies the name of the resource to check the runas user in.
 *   'securityDomainName': Specifies the name of the security domain to check the runas user in.
 *   'realmName': Specifies the name of the security realm to check the runas user in.
 *   'username': The name of the runas user to check
 * The required parameters are found in the constructor.
 */
public class CheckRegistryRunAsUser extends Command {

	private String groupList;
	private String userList;
	private String resourceName;
	private String securityDomainName;
	private String realmName;
	private String username;

	public CheckRegistryRunAsUser(String username) {
		super("checkRegistryRunAsUser");
		this.username = username;
	}

	/**
	 * Pipe separated list of groups to check the runas user against.
	 */
	public String getGroupList() {
		return this.groupList;
	}

	/**
	 * Pipe separated list of groups to check the runas user against.
	 */
	public void setGroupList(String value) {
		this.groupList = value;
	}

	/**
	 * Pipe separated list of users to check the runas user against.
	 */
	public String getUserList() {
		return this.userList;
	}

	/**
	 * Pipe separated list of users to check the runas user against.
	 */
	public void setUserList(String value) {
		this.userList = value;
	}

	/**
	 * Specifies the name of the resource to check the runas user in.
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Specifies the name of the resource to check the runas user in.
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	/**
	 * Specifies the name of the security domain to check the runas user in.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Specifies the name of the security domain to check the runas user in.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * Specifies the name of the security realm to check the runas user in.
	 */
	public String getRealmName() {
		return this.realmName;
	}

	/**
	 * Specifies the name of the security realm to check the runas user in.
	 */
	public void setRealmName(String value) {
		this.realmName = value;
	}

	/**
	 * The name of the runas user to check
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * The name of the runas user to check
	 */
	public void setUsername(String value) {
		this.username = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.groupList != null) {
			ret.put("groupList", this.groupList);
		}
		if (this.userList != null) {
			ret.put("userList", this.userList);
		}
		if (this.resourceName != null) {
			ret.put("resourceName", this.resourceName);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.realmName != null) {
			ret.put("realmName", this.realmName);
		}
		ret.put("username", this.username);
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
