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

package com.ibm.websphere.simplicity.commands.auditkeystore;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Deletes an existing Key Store.
 *   'scopeName': Specifies the management scope
 *   'keyStoreName': Specifies the unique name to identify the key store.
 *   'removeKeyStoreFile': Specify true to remove the key store file or false to leave the key store file.
 * The required parameters are found in the constructor.
 */
public class DeleteAuditKeyStore extends Command {

	private String scopeName;
	private String keyStoreName;
	private Boolean removeKeyStoreFile = false;

	public DeleteAuditKeyStore(String keyStoreName) {
		super("deleteAuditKeyStore");
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Specifies the management scope
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the unique name to identify the key store.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the key store.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	/**
	 * Specify true to remove the key store file or false to leave the key store file.
	 */
	public Boolean getRemoveKeyStoreFile() {
		return this.removeKeyStoreFile;
	}

	/**
	 * Specify true to remove the key store file or false to leave the key store file.
	 */
	public void setRemoveKeyStoreFile(Boolean value) {
		this.removeKeyStoreFile = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("keyStoreName", this.keyStoreName);
		if (this.removeKeyStoreFile != null) {
			ret.put("removeKeyStoreFile", this.removeKeyStoreFile);
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
