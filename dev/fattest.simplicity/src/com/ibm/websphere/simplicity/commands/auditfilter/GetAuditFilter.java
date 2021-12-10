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

package com.ibm.websphere.simplicity.commands.auditfilter;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Returns an audit specification entry in the audit.xml that matches the reference Id.
 *   'filterRef': Supply a valid audit specification reference.
 * The required parameters are found in the constructor.
 */
public class GetAuditFilter extends Command {

	private String filterRef;

	public GetAuditFilter(String filterRef) {
		super("getAuditFilter");
		this.filterRef = filterRef;
	}

	/**
	 * Supply a valid audit specification reference.
	 */
	public String getFilterRef() {
		return this.filterRef;
	}

	/**
	 * Supply a valid audit specification reference.
	 */
	public void setFilterRef(String value) {
		this.filterRef = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("filterRef", this.filterRef);
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
