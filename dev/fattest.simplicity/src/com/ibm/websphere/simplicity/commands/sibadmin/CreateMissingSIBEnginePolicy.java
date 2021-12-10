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
 * Create a core group policy for a messaging engine configured for server cluster bus member with messaging engine policy assistance enabled for the "Custom" policy.
 *   'name': The name of the messaging engine to create a core group policy for.
 *   'failover': Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 *   'failback': Indicates that the messaging engine created can fail back to a preferred server. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 *   'preferredServersOnly': Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
 * The required parameters are found in the constructor.
 */
public class CreateMissingSIBEnginePolicy extends Command {

	private List<Command> __steps;
	private String name;
	private Boolean failover;
	private Boolean failback;
	private Boolean preferredServersOnly;

	public CreateMissingSIBEnginePolicy(String name) {
		super("createMissingSIBEnginePolicy");
		this.name = name;
	}

	/**
	 * The name of the messaging engine to create a core group policy for.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the messaging engine to create a core group policy for.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public Boolean getFailover() {
		return this.failover;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public void setFailover(Boolean value) {
		this.failover = value;
	}

	/**
	 * Indicates that the messaging engine created can fail back to a preferred server. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public Boolean getFailback() {
		return this.failback;
	}

	/**
	 * Indicates that the messaging engine created can fail back to a preferred server. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public void setFailback(Boolean value) {
		this.failback = value;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public Boolean getPreferredServersOnly() {
		return this.preferredServersOnly;
	}

	/**
	 * Indicates that the messaging engine created can failover to other servers. This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 */
	public void setPreferredServersOnly(Boolean value) {
		this.preferredServersOnly = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.failover != null) {
			ret.put("failover", this.failover);
		}
		if (this.failback != null) {
			ret.put("failback", this.failback);
		}
		if (this.preferredServersOnly != null) {
			ret.put("preferredServersOnly", this.preferredServersOnly);
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
	public OperationResults<Object> run(Scope scope, PreferredServerList preferredServerList) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (preferredServerList != null)
			this.__steps.add(preferredServerList);
		return super.run(scope);
	}

	/**
	 * The list of preferred servers for the messaging engine created.  This option can be used when messaging engine policy assistance is enabled and the "CUSTOM" policy is selected.
	 *   'node': The name of the node on which the server is configured
	 *   'server': The name of the server to add to the preferred server list
	 * The required parameters are found in the constructor.
	 */
	public static class PreferredServerList extends CommandStep {

		private String node;
		private String server;

		public PreferredServerList(String node, String server) {
			super("preferredServerList");
			this.node = node;
			this.server = server;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("node", this.node);
			ret.put("server", this.server);
			return ret;
		}

		/**
		 * The name of the node on which the server is configured
		 */
		public String getNode() {
			return this.node;
		}

		/**
		 * The name of the node on which the server is configured
		 */
		public void setNode(String value) {
			this.node = value;
		}

		/**
		 * The name of the server to add to the preferred server list
		 */
		public String getServer() {
			return this.server;
		}

		/**
		 * The name of the server to add to the preferred server list
		 */
		public void setServer(String value) {
			this.server = value;
		}

	}
}
