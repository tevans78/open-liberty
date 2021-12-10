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

package com.ibm.websphere.simplicity.commands.sibwebservices;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Add an outbound port to an outbound service.
 *   'name': Name of the outbound port in the service WSDL.
 *   'node': Name of the node to which the port will be assigned.
 *   'server': Name of the server to which the port will be assigned.
 *   'cluster': Name of the cluster to which the port will be assigned.
 *   'destination': Name to use for the associated port destination.
 *   'userId': User ID to be used if WSDL is obtained through an authorizing proxy.
 *   'password': Password to be used if WSDL is obtained through an authorizing proxy.
 * The required parameters are found in the constructor.
 */
public class AddSIBWSOutboundPort extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String node;
	private String server;
	private String cluster;
	private String destination;
	private String userId;
	private String password;

	public AddSIBWSOutboundPort(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name) {
		super("addSIBWSOutboundPort");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * Name of the outbound port in the service WSDL.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the outbound port in the service WSDL.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of the node to which the port will be assigned.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * Name of the node to which the port will be assigned.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * Name of the server to which the port will be assigned.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * Name of the server to which the port will be assigned.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * Name of the cluster to which the port will be assigned.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * Name of the cluster to which the port will be assigned.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * Name to use for the associated port destination.
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * Name to use for the associated port destination.
	 */
	public void setDestination(String value) {
		this.destination = value;
	}

	/**
	 * User ID to be used if WSDL is obtained through an authorizing proxy.
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * User ID to be used if WSDL is obtained through an authorizing proxy.
	 */
	public void setUserId(String value) {
		this.userId = value;
	}

	/**
	 * Password to be used if WSDL is obtained through an authorizing proxy.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Password to be used if WSDL is obtained through an authorizing proxy.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.node != null) {
			ret.put("node", this.node);
		}
		if (this.server != null) {
			ret.put("server", this.server);
		}
		if (this.cluster != null) {
			ret.put("cluster", this.cluster);
		}
		if (this.destination != null) {
			ret.put("destination", this.destination);
		}
		if (this.userId != null) {
			ret.put("userId", this.userId);
		}
		if (this.password != null) {
			ret.put("password", this.password);
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
