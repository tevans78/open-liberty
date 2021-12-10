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
 * The setPolicyTypeAttribute command sets an attribute for a specific policy.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'policyType': Specifies the name of the policy to add to the policy set. (String)
 *   'attributeName': Specifies the name of the attribute of interest. (String)
 *   'attributeValue': Specifies the value of the attribute of interest. (String)
 * The required parameters are found in the constructor.
 */
public class SetPolicyTypeAttribute extends Command {

	private String policySet;
	private String policyType;
	private String attributeName;
	private String attributeValue;

	public SetPolicyTypeAttribute(String policySet, String policyType, String attributeName, String attributeValue) {
		super("setPolicyTypeAttribute");
		this.policySet = policySet;
		this.policyType = policyType;
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
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
	 * Specifies the value of the attribute of interest. (String)
	 */
	public String getAttributeValue() {
		return this.attributeValue;
	}

	/**
	 * Specifies the value of the attribute of interest. (String)
	 */
	public void setAttributeValue(String value) {
		this.attributeValue = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("policySet", this.policySet);
		ret.put("policyType", this.policyType);
		ret.put("attributeName", this.attributeName);
		ret.put("attributeValue", this.attributeValue);
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
