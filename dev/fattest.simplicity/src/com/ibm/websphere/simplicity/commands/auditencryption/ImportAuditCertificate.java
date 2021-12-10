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
 * Import a Certificate from another keyStore to this KeyStore.
 *   'certificateAliasFromKeyFile': Specifies the alias of the certificate to import from the key store file.
 *   'keyFilePath': Specifies the key store path name that contains the certificate to import.
 *   'keyFilePassword': Specifies the password of the key store file.
 *   'keyStoreScope': Specifies the scope of the key store.
 *   'keyFileType': Specifies the type of the key store file.
 *   'keyStoreName': Specifies the unique name to identify the key store.
 *   'certificateAlias': Certificate alias name.
 * The required parameters are found in the constructor.
 */
public class ImportAuditCertificate extends Command {

	private String certificateAliasFromKeyFile;
	private String keyFilePath;
	private String keyFilePassword;
	private String keyStoreScope;
	private String keyFileType;
	private String keyStoreName;
	private String certificateAlias;

	public ImportAuditCertificate(String certificateAliasFromKeyFile, String keyFilePath, String keyFilePassword, String keyFileType, String keyStoreName) {
		super("importAuditCertificate");
		this.certificateAliasFromKeyFile = certificateAliasFromKeyFile;
		this.keyFilePath = keyFilePath;
		this.keyFilePassword = keyFilePassword;
		this.keyFileType = keyFileType;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Specifies the alias of the certificate to import from the key store file.
	 */
	public String getCertificateAliasFromKeyFile() {
		return this.certificateAliasFromKeyFile;
	}

	/**
	 * Specifies the alias of the certificate to import from the key store file.
	 */
	public void setCertificateAliasFromKeyFile(String value) {
		this.certificateAliasFromKeyFile = value;
	}

	/**
	 * Specifies the key store path name that contains the certificate to import.
	 */
	public String getKeyFilePath() {
		return this.keyFilePath;
	}

	/**
	 * Specifies the key store path name that contains the certificate to import.
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("certificateAliasFromKeyFile", this.certificateAliasFromKeyFile);
		ret.put("keyFilePath", this.keyFilePath);
		ret.put("keyFilePassword", this.keyFilePassword);
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("keyFileType", this.keyFileType);
		ret.put("keyStoreName", this.keyStoreName);
		if (this.certificateAlias != null) {
			ret.put("certificateAlias", this.certificateAlias);
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
