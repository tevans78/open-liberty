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

package com.ibm.websphere.simplicity.commands.wsnotification;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Delete a WS-Notification service
 *   'deleteSIBTopicSpaces': Indicates whether service integration bus topic spaces created by definition of a WSNTopicNamespace should also be deleted (default is False).
 * The required parameters are found in the constructor.
 */
public class DeleteWSNService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private Boolean deleteSIBTopicSpaces;

	public DeleteWSNService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("deleteWSNService");
		this.__target = commandTarget;
	}

	/**
	 * Indicates whether service integration bus topic spaces created by definition of a WSNTopicNamespace should also be deleted (default is False).
	 */
	public Boolean getDeleteSIBTopicSpaces() {
		return this.deleteSIBTopicSpaces;
	}

	/**
	 * Indicates whether service integration bus topic spaces created by definition of a WSNTopicNamespace should also be deleted (default is False).
	 */
	public void setDeleteSIBTopicSpaces(Boolean value) {
		this.deleteSIBTopicSpaces = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.deleteSIBTopicSpaces != null) {
			ret.put("deleteSIBTopicSpaces", this.deleteSIBTopicSpaces);
		}
		return ret;
	}

	public Object __getTarget() {
		return this.__target;
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
