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

package com.ibm.websphere.simplicity.commands.auditeventfactory;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Sets a list of references to defined filters for the supplied event factory.
 *   'filtersRef': Supply a list of valid references to defined audit specifications.
 *   'eventFactoryRef': Supply a valid reference to an audit event factory implementation.
 * The required parameters are found in the constructor.
 */
public class SetAuditEventFactoryFilters extends Command {

	private String filtersRef;
	private String eventFactoryRef;

	public SetAuditEventFactoryFilters(String filtersRef, String eventFactoryRef) {
		super("setAuditEventFactoryFilters");
		this.filtersRef = filtersRef;
		this.eventFactoryRef = eventFactoryRef;
	}

	/**
	 * Supply a list of valid references to defined audit specifications.
	 */
	public String getFiltersRef() {
		return this.filtersRef;
	}

	/**
	 * Supply a list of valid references to defined audit specifications.
	 */
	public void setFiltersRef(String value) {
		this.filtersRef = value;
	}

	/**
	 * Supply a valid reference to an audit event factory implementation.
	 */
	public String getEventFactoryRef() {
		return this.eventFactoryRef;
	}

	/**
	 * Supply a valid reference to an audit event factory implementation.
	 */
	public void setEventFactoryRef(String value) {
		this.eventFactoryRef = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("filtersRef", this.filtersRef);
		ret.put("eventFactoryRef", this.eventFactoryRef);
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
