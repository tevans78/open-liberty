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
 * Updates a base entry for the specified repository.
 *   'name': The name of a base entry.
 *   'id': The unique identifier of the repository.
 *   'nameInRepository': Name in the repository for the base entry
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrRepositoryBaseEntry extends Command {

	private String name;
	private String id;
	private String nameInRepository;

	public UpdateIdMgrRepositoryBaseEntry(String name, String id) {
		super("updateIdMgrRepositoryBaseEntry");
		this.name = name;
		this.id = id;
	}

	/**
	 * The name of a base entry.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of a base entry.
	 */
	public void setName(String value) {
		this.name = value;
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

	/**
	 * Name in the repository for the base entry
	 */
	public String getNameInRepository() {
		return this.nameInRepository;
	}

	/**
	 * Name in the repository for the base entry
	 */
	public void setNameInRepository(String value) {
		this.nameInRepository = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		ret.put("id", this.id);
		if (this.nameInRepository != null) {
			ret.put("nameInRepository", this.nameInRepository);
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
