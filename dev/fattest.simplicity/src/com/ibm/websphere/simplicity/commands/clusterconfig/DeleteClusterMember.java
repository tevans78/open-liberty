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
 * Deletes a member from an application server cluster.
 *   'clusterName': Name of server cluster which the cluster member to be deleted belongs to.
 *   'memberNode': Name of node where the cluster member resides.
 *   'memberName': Name of cluster member to be deleted.
 * The required parameters are found in the constructor.
 */
public class DeleteClusterMember extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String clusterName;
	private String memberNode;
	private String memberName;

	public DeleteClusterMember(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("deleteClusterMember");
		this.__target = commandTarget;
	}

	/**
	 * Name of server cluster which the cluster member to be deleted belongs to.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * Name of server cluster which the cluster member to be deleted belongs to.
	 */
	public void setClusterName(String value) {
		this.clusterName = value;
	}

	/**
	 * Name of node where the cluster member resides.
	 */
	public String getMemberNode() {
		return this.memberNode;
	}

	/**
	 * Name of node where the cluster member resides.
	 */
	public void setMemberNode(String value) {
		this.memberNode = value;
	}

	/**
	 * Name of cluster member to be deleted.
	 */
	public String getMemberName() {
		return this.memberName;
	}

	/**
	 * Name of cluster member to be deleted.
	 */
	public void setMemberName(String value) {
		this.memberName = value;
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
		if (this.memberNode != null) {
			ret.put("memberNode", this.memberNode);
		}
		if (this.memberName != null) {
			ret.put("memberName", this.memberName);
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
	public OperationResults<Object> run(Scope scope, ReplicatorEntry replicatorEntry, EventServiceConfig eventServiceConfig, WebsvcsConfigCoreGroup websvcsConfigCoreGroup) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (replicatorEntry != null)
			this.__steps.add(replicatorEntry);
		if (eventServiceConfig != null)
			this.__steps.add(eventServiceConfig);
		if (websvcsConfigCoreGroup != null)
			this.__steps.add(websvcsConfigCoreGroup);
		return super.run(scope);
	}

	/**
	 * Specifies the removal of a replicator entry for this cluster member.
	 *   'deleteEntry': Deletes the replicator entry having the server name of this cluster member from the cluster's replication domain.
	 * The required parameters are found in the constructor.
	 */
	public static class ReplicatorEntry extends CommandStep {

		private Boolean deleteEntry = false;

		public ReplicatorEntry() {
			super("replicatorEntry");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.deleteEntry != null) {
				ret.put("deleteEntry", this.deleteEntry);
			}
			return ret;
		}

		/**
		 * Deletes the replicator entry having the server name of this cluster member from the cluster's replication domain.
		 */
		public Boolean getDeleteEntry() {
			return this.deleteEntry;
		}

		/**
		 * Deletes the replicator entry having the server name of this cluster member from the cluster's replication domain.
		 */
		public void setDeleteEntry(Boolean value) {
			this.deleteEntry = value;
		}

	}
	/**
	 * Specifies the event service configuration when a member is deleted from the cluster.
	 * The required parameters are found in the constructor.
	 */
	public static class EventServiceConfig extends CommandStep {

		public EventServiceConfig() {
			super("eventServiceConfig");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
	/**
	 * 
	 *   'coregroupName': 
	 * The required parameters are found in the constructor.
	 */
	public static class WebsvcsConfigCoreGroup extends CommandStep {

		private String coregroupName;

		public WebsvcsConfigCoreGroup() {
			super("WebsvcsConfigCoreGroup");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.coregroupName != null) {
				ret.put("coregroupName", this.coregroupName);
			}
			return ret;
		}

		/**
		 * 
		 */
		public String getCoregroupName() {
			return this.coregroupName;
		}

		/**
		 * 
		 */
		public void setCoregroupName(String value) {
			this.coregroupName = value;
		}

	}
}
