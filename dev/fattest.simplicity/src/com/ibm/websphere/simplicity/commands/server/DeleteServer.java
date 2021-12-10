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

package com.ibm.websphere.simplicity.commands.server;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Delete a server configuration
 *   'serverName': ADMG0105I
 *   'nodeName': ADMG0103I
 * The required parameters are found in the constructor.
 */
public class DeleteServer extends Command {

	private List<Command> __steps;
	private String serverName;
	private String nodeName;

	public DeleteServer(String serverName, String nodeName) {
		super("deleteServer");
		this.serverName = serverName;
		this.nodeName = nodeName;
	}

	/**
	 * ADMG0105I
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * ADMG0105I
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * ADMG0103I
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * ADMG0103I
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("serverName", this.serverName);
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
	public OperationResults<Object> run(Scope scope, ConfigCoreGroup configCoreGroup, CleanupSIBuses cleanupSIBuses) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (configCoreGroup != null)
			this.__steps.add(configCoreGroup);
		if (cleanupSIBuses != null)
			this.__steps.add(cleanupSIBuses);
		return super.run(scope);
	}

	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class ConfigCoreGroup extends CommandStep {

		public ConfigCoreGroup() {
			super("ConfigCoreGroup");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class CleanupSIBuses extends CommandStep {

		public CleanupSIBuses() {
			super("CleanupSIBuses");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
