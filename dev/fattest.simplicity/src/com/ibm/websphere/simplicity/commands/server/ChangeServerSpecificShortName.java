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
 * A command that can be used to change the server specific short name.
 *   'serverName': The Server Name
 *   'nodeName': The Node Name
 *   'specificShortName': The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
 * The required parameters are found in the constructor.
 */
public class ChangeServerSpecificShortName extends Command {

	private String serverName;
	private String nodeName;
	private String specificShortName;

	public ChangeServerSpecificShortName(String serverName, String nodeName, String specificShortName) {
		super("changeServerSpecificShortName");
		this.serverName = serverName;
		this.nodeName = nodeName;
		this.specificShortName = specificShortName;
	}

	/**
	 * The Server Name
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The Server Name
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The Node Name
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The Node Name
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public String getSpecificShortName() {
		return this.specificShortName;
	}

	/**
	 * The server specific short name is applicable only on zOS platforms. This represents the specific short name of the server. All servers should have unique specific short name. This parameter is optional and when it is not specified a unique specific short name is automatically assigned. The value should be 8 chars or less and all upper case.
	 */
	public void setSpecificShortName(String value) {
		this.specificShortName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("serverName", this.serverName);
		ret.put("nodeName", this.nodeName);
		ret.put("specificShortName", this.specificShortName);
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
