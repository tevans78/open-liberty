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
 * Display information about the Jaspi configuration.
 *   'securityDomainName': Specify the name of the security domain.
 * The required parameters are found in the constructor.
 */
public class GetJaspiInfo extends Command {

	private java.lang.String securityDomainName;

	public GetJaspiInfo() {
		super("getJaspiInfo");
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
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
