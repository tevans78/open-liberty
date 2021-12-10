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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use the dpGetWebGUIURL command to obtain a URL to open the DataPower WebGUI on a appliance.
 *   'applianceId': Specifies the ID of the DataPower appliance of interest. This parameter is mutually exclusive with the msDomainId parameter.
 *   'msDomainId': Specifies the ID of the managed domain of interest.  This parameter is mutually exclusive with the applianceId parameter.
 * The required parameters are found in the constructor.
 */
public class DpGetWebGUIURL extends Command {

	private String applianceId;
	private String msDomainId;

	public DpGetWebGUIURL() {
		super("dpGetWebGUIURL");
	}

	/**
	 * Specifies the ID of the DataPower appliance of interest. This parameter is mutually exclusive with the msDomainId parameter.
	 */
	public String getApplianceId() {
		return this.applianceId;
	}

	/**
	 * Specifies the ID of the DataPower appliance of interest. This parameter is mutually exclusive with the msDomainId parameter.
	 */
	public void setApplianceId(String value) {
		this.applianceId = value;
	}

	/**
	 * Specifies the ID of the managed domain of interest.  This parameter is mutually exclusive with the applianceId parameter.
	 */
	public String getMsDomainId() {
		return this.msDomainId;
	}

	/**
	 * Specifies the ID of the managed domain of interest.  This parameter is mutually exclusive with the applianceId parameter.
	 */
	public void setMsDomainId(String value) {
		this.msDomainId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.applianceId != null) {
			ret.put("applianceId", this.applianceId);
		}
		if (this.msDomainId != null) {
			ret.put("msDomainId", this.msDomainId);
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
