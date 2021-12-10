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
 * Updates the attributes of a group.
 *   'cn': The common name of the entity.
 *   'description': A description of a group.
 *   'uniqueName': The name that uniquely identifies an object of a virtual member manager entity.
 * The required parameters are found in the constructor.
 */
public class UpdateGroup extends Command {

	private String cn;
	private String description;
	private String uniqueName;

	public UpdateGroup(String uniqueName) {
		super("updateGroup");
		this.uniqueName = uniqueName;
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
	 * The name that uniquely identifies an object of a virtual member manager entity.
	 */
	public String getUniqueName() {
		return this.uniqueName;
	}

	/**
	 * The name that uniquely identifies an object of a virtual member manager entity.
	 */
	public void setUniqueName(String value) {
		this.uniqueName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.cn != null) {
			ret.put("cn", this.cn);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		ret.put("uniqueName", this.uniqueName);
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
