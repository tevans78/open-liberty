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
 * Deletes a domain object.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'force': When force is set to true, the security domain is deleted without checking if any resources exist in the domain. This option can be used when the resources in the security domains are not valid resources.
 * The required parameters are found in the constructor.
 */
public class DeleteSecurityDomain extends Command {

	private String securityDomainName;
	private Boolean force = false;

	public DeleteSecurityDomain(String securityDomainName) {
		super("deleteSecurityDomain");
		this.securityDomainName = securityDomainName;
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
	 * When force is set to true, the security domain is deleted without checking if any resources exist in the domain. This option can be used when the resources in the security domains are not valid resources.
	 */
	public Boolean getForce() {
		return this.force;
	}

	/**
	 * When force is set to true, the security domain is deleted without checking if any resources exist in the domain. This option can be used when the resources in the security domains are not valid resources.
	 */
	public void setForce(Boolean value) {
		this.force = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("securityDomainName", this.securityDomainName);
		if (this.force != null) {
			ret.put("force", this.force);
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
