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

package com.ibm.websphere.simplicity.commands.securityconfiguration;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Returns the CSI outbound information for global security or in a security domain.
 *   'displayModel': Display the model attribute values for the CSI inbound configuration.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 * The required parameters are found in the constructor.
 */
public class GetCSIOutboundInfo extends Command {

	private Boolean displayModel = false;
	private String securityDomainName;

	public GetCSIOutboundInfo() {
		super("getCSIOutboundInfo");
	}

	/**
	 * Display the model attribute values for the CSI inbound configuration.
	 */
	public Boolean getDisplayModel() {
		return this.displayModel;
	}

	/**
	 * Display the model attribute values for the CSI inbound configuration.
	 */
	public void setDisplayModel(Boolean value) {
		this.displayModel = value;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.displayModel != null) {
			ret.put("displayModel", this.displayModel);
		}
		if (this.securityDomainName != null) {
			ret.put("securityDomainName", this.securityDomainName);
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
