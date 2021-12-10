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
 * Get the authorization groups of a given Resource.
 *   'resourceName': Name of the resource
 *   'traverseContainedResources': If traverseContainingObjects is true, it will list all the Resources that are effectively within this authorization group. If traverseContainingObjects is false, it will list only the resources within the given Authorization Group.
 * The required parameters are found in the constructor.
 */
public class ListAuthorizationGroupsOfResource extends Command {

	private String resourceName;
	private Boolean traverseContainedResources = false;

	public ListAuthorizationGroupsOfResource(String resourceName) {
		super("listAuthorizationGroupsOfResource");
		this.resourceName = resourceName;
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

	/**
	 * If traverseContainingObjects is true, it will list all the Resources that are effectively within this authorization group. If traverseContainingObjects is false, it will list only the resources within the given Authorization Group.
	 */
	public Boolean getTraverseContainedResources() {
		return this.traverseContainedResources;
	}

	/**
	 * If traverseContainingObjects is true, it will list all the Resources that are effectively within this authorization group. If traverseContainingObjects is false, it will list only the resources within the given Authorization Group.
	 */
	public void setTraverseContainedResources(Boolean value) {
		this.traverseContainedResources = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("resourceName", this.resourceName);
		if (this.traverseContainedResources != null) {
			ret.put("traverseContainedResources", this.traverseContainedResources);
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
