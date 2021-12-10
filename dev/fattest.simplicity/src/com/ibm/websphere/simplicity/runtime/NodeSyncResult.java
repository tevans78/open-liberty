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

/**
 * This class contains the results associated with a node sync
 */
public class NodeSyncResult {

    private long completeTime;
    private long initTime;
    private SyncResultStatus resultStatus;
    private boolean isUpdated;
    
    public enum SyncResultStatus {
        COMPLETE,
        ERROR,
        IN_PROGRESS,
        NOT_VERIFIED,
        OUT_OF_SYNC;
    }

    /**
     * Gets the time in milliseconds at which the most recent synchronization operation completed.
     * 
     * @return The time at which the most recent synchronization operation completed.
     */
    public long getCompleteTime() {
        return completeTime;
    }

    /**
     * Sets the time in milliseconds at which the most recent synchronization operation completed.
     * 
     * @param completeTime The complete time to set
     */
    public void setCompleteTime(long completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * Gets the time in milliseconds at which the most recent synchronization operation began.
     * 
     * @return The time at which the most recent synchronization operation began.
     */
    public long getInitTime() {
        return initTime;
    }

    /**
     * Sets the time in milliseconds at which the most recent synchronization operation began.
     * 
     * @param initTime The init time to set
     */
    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    /**
     * Returns if the most recent synchronization operation resulted in updates to the node
     * configuration.
     * 
     * @return true if the most recent sync operation resulted in updates
     */
    public boolean isUpdated() {
        return isUpdated;
    }

    /**
     * Sets if the most recent synchronization operation resulted in updates to the node
     * configuration.
     * 
     * @param isUpdated true if the most recent sync operation resulted in updates
     */
    public void setUpdated(boolean isUpdated) {
        this.isUpdated = isUpdated;
    }

    /**
     * Gets the result of the most recent synchronization operation.
     * 
     * @return The result of the most recent synchronization operation.
     */
    public SyncResultStatus getResult() {
        return this.resultStatus;
    }
    
    /**
     * Sets the result of the most recent synchronization operation.
     * 
     * @param result The result to set
     */
    public void setResult(SyncResultStatus result) {
        this.resultStatus = result;
    }
    
    /**
     * Get whether or not the most recent operation was successful
     * 
     * @return true if the most recent operation was successful
     */
    public boolean isSuccessful() {
        return (resultStatus != null) && (resultStatus == SyncResultStatus.COMPLETE);
    }
}
