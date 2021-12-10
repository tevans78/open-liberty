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

package com.ibm.websphere.simplicity.commands.server;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * creates a server Template based on a server configuration
 *   'templateName': The Template Name
 *   'serverName': The Server Name
 *   'nodeName': The Node Name
 *   'description': Description for the created Server Template.
 *   'templateLocation': The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
 * The required parameters are found in the constructor.
 */
public class CreateGenericServerTemplate extends Command {

	private String templateName;
	private String serverName;
	private String nodeName;
	private String description;
	private com.ibm.websphere.simplicity.ConfigIdentifier templateLocation;

	public CreateGenericServerTemplate(String templateName, String serverName, String nodeName) {
		super("createGenericServerTemplate");
		this.templateName = templateName;
		this.serverName = serverName;
		this.nodeName = nodeName;
	}

	/**
	 * The Template Name
	 */
	public String getTemplateName() {
		return this.templateName;
	}

	/**
	 * The Template Name
	 */
	public void setTemplateName(String value) {
		this.templateName = value;
	}

	/**
	 * The Server Name
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * The Server Name
	 */
	public void setServerName(String value) {
		this.serverName = value;
	}

	/**
	 * The Node Name
	 */
	public String getNodeName() {
		return this.nodeName;
	}

	/**
	 * The Node Name
	 */
	public void setNodeName(String value) {
		this.nodeName = value;
	}

	/**
	 * Description for the created Server Template.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Description for the created Server Template.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
	 */
	public com.ibm.websphere.simplicity.ConfigIdentifier getTemplateLocation() {
		return this.templateLocation;
	}

	/**
	 * The location where the template is stored. Use system defined location if it is not specified. Using system defined location is recommended.
	 */
	public void setTemplateLocation(com.ibm.websphere.simplicity.ConfigIdentifier value) {
		this.templateLocation = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("templateName", this.templateName);
		ret.put("serverName", this.serverName);
		ret.put("nodeName", this.nodeName);
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.templateLocation != null) {
			ret.put("templateLocation", this.templateLocation);
		}
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
