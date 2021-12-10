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

public enum ClusterStatus {

    RUNNING ("websphere.cluster.running"),
    PARTIALLY_STARTED ("websphere.cluster.partial.start"),
    PARTIALLY_STOPPED ("websphere.cluster.partial.stop"),
    STARTING ("websphere.cluster.starting"),
    STOPPED ("websphere.cluster.stopped");
    
    private String status;
    
    private ClusterStatus(String status) {
        this.status = status;
    }
    
    public String getStatusString() {
        return this.status;
    }
    
    public static ClusterStatus getClusterStatus(String statusString) {
        if("websphere.cluster.running".equals(statusString)) {
            return RUNNING;
        } else if("websphere.cluster.partial.start".equals(statusString)) {
            return PARTIALLY_STARTED;
        } else if("websphere.cluster.partial.stop".equals(statusString)) {
            return PARTIALLY_STOPPED;
        } else if("websphere.cluster.starting".equals(statusString)) {
            return STARTING;
        } else if("websphere.cluster.stopped".equals(statusString)) {
            return STOPPED;
        }
        return null;
    }
}
