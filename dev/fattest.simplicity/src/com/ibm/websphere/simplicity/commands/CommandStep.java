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

package com.ibm.websphere.simplicity.commands;

import java.util.List;
import java.util.Properties;

public abstract class CommandStep extends Command {

	public CommandStep(String name) {
		super(name);
	}

	/*
	 * SHELL DEFINITIONS
	 */
	
	@Override
	public Properties __getParameters() {
		return null;
	}

	@Override
	public List<Command> __getSteps() {
		return null;
	}

	@Override
	public Object __getTarget() {
		return null;
	}

}
