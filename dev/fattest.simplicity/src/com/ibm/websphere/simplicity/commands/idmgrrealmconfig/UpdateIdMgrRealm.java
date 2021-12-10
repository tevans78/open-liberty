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

package com.ibm.websphere.simplicity.commands.idmgrrealmconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates the configuration of the specified realm.
 *   'allowOperationIfReposDown': Whether to allow operation if a repository is down.  Default value is false.
 *   'delimiter': Delimiter used for this realm
 *   'name': Name of the realm
 *   'securityUse': A string that indicates if this realm is currently used in security, currently not used in security, but used later, or is never used in security. Acceptable values include 'active', 'inactive', 'notSelectable'.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrRealm extends Command {

	private Boolean allowOperationIfReposDown;
	private String delimiter;
	private String name;
	private String securityUse;

	public UpdateIdMgrRealm(String name) {
		super("updateIdMgrRealm");
		this.name = name;
	}

	/**
	 * Whether to allow operation if a repository is down.  Default value is false.
	 */
	public Boolean getAllowOperationIfReposDown() {
		return this.allowOperationIfReposDown;
	}

	/**
	 * Whether to allow operation if a repository is down.  Default value is false.
	 */
	public void setAllowOperationIfReposDown(Boolean value) {
		this.allowOperationIfReposDown = value;
	}

	/**
	 * Delimiter used for this realm
	 */
	public String getDelimiter() {
		return this.delimiter;
	}

	/**
	 * Delimiter used for this realm
	 */
	public void setDelimiter(String value) {
		this.delimiter = value;
	}

	/**
	 * Name of the realm
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the realm
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * A string that indicates if this realm is currently used in security, currently not used in security, but used later, or is never used in security. Acceptable values include 'active', 'inactive', 'notSelectable'.
	 */
	public String getSecurityUse() {
		return this.securityUse;
	}

	/**
	 * A string that indicates if this realm is currently used in security, currently not used in security, but used later, or is never used in security. Acceptable values include 'active', 'inactive', 'notSelectable'.
	 */
	public void setSecurityUse(String value) {
		this.securityUse = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.allowOperationIfReposDown != null) {
			ret.put("allowOperationIfReposDown", this.allowOperationIfReposDown);
		}
		if (this.delimiter != null) {
			ret.put("delimiter", this.delimiter);
		}
		ret.put("name", this.name);
		if (this.securityUse != null) {
			ret.put("securityUse", this.securityUse);
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
