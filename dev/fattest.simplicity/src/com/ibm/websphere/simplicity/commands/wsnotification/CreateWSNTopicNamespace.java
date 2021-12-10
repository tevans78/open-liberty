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
 * Create a WS-Notification topic namespace
 *   'namespace': Namespace of the WS-Notification topic namespace
 *   'busTopicSpace': Name of the service integration bus topic space to assign to this WS-Notification topic namespace
 *   'reliability': The service integration bus reliability to be applied to all messages published using this topic namespace
 * The required parameters are found in the constructor.
 */
public class CreateWSNTopicNamespace extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String namespace;
	private String busTopicSpace;
	private String reliability;

	public CreateWSNTopicNamespace(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String namespace, String busTopicSpace) {
		super("createWSNTopicNamespace");
		this.__target = commandTarget;
		this.namespace = namespace;
		this.busTopicSpace = busTopicSpace;
	}

	/**
	 * Namespace of the WS-Notification topic namespace
	 */
	public String getNamespace() {
		return this.namespace;
	}

	/**
	 * Namespace of the WS-Notification topic namespace
	 */
	public void setNamespace(String value) {
		this.namespace = value;
	}

	/**
	 * Name of the service integration bus topic space to assign to this WS-Notification topic namespace
	 */
	public String getBusTopicSpace() {
		return this.busTopicSpace;
	}

	/**
	 * Name of the service integration bus topic space to assign to this WS-Notification topic namespace
	 */
	public void setBusTopicSpace(String value) {
		this.busTopicSpace = value;
	}

	/**
	 * The service integration bus reliability to be applied to all messages published using this topic namespace
	 */
	public String getReliability() {
		return this.reliability;
	}

	/**
	 * The service integration bus reliability to be applied to all messages published using this topic namespace
	 */
	public void setReliability(String value) {
		this.reliability = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("namespace", this.namespace);
		ret.put("busTopicSpace", this.busTopicSpace);
		if (this.reliability != null) {
			ret.put("reliability", this.reliability);
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
