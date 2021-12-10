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
 * Creates a custom repository configuration.
 *   'adapterClassName': The implementation class name for the repository adapter.
 *   'id': The unique identifier of the repository.
 * The required parameters are found in the constructor.
 */
public class CreateIdMgrCustomRepository extends Command {

	private String adapterClassName;
	private String id;

	public CreateIdMgrCustomRepository(String adapterClassName, String id) {
		super("createIdMgrCustomRepository");
		this.adapterClassName = adapterClassName;
		this.id = id;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public String getAdapterClassName() {
		return this.adapterClassName;
	}

	/**
	 * The implementation class name for the repository adapter.
	 */
	public void setAdapterClassName(String value) {
		this.adapterClassName = value;
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
		ret.put("adapterClassName", this.adapterClassName);
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
