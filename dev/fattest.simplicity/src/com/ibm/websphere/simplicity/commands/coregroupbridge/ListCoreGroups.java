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
 * Return a collection of core groups that are related to the specified core group.
 *   'cgBridgeSettings': Core group bridge settings object for the cell.
 * The required parameters are found in the constructor.
 */
public class ListCoreGroups extends Command {

	private String __target;
	private com.ibm.websphere.simplicity.ConfigIdentifier cgBridgeSettings;

	public ListCoreGroups(String commandTarget, com.ibm.websphere.simplicity.ConfigIdentifier cgBridgeSettings) {
		super("listCoreGroups");
		this.__target = commandTarget;
		this.cgBridgeSettings = cgBridgeSettings;
	}

	/**
	 * Core group bridge settings object for the cell.
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getCgBridgeSettings() {
		return this.cgBridgeSettings;
	}

	/**
	 * Core group bridge settings object for the cell.
	 */
	public void setCgBridgeSettings(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.cgBridgeSettings = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("cgBridgeSettings", this.cgBridgeSettings);
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
