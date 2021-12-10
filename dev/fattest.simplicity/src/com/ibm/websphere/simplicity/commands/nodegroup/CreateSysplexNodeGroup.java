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

package com.ibm.websphere.simplicity.commands.nodegroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * create sysplex node group
 *   'shortName': the shortName (alias) of the node group
 *   'description': a description for the node group
 *   'sysplexName': Sysplex Name
 *   'icuData': Daemon ICU DATA
 *   'daemonName': Daemon Name
 *   'jobName': Daemon Job Name
 *   'serverGenericShortName': Daemon generic server name
 *   'serverGenericUuid': Daemon generic uuid
 *   'port': Daemon IP Port
 *   'sslPort': Daemon SSL port
 *   'ipAddress': Daemon IP Address
 *   'sslRepertoire': Daemon SSL repertoire
 *   'groupName': Daemon group name
 * The required parameters are found in the constructor.
 */
public class CreateSysplexNodeGroup extends Command {

	private String __target;
	private String shortName;
	private String description;
	private String sysplexName;
	private String icuData;
	private String daemonName;
	private String jobName;
	private String serverGenericShortName;
	private String serverGenericUuid;
	private String port;
	private String sslPort;
	private String ipAddress;
	private String sslRepertoire;
	private String groupName;

	public CreateSysplexNodeGroup(String commandTarget, String shortName, String sysplexName, String daemonName, String jobName, String serverGenericShortName, String serverGenericUuid, String port, String ipAddress) {
		super("createSysplexNodeGroup");
		this.__target = commandTarget;
		this.shortName = shortName;
		this.sysplexName = sysplexName;
		this.daemonName = daemonName;
		this.jobName = jobName;
		this.serverGenericShortName = serverGenericShortName;
		this.serverGenericUuid = serverGenericUuid;
		this.port = port;
		this.ipAddress = ipAddress;
	}

	/**
	 * the shortName (alias) of the node group
	 */
	public String getShortName() {
		return this.shortName;
	}

	/**
	 * the shortName (alias) of the node group
	 */
	public void setShortName(String value) {
		this.shortName = value;
	}

	/**
	 * a description for the node group
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * a description for the node group
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Sysplex Name
	 */
	public String getSysplexName() {
		return this.sysplexName;
	}

	/**
	 * Sysplex Name
	 */
	public void setSysplexName(String value) {
		this.sysplexName = value;
	}

	/**
	 * Daemon ICU DATA
	 */
	public String getIcuData() {
		return this.icuData;
	}

	/**
	 * Daemon ICU DATA
	 */
	public void setIcuData(String value) {
		this.icuData = value;
	}

	/**
	 * Daemon Name
	 */
	public String getDaemonName() {
		return this.daemonName;
	}

	/**
	 * Daemon Name
	 */
	public void setDaemonName(String value) {
		this.daemonName = value;
	}

	/**
	 * Daemon Job Name
	 */
	public String getJobName() {
		return this.jobName;
	}

	/**
	 * Daemon Job Name
	 */
	public void setJobName(String value) {
		this.jobName = value;
	}

	/**
	 * Daemon generic server name
	 */
	public String getServerGenericShortName() {
		return this.serverGenericShortName;
	}

	/**
	 * Daemon generic server name
	 */
	public void setServerGenericShortName(String value) {
		this.serverGenericShortName = value;
	}

	/**
	 * Daemon generic uuid
	 */
	public String getServerGenericUuid() {
		return this.serverGenericUuid;
	}

	/**
	 * Daemon generic uuid
	 */
	public void setServerGenericUuid(String value) {
		this.serverGenericUuid = value;
	}

	/**
	 * Daemon IP Port
	 */
	public String getPort() {
		return this.port;
	}

	/**
	 * Daemon IP Port
	 */
	public void setPort(String value) {
		this.port = value;
	}

	/**
	 * Daemon SSL port
	 */
	public String getSslPort() {
		return this.sslPort;
	}

	/**
	 * Daemon SSL port
	 */
	public void setSslPort(String value) {
		this.sslPort = value;
	}

	/**
	 * Daemon IP Address
	 */
	public String getIpAddress() {
		return this.ipAddress;
	}

	/**
	 * Daemon IP Address
	 */
	public void setIpAddress(String value) {
		this.ipAddress = value;
	}

	/**
	 * Daemon SSL repertoire
	 */
	public String getSslRepertoire() {
		return this.sslRepertoire;
	}

	/**
	 * Daemon SSL repertoire
	 */
	public void setSslRepertoire(String value) {
		this.sslRepertoire = value;
	}

	/**
	 * Daemon group name
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Daemon group name
	 */
	public void setGroupName(String value) {
		this.groupName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("shortName", this.shortName);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		ret.put("sysplexName", this.sysplexName);
		if (this.icuData != null) {
			ret.put("icuData", this.icuData);
		}
		ret.put("daemonName", this.daemonName);
		ret.put("jobName", this.jobName);
		ret.put("serverGenericShortName", this.serverGenericShortName);
		ret.put("serverGenericUuid", this.serverGenericUuid);
		ret.put("port", this.port);
		if (this.sslPort != null) {
			ret.put("sslPort", this.sslPort);
		}
		ret.put("ipAddress", this.ipAddress);
		if (this.sslRepertoire != null) {
			ret.put("sslRepertoire", this.sslRepertoire);
		}
		if (this.groupName != null) {
			ret.put("groupName", this.groupName);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
