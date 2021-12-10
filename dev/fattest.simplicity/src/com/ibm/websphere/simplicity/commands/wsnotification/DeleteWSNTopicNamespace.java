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
 * Delete a WS-Notification topic namespace
 *   'deleteSIBTopicSpace': Indicates whether service integration bus topic space created by definition of a WSNTopicNamespace should also be deleted.
 * The required parameters are found in the constructor.
 */
public class DeleteWSNTopicNamespace extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private Boolean deleteSIBTopicSpace = false;

	public DeleteWSNTopicNamespace(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("deleteWSNTopicNamespace");
		this.__target = commandTarget;
	}

	/**
	 * Indicates whether service integration bus topic space created by definition of a WSNTopicNamespace should also be deleted.
	 */
	public Boolean getDeleteSIBTopicSpace() {
		return this.deleteSIBTopicSpace;
	}

	/**
	 * Indicates whether service integration bus topic space created by definition of a WSNTopicNamespace should also be deleted.
	 */
	public void setDeleteSIBTopicSpace(Boolean value) {
		this.deleteSIBTopicSpace = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.deleteSIBTopicSpace != null) {
			ret.put("deleteSIBTopicSpace", this.deleteSIBTopicSpace);
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
