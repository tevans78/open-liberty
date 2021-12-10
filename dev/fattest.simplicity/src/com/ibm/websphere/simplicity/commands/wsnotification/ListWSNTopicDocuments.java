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
 * Lists all the WSNTopicDocument objects in the configuration of the target WSNTopicNamespace that match the specified input parameters.
 *   'url': URL
 * The required parameters are found in the constructor.
 */
public class ListWSNTopicDocuments extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String url;

	public ListWSNTopicDocuments(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget) {
		super("listWSNTopicDocuments");
		this.__target = commandTarget;
	}

	/**
	 * URL
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * URL
	 */
	public void setUrl(String value) {
		this.url = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.url != null) {
			ret.put("url", this.url);
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
