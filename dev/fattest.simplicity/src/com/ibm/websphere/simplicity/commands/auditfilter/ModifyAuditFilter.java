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
 * Modifies an audit specification entry in the audit.xml that matches the reference Id.
 *   'name': Supply a unique name to identify the audit specification.
 *   'outcome': Supply a valid audit outcome.
 *   'filterRef': Supply a valid audit specification reference.
 *   'eventType': Supply a valid event type.
 *   'enableFilter': Supply the state of enablement for this audit specification.
 * The required parameters are found in the constructor.
 */
public class ModifyAuditFilter extends Command {

	private String name;
	private String outcome;
	private String filterRef;
	private String eventType;
	private Boolean enableFilter;

	public ModifyAuditFilter(String filterRef) {
		super("modifyAuditFilter");
		this.filterRef = filterRef;
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
	 * Supply a valid audit specification reference.
	 */
	public String getFilterRef() {
		return this.filterRef;
	}

	/**
	 * Supply a valid audit specification reference.
	 */
	public void setFilterRef(String value) {
		this.filterRef = value;
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

	/**
	 * Supply the state of enablement for this audit specification.
	 */
	public Boolean getEnableFilter() {
		return this.enableFilter;
	}

	/**
	 * Supply the state of enablement for this audit specification.
	 */
	public void setEnableFilter(Boolean value) {
		this.enableFilter = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.outcome != null) {
			ret.put("outcome", this.outcome);
		}
		ret.put("filterRef", this.filterRef);
		if (this.eventType != null) {
			ret.put("eventType", this.eventType);
		}
		if (this.enableFilter != null) {
			ret.put("enableFilter", this.enableFilter);
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
