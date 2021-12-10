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
 * Add a configuration group.
 *   'groupPath': Path of group names to the desired group.
 * The required parameters are found in the constructor.
 */
public class AddSTSConfigurationGroup extends Command {

	private String __target;
	private java.lang.String[] groupPath;

	public AddSTSConfigurationGroup(String commandTarget) {
		super("addSTSConfigurationGroup");
		this.__target = commandTarget;
	}

	/**
	 * Path of group names to the desired group.
	 */
	public java.lang.String[] getGroupPath() {
		return this.groupPath;
	}

	/**
	 * Path of group names to the desired group.
	 */
	public void setGroupPath(java.lang.String[] value) {
		this.groupPath = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.groupPath != null) {
			ret.put("groupPath", this.groupPath);
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
