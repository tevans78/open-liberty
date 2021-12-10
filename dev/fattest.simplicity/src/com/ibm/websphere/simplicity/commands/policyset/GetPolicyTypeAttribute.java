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
 * The getPolicyTypeAttribute command returns the value for the specified policy attribute.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'policyType': Specifies the name of the policy to add to the policy set. (String)
 *   'attributeName': Specifies the name of the attribute of interest. (String)
 *   'fromDefaultRepository': Indicates if the command should use the default repository (Boolean)
 * The required parameters are found in the constructor.
 */
public class GetPolicyTypeAttribute extends Command {

	private String policySet;
	private String policyType;
	private String attributeName;
	private Boolean fromDefaultRepository;

	public GetPolicyTypeAttribute(String policySet, String policyType, String attributeName) {
		super("getPolicyTypeAttribute");
		this.policySet = policySet;
		this.policyType = policyType;
		this.attributeName = attributeName;
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
	 * Specifies the name of the attribute of interest. (String)
	 */
	public String getAttributeName() {
		return this.attributeName;
	}

	/**
	 * Specifies the name of the attribute of interest. (String)
	 */
	public void setAttributeName(String value) {
		this.attributeName = value;
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
		ret.put("attributeName", this.attributeName);
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
