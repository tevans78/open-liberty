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

package com.ibm.websphere.simplicity.commands.authorizationgroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Add resources to an existing authorization group.
 *   'authorizationGroupName': Authorization Group
 *   'resourceName': Name of the resource
 * The required parameters are found in the constructor.
 */
public class AddResourceToAuthorizationGroup extends Command {

	private String authorizationGroupName;
	private String resourceName;

	public AddResourceToAuthorizationGroup(String authorizationGroupName, String resourceName) {
		super("addResourceToAuthorizationGroup");
		this.authorizationGroupName = authorizationGroupName;
		this.resourceName = resourceName;
	}

	/**
	 * Authorization Group
	 */
	public String getAuthorizationGroupName() {
		return this.authorizationGroupName;
	}

	/**
	 * Authorization Group
	 */
	public void setAuthorizationGroupName(String value) {
		this.authorizationGroupName = value;
	}

	/**
	 * Name of the resource
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Name of the resource
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("authorizationGroupName", this.authorizationGroupName);
		ret.put("resourceName", this.resourceName);
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
