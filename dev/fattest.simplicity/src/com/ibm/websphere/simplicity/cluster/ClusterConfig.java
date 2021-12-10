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

/**
 * ClusterConfig options for creating a cluster
 */
public class ClusterConfig {
    
    private String clusterName;
    private boolean preferLocal = false;
    private ClusterType clusterType = ClusterType.APPLICATION_SERVER;
    private String shortName;
    
    /**
     * Get the cluster name. The name uniquely identifies the cluster.
     * 
     * @return the cluster name
     */
    public String getClusterName() {
        return clusterName;
    }
    /**
     * Set the name of the cluster. The name uniquely identifies the cluster, and can be up to 
     * 50 characters long and include mixed case alphabetic characters, numeric characters, and 
     * the following special characters: ! ^ ( ) _ - . { } [ ]
     * 
     * @param clusterName The name to set
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }
    /**
     * Get the cluster type. Optionally specifies the type of the server cluster to create. The
     * default type is {@link ClusterType#APPLICATION_SERVER}
     * 
     * @return The cluter type
     */
    public ClusterType getClusterType() {
        return clusterType;
    }
    /**
     * Set the cluster type. Optionally specifies the type of the server cluster to create. The
     * default type is {@link ClusterType#APPLICATION_SERVER}
     * 
     * @param clusterType The type of the cluster
     */
    public void setClusterType(ClusterType clusterType) {
        this.clusterType = clusterType;
    }
    /**
     * Optionally specifies whether to enable or disable node-scoped routing optimization within the
     * cluster. The default value is false.
     * 
     * @return true if node-scoped routing optimization is set
     */
    public boolean getPreferLocal() {
        return preferLocal;
    }
    /**
     * Optionally specifies whether to enable or disable node-scoped routing optimization within the
     * cluster. The default value is false.
     * 
     * @param preferLocal Whether to enable or disable node-scopred routing optimization.
     */
    public void setPreferLocal(boolean preferLocal) {
        this.preferLocal = preferLocal;
    }
    /**
     * Get the short name. The short name setting is specific to z/OS
     * 
     * @return The short name
     */
    public String getShortName() {
        return shortName;
    }
    /**
     * Set the short name. Short names are specific to the z/OS implementation of WebSphere 
     * Application Server and are the principal names by which cells, nodes, servers and clusters
     * are known to z/OS. (Note that z/OS has an eight-character limit on many operating system 
     * interface values.) Short names must be one to eight characters long, use only uppercase 
     * alphabetic, numeric and national characters, and cannot begin with a numeric character.
     * 
     * @param shortName The short name to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
