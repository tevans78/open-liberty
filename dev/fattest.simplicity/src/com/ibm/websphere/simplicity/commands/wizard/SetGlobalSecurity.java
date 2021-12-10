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

package com.ibm.websphere.simplicity.commands.wizard;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The administrative security field in the security.xml file is updated based on the user input of true or false.
 *   'enabled': Supply value for Global Security Setting: true/false.
 * The required parameters are found in the constructor.
 */
public class SetGlobalSecurity extends Command {

	private Boolean enabled;

	public SetGlobalSecurity(Boolean enabled) {
		super("setGlobalSecurity");
		this.enabled = enabled;
	}

	/**
	 * Supply value for Global Security Setting: true/false.
	 */
	public Boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * Supply value for Global Security Setting: true/false.
	 */
	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("enabled", this.enabled);
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
