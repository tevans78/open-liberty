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
 * The copyPolicySet command creates a copy of an existing policy set. The default indicator is set to false for the new policy set. You may indicate whether to transfer attachments from the existing policy set to the new policy set.
 *   'sourcePolicySet': Specifies the name of the existing policy set. (String)
 *   'newPolicySet': Specifies the name of the new policy set. (String)
 *   'newDescription': Adds a description for the policy set or binding. (String)
 *   'transferAttachments': If this parameter is set to true, all attachments transfer from the source policy set to the new policy set. The default value is false. (Boolean)
 * The required parameters are found in the constructor.
 */
public class CopyPolicySet extends Command {

	private String sourcePolicySet;
	private String newPolicySet;
	private String newDescription;
	private Boolean transferAttachments;

	public CopyPolicySet(String sourcePolicySet, String newPolicySet) {
		super("copyPolicySet");
		this.sourcePolicySet = sourcePolicySet;
		this.newPolicySet = newPolicySet;
	}

	/**
	 * Specifies the name of the existing policy set. (String)
	 */
	public String getSourcePolicySet() {
		return this.sourcePolicySet;
	}

	/**
	 * Specifies the name of the existing policy set. (String)
	 */
	public void setSourcePolicySet(String value) {
		this.sourcePolicySet = value;
	}

	/**
	 * Specifies the name of the new policy set. (String)
	 */
	public String getNewPolicySet() {
		return this.newPolicySet;
	}

	/**
	 * Specifies the name of the new policy set. (String)
	 */
	public void setNewPolicySet(String value) {
		this.newPolicySet = value;
	}

	/**
	 * Adds a description for the policy set or binding. (String)
	 */
	public String getNewDescription() {
		return this.newDescription;
	}

	/**
	 * Adds a description for the policy set or binding. (String)
	 */
	public void setNewDescription(String value) {
		this.newDescription = value;
	}

	/**
	 * If this parameter is set to true, all attachments transfer from the source policy set to the new policy set. The default value is false. (Boolean)
	 */
	public Boolean getTransferAttachments() {
		return this.transferAttachments;
	}

	/**
	 * If this parameter is set to true, all attachments transfer from the source policy set to the new policy set. The default value is false. (Boolean)
	 */
	public void setTransferAttachments(Boolean value) {
		this.transferAttachments = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("sourcePolicySet", this.sourcePolicySet);
		ret.put("newPolicySet", this.newPolicySet);
		if (this.newDescription != null) {
			ret.put("newDescription", this.newDescription);
		}
		if (this.transferAttachments != null) {
			ret.put("transferAttachments", this.transferAttachments);
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
