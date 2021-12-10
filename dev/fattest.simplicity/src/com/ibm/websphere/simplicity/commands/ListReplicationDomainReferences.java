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

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List search object that participates in a specific data replication domain.  An object participates in a data replication domain if the object references the provided data replication domain name.  The command returns the objects that reference the data replication domain name regardless of whether replication is enabled or disabled for that object.
 *   'dataReplicationDomainName': Specifies the name of the data replication domain to use to query for objects that participate in the data replication domain.
 * The required parameters are found in the constructor.
 */
public class ListReplicationDomainReferences extends Command {

	private String dataReplicationDomainName;

	public ListReplicationDomainReferences(String dataReplicationDomainName) {
		super("listReplicationDomainReferences");
		this.dataReplicationDomainName = dataReplicationDomainName;
	}

	/**
	 * Specifies the name of the data replication domain to use to query for objects that participate in the data replication domain.
	 */
	public String getDataReplicationDomainName() {
		return this.dataReplicationDomainName;
	}

	/**
	 * Specifies the name of the data replication domain to use to query for objects that participate in the data replication domain.
	 */
	public void setDataReplicationDomainName(String value) {
		this.dataReplicationDomainName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("dataReplicationDomainName", this.dataReplicationDomainName);
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
