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

package com.ibm.websphere.simplicity.commands.app;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List the serialized SQLJ profiles that are in an installed application.
 *   'appName': The name of an installed application that contains the SQLJ profiles to be processed.
 * The required parameters are found in the constructor.
 */
public class ListSqljProfiles extends Command {

	private String appName;

	public ListSqljProfiles(String appName) {
		super("listSqljProfiles");
		this.appName = appName;
	}

	/**
	 * The name of an installed application that contains the SQLJ profiles to be processed.
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * The name of an installed application that contains the SQLJ profiles to be processed.
	 */
	public void setAppName(String value) {
		this.appName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("appName", this.appName);
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
