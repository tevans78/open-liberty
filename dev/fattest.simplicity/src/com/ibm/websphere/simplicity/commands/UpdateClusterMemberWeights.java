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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates the weights of the specified cluster members.
 *   'clusterName': Name of server cluster to update.
 * The required parameters are found in the constructor.
 */
public class UpdateClusterMemberWeights extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String clusterName;

	public UpdateClusterMemberWeights(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("updateClusterMemberWeights");
		this.__target = commandTarget;
	}

	/**
	 * Name of server cluster to update.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * Name of server cluster to update.
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.clusterName != null) {
			ret.put("clusterName", this.clusterName);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, Members members) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (members != null)
			this.__steps.add(members);
		return super.run(scope);
	}

	/**
	 * Updates the cluster member weights
	 *   'node': Node name of the member to be updated.
	 *   'name': Name of the member to be updated
	 *   'weight': Weight value of cluster member.
	 * The required parameters are found in the constructor.
	 */
	public static class Members extends CommandStep {

		private String node;
		private String name;
		private Integer weight;

		public Members(String node, String name, Integer weight) {
			super("members");
			this.node = node;
			this.name = name;
			this.weight = weight;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("node", this.node);
			ret.put("name", this.name);
			ret.put("weight", this.weight);
			return ret;
		}

		/**
		 * Node name of the member to be updated.
		 */
		public String getNode() {
			return this.node;
		}

		/**
		 * Node name of the member to be updated.
		 */
		public void setNode(String value) {
			this.node = value;
		}

		/**
		 * Name of the member to be updated
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Name of the member to be updated
		 */
		public void setName(String value) {
			this.name = value;
		}

		/**
		 * Weight value of cluster member.
		 */
		public Integer getWeight() {
			return this.weight;
		}

		/**
		 * Weight value of cluster member.
		 */
		public void setWeight(Integer value) {
			this.weight = value;
		}

	}
}
