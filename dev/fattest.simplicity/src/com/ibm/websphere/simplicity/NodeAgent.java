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

import java.util.ArrayList;

import javax.management.AttributeList;

import com.ibm.websphere.simplicity.runtime.NodeAgentMBean;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;

/**
 * This class represents a WebSphere node agent server. This corresponds to the
 * {@link ServerType#NODE_AGENT} server type. Node agents are administrative agents that monitor
 * application servers on a host system and route administrative requests to servers. A node agent
 * is the running server that represents a node in a Network Deployment environment.
 * 
 * @see WebSphereTopologyType#ND
 * @see ApplicationServer
 */
public class NodeAgent extends ApplicationServer {
	
	private NodeAgentMBean mbean;

    /**
     * Constructor
     * 
     * @param configId The {@link ConfigIdentifier} that uniquely identifies this NodeAgent
     * @param cell The {@link Cell} to which this NodeAgent belongs
     * @param node The {@link Node} to which this NodeAgent belongs
     */
	public NodeAgent(ConfigIdentifier configId, Cell cell, Node node, ArrayList<AttributeList> portInitData) throws Exception {
		super(configId, cell, node, ServerType.NODE_AGENT, portInitData);
	}
	
	public boolean start(Server server) throws Exception {
		return getMBean().launchProcess(server);
	}
	
	public ProcessStatus getProcessStatus(Server server) throws Exception {
		return this.getMBean().getProcessStatus(server);
	}
	
	public void terminate(Server server) throws Exception {
		this.getMBean().terminate(server);
	}
	
	private NodeAgentMBean getMBean() throws Exception {
		if (this.mbean == null) {
			this.mbean = new NodeAgentMBean(this);
		}
		return this.mbean;
	}

}
