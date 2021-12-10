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
 * set Java virtual machine (JVM) system property for the application server's process.
 *   'serverName': The name of the Server whose process definition is modified. If there is only one server in the entire configuration, then this parameter is optional.
 *   'nodeName': The name of the node. This is only needed for the server scopes that do not have a unique name across nodes.
 *   'processType': The process type of the server.  This is for zOS only.
 *   'propertyName': The JVM system property name
 *   'propertyValue': The JVM system property value
 * The required parameters are found in the constructor.
 */
public class SetJVMSystemProperties extends Command {

	private String serverName;
	private String nodeName;
	private String processType;
	private String propertyName;
	private String propertyValue;

	public SetJVMSystemProperties(String propertyName, String propertyValue) {
		super("setJVMSystemProperties");
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
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
	 * The JVM system property name
	 */
	public String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * The JVM system property name
	 */
	public void setPropertyName(String value) {
		this.propertyName = value;
	}

	/**
	 * The JVM system property value
	 */
	public String getPropertyValue() {
		return this.propertyValue;
	}

	/**
	 * The JVM system property value
	 */
	public void setPropertyValue(String value) {
		this.propertyValue = value;
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
		ret.put("propertyName", this.propertyName);
		ret.put("propertyValue", this.propertyValue);
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
