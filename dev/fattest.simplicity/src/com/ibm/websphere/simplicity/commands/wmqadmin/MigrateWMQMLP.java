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

package com.ibm.websphere.simplicity.commands.wmqadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Migrates a WebSphere MQ message listener port definition to an activation specification definition.
 *   'asJNDIName': Specifies the JNDI name of the activation specification to be created.
 *   'asName': Specifies the name of the activation specification to be created.
 *   'asScope': The type of scope at which to create the activation specification ("server", "node", "cluster" or "cell")
 * The required parameters are found in the constructor.
 */
public class MigrateWMQMLP extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String asJNDIName;
	private String asName;
	private String asScope;

	public MigrateWMQMLP(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String asJNDIName, String asName) {
		super("migrateWMQMLP");
		this.__target = commandTarget;
		this.asJNDIName = asJNDIName;
		this.asName = asName;
	}

	/**
	 * Specifies the JNDI name of the activation specification to be created.
	 */
	public String getAsJNDIName() {
		return this.asJNDIName;
	}

	/**
	 * Specifies the JNDI name of the activation specification to be created.
	 */
	public void setAsJNDIName(String value) {
		this.asJNDIName = value;
	}

	/**
	 * Specifies the name of the activation specification to be created.
	 */
	public String getAsName() {
		return this.asName;
	}

	/**
	 * Specifies the name of the activation specification to be created.
	 */
	public void setAsName(String value) {
		this.asName = value;
	}

	/**
	 * The type of scope at which to create the activation specification ("server", "node", "cluster" or "cell")
	 */
	public String getAsScope() {
		return this.asScope;
	}

	/**
	 * The type of scope at which to create the activation specification ("server", "node", "cluster" or "cell")
	 */
	public void setAsScope(String value) {
		this.asScope = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("asJNDIName", this.asJNDIName);
		ret.put("asName", this.asName);
		if (this.asScope != null) {
			ret.put("asScope", this.asScope);
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
