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
 * List J2C connection factories that have a specified connection factory interface defined in the specified J2C resource adapter.
 *   'connectionFactoryInterface': A connection factory interface of the J2C connection factory to list.
 * The required parameters are found in the constructor.
 */
public class ListJ2CConnectionFactories extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String connectionFactoryInterface;

	public ListJ2CConnectionFactories(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String connectionFactoryInterface) {
		super("listJ2CConnectionFactories");
		this.__target = commandTarget;
		this.connectionFactoryInterface = connectionFactoryInterface;
	}

	/**
	 * A connection factory interface of the J2C connection factory to list.
	 */
	public String getConnectionFactoryInterface() {
		return this.connectionFactoryInterface;
	}

	/**
	 * A connection factory interface of the J2C connection factory to list.
	 */
	public void setConnectionFactoryInterface(String value) {
		this.connectionFactoryInterface = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("connectionFactoryInterface", this.connectionFactoryInterface);
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
