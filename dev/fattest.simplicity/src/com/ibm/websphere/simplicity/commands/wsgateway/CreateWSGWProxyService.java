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

package com.ibm.websphere.simplicity.commands.wsgateway;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a proxy service.
 *   'name': Name of the proxy service to be created.
 *   'node': Name of the node to which the proxy service will be assigned.
 *   'server': Name of the server to which the proxy service will be assigned.
 *   'cluster': Name of the cluster to which the proxy service will be assigned.
 *   'requestDestination': Name to use for the proxy service's request destination.
 *   'replyDestination': Name to use for the proxy service's reply destination.
 *   'wsdlLocation': Location of the template WSDL to use for the proxy service.
 * The required parameters are found in the constructor.
 */
public class CreateWSGWProxyService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String node;
	private String server;
	private String cluster;
	private String requestDestination;
	private String replyDestination;
	private String wsdlLocation;

	public CreateWSGWProxyService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name) {
		super("createWSGWProxyService");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * Name of the proxy service to be created.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the proxy service to be created.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of the node to which the proxy service will be assigned.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * Name of the node to which the proxy service will be assigned.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * Name of the server to which the proxy service will be assigned.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * Name of the server to which the proxy service will be assigned.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * Name of the cluster to which the proxy service will be assigned.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * Name of the cluster to which the proxy service will be assigned.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * Name to use for the proxy service's request destination.
	 */
	public String getRequestDestination() {
		return this.requestDestination;
	}

	/**
	 * Name to use for the proxy service's request destination.
	 */
	public void setRequestDestination(String value) {
		this.requestDestination = value;
	}

	/**
	 * Name to use for the proxy service's reply destination.
	 */
	public String getReplyDestination() {
		return this.replyDestination;
	}

	/**
	 * Name to use for the proxy service's reply destination.
	 */
	public void setReplyDestination(String value) {
		this.replyDestination = value;
	}

	/**
	 * Location of the template WSDL to use for the proxy service.
	 */
	public String getWsdlLocation() {
		return this.wsdlLocation;
	}

	/**
	 * Location of the template WSDL to use for the proxy service.
	 */
	public void setWsdlLocation(String value) {
		this.wsdlLocation = value;
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
		if (this.requestDestination != null) {
			ret.put("requestDestination", this.requestDestination);
		}
		if (this.replyDestination != null) {
			ret.put("replyDestination", this.replyDestination);
		}
		if (this.wsdlLocation != null) {
			ret.put("wsdlLocation", this.wsdlLocation);
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
