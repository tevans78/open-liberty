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
 * Create a Servlet Cache Instance.  A servlet cache instance is a location where the dynamic cache can store, distribute, and share data.
 *   'jndiName': The JNDI name for this Servlet Cache Instance.
 *   'name': Name of the Servlet Cache Instance.
 * The required parameters are found in the constructor.
 */
public class CreateServletCacheInstance extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private java.lang.String jndiName;
	private java.lang.String name;

	public CreateServletCacheInstance(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, java.lang.String jndiName, java.lang.String name) {
		super("createServletCacheInstance");
		this.__target = commandTarget;
		this.jndiName = jndiName;
		this.name = name;
	}

	/**
	 * The JNDI name for this Servlet Cache Instance.
	 */
	public java.lang.String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The JNDI name for this Servlet Cache Instance.
	 */
	public void setJndiName(java.lang.String value) {
		this.jndiName = value;
	}

	/**
	 * Name of the Servlet Cache Instance.
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * Name of the Servlet Cache Instance.
	 */
	public void setName(java.lang.String value) {
		this.name = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("jndiName", this.jndiName);
		ret.put("name", this.name);
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
