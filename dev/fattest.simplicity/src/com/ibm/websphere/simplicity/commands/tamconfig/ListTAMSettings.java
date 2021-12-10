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

package com.ibm.websphere.simplicity.commands.tamconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command lists the current embedded Tivoli Access Manager configuration settings.
 *   'nodeName': Specifies the target WebSphere Application Server node or nodes. Specify all nodes by entering '*'.
 * The required parameters are found in the constructor.
 */
public class ListTAMSettings extends Command {

	private String nodeName = "*";

	public ListTAMSettings() {
		super("listTAMSettings");
	}

	/**
	 * Specifies the target WebSphere Application Server node or nodes. Specify all nodes by entering '*'.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * Specifies the target WebSphere Application Server node or nodes. Specify all nodes by entering '*'.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.nodeName != null) {
			ret.put("nodeName", this.nodeName);
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
