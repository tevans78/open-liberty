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

package com.ibm.websphere.simplicity.commands.managednodeagent;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Stop a managed node's polling against a JobManager
 *   'managedNodeName': Name of the managed node that polls
 *   'jobManagerUUID': ID of the JobManager being polled by the managed node
 *   'host': The host component of JobManager URL
 *   'port': The port component of JobManager URL
 * The required parameters are found in the constructor.
 */
public class StopPollingJobManager extends Command {

	private String managedNodeName;
	private String jobManagerUUID;
	private String host;
	private String port;

	public StopPollingJobManager(String managedNodeName) {
		super("stopPollingJobManager");
		this.managedNodeName = managedNodeName;
	}

	/**
	 * Name of the managed node that polls
	 */
	public String getManagedNodeName() {
		return this.managedNodeName;
	}

	/**
	 * Name of the managed node that polls
	 */
	public void setManagedNodeName(String value) {
		this.managedNodeName = value;
	}

	/**
	 * ID of the JobManager being polled by the managed node
	 */
	public String getJobManagerUUID() {
		return this.jobManagerUUID;
	}

	/**
	 * ID of the JobManager being polled by the managed node
	 */
	public void setJobManagerUUID(String value) {
		this.jobManagerUUID = value;
	}

	/**
	 * The host component of JobManager URL
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * The host component of JobManager URL
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * The port component of JobManager URL
	 */
	public String getPort() {
		return this.port;
	}

	/**
	 * The port component of JobManager URL
	 */
	public void setPort(String value) {
		this.port = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("managedNodeName", this.managedNodeName);
		if (this.jobManagerUUID != null) {
			ret.put("jobManagerUUID", this.jobManagerUUID);
		}
		if (this.host != null) {
			ret.put("host", this.host);
		}
		if (this.port != null) {
			ret.put("port", this.port);
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
