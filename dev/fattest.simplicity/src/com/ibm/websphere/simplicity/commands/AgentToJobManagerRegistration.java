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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Security registration of an agent with a job manager.
 *   'jobManagerFTPort': The file transfer servlet TCP port on the job manager.
 *   'jobManagerFTSecurePort': The file transfer servlet SSL port on the job manager.
 *   'jobManagerHost': Hostname of the target job manager.
 *   'register': The determination of whether to register or unregister the agent from the job manager.
 *   'jobManagerPassword': The password to use when making a secure call to the job manager.
 *   'agentProfilePath': Profile path for the admin agent being registered.
 *   'jobManagerUserid': The userid to use when making a secure call to the job manager.
 * The required parameters are found in the constructor.
 */
public class AgentToJobManagerRegistration extends Command {

	private Integer jobManagerFTPort;
	private Integer jobManagerFTSecurePort;
	private String jobManagerHost;
	private Boolean register;
	private String jobManagerPassword;
	private String agentProfilePath;
	private String jobManagerUserid;

	public AgentToJobManagerRegistration(Integer jobManagerFTPort, Integer jobManagerFTSecurePort, String jobManagerHost, Boolean register, String agentProfilePath) {
		super("agentToJobManagerRegistration");
		this.jobManagerFTPort = jobManagerFTPort;
		this.jobManagerFTSecurePort = jobManagerFTSecurePort;
		this.jobManagerHost = jobManagerHost;
		this.register = register;
		this.agentProfilePath = agentProfilePath;
	}

	/**
	 * The file transfer servlet TCP port on the job manager.
	 */
	public Integer getJobManagerFTPort() {
		return this.jobManagerFTPort;
	}

	/**
	 * The file transfer servlet TCP port on the job manager.
	 */
	public void setJobManagerFTPort(Integer value) {
		this.jobManagerFTPort = value;
	}

	/**
	 * The file transfer servlet SSL port on the job manager.
	 */
	public Integer getJobManagerFTSecurePort() {
		return this.jobManagerFTSecurePort;
	}

	/**
	 * The file transfer servlet SSL port on the job manager.
	 */
	public void setJobManagerFTSecurePort(Integer value) {
		this.jobManagerFTSecurePort = value;
	}

	/**
	 * Hostname of the target job manager.
	 */
	public String getJobManagerHost() {
		return this.jobManagerHost;
	}

	/**
	 * Hostname of the target job manager.
	 */
	public void setJobManagerHost(String value) {
		this.jobManagerHost = value;
	}

	/**
	 * The determination of whether to register or unregister the agent from the job manager.
	 */
	public Boolean getRegister() {
		return this.register;
	}

	/**
	 * The determination of whether to register or unregister the agent from the job manager.
	 */
	public void setRegister(Boolean value) {
		this.register = value;
	}

	/**
	 * The password to use when making a secure call to the job manager.
	 */
	public String getJobManagerPassword() {
		return this.jobManagerPassword;
	}

	/**
	 * The password to use when making a secure call to the job manager.
	 */
	public void setJobManagerPassword(String value) {
		this.jobManagerPassword = value;
	}

	/**
	 * Profile path for the admin agent being registered.
	 */
	public String getAgentProfilePath() {
		return this.agentProfilePath;
	}

	/**
	 * Profile path for the admin agent being registered.
	 */
	public void setAgentProfilePath(String value) {
		this.agentProfilePath = value;
	}

	/**
	 * The userid to use when making a secure call to the job manager.
	 */
	public String getJobManagerUserid() {
		return this.jobManagerUserid;
	}

	/**
	 * The userid to use when making a secure call to the job manager.
	 */
	public void setJobManagerUserid(String value) {
		this.jobManagerUserid = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("jobManagerFTPort", this.jobManagerFTPort);
		ret.put("jobManagerFTSecurePort", this.jobManagerFTSecurePort);
		ret.put("jobManagerHost", this.jobManagerHost);
		ret.put("register", this.register);
		if (this.jobManagerPassword != null) {
			ret.put("jobManagerPassword", this.jobManagerPassword);
		}
		ret.put("agentProfilePath", this.agentProfilePath);
		if (this.jobManagerUserid != null) {
			ret.put("jobManagerUserid", this.jobManagerUserid);
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
