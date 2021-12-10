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
 * Remove a configuration property under a configuration group.
 *   'propertyName': Name of the property.
 *   'propertyType': Type of the property.
 * The required parameters are found in the constructor.
 */
public class RemoveSTSConfigurationProperty extends Command {

	private java.lang.String[] __target;
	private String propertyName = ".*";
	private String propertyType = ".*";

	public RemoveSTSConfigurationProperty(java.lang.String[] commandTarget) {
		super("removeSTSConfigurationProperty");
		this.__target = commandTarget;
	}

	/**
	 * Name of the property.
	 */
	public String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * Name of the property.
	 */
	public void setPropertyName(String value) {
		this.propertyName = value;
	}

	/**
	 * Type of the property.
	 */
	public String getPropertyType() {
		return this.propertyType;
	}

	/**
	 * Type of the property.
	 */
	public void setPropertyType(String value) {
		this.propertyType = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(java.lang.String[] value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.propertyName != null) {
			ret.put("propertyName", this.propertyName);
		}
		if (this.propertyType != null) {
			ret.put("propertyType", this.propertyType);
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
