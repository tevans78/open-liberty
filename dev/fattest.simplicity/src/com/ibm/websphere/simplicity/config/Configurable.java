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

package com.ibm.websphere.simplicity.config;

import java.util.HashMap;

/**
 * For internal use only.  Implemented by classes that listen to live transaction events.
 */
public interface Configurable {

    public void commit(HashMap<String, Object> values) throws Exception;
    public void rollback(HashMap<String, Object> values) throws Exception;
    
}
