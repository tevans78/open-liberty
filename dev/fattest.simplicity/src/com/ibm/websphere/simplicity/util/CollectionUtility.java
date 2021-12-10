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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * This is a general utility class to peform operations on Java Collections
 */
public class CollectionUtility {

    /**
     * Sort a Set
     * 
     * @param <T> The type of Object contained in the Set
     * @param set The Set who's items should be sorted
     * @param comparator A Comparator that defines how to sort the items in the Set
     * @return A List containing the sorted elements in the input Set
     */
    public static <T> List<T> sort(Set<T> set, Comparator<T> comparator) {
        List<T> list = new ArrayList<T>(set);
        Collections.sort(list, comparator);
        return list;
    }
    
    /**
     * Filter items from a Set. The input Set is not modified.
     * 
     * @param <T> The type of Object contained in the Set
     * @param set The Set who's items should be filtered
     * @param filter The {@link Filter} that defines how the items in the Set should be filtered
     * @return A new Set containing the contents of the input Set minus the filtered elements
     */
    public static <T> Set<T> filter(Set<T> set, Filter<T> filter) {
        Set<T> ret = new HashSet<T>();
        for(T object : set) {
            if(!filter.filterOut(object)) {
                ret.add(object);
            }
        }
        return ret;
    }
    
}
