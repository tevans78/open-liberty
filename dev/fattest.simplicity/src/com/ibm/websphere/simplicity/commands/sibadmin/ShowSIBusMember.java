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

package com.ibm.websphere.simplicity.commands.sibadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Show a member from a bus.
 *   'bus': Name of bus to show member from.
 *   'node': To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
 *   'server': To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
 *   'cluster': To specify a cluster bus member, supply cluster name, but not node name, server name or WebSphere MQ server name.
 *   'wmqServer': To specify an WebSphere MQ server bus member, supply WebSphere MQ server name, but not node name, server name or cluster name.
 * The required parameters are found in the constructor.
 */
public class ShowSIBusMember extends Command {

	private String bus;
	private String node;
	private String server;
	private String cluster;
	private String wmqServer;

	public ShowSIBusMember(String bus) {
		super("showSIBusMember");
		this.bus = bus;
	}

	/**
	 * Name of bus to show member from.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of bus to show member from.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * To specify a server bus member, supply node and server name, but not cluster name or WebSphere MQ server name.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * To specify a cluster bus member, supply cluster name, but not node name, server name or WebSphere MQ server name.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * To specify a cluster bus member, supply cluster name, but not node name, server name or WebSphere MQ server name.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * To specify an WebSphere MQ server bus member, supply WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public String getWmqServer() {
		return this.wmqServer;
	}

	/**
	 * To specify an WebSphere MQ server bus member, supply WebSphere MQ server name, but not node name, server name or cluster name.
	 */
	public void setWmqServer(String value) {
		this.wmqServer = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		if (this.node != null) {
			ret.put("node", this.node);
		}
		if (this.server != null) {
			ret.put("server", this.server);
		}
		if (this.cluster != null) {
			ret.put("cluster", this.cluster);
		}
		if (this.wmqServer != null) {
			ret.put("wmqServer", this.wmqServer);
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
