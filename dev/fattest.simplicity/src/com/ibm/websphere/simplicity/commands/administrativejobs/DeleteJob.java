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

package com.ibm.websphere.simplicity.commands.administrativejobs;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Deletes a previously submitted job.
 *   'jobToken': Unique identifier of previously submitted job.
 * The required parameters are found in the constructor.
 */
public class DeleteJob extends Command {

	private String jobToken;

	public DeleteJob(String jobToken) {
		super("deleteJob");
		this.jobToken = jobToken;
	}

	/**
	 * Unique identifier of previously submitted job.
	 */
	public String getJobToken() {
		return this.jobToken;
	}

	/**
	 * Unique identifier of previously submitted job.
	 */
	public void setJobToken(String value) {
		this.jobToken = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("jobToken", this.jobToken);
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
