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
 * The getClientDynamicPolicyControl command returns the WSPolicy client acquisition information for a specified application or resource.
 *   'applicationName': Specifies the name of the application. This parameter applies to application and client attachments.  It is not applicable to trust service attachments. (String)
 *   'resource': Specifies the name of the application resource. (String)
 * The required parameters are found in the constructor.
 */
public class GetClientDynamicPolicyControl extends Command {

	private String applicationName;
	private String resource;

	public GetClientDynamicPolicyControl(String applicationName) {
		super("getClientDynamicPolicyControl");
		this.applicationName = applicationName;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("applicationName", this.applicationName);
		if (this.resource != null) {
			ret.put("resource", this.resource);
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
