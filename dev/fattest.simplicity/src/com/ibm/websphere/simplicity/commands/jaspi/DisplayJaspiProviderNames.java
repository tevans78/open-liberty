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

package com.ibm.websphere.simplicity.commands.jaspi;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Display the names of all authentication providers in the security configuration.
 *   'securityDomainName': Specify the name of the security domain.
 *   'getEffectiveProviderNames': Display the effective Jaspi provider names when getting the list of provider names for a security domain.
 * The required parameters are found in the constructor.
 */
public class DisplayJaspiProviderNames extends Command {

	private java.lang.String securityDomainName;
	private java.lang.Boolean getEffectiveProviderNames = false;

	public DisplayJaspiProviderNames() {
		super("displayJaspiProviderNames");
	}

	/**
	 * Specify the name of the security domain.
	 */
	public java.lang.String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Specify the name of the security domain.
	 */
	public void setSecurityDomainName(java.lang.String value) {
		this.securityDomainName = value;
	}

	/**
	 * Display the effective Jaspi provider names when getting the list of provider names for a security domain.
	 */
	public java.lang.Boolean getGetEffectiveProviderNames() {
		return this.getEffectiveProviderNames;
	}

	/**
	 * Display the effective Jaspi provider names when getting the list of provider names for a security domain.
	 */
	public void setGetEffectiveProviderNames(java.lang.Boolean value) {
		this.getEffectiveProviderNames = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		if (this.getEffectiveProviderNames != null) {
			ret.put("getEffectiveProviderNames", this.getEffectiveProviderNames);
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
