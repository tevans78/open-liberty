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
 * Migrates WMM general configuration, supported member types, out-of-the-box member repositories, and LDAP attributes information to virtual member manager configuration.
 *   'wmmConfigPath': WMM configuration path in WAS 5.x driver. e.g. c:\WAS5\config\wmm.
 * The required parameters are found in the constructor.
 */
public class MigrateWMMConfig extends Command {

	private String wmmConfigPath;

	public MigrateWMMConfig(String wmmConfigPath) {
		super("migrateWMMConfig");
		this.wmmConfigPath = wmmConfigPath;
	}

	/**
	 * WMM configuration path in WAS 5.x driver. e.g. c:\WAS5\config\wmm.
	 */
	public String getWmmConfigPath() {
		return this.wmmConfigPath;
	}

	/**
	 * WMM configuration path in WAS 5.x driver. e.g. c:\WAS5\config\wmm.
	 */
	public void setWmmConfigPath(String value) {
		this.wmmConfigPath = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("wmmConfigPath", this.wmmConfigPath);
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
