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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * 
 *   'scope': 
 *   'jndiName': 
 *   'currentScopeOnly': 
 * The required parameters are found in the constructor.
 */
public class LookupResources extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier scope;
	private String jndiName;
	private Boolean currentScopeOnly = true;

	public LookupResources(com.ibm.websphere.simplicity.ConfigIdentifier scope, String jndiName) {
		super("lookupResources");
		this.scope = scope;
		this.jndiName = jndiName;
	}

	/**
	 * 
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getScope() {
		return this.scope;
	}

	/**
	 * 
	 */
	public void setScope(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.scope = value;
	}

	/**
	 * 
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * 
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * 
	 */
	public Boolean getCurrentScopeOnly() {
		return this.currentScopeOnly;
	}

	/**
	 * 
	 */
	public void setCurrentScopeOnly(Boolean value) {
		this.currentScopeOnly = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("scope", this.scope);
		ret.put("jndiName", this.jndiName);
		if (this.currentScopeOnly != null) {
			ret.put("currentScopeOnly", this.currentScopeOnly);
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
