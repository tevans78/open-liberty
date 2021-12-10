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
 * Represents a WebSphere topology type
 */
public enum WebSphereTopologyType {
    /**
     * A BASE topology typically consists of a single application server. The server is administered
     * individually and has no knowledge of other WebSphere cells or servers.
     */
	BASE,
    /**
     * An ADMING_AGENT topology typically consists of serveral BASE nodes registered to an admin
     * agent node. The admin agent acts as a single point of administration for the otherwise
     * unrelated BASE nodes.
     */
	ADMIN_AGENT,
    /**
     * An ND topology typically consists of a deployment manager and several managed nodes. The
     * deployment manager is a single point of administration for all the nodes and servers in the
     * cell.
     */
	ND,
    /**
     * A FLEX topology typically consists of a job manager and several registered deployment manager
     * nodes and admin agent registerd BASE nodes. The job manager allows the user to submit,
     * schedule, and track jobs to the registered entites.
     */
	FLEX;
	
    /**
     * Get a corresponding {@link ServerType} for the manager server in this topology type.
     * 
     * @return The {@link ServerType} for the manager in this topology type
     * @throws Exception
     */
	public ServerType toWebSphereEndpointType() throws Exception {
		switch(this) {
			case ADMIN_AGENT: return ServerType.ADMIN_AGENT;
			case BASE: return ServerType.APPLICATION_SERVER;
			case FLEX: return ServerType.JOB_MANAGER;
			case ND: return ServerType.DEPLOYMENT_MANAGER;
			default: throw new Exception("Unable to determine endpoint type from topology type: "+this.name());
		}
	}
}
