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
 * Set the value for a variable. A variable is a configuration property that can be used to provide a parameter for some values in the system.
 *   'scope': Scope of the variable definition.  &lt;Cell | Node | Server | Application | Cluster&gt; default: Cell.
 *   'variableName': The name of the variable.
 *   'variableValue': The value of the variable.
 *   'variableDescription': The description of the variable.
 * The required parameters are found in the constructor.
 */
public class SetVariable extends Command {

	private String scope;
	private String variableName;
	private String variableValue;
	private String variableDescription;

	public SetVariable(String variableName) {
		super("setVariable");
		this.variableName = variableName;
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

	/**
	 * The value of the variable.
	 */
	public String getVariableValue() {
		return this.variableValue;
	}

	/**
	 * The value of the variable.
	 */
	public void setVariableValue(String value) {
		this.variableValue = value;
	}

	/**
	 * The description of the variable.
	 */
	public String getVariableDescription() {
		return this.variableDescription;
	}

	/**
	 * The description of the variable.
	 */
	public void setVariableDescription(String value) {
		this.variableDescription = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scope != null) {
			ret.put("scope", this.scope);
		}
		ret.put("variableName", this.variableName);
		if (this.variableValue != null) {
			ret.put("variableValue", this.variableValue);
		}
		if (this.variableDescription != null) {
			ret.put("variableDescription", this.variableDescription);
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
