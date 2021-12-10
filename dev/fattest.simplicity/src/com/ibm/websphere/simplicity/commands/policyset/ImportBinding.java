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
 * The importBinding command imports a binding from a compressed archive onto a server environment.
 *   'importFile': Specifies the path name of the archive file to import. (String)
 *   'bindingName': Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
 *   'domainName': Specifies the name of the domain. The domain name is only required when the domain is not the global security domain. (String)
 *   'verifyBindingType': Verifies the binding is of this type. (String)
 * The required parameters are found in the constructor.
 */
public class ImportBinding extends Command {

	private String importFile;
	private String bindingName;
	private String domainName;
	private String verifyBindingType;

	public ImportBinding(String importFile) {
		super("importBinding");
		this.importFile = importFile;
	}

	/**
	 * Specifies the path name of the archive file to import. (String)
	 */
	public String getImportFile() {
		return this.importFile;
	}

	/**
	 * Specifies the path name of the archive file to import. (String)
	 */
	public void setImportFile(String value) {
		this.importFile = value;
	}

	/**
	 * Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
	 */
	public String getBindingName() {
		return this.bindingName;
	}

	/**
	 * Specifies the name for the binding. The binding name is optional when you are creating a new binding. A name is generated if it is not specified. The binding name is required when you are changing an attachment to use a different existing binding. (String)
	 */
	public void setBindingName(String value) {
		this.bindingName = value;
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

	/**
	 * Verifies the binding is of this type. (String)
	 */
	public String getVerifyBindingType() {
		return this.verifyBindingType;
	}

	/**
	 * Verifies the binding is of this type. (String)
	 */
	public void setVerifyBindingType(String value) {
		this.verifyBindingType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("importFile", this.importFile);
		if (this.bindingName != null) {
			ret.put("bindingName", this.bindingName);
		}
		if (this.domainName != null) {
			ret.put("domainName", this.domainName);
		}
		if (this.verifyBindingType != null) {
			ret.put("verifyBindingType", this.verifyBindingType);
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
