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
 * Edit a configuration property under a configuration group.
 *   'propertyName': Name of the property.
 *   'propertyType': Type of the property.
 *   'nullPropertyType': Property type is null.
 *   'newPropertyName': New name for the property.
 *   'newPropertyType': New type for the property.
 *   'newPropertyValue': New value for the property.
 * The required parameters are found in the constructor.
 */
public class EditSTSConfigurationProperty extends Command {

	private java.lang.String[] __target;
	private String propertyName = ".*";
	private String propertyType = ".*";
	private Boolean nullPropertyType = false;
	private String newPropertyName;
	private String newPropertyType;
	private String newPropertyValue;

	public EditSTSConfigurationProperty(java.lang.String[] commandTarget) {
		super("editSTSConfigurationProperty");
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
	 * Property type is null.
	 */
	public Boolean getNullPropertyType() {
		return this.nullPropertyType;
	}

	/**
	 * Property type is null.
	 */
	public void setNullPropertyType(Boolean value) {
		this.nullPropertyType = value;
	}

	/**
	 * New name for the property.
	 */
	public String getNewPropertyName() {
		return this.newPropertyName;
	}

	/**
	 * New name for the property.
	 */
	public void setNewPropertyName(String value) {
		this.newPropertyName = value;
	}

	/**
	 * New type for the property.
	 */
	public String getNewPropertyType() {
		return this.newPropertyType;
	}

	/**
	 * New type for the property.
	 */
	public void setNewPropertyType(String value) {
		this.newPropertyType = value;
	}

	/**
	 * New value for the property.
	 */
	public String getNewPropertyValue() {
		return this.newPropertyValue;
	}

	/**
	 * New value for the property.
	 */
	public void setNewPropertyValue(String value) {
		this.newPropertyValue = value;
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
		if (this.nullPropertyType != null) {
			ret.put("nullPropertyType", this.nullPropertyType);
		}
		if (this.newPropertyName != null) {
			ret.put("newPropertyName", this.newPropertyName);
		}
		if (this.newPropertyType != null) {
			ret.put("newPropertyType", this.newPropertyType);
		}
		if (this.newPropertyValue != null) {
			ret.put("newPropertyValue", this.newPropertyValue);
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
