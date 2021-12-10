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
 * Use the dpSetMSSettingsVersion command to modify a DataPower appliance manager managed settings version.
 *   'msSettingsVersionId': Specifies the ID of the managed settings version of interest in the DataPower appliance manager.
 *   'userComment': Specifies the comment to store in the settings version.
 * The required parameters are found in the constructor.
 */
public class DpSetMSSettingsVersion extends Command {

	private String msSettingsVersionId;
	private String userComment;

	public DpSetMSSettingsVersion(String msSettingsVersionId) {
		super("dpSetMSSettingsVersion");
		this.msSettingsVersionId = msSettingsVersionId;
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

	/**
	 * Specifies the comment to store in the settings version.
	 */
	public String getUserComment() {
		return this.userComment;
	}

	/**
	 * Specifies the comment to store in the settings version.
	 */
	public void setUserComment(String value) {
		this.userComment = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("msSettingsVersionId", this.msSettingsVersionId);
		if (this.userComment != null) {
			ret.put("userComment", this.userComment);
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
