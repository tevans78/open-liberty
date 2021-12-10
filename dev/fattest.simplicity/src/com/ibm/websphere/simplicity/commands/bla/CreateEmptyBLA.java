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

package com.ibm.websphere.simplicity.commands.bla;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a new business-level application with no composition units.
 *   'name': Business-level application name. The name must be unique in a cell, must be non-empty, cannot have leading or trailing blanks or a leading dot, and cannot contain any of the following characters: \/,#$@:;"*?&lt;&gt;|=+&%'
 *   'description': Description of the business-level application being created.
 * The required parameters are found in the constructor.
 */
public class CreateEmptyBLA extends Command {

	private String name;
	private String description;

	public CreateEmptyBLA(String name) {
		super("createEmptyBLA");
		this.name = name;
	}

	/**
	 * Business-level application name. The name must be unique in a cell, must be non-empty, cannot have leading or trailing blanks or a leading dot, and cannot contain any of the following characters: \/,#$@:;"*?&lt;&gt;|=+&%'
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Business-level application name. The name must be unique in a cell, must be non-empty, cannot have leading or trailing blanks or a leading dot, and cannot contain any of the following characters: \/,#$@:;"*?&lt;&gt;|=+&%'
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Description of the business-level application being created.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the business-level application being created.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.description != null) {
			ret.put("description", this.description);
		}
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
