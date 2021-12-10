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

package com.ibm.websphere.simplicity.commands.dpmanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use the dpRemoveAppliance command to remove an appliance from the DataPower appliance manager.
 *   'applianceId': Specifies the ID of the appliance of interest in the DataPower appliance manager.
 * The required parameters are found in the constructor.
 */
public class DpRemoveAppliance extends Command {

	private String applianceId;

	public DpRemoveAppliance(String applianceId) {
		super("dpRemoveAppliance");
		this.applianceId = applianceId;
	}

	/**
	 * Specifies the ID of the appliance of interest in the DataPower appliance manager.
	 */
	public String getApplianceId() {
		return this.applianceId;
	}

	/**
	 * Specifies the ID of the appliance of interest in the DataPower appliance manager.
	 */
	public void setApplianceId(String value) {
		this.applianceId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("applianceId", this.applianceId);
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
