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

import com.ibm.websphere.simplicity.Node;

/**
 * MemberConfig options for creating a cluster member
 */
public class MemberConfig {

    private Node memberNode;
    private String memberName;
    private int memberWeight = 2;
    private String memberUUID;
    private boolean genUniquePorts = true;
    private boolean replicatorEntry = false;
    
    /**
     * Optionally specifies whether the system generates unique port numbers for each HTTP transport
     * defined in the server. The new server will not have HTTP transports which conflict with any
     * other servers defined on the same node. The default value is true. If you do not want to
     * generate unique port numbers, specify the value as false.
     * 
     * @return the genUniquePorts setting
     */
    public boolean getGenUniquePorts() {
        return genUniquePorts;
    }
    /**
     * Optionally specifies whether the system generates unique port numbers for each HTTP transport
     * defined in the server. The new server will not have HTTP transports which conflict with any
     * other servers defined on the same node. The default value is true. If you do not want to
     * generate unique port numbers, specify the value as false.
     * 
     * @param genUniquePorts Whether or not unique HTTP transport port numbers should be generated
     */
    public void setGenUniquePorts(boolean genUniquePorts) {
        this.genUniquePorts = genUniquePorts;
    }
    /**
     * Specifies the name of the new cluster member.
     * 
     * @return The member name
     */
    public String getMemberName() {
        return memberName;
    }
    /**
     * Specifies the name of the new cluster member.
     * 
     * @param memberName The member name to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    /**
     * The {@link Node} on which the member will be created
     * 
     * @return The node name of the node that the new member will be created on
     */
    public Node getMemberNode() {
        return memberNode;
    }
    /**
     * The {@link Node} on which the member will be created
     * 
     * @param memberNode The {@link Node} of the new member
     */
    public void setMemberNode(Node memberNode) {
        this.memberNode = memberNode;
    }
    /**
     * Optionally specifies the UUID of the cluster member.
     * 
     * @return The UUID setting
     */
    public String getMemberUUID() {
        return memberUUID;
    }
    /**
     * Optionally specifies the UUID of the cluster member.
     * 
     * @param memberUUID The UUID to set
     */
    public void setMemberUUID(String memberUUID) {
        this.memberUUID = memberUUID;
    }
    /**
     * Optionally specifies the starting weight of the cluster member.
     * 
     * @return The member weight
     */
    public int getMemberWeight() {
        return memberWeight;
    }
    /**
     * Optionally specifies the starting weight of the cluster member.
     * 
     * @param memberWeight The member weight to set
     */
    public void setMemberWeight(int memberWeight) {
        this.memberWeight = memberWeight;
    }
    /**
     * Optionally specifies whether the system creates a replicator entry for the new cluster member
     * in the cluster replication domain. A replicator entry is used to provide HTTP session data
     * replication. This command parameter is optional. The value is true or false which indicates
     * whether the entry will be created. The default value is false. You can specify this parameter
     * only if a replication domain has been created for the cluster.
     * 
     * @return The replicatorEntry setting
     */
    public boolean getReplicatorEntry() {
        return replicatorEntry;
    }
    /**
     * Optionally specifies whether the system creates a replicator entry for the new cluster member
     * in the cluster replication domain. A replicator entry is used to provide HTTP session data
     * replication. This command parameter is optional. The value is true or false which indicates
     * whether the entry will be created. The default value is false. You can specify this parameter
     * only if a replication domain has been created for the cluster.
     * 
     * @param replicatorEntry Whether or not to create a replicator entry for the new cluster member
     */
    public void setReplicatorEntry(boolean replicatorEntry) {
        this.replicatorEntry = replicatorEntry;
    }
    
    
}
