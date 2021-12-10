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
 * Compare an existing Resource Adapter to a RAR file and determine whether the RAR is compatible for updating the Resource Adapter.
 *   'rarPath': The absolute path to the new RAR file.
 * The required parameters are found in the constructor.
 */
public class CompareResourceAdapterToRAR extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String rarPath;

	public CompareResourceAdapterToRAR(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String rarPath) {
		super("compareResourceAdapterToRAR");
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
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("rarPath", this.rarPath);
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
