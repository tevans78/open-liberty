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

package com.ibm.websphere.simplicity.commands.auditauthorization;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Map groupids to one or more audit role in the authorization group.
 *   'authorizationGroupName': Authorization Group
 *   'roleName': Name of the role.  &lt; administrator | configurator | operator | deployer | monitor &gt;
 *   'groupids': Group ID.
 *   'specialSubjects': Special Subject.  &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt;
 *   'accessids': ACCESS IDs. If provided, there should be one for each user id.
 * The required parameters are found in the constructor.
 */
public class MapGroupsToAuditRole extends Command {

	private String authorizationGroupName = "CellAuthorizationGroup";
	private String roleName;
	private java.lang.String[] groupids;
	private java.lang.String[] specialSubjects;
	private java.lang.String[] accessids;

	public MapGroupsToAuditRole(String roleName) {
		super("mapGroupsToAuditRole");
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

	/**
	 * ACCESS IDs. If provided, there should be one for each user id.
	 */
	public java.lang.String[] getAccessids() {
		return this.accessids;
	}

	/**
	 * ACCESS IDs. If provided, there should be one for each user id.
	 */
	public void setAccessids(java.lang.String[] value) {
		this.accessids = value;
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
		if (this.accessids != null) {
			ret.put("accessids", this.accessids);
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
