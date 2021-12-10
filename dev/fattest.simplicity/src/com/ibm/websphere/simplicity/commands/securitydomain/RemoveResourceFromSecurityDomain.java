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
 * Remove a resource from a security domain.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'resourceName': Specifies the resource to remove from the security domain.
 * The required parameters are found in the constructor.
 */
public class RemoveResourceFromSecurityDomain extends Command {

	private String securityDomainName;
	private String resourceName;

	public RemoveResourceFromSecurityDomain(String securityDomainName, String resourceName) {
		super("removeResourceFromSecurityDomain");
		this.securityDomainName = securityDomainName;
		this.resourceName = resourceName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * Specifies the resource to remove from the security domain.
	 */
	public String getResourceName() {
		return this.resourceName;
	}

	/**
	 * Specifies the resource to remove from the security domain.
	 */
	public void setResourceName(String value) {
		this.resourceName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("securityDomainName", this.securityDomainName);
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
