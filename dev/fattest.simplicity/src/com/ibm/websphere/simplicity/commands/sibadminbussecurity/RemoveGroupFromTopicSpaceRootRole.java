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

package com.ibm.websphere.simplicity.commands.sibadminbussecurity;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Removes a groups permission to access the topic space for the specified role.
 *   'bus': Bus name
 *   'topicSpace': Topicspace name
 *   'role': The role name.  Allowable values are ( Sender | Receiver | IdentityAdopter )
 *   'group': Group name
 * The required parameters are found in the constructor.
 */
public class RemoveGroupFromTopicSpaceRootRole extends Command {

	private String bus;
	private String topicSpace;
	private String role;
	private String group;

	public RemoveGroupFromTopicSpaceRootRole(String bus, String topicSpace, String role, String group) {
		super("removeGroupFromTopicSpaceRootRole");
		this.bus = bus;
		this.topicSpace = topicSpace;
		this.role = role;
		this.group = group;
	}

	/**
	 * Bus name
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus name
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Topicspace name
	 */
	public String getTopicSpace() {
		return this.topicSpace;
	}

	/**
	 * Topicspace name
	 */
	public void setTopicSpace(String value) {
		this.topicSpace = value;
	}

	/**
	 * The role name.  Allowable values are ( Sender | Receiver | IdentityAdopter )
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * The role name.  Allowable values are ( Sender | Receiver | IdentityAdopter )
	 */
	public void setRole(String value) {
		this.role = value;
	}

	/**
	 * Group name
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * Group name
	 */
	public void setGroup(String value) {
		this.group = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("topicSpace", this.topicSpace);
		ret.put("role", this.role);
		ret.put("group", this.group);
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
