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

public class DeleteClusterMember extends Job {
	
	public static final String MEMBER_NAME = "memberConfig.memberName";
	public static final String MEMBER_NODE_NAME = "memberConfig.memberNode";
	public static final String CLUSTER_NAME = "clusterName";
	public static final String REPLICATION_DELETE_ENTRY = "replicatorEntry.deleteEntry";

	/**
	 * Deletes a member from an application server cluster.
	 * @param clusterName Name of the server cluster which the cluster member to be deleted belongs to.
	 * @param nodeName Name of the node where the cluster member resides.
	 * @param memberName Server name of the cluster member to be deleted.
	 */
	public DeleteClusterMember(String clusterName, String nodeName, String memberName) {
		super(JobType.DeleteClusterMember);
		setClusterName(clusterName);
		setNodeName(nodeName);
		setMemberName(memberName);
	}
	
	/**
	 * Name of the server cluster which the cluster member to be deleted belongs to.
	 * @return
	 */
	public String getClusterName() {
		return getJobParam(CLUSTER_NAME);
	}
	
	/**
	 * Name of the server cluster which the cluster member to be deleted belongs to.
	 * @param value
	 */
	public void setClusterName(String value) {
		setJobParam(CLUSTER_NAME, value);
	}

	/**
	 * Name of the node where the cluster member resides.
	 * @return
	 */
	public String getNodeName() {
		return getJobParam(MEMBER_NODE_NAME);
	}
	
	/**
	 * Name of the node where the cluster member resides.
	 * @param value
	 */
	public void setNodeName(String value) {
		setJobParam(MEMBER_NODE_NAME, value);
	}

	/**
	 * Server name of the cluster member to be deleted.
	 * @return
	 */
	public String getMemberName() {
		return getJobParam(MEMBER_NAME);
	}
	
	/**
	 * Server name of the cluster member to be deleted.
	 * @param value
	 */
	public void setMemberName(String value) {
		setJobParam(MEMBER_NAME, value);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getDeleteReplicationEntry() {
		return getJobParam(REPLICATION_DELETE_ENTRY);
	}
	
	/**
	 * TODO
	 * @param value
	 */
	public void setDeleteReplicationEntry(String value) {
		if (value != null)
			setJobParam(REPLICATION_DELETE_ENTRY, value);
		else
			removeJobParam(REPLICATION_DELETE_ENTRY);
	}

}
