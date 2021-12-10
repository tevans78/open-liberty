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
 * Display configuration data for the given authentication provider(s).
 *   'securityDomainName': Specify the name of the security domain.
 *   'providerName': Specify one or more authentication provider names.
 * The required parameters are found in the constructor.
 */
public class DisplayJaspiProvider extends Command {

	private java.lang.String securityDomainName;
	private java.lang.String[] providerName;

	public DisplayJaspiProvider(java.lang.String[] providerName) {
		super("displayJaspiProvider");
		this.providerName = providerName;
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
	 * Specify one or more authentication provider names.
	 */
	public java.lang.String[] getProviderName() {
		return this.providerName;
	}

	/**
	 * Specify one or more authentication provider names.
	 */
	public void setProviderName(java.lang.String[] value) {
		this.providerName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
		}
		ret.put("providerName", this.providerName);
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
