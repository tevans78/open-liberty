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
 * The setProviderPolicySharingInfo command sets the WSPolicy provider sharing information for a specified resource within an application.
 *   'applicationName': Specifies the name of the application. This parameter applies to application and client attachments.  It is not applicable to trust service attachments. (String)
 *   'resource': Specifies the name of the application resource. (String)
 *   'sharePolicyMethods': Specifies the WSPolicy provider sharing methods. (String)
 *   'wsMexProperties': Specifies the WSMex resource properties. (Properties)
 *   'remove': Specifies whether to remove a server-specific default binding or to remove a custom binding from an attachment. You cannot remove a cell-level default binding. The default value is false. (Boolean)
 * The required parameters are found in the constructor.
 */
public class SetProviderPolicySharingInfo extends Command {

	private String applicationName;
	private String resource;
	private java.lang.String[] sharePolicyMethods;
	private java.util.Properties wsMexProperties;
	private Boolean remove;

	public SetProviderPolicySharingInfo(String applicationName, String resource) {
		super("setProviderPolicySharingInfo");
		this.applicationName = applicationName;
		this.resource = resource;
	}

	/**
	 * Specifies the name of the application. This parameter applies to application and client attachments.  It is not applicable to trust service attachments. (String)
	 */
	public String getApplicationName() {
		return this.applicationName;
	}

	/**
	 * Specifies the name of the application. This parameter applies to application and client attachments.  It is not applicable to trust service attachments. (String)
	 */
	public void setApplicationName(String value) {
		this.applicationName = value;
	}

	/**
	 * Specifies the name of the application resource. (String)
	 */
	public String getResource() {
		return this.resource;
	}

	/**
	 * Specifies the name of the application resource. (String)
	 */
	public void setResource(String value) {
		this.resource = value;
	}

	/**
	 * Specifies the WSPolicy provider sharing methods. (String)
	 */
	public java.lang.String[] getSharePolicyMethods() {
		return this.sharePolicyMethods;
	}

	/**
	 * Specifies the WSPolicy provider sharing methods. (String)
	 */
	public void setSharePolicyMethods(java.lang.String[] value) {
		this.sharePolicyMethods = value;
	}

	/**
	 * Specifies the WSMex resource properties. (Properties)
	 */
	public java.util.Properties getWsMexProperties() {
		return this.wsMexProperties;
	}

	/**
	 * Specifies the WSMex resource properties. (Properties)
	 */
	public void setWsMexProperties(java.util.Properties value) {
		this.wsMexProperties = value;
	}

	/**
	 * Specifies whether to remove a server-specific default binding or to remove a custom binding from an attachment. You cannot remove a cell-level default binding. The default value is false. (Boolean)
	 */
	public Boolean getRemove() {
		return this.remove;
	}

	/**
	 * Specifies whether to remove a server-specific default binding or to remove a custom binding from an attachment. You cannot remove a cell-level default binding. The default value is false. (Boolean)
	 */
	public void setRemove(Boolean value) {
		this.remove = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("applicationName", this.applicationName);
		ret.put("resource", this.resource);
		if (this.sharePolicyMethods != null) {
			ret.put("sharePolicyMethods", this.sharePolicyMethods);
		}
		if (this.wsMexProperties != null) {
			ret.put("wsMexProperties", this.wsMexProperties);
		}
		if (this.remove != null) {
			ret.put("remove", this.remove);
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
