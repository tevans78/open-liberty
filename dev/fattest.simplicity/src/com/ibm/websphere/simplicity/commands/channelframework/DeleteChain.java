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

package com.ibm.websphere.simplicity.commands.channelframework;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Delete an existing chain and, optionally, the transport channels in the chain.
 *   'deleteChannels': If specified, non-shared transport channels used by the specified chain will also be deleted.
 * The required parameters are found in the constructor.
 */
public class DeleteChain extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private java.lang.Boolean deleteChannels;

	public DeleteChain(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("deleteChain");
		this.__target = commandTarget;
	}

	/**
	 * If specified, non-shared transport channels used by the specified chain will also be deleted.
	 */
	public java.lang.Boolean getDeleteChannels() {
		return this.deleteChannels;
	}

	/**
	 * If specified, non-shared transport channels used by the specified chain will also be deleted.
	 */
	public void setDeleteChannels(java.lang.Boolean value) {
		this.deleteChannels = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.deleteChannels != null) {
			ret.put("deleteChannels", this.deleteChannels);
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
