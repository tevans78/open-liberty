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

package com.ibm.websphere.simplicity.commands.dynamicsslconfigselection;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Get information about a Dynamic SSL configuration selection.
 *   'scopeName': Specifies the management scope.
 *   'dynSSLConfigSelectionName': Specifies the name that uniquely identifies the dynamic SSL configuration selection.
 * The required parameters are found in the constructor.
 */
public class GetDynamicSSLConfigSelection extends Command {

	private String scopeName;
	private String dynSSLConfigSelectionName;

	public GetDynamicSSLConfigSelection(String dynSSLConfigSelectionName) {
		super("getDynamicSSLConfigSelection");
		this.dynSSLConfigSelectionName = dynSSLConfigSelectionName;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the name that uniquely identifies the dynamic SSL configuration selection.
	 */
	public String getDynSSLConfigSelectionName() {
		return this.dynSSLConfigSelectionName;
	}

	/**
	 * Specifies the name that uniquely identifies the dynamic SSL configuration selection.
	 */
	public void setDynSSLConfigSelectionName(String value) {
		this.dynSSLConfigSelectionName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("dynSSLConfigSelectionName", this.dynSSLConfigSelectionName);
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
