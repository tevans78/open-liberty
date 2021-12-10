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

package com.ibm.websphere.simplicity.runtime;

import com.ibm.websphere.simplicity.Cluster;
import com.ibm.websphere.simplicity.Dmgr;
import com.ibm.websphere.simplicity.Server;

public class ClusterMBean extends MBean {

    /**
     * Constructor
     * 
     * @param scope The {@link Dmgr} on which the cluster mbean resides
     * @param cluster The {@link Cluster}
     * @throws Exception
     */
    public ClusterMBean(Dmgr scope, Cluster cluster) throws Exception {
        super(scope);
        resolveObjectName("*:name=" + cluster.getName() + ",type=Cluster,node=" + scope.getNode().getName() + ",process=" + scope.getName() + ",*");
    }
    
    /**
     * Constructor
     * 
     * @param scope The {@link Dmgr} on which the cluster mbean resides
     * @param clusterName The name of the cluster
     * @throws Exception
     */
    public ClusterMBean(Dmgr scope, String clusterName) throws Exception {
        super(scope);
        resolveObjectName("*:name=" + clusterName + ",type=Cluster,node=" + scope.getNode().getName() + ",process=" + scope.getName() + ",*");
    }

    /**
     * Start a cluster
     * @throws Exception
     */
    public void start() throws Exception {
        this.invoke("start");
    }
    
    /**
     * Stop a cluster
     * @throws Exception
     */
    public void stop() throws Exception {
        this.invoke("stop");
    }
    
    /**
     * Stop the cluster immediately
     * @throws Exception
     */
    public void stopImmediate() throws Exception {
        this.invoke("stopImmediate");
    }
    
    /**
     * Start the cluster
     * @throws Exception
     */
    public void rippleStart() throws Exception {
        this.invoke("rippleStart");
    }
    
    /**
     * Get availability of a cluster member.
     * 
     * @param memberName The name of the member server
     * @param nodeName The name of the node of the member
     * @return true if the member is available
     * @throws Exception
     */
    public boolean getAvailable(String memberName, String nodeName) throws Exception {
        return (Boolean)this.invoke("getAvailable", new Object[]{memberName, nodeName});
    }
    
    /**
     * Get availability of a cluster member.
     * 
     * @param member The cluster member
     * @return true if the member is available
     * @throws Exception
     */
    public boolean getAvailable(Server member) throws Exception {
        return getAvailable(member.getName(), member.getNodeName());
    }
    
    /**
     * Get the state of the Cluster
     * @return A {@link ClusterStatus} representing the state of the cluster
     * @throws Exception
     */
    public ClusterStatus getState() throws Exception {
        return ClusterStatus.getClusterStatus((String)this.getAttribute("state"));
    }
}
