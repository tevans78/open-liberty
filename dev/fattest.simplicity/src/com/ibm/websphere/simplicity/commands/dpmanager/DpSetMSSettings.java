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
 * Use the dpSetMSSettings command to modify the DataPower appliance manager managed settings.
 *   'msSettingsId': Specifies the ID of the managed settings of interest in the DataPower appliance manager.
 *   'desiredSettingsVersionId': Specifies the ID of the settings version to synchronize to each appliance in the managed set.
 * The required parameters are found in the constructor.
 */
public class DpSetMSSettings extends Command {

	private String msSettingsId;
	private String desiredSettingsVersionId;

	public DpSetMSSettings(String msSettingsId) {
		super("dpSetMSSettings");
		this.msSettingsId = msSettingsId;
	}

	/**
	 * Specifies the ID of the managed settings of interest in the DataPower appliance manager.
	 */
	public String getMsSettingsId() {
		return this.msSettingsId;
	}

	/**
	 * Specifies the ID of the managed settings of interest in the DataPower appliance manager.
	 */
	public void setMsSettingsId(String value) {
		this.msSettingsId = value;
	}

	/**
	 * Specifies the ID of the settings version to synchronize to each appliance in the managed set.
	 */
	public String getDesiredSettingsVersionId() {
		return this.desiredSettingsVersionId;
	}

	/**
	 * Specifies the ID of the settings version to synchronize to each appliance in the managed set.
	 */
	public void setDesiredSettingsVersionId(String value) {
		this.desiredSettingsVersionId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("msSettingsId", this.msSettingsId);
		if (this.desiredSettingsVersionId != null) {
			ret.put("desiredSettingsVersionId", this.desiredSettingsVersionId);
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
