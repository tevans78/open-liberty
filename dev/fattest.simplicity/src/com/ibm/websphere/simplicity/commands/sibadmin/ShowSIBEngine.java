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
 * Show a messaging engine's attributes.
 *   'bus': The name of the bus to which the messaging engine to be shown belongs.
 *   'node': To show a messaging engine that belongs to a server, supply node and server name, but not cluster name.
 *   'server': To show a messaging engine that belongs to a server, supply node and server name, but not cluster name.
 *   'cluster': To show a messaging engine that belongs to a cluster, supply cluster name, but not node and server name.
 *   'engine': The name of the engine to show.
 * The required parameters are found in the constructor.
 */
public class ShowSIBEngine extends Command {

	private String bus;
	private String node;
	private String server;
	private String cluster;
	private String engine;

	public ShowSIBEngine(String bus) {
		super("showSIBEngine");
		this.bus = bus;
	}

	/**
	 * The name of the bus to which the messaging engine to be shown belongs.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus to which the messaging engine to be shown belongs.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * To show a messaging engine that belongs to a server, supply node and server name, but not cluster name.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * To show a messaging engine that belongs to a server, supply node and server name, but not cluster name.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * To show a messaging engine that belongs to a server, supply node and server name, but not cluster name.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * To show a messaging engine that belongs to a server, supply node and server name, but not cluster name.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * To show a messaging engine that belongs to a cluster, supply cluster name, but not node and server name.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * To show a messaging engine that belongs to a cluster, supply cluster name, but not node and server name.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * The name of the engine to show.
	 */
	public String getEngine() {
		return this.engine;
	}

	/**
	 * The name of the engine to show.
	 */
	public void setEngine(String value) {
		this.engine = value;
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
		if (this.engine != null) {
			ret.put("engine", this.engine);
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
