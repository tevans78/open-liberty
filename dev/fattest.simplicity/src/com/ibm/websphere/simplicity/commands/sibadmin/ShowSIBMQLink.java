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

package com.ibm.websphere.simplicity.commands.sibadmin;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Show detail for a WebSphere MQ link.
 *   'bus': The name of the bus.
 *   'messagingEngine': The name of the messaging engine.
 *   'mqLink': The name of the WebSphere MQ link.
 *   'javaFormat': The output from the command is a format suitable for java program clients.
 * The required parameters are found in the constructor.
 */
public class ShowSIBMQLink extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String bus;
	private String messagingEngine;
	private String mqLink;
	private Boolean javaFormat = true;

	public ShowSIBMQLink(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("showSIBMQLink");
		this.__target = commandTarget;
	}

	/**
	 * The name of the bus.
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * The name of the bus.
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * The name of the messaging engine.
	 */
	public String getMessagingEngine() {
		return this.messagingEngine;
	}

	/**
	 * The name of the messaging engine.
	 */
	public void setMessagingEngine(String value) {
		this.messagingEngine = value;
	}

	/**
	 * The name of the WebSphere MQ link.
	 */
	public String getMqLink() {
		return this.mqLink;
	}

	/**
	 * The name of the WebSphere MQ link.
	 */
	public void setMqLink(String value) {
		this.mqLink = value;
	}

	/**
	 * The output from the command is a format suitable for java program clients.
	 */
	public Boolean getJavaFormat() {
		return this.javaFormat;
	}

	/**
	 * The output from the command is a format suitable for java program clients.
	 */
	public void setJavaFormat(Boolean value) {
		this.javaFormat = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.bus != null) {
			ret.put("bus", this.bus);
		}
		if (this.messagingEngine != null) {
			ret.put("messagingEngine", this.messagingEngine);
		}
		if (this.mqLink != null) {
			ret.put("mqLink", this.mqLink);
		}
		if (this.javaFormat != null) {
			ret.put("javaFormat", this.javaFormat);
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
