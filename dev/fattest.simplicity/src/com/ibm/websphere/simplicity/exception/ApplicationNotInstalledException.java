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

public class ApplicationNotInstalledException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ApplicationNotInstalledException(String appName) {
		super("The application \""+appName+"\" need to be installed to perform this operation.");
	}

}
