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
 * Map groups or special subjects or both to the naming roles
 *   'accessids': AccessIds of the groups &lt;group:realmName/uniqueID&gt; 	To add multiple values use space separated names enclosed by quotes(" "). The order of the accessids list should match accordingly with the order of the groupids list. 	Example: "group:default/123 group:default/456"
 *   'groupids': Group names 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -groupids "group1 group2"
 *   'roleName': Name of the Naming role: &lt;CosNamingRead | CosNamingWrite | CosNamingCreate | CosNamingDelete&gt;
 *   'specialSubjects': Special subjects &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt; 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -specialSubjects "ALLAUTHENTICATED EVERYONE"
 * The required parameters are found in the constructor.
 */
public class MapGroupsToNamingRole extends Command {

	private java.lang.String[] accessids;
	private java.lang.String[] groupids;
	private String roleName;
	private java.lang.String[] specialSubjects;

	public MapGroupsToNamingRole(String roleName) {
		super("mapGroupsToNamingRole");
		this.roleName = roleName;
	}

	/**
	 * AccessIds of the groups &lt;group:realmName/uniqueID&gt; 	To add multiple values use space separated names enclosed by quotes(" "). The order of the accessids list should match accordingly with the order of the groupids list. 	Example: "group:default/123 group:default/456"
	 */
	public java.lang.String[] getAccessids() {
		return this.accessids;
	}

	/**
	 * AccessIds of the groups &lt;group:realmName/uniqueID&gt; 	To add multiple values use space separated names enclosed by quotes(" "). The order of the accessids list should match accordingly with the order of the groupids list. 	Example: "group:default/123 group:default/456"
	 */
	public void setAccessids(java.lang.String[] value) {
		this.accessids = value;
	}

	/**
	 * Group names 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -groupids "group1 group2"
	 */
	public java.lang.String[] getGroupids() {
		return this.groupids;
	}

	/**
	 * Group names 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -groupids "group1 group2"
	 */
	public void setGroupids(java.lang.String[] value) {
		this.groupids = value;
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
	 * Special subjects &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt; 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -specialSubjects "ALLAUTHENTICATED EVERYONE"
	 */
	public java.lang.String[] getSpecialSubjects() {
		return this.specialSubjects;
	}

	/**
	 * Special subjects &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt; 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -specialSubjects "ALLAUTHENTICATED EVERYONE"
	 */
	public void setSpecialSubjects(java.lang.String[] value) {
		this.specialSubjects = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.accessids != null) {
			ret.put("accessids", this.accessids);
		}
		if (this.groupids != null) {
			ret.put("groupids", this.groupids);
		}
		ret.put("roleName", this.roleName);
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
