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
 * Options for deleting a {@link com.ibm.websphere.simplicity.Cluster}
 */
public class ClusterDeletionOptions {

    private DeleteReplicationDomain replicationDomainOptions = new DeleteReplicationDomain();
    
    /**
     * The replication domain command step options for cluster deletion
     * 
     * @return The replication domain command step options
     */
    public DeleteReplicationDomain getReplicationDomainOptions() {
        return replicationDomainOptions;
    }
}
