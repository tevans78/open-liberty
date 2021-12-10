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

package com.ibm.websphere.simplicity.commands.auditfilter;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Returns the audit outcomes defined for an event.
 *   'eventType': Supply a valid event type.
 * The required parameters are found in the constructor.
 */
public class GetAuditOutcomes extends Command {

	private String eventType;

	public GetAuditOutcomes(String eventType) {
		super("getAuditOutcomes");
		this.eventType = eventType;
	}

	/**
	 * Supply a valid event type.
	 */
	public String getEventType() {
		return this.eventType;
	}

	/**
	 * Supply a valid event type.
	 */
	public void setEventType(String value) {
		this.eventType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("eventType", this.eventType);
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
