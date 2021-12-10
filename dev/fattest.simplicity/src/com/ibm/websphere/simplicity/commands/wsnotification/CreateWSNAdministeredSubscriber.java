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
 * Add an administered subscriber to a WS-Notification service point
 *   'endpoint': Endpoint
 *   'topic': Topic expression
 *   'dialect': Dialect expression
 *   'topicNamespace': Topic namespace
 *   'remoteSubscriptionTimeout': Remote subscription timeout
 * The required parameters are found in the constructor.
 */
public class CreateWSNAdministeredSubscriber extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String endpoint;
	private String topic;
	private String dialect;
	private String topicNamespace;
	private Integer remoteSubscriptionTimeout;

	public CreateWSNAdministeredSubscriber(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String endpoint, String topic, String dialect) {
		super("createWSNAdministeredSubscriber");
		this.__target = commandTarget;
		this.endpoint = endpoint;
		this.topic = topic;
		this.dialect = dialect;
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
	 * Topic expression
	 */
	public String getTopic() {
		return this.topic;
	}

	/**
	 * Topic expression
	 */
	public void setTopic(String value) {
		this.topic = value;
	}

	/**
	 * Dialect expression
	 */
	public String getDialect() {
		return this.dialect;
	}

	/**
	 * Dialect expression
	 */
	public void setDialect(String value) {
		this.dialect = value;
	}

	/**
	 * Topic namespace
	 */
	public String getTopicNamespace() {
		return this.topicNamespace;
	}

	/**
	 * Topic namespace
	 */
	public void setTopicNamespace(String value) {
		this.topicNamespace = value;
	}

	/**
	 * Remote subscription timeout
	 */
	public Integer getRemoteSubscriptionTimeout() {
		return this.remoteSubscriptionTimeout;
	}

	/**
	 * Remote subscription timeout
	 */
	public void setRemoteSubscriptionTimeout(Integer value) {
		this.remoteSubscriptionTimeout = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("endpoint", this.endpoint);
		ret.put("topic", this.topic);
		ret.put("dialect", this.dialect);
		if (this.topicNamespace != null) {
			ret.put("topicNamespace", this.topicNamespace);
		}
		if (this.remoteSubscriptionTimeout != null) {
			ret.put("remoteSubscriptionTimeout", this.remoteSubscriptionTimeout);
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
