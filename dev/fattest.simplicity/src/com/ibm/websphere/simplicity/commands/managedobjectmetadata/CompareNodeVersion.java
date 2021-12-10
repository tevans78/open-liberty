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

package com.ibm.websphere.simplicity.commands.managedobjectmetadata;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Compares the version of a given node with the specified version.  Only the number of levels in the specified version number are compared.  For example, if "6.0" compared to a node version of "6.0.1.0", they will compare as equal.  The possible return values are -1, 0, and 1. They are defined as follows: 	-1: node version is less than the specified version 	 0: node version is equal to the specified version 	 1: node version is greater than the specified version
 *   'nodeName': Name of node.
 *   'version': Version to compare
 * The required parameters are found in the constructor.
 */
public class CompareNodeVersion extends Command {

	private String nodeName;
	private String version;

	public CompareNodeVersion(String nodeName, String version) {
		super("compareNodeVersion");
		this.nodeName = nodeName;
		this.version = version;
	}

	/**
	 * Name of node.
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * Name of node.
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Version to compare
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * Version to compare
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("nodeName", this.nodeName);
		ret.put("version", this.version);
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
