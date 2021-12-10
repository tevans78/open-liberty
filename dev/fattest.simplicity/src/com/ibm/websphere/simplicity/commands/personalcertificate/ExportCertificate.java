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

package com.ibm.websphere.simplicity.commands.personalcertificate;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Export a certificate to another KeyStore.
 *   'aliasInKeyStore': Specifies the alias name of the certificate used in the exported key file.
 *   'keyFilePath': Specifies the keystore path from which the certificate will be exported.
 *   'keyFilePassword': Specifies the password of the keystore file.
 *   'keyStorePassword': Specifies the password to open the keystore.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'keyFileType': Specifies the type of the keystore file.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class ExportCertificate extends Command {

	private String aliasInKeyStore;
	private String keyFilePath;
	private String keyFilePassword;
	private String keyStorePassword;
	private String keyStoreScope;
	private String keyFileType;
	private String keyStoreName;
	private String certificateAlias;

	public ExportCertificate(String keyFilePath, String keyFilePassword, String keyStorePassword, String keyFileType, String keyStoreName, String certificateAlias) {
		super("exportCertificate");
		this.keyFilePath = keyFilePath;
		this.keyFilePassword = keyFilePassword;
		this.keyStorePassword = keyStorePassword;
		this.keyFileType = keyFileType;
		this.keyStoreName = keyStoreName;
		this.certificateAlias = certificateAlias;
	}

	/**
	 * Specifies the alias name of the certificate used in the exported key file.
	 */
	public String getAliasInKeyStore() {
		return this.aliasInKeyStore;
	}

	/**
	 * Specifies the alias name of the certificate used in the exported key file.
	 */
	public void setAliasInKeyStore(String value) {
		this.aliasInKeyStore = value;
	}

	/**
	 * Specifies the keystore path from which the certificate will be exported.
	 */
	public String getKeyFilePath() {
		return this.keyFilePath;
	}

	/**
	 * Specifies the keystore path from which the certificate will be exported.
	 */
	public void setKeyFilePath(String value) {
		this.keyFilePath = value;
	}

	/**
	 * Specifies the password of the keystore file.
	 */
	public String getKeyFilePassword() {
		return this.keyFilePassword;
	}

	/**
	 * Specifies the password of the keystore file.
	 */
	public void setKeyFilePassword(String value) {
		this.keyFilePassword = value;
	}

	/**
	 * Specifies the password to open the keystore.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to open the keystore.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * Specifies the scope of the keystore.
	 */
	public String getKeyStoreScope() {
		return this.keyStoreScope;
	}

	/**
	 * Specifies the scope of the keystore.
	 */
	public void setKeyStoreScope(String value) {
		this.keyStoreScope = value;
	}

	/**
	 * Specifies the type of the keystore file.
	 */
	public String getKeyFileType() {
		return this.keyFileType;
	}

	/**
	 * Specifies the type of the keystore file.
	 */
	public void setKeyFileType(String value) {
		this.keyFileType = value;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the keystore.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	/**
	 * Specifies a unique name to identify a certificate.
	 */
	public String getCertificateAlias() {
		return this.certificateAlias;
	}

	/**
	 * Specifies a unique name to identify a certificate.
	 */
	public void setCertificateAlias(String value) {
		this.certificateAlias = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
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
		ret.put("certificateAlias", this.certificateAlias);
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
