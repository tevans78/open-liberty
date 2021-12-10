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
 * List the J2C administrative objects that have a specified administrative object interface defined in the specified J2C resource adapter.
 *   'adminObjectInterface': An administrative object factory interface of the J2C administrative object to list.
 * The required parameters are found in the constructor.
 */
public class ListJ2CAdminObjects extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String adminObjectInterface;

	public ListJ2CAdminObjects(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String adminObjectInterface) {
		super("listJ2CAdminObjects");
		this.__target = commandTarget;
		this.adminObjectInterface = adminObjectInterface;
	}

	/**
	 * An administrative object factory interface of the J2C administrative object to list.
	 */
	public String getAdminObjectInterface() {
		return this.adminObjectInterface;
	}

	/**
	 * An administrative object factory interface of the J2C administrative object to list.
	 */
	public void setAdminObjectInterface(String value) {
		this.adminObjectInterface = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("adminObjectInterface", this.adminObjectInterface);
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
