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

package com.ibm.websphere.simplicity.application;

/**
 * Status states
 */
public enum ApplicationStatus {
	
    NA,
    PARTIALLY_STARTED,
    STARTING,
    STARTED,
    STOPPED,
    STOPPING,
    UNKNOWN;
    
    protected final static int STARTING_STATE = 0;
    protected final static int RUNNING_STATE = 1;
    protected final static int STOPPING_STATE = 2;
    protected final static int STOPPED_STATE = 3;
    protected final static int FAILED_STATE = 4;
}
