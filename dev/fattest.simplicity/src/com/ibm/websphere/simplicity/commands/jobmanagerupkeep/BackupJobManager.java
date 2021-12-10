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

package com.ibm.websphere.simplicity.commands.jobmanagerupkeep;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Backs up the job manager database to a specified location.
 *   'location': Location of the file.
 *   'force': If the file already exists, force the new file to overwrite the existing file.
 * The required parameters are found in the constructor.
 */
public class BackupJobManager extends Command {

	private String location;
	private Boolean force = false;

	public BackupJobManager() {
		super("backupJobManager");
	}

	/**
	 * Location of the file.
	 */
	public String getLocation() {
		return this.location;
	}

	/**
	 * Location of the file.
	 */
	public void setLocation(String value) {
		this.location = value;
	}

	/**
	 * If the file already exists, force the new file to overwrite the existing file.
	 */
	public Boolean getForce() {
		return this.force;
	}

	/**
	 * If the file already exists, force the new file to overwrite the existing file.
	 */
	public void setForce(Boolean value) {
		this.force = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.location != null) {
			ret.put("location", this.location);
		}
		if (this.force != null) {
			ret.put("force", this.force);
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
