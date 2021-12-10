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
 * Remove groupids from one or more admin role in the AuthorizationGroup.
 *   'authorizationGroupName': Authorization Group
 *   'roleName': Name of the role.  &lt; administrator | configurator | operator | deployer | monitor &gt;
 *   'groupids': Group ID.
 *   'specialSubjects': Special Subject.  &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt;
 * The required parameters are found in the constructor.
 */
public class RemoveGroupsFromAdminRole extends Command {

	private String authorizationGroupName = "CellAuthorizationGroup";
	private String roleName;
	private java.lang.String[] groupids;
	private java.lang.String[] specialSubjects;

	public RemoveGroupsFromAdminRole(String roleName) {
		super("removeGroupsFromAdminRole");
		this.roleName = roleName;
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
	 * Group ID.
	 */
	public java.lang.String[] getGroupids() {
		return this.groupids;
	}

	/**
	 * Group ID.
	 */
	public void setGroupids(java.lang.String[] value) {
		this.groupids = value;
	}

	/**
	 * Special Subject.  &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt;
	 */
	public java.lang.String[] getSpecialSubjects() {
		return this.specialSubjects;
	}

	/**
	 * Special Subject.  &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt;
	 */
	public void setSpecialSubjects(java.lang.String[] value) {
		this.specialSubjects = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.authorizationGroupName != null) {
			ret.put("authorizationGroupName", this.authorizationGroupName);
		}
		ret.put("roleName", this.roleName);
		if (this.groupids != null) {
			ret.put("groupids", this.groupids);
		}
		if (this.specialSubjects != null) {
			ret.put("specialSubjects", this.specialSubjects);
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
