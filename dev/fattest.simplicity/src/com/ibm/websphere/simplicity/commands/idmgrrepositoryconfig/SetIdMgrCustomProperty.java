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

package com.ibm.websphere.simplicity.commands.idmgrrepositoryconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Sets/adds/deletes custom property to a repository configuration. If value is not specified or an empty string then the property will be deleted from the repository configuration. If name does not exist then it will be added, if a value is specified. If name is "*" then all the custom properties will be deleted.
 *   'name': Name of a property for the repository
 *   'value': Value of a property for the repository
 *   'id': The unique identifier of the repository.
 * The required parameters are found in the constructor.
 */
public class SetIdMgrCustomProperty extends Command {

	private String name;
	private String value;
	private String id;

	public SetIdMgrCustomProperty(String name, String id) {
		super("setIdMgrCustomProperty");
		this.name = name;
		this.id = id;
	}

	/**
	 * Name of a property for the repository
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of a property for the repository
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Value of a property for the repository
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Value of a property for the repository
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * The unique identifier of the repository.
	 */
	public void setId(String value) {
		this.id = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.value != null) {
			ret.put("value", this.value);
		}
		ret.put("id", this.id);
		return ret;
	}

	public Object __getTarget() {
		return null;
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
