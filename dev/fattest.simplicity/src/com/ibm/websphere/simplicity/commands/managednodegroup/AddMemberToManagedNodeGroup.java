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

package com.ibm.websphere.simplicity.commands.managednodegroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command is used to add members to a group of managed nodes.
 *   'groupName': The name of the group.
 *   'managedNodeNameList': List of managed node names.
 * The required parameters are found in the constructor.
 */
public class AddMemberToManagedNodeGroup extends Command {

	private String groupName;
	private java.lang.String[] managedNodeNameList;

	public AddMemberToManagedNodeGroup(String groupName, java.lang.String[] managedNodeNameList) {
		super("addMemberToManagedNodeGroup");
		this.groupName = groupName;
		this.managedNodeNameList = managedNodeNameList;
	}

	/**
	 * The name of the group.
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * The name of the group.
	 */
	public void setGroupName(String value) {
		this.groupName = value;
	}

	/**
	 * List of managed node names.
	 */
	public java.lang.String[] getManagedNodeNameList() {
		return this.managedNodeNameList;
	}

	/**
	 * List of managed node names.
	 */
	public void setManagedNodeNameList(java.lang.String[] value) {
		this.managedNodeNameList = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("groupName", this.groupName);
		ret.put("managedNodeNameList", this.managedNodeNameList);
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
