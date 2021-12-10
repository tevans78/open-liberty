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
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a messaging engine.
 *   'bus': The name of the bus to which the messaging engine is to belong.
 *   'node': To modify a messaging engine on a server, supply node and server name, but not cluster name.
 *   'server': To modify a messaging engine on a server, supply node and server name, but not cluster name.
 *   'cluster': To modify a messaging engine on a cluster, supply cluster name, but not node and server name.
 *   'engine': The name of the messaging engine to be modified.
 *   'description': Description of the messaging engine.
 *   'initialState': Whether the messaging engine is started or stopped when the associated application server is first started. Until started, the messaging engine is unavailable. (Stopped | Started).
 *   'highMessageThreshold': The maximum total number of messages that the messaging engine can place on its message points.
 *   'defaultBlockedRetryTimeout': The default blocked retry interval for destinations owned by this messaging engine.
 * The required parameters are found in the constructor.
 */
public class ModifySIBEngine extends Command {

	private List<Command> __steps;
	private String bus;
	private String node;
	private String server;
	private String cluster;
	private String engine;
	private String description;
	private String initialState;
	private java.lang.Long highMessageThreshold;
	private java.lang.Long defaultBlockedRetryTimeout;

	public ModifySIBEngine(String bus) {
		super("modifySIBEngine");
		this.bus = bus;
	}

	/**
	 * The name of the bus to which the messaging engine is to belong.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus to which the messaging engine is to belong.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * To modify a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public String getNode() {
		return this.node;
	}

	/**
	 * To modify a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public void setNode(String value) {
		this.node = value;
	}

	/**
	 * To modify a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public String getServer() {
		return this.server;
	}

	/**
	 * To modify a messaging engine on a server, supply node and server name, but not cluster name.
	 */
	public void setServer(String value) {
		this.server = value;
	}

	/**
	 * To modify a messaging engine on a cluster, supply cluster name, but not node and server name.
	 */
	public String getCluster() {
		return this.cluster;
	}

	/**
	 * To modify a messaging engine on a cluster, supply cluster name, but not node and server name.
	 */
	public void setCluster(String value) {
		this.cluster = value;
	}

	/**
	 * The name of the messaging engine to be modified.
	 */
	public String getEngine() {
		return this.engine;
	}

	/**
	 * The name of the messaging engine to be modified.
	 */
	public void setEngine(String value) {
		this.engine = value;
	}

	/**
	 * Description of the messaging engine.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the messaging engine.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Whether the messaging engine is started or stopped when the associated application server is first started. Until started, the messaging engine is unavailable. (Stopped | Started).
	 */
	public String getInitialState() {
		return this.initialState;
	}

	/**
	 * Whether the messaging engine is started or stopped when the associated application server is first started. Until started, the messaging engine is unavailable. (Stopped | Started).
	 */
	public void setInitialState(String value) {
		this.initialState = value;
	}

	/**
	 * The maximum total number of messages that the messaging engine can place on its message points.
	 */
	public java.lang.Long getHighMessageThreshold() {
		return this.highMessageThreshold;
	}

	/**
	 * The maximum total number of messages that the messaging engine can place on its message points.
	 */
	public void setHighMessageThreshold(java.lang.Long value) {
		this.highMessageThreshold = value;
	}

	/**
	 * The default blocked retry interval for destinations owned by this messaging engine.
	 */
	public java.lang.Long getDefaultBlockedRetryTimeout() {
		return this.defaultBlockedRetryTimeout;
	}

	/**
	 * The default blocked retry interval for destinations owned by this messaging engine.
	 */
	public void setDefaultBlockedRetryTimeout(java.lang.Long value) {
		this.defaultBlockedRetryTimeout = value;
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
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.initialState != null) {
			ret.put("initialState", this.initialState);
		}
		if (this.highMessageThreshold != null) {
			ret.put("highMessageThreshold", this.highMessageThreshold);
		}
		if (this.defaultBlockedRetryTimeout != null) {
			ret.put("defaultBlockedRetryTimeout", this.defaultBlockedRetryTimeout);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, TargetGroups targetGroups) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (targetGroups != null)
			this.__steps.add(targetGroups);
		return super.run(scope);
	}

	/**
	 * The target groups for this messaging engine.
	 *   'group': The name of a target group.
	 * The required parameters are found in the constructor.
	 */
	public static class TargetGroups extends CommandStep {

		private String group;

		public TargetGroups(String group) {
			super("targetGroups");
			this.group = group;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("group", this.group);
			return ret;
		}

		/**
		 * The name of a target group.
		 */
		public String getGroup() {
			return this.group;
		}

		/**
		 * The name of a target group.
		 */
		public void setGroup(String value) {
			this.group = value;
		}

	}
}
