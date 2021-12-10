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
 *   'removeSigners': True if root signers from the Node and Admin Agent are to be removed from the Key Stores.  Default set to False.
 *   'profilePath': Profile path for the appserver node being registered.
 * The required parameters are found in the constructor.
 */
public class BaseToAgentRegistration extends Command {

	private Boolean removeSigners = false;
	private String profilePath;

	public BaseToAgentRegistration(String profilePath) {
		super("baseToAgentRegistration");
		this.profilePath = profilePath;
	}

	/**
	 * True if root signers from the Node and Admin Agent are to be removed from the Key Stores.  Default set to False.
	 */
	public Boolean getRemoveSigners() {
		return this.removeSigners;
	}

	/**
	 * True if root signers from the Node and Admin Agent are to be removed from the Key Stores.  Default set to False.
	 */
	public void setRemoveSigners(Boolean value) {
		this.removeSigners = value;
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
		if (this.removeSigners != null) {
			ret.put("removeSigners", this.removeSigners);
		}
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
