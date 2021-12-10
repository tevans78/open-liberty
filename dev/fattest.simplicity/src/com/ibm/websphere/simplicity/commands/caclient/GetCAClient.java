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

package com.ibm.websphere.simplicity.commands.caclient;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Gets information about a certificate authority (CA) client configurator object.
 *   'scopeName': Specifies the management scope.
 *   'caClientName': Specifies the name that uniquely identifies the certificate authority (CA) configurator.
 * The required parameters are found in the constructor.
 */
public class GetCAClient extends Command {

	private String scopeName;
	private String caClientName;

	public GetCAClient(String caClientName) {
		super("getCAClient");
		this.caClientName = caClientName;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the name that uniquely identifies the certificate authority (CA) configurator.
	 */
	public String getCaClientName() {
		return this.caClientName;
	}

	/**
	 * Specifies the name that uniquely identifies the certificate authority (CA) configurator.
	 */
	public void setCaClientName(String value) {
		this.caClientName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("caClientName", this.caClientName);
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
