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
 * The getPolicyType command returns the attributes for a specified policy.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'policyType': Specifies the name of the policy to add to the policy set. (String)
 *   'attributes': Specifies the attributes to display. If this parameter is used, the command returns all attributes for the specified policy type. (String[])
 *   'fromDefaultRepository': Indicates if the command should use the default repository (Boolean)
 * The required parameters are found in the constructor.
 */
public class GetPolicyType extends Command {

	private String policySet;
	private String policyType;
	private java.lang.String[] attributes;
	private Boolean fromDefaultRepository;

	public GetPolicyType(String policySet, String policyType) {
		super("getPolicyType");
		this.policySet = policySet;
		this.policyType = policyType;
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
	 * Specifies the name of the policy to add to the policy set. (String)
	 */
	public String getPolicyType() {
		return this.policyType;
	}

	/**
	 * Specifies the name of the policy to add to the policy set. (String)
	 */
	public void setPolicyType(String value) {
		this.policyType = value;
	}

	/**
	 * Specifies the attributes to display. If this parameter is used, the command returns all attributes for the specified policy type. (String[])
	 */
	public java.lang.String[] getAttributes() {
		return this.attributes;
	}

	/**
	 * Specifies the attributes to display. If this parameter is used, the command returns all attributes for the specified policy type. (String[])
	 */
	public void setAttributes(java.lang.String[] value) {
		this.attributes = value;
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
		ret.put("policySet", this.policySet);
		ret.put("policyType", this.policyType);
		if (this.attributes != null) {
			ret.put("attributes", this.attributes);
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
