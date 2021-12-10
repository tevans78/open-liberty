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
 * This command is used to get the metadata associated with a jobType.
 *   'jobTypeList': List containing Job Types.
 * The required parameters are found in the constructor.
 */
public class GetJobTypeMetadata extends Command {

	private java.lang.String[] jobTypeList;

	public GetJobTypeMetadata(java.lang.String[] jobTypeList) {
		super("getJobTypeMetadata");
		this.jobTypeList = jobTypeList;
	}

	/**
	 * List containing Job Types.
	 */
	public java.lang.String[] getJobTypeList() {
		return this.jobTypeList;
	}

	/**
	 * List containing Job Types.
	 */
	public void setJobTypeList(java.lang.String[] value) {
		this.jobTypeList = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("jobTypeList", this.jobTypeList);
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
