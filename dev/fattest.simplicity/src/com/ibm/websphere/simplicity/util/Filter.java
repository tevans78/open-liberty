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

package com.ibm.websphere.simplicity.util;

/**
 * This interface can be used to decide whether Objects should be filtered from some grouping such
 * as a Collection
 * 
 * @param <T> The type of Object to check
 */
public interface Filter<T> {

    /**
     * Determine if an Object should be filtered
     * 
     * @param object The Object to check
     * @return true if the Object should be filtered out, false if it should not be filtered
     */
    public boolean filterOut(T object);
    
}
