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

public class StopCluster extends Job {
	
	private static final String CLUSTER_NAME = "clusterName";
	private static final String TIMEOUT = "timeout";
	private static final String RIPPLE_START = "rippleStart";
	
	/**
	 * Stop a server cluster.
	 * @param clusterName Name of the cluster to stop.
	 */
	public StopCluster(String clusterName) {
		super(JobType.StopCluster);
		setClusterName(clusterName);
	}
	
	/**
	 * Name of the cluster to stop.
	 * @return
	 */
	public String getClusterName() {
		return getJobParam(CLUSTER_NAME);
	}
	
	/**
	 * The maximum amount of time in minutes to wait for the cluster to stop before returning the cluster's state.
	 * @return
	 */
	public String getTimeout() {
		return getJobParam(TIMEOUT);
	}
	
	/**
	 * Name of the cluster to stop.
	 * @param value
	 */
	public void setClusterName(String value) {
		setJobParam(CLUSTER_NAME, value);
	}

	/**
	 * The maximum amount of time in minutes to wait for the cluster to stop before returning the cluster's state.
	 * @param value
	 */
	public void setTimeout(String value) {
		if (value != null)
			setJobParam(TIMEOUT, value);
		else
			removeJobParam(TIMEOUT);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getRippleStart() {
		return getJobParam(RIPPLE_START);
	}
	
	/**
	 * TODO
	 * @param value
	 */
	public void setRippleStart(String value) {
		if (value != null)
			setJobParam(RIPPLE_START, value);
		else
			removeJobParam(RIPPLE_START);
	}

}
