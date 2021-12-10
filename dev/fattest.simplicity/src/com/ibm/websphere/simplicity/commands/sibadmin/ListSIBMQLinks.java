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
 * List the WebSphere MQ links.
 *   'bus': The name of the bus.
 *   'node': The name of the node.
 *   'server': The name of the server.
 *   'cluster': The name of the cluster.
 *   'messagingEngine': The name of the messaging engine.
 *   'foreignBus': The name of the foreign bus.
 *   'javaFormat': The output from the command is a format suitable for java program clients.
 * The required parameters are found in the constructor.
 */
public class ListSIBMQLinks extends Command {

	private String bus;
	private String node;
	private String server;
	private String cluster;
	private String messagingEngine;
	private String foreignBus;
	private Boolean javaFormat = true;

	public ListSIBMQLinks(String bus) {
		super("listSIBMQLinks");
		this.bus = bus;
	}

	/**
	 * The name of the bus.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the node.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * The name of the node.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * The name of the server.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * The name of the server.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * The name of the cluster.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * The name of the cluster.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * The name of the messaging engine.
	 */
	public String getMessagingEngine() {
		return this.messagingEngine;
	}

	/**
	 * The name of the messaging engine.
	 */
	public void setMessagingEngine(String value) {
		this.messagingEngine = value;
	}

	/**
	 * The name of the foreign bus.
	 */
	public String getForeignBus() {
		return this.foreignBus;
	}

	/**
	 * The name of the foreign bus.
	 */
	public void setForeignBus(String value) {
		this.foreignBus = value;
	}

	/**
	 * The output from the command is a format suitable for java program clients.
	 */
	public Boolean getJavaFormat() {
		return this.javaFormat;
	}

	/**
	 * The output from the command is a format suitable for java program clients.
	 */
	public void setJavaFormat(Boolean value) {
		this.javaFormat = value;
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
		if (this.messagingEngine != null) {
			ret.put("messagingEngine", this.messagingEngine);
		}
		if (this.foreignBus != null) {
			ret.put("foreignBus", this.foreignBus);
		}
		if (this.javaFormat != null) {
			ret.put("javaFormat", this.javaFormat);
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
