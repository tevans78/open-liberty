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

import java.util.Comparator;

import com.ibm.websphere.simplicity.Scope;

/**
 * Compare two {@link Scope}s alphabetically by name
 * 
 * @param <T> The {@link Scope} type
 */
public class AlphabeticScopeComparator<T extends Scope> implements Comparator<T> {

    public int compare(T object1, T object2) {
        if(object1 == null) {
            if(object2 == null) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if(object2 == null) {
                return 1;
            } else {
                return object1.getName().compareTo(object2.getName());
            }
        }
    }

}
