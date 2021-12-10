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

package com.ibm.websphere.simplicity.commands.wsscache;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Remove Web Services Security distributed cache custom properties
 *   'propertyNames': WSS Distributed Cache Config Custom Properties
 * The required parameters are found in the constructor.
 */
public class DeleteWSSDistributedCacheConfigCustomProperties extends Command {

	private java.lang.String[] propertyNames;

	public DeleteWSSDistributedCacheConfigCustomProperties(java.lang.String[] propertyNames) {
		super("deleteWSSDistributedCacheConfigCustomProperties");
		this.propertyNames = propertyNames;
	}

	/**
	 * WSS Distributed Cache Config Custom Properties
	 */
	public java.lang.String[] getPropertyNames() {
		return this.propertyNames;
	}

	/**
	 * WSS Distributed Cache Config Custom Properties
	 */
	public void setPropertyNames(java.lang.String[] value) {
		this.propertyNames = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("propertyNames", this.propertyNames);
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
