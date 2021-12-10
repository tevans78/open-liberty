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
 * Converts an audit specification event and outcome to a reference representation.
 *   'filter': Supply a valid audit specification in the form event:outcome using the shortened form of the event.
 * The required parameters are found in the constructor.
 */
public class ConvertFilterStringToRef extends Command {

	private String filter;

	public ConvertFilterStringToRef(String filter) {
		super("convertFilterStringToRef");
		this.filter = filter;
	}

	/**
	 * Supply a valid audit specification in the form event:outcome using the shortened form of the event.
	 */
	public String getFilter() {
		return this.filter;
	}

	/**
	 * Supply a valid audit specification in the form event:outcome using the shortened form of the event.
	 */
	public void setFilter(String value) {
		this.filter = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("filter", this.filter);
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
