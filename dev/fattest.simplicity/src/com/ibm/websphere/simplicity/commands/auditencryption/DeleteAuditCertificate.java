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

package com.ibm.websphere.simplicity.commands.auditencryption;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Delete the personal certificate used for audit encryption from the keystore identified as the audit encryption keystore
 *   'certificateAlias': Certificate alias name.
 *   'keyStoreScope': Specifies the scope of the key store.
 *   'keyStoreName': Specifies the unique name to identify the key store.
 * The required parameters are found in the constructor.
 */
public class DeleteAuditCertificate extends Command {

	private String certificateAlias;
	private String keyStoreScope;
	private String keyStoreName;

	public DeleteAuditCertificate(String certificateAlias, String keyStoreName) {
		super("deleteAuditCertificate");
		this.certificateAlias = certificateAlias;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Certificate alias name.
	 */
	public String getCertificateAlias() {
		return this.certificateAlias;
	}

	/**
	 * Certificate alias name.
	 */
	public void setCertificateAlias(String value) {
		this.certificateAlias = value;
	}

	/**
	 * Specifies the scope of the key store.
	 */
	public String getKeyStoreScope() {
		return this.keyStoreScope;
	}

	/**
	 * Specifies the scope of the key store.
	 */
	public void setKeyStoreScope(String value) {
		this.keyStoreScope = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("certificateAlias", this.certificateAlias);
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("keyStoreName", this.keyStoreName);
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
