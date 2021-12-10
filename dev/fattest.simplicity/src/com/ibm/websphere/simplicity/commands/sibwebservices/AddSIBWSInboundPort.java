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
 * Add an inbound port to an inbound service.
 *   'name': Name of the inbound port.
 *   'endpointListener': Name of the associated endpoint listener.
 *   'node': Name of the node where the endpoint listener is located.
 *   'server': Name of the server where the endpoint listener is located.
 *   'cluster': Name of the cluster where the endpoint listener is located.
 *   'templatePort': Name of the port in the template WSDL to use as a basis for this port's binding.
 * The required parameters are found in the constructor.
 */
public class AddSIBWSInboundPort extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String endpointListener;
	private String node;
	private String server;
	private String cluster;
	private String templatePort;

	public AddSIBWSInboundPort(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String endpointListener) {
		super("addSIBWSInboundPort");
		this.__target = commandTarget;
		this.name = name;
		this.endpointListener = endpointListener;
	}

	/**
	 * Name of the inbound port.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the inbound port.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of the associated endpoint listener.
	 */
	public String getEndpointListener() {
		return this.endpointListener;
	}

	/**
	 * Name of the associated endpoint listener.
	 */
	public void setEndpointListener(String value) {
		this.endpointListener = value;
	}

	/**
	 * Name of the node where the endpoint listener is located.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * Name of the node where the endpoint listener is located.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * Name of the server where the endpoint listener is located.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * Name of the server where the endpoint listener is located.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * Name of the cluster where the endpoint listener is located.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * Name of the cluster where the endpoint listener is located.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * Name of the port in the template WSDL to use as a basis for this port's binding.
	 */
	public String getTemplatePort() {
		return this.templatePort;
	}

	/**
	 * Name of the port in the template WSDL to use as a basis for this port's binding.
	 */
	public void setTemplatePort(String value) {
		this.templatePort = value;
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
		ret.put("endpointListener", this.endpointListener);
		if (this.node != null) {
			ret.put("node", this.node);
		}
		if (this.server != null) {
			ret.put("server", this.server);
		}
		if (this.cluster != null) {
			ret.put("cluster", this.cluster);
		}
		if (this.templatePort != null) {
			ret.put("templatePort", this.templatePort);
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
