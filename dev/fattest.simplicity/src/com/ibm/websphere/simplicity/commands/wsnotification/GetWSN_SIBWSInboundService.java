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

package com.ibm.websphere.simplicity.commands.wsnotification;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Retrieve one of the service integration bus inbound services from a WS-Notification service
 *   'type': The type of inbound service to retrieve: "BROKER" for the notification broker, "SUB_MGR" for the subscription manager or "PUB_REG_MGR" for the publisher registration manager.
 * The required parameters are found in the constructor.
 */
public class GetWSN_SIBWSInboundService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String type;

	public GetWSN_SIBWSInboundService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String type) {
		super("getWSN_SIBWSInboundService");
		this.__target = commandTarget;
		this.type = type;
	}

	/**
	 * The type of inbound service to retrieve: "BROKER" for the notification broker, "SUB_MGR" for the subscription manager or "PUB_REG_MGR" for the publisher registration manager.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * The type of inbound service to retrieve: "BROKER" for the notification broker, "SUB_MGR" for the subscription manager or "PUB_REG_MGR" for the publisher registration manager.
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("type", this.type);
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
