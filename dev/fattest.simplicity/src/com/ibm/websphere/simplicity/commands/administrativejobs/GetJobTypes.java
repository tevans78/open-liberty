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

package com.ibm.websphere.simplicity.commands.administrativejobs;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command is used to get the supported job types for a managed node.
 *   'targetList': List of managed node names for the target.
 *   'group': The name of the group.
 * The required parameters are found in the constructor.
 */
public class GetJobTypes extends Command {

	private java.lang.String[] targetList;
	private String group;

	public GetJobTypes() {
		super("getJobTypes");
	}

	/**
	 * List of managed node names for the target.
	 */
	public java.lang.String[] getTargetList() {
		return this.targetList;
	}

	/**
	 * List of managed node names for the target.
	 */
	public void setTargetList(java.lang.String[] value) {
		this.targetList = value;
	}

	/**
	 * The name of the group.
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * The name of the group.
	 */
	public void setGroup(String value) {
		this.group = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.targetList != null) {
			ret.put("targetList", this.targetList);
		}
		if (this.group != null) {
			ret.put("group", this.group);
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
