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
 * Add an instance document to a WS-Notification topic namespace
 *   'url': URL of instance document
 *   'description': Description of the instance document
 * The required parameters are found in the constructor.
 */
public class CreateWSNTopicDocument extends Command {

	private com.ibm.websphere.simplicity.ConfigIdentifier __target;
	private String url;
	private String description;

	public CreateWSNTopicDocument(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String url) {
		super("createWSNTopicDocument");
		this.__target = commandTarget;
		this.url = url;
	}

	/**
	 * URL of instance document
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * URL of instance document
	 */
	public void setUrl(String value) {
		this.url = value;
	}

	/**
	 * Description of the instance document
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description of the instance document
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Change the command's target (originally specified in constructor).
	 */
	public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.__target = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("url", this.url);
		if (this.description != null) {
			ret.put("description", this.description);
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
