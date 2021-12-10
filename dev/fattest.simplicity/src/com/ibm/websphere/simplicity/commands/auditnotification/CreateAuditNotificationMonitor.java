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

package com.ibm.websphere.simplicity.commands.auditnotification;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Configures an audit notification monitor.
 *   'notificationRef': Supply a reference to an existing audit notification.
 *   'monitorName': Supply a unique name for the audit notification monitor.
 *   'enable': Supply the enablement flag (true/false).
 * The required parameters are found in the constructor.
 */
public class CreateAuditNotificationMonitor extends Command {

	private String notificationRef;
	private String monitorName;
	private Boolean enable;

	public CreateAuditNotificationMonitor(String notificationRef, String monitorName, Boolean enable) {
		super("createAuditNotificationMonitor");
		this.notificationRef = notificationRef;
		this.monitorName = monitorName;
		this.enable = enable;
	}

	/**
	 * Supply a reference to an existing audit notification.
	 */
	public String getNotificationRef() {
		return this.notificationRef;
	}

	/**
	 * Supply a reference to an existing audit notification.
	 */
	public void setNotificationRef(String value) {
		this.notificationRef = value;
	}

	/**
	 * Supply a unique name for the audit notification monitor.
	 */
	public String getMonitorName() {
		return this.monitorName;
	}

	/**
	 * Supply a unique name for the audit notification monitor.
	 */
	public void setMonitorName(String value) {
		this.monitorName = value;
	}

	/**
	 * Supply the enablement flag (true/false).
	 */
	public Boolean getEnable() {
		return this.enable;
	}

	/**
	 * Supply the enablement flag (true/false).
	 */
	public void setEnable(Boolean value) {
		this.enable = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("notificationRef", this.notificationRef);
		ret.put("monitorName", this.monitorName);
		ret.put("enable", this.enable);
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
