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

package com.ibm.websphere.simplicity.commands.administrativejobs;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Query for previously submitted jobs.
 *   'query': String representation of the search query.
 *   'maxReturn': Maximum number of matches to return.
 * The required parameters are found in the constructor.
 */
public class QueryJobs extends Command {

	private String query;
	private java.lang.Integer maxReturn;

	public QueryJobs(String query, java.lang.Integer maxReturn) {
		super("queryJobs");
		this.query = query;
		this.maxReturn = maxReturn;
	}

	/**
	 * String representation of the search query.
	 */
	public String getQuery() {
		return this.query;
	}

	/**
	 * String representation of the search query.
	 */
	public void setQuery(String value) {
		this.query = value;
	}

	/**
	 * Maximum number of matches to return.
	 */
	public java.lang.Integer getMaxReturn() {
		return this.maxReturn;
	}

	/**
	 * Maximum number of matches to return.
	 */
	public void setMaxReturn(java.lang.Integer value) {
		this.maxReturn = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("query", this.query);
		ret.put("maxReturn", this.maxReturn);
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
