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

import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/*
 * PLEASE NOTE.  The methods below have double-underscores in front
 * to avoid any conflicts with similar names in the generated classes.
 */

public abstract class Command {
	
	private String name;
	
	public Command(String name) {
		this.name = name;
	}
	
	/**
	 * For internal use only.
	 */
	public String __getName() {
		return this.name;
	}
	
	/**
	 * For internal use only.
	 */
	public abstract Properties __getParameters();
	/**
	 * For internal use only.
	 */
	public abstract List<Command> __getSteps();
	/**
	 * For internal use only.
	 */
	public abstract Object __getTarget();
	
	protected OperationResults<Object> run(Scope scope) throws Exception {
		return OperationsProviderFactory.getProvider().getAdminCommandOperationsProvider().run(scope, this);
	}

}
