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

package com.ibm.websphere.simplicity.commands.profile;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * AddAdminIdToUserRegObjCmdDesc
 *   'registryType': Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
 *   'adminUser': Supply an administrative user name.
 * The required parameters are found in the constructor.
 */
public class AddAdminIdToUserRegObj extends Command {

	private String registryType;
	private String adminUser;

	public AddAdminIdToUserRegObj(String registryType, String adminUser) {
		super("addAdminIdToUserRegObj");
		this.registryType = registryType;
		this.adminUser = adminUser;
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

	/**
	 * Supply an administrative user name.
	 */
	public String getAdminUser() {
		return this.adminUser;
	}

	/**
	 * Supply an administrative user name.
	 */
	public void setAdminUser(String value) {
		this.adminUser = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("registryType", this.registryType);
		ret.put("adminUser", this.adminUser);
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
