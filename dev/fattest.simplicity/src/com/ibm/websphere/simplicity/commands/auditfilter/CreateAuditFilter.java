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
 * Creates an entry in the audit.xml to reference an Audit Specification. Enables the specification by default.
 *   'name': Supply a unique name to identify the audit specification.
 *   'outcome': Supply a valid audit outcome.
 *   'eventType': Supply a valid event type.
 * The required parameters are found in the constructor.
 */
public class CreateAuditFilter extends Command {

	private String name;
	private String outcome;
	private String eventType;

	public CreateAuditFilter(String name, String outcome, String eventType) {
		super("createAuditFilter");
		this.name = name;
		this.outcome = outcome;
		this.eventType = eventType;
	}

	/**
	 * Supply a unique name to identify the audit specification.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Supply a unique name to identify the audit specification.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Supply a valid audit outcome.
	 */
	public String getOutcome() {
		return this.outcome;
	}

	/**
	 * Supply a valid audit outcome.
	 */
	public void setOutcome(String value) {
		this.outcome = value;
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
		ret.put("name", this.name);
		ret.put("outcome", this.outcome);
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
