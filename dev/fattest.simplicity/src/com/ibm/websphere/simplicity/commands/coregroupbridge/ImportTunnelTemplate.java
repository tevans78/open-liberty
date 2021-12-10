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

package com.ibm.websphere.simplicity.commands.coregroupbridge;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Import a tunnel template and its children into the cell-scoped config.
 *   'inputFileName': Name of the input file with tunnel template information.
 *   'bridgeInterfaceNodeName': The Node Name of the secure proxy node to use for the CGB interface.
 *   'bridgeInterfaceServerName': The Server Name of the secure proxy to use for the CGB interface.
 * The required parameters are found in the constructor.
 */
public class ImportTunnelTemplate extends Command {

	private String inputFileName;
	private String bridgeInterfaceNodeName;
	private String bridgeInterfaceServerName;

	public ImportTunnelTemplate(String inputFileName, String bridgeInterfaceNodeName, String bridgeInterfaceServerName) {
		super("importTunnelTemplate");
		this.inputFileName = inputFileName;
		this.bridgeInterfaceNodeName = bridgeInterfaceNodeName;
		this.bridgeInterfaceServerName = bridgeInterfaceServerName;
	}

	/**
	 * Name of the input file with tunnel template information.
	 */
	public String getInputFileName() {
		return this.inputFileName;
	}

	/**
	 * Name of the input file with tunnel template information.
	 */
	public void setInputFileName(String value) {
		this.inputFileName = value;
	}

	/**
	 * The Node Name of the secure proxy node to use for the CGB interface.
	 */
	public String getBridgeInterfaceNodeName() {
		return this.bridgeInterfaceNodeName;
	}

	/**
	 * The Node Name of the secure proxy node to use for the CGB interface.
	 */
	public void setBridgeInterfaceNodeName(String value) {
		this.bridgeInterfaceNodeName = value;
	}

	/**
	 * The Server Name of the secure proxy to use for the CGB interface.
	 */
	public String getBridgeInterfaceServerName() {
		return this.bridgeInterfaceServerName;
	}

	/**
	 * The Server Name of the secure proxy to use for the CGB interface.
	 */
	public void setBridgeInterfaceServerName(String value) {
		this.bridgeInterfaceServerName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("inputFileName", this.inputFileName);
		ret.put("bridgeInterfaceNodeName", this.bridgeInterfaceNodeName);
		ret.put("bridgeInterfaceServerName", this.bridgeInterfaceServerName);
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
