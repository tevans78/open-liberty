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
 * Export a tunnel template and its children into a simple properties file.
 *   'tunnelTemplateName': Name of the tunnel template to export.
 *   'outputFileName': The name of the properties file to be output.
 * The required parameters are found in the constructor.
 */
public class ExportTunnelTemplate extends Command {

	private String tunnelTemplateName;
	private String outputFileName;

	public ExportTunnelTemplate(String tunnelTemplateName, String outputFileName) {
		super("exportTunnelTemplate");
		this.tunnelTemplateName = tunnelTemplateName;
		this.outputFileName = outputFileName;
	}

	/**
	 * Name of the tunnel template to export.
	 */
	public String getTunnelTemplateName() {
		return this.tunnelTemplateName;
	}

	/**
	 * Name of the tunnel template to export.
	 */
	public void setTunnelTemplateName(String value) {
		this.tunnelTemplateName = value;
	}

	/**
	 * The name of the properties file to be output.
	 */
	public String getOutputFileName() {
		return this.outputFileName;
	}

	/**
	 * The name of the properties file to be output.
	 */
	public void setOutputFileName(String value) {
		this.outputFileName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("tunnelTemplateName", this.tunnelTemplateName);
		ret.put("outputFileName", this.outputFileName);
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
