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

package com.ibm.websphere.simplicity.commands.auditauthorization;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * listAuditUserIDsOfAuthorizationGroupDesc
 *   'authorizationGroupName': Authorization Group
 * The required parameters are found in the constructor.
 */
public class ListAuditUserIDsOfAuthorizationGroup extends Command {

	private String authorizationGroupName = "CellAuthorizationGroup";

	public ListAuditUserIDsOfAuthorizationGroup() {
		super("listAuditUserIDsOfAuthorizationGroup");
	}

	/**
	 * Authorization Group
	 */
	public String getAuthorizationGroupName() {
		return this.authorizationGroupName;
	}

	/**
	 * Authorization Group
	 */
	public void setAuthorizationGroupName(String value) {
		this.authorizationGroupName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.authorizationGroupName != null) {
			ret.put("authorizationGroupName", this.authorizationGroupName);
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
