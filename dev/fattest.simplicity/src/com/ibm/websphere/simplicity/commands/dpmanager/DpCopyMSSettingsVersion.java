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
 * Use the dpCopyMSSettingsVersion command to copy a DataPower appliance manager managed settings version to a new managed set.
 *   'managedSetId': Specifies the ID of the managed set of interest in the DataPower appliance manager.
 *   'msSettingsVersionId': Specifies the ID of the managed settings version of interest in the DataPower appliance manager.
 * The required parameters are found in the constructor.
 */
public class DpCopyMSSettingsVersion extends Command {

	private String managedSetId;
	private String msSettingsVersionId;

	public DpCopyMSSettingsVersion(String managedSetId, String msSettingsVersionId) {
		super("dpCopyMSSettingsVersion");
		this.managedSetId = managedSetId;
		this.msSettingsVersionId = msSettingsVersionId;
	}

	/**
	 * Specifies the ID of the managed set of interest in the DataPower appliance manager.
	 */
	public String getManagedSetId() {
		return this.managedSetId;
	}

	/**
	 * Specifies the ID of the managed set of interest in the DataPower appliance manager.
	 */
	public void setManagedSetId(String value) {
		this.managedSetId = value;
	}

	/**
	 * Specifies the ID of the managed settings version of interest in the DataPower appliance manager.
	 */
	public String getMsSettingsVersionId() {
		return this.msSettingsVersionId;
	}

	/**
	 * Specifies the ID of the managed settings version of interest in the DataPower appliance manager.
	 */
	public void setMsSettingsVersionId(String value) {
		this.msSettingsVersionId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("managedSetId", this.managedSetId);
		ret.put("msSettingsVersionId", this.msSettingsVersionId);
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
