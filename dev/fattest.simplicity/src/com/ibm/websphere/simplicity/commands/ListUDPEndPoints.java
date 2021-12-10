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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Lists all the NamedEndPoints endpoints that can be associated with a UDPInboundChannel
 *   'excludeDistinguished': If specified,  this command shows only non-distinguished NamedEndPoints endpoints.
 *   'unusedOnly': If specified, this command shows only the NamedEndPoints endpoints that are not in use by other UDPInboundChannel instances.
 * The required parameters are found in the constructor.
 */
public class ListUDPEndPoints extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private java.lang.Boolean excludeDistinguished;
	private java.lang.Boolean unusedOnly;

	public ListUDPEndPoints(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("listUDPEndPoints");
		this.__target = commandTarget;
	}

	/**
	 * If specified,  this command shows only non-distinguished NamedEndPoints endpoints.
	 */
	public java.lang.Boolean getExcludeDistinguished() {
		return this.excludeDistinguished;
	}

	/**
	 * If specified,  this command shows only non-distinguished NamedEndPoints endpoints.
	 */
	public void setExcludeDistinguished(java.lang.Boolean value) {
		this.excludeDistinguished = value;
	}

	/**
	 * If specified, this command shows only the NamedEndPoints endpoints that are not in use by other UDPInboundChannel instances.
	 */
	public java.lang.Boolean getUnusedOnly() {
		return this.unusedOnly;
	}

	/**
	 * If specified, this command shows only the NamedEndPoints endpoints that are not in use by other UDPInboundChannel instances.
	 */
	public void setUnusedOnly(java.lang.Boolean value) {
		this.unusedOnly = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.excludeDistinguished != null) {
			ret.put("excludeDistinguished", this.excludeDistinguished);
		}
		if (this.unusedOnly != null) {
			ret.put("unusedOnly", this.unusedOnly);
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
