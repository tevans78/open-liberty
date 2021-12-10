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
 * The removeEventService command removes the event service from a server or cluster.
 *   'nodeName': The name of the node from which the event service should be removed. If this parameter is specified, then the serverName parameter must be specified. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server from which the event service should be removed. You must specify this parameter if the nodeName parameter is specified. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster from which the event service should be removed. You must not specify this parameter if the nodeName or serverName parameter are specified.
 * The required parameters are found in the constructor.
 */
public class RemoveEventService extends Command {

	private String nodeName;
	private String serverName;
	private String clusterName;

	public RemoveEventService() {
		super("removeEventService");
	}

	/**
	 * The name of the node from which the event service should be removed. If this parameter is specified, then the serverName parameter must be specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node from which the event service should be removed. If this parameter is specified, then the serverName parameter must be specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The name of the server from which the event service should be removed. You must specify this parameter if the nodeName parameter is specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the server from which the event service should be removed. You must specify this parameter if the nodeName parameter is specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The name of the cluster from which the event service should be removed. You must not specify this parameter if the nodeName or serverName parameter are specified.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * The name of the cluster from which the event service should be removed. You must not specify this parameter if the nodeName or serverName parameter are specified.
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
