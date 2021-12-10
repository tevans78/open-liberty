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
 * Security registration for base and admin agent.
 *   'profilePath': Profile path for the appserver node being registered.
 * The required parameters are found in the constructor.
 */
public class BaseToAgentRegistrationAfterStart extends Command {

	private String profilePath;

	public BaseToAgentRegistrationAfterStart(String profilePath) {
		super("baseToAgentRegistrationAfterStart");
		this.profilePath = profilePath;
	}

	/**
	 * Profile path for the appserver node being registered.
	 */
	public String getProfilePath() {
		return this.profilePath;
	}

	/**
	 * Profile path for the appserver node being registered.
	 */
	public void setProfilePath(String value) {
		this.profilePath = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("profilePath", this.profilePath);
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
