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
 * Required and optional cluster creation options.
 */
public class ClusterCreationOptions {
    
    private ClusterConfig clusterConfigOptions = new ClusterConfig();
    private ConvertServer convertServerOptions = new ConvertServer();
    private CreateReplicationDomain replicationDomainOptions = new CreateReplicationDomain();
    
    /**
     * The clusterConfig command step options for cluster creation
     * 
     * @return The clusterConfig command step options
     */
    public ClusterConfig getClusterConfigOptions() {
        return clusterConfigOptions;
    }
    /**
     * The convertServer command step options for cluster creation
     * 
     * @return The convertServer command step options
     */
    public ConvertServer getConvertServerOptions() {
        return convertServerOptions;
    }
    /**
     * The replication domain command step options for cluster creation
     * 
     * @return The replication domain command step options
     */
    public CreateReplicationDomain getReplicationDomainOptions() {
        return replicationDomainOptions;
    }
}
