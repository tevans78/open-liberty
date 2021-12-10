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
 * Validates the existence of the administrator name in the input user registry.
 *   'ldapServerType': Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
 *   'registryType': Supply a valid user registry type.  Valid types are: LDAPUserRegistry, CustomUserRegistry, WIMUserRegistry, and LocalOSUserRegistry.
 *   'adminUser': Supply an administrative user name.
 * The required parameters are found in the constructor.
 */
public class ValidateAdminName extends Command {

	private String ldapServerType;
	private String registryType;
	private String adminUser;

	public ValidateAdminName(String registryType, String adminUser) {
		super("validateAdminName");
		this.registryType = registryType;
		this.adminUser = adminUser;
	}

	/**
	 * Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
	 */
	public String getLdapServerType() {
		return this.ldapServerType;
	}

	/**
	 * Supply a valid LDAP Server type.  Valid values are: IBM_DIRECTORY_SERVER, IPLANET, NETSCAPE, NDS, DOMINO502, SECUREWAY, ACTIVE_DIRECTORY, CUSTOM
	 */
	public void setLdapServerType(String value) {
		this.ldapServerType = value;
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
		if (this.ldapServerType != null) {
			ret.put("ldapServerType", this.ldapServerType);
		}
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
