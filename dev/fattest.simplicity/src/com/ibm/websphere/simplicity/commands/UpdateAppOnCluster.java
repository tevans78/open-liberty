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
 * Updates all cluster members about the application config changes.
 *   'ApplicationNames': Names of applications that are modified.
 *   'timeout': Timeout value for each node update.
 * The required parameters are found in the constructor.
 */
public class UpdateAppOnCluster extends Command {

	private String __target;
	private java.lang.String[] ApplicationNames;
	private Integer timeout = 300;

	public UpdateAppOnCluster(String commandTarget, java.lang.String[] ApplicationNames) {
		super("updateAppOnCluster");
		this.__target = commandTarget;
		this.ApplicationNames = ApplicationNames;
	}

	/**
	 * Names of applications that are modified.
	 */
	public java.lang.String[] getApplicationNames() {
		return this.ApplicationNames;
	}

	/**
	 * Names of applications that are modified.
	 */
	public void setApplicationNames(java.lang.String[] value) {
		this.ApplicationNames = value;
	}

	/**
	 * Timeout value for each node update.
	 */
	public Integer getTimeout() {
		return this.timeout;
	}

	/**
	 * Timeout value for each node update.
	 */
	public void setTimeout(Integer value) {
		this.timeout = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("ApplicationNames", this.ApplicationNames);
		if (this.timeout != null) {
			ret.put("timeout", this.timeout);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
