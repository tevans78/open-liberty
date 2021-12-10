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
 * Deletes an audit notification.
 *   'notificationRef': Supply a reference to an existing audit notification.
 * The required parameters are found in the constructor.
 */
public class DeleteAuditNotification extends Command {

	private String notificationRef;

	public DeleteAuditNotification(String notificationRef) {
		super("deleteAuditNotification");
		this.notificationRef = notificationRef;
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
