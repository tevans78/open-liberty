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

package com.ibm.websphere.simplicity.commands.sibadminbussecurity;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Allows the override for receiver inheritance for an individual topic on a specified topic space.  Setting the "inherit" value to true will allow the topic to inherit from the default values.
 *   'bus': Bus name
 *   'topicSpace': Topicspace name
 *   'topic': Topic name
 *   'inherit': Inherit receiver defaults (True by default)
 * The required parameters are found in the constructor.
 */
public class SetInheritReceiverForTopic extends Command {

	private String bus;
	private String topicSpace;
	private String topic;
	private Boolean inherit = true;

	public SetInheritReceiverForTopic(String bus, String topicSpace, String topic, Boolean inherit) {
		super("setInheritReceiverForTopic");
		this.bus = bus;
		this.topicSpace = topicSpace;
		this.topic = topic;
		this.inherit = inherit;
	}

	/**
	 * Bus name
	 */
	public String getBus() {
		return this.bus;
	}

	/**
	 * Bus name
	 */
	public void setBus(String value) {
		this.bus = value;
	}

	/**
	 * Topicspace name
	 */
	public String getTopicSpace() {
		return this.topicSpace;
	}

	/**
	 * Topicspace name
	 */
	public void setTopicSpace(String value) {
		this.topicSpace = value;
	}

	/**
	 * Topic name
	 */
	public String getTopic() {
		return this.topic;
	}

	/**
	 * Topic name
	 */
	public void setTopic(String value) {
		this.topic = value;
	}

	/**
	 * Inherit receiver defaults (True by default)
	 */
	public Boolean getInherit() {
		return this.inherit;
	}

	/**
	 * Inherit receiver defaults (True by default)
	 */
	public void setInherit(Boolean value) {
		this.inherit = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("bus", this.bus);
		ret.put("topicSpace", this.topicSpace);
		ret.put("topic", this.topic);
		ret.put("inherit", this.inherit);
		return ret;
	}

	public Object __getTarget() {
		return null;
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
