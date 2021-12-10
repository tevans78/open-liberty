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
 * Creates a new application server cluster.
 * The required parameters are found in the constructor.
 */
public class CreateCluster extends Command {

	private List<Command> __steps;
	public CreateCluster() {
		super("createCluster");
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
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
	public OperationResults<Object> run(Scope scope, ClusterConfig clusterConfig, ReplicationDomain replicationDomain, ConvertServer convertServer, EventServiceConfig eventServiceConfig, PromoteProxyServer promoteProxyServer) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (clusterConfig != null)
			this.__steps.add(clusterConfig);
		if (replicationDomain != null)
			this.__steps.add(replicationDomain);
		if (convertServer != null)
			this.__steps.add(convertServer);
		if (eventServiceConfig != null)
			this.__steps.add(eventServiceConfig);
		if (promoteProxyServer != null)
			this.__steps.add(promoteProxyServer);
		return super.run(scope);
	}

	/**
	 * Specifies the configuration of the new server cluster.
	 *   'clusterName': Name of server cluster.
	 *   'preferLocal': Enables node-scoped routing optimization for the cluster.
	 *   'clusterType': Type of server cluster.
	 *   'shortName': Short name of server cluster for zOS platforms.
	 * The required parameters are found in the constructor.
	 */
	public static class ClusterConfig extends CommandStep {

		private String clusterName;
		private Boolean preferLocal = true;
		private String clusterType;
		private String shortName;

		public ClusterConfig(String clusterName) {
			super("clusterConfig");
			this.clusterName = clusterName;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("clusterName", this.clusterName);
			if (this.preferLocal != null) {
				ret.put("preferLocal", this.preferLocal);
			}
			if (this.clusterType != null) {
				ret.put("clusterType", this.clusterType);
			}
			if (this.shortName != null) {
				ret.put("shortName", this.shortName);
			}
			return ret;
		}

		/**
		 * Name of server cluster.
		 */
		public String getClusterName() {
			return this.clusterName;
		}

		/**
		 * Name of server cluster.
		 */
		public void setClusterName(String value) {
			this.clusterName = value;
		}

		/**
		 * Enables node-scoped routing optimization for the cluster.
		 */
		public Boolean getPreferLocal() {
			return this.preferLocal;
		}

		/**
		 * Enables node-scoped routing optimization for the cluster.
		 */
		public void setPreferLocal(Boolean value) {
			this.preferLocal = value;
		}

		/**
		 * Type of server cluster.
		 */
		public String getClusterType() {
			return this.clusterType;
		}

		/**
		 * Type of server cluster.
		 */
		public void setClusterType(String value) {
			this.clusterType = value;
		}

		/**
		 * Short name of server cluster for zOS platforms.
		 */
		public String getShortName() {
			return this.shortName;
		}

		/**
		 * Short name of server cluster for zOS platforms.
		 */
		public void setShortName(String value) {
			this.shortName = value;
		}

	}
	/**
	 * Specifies the configuration of a replication domain for this cluster.  Used for HTTP session data replication.
	 *   'createDomain': Creates a replication domain with a name set to the name of the new cluster.
	 * The required parameters are found in the constructor.
	 */
	public static class ReplicationDomain extends CommandStep {

		private Boolean createDomain = false;

		public ReplicationDomain() {
			super("replicationDomain");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.createDomain != null) {
				ret.put("createDomain", this.createDomain);
			}
			return ret;
		}

		/**
		 * Creates a replication domain with a name set to the name of the new cluster.
		 */
		public Boolean getCreateDomain() {
			return this.createDomain;
		}

		/**
		 * Creates a replication domain with a name set to the name of the new cluster.
		 */
		public void setCreateDomain(Boolean value) {
			this.createDomain = value;
		}

	}
	/**
	 * Specifies an existing server will be converted to be the first member of cluster.
	 *   'serverNode': Name of node with the existing server to convert to first member of the cluster.
	 *   'serverName': Name of existing server to convert to first member of the cluster.
	 *   'memberWeight': Weight value of cluster member.
	 *   'nodeGroup': Name of node group which all cluster member nodes must belong to.
	 *   'replicatorEntry': Enable this member to use data replication service for HTTP session persistence.
	 *   'resourcesScope': resourcesScopeDesc
	 * The required parameters are found in the constructor.
	 */
	public static class ConvertServer extends CommandStep {

		private Boolean __target;
		private String serverNode;
		private String serverName;
		private Integer memberWeight;
		private String nodeGroup;
		private Boolean replicatorEntry;
		private String resourcesScope = "both";

		public ConvertServer(Boolean commandTarget) {
			super("convertServer");
			this.__target = commandTarget;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.serverNode != null) {
				ret.put("serverNode", this.serverNode);
			}
			if (this.serverName != null) {
				ret.put("serverName", this.serverName);
			}
			if (this.memberWeight != null) {
				ret.put("memberWeight", this.memberWeight);
			}
			if (this.nodeGroup != null) {
				ret.put("nodeGroup", this.nodeGroup);
			}
			if (this.replicatorEntry != null) {
				ret.put("replicatorEntry", this.replicatorEntry);
			}
			if (this.resourcesScope != null) {
				ret.put("resourcesScope", this.resourcesScope);
			}
			return ret;
		}

		/**
		 * Name of node with the existing server to convert to first member of the cluster.
		 */
		public String getServerNode() {
			return this.serverNode;
		}

		/**
		 * Name of node with the existing server to convert to first member of the cluster.
		 */
		public void setServerNode(String value) {
			this.serverNode = value;
		}

		/**
		 * Name of existing server to convert to first member of the cluster.
		 */
		public String getServerName() {
			return this.serverName;
		}

		/**
		 * Name of existing server to convert to first member of the cluster.
		 */
		public void setServerName(String value) {
			this.serverName = value;
		}

		/**
		 * Weight value of cluster member.
		 */
		public Integer getMemberWeight() {
			return this.memberWeight;
		}

		/**
		 * Weight value of cluster member.
		 */
		public void setMemberWeight(Integer value) {
			this.memberWeight = value;
		}

		/**
		 * Name of node group which all cluster member nodes must belong to.
		 */
		public String getNodeGroup() {
			return this.nodeGroup;
		}

		/**
		 * Name of node group which all cluster member nodes must belong to.
		 */
		public void setNodeGroup(String value) {
			this.nodeGroup = value;
		}

		/**
		 * Enable this member to use data replication service for HTTP session persistence.
		 */
		public Boolean getReplicatorEntry() {
			return this.replicatorEntry;
		}

		/**
		 * Enable this member to use data replication service for HTTP session persistence.
		 */
		public void setReplicatorEntry(Boolean value) {
			this.replicatorEntry = value;
		}

		/**
		 * resourcesScopeDesc
		 */
		public String getResourcesScope() {
			return this.resourcesScope;
		}

		/**
		 * resourcesScopeDesc
		 */
		public void setResourcesScope(String value) {
			this.resourcesScope = value;
		}

		/**
		 * Change the step's target (originally specified in constructor).
		 */
		public void setCommandTarget(Boolean value) {
			this.__target = value;
		}

		public Object __getTarget() {
			return this.__target;
		}

	}
	/**
	 * Specifies the event service configuration of the new server cluster.
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
	 * If a proxy server was specified for convertServer, apply the proxy settings for the contentServer to the cluster.
	 * The required parameters are found in the constructor.
	 */
	public static class PromoteProxyServer extends CommandStep {

		public PromoteProxyServer() {
			super("promoteProxyServer");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
