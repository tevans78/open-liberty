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
 * The deployEventServiceMdb command deploys the event service MDB to a server or cluster.
 *   'nodeName': The name of the node where the event service MDB should be deployed. If this parameter is specified, then the serverName parameter must be specified. You must not specify this parameter if the clusterName parameter is specified.
 *   'serverName': The name of the server where the event service MDB should be deployed. You must specify this parameter if the nodeName parameter is specified. You must not specify this parameter if the clusterName parameter is specified.
 *   'clusterName': The name of the cluster where the event service MDB should be deployed. You must not specify this parameter if the nodeName or serverName parameter are specified.
 *   'applicationName': The name of the event service MDB application to be deployed on a server or cluster.
 *   'listenerPort': The name of the listener port where the event service MDB should published the events. The listener port must already be created. You must not specify this parameter if the activation spec parameter is specified.
 *   'activationSpec': The JNDI name of activation spec where the event service MDB should publish the events. The activation spec must already be created. You must not specify this parameter if the listener port parameter is specified.
 *   'qcfJndiName': The JNDI name of the JMS queue connection factory object to be used by the event service MDB. You must specify this parameter if ActivationSpec parameter is specified.
 * The required parameters are found in the constructor.
 */
public class DeployEventServiceMdb extends Command {

	private String nodeName;
	private String serverName;
	private String clusterName;
	private String applicationName;
	private String listenerPort;
	private String activationSpec;
	private String qcfJndiName;

	public DeployEventServiceMdb(String applicationName) {
		super("deployEventServiceMdb");
		this.applicationName = applicationName;
	}

	/**
	 * The name of the node where the event service MDB should be deployed. If this parameter is specified, then the serverName parameter must be specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The name of the node where the event service MDB should be deployed. If this parameter is specified, then the serverName parameter must be specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * The name of the server where the event service MDB should be deployed. You must specify this parameter if the nodeName parameter is specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The name of the server where the event service MDB should be deployed. You must specify this parameter if the nodeName parameter is specified. You must not specify this parameter if the clusterName parameter is specified.
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The name of the cluster where the event service MDB should be deployed. You must not specify this parameter if the nodeName or serverName parameter are specified.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * The name of the cluster where the event service MDB should be deployed. You must not specify this parameter if the nodeName or serverName parameter are specified.
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * The name of the event service MDB application to be deployed on a server or cluster.
	 */
	public String getApplicationName() {
		return this.applicationName;
	}

	/**
	 * The name of the event service MDB application to be deployed on a server or cluster.
	 */
	public void setApplicationName(String value) {
		this.applicationName = value;
	}

	/**
	 * The name of the listener port where the event service MDB should published the events. The listener port must already be created. You must not specify this parameter if the activation spec parameter is specified.
	 */
	public String getListenerPort() {
		return this.listenerPort;
	}

	/**
	 * The name of the listener port where the event service MDB should published the events. The listener port must already be created. You must not specify this parameter if the activation spec parameter is specified.
	 */
	public void setListenerPort(String value) {
		this.listenerPort = value;
	}

	/**
	 * The JNDI name of activation spec where the event service MDB should publish the events. The activation spec must already be created. You must not specify this parameter if the listener port parameter is specified.
	 */
	public String getActivationSpec() {
		return this.activationSpec;
	}

	/**
	 * The JNDI name of activation spec where the event service MDB should publish the events. The activation spec must already be created. You must not specify this parameter if the listener port parameter is specified.
	 */
	public void setActivationSpec(String value) {
		this.activationSpec = value;
	}

	/**
	 * The JNDI name of the JMS queue connection factory object to be used by the event service MDB. You must specify this parameter if ActivationSpec parameter is specified.
	 */
	public String getQcfJndiName() {
		return this.qcfJndiName;
	}

	/**
	 * The JNDI name of the JMS queue connection factory object to be used by the event service MDB. You must specify this parameter if ActivationSpec parameter is specified.
	 */
	public void setQcfJndiName(String value) {
		this.qcfJndiName = value;
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
		ret.put("applicationName", this.applicationName);
		if (this.listenerPort != null) {
			ret.put("listenerPort", this.listenerPort);
		}
		if (this.activationSpec != null) {
			ret.put("activationSpec", this.activationSpec);
		}
		if (this.qcfJndiName != null) {
			ret.put("qcfJndiName", this.qcfJndiName);
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
