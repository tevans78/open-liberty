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

public class CreateApplicationServer extends Job {
	
	private static final String NODE_NAME = "nodeName";
	private static final String SERVER_NAME = "serverName";
	private static final String SERVER_TEMPLATE = "serverTemplate";
	private static final String TEMPLATE_NAME = "templateName";
	private static final String TEMPLATE_LOCATION = "templateLocation";
	private static final String PORT_CONTROL = "portControl";
	private static final String GEN_UNIQUE_PORTS = "genUniquePorts";
	private static final String ZOS_SPECIFIC = "zosSpecific";
	private static final String SPECIFIC_SHORT_NAME = "specificShortName";
	private static final String GENERIC_SHORT_NAME = "genericShortName";
	private static final String BIT_MODE = "bitmode";

	/**
	 * Create an application server.
	 * @param serverName Name of the server to create.
	 */
	public CreateApplicationServer(String serverName) {
		super(JobType.CreateApplicationServer);
		setServerName(serverName);
	}
	
	/**
	 * Create an application server.
	 * @param serverName Name of the server to create.
	 * @param nodeName Name of the node the server is located on.  This parameter is only required for servers in a Network Deployment topology.
	 */
	public CreateApplicationServer(String serverName, String nodeName) {
		super(JobType.CreateApplicationServer);
		setServerName(serverName);
		if (nodeName != null)
			setNodeName(nodeName);
	}
	
	/**
	 * Name of the server to create.
	 * @return
	 */
	public String getServerName() {
		return getJobParam(SERVER_NAME);
	}
	
	/**
	 * Name of the node the server is located on.  This parameter is only required for servers in a Network Deployment topology.
	 * @return
	 */
	public String getNodeName() {
		return getJobParam(NODE_NAME);
	}
	
	/**
	 * Name of the server to create.
	 * @param value
	 */
	public void setServerName(String value) {
		setJobParam(SERVER_NAME, value);
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
	 * TODO
	 * @return
	 */
	public String getTemplateName() {
		return getSubParam(SERVER_TEMPLATE, TEMPLATE_NAME);
	}

	/**
	 * TODO
	 * @param value
	 */
	public void setTemplateName(String value) {
		if (value != null)
			setSubJobParam(SERVER_TEMPLATE, TEMPLATE_NAME, value);
		else
			removeSubJobParam(SERVER_TEMPLATE, TEMPLATE_NAME);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getTemplateLocation() {
		return getSubParam(SERVER_TEMPLATE, TEMPLATE_LOCATION);
	}

	/**
	 * TODO
	 * @param value
	 */
	public void setTemplateLocation(String value) {
		if (value != null)
			setSubJobParam(SERVER_TEMPLATE, TEMPLATE_LOCATION, value);
		else
			removeSubJobParam(SERVER_TEMPLATE, TEMPLATE_LOCATION);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getGenUniquePorts() {
		return getSubParam(PORT_CONTROL, GEN_UNIQUE_PORTS);
	}

	/**
	 * TODO
	 * @param value
	 */
	public void setGenUniquePorts(String value) {
		if (value != null)
			setSubJobParam(PORT_CONTROL, GEN_UNIQUE_PORTS, value);
		else
			removeSubJobParam(PORT_CONTROL, GEN_UNIQUE_PORTS);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getSpecificShortName() {
		return getSubParam(ZOS_SPECIFIC, SPECIFIC_SHORT_NAME);
	}

	/**
	 * TODO
	 * @param value
	 */
	public void setSpecificShortName(String value) {
		if (value != null)
			setSubJobParam(ZOS_SPECIFIC, SPECIFIC_SHORT_NAME, value);
		else
			removeSubJobParam(ZOS_SPECIFIC, SPECIFIC_SHORT_NAME);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getGenericShortName() {
		return getSubParam(ZOS_SPECIFIC, GENERIC_SHORT_NAME);
	}

	/**
	 * TODO
	 * @param value
	 */
	public void setGenericShortName(String value) {
		if (value != null)
			setSubJobParam(ZOS_SPECIFIC, GENERIC_SHORT_NAME, value);
		else
			removeSubJobParam(ZOS_SPECIFIC, GENERIC_SHORT_NAME);
	}

	/**
	 * TODO
	 * @return
	 */
	public String getBitMode() {
		return getSubParam(ZOS_SPECIFIC, BIT_MODE);
	}

	/**
	 * TODO
	 * @param value
	 */
	public void setBitMode(String value) {
		if (value != null)
			setSubJobParam(ZOS_SPECIFIC, BIT_MODE, value);
		else
			removeSubJobParam(ZOS_SPECIFIC, BIT_MODE);
	}

}
