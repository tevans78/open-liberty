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

public class ApplicationAlreadyInstalledException extends Exception {

	private static final long serialVersionUID = 2860461548843896902L;

	public ApplicationAlreadyInstalledException(String appName) {
		super("Application is already installed on the target: "+appName);
	}

	public ApplicationAlreadyInstalledException(String appName, Throwable arg1) {
		super("Application is already installed on the target: "+appName, arg1);
	}

}
