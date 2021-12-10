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

package com.ibm.websphere.simplicity.commands.channelframework;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Displays a list of templates that can be used to create chains in this configuration. All templates have a certain type of transport channel as the last transport channel in the chain.
 *   'acceptorFilter': Templates returned by this method should all have a transport channel instance of the specified type as the last transport channel in the chain.
 * The required parameters are found in the constructor.
 */
public class ListChainTemplates extends Command {

	private String acceptorFilter;

	public ListChainTemplates() {
		super("listChainTemplates");
	}

	/**
	 * Templates returned by this method should all have a transport channel instance of the specified type as the last transport channel in the chain.
	 */
	public String getAcceptorFilter() {
		return this.acceptorFilter;
	}

	/**
	 * Templates returned by this method should all have a transport channel instance of the specified type as the last transport channel in the chain.
	 */
	public void setAcceptorFilter(String value) {
		this.acceptorFilter = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.acceptorFilter != null) {
			ret.put("acceptorFilter", this.acceptorFilter);
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
