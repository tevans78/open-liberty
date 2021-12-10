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

package com.ibm.websphere.simplicity.commands.auditreader;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Displays information about the keystore used during Audit Record encryption
 *   'fileName': Specifies the fully qualified path of the Binary Audit Log
 * The required parameters are found in the constructor.
 */
public class ShowAuditLogEncryptionInfo extends Command {

	private String fileName;

	public ShowAuditLogEncryptionInfo(String fileName) {
		super("showAuditLogEncryptionInfo");
		this.fileName = fileName;
	}

	/**
	 * Specifies the fully qualified path of the Binary Audit Log
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Specifies the fully qualified path of the Binary Audit Log
	 */
	public void setFileName(String value) {
		this.fileName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("fileName", this.fileName);
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
