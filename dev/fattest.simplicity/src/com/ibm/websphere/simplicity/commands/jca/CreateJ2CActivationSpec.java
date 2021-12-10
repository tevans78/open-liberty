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

package com.ibm.websphere.simplicity.commands.jca;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a J2C activation specification.
 *   'messageListenerType': A message listener type that is defined in the deployment description of the parent J2C resource adapter.
 *   'name': The name of the J2C activation specification.
 *   'jndiName': The JNDI name of the created J2C activation specification.
 *   'destinationJndiName': the destination JNDI name of the created J2C activation specification
 *   'description': The description for the created J2C activation specification.
 *   'authenticationAlias': the authentication alias of the created J2C activation specification
 * The required parameters are found in the constructor.
 */
public class CreateJ2CActivationSpec extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String messageListenerType;
	private String name;
	private String jndiName;
	private String destinationJndiName;
	private String description;
	private String authenticationAlias;

	public CreateJ2CActivationSpec(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String messageListenerType, String name, String jndiName) {
		super("createJ2CActivationSpec");
		this.__target = commandTarget;
		this.messageListenerType = messageListenerType;
		this.name = name;
		this.jndiName = jndiName;
	}

	/**
	 * A message listener type that is defined in the deployment description of the parent J2C resource adapter.
	 */
	public String getMessageListenerType() {
		return this.messageListenerType;
	}

	/**
	 * A message listener type that is defined in the deployment description of the parent J2C resource adapter.
	 */
	public void setMessageListenerType(String value) {
		this.messageListenerType = value;
	}

	/**
	 * The name of the J2C activation specification.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the J2C activation specification.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The JNDI name of the created J2C activation specification.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The JNDI name of the created J2C activation specification.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * the destination JNDI name of the created J2C activation specification
	 */
	public String getDestinationJndiName() {
		return this.destinationJndiName;
	}

	/**
	 * the destination JNDI name of the created J2C activation specification
	 */
	public void setDestinationJndiName(String value) {
		this.destinationJndiName = value;
	}

	/**
	 * The description for the created J2C activation specification.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description for the created J2C activation specification.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * the authentication alias of the created J2C activation specification
	 */
	public String getAuthenticationAlias() {
		return this.authenticationAlias;
	}

	/**
	 * the authentication alias of the created J2C activation specification
	 */
	public void setAuthenticationAlias(String value) {
		this.authenticationAlias = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("messageListenerType", this.messageListenerType);
		ret.put("name", this.name);
		ret.put("jndiName", this.jndiName);
		if (this.destinationJndiName != null) {
			ret.put("destinationJndiName", this.destinationJndiName);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.authenticationAlias != null) {
			ret.put("authenticationAlias", this.authenticationAlias);
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
