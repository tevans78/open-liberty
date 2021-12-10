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

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Sets up the LDAP group configuration.
 *   'id': The unique identifier of the repository.
 *   'name': The name of the membership attribute. For example, memberOf in Active Directory Server and ibm-allGroups in IDS.
 *   'scope': The scope of the membership attribute. One of the three values: "direct", "nested" and "all". direct: The membership attribute contains direct groups only. direct: groups are the groups that contain the member, not contained through nested group. For example, if Group1 contains Group2, Group2 contains User1, then Group2 is a direct group of User1, but Group1 is not a direct group of User1. nested: The membership attribute contains both direct groups and nested groups. all: The membership attribute contains direct groups, nested groups and dynamic members.
 *   'updateGroupMembership': Whether or not virtual member manager LDAP adapter needs to update group membership if the member is deleted or renamed. Some LDAP servers, like Domino, Sun ONE, IDS on zOS, do not clean up a user's membership when a user is deleted or renamed. If these LDAP server types are chosen in the ldapServerType property, the value of this parameter is set to "true". Set this property only if the value needs to change.
 * The required parameters are found in the constructor.
 */
public class SetIdMgrLDAPGroupConfig extends Command {

	private String id;
	private String name;
	private String scope;
	private Boolean updateGroupMembership;

	public SetIdMgrLDAPGroupConfig(String id) {
		super("setIdMgrLDAPGroupConfig");
		this.id = id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * The name of the membership attribute. For example, memberOf in Active Directory Server and ibm-allGroups in IDS.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the membership attribute. For example, memberOf in Active Directory Server and ibm-allGroups in IDS.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The scope of the membership attribute. One of the three values: "direct", "nested" and "all". direct: The membership attribute contains direct groups only. direct: groups are the groups that contain the member, not contained through nested group. For example, if Group1 contains Group2, Group2 contains User1, then Group2 is a direct group of User1, but Group1 is not a direct group of User1. nested: The membership attribute contains both direct groups and nested groups. all: The membership attribute contains direct groups, nested groups and dynamic members.
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * The scope of the membership attribute. One of the three values: "direct", "nested" and "all". direct: The membership attribute contains direct groups only. direct: groups are the groups that contain the member, not contained through nested group. For example, if Group1 contains Group2, Group2 contains User1, then Group2 is a direct group of User1, but Group1 is not a direct group of User1. nested: The membership attribute contains both direct groups and nested groups. all: The membership attribute contains direct groups, nested groups and dynamic members.
	 */
	public void setScope(String value) {
		this.scope = value;
	}

	/**
	 * Whether or not virtual member manager LDAP adapter needs to update group membership if the member is deleted or renamed. Some LDAP servers, like Domino, Sun ONE, IDS on zOS, do not clean up a user's membership when a user is deleted or renamed. If these LDAP server types are chosen in the ldapServerType property, the value of this parameter is set to "true". Set this property only if the value needs to change.
	 */
	public Boolean getUpdateGroupMembership() {
		return this.updateGroupMembership;
	}

	/**
	 * Whether or not virtual member manager LDAP adapter needs to update group membership if the member is deleted or renamed. Some LDAP servers, like Domino, Sun ONE, IDS on zOS, do not clean up a user's membership when a user is deleted or renamed. If these LDAP server types are chosen in the ldapServerType property, the value of this parameter is set to "true". Set this property only if the value needs to change.
	 */
	public void setUpdateGroupMembership(Boolean value) {
		this.updateGroupMembership = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("id", this.id);
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.scope != null) {
			ret.put("scope", this.scope);
		}
		if (this.updateGroupMembership != null) {
			ret.put("updateGroupMembership", this.updateGroupMembership);
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
