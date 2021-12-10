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
import java.util.ArrayList;
import com.ibm.websphere.simplicity.commands.CommandStep;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Get the available JMS connection factories
 * The required parameters are found in the constructor.
 */
public class DeleteJMSObject extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private List<Command> __steps;
	public DeleteJMSObject(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("deleteJMSObject");
		this.__target = commandTarget;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
	}

	public List<Command> __getSteps() {
		return this.__steps;
	}

	/**
	 * Executes the command against the specified scope.
	 * Steps are required by this command, and they appear after the scope parameter.
	 * Classes for these steps are statically available through this admin command class.
	 */
	public OperationResults<Object> run(Scope scope, DeleteSIBJMSObject deleteSIBJMSObject) throws Exception {
		this.__steps = new ArrayList<Command>();
		if (deleteSIBJMSObject != null)
			this.__steps.add(deleteSIBJMSObject);
		return super.run(scope);
	}

	/**
	 * 
	 * The required parameters are found in the constructor.
	 */
	public static class DeleteSIBJMSObject extends CommandStep {

		public DeleteSIBJMSObject() {
			super("deleteSIBJMSObject");
		}

		public Properties __getParameters() {
			Properties ret = new Properties();
			return ret;
		}

	}
}
