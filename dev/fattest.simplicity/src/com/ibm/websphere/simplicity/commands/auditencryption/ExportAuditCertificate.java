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
 * Export a certificate to another KeyStore.
 *   'certificateAlias': Certificate alias name.
 *   'aliasInKeyStore': Specifies the alias name of the certificate used in the exported file.
 *   'keyFilePath': Specifies the key store path which the certificate will be exported.
 *   'keyFilePassword': Specifies the password of the key store file.
 *   'keyStorePassword': Specifies the password to open the key store.
 *   'keyStoreScope': Specifies the scope of the key store.
 *   'keyFileType': Specifies the type of the key store file.
 *   'keyStoreName': Specifies the unique name to identify the key store.
 * The required parameters are found in the constructor.
 */
public class ExportAuditCertificate extends Command {

	private String certificateAlias;
	private String aliasInKeyStore;
	private String keyFilePath;
	private String keyFilePassword;
	private String keyStorePassword;
	private String keyStoreScope;
	private String keyFileType;
	private String keyStoreName;

	public ExportAuditCertificate(String certificateAlias, String keyFilePath, String keyFilePassword, String keyStorePassword, String keyFileType, String keyStoreName) {
		super("exportAuditCertificate");
		this.certificateAlias = certificateAlias;
		this.keyFilePath = keyFilePath;
		this.keyFilePassword = keyFilePassword;
		this.keyStorePassword = keyStorePassword;
		this.keyFileType = keyFileType;
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
	 * Specifies the alias name of the certificate used in the exported file.
	 */
	public String getAliasInKeyStore() {
		return this.aliasInKeyStore;
	}

	/**
	 * Specifies the alias name of the certificate used in the exported file.
	 */
	public void setAliasInKeyStore(String value) {
		this.aliasInKeyStore = value;
	}

	/**
	 * Specifies the key store path which the certificate will be exported.
	 */
	public String getKeyFilePath() {
		return this.keyFilePath;
	}

	/**
	 * Specifies the key store path which the certificate will be exported.
	 */
	public void setKeyFilePath(String value) {
		this.keyFilePath = value;
	}

	/**
	 * Specifies the password of the key store file.
	 */
	public String getKeyFilePassword() {
		return this.keyFilePassword;
	}

	/**
	 * Specifies the password of the key store file.
	 */
	public void setKeyFilePassword(String value) {
		this.keyFilePassword = value;
	}

	/**
	 * Specifies the password to open the key store.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to open the key store.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
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
	 * Specifies the type of the key store file.
	 */
	public String getKeyFileType() {
		return this.keyFileType;
	}

	/**
	 * Specifies the type of the key store file.
	 */
	public void setKeyFileType(String value) {
		this.keyFileType = value;
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
		if (this.aliasInKeyStore != null) {
			ret.put("aliasInKeyStore", this.aliasInKeyStore);
		}
		ret.put("keyFilePath", this.keyFilePath);
		ret.put("keyFilePassword", this.keyFilePassword);
		ret.put("keyStorePassword", this.keyStorePassword);
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("keyFileType", this.keyFileType);
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
