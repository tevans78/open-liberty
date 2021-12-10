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
 * Delete the configuration of an application server cluster.
 *   'clusterName': Name of server cluster to delete.
 * The required parameters are found in the constructor.
 */
public class DeleteCluster extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String clusterName;

	public DeleteCluster(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("deleteCluster");
		this.__target = commandTarget;
	}

	/**
	 * Name of server cluster to delete.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * Name of server cluster to delete.
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
	public OperationResults<Object> run(Scope scope, ReplicationDomain replicationDomain, CleanupSIBuses cleanupSIBuses) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (replicationDomain != null)
			this.__steps.add(replicationDomain);
		if (cleanupSIBuses != null)
			this.__steps.add(cleanupSIBuses);
		return super.run(scope);
	}

	/**
	 * Specifies the removal of the replication domain for this cluster.
	 *   'deleteRepDomain': Deletes the replication domain for this cluster.
	 * The required parameters are found in the constructor.
	 */
	public static class ReplicationDomain extends CommandStep {

		private Boolean deleteRepDomain = false;

		public ReplicationDomain() {
			super("replicationDomain");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.deleteRepDomain != null) {
				ret.put("deleteRepDomain", this.deleteRepDomain);
			}
			return ret;
		}

		/**
		 * Deletes the replication domain for this cluster.
		 */
		public Boolean getDeleteRepDomain() {
			return this.deleteRepDomain;
		}

		/**
		 * Deletes the replication domain for this cluster.
		 */
		public void setDeleteRepDomain(Boolean value) {
			this.deleteRepDomain = value;
		}

	}
	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class CleanupSIBuses extends CommandStep {

		public CleanupSIBuses() {
			super("CleanupSIBuses");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
