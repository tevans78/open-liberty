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

package com.ibm.websphere.simplicity.commands.wsnotification;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a JAX-WS Handler
 *   'name': The name given to the JAX-WS Handler
 *   'className': The class name associated with the JAX-WS Handler
 *   'description': The description associated with the JAX-WS Handler
 * The required parameters are found in the constructor.
 */
public class ModifyJAXWSHandler extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String className;
	private String description;

	public ModifyJAXWSHandler(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("modifyJAXWSHandler");
		this.__target = commandTarget;
	}

	/**
	 * The name given to the JAX-WS Handler
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name given to the JAX-WS Handler
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The class name associated with the JAX-WS Handler
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 * The class name associated with the JAX-WS Handler
	 */
	public void setClassName(String value) {
		this.className = value;
	}

	/**
	 * The description associated with the JAX-WS Handler
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description associated with the JAX-WS Handler
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.name != null) {
			ret.put("name", this.name);
		}
		if (this.className != null) {
			ret.put("className", this.className);
		}
		if (this.description != null) {
			ret.put("description", this.description);
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
