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
 * Use the dpSetManager command to modify the DataPower appliance manager.
 *   'maxVersionsToStore': Specifies the new maximum number of versions to keep.
 *   'versionsDirectory': Specifies the DataPower applicance manager system directory where the manager creates the versions.
 * The required parameters are found in the constructor.
 */
public class DpSetManager extends Command {

	private Integer maxVersionsToStore;
	private String versionsDirectory;

	public DpSetManager() {
		super("dpSetManager");
	}

	/**
	 * Specifies the new maximum number of versions to keep.
	 */
	public Integer getMaxVersionsToStore() {
		return this.maxVersionsToStore;
	}

	/**
	 * Specifies the new maximum number of versions to keep.
	 */
	public void setMaxVersionsToStore(Integer value) {
		this.maxVersionsToStore = value;
	}

	/**
	 * Specifies the DataPower applicance manager system directory where the manager creates the versions.
	 */
	public String getVersionsDirectory() {
		return this.versionsDirectory;
	}

	/**
	 * Specifies the DataPower applicance manager system directory where the manager creates the versions.
	 */
	public void setVersionsDirectory(String value) {
		this.versionsDirectory = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.maxVersionsToStore != null) {
			ret.put("maxVersionsToStore", this.maxVersionsToStore);
		}
		if (this.versionsDirectory != null) {
			ret.put("versionsDirectory", this.versionsDirectory);
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
