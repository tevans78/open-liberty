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

import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.commands.Command;
import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;

public abstract class AdminCommandOperationsProvider extends CategorizedOperationsBase {

	public AdminCommandOperationsProvider(WebSphereOperationsProvider parent) {
		super(parent);
	}
	
	public abstract OperationResults<Object> run(Scope scope, Command command) throws Exception;

}
