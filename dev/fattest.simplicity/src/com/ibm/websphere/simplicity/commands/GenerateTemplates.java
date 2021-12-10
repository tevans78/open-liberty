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
 * Generates new set of templates by combining WAS base product templates with feature pack and/or stack product templates
 *   'featureTemplateNames': Feature pack or stack product templates that need to be combined with base templates
 *   'serverType': Server type that needs generation of templates
 * The required parameters are found in the constructor.
 */
public class GenerateTemplates extends Command {

	private java.lang.String[] featureTemplateNames;
	private String serverType;

	public GenerateTemplates() {
		super("generateTemplates");
	}

	/**
	 * Feature pack or stack product templates that need to be combined with base templates
	 */
	public java.lang.String[] getFeatureTemplateNames() {
		return this.featureTemplateNames;
	}

	/**
	 * Feature pack or stack product templates that need to be combined with base templates
	 */
	public void setFeatureTemplateNames(java.lang.String[] value) {
		this.featureTemplateNames = value;
	}

	/**
	 * Server type that needs generation of templates
	 */
	public String getServerType() {
		return this.serverType;
	}

	/**
	 * Server type that needs generation of templates
	 */
	public void setServerType(String value) {
		this.serverType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.featureTemplateNames != null) {
			ret.put("featureTemplateNames", this.featureTemplateNames);
		}
		if (this.serverType != null) {
			ret.put("serverType", this.serverType);
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
