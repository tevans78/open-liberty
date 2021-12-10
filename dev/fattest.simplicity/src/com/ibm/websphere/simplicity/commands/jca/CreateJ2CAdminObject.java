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
 * Create a J2C administrative object.
 *   'adminObjectInterface': An administrative object factory interface that is defined in the deployment description of the parent J2C resource adapter.
 *   'name': The name of the J2C administrative object.
 *   'jndiName': The JNDI name of the created J2C administrative object.
 *   'description': The description for the created J2C administrative object.
 * The required parameters are found in the constructor.
 */
public class CreateJ2CAdminObject extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String adminObjectInterface;
	private String name;
	private String jndiName;
	private String description;

	public CreateJ2CAdminObject(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String adminObjectInterface, String name, String jndiName) {
		super("createJ2CAdminObject");
		this.__target = commandTarget;
		this.adminObjectInterface = adminObjectInterface;
		this.name = name;
		this.jndiName = jndiName;
	}

	/**
	 * An administrative object factory interface that is defined in the deployment description of the parent J2C resource adapter.
	 */
	public String getAdminObjectInterface() {
		return this.adminObjectInterface;
	}

	/**
	 * An administrative object factory interface that is defined in the deployment description of the parent J2C resource adapter.
	 */
	public void setAdminObjectInterface(String value) {
		this.adminObjectInterface = value;
	}

	/**
	 * The name of the J2C administrative object.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the J2C administrative object.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The JNDI name of the created J2C administrative object.
	 */
	public String getJndiName() {
		return this.jndiName;
	}

	/**
	 * The JNDI name of the created J2C administrative object.
	 */
	public void setJndiName(String value) {
		this.jndiName = value;
	}

	/**
	 * The description for the created J2C administrative object.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * The description for the created J2C administrative object.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("adminObjectInterface", this.adminObjectInterface);
		ret.put("name", this.name);
		ret.put("jndiName", this.jndiName);
		if (this.description != null) {
			ret.put("description", this.description);
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
