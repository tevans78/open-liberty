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

package com.ibm.websphere.simplicity.jobmanager.job;

import com.ibm.websphere.simplicity.jobmanager.Job;
import com.ibm.websphere.simplicity.jobmanager.JobType;

public class CreateClusterMember extends Job {
	
	public static final String MEMBER_NAME = "memberConfig.memberName";
	public static final String MEMBER_NODE_NAME = "memberConfig.memberNode";
	public static final String CLUSTER_NAME = "clusterName";
	public static final String MEMBER_WEIGHT = "memberConfig.memberWeight";
	public static final String MEMBER_UUID = "memberConfig.memberUUID";
	public static final String GEN_UNIQUE_PORTS = "memberConfig.genUniquePorts";
	public static final String REPLICATOR_ENTRY = "memberConfig.replicatorEntry";
	public static final String SPECIFIC_SHORT_NAME = "memberConfig.specificShortName";
	public static final String FIRST_MEMBER = "firstMember";
	public static final String FIRST_TEMPLATE_NAME = "firstMember.templateName";
	public static final String FIRST_TEMPLATE_SERVER_NODE = "firstMember.templateServerNode";
	public static final String FIRST_TEMPLATE_SERVER_NAME = "firstMember.templateServerName";
	public static final String FIRST_NODE_GROUP	= "firstMember.nodeGroup";
	public static final String FIRST_CORE_GROUP = "firstMember.coreGroup";
	
	private FirstMember firstMember;
	
	public static class FirstMember {
		private CreateClusterMember member;
		
		private FirstMember(CreateClusterMember member) {
			this.member = member;
		}
		
		public String getTemplateName() {
			return member.getSubParam(FIRST_MEMBER, FIRST_TEMPLATE_NAME);
		}
		
		public void setTemplateName(String value) {
			if (value != null)
				member.setSubJobParam(FIRST_MEMBER, FIRST_TEMPLATE_NAME, value);
			else
				member.removeSubJobParam(FIRST_MEMBER, FIRST_TEMPLATE_NAME);
		}
		
		public String getTemplateServerName() {
			return member.getSubParam(FIRST_MEMBER, FIRST_TEMPLATE_SERVER_NAME);
		}
		
		public void setTemplateServerName(String value) {
			if (value != null)
				member.setSubJobParam(FIRST_MEMBER, FIRST_TEMPLATE_SERVER_NAME, value);
			else
				member.removeSubJobParam(FIRST_MEMBER, FIRST_TEMPLATE_SERVER_NAME);
		}
		
		public String getTemplateServerNode() {
			return member.getSubParam(FIRST_MEMBER, FIRST_TEMPLATE_SERVER_NODE);
		}
		
		public void setTemplateServerNode(String value) {
			if (value != null)
				member.setSubJobParam(FIRST_MEMBER, FIRST_TEMPLATE_SERVER_NODE, value);
			else
				member.removeSubJobParam(FIRST_MEMBER, FIRST_TEMPLATE_SERVER_NODE);
		}
		
		public String getNodeGroup() {
			return member.getSubParam(FIRST_MEMBER, FIRST_NODE_GROUP);
		}
		
		public void setNodeGroup(String value) {
			if (value != null)
				member.setSubJobParam(FIRST_MEMBER, FIRST_NODE_GROUP, value);
			else
				member.removeSubJobParam(FIRST_MEMBER, FIRST_NODE_GROUP);
		}
		
		public String getCoreGroup() {
			return member.getSubParam(FIRST_MEMBER, FIRST_CORE_GROUP);
		}
		
		public void setCoreGroup(String value) {
			if (value != null)
				member.setSubJobParam(FIRST_MEMBER, FIRST_CORE_GROUP, value);
			else
				member.removeSubJobParam(FIRST_MEMBER, FIRST_CORE_GROUP);
		}
		
	}

	/**
	 * Creates a new member of an application server cluster.
	 * @param clusterName Name of the server cluster which the new cluster member will belong to.
	 * @param nodeName Name of the node where the new cluster member will reside.
	 * @param memberName Name of the new cluster member. 
	 */
	public CreateClusterMember(String clusterName, String nodeName, String memberName) {
		super(JobType.CreateClusterMember);
		setClusterName(clusterName);
		setNodeName(nodeName);
		setMemberName(memberName);
	}
	
	/**
	 * Name of the server cluster which the new cluster member will belong to.
	 * @return
	 */
	public String getClusterName() {
		return getJobParam(CLUSTER_NAME);
	}
	
	/**
	 * Name of the server cluster which the new cluster member will belong to.
	 * @param value
	 */
	public void setClusterName(String value) {
		setJobParam(CLUSTER_NAME, value);
	}

	/**
	 * Name of the node where the new cluster member will reside.
	 * @return
	 */
	public String getNodeName() {
		return getJobParam(MEMBER_NODE_NAME);
	}
	
	/**
	 * Name of the node where the new cluster member will reside.
	 * @param value
	 */
	public void setNodeName(String value) {
		setJobParam(MEMBER_NODE_NAME, value);
	}

	/**
	 * Name of the new cluster member.
	 * @return
	 */
	public String getMemberName() {
		return getJobParam(MEMBER_NAME);
	}
	
	/**
	 * Name of the new cluster member.
	 * @param value
	 */
	public void setMemberName(String value) {
		setJobParam(MEMBER_NAME, value);
	}
	
	/**
	 * Weight of the new cluster member.
	 * @return
	 */
	public String getMemberWeight() {
		return getJobParam(MEMBER_WEIGHT);
	}
	
	/**
	 * Weight of the new cluster member.
	 * @param value
	 */
	public void setMemberWeight(String value) {
		if (value != null)
			setJobParam(MEMBER_WEIGHT, value);
		else
			removeJobParam(MEMBER_WEIGHT);
	}
	
	/**
	 * UUID of the new cluster member.
	 * @return
	 */
	public String getMemberUuid() {
		return getJobParam(MEMBER_UUID);
	}
	
	/**
	 * UUID of the new cluster member.
	 * @param value
	 */
	public void setMemberUuid(String value) {
		if (value != null)
			setJobParam(MEMBER_UUID, value);
		else
			removeJobParam(MEMBER_UUID);
	}
	
	/**
	 * Whether to generate unique ports for the cluster member.
	 * @return
	 */
	public String getGenUniquePorts() {
		return getJobParam(GEN_UNIQUE_PORTS);
	}
	
	/**
	 * Whether to generate unique ports for the cluster member.
	 * @param value
	 */
	public void setGenUniquePorts(String value) {
		if (value != null)
			setJobParam(GEN_UNIQUE_PORTS, value);
		else
			removeJobParam(GEN_UNIQUE_PORTS);
	}
	
	/**
	 * TODO
	 * @return
	 */
	public String getReplicatorEntry() {
		return getJobParam(REPLICATOR_ENTRY);
	}
	
	/**
	 * TODO
	 * @param value
	 */
	public void setReplicatorEntry(String value) {
		if (value != null)
			setJobParam(REPLICATOR_ENTRY, value);
		else
			removeJobParam(REPLICATOR_ENTRY);
	}
	
	/**
	 * The shortname of the new cluster member.
	 * @return
	 */
	public String getShortName() {
		return getJobParam(SPECIFIC_SHORT_NAME);
	}
	
	/**
	 * The shortname of the new cluster member.
	 * @param value
	 */
	public void setShortName(String value) {
		if (value != null)
			setJobParam(SPECIFIC_SHORT_NAME, value);
		else
			removeJobParam(SPECIFIC_SHORT_NAME);
	}
	
	public FirstMember getFirstMember() {
		if (firstMember == null)
			firstMember = new FirstMember(this);
		return firstMember;
	}
	
}
