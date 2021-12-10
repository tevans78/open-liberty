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

package com.ibm.websphere.simplicity.exception;

/**
 * This Exception is thrown by providers who have not implemented an operation
 */
public class NotImplementedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NotImplementedException() {
		this("Not yet implemented");
	}
	
    public NotImplementedException(String msg) {
        super(msg);
    }
}
