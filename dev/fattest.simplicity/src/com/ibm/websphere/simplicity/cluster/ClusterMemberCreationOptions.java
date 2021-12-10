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
 * Options to create a new cluster member
 */
public class ClusterMemberCreationOptions {

    private MemberConfig memberConfigOptions = new MemberConfig();
    private FirstMember firstMemberOptions = new FirstMember();
    
    /**
     * The firstMember command step options for creating a new cluster member
     * 
     * @return The firstMember command step options
     */
    public FirstMember getFirstMemberOptions() {
        return firstMemberOptions;
    }
    /**
     * The memberConfig command step options for creating a new cluster member
     * 
     * @return The memberConfig command step options
     */
    public MemberConfig getMemberConfigOptions() {
        return memberConfigOptions;
    }
    
}
