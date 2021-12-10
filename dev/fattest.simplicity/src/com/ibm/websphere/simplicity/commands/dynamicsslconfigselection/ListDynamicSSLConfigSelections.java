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

package com.ibm.websphere.simplicity.commands.dynamicsslconfigselection;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List all Dynamic SSL configuration selections.
 *   'scopeName': Specifies the management scope.
 *   'all': Specify true to list all dynamic SSL configuration selections.  True overrides the scopeName parameter.
 * The required parameters are found in the constructor.
 */
public class ListDynamicSSLConfigSelections extends Command {

	private String scopeName;
	private Boolean all = false;

	public ListDynamicSSLConfigSelections() {
		super("listDynamicSSLConfigSelections");
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specify true to list all dynamic SSL configuration selections.  True overrides the scopeName parameter.
	 */
	public Boolean getAll() {
		return this.all;
	}

	/**
	 * Specify true to list all dynamic SSL configuration selections.  True overrides the scopeName parameter.
	 */
	public void setAll(Boolean value) {
		this.all = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		if (this.all != null) {
			ret.put("all", this.all);
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
