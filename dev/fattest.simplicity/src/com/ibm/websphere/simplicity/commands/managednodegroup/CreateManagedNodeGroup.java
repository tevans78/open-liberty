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
 * This command is used to create a group of managed nodes.
 *   'groupName': The name of the group.
 *   'description': A brief description for the group.
 * The required parameters are found in the constructor.
 */
public class CreateManagedNodeGroup extends Command {

	private String groupName;
	private String description;

	public CreateManagedNodeGroup(String groupName) {
		super("createManagedNodeGroup");
		this.groupName = groupName;
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
	 * A brief description for the group.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * A brief description for the group.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("groupName", this.groupName);
		if (this.description != null) {
			ret.put("description", this.description);
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
