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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.management.AttributeList;

import com.ibm.websphere.simplicity.commands.GetManagedNodeConnectorProperties;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;



/**
 * This class represents a WebSphere admin agent server. This corresponds to the
 * {@link ServerType#ADMIN_AGENT} server type. An admin agent server is a central administrative
 * point for registered BASE nodes.
 * 
 * @see WebSphereTopologyType#ADMIN_AGENT
 * @see ApplicationServer
 */
public class AdminAgent extends ApplicationServer {
    
    private static final Class c = AdminAgent.class;
    
    protected Map<Node, Map<ConnectorType, Integer>> subSystemPorts = new HashMap<Node, Map<ConnectorType,Integer>>();

   /**
     * Constructor
     * 
     * @param configId The {@link ConfigIdentifier} that uniquely identifies this AdminAgent
     * @param cell The {@link Cell} to which this AdminAgent belongs
     * @param node The {@link Node} to which this AdminAgent belongs
     */
	public AdminAgent(ConfigIdentifier configId, Cell cell, Node node, ArrayList<AttributeList> portInitData) throws Exception {
		super(configId, cell, node, ServerType.ADMIN_AGENT, portInitData);
	}

    public Integer getSubSystemPort(ConnectorType connType, Node registeredNode) throws Exception {
        final String method = "getSubSystemPort";
        Log.entering(c, method, new Object[]{connType, registeredNode});
        
        if(connType == ConnectorType.NONE) {
            throw new Exception("Invalid connType NONE");
        }
        if(registeredNode.getAdminAgent() == null || !registeredNode.getAdminAgent().getCell().equals(this.getCell())) {
            throw new Exception("The Node is not registered to this admin agent.");
        }
        Integer ret = getSubSystemPorts(registeredNode).get(connType);
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Get the subsystem ports for a registered node
     * 
     * @param registeredNode The node to get the corresponding subsystem ports for
     * @return The subsytem ports
     * @throws Exception
     */
    protected Map<ConnectorType, Integer> getSubSystemPorts(Node registeredNode) throws Exception {
        final String method = "getSubSystemPorts";
        Log.entering(c, method, registeredNode);
        Map<ConnectorType, Integer> ports = null;
        if(this.subSystemPorts.get(registeredNode) == null) {
            ports = new HashMap<ConnectorType, Integer>();
            ConnectorType[] connTypes = ConnectorType.values();
            Properties p = null;
            int port = -1;
            for(int i = 0; i < connTypes.length; ++i) {
                if(connTypes[i] != ConnectorType.NONE) {
                    Log.finer(c, method, "Getting sub system port for connType " + connTypes[i]);
                    GetManagedNodeConnectorProperties task = new GetManagedNodeConnectorProperties(connTypes[i].toString());
                    task.setManagedNodeName(registeredNode.getName());
                    Object result = task.run(this).getResult();
                    p = OperationsProviderFactory.getProvider().getCellOperationsProvider().getManagedNodeConnectorProperties(result);
                    port = Integer.parseInt((String)p.getProperty("port"));
                    ports.put(connTypes[i], port);
                }
            }
            this.subSystemPorts.put(registeredNode, ports);
        } else {
            ports = this.subSystemPorts.get(registeredNode);
        }
        Log.exiting(c, method, ports);
        return ports;
    }
}
