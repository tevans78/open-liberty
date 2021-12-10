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

package com.ibm.websphere.simplicity.commands.rarupdate;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Returns a string containing all of the property values and step inputs for the updateRAR command.
 *   'rarPath': The absolute path to the new RAR file.
 *   'returnType': The format in which the command will return information, which is jacl or jython.  The default is jython.
 * The required parameters are found in the constructor.
 */
public class GetNewRAObjectProperties extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String rarPath;
	private String returnType = "jython";

	public GetNewRAObjectProperties(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String rarPath) {
		super("getNewRAObjectProperties");
		this.__target = commandTarget;
		this.rarPath = rarPath;
	}

	/**
	 * The absolute path to the new RAR file.
	 */
	public String getRarPath() {
		return this.rarPath;
	}

	/**
	 * The absolute path to the new RAR file.
	 */
	public void setRarPath(String value) {
		this.rarPath = value;
	}

	/**
	 * The format in which the command will return information, which is jacl or jython.  The default is jython.
	 */
	public String getReturnType() {
		return this.returnType;
	}

	/**
	 * The format in which the command will return information, which is jacl or jython.  The default is jython.
	 */
	public void setReturnType(String value) {
		this.returnType = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("rarPath", this.rarPath);
		if (this.returnType != null) {
			ret.put("returnType", this.returnType);
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
