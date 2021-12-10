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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a new Server Type ie (APPLICATION_SERVER)
 *   'version': The Product Version
 *   'serverType': The ServerType ie: (APPLICATION_SERVER)
 *   'createTemplateCommand': The Command used to create a Server Template
 *   'createCommand': The Command used to create a Server
 *   'defaultTemplateName': The name of the default Template (non-z/OS)
 *   'defaultzOSTemplateName': The name of the default z/OS Template (non-z/OS)
 *   'configValidator': The name of the Config Validator class
 * The required parameters are found in the constructor.
 */
public class CreateServerType extends Command {

	private String version;
	private String serverType;
	private String createTemplateCommand;
	private String createCommand;
	private String defaultTemplateName = "default";
	private String defaultzOSTemplateName = "default_zOS";
	private String configValidator;

	public CreateServerType(String version, String serverType, String createTemplateCommand, String createCommand, String configValidator) {
		super("createServerType");
		this.version = version;
		this.serverType = serverType;
		this.createTemplateCommand = createTemplateCommand;
		this.createCommand = createCommand;
		this.configValidator = configValidator;
	}

	/**
	 * The Product Version
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * The Product Version
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * The ServerType ie: (APPLICATION_SERVER)
	 */
	public String getServerType() {
		return this.serverType;
	}

	/**
	 * The ServerType ie: (APPLICATION_SERVER)
	 */
	public void setServerType(String value) {
		this.serverType = value;
	}

	/**
	 * The Command used to create a Server Template
	 */
	public String getCreateTemplateCommand() {
		return this.createTemplateCommand;
	}

	/**
	 * The Command used to create a Server Template
	 */
	public void setCreateTemplateCommand(String value) {
		this.createTemplateCommand = value;
	}

	/**
	 * The Command used to create a Server
	 */
	public String getCreateCommand() {
		return this.createCommand;
	}

	/**
	 * The Command used to create a Server
	 */
	public void setCreateCommand(String value) {
		this.createCommand = value;
	}

	/**
	 * The name of the default Template (non-z/OS)
	 */
	public String getDefaultTemplateName() {
		return this.defaultTemplateName;
	}

	/**
	 * The name of the default Template (non-z/OS)
	 */
	public void setDefaultTemplateName(String value) {
		this.defaultTemplateName = value;
	}

	/**
	 * The name of the default z/OS Template (non-z/OS)
	 */
	public String getDefaultzOSTemplateName() {
		return this.defaultzOSTemplateName;
	}

	/**
	 * The name of the default z/OS Template (non-z/OS)
	 */
	public void setDefaultzOSTemplateName(String value) {
		this.defaultzOSTemplateName = value;
	}

	/**
	 * The name of the Config Validator class
	 */
	public String getConfigValidator() {
		return this.configValidator;
	}

	/**
	 * The name of the Config Validator class
	 */
	public void setConfigValidator(String value) {
		this.configValidator = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("version", this.version);
		ret.put("serverType", this.serverType);
		ret.put("createTemplateCommand", this.createTemplateCommand);
		ret.put("createCommand", this.createCommand);
		if (this.defaultTemplateName != null) {
			ret.put("defaultTemplateName", this.defaultTemplateName);
		}
		if (this.defaultzOSTemplateName != null) {
			ret.put("defaultzOSTemplateName", this.defaultzOSTemplateName);
		}
		ret.put("configValidator", this.configValidator);
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
