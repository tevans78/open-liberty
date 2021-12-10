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
 * Information regarding a group of managed nodes.
 *   'groupName': A list of group names.
 * The required parameters are found in the constructor.
 */
public class GetManagedNodeGroupInfo extends Command {

	private java.lang.String[] groupName;

	public GetManagedNodeGroupInfo(java.lang.String[] groupName) {
		super("getManagedNodeGroupInfo");
		this.groupName = groupName;
	}

	/**
	 * A list of group names.
	 */
	public java.lang.String[] getGroupName() {
		return this.groupName;
	}

	/**
	 * A list of group names.
	 */
	public void setGroupName(java.lang.String[] value) {
		this.groupName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("groupName", this.groupName);
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
