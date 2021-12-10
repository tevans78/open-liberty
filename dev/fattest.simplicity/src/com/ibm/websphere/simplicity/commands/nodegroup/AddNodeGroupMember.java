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

package com.ibm.websphere.simplicity.commands.nodegroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * add node to the node group
 *   'nodeName': the name of the node to be added to the node group
 * The required parameters are found in the constructor.
 */
public class AddNodeGroupMember extends Command {

	private String __target;
	private String nodeName;

	public AddNodeGroupMember(String commandTarget, String nodeName) {
		super("addNodeGroupMember");
		this.__target = commandTarget;
		this.nodeName = nodeName;
	}

	/**
	 * the name of the node to be added to the node group
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * the name of the node to be added to the node group
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
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
