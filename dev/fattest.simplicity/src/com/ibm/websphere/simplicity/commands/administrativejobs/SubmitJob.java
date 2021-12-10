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
 * Submits a new job for execution.
 *   'jobType': Type associated with the job.
 *   'targetList': List of managed node names for the target.
 *   'group': Name of the group for the target.
 *   'jobParams': Job specific parameters.
 *   'username': usernameDesc
 *   'password': passwordDesc
 *   'description': Description of the job.
 *   'activationDateTime': Time when this job will become active.
 *   'expirationDateTime': Expiration date of the Job.
 *   'executionWindow': Recurring interval for the job.
 *   'executionWindowUnit': Recurring Interval Unit for the job [DAILY|WEEKLY|MONTHLY|YEARLY|CONNECTION].
 *   'email': Email address where the job notification will be sent.
 * The required parameters are found in the constructor.
 */
public class SubmitJob extends Command {

	private java.lang.String jobType;
	private java.lang.String[] targetList;
	private java.lang.String group;
	private java.util.Properties jobParams;
	private java.lang.String username;
	private java.lang.String password;
	private java.lang.String description;
	private java.lang.String activationDateTime;
	private java.lang.String expirationDateTime;
	private java.lang.String executionWindow;
	private java.lang.String executionWindowUnit;
	private java.lang.String email;

	public SubmitJob(java.lang.String jobType) {
		super("submitJob");
		this.jobType = jobType;
	}

	/**
	 * Type associated with the job.
	 */
	public java.lang.String getJobType() {
		return this.jobType;
	}

	/**
	 * Type associated with the job.
	 */
	public void setJobType(java.lang.String value) {
		this.jobType = value;
	}

	/**
	 * List of managed node names for the target.
	 */
	public java.lang.String[] getTargetList() {
		return this.targetList;
	}

	/**
	 * List of managed node names for the target.
	 */
	public void setTargetList(java.lang.String[] value) {
		this.targetList = value;
	}

	/**
	 * Name of the group for the target.
	 */
	public java.lang.String getGroup() {
		return this.group;
	}

	/**
	 * Name of the group for the target.
	 */
	public void setGroup(java.lang.String value) {
		this.group = value;
	}

	/**
	 * Job specific parameters.
	 */
	public java.util.Properties getJobParams() {
		return this.jobParams;
	}

	/**
	 * Job specific parameters.
	 */
	public void setJobParams(java.util.Properties value) {
		this.jobParams = value;
	}

	/**
	 * usernameDesc
	 */
	public java.lang.String getUsername() {
		return this.username;
	}

	/**
	 * usernameDesc
	 */
	public void setUsername(java.lang.String value) {
		this.username = value;
	}

	/**
	 * passwordDesc
	 */
	public java.lang.String getPassword() {
		return this.password;
	}

	/**
	 * passwordDesc
	 */
	public void setPassword(java.lang.String value) {
		this.password = value;
	}

	/**
	 * Description of the job.
	 */
	public java.lang.String getDescription() {
		return this.description;
	}

	/**
	 * Description of the job.
	 */
	public void setDescription(java.lang.String value) {
		this.description = value;
	}

	/**
	 * Time when this job will become active.
	 */
	public java.lang.String getActivationDateTime() {
		return this.activationDateTime;
	}

	/**
	 * Time when this job will become active.
	 */
	public void setActivationDateTime(java.lang.String value) {
		this.activationDateTime = value;
	}

	/**
	 * Expiration date of the Job.
	 */
	public java.lang.String getExpirationDateTime() {
		return this.expirationDateTime;
	}

	/**
	 * Expiration date of the Job.
	 */
	public void setExpirationDateTime(java.lang.String value) {
		this.expirationDateTime = value;
	}

	/**
	 * Recurring interval for the job.
	 */
	public java.lang.String getExecutionWindow() {
		return this.executionWindow;
	}

	/**
	 * Recurring interval for the job.
	 */
	public void setExecutionWindow(java.lang.String value) {
		this.executionWindow = value;
	}

	/**
	 * Recurring Interval Unit for the job [DAILY|WEEKLY|MONTHLY|YEARLY|CONNECTION].
	 */
	public java.lang.String getExecutionWindowUnit() {
		return this.executionWindowUnit;
	}

	/**
	 * Recurring Interval Unit for the job [DAILY|WEEKLY|MONTHLY|YEARLY|CONNECTION].
	 */
	public void setExecutionWindowUnit(java.lang.String value) {
		this.executionWindowUnit = value;
	}

	/**
	 * Email address where the job notification will be sent.
	 */
	public java.lang.String getEmail() {
		return this.email;
	}

	/**
	 * Email address where the job notification will be sent.
	 */
	public void setEmail(java.lang.String value) {
		this.email = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("jobType", this.jobType);
		if (this.targetList != null) {
			ret.put("targetList", this.targetList);
		}
		if (this.group != null) {
			ret.put("group", this.group);
		}
		if (this.jobParams != null) {
			ret.put("jobParams", this.jobParams);
		}
		if (this.username != null) {
			ret.put("username", this.username);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.activationDateTime != null) {
			ret.put("activationDateTime", this.activationDateTime);
		}
		if (this.expirationDateTime != null) {
			ret.put("expirationDateTime", this.expirationDateTime);
		}
		if (this.executionWindow != null) {
			ret.put("executionWindow", this.executionWindow);
		}
		if (this.executionWindowUnit != null) {
			ret.put("executionWindowUnit", this.executionWindowUnit);
		}
		if (this.email != null) {
			ret.put("email", this.email);
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
