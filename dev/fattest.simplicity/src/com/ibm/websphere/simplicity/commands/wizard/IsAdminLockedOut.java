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

package com.ibm.websphere.simplicity.commands.wizard;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Checks to make sure that at least one admin user in the admin-authz.xml file exists in the input user registry.
 *   'registryType': Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
 * The required parameters are found in the constructor.
 */
public class IsAdminLockedOut extends Command {

	private String registryType;

	public IsAdminLockedOut(String registryType) {
		super("isAdminLockedOut");
		this.registryType = registryType;
	}

	/**
	 * Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
	 */
	public String getRegistryType() {
		return this.registryType;
	}

	/**
	 * Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
	 */
	public void setRegistryType(String value) {
		this.registryType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("registryType", this.registryType);
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
