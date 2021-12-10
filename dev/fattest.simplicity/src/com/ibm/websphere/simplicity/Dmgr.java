/*******************************************************************************
 * Copyright (c) 2011, 2022 IBM Corporation and others.
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

/**
 * This class represents a WebSphere deployment manager server. This corresponds to the
 * {@link ServerType#DEPLOYMENT_MANAGER} server type. The deployment manager administers multiple
 * WebSphere nodes in an ND topology.
 *
 * @see WebSphereTopologyType#ND
 * @see ApplicationServer
 */
public class Dmgr extends ApplicationServer {

    /**
     * Constructor
     *
     * @param configId The {@link ConfigIdentifier} that uniquely identifies this Dmgr
     * @param cell     The {@link Cell} to which this Dmgr belongs
     * @param node     The {@link Node} to which this Dmgr belongs
     */
    public Dmgr(ConfigIdentifier configId, Cell cell, Node node, ArrayList<AttributeList> portInitData) throws Exception {
        super(configId, cell, node, ServerType.DEPLOYMENT_MANAGER, portInitData);
    }

    /**
     * The dmgr stores the primary configuration for all nodes. This API
     * returns a path to the node's primary configuration under the dmgr.
     *
     * @param node The node whose configuration path will be returned.
     * @return The path
     * @exception Thrown if the node does not exist in the cell.
     */
    public String getConfigPath(Node node) throws Exception {
        if (!this.getCell().getNodes().contains(node))
            throw new Exception("The specified node (" + node.getName() + ") does not exist in the cell (" + this.getCellName() + ").");
        String ret = this.getNode().getConfigPath();
        return ret.replace("nodes/" + this.getNodeName(), "nodes/" + node.getName());
    }

    /**
     * The dmgr stores the primary configuration for all nodes. This API
     * returns a path to the server's primary configuration under the dmgr.
     *
     * @param server The server whose configuration path will be returned.
     * @return The path
     * @exception Thrown if the server does not exist in the cell.
     */
    public String getConfigPath(Server server) throws Exception {
        if (!this.getCell().getServers().contains(server))
            throw new Exception("The specified server (" + server.getName() + ") does not exist in the cell (" + this.getCellName() + ").");
        String ret = this.getNode().getConfigPath();
        ret = ret.replace("nodes/" + this.getNodeName(), "nodes/" + server.getNodeName());
        return ret + "/servers/" + server.getName();
    }

}
