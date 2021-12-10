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

package com.ibm.websphere.simplicity.commands.resource;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command sets the value of a specified property defined on a resource provider such as JDBCProvider or a connection factory such as DataSource or JMSConnectionFactory. If the property with specified key is defined already, then this command overrides the value. If none property with specified key is defined yet, then this command will add the property with specified key and value.
 *   'propertyName': The name of a property.
 *   'propertyValue': The value of a property.
 *   'propertyType': Type of the property.
 *   'propertyDescription': The description of the property
 * The required parameters are found in the constructor.
 */
public class SetResourceProperty extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String propertyName;
	private String propertyValue;
	private String propertyType;
	private String propertyDescription;

	public SetResourceProperty(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String propertyName, String propertyValue) {
		super("setResourceProperty");
		this.__target = commandTarget;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}

	/**
	 * The name of a property.
	 */
	public String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * The name of a property.
	 */
	public void setPropertyName(String value) {
		this.propertyName = value;
	}

	/**
	 * The value of a property.
	 */
	public String getPropertyValue() {
		return this.propertyValue;
	}

	/**
	 * The value of a property.
	 */
	public void setPropertyValue(String value) {
		this.propertyValue = value;
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
	 * The description of the property
	 */
	public String getPropertyDescription() {
		return this.propertyDescription;
	}

	/**
	 * The description of the property
	 */
	public void setPropertyDescription(String value) {
		this.propertyDescription = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("propertyName", this.propertyName);
		ret.put("propertyValue", this.propertyValue);
		if (this.propertyType != null) {
			ret.put("propertyType", this.propertyType);
		}
		if (this.propertyDescription != null) {
			ret.put("propertyDescription", this.propertyDescription);
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
