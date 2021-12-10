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

package com.ibm.websphere.simplicity.commands.idmgrconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Dynamically updates the LDAP server bind information. If bindDN is specified bindPassword must be specified. If only id is specified then LDAP server information is refreshed.
 *   'bindDN': The binding distinguished name for the LDAP server.
 *   'bindPassword': The LDAP server binding password.
 *   'id': The unique identifier of the repository.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrLDAPBindInfo extends Command {

	private String bindDN;
	private String bindPassword;
	private String id;

	public UpdateIdMgrLDAPBindInfo(String id) {
		super("updateIdMgrLDAPBindInfo");
		this.id = id;
	}

	/**
	 * The binding distinguished name for the LDAP server.
	 */
	public String getBindDN() {
		return this.bindDN;
	}

	/**
	 * The binding distinguished name for the LDAP server.
	 */
	public void setBindDN(String value) {
		this.bindDN = value;
	}

	/**
	 * The LDAP server binding password.
	 */
	public String getBindPassword() {
		return this.bindPassword;
	}

	/**
	 * The LDAP server binding password.
	 */
	public void setBindPassword(String value) {
		this.bindPassword = value;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.bindDN != null) {
			ret.put("bindDN", this.bindDN);
		}
		if (this.bindPassword != null) {
			ret.put("bindPassword", this.bindPassword);
		}
		ret.put("id", this.id);
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
