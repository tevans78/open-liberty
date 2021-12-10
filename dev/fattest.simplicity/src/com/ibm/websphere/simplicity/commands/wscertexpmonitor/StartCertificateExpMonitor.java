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

package com.ibm.websphere.simplicity.commands.wscertexpmonitor;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Start the Certificate Expiration Monitor.
 *   'ExpMonitorSaveConfig': Automatically save the changed key stores and configurations when the Certificate Expiration Monitor.
 * The required parameters are found in the constructor.
 */
public class StartCertificateExpMonitor extends Command {

	private Boolean ExpMonitorSaveConfig;

	public StartCertificateExpMonitor() {
		super("startCertificateExpMonitor");
	}

	/**
	 * Automatically save the changed key stores and configurations when the Certificate Expiration Monitor.
	 */
	public Boolean getExpMonitorSaveConfig() {
		return this.ExpMonitorSaveConfig;
	}

	/**
	 * Automatically save the changed key stores and configurations when the Certificate Expiration Monitor.
	 */
	public void setExpMonitorSaveConfig(Boolean value) {
		this.ExpMonitorSaveConfig = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.ExpMonitorSaveConfig != null) {
			ret.put("ExpMonitorSaveConfig", this.ExpMonitorSaveConfig);
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
