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
 * Creates a new member of an application server cluster.
 *   'clusterName': Name of server cluster which the new cluster member will belong to.
 * The required parameters are found in the constructor.
 */
public class CreateClusterMember extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	private String clusterName;

	public CreateClusterMember(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("createClusterMember");
		this.__target = commandTarget;
	}

	/**
	 * Name of server cluster which the new cluster member will belong to.
	 */
	public String getClusterName() {
		return this.clusterName;
	}

	/**
	 * Name of server cluster which the new cluster member will belong to.
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
	public OperationResults<Object> run(Scope scope, MemberConfig memberConfig, FirstMember firstMember, EventServiceConfig eventServiceConfig, PromoteProxyServer promoteProxyServer) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (memberConfig != null)
			this.__steps.add(memberConfig);
		if (firstMember != null)
			this.__steps.add(firstMember);
		if (eventServiceConfig != null)
			this.__steps.add(eventServiceConfig);
		if (promoteProxyServer != null)
			this.__steps.add(promoteProxyServer);
		return super.run(scope);
	}

	/**
	 * Specifies the configuration of a new member of the cluster.
	 *   'memberNode': Name of node which the new cluster member will belong to.
	 *   'memberName': Name of new cluster member.
	 *   'memberWeight': Weight value of new cluster member.
	 *   'memberUUID': UUID of new cluster member.
	 *   'genUniquePorts': Generates unique port numbers for HTTP transports defined in the server.
	 *   'replicatorEntry': Enable this member to use data replication service for HTTP session persistence.
	 *   'specificShortName': Specific Short name of cluster member for zOS platforms.
	 * The required parameters are found in the constructor.
	 */
	public static class MemberConfig extends CommandStep {

		private String memberNode;
		private String memberName;
		private Integer memberWeight;
		private String memberUUID;
		private Boolean genUniquePorts = true;
		private Boolean replicatorEntry = false;
		private String specificShortName;

		public MemberConfig(String memberNode, String memberName) {
			super("memberConfig");
			this.memberNode = memberNode;
			this.memberName = memberName;
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			ret.put("memberNode", this.memberNode);
			ret.put("memberName", this.memberName);
			if (this.memberWeight != null) {
				ret.put("memberWeight", this.memberWeight);
			}
			if (this.memberUUID != null) {
				ret.put("memberUUID", this.memberUUID);
			}
			if (this.genUniquePorts != null) {
				ret.put("genUniquePorts", this.genUniquePorts);
			}
			if (this.replicatorEntry != null) {
				ret.put("replicatorEntry", this.replicatorEntry);
			}
			if (this.specificShortName != null) {
				ret.put("specificShortName", this.specificShortName);
			}
			return ret;
		}

		/**
		 * Name of node which the new cluster member will belong to.
		 */
		public String getMemberNode() {
			return this.memberNode;
		}

		/**
		 * Name of node which the new cluster member will belong to.
		 */
		public void setMemberNode(String value) {
			this.memberNode = value;
		}

		/**
		 * Name of new cluster member.
		 */
		public String getMemberName() {
			return this.memberName;
		}

		/**
		 * Name of new cluster member.
		 */
		public void setMemberName(String value) {
			this.memberName = value;
		}

		/**
		 * Weight value of new cluster member.
		 */
		public Integer getMemberWeight() {
			return this.memberWeight;
		}

		/**
		 * Weight value of new cluster member.
		 */
		public void setMemberWeight(Integer value) {
			this.memberWeight = value;
		}

		/**
		 * UUID of new cluster member.
		 */
		public String getMemberUUID() {
			return this.memberUUID;
		}

		/**
		 * UUID of new cluster member.
		 */
		public void setMemberUUID(String value) {
			this.memberUUID = value;
		}

		/**
		 * Generates unique port numbers for HTTP transports defined in the server.
		 */
		public Boolean getGenUniquePorts() {
			return this.genUniquePorts;
		}

		/**
		 * Generates unique port numbers for HTTP transports defined in the server.
		 */
		public void setGenUniquePorts(Boolean value) {
			this.genUniquePorts = value;
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
		 * Specific Short name of cluster member for zOS platforms.
		 */
		public String getSpecificShortName() {
			return this.specificShortName;
		}

		/**
		 * Specific Short name of cluster member for zOS platforms.
		 */
		public void setSpecificShortName(String value) {
			this.specificShortName = value;
		}

	}
	/**
	 * Specifies additional information required to configure the first member of a cluster.
	 *   'templateName': Name of server template to use as model for new cluster member.
	 *   'templateServerNode': Name of node with existing server to use as template for new cluster members.
	 *   'templateServerName': Name of server to use as template for new cluster member.
	 *   'nodeGroup': Name of node group which all cluster member nodes must belong to.
	 *   'coreGroup': Name of core group which all cluster members must belong to.
	 *   'resourcesScope': resourcesScopeDesc
	 * The required parameters are found in the constructor.
	 */
	public static class FirstMember extends CommandStep {

		private String templateName;
		private String templateServerNode;
		private String templateServerName;
		private String nodeGroup;
		private String coreGroup;
		private String resourcesScope = "both";

		public FirstMember() {
			super("firstMember");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			if (this.templateName != null) {
				ret.put("templateName", this.templateName);
			}
			if (this.templateServerNode != null) {
				ret.put("templateServerNode", this.templateServerNode);
			}
			if (this.templateServerName != null) {
				ret.put("templateServerName", this.templateServerName);
			}
			if (this.nodeGroup != null) {
				ret.put("nodeGroup", this.nodeGroup);
			}
			if (this.coreGroup != null) {
				ret.put("coreGroup", this.coreGroup);
			}
			if (this.resourcesScope != null) {
				ret.put("resourcesScope", this.resourcesScope);
			}
			return ret;
		}

		/**
		 * Name of server template to use as model for new cluster member.
		 */
		public String getTemplateName() {
			return this.templateName;
		}

		/**
		 * Name of server template to use as model for new cluster member.
		 */
		public void setTemplateName(String value) {
			this.templateName = value;
		}

		/**
		 * Name of node with existing server to use as template for new cluster members.
		 */
		public String getTemplateServerNode() {
			return this.templateServerNode;
		}

		/**
		 * Name of node with existing server to use as template for new cluster members.
		 */
		public void setTemplateServerNode(String value) {
			this.templateServerNode = value;
		}

		/**
		 * Name of server to use as template for new cluster member.
		 */
		public String getTemplateServerName() {
			return this.templateServerName;
		}

		/**
		 * Name of server to use as template for new cluster member.
		 */
		public void setTemplateServerName(String value) {
			this.templateServerName = value;
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
		 * Name of core group which all cluster members must belong to.
		 */
		public String getCoreGroup() {
			return this.coreGroup;
		}

		/**
		 * Name of core group which all cluster members must belong to.
		 */
		public void setCoreGroup(String value) {
			this.coreGroup = value;
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

	}
	/**
	 * Specifies the event service configuration of a new member of the cluster.
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
	 * If a proxy server was specified and no other servers exist in the cluster, apply the proxy settings to the cluster.
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
