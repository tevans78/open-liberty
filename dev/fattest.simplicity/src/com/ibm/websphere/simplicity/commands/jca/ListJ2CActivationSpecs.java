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

package com.ibm.websphere.simplicity.commands.jca;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List the J2C activation specifications that have a specified message listener type defined in the specified J2C resource adapter.
 *   'messageListenerType': A message listener of the J2C activation specification to list.
 * The required parameters are found in the constructor.
 */
public class ListJ2CActivationSpecs extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String messageListenerType;

	public ListJ2CActivationSpecs(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String messageListenerType) {
		super("listJ2CActivationSpecs");
		this.__target = commandTarget;
		this.messageListenerType = messageListenerType;
	}

	/**
	 * A message listener of the J2C activation specification to list.
	 */
	public String getMessageListenerType() {
		return this.messageListenerType;
	}

	/**
	 * A message listener of the J2C activation specification to list.
	 */
	public void setMessageListenerType(String value) {
		this.messageListenerType = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("messageListenerType", this.messageListenerType);
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
