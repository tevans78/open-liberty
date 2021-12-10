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
 * run jobs locally without going through job manager
 *   'target': uuid of target
 *   'jobType': job type
 *   'jobParams': job parameters
 *   'locale': locale
 *   'contentParamName': name of parameter that refers to content element
 *   'contentElement': content element Properties
 * The required parameters are found in the constructor.
 */
public class RunJob extends Command {

	private String target;
	private String jobType;
	private java.util.Properties jobParams;
	private String locale;
	private String contentParamName;
	private java.util.Properties contentElement;

	public RunJob(String target, String jobType) {
		super("runJob");
		this.target = target;
		this.jobType = jobType;
	}

	/**
	 * uuid of target
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * uuid of target
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * job type
	 */
	public String getJobType() {
		return this.jobType;
	}

	/**
	 * job type
	 */
	public void setJobType(String value) {
		this.jobType = value;
	}

	/**
	 * job parameters
	 */
	public java.util.Properties getJobParams() {
		return this.jobParams;
	}

	/**
	 * job parameters
	 */
	public void setJobParams(java.util.Properties value) {
		this.jobParams = value;
	}

	/**
	 * locale
	 */
	public String getLocale() {
		return this.locale;
	}

	/**
	 * locale
	 */
	public void setLocale(String value) {
		this.locale = value;
	}

	/**
	 * name of parameter that refers to content element
	 */
	public String getContentParamName() {
		return this.contentParamName;
	}

	/**
	 * name of parameter that refers to content element
	 */
	public void setContentParamName(String value) {
		this.contentParamName = value;
	}

	/**
	 * content element Properties
	 */
	public java.util.Properties getContentElement() {
		return this.contentElement;
	}

	/**
	 * content element Properties
	 */
	public void setContentElement(java.util.Properties value) {
		this.contentElement = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("target", this.target);
		ret.put("jobType", this.jobType);
		if (this.jobParams != null) {
			ret.put("jobParams", this.jobParams);
		}
		if (this.locale != null) {
			ret.put("locale", this.locale);
		}
		if (this.contentParamName != null) {
			ret.put("contentParamName", this.contentParamName);
		}
		if (this.contentElement != null) {
			ret.put("contentElement", this.contentElement);
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
