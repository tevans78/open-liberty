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
 * Returns the security domain that a particular scope belongs to.
 *   'resourceName': Name of the scope used to find the domain it is mapped to.
 *   'getEffectiveDomain': Specify true to return the effective security domain for the resource provided and false to only return the direct security domain for the resource.
 * The required parameters are found in the constructor.
 */
public class GetSecurityDomainForResource extends Command {

	private String resourceName;
	private Boolean getEffectiveDomain = true;

	public GetSecurityDomainForResource(String resourceName) {
		super("getSecurityDomainForResource");
		this.resourceName = resourceName;
	}

	/**
	 * Name of the scope used to find the domain it is mapped to.
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Name of the scope used to find the domain it is mapped to.
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	/**
	 * Specify true to return the effective security domain for the resource provided and false to only return the direct security domain for the resource.
	 */
	public Boolean getGetEffectiveDomain() {
		return this.getEffectiveDomain;
	}

	/**
	 * Specify true to return the effective security domain for the resource provided and false to only return the direct security domain for the resource.
	 */
	public void setGetEffectiveDomain(Boolean value) {
		this.getEffectiveDomain = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("resourceName", this.resourceName);
		if (this.getEffectiveDomain != null) {
			ret.put("getEffectiveDomain", this.getEffectiveDomain);
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
