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

public class CreateCluster extends Job {
	
	public static final String CLUSTER_NAME = "clusterConfig.clusterName";
	public static final String PREFER_LOCAL = "clusterConfig.preferLocal";
	public static final String CLUSTER_TYPE = "clusterConfig.clusterType";
	public static final String SHORT_NAME = "clusterConfig.shortName";
	public static final String REPLICATION_DOMAIN = "replicationDomain";
	public static final String CREATE_DOMAIN = "replicationDomain.createDomain";
	public static final String CONVERT_SERVER = "convertServer";
	public static final String SERVER_NODE = "convertServer.serverNode";
	public static final String SERVER_NAME = "convertServer.serverName";
	public static final String MEMBER_WEIGHT = "convertServer.memberWeight";
	public static final String NODE_GROUP = "convertServer.nodeGroup";
	public static final String REPLICATOR_ENTRY = "convertServer.replicatorEntry";
	
	private ConvertServer convertServer;
	
	public static class ConvertServer {
		
		private CreateCluster creator;
		
		private ConvertServer(CreateCluster creator) {
			this.creator = creator;
		}
		
		/**
		 * TODO
		 * @return
		 */
		public String getServerName() {
			return creator.getSubParam(CONVERT_SERVER, SERVER_NAME);
		}
		
		/**
		 * TODO
		 * @param value
		 */
		public void setServerName(String value) {
			creator.setSubJobParam(CONVERT_SERVER, SERVER_NAME, value);
		}
		
		/**
		 * TODO
		 * @return
		 */
		public String getNodeName() {
			return creator.getSubParam(CONVERT_SERVER, SERVER_NODE);
		}
		
		/**
		 * TODO
		 * @param value
		 */
		public void setNodeName(String value) {
			creator.setSubJobParam(CONVERT_SERVER, SERVER_NODE, value);
		}
		
		/**
		 * TODO
		 * @return
		 */
		public String getMemberWeight() {
			return creator.getSubParam(CONVERT_SERVER, MEMBER_WEIGHT);
		}
		
		/**
		 * TODO
		 * @param value
		 */
		public void setMemberWeight(String value) {
			creator.setSubJobParam(CONVERT_SERVER, MEMBER_WEIGHT, value);
		}
		
		/**
		 * TODO
		 * @return
		 */
		public String getNodeGroup() {
			return creator.getSubParam(CONVERT_SERVER, NODE_GROUP);
		}
		
		/**
		 * TODO
		 * @param value
		 */
		public void setNodeGroup(String value) {
			creator.setSubJobParam(CONVERT_SERVER, NODE_GROUP, value);
		}
		
		/**
		 * TODO
		 * @return
		 */
		public String getReplicatorEntry() {
			return creator.getSubParam(CONVERT_SERVER, REPLICATOR_ENTRY);
		}
		
		/**
		 * TODO
		 * @param value
		 */
		public void setReplicatorEntry(String value) {
			creator.setSubJobParam(CONVERT_SERVER, REPLICATOR_ENTRY, value);
		}
		
	}

	/**
	 * Creates a new application server cluster.
	 * @param clusterName Name of the server cluster.
	 */
	public CreateCluster(String clusterName) {
		super(JobType.CreateCluster);
		setClusterName(clusterName);
	}
	
	/**
	 * Name of the server cluster.
	 * @return
	 */
	public String getClusterName() {
		return getJobParam(CLUSTER_NAME);
	}
	
	/**
	 * Name of the server cluster.
	 * @param value
	 */
	public void setClusterName(String value) {
		setJobParam(CLUSTER_NAME, value);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getPreferLocal() {
		return getJobParam(PREFER_LOCAL);
	}
	
	/**
	 * TODO
	 * @param value
	 */
	public void setPreferLocal(String value) {
		if (value != null)
			setJobParam(PREFER_LOCAL, value);
		else
			removeJobParam(PREFER_LOCAL);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getClusterType() {
		return getJobParam(CLUSTER_TYPE);
	}
	
	/**
	 * TODO
	 * @param value
	 */
	public void setClusterType(String value) {
		if (value != null)
			setJobParam(CLUSTER_TYPE, value);
		else
			removeJobParam(CLUSTER_TYPE);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getShortName() {
		return getJobParam(SHORT_NAME);
	}
	
	/**
	 * TODO
	 * @param value
	 */
	public void setShortName(String value) {
		if (value != null)
			setJobParam(SHORT_NAME, value);
		else
			removeJobParam(SHORT_NAME);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getCreateReplicationDomain() {
		return getSubParam(REPLICATION_DOMAIN, CREATE_DOMAIN);
	}
	
	/**
	 * TODO
	 * @param value
	 */
	public void setCreateReplicationDomain(String value) {
		if (value != null)
			setSubJobParam(REPLICATION_DOMAIN, CREATE_DOMAIN, value);
		else
			removeSubJobParam(REPLICATION_DOMAIN, CREATE_DOMAIN);
	}
	
	public ConvertServer getConvertServer() {
		if (convertServer == null)
			convertServer = new ConvertServer(this);
		return convertServer;
	}

}
