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

package com.ibm.websphere.simplicity.commands.kerberos;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command sets the active authentication mechanism attribute in the security configuration.
 *   'authMechanismType': Supply value for active authentication mechanism type: KRB5/LTPA.
 * The required parameters are found in the constructor.
 */
public class SetActiveAuthMechanism extends Command {

	private String authMechanismType = "KRB5";

	public SetActiveAuthMechanism(String authMechanismType) {
		super("setActiveAuthMechanism");
		this.authMechanismType = authMechanismType;
	}

	/**
	 * Supply value for active authentication mechanism type: KRB5/LTPA.
	 */
	public String getAuthMechanismType() {
		return this.authMechanismType;
	}

	/**
	 * Supply value for active authentication mechanism type: KRB5/LTPA.
	 */
	public void setAuthMechanismType(String value) {
		this.authMechanismType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("authMechanismType", this.authMechanismType);
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
