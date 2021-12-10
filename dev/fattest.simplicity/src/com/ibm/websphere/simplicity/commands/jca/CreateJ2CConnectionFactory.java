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
 * Create a J2C connection factory
 *   'connectionFactoryInterface': A connection factory interface that is defined in the deployment description of the parent J2C resource adapter.
 *   'name': The name of the J2C connection factory.
 *   'jndiName': The JNDI name of the created J2C connection factory.
 *   'description': The description for the created J2C connection factory.
 *   'authDataAlias': component-managed authentication data alias of the created J2C connection factory.
 * The required parameters are found in the constructor.
 */
public class CreateJ2CConnectionFactory extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String connectionFactoryInterface;
	private String name;
	private String jndiName;
	private String description;
	private String authDataAlias;

	public CreateJ2CConnectionFactory(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String jndiName) {
		super("createJ2CConnectionFactory");
		this.__target = commandTarget;
		this.name = name;
		this.jndiName = jndiName;
	}

	/**
	 * A connection factory interface that is defined in the deployment description of the parent J2C resource adapter.
	 */
	public String getConnectionFactoryInterface() {
		return this.connectionFactoryInterface;
	}

	/**
	 * A connection factory interface that is defined in the deployment description of the parent J2C resource adapter.
	 */
	public void setConnectionFactoryInterface(String value) {
		this.connectionFactoryInterface = value;
	}

	/**
	 * The name of the J2C connection factory.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the J2C connection factory.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The JNDI name of the created J2C connection factory.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The JNDI name of the created J2C connection factory.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * The description for the created J2C connection factory.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description for the created J2C connection factory.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * component-managed authentication data alias of the created J2C connection factory.
	 */
	public String getAuthDataAlias() {
		return this.authDataAlias;
	}

	/**
	 * component-managed authentication data alias of the created J2C connection factory.
	 */
	public void setAuthDataAlias(String value) {
		this.authDataAlias = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.connectionFactoryInterface != null) {
			ret.put("connectionFactoryInterface", this.connectionFactoryInterface);
		}
		ret.put("name", this.name);
		ret.put("jndiName", this.jndiName);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.authDataAlias != null) {
			ret.put("authDataAlias", this.authDataAlias);
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
