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

package com.ibm.websphere.simplicity.commands.policyset;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The setDefaultBindings command updates the default binding names for a specified domain or server.
 *   'defaultBindings': Specifies the names of the default bindings for the provider, client, or both. (Properties)
 *   'bindingLocation': Specifies the location of the binding. This value could be the cell-wide default binding, server-specific default binding, or attachment-specific binding. (Properties)
 *   'domainName': Specifies the name of the domain. The domain name is only required when the domain is not the global security domain. (String)
 * The required parameters are found in the constructor.
 */
public class SetDefaultBindings extends Command {

	private java.util.Properties defaultBindings;
	private java.util.Properties bindingLocation;
	private String domainName;

	public SetDefaultBindings(java.util.Properties defaultBindings) {
		super("setDefaultBindings");
		this.defaultBindings = defaultBindings;
	}

	/**
	 * Specifies the names of the default bindings for the provider, client, or both. (Properties)
	 */
	public java.util.Properties getDefaultBindings() {
		return this.defaultBindings;
	}

	/**
	 * Specifies the names of the default bindings for the provider, client, or both. (Properties)
	 */
	public void setDefaultBindings(java.util.Properties value) {
		this.defaultBindings = value;
	}

	/**
	 * Specifies the location of the binding. This value could be the cell-wide default binding, server-specific default binding, or attachment-specific binding. (Properties)
	 */
	public java.util.Properties getBindingLocation() {
		return this.bindingLocation;
	}

	/**
	 * Specifies the location of the binding. This value could be the cell-wide default binding, server-specific default binding, or attachment-specific binding. (Properties)
	 */
	public void setBindingLocation(java.util.Properties value) {
		this.bindingLocation = value;
	}

	/**
	 * Specifies the name of the domain. The domain name is only required when the domain is not the global security domain. (String)
	 */
	public String getDomainName() {
		return this.domainName;
	}

	/**
	 * Specifies the name of the domain. The domain name is only required when the domain is not the global security domain. (String)
	 */
	public void setDomainName(String value) {
		this.domainName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("defaultBindings", this.defaultBindings);
		if (this.bindingLocation != null) {
			ret.put("bindingLocation", this.bindingLocation);
		}
		if (this.domainName != null) {
			ret.put("domainName", this.domainName);
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
