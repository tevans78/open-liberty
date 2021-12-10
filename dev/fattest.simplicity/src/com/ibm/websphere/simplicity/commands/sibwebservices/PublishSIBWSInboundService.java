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

package com.ibm.websphere.simplicity.commands.sibwebservices;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Publish an inbound service to a UDDI registry.
 *   'uddiPublication': Name of a UDDI publication for the inbound service.
 *   'userId': User ID to be used if publishing is done through an authenticating proxy.
 *   'password': Password to be used if publishing is done through an authenticating proxy.
 * The required parameters are found in the constructor.
 */
public class PublishSIBWSInboundService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String uddiPublication;
	private String userId;
	private String password;

	public PublishSIBWSInboundService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String uddiPublication) {
		super("publishSIBWSInboundService");
		this.__target = commandTarget;
		this.uddiPublication = uddiPublication;
	}

	/**
	 * Name of a UDDI publication for the inbound service.
	 */
	public String getUddiPublication() {
		return this.uddiPublication;
	}

	/**
	 * Name of a UDDI publication for the inbound service.
	 */
	public void setUddiPublication(String value) {
		this.uddiPublication = value;
	}

	/**
	 * User ID to be used if publishing is done through an authenticating proxy.
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * User ID to be used if publishing is done through an authenticating proxy.
	 */
	public void setUserId(String value) {
		this.userId = value;
	}

	/**
	 * Password to be used if publishing is done through an authenticating proxy.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Password to be used if publishing is done through an authenticating proxy.
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("uddiPublication", this.uddiPublication);
		if (this.userId != null) {
			ret.put("userId", this.userId);
		}
		if (this.password != null) {
			ret.put("password", this.password);
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
