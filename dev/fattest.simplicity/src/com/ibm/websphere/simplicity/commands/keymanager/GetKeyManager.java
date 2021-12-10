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

package com.ibm.websphere.simplicity.commands.keymanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Get information about a key manager.
 *   'name': Specifies a name to uniquely identify a key manager.
 *   'scopeName': Specifies the management scope.
 * The required parameters are found in the constructor.
 */
public class GetKeyManager extends Command {

	private String name;
	private String scopeName;

	public GetKeyManager(String name) {
		super("getKeyManager");
		this.name = name;
	}

	/**
	 * Specifies a name to uniquely identify a key manager.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies a name to uniquely identify a key manager.
	 */
	public void setName(String value) {
		this.name = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
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
