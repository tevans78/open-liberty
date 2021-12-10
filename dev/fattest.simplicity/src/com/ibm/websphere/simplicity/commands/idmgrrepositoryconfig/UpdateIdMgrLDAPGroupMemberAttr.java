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
 * Updates a member attribute configuration of an LDAP group configuration.
 *   'dummyMember': When creating a group without member specified, dummy member is filled in to avoid missing mandatory attribute exception.
 *   'id': The unique identifier of the repository.
 *   'name': The name of the LDAP attribute that is used as a group member attribute. For example, member or uniqueMember.
 *   'objectClass': The group object class that contains this member attribute. For example, "groupOfNames" or "groupOfUniqueNames". If this property is not defined, this member attribute applies to all group object classes.
 *   'scope': The scope of the member attribute. One of the three values: "direct", "nested" and "all". direct: The member attribute only contains direct members, which means the member directly contained by the group, not contained through nested group. For example, if Group1 contains Group2, Group2 contains User1, then Group2 is a direct member of Group1 but User1 is not a direct member of Group1.  Both member and uniqueMember are direct member attribute. nested: The member attribute contains both direct members and nested members. all: The member attribute contains direct members, nested members and dynamic members.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrLDAPGroupMemberAttr extends Command {

	private String dummyMember;
	private String id;
	private String name;
	private String objectClass;
	private String scope;

	public UpdateIdMgrLDAPGroupMemberAttr(String id, String name) {
		super("updateIdMgrLDAPGroupMemberAttr");
		this.id = id;
		this.name = name;
	}

	/**
	 * When creating a group without member specified, dummy member is filled in to avoid missing mandatory attribute exception.
	 */
	public String getDummyMember() {
		return this.dummyMember;
	}

	/**
	 * When creating a group without member specified, dummy member is filled in to avoid missing mandatory attribute exception.
	 */
	public void setDummyMember(String value) {
		this.dummyMember = value;
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
	 * The name of the LDAP attribute that is used as a group member attribute. For example, member or uniqueMember.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the LDAP attribute that is used as a group member attribute. For example, member or uniqueMember.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The group object class that contains this member attribute. For example, "groupOfNames" or "groupOfUniqueNames". If this property is not defined, this member attribute applies to all group object classes.
	 */
	public String getObjectClass() {
		return this.objectClass;
	}

	/**
	 * The group object class that contains this member attribute. For example, "groupOfNames" or "groupOfUniqueNames". If this property is not defined, this member attribute applies to all group object classes.
	 */
	public void setObjectClass(String value) {
		this.objectClass = value;
	}

	/**
	 * The scope of the member attribute. One of the three values: "direct", "nested" and "all". direct: The member attribute only contains direct members, which means the member directly contained by the group, not contained through nested group. For example, if Group1 contains Group2, Group2 contains User1, then Group2 is a direct member of Group1 but User1 is not a direct member of Group1.  Both member and uniqueMember are direct member attribute. nested: The member attribute contains both direct members and nested members. all: The member attribute contains direct members, nested members and dynamic members.
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * The scope of the member attribute. One of the three values: "direct", "nested" and "all". direct: The member attribute only contains direct members, which means the member directly contained by the group, not contained through nested group. For example, if Group1 contains Group2, Group2 contains User1, then Group2 is a direct member of Group1 but User1 is not a direct member of Group1.  Both member and uniqueMember are direct member attribute. nested: The member attribute contains both direct members and nested members. all: The member attribute contains direct members, nested members and dynamic members.
	 */
	public void setScope(String value) {
		this.scope = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.dummyMember != null) {
			ret.put("dummyMember", this.dummyMember);
		}
		ret.put("id", this.id);
		ret.put("name", this.name);
		if (this.objectClass != null) {
			ret.put("objectClass", this.objectClass);
		}
		if (this.scope != null) {
			ret.put("scope", this.scope);
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
