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
 * List all chains configured under a particular instance of TransportChannelService.
 *   'acceptorFilter': Chains returned by this method should all have a transport channel instance of the specified type as the last transport channel in the chain.
 *   'endPointFilter': Chains returned by this method should all have a TCPInboundChannel using an end point with the specified name.
 * The required parameters are found in the constructor.
 */
public class ListChains extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private java.lang.String acceptorFilter;
	private java.lang.String endPointFilter;

	public ListChains(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("listChains");
		this.__target = commandTarget;
	}

	/**
	 * Chains returned by this method should all have a transport channel instance of the specified type as the last transport channel in the chain.
	 */
	public java.lang.String getAcceptorFilter() {
		return this.acceptorFilter;
	}

	/**
	 * Chains returned by this method should all have a transport channel instance of the specified type as the last transport channel in the chain.
	 */
	public void setAcceptorFilter(java.lang.String value) {
		this.acceptorFilter = value;
	}

	/**
	 * Chains returned by this method should all have a TCPInboundChannel using an end point with the specified name.
	 */
	public java.lang.String getEndPointFilter() {
		return this.endPointFilter;
	}

	/**
	 * Chains returned by this method should all have a TCPInboundChannel using an end point with the specified name.
	 */
	public void setEndPointFilter(java.lang.String value) {
		this.endPointFilter = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.acceptorFilter != null) {
			ret.put("acceptorFilter", this.acceptorFilter);
		}
		if (this.endPointFilter != null) {
			ret.put("endPointFilter", this.endPointFilter);
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
