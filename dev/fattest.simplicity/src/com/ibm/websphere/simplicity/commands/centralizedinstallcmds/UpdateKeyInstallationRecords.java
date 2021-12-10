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

package com.ibm.websphere.simplicity.commands.centralizedinstallcmds;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates the SSH public key installation records for specified targets. Use this command to update the key installation records if keys were added or removed using methods unknown to the centralized installation manager.
 *   'add': Specifies a comma-separated list of domain-qualified hostnames to be added to the installation records.
 *   'remove': Specifies a comma-separated list of domain-qualified hostnames to be removed from the installation records.
 * The required parameters are found in the constructor.
 */
public class UpdateKeyInstallationRecords extends Command {

	private String add;
	private String remove;

	public UpdateKeyInstallationRecords() {
		super("updateKeyInstallationRecords");
	}

	/**
	 * Specifies a comma-separated list of domain-qualified hostnames to be added to the installation records.
	 */
	public String getAdd() {
		return this.add;
	}

	/**
	 * Specifies a comma-separated list of domain-qualified hostnames to be added to the installation records.
	 */
	public void setAdd(String value) {
		this.add = value;
	}

	/**
	 * Specifies a comma-separated list of domain-qualified hostnames to be removed from the installation records.
	 */
	public String getRemove() {
		return this.remove;
	}

	/**
	 * Specifies a comma-separated list of domain-qualified hostnames to be removed from the installation records.
	 */
	public void setRemove(String value) {
		this.remove = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.add != null) {
			ret.put("add", this.add);
		}
		if (this.remove != null) {
			ret.put("remove", this.remove);
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
