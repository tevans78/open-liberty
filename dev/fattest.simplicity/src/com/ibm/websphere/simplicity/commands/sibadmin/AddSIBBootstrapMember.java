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
 * Nominates a server or cluster for use as a bootstrap server.
 *   'bus': Name of the bus to add the server or cluster to the list of nominated servers.
 *   'node': The name of the node the server to be selected is defined to.
 *   'server': The name of a server to be nominated for bootstrap.
 *   'cluster': The name of a cluster that should be nominated for bootstrap.
 * The required parameters are found in the constructor.
 */
public class AddSIBBootstrapMember extends Command {

	private String bus;
	private String node;
	private String server;
	private String cluster;

	public AddSIBBootstrapMember(String bus) {
		super("addSIBBootstrapMember");
		this.bus = bus;
	}

	/**
	 * Name of the bus to add the server or cluster to the list of nominated servers.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Name of the bus to add the server or cluster to the list of nominated servers.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the node the server to be selected is defined to.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * The name of the node the server to be selected is defined to.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * The name of a server to be nominated for bootstrap.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * The name of a server to be nominated for bootstrap.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * The name of a cluster that should be nominated for bootstrap.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * The name of a cluster that should be nominated for bootstrap.
	 */
	public void setCluster(String value) {
		this.cluster = value;
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
