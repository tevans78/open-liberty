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
 * The addPolicyType command creates a policy type with default values for the specified policy set. You may indicate whether to enable or disable the added policy type.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'policyType': Specifies the name of the policy to add to the policy set. (String)
 *   'enabled': If this parameter is set to true, the new policy type is enabled in the policy set. If this parameter is set to false, the configuration is contained within the policy set but the configuration does not have an effect on the system. (Boolean)
 * The required parameters are found in the constructor.
 */
public class AddPolicyType extends Command {

	private String policySet;
	private String policyType;
	private Boolean enabled;

	public AddPolicyType(String policySet, String policyType) {
		super("addPolicyType");
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
	 * If this parameter is set to true, the new policy type is enabled in the policy set. If this parameter is set to false, the configuration is contained within the policy set but the configuration does not have an effect on the system. (Boolean)
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * If this parameter is set to true, the new policy type is enabled in the policy set. If this parameter is set to false, the configuration is contained within the policy set but the configuration does not have an effect on the system. (Boolean)
	 */
	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("policySet", this.policySet);
		ret.put("policyType", this.policyType);
		if (this.enabled != null) {
			ret.put("enabled", this.enabled);
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
