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

package com.ibm.websphere.simplicity.commands.idmgrrealmconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Renames the specified realm configuration.
 *   'newName': The new name of the realm.
 *   'name': Name of the realm
 * The required parameters are found in the constructor.
 */
public class RenameIdMgrRealm extends Command {

	private String newName;
	private String name;

	public RenameIdMgrRealm(String newName, String name) {
		super("renameIdMgrRealm");
		this.newName = newName;
		this.name = name;
	}

	/**
	 * The new name of the realm.
	 */
	public String getNewName() {
		return this.newName;
	}

	/**
	 * The new name of the realm.
	 */
	public void setNewName(String value) {
		this.newName = value;
	}

	/**
	 * Name of the realm
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the realm
	 */
	public void setName(String value) {
		this.name = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("newName", this.newName);
		ret.put("name", this.name);
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
