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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Generate profile key
 *   'properties': Properties
 * The required parameters are found in the constructor.
 */
public class GenerateProfileKey extends Command {

	private java.util.Properties properties;

	public GenerateProfileKey(java.util.Properties properties) {
		super("generateProfileKey");
		this.properties = properties;
	}

	/**
	 * Properties
	 */
	public java.util.Properties getProperties() {
		return this.properties;
	}

	/**
	 * Properties
	 */
	public void setProperties(java.util.Properties value) {
		this.properties = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("properties", this.properties);
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
