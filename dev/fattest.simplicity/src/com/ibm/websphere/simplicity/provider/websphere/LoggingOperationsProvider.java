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

package com.ibm.websphere.simplicity.provider.websphere;

import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;

public abstract class LoggingOperationsProvider extends CategorizedOperationsBase {

	/**
	 * Constructor.  For provider use only.
	 * @param parent
	 */
    public LoggingOperationsProvider(WebSphereOperationsProvider parent) {
		super(parent);
	}

    /**
     * Enables the user to modify both the trace specification and the
     * location of the trace log.  If filename is null, the trace will
     * be redirected to the standard out stream.  Filename is a fully-
     * qualified path and file name.  If the file pointed to by filename
     * exists, the file will be overwritten.
     * @param spec The new trace specification.
     * @param filename A fully-qualified path and file name.
     * @throws Exception
     */
	public abstract void setClientTrace(String spec, String filename) throws Exception;
    
}
