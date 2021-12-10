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

package com.ibm.websphere.simplicity.cluster;

import com.ibm.websphere.simplicity.NodeGroup;
import com.ibm.websphere.simplicity.Server;

/**
 * ConvertServer options for creating a cluster
 */
public class ConvertServer {

    private Server server;
    private int memberWeight = 2;
    private NodeGroup nodeGroup;
    private boolean replicatorEntry = false;
    
    /**
     * The weight of the cluster member. The weight controls the amount of work directed to the
     * application server. If the weight is greater than the weight assigned to other cluster
     * members, the server will receive a larger share of the workload. The value is a number
     * between 0 and 100. If none is specified, the default is 2.
     * 
     * @return The member weight
     */
    public int getMemberWeight() {
        return memberWeight;
    }
    /**
     * The weight of the cluster member. The weight controls the amount of work directed to the
     * application server. If the weight is greater than the weight assigned to other cluster
     * members, the server will receive a larger share of the workload. The value is a number
     * between 0 and 100. If none is specified, the default is 2.
     * 
     * @param memberWeight The member weight to set
     */
    public void setMemberWeight(int memberWeight) {
        if(memberWeight < 0 || memberWeight > 100) {
            throw new IllegalArgumentException("memberWeight must be between 0 and 100 inclusive.");
        }
        this.memberWeight = memberWeight;
    }
    /**
     * The name of the node group which this cluster member's node, and all future cluster members'
     * nodes, must belong to. All cluster members must reside on nodes in the same node group. If
     * specified, it must be one of the node groups which this member's node belongs to. If not
     * specified, the default value will be the first node group listed for this member's node.
     * 
     * @return The node group
     */
    public NodeGroup getNodeGroup() {
        return nodeGroup;
    }
    /**
     * The name of the node group which this cluster member's node, and all future cluster members'
     * nodes, must belong to. All cluster members must reside on nodes in the same node group. If
     * specified, it must be one of the node groups which this member's node belongs to. If not
     * specified, the default value will be the first node group listed for this member's node.
     * 
     * @param nodeGroup The node group to set
     */
    public void setNodeGroup(NodeGroup nodeGroup) {
        this.nodeGroup = nodeGroup;
    }
    /**
     * Specifies whether to enable HTTP session data replication. The default value is false.
     * Specify true to enable HTTP session data replication. You must specify this parameter if the
     * createDomain parameter was set to true in the replicationDomain command step.
     * 
     * @return true if data replication is enabled
     */
    public boolean getReplicatorEntry() {
        return replicatorEntry;
    }
    /**
     * Specifies whether to enable HTTP session data replication. The default value is false.
     * Specify true to enable HTTP session data replication. You must specify this parameter if the
     * createDomain parameter was set to true in the replicationDomain command step.
     * 
     * @param replicatorEntry true to enable data replication
     */
    public void setReplicatorEntry(boolean replicatorEntry) {
        this.replicatorEntry = replicatorEntry;
    }
    /**
     * The {@link Server} to be converted to the first cluster member
     * 
     * @return The first {@link Server} to be converted
     */
    public Server getServer() {
        return server;
    }
    /**
     * The {@link Server} to be converted to the first cluster member
     * 
     * @param server The first {@link Server} to be converted
     */
    public void setServer(Server server) {
        this.server = server;
    }
    
}
