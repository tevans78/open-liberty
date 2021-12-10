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

package com.ibm.websphere.simplicity.commands.wmqadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Provides the ability to manage the settings associated with the WMQ resource adapter installed at a particular scope.
 *   'enableInbound': Enables inbound JCA message delivery for the z/OS platform.
 *   'nativePath': Specifies the path to the WMQ messaging provider native libraries to be used if the WMQ resource adapter is to establish a bindings mode connection to the queue manager.
 *   'query': Provides information about the WMQ messaging provider.  This can be the WMQ resource adapter installed into WAS, or a WMQ resource adapter present on the filesystem of the node.
 * The required parameters are found in the constructor.
 */
public class ManageWMQ extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private Boolean enableInbound;
	private String nativePath;
	private String query;

	public ManageWMQ(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("manageWMQ");
		this.__target = commandTarget;
	}

	/**
	 * Enables inbound JCA message delivery for the z/OS platform.
	 */
	public Boolean getEnableInbound() {
		return this.enableInbound;
	}

	/**
	 * Enables inbound JCA message delivery for the z/OS platform.
	 */
	public void setEnableInbound(Boolean value) {
		this.enableInbound = value;
	}

	/**
	 * Specifies the path to the WMQ messaging provider native libraries to be used if the WMQ resource adapter is to establish a bindings mode connection to the queue manager.
	 */
	public String getNativePath() {
		return this.nativePath;
	}

	/**
	 * Specifies the path to the WMQ messaging provider native libraries to be used if the WMQ resource adapter is to establish a bindings mode connection to the queue manager.
	 */
	public void setNativePath(String value) {
		this.nativePath = value;
	}

	/**
	 * Provides information about the WMQ messaging provider.  This can be the WMQ resource adapter installed into WAS, or a WMQ resource adapter present on the filesystem of the node.
	 */
	public String getQuery() {
		return this.query;
	}

	/**
	 * Provides information about the WMQ messaging provider.  This can be the WMQ resource adapter installed into WAS, or a WMQ resource adapter present on the filesystem of the node.
	 */
	public void setQuery(String value) {
		this.query = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.enableInbound != null) {
			ret.put("enableInbound", this.enableInbound);
		}
		if (this.nativePath != null) {
			ret.put("nativePath", this.nativePath);
		}
		if (this.query != null) {
			ret.put("query", this.query);
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
