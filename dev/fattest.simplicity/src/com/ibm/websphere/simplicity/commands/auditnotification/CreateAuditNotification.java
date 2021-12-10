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
 * Configures an audit notification.
 *   'sendEmail': Flag indicating if notification is emailed.
 *   'logToSystemOut': Flag indicating if notification is logged to system out.
 *   'emailFormat': Specify html to email the content in html format or specify text to send it in text format.
 *   'notificationName': Supply a unique name for the audit notification.
 *   'emailList': Supply an email list or distribution email list to which to send audit notifications.
 * The required parameters are found in the constructor.
 */
public class CreateAuditNotification extends Command {

	private Boolean sendEmail;
	private Boolean logToSystemOut;
	private String emailFormat;
	private String notificationName;
	private String emailList;

	public CreateAuditNotification(Boolean sendEmail, Boolean logToSystemOut, String notificationName) {
		super("createAuditNotification");
		this.sendEmail = sendEmail;
		this.logToSystemOut = logToSystemOut;
		this.notificationName = notificationName;
	}

	/**
	 * Flag indicating if notification is emailed.
	 */
	public Boolean getSendEmail() {
		return this.sendEmail;
	}

	/**
	 * Flag indicating if notification is emailed.
	 */
	public void setSendEmail(Boolean value) {
		this.sendEmail = value;
	}

	/**
	 * Flag indicating if notification is logged to system out.
	 */
	public Boolean getLogToSystemOut() {
		return this.logToSystemOut;
	}

	/**
	 * Flag indicating if notification is logged to system out.
	 */
	public void setLogToSystemOut(Boolean value) {
		this.logToSystemOut = value;
	}

	/**
	 * Specify html to email the content in html format or specify text to send it in text format.
	 */
	public String getEmailFormat() {
		return this.emailFormat;
	}

	/**
	 * Specify html to email the content in html format or specify text to send it in text format.
	 */
	public void setEmailFormat(String value) {
		this.emailFormat = value;
	}

	/**
	 * Supply a unique name for the audit notification.
	 */
	public String getNotificationName() {
		return this.notificationName;
	}

	/**
	 * Supply a unique name for the audit notification.
	 */
	public void setNotificationName(String value) {
		this.notificationName = value;
	}

	/**
	 * Supply an email list or distribution email list to which to send audit notifications.
	 */
	public String getEmailList() {
		return this.emailList;
	}

	/**
	 * Supply an email list or distribution email list to which to send audit notifications.
	 */
	public void setEmailList(String value) {
		this.emailList = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("sendEmail", this.sendEmail);
		ret.put("logToSystemOut", this.logToSystemOut);
		if (this.emailFormat != null) {
			ret.put("emailFormat", this.emailFormat);
		}
		ret.put("notificationName", this.notificationName);
		if (this.emailList != null) {
			ret.put("emailList", this.emailList);
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
