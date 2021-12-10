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

package com.ibm.websphere.simplicity.commands.wim;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Creates a group in the default realm.
 *   'cn': The common name of the entity.
 *   'description': A description of a group.
 *   'memberUniqueName': The uniqueName of the member to add or remove.
 *   'parent': The parent of the entity.
 * The required parameters are found in the constructor.
 */
public class CreateGroup extends Command {

	private String cn;
	private String description;
	private String memberUniqueName;
	private String parent;

	public CreateGroup(String cn) {
		super("createGroup");
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
	 * The uniqueName of the member to add or remove.
	 */
	public String getMemberUniqueName() {
		return this.memberUniqueName;
	}

	/**
	 * The uniqueName of the member to add or remove.
	 */
	public void setMemberUniqueName(String value) {
		this.memberUniqueName = value;
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
		if (this.memberUniqueName != null) {
			ret.put("memberUniqueName", this.memberUniqueName);
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
