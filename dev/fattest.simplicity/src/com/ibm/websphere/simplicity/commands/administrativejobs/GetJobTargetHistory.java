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
 * This command is used to get the job target history for a job.
 *   'jobToken': Unique identifier of previously submitted job.
 *   'target': Managed node name for the target.
 *   'startingTime': Include all the time window starting with the specified time.
 *   'endingTime': Include all the time window ending with the specified time.
 *   'ascending': Returns the results in ascending order if set to true.
 *   'maxReturn': Maximum number of matches to return.
 * The required parameters are found in the constructor.
 */
public class GetJobTargetHistory extends Command {

	private String jobToken;
	private String target;
	private java.lang.String startingTime;
	private java.lang.String endingTime;
	private Boolean ascending = true;
	private java.lang.Integer maxReturn;

	public GetJobTargetHistory(String jobToken, String target, java.lang.Integer maxReturn) {
		super("getJobTargetHistory");
		this.jobToken = jobToken;
		this.target = target;
		this.maxReturn = maxReturn;
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

	/**
	 * Managed node name for the target.
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * Managed node name for the target.
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * Include all the time window starting with the specified time.
	 */
	public java.lang.String getStartingTime() {
		return this.startingTime;
	}

	/**
	 * Include all the time window starting with the specified time.
	 */
	public void setStartingTime(java.lang.String value) {
		this.startingTime = value;
	}

	/**
	 * Include all the time window ending with the specified time.
	 */
	public java.lang.String getEndingTime() {
		return this.endingTime;
	}

	/**
	 * Include all the time window ending with the specified time.
	 */
	public void setEndingTime(java.lang.String value) {
		this.endingTime = value;
	}

	/**
	 * Returns the results in ascending order if set to true.
	 */
	public Boolean getAscending() {
		return this.ascending;
	}

	/**
	 * Returns the results in ascending order if set to true.
	 */
	public void setAscending(Boolean value) {
		this.ascending = value;
	}

	/**
	 * Maximum number of matches to return.
	 */
	public java.lang.Integer getMaxReturn() {
		return this.maxReturn;
	}

	/**
	 * Maximum number of matches to return.
	 */
	public void setMaxReturn(java.lang.Integer value) {
		this.maxReturn = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("jobToken", this.jobToken);
		ret.put("target", this.target);
		if (this.startingTime != null) {
			ret.put("startingTime", this.startingTime);
		}
		if (this.endingTime != null) {
			ret.put("endingTime", this.endingTime);
		}
		if (this.ascending != null) {
			ret.put("ascending", this.ascending);
		}
		ret.put("maxReturn", this.maxReturn);
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
