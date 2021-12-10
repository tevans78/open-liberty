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

package com.ibm.websphere.simplicity;

/**
 * Represents a WebSphere application server type. All servers in WebSphere are technically
 * "application servers," however, specialzied servers have functionality to do things such as
 * manage a WebSphere cell or node.
 */
public enum ServerType {
	ADMIN_AGENT("ADMIN_AGENT"),
	ADMIN_AGENT_SUB_SYSTEM(null),			// subsystems are not servers, so have no type key
	DEPLOYMENT_MANAGER("DEPLOYMENT_MANAGER"),
	JOB_MANAGER("JOB_MANAGER"),
	NODE_AGENT("NODE_AGENT"),
	APPLICATION_SERVER("APPLICATION_SERVER"),
	PROXY_SERVER("PROXY_SERVER"),
	WEB_SERVER("WEB_SERVER"),
	GENERIC_SERVER("GENERIC_SERVER");
	
	// Corresponds to the "serverType" attribute in serverindex.xml
	private String serverTypeKey;
	
	private ServerType(String serverTypeKey) {
		this.serverTypeKey = serverTypeKey;
	}
	
	/**
     * @param serverType A string corresponding to the "serverType" attribute from a serverindex.xml
     *            file.
     * @return The endpoint type corresponding to the supplied server type key. Note that
     *         "APPLICATION_SERVER" will return the base "server" type, which is expected behavior.
     */
	public ServerType fromServerTypeKey(String serverType) {
		for (ServerType type : ServerType.values())
			if (type.getServerTypeKey().equalsIgnoreCase(serverType))
				return type;
		return null;
	}
	
	public String getServerTypeKey() {
		return this.serverTypeKey;
	}

	/**
	 * @return A string matching the expected "type" attribute in a server's ObjectName of the current endpoint type.
	 * @throws Exception
	 */
	public String toProcessType() throws Exception {
		switch(this) {
			case ADMIN_AGENT: return "AdminAgent";
			case ADMIN_AGENT_SUB_SYSTEM: return "AdminAgent";
			case DEPLOYMENT_MANAGER: return "DeploymentManager";
			case JOB_MANAGER: return "JobManager";
			case NODE_AGENT: return "NodeAgent";
			case APPLICATION_SERVER: return "UnManagedProcess";
//			case ManagedServer: return "ManagedProcess";
		}
		throw new Exception("Unknown endpoint-to-process-type conversion: "+this.name());
	}

	/**
	 * @return A topology type corresponding to the type of topology in which the endpoint type would be expected.
	 * @throws Exception
	 */
	public WebSphereTopologyType toTopologyType() throws Exception {
		switch(this) {
			case ADMIN_AGENT: return WebSphereTopologyType.ADMIN_AGENT;
			case ADMIN_AGENT_SUB_SYSTEM: return WebSphereTopologyType.ADMIN_AGENT;
			case DEPLOYMENT_MANAGER: return WebSphereTopologyType.ND;
			case JOB_MANAGER: return WebSphereTopologyType.FLEX;
			case NODE_AGENT: return WebSphereTopologyType.ND;
			case APPLICATION_SERVER: return WebSphereTopologyType.BASE;
//			case ManagedServer: return WebSphereTopologyType.ND;
		}
		throw new Exception("Unknown endpoint-to-topology-type conversion: "+this.name());
	}
}
