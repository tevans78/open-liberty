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

package com.ibm.websphere.simplicity.commands.keystore;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a CMS KeyStore with password stash file.
 *   'pluginHostName': Specifies the fully-qualified DNS hostname of the node where the plugin-key.kdb will reside.
 *   'cmsKeyStoreURI': Specifies the path to where the plugin-key.kdb file resides.
 * The required parameters are found in the constructor.
 */
public class CreateCMSKeyStore extends Command {

	private String pluginHostName;
	private String cmsKeyStoreURI;

	public CreateCMSKeyStore(String pluginHostName, String cmsKeyStoreURI) {
		super("createCMSKeyStore");
		this.pluginHostName = pluginHostName;
		this.cmsKeyStoreURI = cmsKeyStoreURI;
	}

	/**
	 * Specifies the fully-qualified DNS hostname of the node where the plugin-key.kdb will reside.
	 */
	public String getPluginHostName() {
		return this.pluginHostName;
	}

	/**
	 * Specifies the fully-qualified DNS hostname of the node where the plugin-key.kdb will reside.
	 */
	public void setPluginHostName(String value) {
		this.pluginHostName = value;
	}

	/**
	 * Specifies the path to where the plugin-key.kdb file resides.
	 */
	public String getCmsKeyStoreURI() {
		return this.cmsKeyStoreURI;
	}

	/**
	 * Specifies the path to where the plugin-key.kdb file resides.
	 */
	public void setCmsKeyStoreURI(String value) {
		this.cmsKeyStoreURI = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("pluginHostName", this.pluginHostName);
		ret.put("cmsKeyStoreURI", this.cmsKeyStoreURI);
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
