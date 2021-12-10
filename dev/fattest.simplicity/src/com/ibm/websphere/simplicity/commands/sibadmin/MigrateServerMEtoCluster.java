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
 * This command will migrate a server messaging engine to a cluster messaging engine. It will not modify the messaging engine message store. Please ensure that the message store is suitable for the new clustered environment. If it is not, the migrated engine must be re-configured with a suitable message store before it is started, or the engine may fail to start.
 *   'bus': Bus name
 *   'node': Node name
 *   'server': Server name
 *   'cluster': Cluster name
 *   'rename': Rename engine (defaults to false)
 * The required parameters are found in the constructor.
 */
public class MigrateServerMEtoCluster extends Command {

	private String bus;
	private String node;
	private String server;
	private String cluster;
	private Boolean rename = false;

	public MigrateServerMEtoCluster(String bus, String node, String server, String cluster) {
		super("migrateServerMEtoCluster");
		this.bus = bus;
		this.node = node;
		this.server = server;
		this.cluster = cluster;
	}

	/**
	 * Bus name
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus name
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Node name
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * Node name
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * Server name
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * Server name
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * Cluster name
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * Cluster name
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * Rename engine (defaults to false)
	 */
	public Boolean getRename() {
		return this.rename;
	}

	/**
	 * Rename engine (defaults to false)
	 */
	public void setRename(Boolean value) {
		this.rename = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("node", this.node);
		ret.put("server", this.server);
		ret.put("cluster", this.cluster);
		if (this.rename != null) {
			ret.put("rename", this.rename);
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
