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
 * Delete a server configuration
 *   'serverName': ADMG0105I
 *   'nodeName': ADMG0103I
 * The required parameters are found in the constructor.
 */
public class DeleteWebServer extends Command {

	private String serverName;
	private String nodeName;

	public DeleteWebServer(String serverName, String nodeName) {
		super("deleteWebServer");
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
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
