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
 * Retrieves the groups in which a group is a member.
 *   'uniqueName': The name that uniquely identifies an object of a virtual member manager entity.
 * The required parameters are found in the constructor.
 */
public class GetMembershipOfGroup extends Command {

	private String uniqueName;

	public GetMembershipOfGroup(String uniqueName) {
		super("getMembershipOfGroup");
		this.uniqueName = uniqueName;
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
