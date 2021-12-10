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

package com.ibm.websphere.simplicity.commands.wim;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Adds a member (user or group) to a group.
 *   'groupUniqueName': The uniqueName of the group.
 *   'memberUniqueName': The uniqueName of the member to add or remove.
 * The required parameters are found in the constructor.
 */
public class AddMemberToGroup extends Command {

	private String groupUniqueName;
	private String memberUniqueName;

	public AddMemberToGroup(String groupUniqueName, String memberUniqueName) {
		super("addMemberToGroup");
		this.groupUniqueName = groupUniqueName;
		this.memberUniqueName = memberUniqueName;
	}

	/**
	 * The uniqueName of the group.
	 */
	public String getGroupUniqueName() {
		return this.groupUniqueName;
	}

	/**
	 * The uniqueName of the group.
	 */
	public void setGroupUniqueName(String value) {
		this.groupUniqueName = value;
	}

	/**
	 * The uniqueName of the member to add or remove.
	 */
	public String getMemberUniqueName() {
		return this.memberUniqueName;
	}

	/**
	 * The uniqueName of the member to add or remove.
	 */
	public void setMemberUniqueName(String value) {
		this.memberUniqueName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("groupUniqueName", this.groupUniqueName);
		ret.put("memberUniqueName", this.memberUniqueName);
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
