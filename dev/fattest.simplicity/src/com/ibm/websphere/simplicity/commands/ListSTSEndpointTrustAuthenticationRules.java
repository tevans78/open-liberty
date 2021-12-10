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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List the identity rules under the specified trust authentication rule.
 *   'tokenTypeURI': URI of the token type.
 *   'issuer': The issuer (URI).
 * The required parameters are found in the constructor.
 */
public class ListSTSEndpointTrustAuthenticationRules extends Command {

	private String __target;
	private String tokenTypeURI;
	private String issuer;

	public ListSTSEndpointTrustAuthenticationRules(String commandTarget, String tokenTypeURI) {
		super("listSTSEndpointTrustAuthenticationRules");
		this.__target = commandTarget;
		this.tokenTypeURI = tokenTypeURI;
	}

	/**
	 * URI of the token type.
	 */
	public String getTokenTypeURI() {
		return this.tokenTypeURI;
	}

	/**
	 * URI of the token type.
	 */
	public void setTokenTypeURI(String value) {
		this.tokenTypeURI = value;
	}

	/**
	 * The issuer (URI).
	 */
	public String getIssuer() {
		return this.issuer;
	}

	/**
	 * The issuer (URI).
	 */
	public void setIssuer(String value) {
		this.issuer = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("tokenTypeURI", this.tokenTypeURI);
		if (this.issuer != null) {
			ret.put("issuer", this.issuer);
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
