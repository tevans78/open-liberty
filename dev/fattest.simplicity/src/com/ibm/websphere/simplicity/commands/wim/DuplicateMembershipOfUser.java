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
 * Makes a user a member of the same groups as another user.
 *   'copyFromUniqueName': The uniqueName of the virtual member manager entity from which the membership is copied.
 *   'copyToUniqueName': The uniqueName of the virtual member manager entity to add to the same groups as the specified copyFromUniqueName entity.
 * The required parameters are found in the constructor.
 */
public class DuplicateMembershipOfUser extends Command {

	private String copyFromUniqueName;
	private String copyToUniqueName;

	public DuplicateMembershipOfUser(String copyFromUniqueName, String copyToUniqueName) {
		super("duplicateMembershipOfUser");
		this.copyFromUniqueName = copyFromUniqueName;
		this.copyToUniqueName = copyToUniqueName;
	}

	/**
	 * The uniqueName of the virtual member manager entity from which the membership is copied.
	 */
	public String getCopyFromUniqueName() {
		return this.copyFromUniqueName;
	}

	/**
	 * The uniqueName of the virtual member manager entity from which the membership is copied.
	 */
	public void setCopyFromUniqueName(String value) {
		this.copyFromUniqueName = value;
	}

	/**
	 * The uniqueName of the virtual member manager entity to add to the same groups as the specified copyFromUniqueName entity.
	 */
	public String getCopyToUniqueName() {
		return this.copyToUniqueName;
	}

	/**
	 * The uniqueName of the virtual member manager entity to add to the same groups as the specified copyFromUniqueName entity.
	 */
	public void setCopyToUniqueName(String value) {
		this.copyToUniqueName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("copyFromUniqueName", this.copyFromUniqueName);
		ret.put("copyToUniqueName", this.copyToUniqueName);
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
