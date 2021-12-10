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

package com.ibm.websphere.simplicity.commands.idmgrconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Updates a supported entity type configuration.
 *   'defaultParent': The default parent of the supported entity type. By default, this is where the supported entity type is created.
 *   'rdnProperties': A semicolon separated list of relative distinguished name properties for the supported entity. To reset all the values of the rdnProperties parameter, specify a blank string ("").
 *   'name': The name of the supported entity type.
 * The required parameters are found in the constructor.
 */
public class UpdateIdMgrSupportedEntityType extends Command {

	private String defaultParent;
	private String rdnProperties;
	private String name;

	public UpdateIdMgrSupportedEntityType(String name) {
		super("updateIdMgrSupportedEntityType");
		this.name = name;
	}

	/**
	 * The default parent of the supported entity type. By default, this is where the supported entity type is created.
	 */
	public String getDefaultParent() {
		return this.defaultParent;
	}

	/**
	 * The default parent of the supported entity type. By default, this is where the supported entity type is created.
	 */
	public void setDefaultParent(String value) {
		this.defaultParent = value;
	}

	/**
	 * A semicolon separated list of relative distinguished name properties for the supported entity. To reset all the values of the rdnProperties parameter, specify a blank string ("").
	 */
	public String getRdnProperties() {
		return this.rdnProperties;
	}

	/**
	 * A semicolon separated list of relative distinguished name properties for the supported entity. To reset all the values of the rdnProperties parameter, specify a blank string ("").
	 */
	public void setRdnProperties(String value) {
		this.rdnProperties = value;
	}

	/**
	 * The name of the supported entity type.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * The name of the supported entity type.
	 */
	public void setName(String value) {
		this.name = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.defaultParent != null) {
			ret.put("defaultParent", this.defaultParent);
		}
		if (this.rdnProperties != null) {
			ret.put("rdnProperties", this.rdnProperties);
		}
		ret.put("name", this.name);
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
