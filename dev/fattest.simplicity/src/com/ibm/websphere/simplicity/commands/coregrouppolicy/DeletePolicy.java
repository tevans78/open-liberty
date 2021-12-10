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

package com.ibm.websphere.simplicity.commands.coregrouppolicy;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Delete a policy that matches the provided policy name.
 *   'coreGroupName': The name of the core group which this policy applies to.
 *   'policyName': The name of the policy that task will create, modify, or delete.
 * The required parameters are found in the constructor.
 */
public class DeletePolicy extends Command {

	private String coreGroupName;
	private String policyName;

	public DeletePolicy(String coreGroupName, String policyName) {
		super("deletePolicy");
		this.coreGroupName = coreGroupName;
		this.policyName = policyName;
	}

	/**
	 * The name of the core group which this policy applies to.
	 */
	public String getCoreGroupName() {
		return this.coreGroupName;
	}

	/**
	 * The name of the core group which this policy applies to.
	 */
	public void setCoreGroupName(String value) {
		this.coreGroupName = value;
	}

	/**
	 * The name of the policy that task will create, modify, or delete.
	 */
	public String getPolicyName() {
		return this.policyName;
	}

	/**
	 * The name of the policy that task will create, modify, or delete.
	 */
	public void setPolicyName(String value) {
		this.policyName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("coreGroupName", this.coreGroupName);
		ret.put("policyName", this.policyName);
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
