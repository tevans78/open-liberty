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

package com.ibm.websphere.simplicity.commands.wsnotifier;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a notifier.
 *   'emailList': Specifies a colon separated list of email address to send notification.
 *   'name': Specifies the name that uniquely identifies a notifier.
 *   'logToSystemOut': Specify true to log information to system out, false otherwise.
 *   'sendEmail': Specify true to send notifiers an e-mail, false to not send an email.
 * The required parameters are found in the constructor.
 */
public class ModifyWSNotifier extends Command {

	private String emailList;
	private String name;
	private Boolean logToSystemOut;
	private Boolean sendEmail;

	public ModifyWSNotifier(String name) {
		super("modifyWSNotifier");
		this.name = name;
	}

	/**
	 * Specifies a colon separated list of email address to send notification.
	 */
	public String getEmailList() {
		return this.emailList;
	}

	/**
	 * Specifies a colon separated list of email address to send notification.
	 */
	public void setEmailList(String value) {
		this.emailList = value;
	}

	/**
	 * Specifies the name that uniquely identifies a notifier.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies the name that uniquely identifies a notifier.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specify true to log information to system out, false otherwise.
	 */
	public Boolean getLogToSystemOut() {
		return this.logToSystemOut;
	}

	/**
	 * Specify true to log information to system out, false otherwise.
	 */
	public void setLogToSystemOut(Boolean value) {
		this.logToSystemOut = value;
	}

	/**
	 * Specify true to send notifiers an e-mail, false to not send an email.
	 */
	public Boolean getSendEmail() {
		return this.sendEmail;
	}

	/**
	 * Specify true to send notifiers an e-mail, false to not send an email.
	 */
	public void setSendEmail(Boolean value) {
		this.sendEmail = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.emailList != null) {
			ret.put("emailList", this.emailList);
		}
		ret.put("name", this.name);
		if (this.logToSystemOut != null) {
			ret.put("logToSystemOut", this.logToSystemOut);
		}
		if (this.sendEmail != null) {
			ret.put("sendEmail", this.sendEmail);
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
