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

public class TaskEntryNotFoundException extends Exception {

	private static final long serialVersionUID = 224828314582609481L;
	
	public TaskEntryNotFoundException() {
		super("Unable to find a task entry with the requested parameters.");
	}

	public TaskEntryNotFoundException(String arg0) {
		this();
	}

	public TaskEntryNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public TaskEntryNotFoundException(String arg0, Throwable arg1) {
		super("Unable to find a task entry with the requested parameters.", arg1);
	}

}
