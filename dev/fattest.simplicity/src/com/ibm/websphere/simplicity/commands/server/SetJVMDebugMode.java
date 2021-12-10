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

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Set Java virtual machine (JVM) Debug Mode
 *   'serverName': The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
 *   'nodeName': The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
 *   'processType': The process type of the server.  This is for zOS only.
 *   'debugMode': Specifies whether to run the JVM in debug mode. The default is not to enable debug mode support.
 * The required parameters are found in the constructor.
 */
public class SetJVMDebugMode extends Command {

	private String serverName;
	private String nodeName;
	private String processType;
	private Boolean debugMode;

	public SetJVMDebugMode(Boolean debugMode) {
		super("setJVMDebugMode");
		this.debugMode = debugMode;
	}

	/**
	 * The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The process type of the server.  This is for zOS only.
	 */
	public String getProcessType() {
		return this.processType;
	}

	/**
	 * The process type of the server.  This is for zOS only.
	 */
	public void setProcessType(String value) {
		this.processType = value;
	}

	/**
	 * Specifies whether to run the JVM in debug mode. The default is not to enable debug mode support.
	 */
	public Boolean getDebugMode() {
		return this.debugMode;
	}

	/**
	 * Specifies whether to run the JVM in debug mode. The default is not to enable debug mode support.
	 */
	public void setDebugMode(Boolean value) {
		this.debugMode = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		if (this.processType != null) {
			ret.put("processType", this.processType);
		}
		ret.put("debugMode", this.debugMode);
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
