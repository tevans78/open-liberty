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

package com.ibm.websphere.simplicity.commands.sibadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Ensures that a messaging engines core group policy conforms to its associated bus members messaging engine assistance policy.
 *   'name': The name of the messaging engine to correct the core group policy for.
 * The required parameters are found in the constructor.
 */
public class CorrectSIBEnginePolicy extends Command {

	private String name;

	public CorrectSIBEnginePolicy(String name) {
		super("correctSIBEnginePolicy");
		this.name = name;
	}

	/**
	 * The name of the messaging engine to correct the core group policy for.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the messaging engine to correct the core group policy for.
	 */
	public void setName(String value) {
		this.name = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
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
