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

package com.ibm.websphere.simplicity.commands.dpmanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use the dpUnmanageDomain command to remove the domain from the managed set, and to stop managing the domain.
 *   'msDomainId': Specifies the ID of the managed domain of interest in the DataPower appliance manager.
 *   'clean': Deletes the domain from each appliance in the managed set.
 * The required parameters are found in the constructor.
 */
public class DpUnmanageDomain extends Command {

	private String msDomainId;
	private String clean;

	public DpUnmanageDomain(String msDomainId) {
		super("dpUnmanageDomain");
		this.msDomainId = msDomainId;
	}

	/**
	 * Specifies the ID of the managed domain of interest in the DataPower appliance manager.
	 */
	public String getMsDomainId() {
		return this.msDomainId;
	}

	/**
	 * Specifies the ID of the managed domain of interest in the DataPower appliance manager.
	 */
	public void setMsDomainId(String value) {
		this.msDomainId = value;
	}

	/**
	 * Deletes the domain from each appliance in the managed set.
	 */
	public String getClean() {
		return this.clean;
	}

	/**
	 * Deletes the domain from each appliance in the managed set.
	 */
	public void setClean(String value) {
		this.clean = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("msDomainId", this.msDomainId);
		if (this.clean != null) {
			ret.put("clean", this.clean);
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
