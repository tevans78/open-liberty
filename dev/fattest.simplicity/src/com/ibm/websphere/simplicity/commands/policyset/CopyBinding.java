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
 * The copyBinding command creates a copy of an existing binding.
 *   'sourceBinding': Specifies the name of the existing binding. (String)
 *   'newBinding': Specifies the name of the binding to which the bindings are copied. (String)
 *   'newDescription': Adds a description for the policy set or binding. (String)
 *   'domainName': Specifies the name of the domain. The domain name is only required when the domain is not the global security domain. (String)
 * The required parameters are found in the constructor.
 */
public class CopyBinding extends Command {

	private String sourceBinding;
	private String newBinding;
	private String newDescription;
	private String domainName;

	public CopyBinding(String sourceBinding, String newBinding) {
		super("copyBinding");
		this.sourceBinding = sourceBinding;
		this.newBinding = newBinding;
	}

	/**
	 * Specifies the name of the existing binding. (String)
	 */
	public String getSourceBinding() {
		return this.sourceBinding;
	}

	/**
	 * Specifies the name of the existing binding. (String)
	 */
	public void setSourceBinding(String value) {
		this.sourceBinding = value;
	}

	/**
	 * Specifies the name of the binding to which the bindings are copied. (String)
	 */
	public String getNewBinding() {
		return this.newBinding;
	}

	/**
	 * Specifies the name of the binding to which the bindings are copied. (String)
	 */
	public void setNewBinding(String value) {
		this.newBinding = value;
	}

	/**
	 * Adds a description for the policy set or binding. (String)
	 */
	public String getNewDescription() {
		return this.newDescription;
	}

	/**
	 * Adds a description for the policy set or binding. (String)
	 */
	public void setNewDescription(String value) {
		this.newDescription = value;
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
		ret.put("sourceBinding", this.sourceBinding);
		ret.put("newBinding", this.newBinding);
		if (this.newDescription != null) {
			ret.put("newDescription", this.newDescription);
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
