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
 * The setPolicyType command updates the attributes of a specified policy.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'policyType': Specifies the name of the policy to add to the policy set. (String)
 *   'attributes': Specifies the attributes to update. (Properties)
 *   'replace': Indicates whether the new attributes provided from the command replace the existing attributes. The default value is false. (Boolean)
 * The required parameters are found in the constructor.
 */
public class SetPolicyType extends Command {

	private String policySet;
	private String policyType;
	private java.util.Properties attributes;
	private Boolean replace;

	public SetPolicyType(String policySet, String policyType, java.util.Properties attributes) {
		super("setPolicyType");
		this.policySet = policySet;
		this.policyType = policyType;
		this.attributes = attributes;
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
	 * Specifies the attributes to update. (Properties)
	 */
	public java.util.Properties getAttributes() {
		return this.attributes;
	}

	/**
	 * Specifies the attributes to update. (Properties)
	 */
	public void setAttributes(java.util.Properties value) {
		this.attributes = value;
	}

	/**
	 * Indicates whether the new attributes provided from the command replace the existing attributes. The default value is false. (Boolean)
	 */
	public Boolean getReplace() {
		return this.replace;
	}

	/**
	 * Indicates whether the new attributes provided from the command replace the existing attributes. The default value is false. (Boolean)
	 */
	public void setReplace(Boolean value) {
		this.replace = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("policySet", this.policySet);
		ret.put("policyType", this.policyType);
		ret.put("attributes", this.attributes);
		if (this.replace != null) {
			ret.put("replace", this.replace);
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
