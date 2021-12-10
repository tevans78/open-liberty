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
 * Create a new chain of transport channels based on a chain template.
 *   'endPoint': Name of the end point to be used by the instance of the TCPInboundChannel in the new chain, if the chain is an inbound chain.
 *   'name': Name of the new chain.
 *   'template': Chain template on which to base the new chain.
 * The required parameters are found in the constructor.
 */
public class CreateChain extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private com.ibm.websphere.simplicity.ConfigIdentifier endPoint;
	private java.lang.String name;
	private com.ibm.websphere.simplicity.ConfigIdentifier template;

	public CreateChain(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, java.lang.String name, com.ibm.websphere.simplicity.ConfigIdentifier template) {
		super("createChain");
		this.__target = commandTarget;
		this.name = name;
		this.template = template;
	}

	/**
	 * Name of the end point to be used by the instance of the TCPInboundChannel in the new chain, if the chain is an inbound chain.
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getEndPoint() {
		return this.endPoint;
	}

	/**
	 * Name of the end point to be used by the instance of the TCPInboundChannel in the new chain, if the chain is an inbound chain.
	 */
	public void setEndPoint(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.endPoint = value;
	}

	/**
	 * Name of the new chain.
	 */
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * Name of the new chain.
	 */
	public void setName(java.lang.String value) {
		this.name = value;
	}

	/**
	 * Chain template on which to base the new chain.
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getTemplate() {
		return this.template;
	}

	/**
	 * Chain template on which to base the new chain.
	 */
	public void setTemplate(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.template = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.endPoint != null) {
			ret.put("endPoint", this.endPoint);
		}
		ret.put("name", this.name);
		ret.put("template", this.template);
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
