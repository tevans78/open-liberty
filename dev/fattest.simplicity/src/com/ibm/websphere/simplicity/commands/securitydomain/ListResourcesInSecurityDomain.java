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

package com.ibm.websphere.simplicity.commands.securitydomain;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List all resources mapped to the specified security domain.
 *   'securityDomainName': Name used to uniquely identify the security domain.
 *   'expandCell': Specify true to expand a cell resource to list all the servers in the cell instead of the listing the cell itself.
 * The required parameters are found in the constructor.
 */
public class ListResourcesInSecurityDomain extends Command {

	private String securityDomainName;
	private Boolean expandCell = false;

	public ListResourcesInSecurityDomain(String securityDomainName) {
		super("listResourcesInSecurityDomain");
		this.securityDomainName = securityDomainName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public String getSecurityDomainName() {
		return this.securityDomainName;
	}

	/**
	 * Name used to uniquely identify the security domain.
	 */
	public void setSecurityDomainName(String value) {
		this.securityDomainName = value;
	}

	/**
	 * Specify true to expand a cell resource to list all the servers in the cell instead of the listing the cell itself.
	 */
	public Boolean getExpandCell() {
		return this.expandCell;
	}

	/**
	 * Specify true to expand a cell resource to list all the servers in the cell instead of the listing the cell itself.
	 */
	public void setExpandCell(Boolean value) {
		this.expandCell = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("securityDomainName", this.securityDomainName);
		if (this.expandCell != null) {
			ret.put("expandCell", this.expandCell);
		}
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
