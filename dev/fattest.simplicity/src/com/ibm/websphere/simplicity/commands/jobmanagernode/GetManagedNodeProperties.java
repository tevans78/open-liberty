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

package com.ibm.websphere.simplicity.commands.jobmanagernode;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * getManagedNodePropertiesDesc
 *   'managedNodeNameList': List of managed node names.
 * The required parameters are found in the constructor.
 */
public class GetManagedNodeProperties extends Command {

	private java.lang.String[] managedNodeNameList;

	public GetManagedNodeProperties() {
		super("getManagedNodeProperties");
	}

	/**
	 * List of managed node names.
	 */
	public java.lang.String[] getManagedNodeNameList() {
		return this.managedNodeNameList;
	}

	/**
	 * List of managed node names.
	 */
	public void setManagedNodeNameList(java.lang.String[] value) {
		this.managedNodeNameList = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.managedNodeNameList != null) {
			ret.put("managedNodeNameList", this.managedNodeNameList);
		}
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
