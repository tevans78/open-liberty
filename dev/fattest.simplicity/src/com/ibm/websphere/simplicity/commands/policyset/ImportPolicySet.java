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
 * The importPolicySet command imports a policy set from a compressed archive onto a server environment.
 *   'importFile': Specifies the path name of the archive file to import. (String)
 *   'defaultPolicySet': The name of the default policy set to import (String)
 *   'policySet': Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
 *   'verifyPolicySetType': Verifies the policy set is of this type. (String)
 * The required parameters are found in the constructor.
 */
public class ImportPolicySet extends Command {

	private String importFile;
	private String defaultPolicySet;
	private String policySet;
	private String verifyPolicySetType;

	public ImportPolicySet() {
		super("importPolicySet");
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
	 * The name of the default policy set to import (String)
	 */
	public String getDefaultPolicySet() {
		return this.defaultPolicySet;
	}

	/**
	 * The name of the default policy set to import (String)
	 */
	public void setDefaultPolicySet(String value) {
		this.defaultPolicySet = value;
	}

	/**
	 * Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
	 */
	public String getPolicySet() {
		return this.policySet;
	}

	/**
	 * Specifies the policy set name. For a list of all policy set names, use the listPolicySets command. (String)
	 */
	public void setPolicySet(String value) {
		this.policySet = value;
	}

	/**
	 * Verifies the policy set is of this type. (String)
	 */
	public String getVerifyPolicySetType() {
		return this.verifyPolicySetType;
	}

	/**
	 * Verifies the policy set is of this type. (String)
	 */
	public void setVerifyPolicySetType(String value) {
		this.verifyPolicySetType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.importFile != null) {
			ret.put("importFile", this.importFile);
		}
		if (this.defaultPolicySet != null) {
			ret.put("defaultPolicySet", this.defaultPolicySet);
		}
		if (this.policySet != null) {
			ret.put("policySet", this.policySet);
		}
		if (this.verifyPolicySetType != null) {
			ret.put("verifyPolicySetType", this.verifyPolicySetType);
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
