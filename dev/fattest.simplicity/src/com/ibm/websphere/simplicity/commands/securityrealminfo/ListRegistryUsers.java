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

package com.ibm.websphere.simplicity.commands.securityrealminfo;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Returns a list of users in the specified security realm, security domain, or resource.
 *   'resourceName': Specifies the name of the resource for which a user list will be returned.
 *   'securityDomainName': Specifies the name of the security domain for which a user list will be returned.
 *   'securityRealmName': Specifies the name of the security realm for which a user list will be returned.
 *   'numberOfUsers': Specifies the maximum number of users to return.
 *   'userFilter': Specifies a filter to be used to get the list of users.
 *   'displayAccessIds': Specify true to return the list of user IDs and access IDs, and false just to return a list of user IDs.
 * The required parameters are found in the constructor.
 */
public class ListRegistryUsers extends Command {

	private String resourceName;
	private String securityDomainName;
	private String securityRealmName;
	private Integer numberOfUsers = 20;
	private String userFilter;
	private Boolean displayAccessIds = false;

	public ListRegistryUsers() {
		super("listRegistryUsers");
	}

	/**
	 * Specifies the name of the resource for which a user list will be returned.
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Specifies the name of the resource for which a user list will be returned.
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	/**
	 * Specifies the name of the security domain for which a user list will be returned.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Specifies the name of the security domain for which a user list will be returned.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * Specifies the name of the security realm for which a user list will be returned.
	 */
	public String getSecurityRealmName() {
		return this.securityRealmName;
	}

	/**
	 * Specifies the name of the security realm for which a user list will be returned.
	 */
	public void setSecurityRealmName(String value) {
		this.securityRealmName = value;
	}

	/**
	 * Specifies the maximum number of users to return.
	 */
	public Integer getNumberOfUsers() {
		return this.numberOfUsers;
	}

	/**
	 * Specifies the maximum number of users to return.
	 */
	public void setNumberOfUsers(Integer value) {
		this.numberOfUsers = value;
	}

	/**
	 * Specifies a filter to be used to get the list of users.
	 */
	public String getUserFilter() {
		return this.userFilter;
	}

	/**
	 * Specifies a filter to be used to get the list of users.
	 */
	public void setUserFilter(String value) {
		this.userFilter = value;
	}

	/**
	 * Specify true to return the list of user IDs and access IDs, and false just to return a list of user IDs.
	 */
	public Boolean getDisplayAccessIds() {
		return this.displayAccessIds;
	}

	/**
	 * Specify true to return the list of user IDs and access IDs, and false just to return a list of user IDs.
	 */
	public void setDisplayAccessIds(Boolean value) {
		this.displayAccessIds = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.resourceName != null) {
			ret.put("resourceName", this.resourceName);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.securityRealmName != null) {
			ret.put("securityRealmName", this.securityRealmName);
		}
		if (this.numberOfUsers != null) {
			ret.put("numberOfUsers", this.numberOfUsers);
		}
		if (this.userFilter != null) {
			ret.put("userFilter", this.userFilter);
		}
		if (this.displayAccessIds != null) {
			ret.put("displayAccessIds", this.displayAccessIds);
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
