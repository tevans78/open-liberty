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
 * Replication domain settings for deleting a cluster
 */
public class DeleteReplicationDomain {
    
    private boolean deleteDomain = false;
    
    /**
     * Specifies whether to delete the replication domain. The default value is false.
     * 
     * @return The delete domain setting
     */
    public boolean getDeleteDomain() {
        return this.deleteDomain;
    }
    
    /**
     * Specifies whether to delete the replication domain. The default value is false. Specify true
     * to delete the replication domain.
     * 
     * @param deleteDomain true to delete the replication domain
     */
    public void setDeleteDomain(boolean deleteDomain) {
        this.deleteDomain = deleteDomain;
    }

}
