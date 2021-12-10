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
 * The getRequiredBindingVersion command returns the binding version that is required for a specified asset.
 *   'assetProps': Specifies the asset, such as the application name. (Properties)
 * The required parameters are found in the constructor.
 */
public class GetRequiredBindingVersion extends Command {

	private java.util.Properties assetProps;

	public GetRequiredBindingVersion(java.util.Properties assetProps) {
		super("getRequiredBindingVersion");
		this.assetProps = assetProps;
	}

	/**
	 * Specifies the asset, such as the application name. (Properties)
	 */
	public java.util.Properties getAssetProps() {
		return this.assetProps;
	}

	/**
	 * Specifies the asset, such as the application name. (Properties)
	 */
	public void setAssetProps(java.util.Properties value) {
		this.assetProps = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("assetProps", this.assetProps);
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
