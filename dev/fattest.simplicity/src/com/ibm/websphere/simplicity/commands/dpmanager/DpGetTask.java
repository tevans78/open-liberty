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
 * Use the dpGetTask command to get a specific DataPower appliance manager task.
 *   'taskId': Specifies the ID of the task of interest in the DataPower appliance manager.
 * The required parameters are found in the constructor.
 */
public class DpGetTask extends Command {

	private String taskId;

	public DpGetTask(String taskId) {
		super("dpGetTask");
		this.taskId = taskId;
	}

	/**
	 * Specifies the ID of the task of interest in the DataPower appliance manager.
	 */
	public String getTaskId() {
		return this.taskId;
	}

	/**
	 * Specifies the ID of the task of interest in the DataPower appliance manager.
	 */
	public void setTaskId(String value) {
		this.taskId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("taskId", this.taskId);
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
