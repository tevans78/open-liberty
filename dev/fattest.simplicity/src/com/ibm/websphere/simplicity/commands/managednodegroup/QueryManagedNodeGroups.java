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

package com.ibm.websphere.simplicity.commands.managednodegroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command is used to query groups of Managed Nodes.
 *   'query': String representation of the search query.
 *   'maxReturn': Maximum size of data retrieved.
 *   'validate': Validate query string.
 * The required parameters are found in the constructor.
 */
public class QueryManagedNodeGroups extends Command {

	private java.lang.String query;
	private java.lang.Integer maxReturn;
	private Boolean validate = true;

	public QueryManagedNodeGroups(java.lang.Integer maxReturn) {
		super("queryManagedNodeGroups");
		this.maxReturn = maxReturn;
	}

	/**
	 * String representation of the search query.
	 */
	public java.lang.String getQuery() {
		return this.query;
	}

	/**
	 * String representation of the search query.
	 */
	public void setQuery(java.lang.String value) {
		this.query = value;
	}

	/**
	 * Maximum size of data retrieved.
	 */
	public java.lang.Integer getMaxReturn() {
		return this.maxReturn;
	}

	/**
	 * Maximum size of data retrieved.
	 */
	public void setMaxReturn(java.lang.Integer value) {
		this.maxReturn = value;
	}

	/**
	 * Validate query string.
	 */
	public Boolean getValidate() {
		return this.validate;
	}

	/**
	 * Validate query string.
	 */
	public void setValidate(Boolean value) {
		this.validate = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.query != null) {
			ret.put("query", this.query);
		}
		ret.put("maxReturn", this.maxReturn);
		if (this.validate != null) {
			ret.put("validate", this.validate);
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
