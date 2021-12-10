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
 * Returns a list of groups in a security realm, security domain, or resource.
 *   'resourceName': Specifies the name of the resource for which a group list will be returned.
 *   'securityDomainName': Specifies the name of the security domain for which a group list will be returned.
 *   'securityRealmName': Specifies the name of the security realm for which a group list will be returned.
 *   'numberOfGroups': Specifies the maximum number of groups to return.
 *   'groupFilter': Specify a filter to be used to get the list of groups.
 *   'displayAccessIds': Specify true to return the list of user IDs and access IDs, and false just to return a list of user IDs.
 * The required parameters are found in the constructor.
 */
public class ListRegistryGroups extends Command {

	private String resourceName;
	private String securityDomainName;
	private String securityRealmName;
	private Integer numberOfGroups = 20;
	private String groupFilter;
	private Boolean displayAccessIds = false;

	public ListRegistryGroups() {
		super("listRegistryGroups");
	}

	/**
	 * Specifies the name of the resource for which a group list will be returned.
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Specifies the name of the resource for which a group list will be returned.
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	/**
	 * Specifies the name of the security domain for which a group list will be returned.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Specifies the name of the security domain for which a group list will be returned.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * Specifies the name of the security realm for which a group list will be returned.
	 */
	public String getSecurityRealmName() {
		return this.securityRealmName;
	}

	/**
	 * Specifies the name of the security realm for which a group list will be returned.
	 */
	public void setSecurityRealmName(String value) {
		this.securityRealmName = value;
	}

	/**
	 * Specifies the maximum number of groups to return.
	 */
	public Integer getNumberOfGroups() {
		return this.numberOfGroups;
	}

	/**
	 * Specifies the maximum number of groups to return.
	 */
	public void setNumberOfGroups(Integer value) {
		this.numberOfGroups = value;
	}

	/**
	 * Specify a filter to be used to get the list of groups.
	 */
	public String getGroupFilter() {
		return this.groupFilter;
	}

	/**
	 * Specify a filter to be used to get the list of groups.
	 */
	public void setGroupFilter(String value) {
		this.groupFilter = value;
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
		if (this.numberOfGroups != null) {
			ret.put("numberOfGroups", this.numberOfGroups);
		}
		if (this.groupFilter != null) {
			ret.put("groupFilter", this.groupFilter);
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
