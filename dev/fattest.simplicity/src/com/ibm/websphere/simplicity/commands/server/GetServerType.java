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
 * returns the server type of the specified server.
 *   'serverName': The Server Name
 *   'nodeName': The Node Name
 * The required parameters are found in the constructor.
 */
public class GetServerType extends Command {

	private String serverName;
	private String nodeName;

	public GetServerType(String serverName, String nodeName) {
		super("getServerType");
		this.serverName = serverName;
		this.nodeName = nodeName;
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
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
