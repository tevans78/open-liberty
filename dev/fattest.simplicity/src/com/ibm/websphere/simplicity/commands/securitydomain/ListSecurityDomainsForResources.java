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

package com.ibm.websphere.simplicity.commands.securitydomain;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Returns a list of resources and their associated domain for each resource provided.
 *   'resourceNames': A plus separated list of resource names for which domain name are to be provided.
 * The required parameters are found in the constructor.
 */
public class ListSecurityDomainsForResources extends Command {

	private String resourceNames;

	public ListSecurityDomainsForResources(String resourceNames) {
		super("listSecurityDomainsForResources");
		this.resourceNames = resourceNames;
	}

	/**
	 * A plus separated list of resource names for which domain name are to be provided.
	 */
	public String getResourceNames() {
		return this.resourceNames;
	}

	/**
	 * A plus separated list of resource names for which domain name are to be provided.
	 */
	public void setResourceNames(String value) {
		this.resourceNames = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("resourceNames", this.resourceNames);
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
