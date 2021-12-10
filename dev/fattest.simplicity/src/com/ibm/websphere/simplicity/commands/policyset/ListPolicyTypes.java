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
 * The listPolicyTypes command returns a list of the names of the policies configured in the system, in a policy set, or in a binding.
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'bindingLocation': Specifies the location of the binding. This value could be the cell-wide default binding, server-specific default binding, or attachment-specific binding. (Properties)
 *   'attachmentType': Specifies the type of policy set attachments. The value for this parameter must be application, client, or system/trust. The default value is application. (String)
 *   'bindingName': Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
 *   'fromDefaultRepository': Indicates if the command should use the default repository (Boolean)
 *   'enabled': If this parameter is set to true, only the policy types that are enabled in the policy set are listed. If this parameter is set to false, all of the policy types in the policy set are listed. (Boolean)
 * The required parameters are found in the constructor.
 */
public class ListPolicyTypes extends Command {

	private String policySet;
	private java.util.Properties bindingLocation;
	private String attachmentType;
	private String bindingName;
	private Boolean fromDefaultRepository;
	private Boolean enabled;

	public ListPolicyTypes() {
		super("listPolicyTypes");
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
	 * Specifies the location of the binding. This value could be the cell-wide default binding, server-specific default binding, or attachment-specific binding. (Properties)
	 */
	public java.util.Properties getBindingLocation() {
		return this.bindingLocation;
	}

	/**
	 * Specifies the location of the binding. This value could be the cell-wide default binding, server-specific default binding, or attachment-specific binding. (Properties)
	 */
	public void setBindingLocation(java.util.Properties value) {
		this.bindingLocation = value;
	}

	/**
	 * Specifies the type of policy set attachments. The value for this parameter must be application, client, or system/trust. The default value is application. (String)
	 */
	public String getAttachmentType() {
		return this.attachmentType;
	}

	/**
	 * Specifies the type of policy set attachments. The value for this parameter must be application, client, or system/trust. The default value is application. (String)
	 */
	public void setAttachmentType(String value) {
		this.attachmentType = value;
	}

	/**
	 * Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
	 */
	public String getBindingName() {
		return this.bindingName;
	}

	/**
	 * Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
	 */
	public void setBindingName(String value) {
		this.bindingName = value;
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

	/**
	 * If this parameter is set to true, only the policy types that are enabled in the policy set are listed. If this parameter is set to false, all of the policy types in the policy set are listed. (Boolean)
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * If this parameter is set to true, only the policy types that are enabled in the policy set are listed. If this parameter is set to false, all of the policy types in the policy set are listed. (Boolean)
	 */
	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.policySet != null) {
			ret.put("policySet", this.policySet);
		}
		if (this.bindingLocation != null) {
			ret.put("bindingLocation", this.bindingLocation);
		}
		if (this.attachmentType != null) {
			ret.put("attachmentType", this.attachmentType);
		}
		if (this.bindingName != null) {
			ret.put("bindingName", this.bindingName);
		}
		if (this.fromDefaultRepository != null) {
			ret.put("fromDefaultRepository", this.fromDefaultRepository);
		}
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
