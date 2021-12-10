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
 * Get properties associated with a specific managed resource.
 *   'resourceIdList': List of identifiers associated with the resource.
 * The required parameters are found in the constructor.
 */
public class GetManagedResourceProperties extends Command {

	private java.lang.String[] resourceIdList;

	public GetManagedResourceProperties(java.lang.String[] resourceIdList) {
		super("getManagedResourceProperties");
		this.resourceIdList = resourceIdList;
	}

	/**
	 * List of identifiers associated with the resource.
	 */
	public java.lang.String[] getResourceIdList() {
		return this.resourceIdList;
	}

	/**
	 * List of identifiers associated with the resource.
	 */
	public void setResourceIdList(java.lang.String[] value) {
		this.resourceIdList = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("resourceIdList", this.resourceIdList);
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
