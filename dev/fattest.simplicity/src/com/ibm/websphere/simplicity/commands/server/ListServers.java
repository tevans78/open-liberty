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
 * list servers of specified server type and node name. If node name is not specified, whole cell will be searched. If the server type is not specified servers of all types are returned.
 *   'serverType': The ServerType ie: (APPLICATION_SERVER)
 *   'nodeName': The Node Name
 * The required parameters are found in the constructor.
 */
public class ListServers extends Command {

	private String serverType;
	private String nodeName;

	public ListServers() {
		super("listServers");
	}

	/**
	 * The ServerType ie: (APPLICATION_SERVER)
	 */
	public String getServerType() {
		return this.serverType;
	}

	/**
	 * The ServerType ie: (APPLICATION_SERVER)
	 */
	public void setServerType(String value) {
		this.serverType = value;
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
		if (this.serverType != null) {
			ret.put("serverType", this.serverType);
		}
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
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
