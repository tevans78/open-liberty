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

package com.ibm.websphere.simplicity.commands.eventservice;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The showEventServiceStatus command returns the status of the event service in a server or cluster. If the task is executed with no parameters, the status of all event services is displayed. To filter the list of event services to be displayed, provide nodeName, serverName or clusterName.
 *   'nodeName': Use this parameter to display only the status of the event services that belong to the specified node. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': Use this parameter to display only the status of the event services that belong to the specified server. You can use this parameter with the node parameter to display the status of the event service belonging to the specified node/server. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': Use this parameter to only display the status of the event services that belong to the specified cluster. You must not specify this parameter if the nodeName or serverName parameter are specified.
 * The required parameters are found in the constructor.
 */
public class ShowEventServiceStatus extends Command {

	private String nodeName;
	private String serverName;
	private String clusterName;

	public ShowEventServiceStatus() {
		super("showEventServiceStatus");
	}

	/**
	 * Use this parameter to display only the status of the event services that belong to the specified node. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * Use this parameter to display only the status of the event services that belong to the specified node. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Use this parameter to display only the status of the event services that belong to the specified server. You can use this parameter with the node parameter to display the status of the event service belonging to the specified node/server. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * Use this parameter to display only the status of the event services that belong to the specified server. You can use this parameter with the node parameter to display the status of the event service belonging to the specified node/server. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * Use this parameter to only display the status of the event services that belong to the specified cluster. You must not specify this parameter if the nodeName or serverName parameter are specified.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * Use this parameter to only display the status of the event services that belong to the specified cluster. You must not specify this parameter if the nodeName or serverName parameter are specified.
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
		}
		if (this.serverName != null) {
			ret.put("serverName", this.serverName);
		}
		if (this.clusterName != null) {
			ret.put("clusterName", this.clusterName);
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
