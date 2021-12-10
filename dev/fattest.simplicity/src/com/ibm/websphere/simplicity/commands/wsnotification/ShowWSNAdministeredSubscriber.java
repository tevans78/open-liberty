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
 * Show the properties of a WSNAdministeredSubscriber object in a human readable form.
 *   'endpoint': Endpoint
 *   'topic': Topic
 *   'dialect': Dialect
 *   'namespace': Namespace
 * The required parameters are found in the constructor.
 */
public class ShowWSNAdministeredSubscriber extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String endpoint;
	private String topic;
	private String dialect;
	private String namespace;

	public ShowWSNAdministeredSubscriber(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("showWSNAdministeredSubscriber");
		this.__target = commandTarget;
	}

	/**
	 * Endpoint
	 */
	public String getEndpoint() {
		return this.endpoint;
	}

	/**
	 * Endpoint
	 */
	public void setEndpoint(String value) {
		this.endpoint = value;
	}

	/**
	 * Topic
	 */
	public String getTopic() {
		return this.topic;
	}

	/**
	 * Topic
	 */
	public void setTopic(String value) {
		this.topic = value;
	}

	/**
	 * Dialect
	 */
	public String getDialect() {
		return this.dialect;
	}

	/**
	 * Dialect
	 */
	public void setDialect(String value) {
		this.dialect = value;
	}

	/**
	 * Namespace
	 */
	public String getNamespace() {
		return this.namespace;
	}

	/**
	 * Namespace
	 */
	public void setNamespace(String value) {
		this.namespace = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.endpoint != null) {
			ret.put("endpoint", this.endpoint);
		}
		if (this.topic != null) {
			ret.put("topic", this.topic);
		}
		if (this.dialect != null) {
			ret.put("dialect", this.dialect);
		}
		if (this.namespace != null) {
			ret.put("namespace", this.namespace);
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
