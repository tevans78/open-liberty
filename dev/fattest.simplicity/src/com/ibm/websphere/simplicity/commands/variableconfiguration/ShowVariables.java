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

package com.ibm.websphere.simplicity.commands.variableconfiguration;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List variable values under a scope.
 *   'scope': Scope of the variable definition.  &lt;Cell | Node | Server | Application | Cluster&gt; default: Cell.
 *   'variableName': The name of the variable.
 * The required parameters are found in the constructor.
 */
public class ShowVariables extends Command {

	private String scope;
	private String variableName;

	public ShowVariables() {
		super("showVariables");
	}

	/**
	 * Scope of the variable definition.  &lt;Cell | Node | Server | Application | Cluster&gt; default: Cell.
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * Scope of the variable definition.  &lt;Cell | Node | Server | Application | Cluster&gt; default: Cell.
	 */
	public void setScope(String value) {
		this.scope = value;
	}

	/**
	 * The name of the variable.
	 */
	public String getVariableName() {
		return this.variableName;
	}

	/**
	 * The name of the variable.
	 */
	public void setVariableName(String value) {
		this.variableName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scope != null) {
			ret.put("scope", this.scope);
		}
		if (this.variableName != null) {
			ret.put("variableName", this.variableName);
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
