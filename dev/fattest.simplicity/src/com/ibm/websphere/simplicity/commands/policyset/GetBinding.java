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
 * The getBinding command returns the binding configuration for a specified policy type and scope.
 *   'policyType': Specifies the name of the policy to add to the policy set. (String)
 *   'bindingLocation': Specifies the location of the binding. This value could be the cell-wide default binding, server-specific default binding, or attachment-specific binding. (Properties)
 *   'attributes': Specifies the attribute values to update. If the attributes parameter is not specified, the command only updates the binding location used by the specified attachment. (Properties)
 *   'attachmentType': Specifies the type of policy set attachments. The value for this parameter must be application, client, or system/trust. The default value is application. (String)
 *   'bindingName': Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
 * The required parameters are found in the constructor.
 */
public class GetBinding extends Command {

	private String policyType;
	private java.util.Properties bindingLocation;
	private java.lang.String[] attributes;
	private String attachmentType;
	private String bindingName;

	public GetBinding(java.util.Properties bindingLocation) {
		super("getBinding");
		this.bindingLocation = bindingLocation;
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
	 * Specifies the attribute values to update. If the attributes parameter is not specified, the command only updates the binding location used by the specified attachment. (Properties)
	 */
	public java.lang.String[] getAttributes() {
		return this.attributes;
	}

	/**
	 * Specifies the attribute values to update. If the attributes parameter is not specified, the command only updates the binding location used by the specified attachment. (Properties)
	 */
	public void setAttributes(java.lang.String[] value) {
		this.attributes = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.policyType != null) {
			ret.put("policyType", this.policyType);
		}
		ret.put("bindingLocation", this.bindingLocation);
		if (this.attributes != null) {
			ret.put("attributes", this.attributes);
		}
		if (this.attachmentType != null) {
			ret.put("attachmentType", this.attachmentType);
		}
		if (this.bindingName != null) {
			ret.put("bindingName", this.bindingName);
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
