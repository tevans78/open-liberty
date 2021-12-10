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

public class CreateProxyServer extends Job {
	
	private static final String NODE_NAME = "nodeName";
	private static final String SERVER_NAME = "serverName";

	/**
	 * Create a proxy server
	 * @param serverName Name of the proxy server to create
	 */
	public CreateProxyServer(String serverName) {
		super(JobType.CreateProxyServer);
		setServerName(serverName);
	}
	
	/**
	 * Create a proxy server
	 * @param serverName Name of the proxy server to create
	 * @param nodeName Name of the node where the proxy server should be created.  This parameter is only required for servers in a Network Deployment topology.
	 */
	public CreateProxyServer(String serverName, String nodeName) {
		super(JobType.CreateProxyServer);
		setServerName(serverName);
		if (nodeName != null)
			setNodeName(nodeName);
	}
	
	/**
	 * Name of the proxy server to create
	 * @return
	 */
	public String getServerName() {
		return getJobParam(SERVER_NAME);
	}
	
	/**
	 * Name of the node where the proxy server should be created.  This parameter is only required for servers in a Network Deployment topology.
	 * @return
	 */
	public String getNodeName() {
		return getJobParam(NODE_NAME);
	}
	
	/**
	 * Name of the proxy server to create
	 * @param value
	 */
	public void setServerName(String value) {
		setJobParam(SERVER_NAME, value);
	}
	
	/**
	 * Name of the node where the proxy server should be created.  This parameter is only required for servers in a Network Deployment topology.
	 * @param value
	 */
	public void setNodeName(String value) {
		if (value != null)
			setJobParam(NODE_NAME, value);
		else
			removeJobParam(NODE_NAME);
	}

}
