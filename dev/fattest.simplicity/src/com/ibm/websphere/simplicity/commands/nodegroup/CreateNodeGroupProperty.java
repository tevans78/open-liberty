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

package com.ibm.websphere.simplicity.commands.nodegroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * add a custom property for a node group
 *   'name': name of the property
 *   'value': value
 *   'description': description
 *   'required': required
 *   'validationExpression': validation expression
 * The required parameters are found in the constructor.
 */
public class CreateNodeGroupProperty extends Command {

	private String __target;
	private String name;
	private String value;
	private String description;
	private Boolean required;
	private String validationExpression;

	public CreateNodeGroupProperty(String commandTarget, String name, String value) {
		super("createNodeGroupProperty");
		this.__target = commandTarget;
		this.name = name;
		this.value = value;
	}

	/**
	 * name of the property
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * name of the property
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * value
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * description
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * required
	 */
	public Boolean getRequired() {
		return this.required;
	}

	/**
	 * required
	 */
	public void setRequired(Boolean value) {
		this.required = value;
	}

	/**
	 * validation expression
	 */
	public String getValidationExpression() {
		return this.validationExpression;
	}

	/**
	 * validation expression
	 */
	public void setValidationExpression(String value) {
		this.validationExpression = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(String value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("value", this.value);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.required != null) {
			ret.put("required", this.required);
		}
		if (this.validationExpression != null) {
			ret.put("validationExpression", this.validationExpression);
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
