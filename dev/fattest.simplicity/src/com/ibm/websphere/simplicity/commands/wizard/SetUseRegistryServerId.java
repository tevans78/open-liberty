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
 * The useRegistryServerId security field in userRegistry object in the security.xml file is updated based on the user input of true or false.
 *   'userRegistryType': Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
 *   'useRegistryServerId': Supply value for useRegistryServerId Setting: true/false.
 * The required parameters are found in the constructor.
 */
public class SetUseRegistryServerId extends Command {

	private String userRegistryType;
	private Boolean useRegistryServerId;

	public SetUseRegistryServerId(String userRegistryType, Boolean useRegistryServerId) {
		super("setUseRegistryServerId");
		this.userRegistryType = userRegistryType;
		this.useRegistryServerId = useRegistryServerId;
	}

	/**
	 * Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
	 */
	public String getUserRegistryType() {
		return this.userRegistryType;
	}

	/**
	 * Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
	 */
	public void setUserRegistryType(String value) {
		this.userRegistryType = value;
	}

	/**
	 * Supply value for useRegistryServerId Setting: true/false.
	 */
	public Boolean getUseRegistryServerId() {
		return this.useRegistryServerId;
	}

	/**
	 * Supply value for useRegistryServerId Setting: true/false.
	 */
	public void setUseRegistryServerId(Boolean value) {
		this.useRegistryServerId = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("userRegistryType", this.userRegistryType);
		ret.put("useRegistryServerId", this.useRegistryServerId);
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
