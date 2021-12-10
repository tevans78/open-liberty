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
 * Replication domain settings for creating a cluster
 */
public class CreateReplicationDomain {

    private boolean createDomain = false;

    /**
     * Specifies whether to create a replication domain in your cluster configuration. The default
     * value is false.
     * 
     * @return true if the createDomain setting is set
     */
    public boolean getCreateDomain() {
        return createDomain;
    }
    /**
     * Specifies whether to create a replication domain in your cluster configuration. The default
     * value is false.
     * 
     * @param createDomain true to create a repliction domain
     */
    public void setCreateDomain(boolean createDomain) {
        this.createDomain = createDomain;
    }
    
    
}
