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

package com.ibm.websphere.simplicity.commands.coregroupbridge;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command creates a default core group access point for the specified core group and adds it to the default access point group.
 *   'coreGroupName': Name of the Core group for which the core group access point will be created.
 * The required parameters are found in the constructor.
 */
public class CreateCoreGroupAccessPoint extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String coreGroupName;

	public CreateCoreGroupAccessPoint(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String coreGroupName) {
		super("createCoreGroupAccessPoint");
		this.__target = commandTarget;
		this.coreGroupName = coreGroupName;
	}

	/**
	 * Name of the Core group for which the core group access point will be created.
	 */
	public String getCoreGroupName() {
		return this.coreGroupName;
	}

	/**
	 * Name of the Core group for which the core group access point will be created.
	 */
	public void setCoreGroupName(String value) {
		this.coreGroupName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("coreGroupName", this.coreGroupName);
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
