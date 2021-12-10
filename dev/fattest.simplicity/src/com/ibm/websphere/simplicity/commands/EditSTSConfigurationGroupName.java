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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Edit the name of a configuration group.
 *   'groupName': Name of the group.
 * The required parameters are found in the constructor.
 */
public class EditSTSConfigurationGroupName extends Command {

	private java.lang.String[] __target;
	private String groupName;

	public EditSTSConfigurationGroupName(java.lang.String[] commandTarget, String groupName) {
		super("editSTSConfigurationGroupName");
		this.__target = commandTarget;
		this.groupName = groupName;
	}

	/**
	 * Name of the group.
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Name of the group.
	 */
	public void setGroupName(String value) {
		this.groupName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(java.lang.String[] value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("groupName", this.groupName);
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
