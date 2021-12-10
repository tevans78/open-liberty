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

package com.ibm.websphere.simplicity.commands.sts;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Update the assigned token type for an endpoint. If the local name parameter is omitted, the default token type is assumed.
 *   'LocalName': The local name of the token type.
 *   'newLocalName': Local name specifying new token type to apply.
 *   'defaultLocalName': Specify the default local name.
 *   'issuer': The issuer (URI).
 *   'newIssuer': The new issuer (URI) to use for the rule.
 *   'nullIssuer': Specify a null issuer.
 * The required parameters are found in the constructor.
 */
public class UpdateSTSEndpointTokenType extends Command {

	private String __target;
	private String LocalName;
	private String newLocalName;
	private Boolean defaultLocalName = false;
	private String issuer;
	private String newIssuer;
	private Boolean nullIssuer = false;

	public UpdateSTSEndpointTokenType(String commandTarget, String LocalName) {
		super("updateSTSEndpointTokenType");
		this.__target = commandTarget;
		this.LocalName = LocalName;
	}

	/**
	 * The local name of the token type.
	 */
	public String getLocalName() {
		return this.LocalName;
	}

	/**
	 * The local name of the token type.
	 */
	public void setLocalName(String value) {
		this.LocalName = value;
	}

	/**
	 * Local name specifying new token type to apply.
	 */
	public String getNewLocalName() {
		return this.newLocalName;
	}

	/**
	 * Local name specifying new token type to apply.
	 */
	public void setNewLocalName(String value) {
		this.newLocalName = value;
	}

	/**
	 * Specify the default local name.
	 */
	public Boolean getDefaultLocalName() {
		return this.defaultLocalName;
	}

	/**
	 * Specify the default local name.
	 */
	public void setDefaultLocalName(Boolean value) {
		this.defaultLocalName = value;
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
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("LocalName", this.LocalName);
		if (this.newLocalName != null) {
			ret.put("newLocalName", this.newLocalName);
		}
		if (this.defaultLocalName != null) {
			ret.put("defaultLocalName", this.defaultLocalName);
		}
		if (this.issuer != null) {
			ret.put("issuer", this.issuer);
		}
		if (this.newIssuer != null) {
			ret.put("newIssuer", this.newIssuer);
		}
		if (this.nullIssuer != null) {
			ret.put("nullIssuer", this.nullIssuer);
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
