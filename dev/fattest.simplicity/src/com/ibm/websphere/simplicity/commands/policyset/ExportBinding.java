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

package com.ibm.websphere.simplicity.commands.policyset;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The exportBinding command exports a binding as an archive that can be copied onto a client environment or imported onto a server environment.
 *   'bindingName': Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
 *   'pathName': Specifies the path name of the archive file. (String)
 * The required parameters are found in the constructor.
 */
public class ExportBinding extends Command {

	private String bindingName;
	private String pathName;

	public ExportBinding(String bindingName, String pathName) {
		super("exportBinding");
		this.bindingName = bindingName;
		this.pathName = pathName;
	}

	/**
	 * Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
	 */
	public String getBindingName() {
		return this.bindingName;
	}

	/**
	 * Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
	 */
	public void setBindingName(String value) {
		this.bindingName = value;
	}

	/**
	 * Specifies the path name of the archive file. (String)
	 */
	public String getPathName() {
		return this.pathName;
	}

	/**
	 * Specifies the path name of the archive file. (String)
	 */
	public void setPathName(String value) {
		this.pathName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bindingName", this.bindingName);
		ret.put("pathName", this.pathName);
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
