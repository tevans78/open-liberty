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

package com.ibm.websphere.simplicity.commands.template;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Removes set of templates that are not required anymore when a feature pack or stack product is removed.
 *   'featureTemplateNames': Feature pack or stack product templates to be removed.
 *   'serverType': Server type that needs removal of some templates
 *   'removeDocuments': Remove template documents also or not. By default template documents are removed
 * The required parameters are found in the constructor.
 */
public class RemoveTemplates extends Command {

	private java.lang.String[] featureTemplateNames;
	private String serverType;
	private Boolean removeDocuments = false;

	public RemoveTemplates(java.lang.String[] featureTemplateNames, String serverType) {
		super("removeTemplates");
		this.featureTemplateNames = featureTemplateNames;
		this.serverType = serverType;
	}

	/**
	 * Feature pack or stack product templates to be removed.
	 */
	public java.lang.String[] getFeatureTemplateNames() {
		return this.featureTemplateNames;
	}

	/**
	 * Feature pack or stack product templates to be removed.
	 */
	public void setFeatureTemplateNames(java.lang.String[] value) {
		this.featureTemplateNames = value;
	}

	/**
	 * Server type that needs removal of some templates
	 */
	public String getServerType() {
		return this.serverType;
	}

	/**
	 * Server type that needs removal of some templates
	 */
	public void setServerType(String value) {
		this.serverType = value;
	}

	/**
	 * Remove template documents also or not. By default template documents are removed
	 */
	public Boolean getRemoveDocuments() {
		return this.removeDocuments;
	}

	/**
	 * Remove template documents also or not. By default template documents are removed
	 */
	public void setRemoveDocuments(Boolean value) {
		this.removeDocuments = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("featureTemplateNames", this.featureTemplateNames);
		ret.put("serverType", this.serverType);
		if (this.removeDocuments != null) {
			ret.put("removeDocuments", this.removeDocuments);
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
