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
 * The updatePolicySet command enables you to input an attribute list to update the policy set. You can use this command to update all attributes for the policy set, or a subset of attributes.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'attributes': Specifies a properties object that contains the attributes to update for the specified policy set. (Properties)
 * The required parameters are found in the constructor.
 */
public class UpdatePolicySet extends Command {

	private String policySet;
	private java.util.Properties attributes;

	public UpdatePolicySet(String policySet, java.util.Properties attributes) {
		super("updatePolicySet");
		this.policySet = policySet;
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
	 * Specifies a properties object that contains the attributes to update for the specified policy set. (Properties)
	 */
	public java.util.Properties getAttributes() {
		return this.attributes;
	}

	/**
	 * Specifies a properties object that contains the attributes to update for the specified policy set. (Properties)
	 */
	public void setAttributes(java.util.Properties value) {
		this.attributes = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("policySet", this.policySet);
		ret.put("attributes", this.attributes);
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
