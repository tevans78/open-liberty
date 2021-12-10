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

package com.ibm.websphere.simplicity.commands.policyset;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The listPolicySets command returns a list of all existing policy sets.
 *   'policySetType': Specifies the type of policy set. Specify application to list application policy sets. Specify system/trust to list the trust service policy sets. The default value for this parameter is application. (String)
 *   'fromDefaultRepository': Indicates if the command should use the default repository (Boolean)
 * The required parameters are found in the constructor.
 */
public class ListPolicySets extends Command {

	private String policySetType;
	private Boolean fromDefaultRepository;

	public ListPolicySets() {
		super("listPolicySets");
	}

	/**
	 * Specifies the type of policy set. Specify application to list application policy sets. Specify system/trust to list the trust service policy sets. The default value for this parameter is application. (String)
	 */
	public String getPolicySetType() {
		return this.policySetType;
	}

	/**
	 * Specifies the type of policy set. Specify application to list application policy sets. Specify system/trust to list the trust service policy sets. The default value for this parameter is application. (String)
	 */
	public void setPolicySetType(String value) {
		this.policySetType = value;
	}

	/**
	 * Indicates if the command should use the default repository (Boolean)
	 */
	public Boolean getFromDefaultRepository() {
		return this.fromDefaultRepository;
	}

	/**
	 * Indicates if the command should use the default repository (Boolean)
	 */
	public void setFromDefaultRepository(Boolean value) {
		this.fromDefaultRepository = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.policySetType != null) {
			ret.put("policySetType", this.policySetType);
		}
		if (this.fromDefaultRepository != null) {
			ret.put("fromDefaultRepository", this.fromDefaultRepository);
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
