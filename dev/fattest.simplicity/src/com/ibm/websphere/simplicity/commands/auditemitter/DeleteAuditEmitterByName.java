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

package com.ibm.websphere.simplicity.commands.auditemitter;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Deletes an audit emitter implementation object by unique name.
 *   'uniqueName': Supply a unique name to identify the implementation.
 * The required parameters are found in the constructor.
 */
public class DeleteAuditEmitterByName extends Command {

	private String uniqueName;

	public DeleteAuditEmitterByName(String uniqueName) {
		super("deleteAuditEmitterByName");
		this.uniqueName = uniqueName;
	}

	/**
	 * Supply a unique name to identify the implementation.
	 */
	public String getUniqueName() {
		return this.uniqueName;
	}

	/**
	 * Supply a unique name to identify the implementation.
	 */
	public void setUniqueName(String value) {
		this.uniqueName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("uniqueName", this.uniqueName);
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
