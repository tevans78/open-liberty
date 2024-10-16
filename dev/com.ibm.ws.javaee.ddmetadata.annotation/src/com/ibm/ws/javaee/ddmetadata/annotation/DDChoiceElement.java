/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.javaee.ddmetadata.annotation;

import java.lang.annotation.Target;

/**
 * Metadata for an XML element that belongs to the same list as another element.
 */
@Target({})
public @interface DDChoiceElement {
    /**
     * The element name.
     */
    String name();

    /**
     * The subtype for this element. This type must extend the return type of
     * the method annotated with {@link DDChoiceElements}.
     */
    Class<?> type();
}
