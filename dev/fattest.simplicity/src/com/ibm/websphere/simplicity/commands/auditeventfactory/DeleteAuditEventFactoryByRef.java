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
 * Deletes the audit event factory specified by the reference id.
 *   'eventFactoryRef': Supply a valid reference to an audit event factory implementation.
 * The required parameters are found in the constructor.
 */
public class DeleteAuditEventFactoryByRef extends Command {

	private String eventFactoryRef;

	public DeleteAuditEventFactoryByRef(String eventFactoryRef) {
		super("deleteAuditEventFactoryByRef");
		this.eventFactoryRef = eventFactoryRef;
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
