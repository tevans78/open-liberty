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

package com.ibm.websphere.simplicity.commands.nodeconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * renameNode
 *   'nodeName': current node name
 *   'newNodeName': newNode
 *   'shortName': shortName
 * The required parameters are found in the constructor.
 */
public class RenameNode extends Command {

	private List<Command> __steps;
	private String nodeName;
	private String newNodeName;
	private String shortName;

	public RenameNode(String nodeName, String newNodeName) {
		super("renameNode");
		this.nodeName = nodeName;
		this.newNodeName = newNodeName;
	}

	/**
	 * current node name
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * current node name
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * newNode
	 */
	public String getNewNodeName() {
		return this.newNodeName;
	}

	/**
	 * newNode
	 */
	public void setNewNodeName(String value) {
		this.newNodeName = value;
	}

	/**
	 * shortName
	 */
	public String getShortName() {
		return this.shortName;
	}

	/**
	 * shortName
	 */
	public void setShortName(String value) {
		this.shortName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
		ret.put("newNodeName", this.newNodeName);
		if (this.shortName != null) {
			ret.put("shortName", this.shortName);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, RenameNodeSIBus renameNodeSIBus) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (renameNodeSIBus != null)
			this.__steps.add(renameNodeSIBus);
		return super.run(scope);
	}

	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class RenameNodeSIBus extends CommandStep {

		public RenameNodeSIBus() {
			super("RenameNodeSIBus");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
