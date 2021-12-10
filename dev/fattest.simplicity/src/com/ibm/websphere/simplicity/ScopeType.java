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
 * This enum contains valid Scope types. A Scope defines areas of visibility in a WebSphere
 * topology. The CELL scope, being the highest, can see and affect all other scopes in the topology.
 * A NODE scope has visibility to the servers within it. A SERVER Scope is the most limited view,
 * and can only affect settings and other values directly impacting the server itself.
 */
public enum ScopeType {

    CELL,
    NODE,
    SERVER,
    /**
     * A collection of Nodes. This view limits visibility to the nodes that are a part of the node
     * group.
     */
    NODE_GROUP,
    /**
     * A collection of Servers. This view limits visibility to the servers within the cluster.
     */
    CLUSTER,
    /**
     * A specialized {@link #SERVER} that manages a node in an ND topology.
     */
    NODE_AGENT, MANAGED_SERVER,
    /**
     * A specialized {@link #SERVER} that manages a cell in an ND topology.
     */
    DMGR,
    /**
     * A specialized {@link #SERVER} that acts as a central point of administration for otherwise
     * independent BASE application servers
     */
    ADMIN_AGENT,
    /**
     * A specialized {@link #SERVER} that is used to administer an application server in an admin agent topology
     */
    SUB_SYSTEM,
    /**
     * A specialized {@link #SERVER} that is used to manage jobs among cells and servers
     */
    JOB_MANAGER;

}
