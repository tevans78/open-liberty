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

public class DeleteCluster extends Job {
	
	public static final String CLUSTERCONFIG_CLUSTERNAME = "clusterConfig.clusterName";
	public static final String REPLICATION_DOMAIN = "replicationDomain.deleteRepDomain";

	/**
	 * Deletes the configuration of an application server cluster.
	 * @param clusterName Name of server cluster to delete.
	 */
	public DeleteCluster(String clusterName) {
		super(JobType.DeleteCluster);
		setClusterName(clusterName);
	}
	
	/**
	 * Name of server cluster to delete.
	 * @return
	 */
	public String getClusterName() {
		return getJobParam(CLUSTERCONFIG_CLUSTERNAME);
	}
	
	/**
	 * Delete the cluster replication domain when the cluster is deleted.  The default value is false.
	 * @return
	 */
	public String getDeleteReplicationDomain() {
		return getJobParam(REPLICATION_DOMAIN);
	}
	
	/**
	 * Name of server cluster to delete.
	 * @param value
	 */
	public void setClusterName(String value) {
		setJobParam(CLUSTERCONFIG_CLUSTERNAME, value);
	}
	
	/**
	 * Delete the cluster replication domain when the cluster is deleted.  The default value is false.
	 * @param value
	 */
	public void setDeleteReplicationDomain(String value) {
		if (value != null)
			setJobParam(REPLICATION_DOMAIN, value);
		else
			removeJobParam(REPLICATION_DOMAIN);
	}

}
