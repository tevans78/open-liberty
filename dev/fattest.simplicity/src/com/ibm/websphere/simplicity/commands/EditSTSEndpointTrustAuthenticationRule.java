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
 * Edit issuer, tokenTypeURI, jaasConfigName or callbackHandler attributes of the specified trust authentication rule.
 *   'issuer': The issuer (URI).
 *   'newIssuer': The new issuer (URI) to use for the rule.
 *   'tokenTypeURI': URI of the token type.
 *   'newTokenTypeURI': The new token type URI for the rule.
 *   'newJAASConfigName': The new JAAS config name to use for the rule.
 *   'newCallbackHandler': The new callback handler to use for the rule.
 * The required parameters are found in the constructor.
 */
public class EditSTSEndpointTrustAuthenticationRule extends Command {

	private String __target;
	private String issuer;
	private String newIssuer;
	private String tokenTypeURI;
	private String newTokenTypeURI;
	private String newJAASConfigName;
	private String newCallbackHandler;

	public EditSTSEndpointTrustAuthenticationRule(String commandTarget) {
		super("editSTSEndpointTrustAuthenticationRule");
		this.__target = commandTarget;
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
	 * The new issuer (URI) to use for the rule.
	 */
	public String getNewIssuer() {
		return this.newIssuer;
	}

	/**
	 * The new issuer (URI) to use for the rule.
	 */
	public void setNewIssuer(String value) {
		this.newIssuer = value;
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
	 * The new token type URI for the rule.
	 */
	public String getNewTokenTypeURI() {
		return this.newTokenTypeURI;
	}

	/**
	 * The new token type URI for the rule.
	 */
	public void setNewTokenTypeURI(String value) {
		this.newTokenTypeURI = value;
	}

	/**
	 * The new JAAS config name to use for the rule.
	 */
	public String getNewJAASConfigName() {
		return this.newJAASConfigName;
	}

	/**
	 * The new JAAS config name to use for the rule.
	 */
	public void setNewJAASConfigName(String value) {
		this.newJAASConfigName = value;
	}

	/**
	 * The new callback handler to use for the rule.
	 */
	public String getNewCallbackHandler() {
		return this.newCallbackHandler;
	}

	/**
	 * The new callback handler to use for the rule.
	 */
	public void setNewCallbackHandler(String value) {
		this.newCallbackHandler = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.issuer != null) {
			ret.put("issuer", this.issuer);
		}
		if (this.newIssuer != null) {
			ret.put("newIssuer", this.newIssuer);
		}
		if (this.tokenTypeURI != null) {
			ret.put("tokenTypeURI", this.tokenTypeURI);
		}
		if (this.newTokenTypeURI != null) {
			ret.put("newTokenTypeURI", this.newTokenTypeURI);
		}
		if (this.newJAASConfigName != null) {
			ret.put("newJAASConfigName", this.newJAASConfigName);
		}
		if (this.newCallbackHandler != null) {
			ret.put("newCallbackHandler", this.newCallbackHandler);
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
