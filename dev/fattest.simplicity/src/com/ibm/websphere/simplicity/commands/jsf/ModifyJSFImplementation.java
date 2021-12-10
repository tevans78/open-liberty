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

package com.ibm.websphere.simplicity.commands.jsf;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modifies the JavaServer Faces implementation used by the WebSphere runtime for an application
 *   'implName': Name of the implementation to be used for the specified application.  This may be SunRI1.2 or MyFaces1.2
 * The required parameters are found in the constructor.
 */
public class ModifyJSFImplementation extends Command {

	private java.lang.String __target;
	private java.lang.String implName;

	public ModifyJSFImplementation(java.lang.String commandTarget, java.lang.String implName) {
		super("modifyJSFImplementation");
		this.__target = commandTarget;
		this.implName = implName;
	}

	/**
	 * Name of the implementation to be used for the specified application.  This may be SunRI1.2 or MyFaces1.2
	 */
	public java.lang.String getImplName() {
		return this.implName;
	}

	/**
	 * Name of the implementation to be used for the specified application.  This may be SunRI1.2 or MyFaces1.2
	 */
	public void setImplName(java.lang.String value) {
		this.implName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(java.lang.String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("implName", this.implName);
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
