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
 * The createPolicySet command creates a new policy set. Policy types are not created with the policy set. The default indicator is set to false.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'description': Adds a description for the policy set. (String)
 *   'policySetType': Specifies the type of policy set. Specify application to list application policy sets. Specify system/trust to list the trust service policy sets. The default value for this parameter is application. (String)
 * The required parameters are found in the constructor.
 */
public class CreatePolicySet extends Command {

	private String policySet;
	private String description;
	private String policySetType;

	public CreatePolicySet(String policySet) {
		super("createPolicySet");
		this.policySet = policySet;
	}

	/**
	 * Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
	 */
	public String getPolicySet() {
		return this.policySet;
	}

	/**
	 * Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
	 */
	public void setPolicySet(String value) {
		this.policySet = value;
	}

	/**
	 * Adds a description for the policy set. (String)
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Adds a description for the policy set. (String)
	 */
	public void setDescription(String value) {
		this.description = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("policySet", this.policySet);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.policySetType != null) {
			ret.put("policySetType", this.policySetType);
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
