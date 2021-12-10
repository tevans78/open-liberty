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

/*
 * Done
 */
public class UpdateApplication extends Job {

	private static final String APPLICATION_NAME = "applicationName";
	private static final String SERVER_NAME = "serverName";
	private static final String APPLOCATION = "appLocation";
	private static final String NODE_NAME = "nodeName";
	private static final String CLUSTER_NAME = "clusterName";

	public UpdateApplication(String applicationName) {
		super(JobType.UpdateApplication);
		setApplicationName(applicationName);
	}
	
	/**
	 * Name of the application to update.
	 * @return
	 */
	public String getApplicationName() {
		return getJobParam(APPLICATION_NAME);
	}
	
	/**
	 * Name of the server where the application will run.
	 * @return
	 */
	public String getServerName() {
		return getJobParam(SERVER_NAME);
	}
	
	/**
	 * Location of application file.  This will be the destination that was given when the file was distributed to the node.  If not provided, the location is assumed to be the application name with a ".ear" extension.
	 * @return
	 */
	public String getAppLocation() {
		return getJobParam(APPLOCATION);
	}
	
	/**
	 * Name of the node the server is located on.  This parameter is only required for servers in a Network Deployment topology.
	 * @return
	 */
	public String getNodeName() {
		return getJobParam(NODE_NAME);
	}
	
	/**
	 * Name of the cluster where the application will run.  This parameter is only valid in a Network Deployment topology.
	 * @return
	 */
	public String getClusterName() {
		return getJobParam(CLUSTER_NAME);
	}
	
	/**
	 * Name of the application to update.
	 * @param value
	 */
	public void setApplicationName(String value) {
		setJobParam(APPLICATION_NAME, value);
	}
	
	/**
	 * Name of the server where the application will run.
	 * @param value
	 */
	public void setServerName(String value) {
		if (value != null)
			setJobParam(SERVER_NAME, value);
		else
			removeJobParam(SERVER_NAME);
	}
	
	/**
	 * Location of application file.  This will be the destination that was given when the file was distributed to the node.  If not provided, the location is assumed to be the application name with a ".ear" extension.
	 * @param value
	 */
	public void setAppLocation(String value) {
		if (value != null)
			setJobParam(APPLOCATION, value);
		else
			removeJobParam(APPLOCATION);
	}
	
	/**
	 * Name of the node the server is located on.  This parameter is only required for servers in a Network Deployment topology.
	 * @param value
	 */
	public void setNodeName(String value) {
		if (value != null)
			setJobParam(NODE_NAME, value);
		else
			removeJobParam(NODE_NAME);
	}
	
	/**
	 * Name of the cluster where the application will run.  This parameter is only valid in a Network Deployment topology.
	 * @param value
	 */
	public void setClusterName(String value) {
		if (value != null)
			setJobParam(CLUSTER_NAME, value);
		else
			removeJobParam(CLUSTER_NAME);
	}
	
}
