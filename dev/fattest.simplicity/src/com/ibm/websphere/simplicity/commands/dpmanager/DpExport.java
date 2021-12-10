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
 * Use the dpExport command to export the DataPower appliance manager configuration and versions.
 *   'file': Specifies the DataPower appliance manager system file that will contain the exported configuration and versions.
 * The required parameters are found in the constructor.
 */
public class DpExport extends Command {

	private String file;

	public DpExport(String file) {
		super("dpExport");
		this.file = file;
	}

	/**
	 * Specifies the DataPower appliance manager system file that will contain the exported configuration and versions.
	 */
	public String getFile() {
		return this.file;
	}

	/**
	 * Specifies the DataPower appliance manager system file that will contain the exported configuration and versions.
	 */
	public void setFile(String value) {
		this.file = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("file", this.file);
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
