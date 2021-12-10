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
 * Use the dpAddFirmwareVersion command to add a firmware version to the DataPower appliance manager.
 *   'file': Specifies the DataPower appliance manager system file that contains the firmware image to store in the firmware version.
 *   'userComment': Specifies the comment to store in the firmware version.
 * The required parameters are found in the constructor.
 */
public class DpAddFirmwareVersion extends Command {

	private String file;
	private String userComment;

	public DpAddFirmwareVersion(String file) {
		super("dpAddFirmwareVersion");
		this.file = file;
	}

	/**
	 * Specifies the DataPower appliance manager system file that contains the firmware image to store in the firmware version.
	 */
	public String getFile() {
		return this.file;
	}

	/**
	 * Specifies the DataPower appliance manager system file that contains the firmware image to store in the firmware version.
	 */
	public void setFile(String value) {
		this.file = value;
	}

	/**
	 * Specifies the comment to store in the firmware version.
	 */
	public String getUserComment() {
		return this.userComment;
	}

	/**
	 * Specifies the comment to store in the firmware version.
	 */
	public void setUserComment(String value) {
		this.userComment = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("file", this.file);
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
