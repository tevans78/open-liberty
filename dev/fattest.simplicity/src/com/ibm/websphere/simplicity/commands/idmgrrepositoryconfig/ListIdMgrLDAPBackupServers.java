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

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists the backup LDAP servers.
 *   'id': The unique identifier of the repository.
 *   'primary_host': Primary host of the LDAP server.
 * The required parameters are found in the constructor.
 */
public class ListIdMgrLDAPBackupServers extends Command {

	private String id;
	private String primary_host;

	public ListIdMgrLDAPBackupServers(String id, String primary_host) {
		super("listIdMgrLDAPBackupServers");
		this.id = id;
		this.primary_host = primary_host;
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

	/**
	 * Primary host of the LDAP server.
	 */
	public String getPrimary_host() {
		return this.primary_host;
	}

	/**
	 * Primary host of the LDAP server.
	 */
	public void setPrimary_host(String value) {
		this.primary_host = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("id", this.id);
		ret.put("primary_host", this.primary_host);
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
