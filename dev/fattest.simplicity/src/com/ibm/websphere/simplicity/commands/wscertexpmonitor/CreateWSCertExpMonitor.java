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
 * Create a certificate expiration monitor.
 *   'name': Specifies the certificate expiration monitor name.
 *   'wsNotificationName': Specifies the name of the notification to use during expiration monitoring.
 *   'wsScheduleName': Specifies the name of the schedule used to run certificate expiration monitoring.
 *   'daysBeforeNotification': Specify the number of days to issue a warning about certificate expiration.
 *   'autoReplace': Specify true to automatically replace certificate during expiration monitoring, false otherwise.
 *   'deleteOld': Specify true to delete old certificates during expiration monitoring, false to not delete old certificates.
 *   'isEnabled': Specify true to enable the certificate expiration monitor, false to disable the certificate expiration monitor.
 * The required parameters are found in the constructor.
 */
public class CreateWSCertExpMonitor extends Command {

	private String name;
	private String wsNotificationName;
	private String wsScheduleName;
	private Integer daysBeforeNotification;
	private Boolean autoReplace;
	private Boolean deleteOld;
	private Boolean isEnabled;

	public CreateWSCertExpMonitor(String name, String wsNotificationName, String wsScheduleName, Integer daysBeforeNotification, Boolean autoReplace, Boolean deleteOld) {
		super("createWSCertExpMonitor");
		this.name = name;
		this.wsNotificationName = wsNotificationName;
		this.wsScheduleName = wsScheduleName;
		this.daysBeforeNotification = daysBeforeNotification;
		this.autoReplace = autoReplace;
		this.deleteOld = deleteOld;
	}

	/**
	 * Specifies the certificate expiration monitor name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies the certificate expiration monitor name.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the name of the notification to use during expiration monitoring.
	 */
	public String getWsNotificationName() {
		return this.wsNotificationName;
	}

	/**
	 * Specifies the name of the notification to use during expiration monitoring.
	 */
	public void setWsNotificationName(String value) {
		this.wsNotificationName = value;
	}

	/**
	 * Specifies the name of the schedule used to run certificate expiration monitoring.
	 */
	public String getWsScheduleName() {
		return this.wsScheduleName;
	}

	/**
	 * Specifies the name of the schedule used to run certificate expiration monitoring.
	 */
	public void setWsScheduleName(String value) {
		this.wsScheduleName = value;
	}

	/**
	 * Specify the number of days to issue a warning about certificate expiration.
	 */
	public Integer getDaysBeforeNotification() {
		return this.daysBeforeNotification;
	}

	/**
	 * Specify the number of days to issue a warning about certificate expiration.
	 */
	public void setDaysBeforeNotification(Integer value) {
		this.daysBeforeNotification = value;
	}

	/**
	 * Specify true to automatically replace certificate during expiration monitoring, false otherwise.
	 */
	public Boolean getAutoReplace() {
		return this.autoReplace;
	}

	/**
	 * Specify true to automatically replace certificate during expiration monitoring, false otherwise.
	 */
	public void setAutoReplace(Boolean value) {
		this.autoReplace = value;
	}

	/**
	 * Specify true to delete old certificates during expiration monitoring, false to not delete old certificates.
	 */
	public Boolean getDeleteOld() {
		return this.deleteOld;
	}

	/**
	 * Specify true to delete old certificates during expiration monitoring, false to not delete old certificates.
	 */
	public void setDeleteOld(Boolean value) {
		this.deleteOld = value;
	}

	/**
	 * Specify true to enable the certificate expiration monitor, false to disable the certificate expiration monitor.
	 */
	public Boolean getIsEnabled() {
		return this.isEnabled;
	}

	/**
	 * Specify true to enable the certificate expiration monitor, false to disable the certificate expiration monitor.
	 */
	public void setIsEnabled(Boolean value) {
		this.isEnabled = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("wsNotificationName", this.wsNotificationName);
		ret.put("wsScheduleName", this.wsScheduleName);
		ret.put("daysBeforeNotification", this.daysBeforeNotification);
		ret.put("autoReplace", this.autoReplace);
		ret.put("deleteOld", this.deleteOld);
		if (this.isEnabled != null) {
			ret.put("isEnabled", this.isEnabled);
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
