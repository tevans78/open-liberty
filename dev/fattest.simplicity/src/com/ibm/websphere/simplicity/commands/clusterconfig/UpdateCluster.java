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

package com.ibm.websphere.simplicity.commands.clusterconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates the configuration of an application server cluster.
 *   'clusterName': Name of server cluster to update.
 * The required parameters are found in the constructor.
 */
public class UpdateCluster extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String clusterName;

	public UpdateCluster(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("updateCluster");
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
	public OperationResults<Object> run(Scope scope, PreferLocal preferLocal, TransactionLogRecovery transactionLogRecovery, BoundingNodeGroupName boundingNodeGroupName) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (preferLocal != null)
			this.__steps.add(preferLocal);
		if (transactionLogRecovery != null)
			this.__steps.add(transactionLogRecovery);
		if (boundingNodeGroupName != null)
			this.__steps.add(boundingNodeGroupName);
		return super.run(scope);
	}

	/**
	 * Specifies node-scoped routing optimization for the cluster.
	 *   'preferLocal': Enable or disable node-scoped routing optimization for the cluster.
	 * The required parameters are found in the constructor.
	 */
	public static class PreferLocal extends CommandStep {

		private Boolean preferLocal;

		public PreferLocal() {
			super("preferLocal");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.preferLocal != null) {
				ret.put("preferLocal", this.preferLocal);
			}
			return ret;
		}

		/**
		 * Enable or disable node-scoped routing optimization for the cluster.
		 */
		public Boolean getPreferLocal() {
			return this.preferLocal;
		}

		/**
		 * Enable or disable node-scoped routing optimization for the cluster.
		 */
		public void setPreferLocal(Boolean value) {
			this.preferLocal = value;
		}

	}
	/**
	 * Specifies failover of the transaction log.
	 *   'transactionLogRecovery': Enables or disables failover of the transaction log.
	 * The required parameters are found in the constructor.
	 */
	public static class TransactionLogRecovery extends CommandStep {

		private String transactionLogRecovery;

		public TransactionLogRecovery() {
			super("transactionLogRecovery");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.transactionLogRecovery != null) {
				ret.put("transactionLogRecovery", this.transactionLogRecovery);
			}
			return ret;
		}

		/**
		 * Enables or disables failover of the transaction log.
		 */
		public String getTransactionLogRecovery() {
			return this.transactionLogRecovery;
		}

		/**
		 * Enables or disables failover of the transaction log.
		 */
		public void setTransactionLogRecovery(String value) {
			this.transactionLogRecovery = value;
		}

	}
	/**
	 * Updates the name of the node group associated with the cluster.
	 *   'boundingNodeGroupName': Specifies the name of the node group to associate with the cluster.
	 * The required parameters are found in the constructor.
	 */
	public static class BoundingNodeGroupName extends CommandStep {

		private String boundingNodeGroupName;

		public BoundingNodeGroupName() {
			super("boundingNodeGroupName");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.boundingNodeGroupName != null) {
				ret.put("boundingNodeGroupName", this.boundingNodeGroupName);
			}
			return ret;
		}

		/**
		 * Specifies the name of the node group to associate with the cluster.
		 */
		public String getBoundingNodeGroupName() {
			return this.boundingNodeGroupName;
		}

		/**
		 * Specifies the name of the node group to associate with the cluster.
		 */
		public void setBoundingNodeGroupName(String value) {
			this.boundingNodeGroupName = value;
		}

	}
}
