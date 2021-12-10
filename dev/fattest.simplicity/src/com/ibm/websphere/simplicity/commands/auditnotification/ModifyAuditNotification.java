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
 * Modifies an audit notification.
 *   'sendEmail': Flag indicating if notification is emailed.
 *   'logToSystemOut': Flag indicating if notification is logged to system out.
 *   'emailList': Supply an email list or distribution email list to which to send audit notifications.
 *   'emailFormat': Specify html to email the content in html format or specify text to send it in text format.
 *   'notificationRef': Supply a reference to an existing audit notification.
 * The required parameters are found in the constructor.
 */
public class ModifyAuditNotification extends Command {

	private Boolean sendEmail;
	private Boolean logToSystemOut;
	private String emailList;
	private String emailFormat;
	private String notificationRef;

	public ModifyAuditNotification(String notificationRef) {
		super("modifyAuditNotification");
		this.notificationRef = notificationRef;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.sendEmail != null) {
			ret.put("sendEmail", this.sendEmail);
		}
		if (this.logToSystemOut != null) {
			ret.put("logToSystemOut", this.logToSystemOut);
		}
		if (this.emailList != null) {
			ret.put("emailList", this.emailList);
		}
		if (this.emailFormat != null) {
			ret.put("emailFormat", this.emailFormat);
		}
		ret.put("notificationRef", this.notificationRef);
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
