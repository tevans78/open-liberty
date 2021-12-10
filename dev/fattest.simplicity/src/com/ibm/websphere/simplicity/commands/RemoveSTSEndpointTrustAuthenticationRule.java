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
 * Remove an identity rule, trust authentication rules applied to a specified token type or rules applied to a specified issuer.
 *   'nullIssuer': Specify a null issuer.
 *   'issuer': The issuer (URI).
 *   'tokenTypeURI': URI of the token type.
 *   'identity': Identifying properties.
 * The required parameters are found in the constructor.
 */
public class RemoveSTSEndpointTrustAuthenticationRule extends Command {

	private String __target;
	private Boolean nullIssuer = false;
	private String issuer;
	private String tokenTypeURI;
	private java.util.Properties identity;

	public RemoveSTSEndpointTrustAuthenticationRule(String commandTarget) {
		super("removeSTSEndpointTrustAuthenticationRule");
		this.__target = commandTarget;
	}

	/**
	 * Specify a null issuer.
	 */
	public Boolean getNullIssuer() {
		return this.nullIssuer;
	}

	/**
	 * Specify a null issuer.
	 */
	public void setNullIssuer(Boolean value) {
		this.nullIssuer = value;
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
	 * Identifying properties.
	 */
	public java.util.Properties getIdentity() {
		return this.identity;
	}

	/**
	 * Identifying properties.
	 */
	public void setIdentity(java.util.Properties value) {
		this.identity = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.nullIssuer != null) {
			ret.put("nullIssuer", this.nullIssuer);
		}
		if (this.issuer != null) {
			ret.put("issuer", this.issuer);
		}
		if (this.tokenTypeURI != null) {
			ret.put("tokenTypeURI", this.tokenTypeURI);
		}
		if (this.identity != null) {
			ret.put("identity", this.identity);
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
