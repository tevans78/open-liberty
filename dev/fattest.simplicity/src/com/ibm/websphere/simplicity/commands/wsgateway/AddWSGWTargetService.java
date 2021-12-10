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

package com.ibm.websphere.simplicity.commands.wsgateway;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Add an additional target service to a gateway service.
 *   'name': Name of the target service to be created.
 *   'targetDestination': Name of the target destination.
 *   'targetService': Name of the target outbound service.
 *   'targetBus': Name of the bus where the target is located.
 * The required parameters are found in the constructor.
 */
public class AddWSGWTargetService extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String name;
	private String targetDestination;
	private String targetService;
	private String targetBus;

	public AddWSGWTargetService(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name) {
		super("addWSGWTargetService");
		this.__target = commandTarget;
		this.name = name;
	}

	/**
	 * Name of the target service to be created.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the target service to be created.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of the target destination.
	 */
	public String getTargetDestination() {
		return this.targetDestination;
	}

	/**
	 * Name of the target destination.
	 */
	public void setTargetDestination(String value) {
		this.targetDestination = value;
	}

	/**
	 * Name of the target outbound service.
	 */
	public String getTargetService() {
		return this.targetService;
	}

	/**
	 * Name of the target outbound service.
	 */
	public void setTargetService(String value) {
		this.targetService = value;
	}

	/**
	 * Name of the bus where the target is located.
	 */
	public String getTargetBus() {
		return this.targetBus;
	}

	/**
	 * Name of the bus where the target is located.
	 */
	public void setTargetBus(String value) {
		this.targetBus = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.targetDestination != null) {
			ret.put("targetDestination", this.targetDestination);
		}
		if (this.targetService != null) {
			ret.put("targetService", this.targetService);
		}
		if (this.targetBus != null) {
			ret.put("targetBus", this.targetBus);
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
