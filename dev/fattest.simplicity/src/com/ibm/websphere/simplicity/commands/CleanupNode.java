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
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * cleanupNodeDesc
 *   'nodeName': cleanupNodeNodeNameDesc
 * The required parameters are found in the constructor.
 */
public class CleanupNode extends Command {

	private List<Command> __steps;
	private String nodeName;

	public CleanupNode(String nodeName) {
		super("cleanupNode");
		this.nodeName = nodeName;
	}

	/**
	 * cleanupNodeNodeNameDesc
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * cleanupNodeNodeNameDesc
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
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
	public OperationResults<Object> run(Scope scope, MergeSecurityCleanup mergeSecurityCleanup, CleanupSIBus cleanupSIBus) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (mergeSecurityCleanup != null)
			this.__steps.add(mergeSecurityCleanup);
		if (cleanupSIBus != null)
			this.__steps.add(cleanupSIBus);
		return super.run(scope);
	}

	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class MergeSecurityCleanup extends CommandStep {

		public MergeSecurityCleanup() {
			super("MergeSecurityCleanup");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
	/**
	 * Cleanup the bus after a federated node has been removed.
	 * The required parameters are found in the constructor.
	 */
	public static class CleanupSIBus extends CommandStep {

		public CleanupSIBus() {
			super("CleanupSIBus");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
