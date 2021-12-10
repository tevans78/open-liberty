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
 * Modifies a security domain's description.
 *   'securityDomainDescription': Description of the security domain.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 * The required parameters are found in the constructor.
 */
public class ModifySecurityDomain extends Command {

	private String securityDomainDescription;
	private String securityDomainName;

	public ModifySecurityDomain(String securityDomainName) {
		super("modifySecurityDomain");
		this.securityDomainName = securityDomainName;
	}

	/**
	 * Description of the security domain.
	 */
	public String getSecurityDomainDescription() {
		return this.securityDomainDescription;
	}

	/**
	 * Description of the security domain.
	 */
	public void setSecurityDomainDescription(String value) {
		this.securityDomainDescription = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainDescription != null) {
			ret.put("securityDomainDescription", this.securityDomainDescription);
		}
		ret.put("securityDomainName", this.securityDomainName);
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
