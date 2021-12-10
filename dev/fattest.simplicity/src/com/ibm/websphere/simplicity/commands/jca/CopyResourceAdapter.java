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

package com.ibm.websphere.simplicity.commands.jca;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * copy the specified J2C resource adapter to the specified scope.
 *   'scope': A scope that the new J2C resource adapter is created.
 *   'name': the name of the J2C resource adapter
 *   'useDeepCopy': A boolean to indicate deep copy
 * The required parameters are found in the constructor.
 */
public class CopyResourceAdapter extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private com.ibm.websphere.simplicity.ConfigIdentifier scope;
	private String name;
	private Boolean useDeepCopy = false;

	public CopyResourceAdapter(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, com.ibm.websphere.simplicity.ConfigIdentifier scope, String name) {
		super("copyResourceAdapter");
		this.__target = commandTarget;
		this.scope = scope;
		this.name = name;
	}

	/**
	 * A scope that the new J2C resource adapter is created.
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getScope() {
		return this.scope;
	}

	/**
	 * A scope that the new J2C resource adapter is created.
	 */
	public void setScope(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.scope = value;
	}

	/**
	 * the name of the J2C resource adapter
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * the name of the J2C resource adapter
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * A boolean to indicate deep copy
	 */
	public Boolean getUseDeepCopy() {
		return this.useDeepCopy;
	}

	/**
	 * A boolean to indicate deep copy
	 */
	public void setUseDeepCopy(Boolean value) {
		this.useDeepCopy = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("scope", this.scope);
		ret.put("name", this.name);
		if (this.useDeepCopy != null) {
			ret.put("useDeepCopy", this.useDeepCopy);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
