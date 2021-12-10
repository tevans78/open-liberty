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
 * This exception is thrown if a WebSphere operation is perform against an incompatible version of WebSphere.
 */
public class IncompatibleVersionException extends Exception {

	private static final long serialVersionUID = 1L;
	
    /**
     * @param version The WAS version
     */
	public IncompatibleVersionException(String version) {
		super("This feature is not supported for version "+version);
	}
	
    /**
     * @param minimum The minimum WAS version
     * @param actual The actual WAS version
     */
	public IncompatibleVersionException(String minimum, String actual) {
		super("This feature requires at least version "+minimum+
				", but the server is "+actual);
	}

}
