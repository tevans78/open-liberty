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
 * This Exception is thrown if an invalid null argument is specified
 */
public class NullArgumentException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NullArgumentException(String argument) {
		super("The argument cannot be null: "+argument);
	}
	
	public NullArgumentException(String argument, String hint) {
		super("The argument cannot be null: "+argument+"; Hint: "+hint);
	}

}
