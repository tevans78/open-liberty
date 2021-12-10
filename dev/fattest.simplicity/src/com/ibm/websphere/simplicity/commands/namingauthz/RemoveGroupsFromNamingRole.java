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
 * Remove groups or special subjects or both from a naming role
 *   'groupids': Group names 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -groupids "group1 group2"
 *   'roleName': Name of the Naming role: &lt;CosNamingRead | CosNamingWrite | CosNamingCreate | CosNamingDelete&gt;
 *   'specialSubjects': Special subjects &lt;EVERYONE | ALLAUTHENTICATED | ALLAUTHENTICATEDINTRUSTEDREALMS&gt; 	To add multiple values use space separated names enclosed by quotes(" ") 	Example: -specialSubjects "ALLAUTHENTICATED EVERYONE"
 * The required parameters are found in the constructor.
 */
public class RemoveGroupsFromNamingRole extends Command {

	private java.lang.String[] groupids;
	private String roleName;
	private java.lang.String[] specialSubjects;

	public RemoveGroupsFromNamingRole(String roleName) {
		super("removeGroupsFromNamingRole");
		this.roleName = roleName;
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
