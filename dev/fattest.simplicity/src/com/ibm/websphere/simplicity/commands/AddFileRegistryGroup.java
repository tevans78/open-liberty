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
 * Adds a group to the file registry.
 *   'cn': The common name of the entity.
 *   'description': A description of a group.
 *   'parent': The parent of the entity.
 * The required parameters are found in the constructor.
 */
public class AddFileRegistryGroup extends Command {

	private String cn;
	private String description;
	private String parent;

	public AddFileRegistryGroup(String cn) {
		super("addFileRegistryGroup");
		this.cn = cn;
	}

	/**
	 * The common name of the entity.
	 */
	public String getCn() {
		return this.cn;
	}

	/**
	 * The common name of the entity.
	 */
	public void setCn(String value) {
		this.cn = value;
	}

	/**
	 * A description of a group.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * A description of a group.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The parent of the entity.
	 */
	public String getParent() {
		return this.parent;
	}

	/**
	 * The parent of the entity.
	 */
	public void setParent(String value) {
		this.parent = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("cn", this.cn);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.parent != null) {
			ret.put("parent", this.parent);
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
