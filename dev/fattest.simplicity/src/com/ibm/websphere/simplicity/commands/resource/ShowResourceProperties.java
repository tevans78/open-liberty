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
 * This command list all the property values defined on a resource provider such as JDBCProvider or a connection factory such as DataSource or JMSConnectionFactory.
 *   'propertyName': The name of a property. If the property name is specified, then the value of the specified property name is returned. If the property name is not specified, then all the property values are shown in a format of list where each element in the list is a property name value pair.
 * The required parameters are found in the constructor.
 */
public class ShowResourceProperties extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String propertyName;

	public ShowResourceProperties(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("showResourceProperties");
		this.__target = commandTarget;
	}

	/**
	 * The name of a property. If the property name is specified, then the value of the specified property name is returned. If the property name is not specified, then all the property values are shown in a format of list where each element in the list is a property name value pair.
	 */
	public String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * The name of a property. If the property name is specified, then the value of the specified property name is returned. If the property name is not specified, then all the property values are shown in a format of list where each element in the list is a property name value pair.
	 */
	public void setPropertyName(String value) {
		this.propertyName = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.propertyName != null) {
			ret.put("propertyName", this.propertyName);
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
