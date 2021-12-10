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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This is a test function used exclusively by the development
 *   'uuid': Id of the managed node that polls
 *   'jobManagerUUID': Id of the JobManager to be polled by the managed node
 *   'serverUrl': serverUrl
 *   'serverId': serverId
 *   'serverPwd': serverPwd
 *   'clientId': clientId
 *   'clientPwd': clientPwd
 * The required parameters are found in the constructor.
 */
public class TestConnection extends Command {

	private String uuid;
	private String jobManagerUUID;
	private String serverUrl;
	private String serverId = "IBM";
	private String serverPwd = "IBM";
	private String clientId = "dmadmin";
	private String clientPwd = "dmadmin";

	public TestConnection() {
		super("testConnection");
	}

	/**
	 * Id of the managed node that polls
	 */
	public String getUuid() {
		return this.uuid;
	}

	/**
	 * Id of the managed node that polls
	 */
	public void setUuid(String value) {
		this.uuid = value;
	}

	/**
	 * Id of the JobManager to be polled by the managed node
	 */
	public String getJobManagerUUID() {
		return this.jobManagerUUID;
	}

	/**
	 * Id of the JobManager to be polled by the managed node
	 */
	public void setJobManagerUUID(String value) {
		this.jobManagerUUID = value;
	}

	/**
	 * serverUrl
	 */
	public String getServerUrl() {
		return this.serverUrl;
	}

	/**
	 * serverUrl
	 */
	public void setServerUrl(String value) {
		this.serverUrl = value;
	}

	/**
	 * serverId
	 */
	public String getServerId() {
		return this.serverId;
	}

	/**
	 * serverId
	 */
	public void setServerId(String value) {
		this.serverId = value;
	}

	/**
	 * serverPwd
	 */
	public String getServerPwd() {
		return this.serverPwd;
	}

	/**
	 * serverPwd
	 */
	public void setServerPwd(String value) {
		this.serverPwd = value;
	}

	/**
	 * clientId
	 */
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * clientId
	 */
	public void setClientId(String value) {
		this.clientId = value;
	}

	/**
	 * clientPwd
	 */
	public String getClientPwd() {
		return this.clientPwd;
	}

	/**
	 * clientPwd
	 */
	public void setClientPwd(String value) {
		this.clientPwd = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.uuid != null) {
			ret.put("uuid", this.uuid);
		}
		if (this.jobManagerUUID != null) {
			ret.put("jobManagerUUID", this.jobManagerUUID);
		}
		if (this.serverUrl != null) {
			ret.put("serverUrl", this.serverUrl);
		}
		if (this.serverId != null) {
			ret.put("serverId", this.serverId);
		}
		if (this.serverPwd != null) {
			ret.put("serverPwd", this.serverPwd);
		}
		if (this.clientId != null) {
			ret.put("clientId", this.clientId);
		}
		if (this.clientPwd != null) {
			ret.put("clientPwd", this.clientPwd);
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
