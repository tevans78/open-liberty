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
 * port a Certificate from another keystore to this keystore.
 *   'certificateAliasFromKeyFile': Specifies the alias of the certificate to import from the keystore file.
 *   'keyFilePath': Specifies the keystore path name that contains the certificate to import.
 *   'keyFilePassword': Specifies the password of the keystore file.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'keyFileType': Specifies the type of the keystore file.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class ImportCertificate extends Command {

	private String certificateAliasFromKeyFile;
	private String keyFilePath;
	private String keyFilePassword;
	private String keyStoreScope;
	private String keyFileType;
	private String keyStoreName;
	private String certificateAlias;

	public ImportCertificate(String certificateAliasFromKeyFile, String keyFilePath, String keyFilePassword, String keyFileType, String keyStoreName) {
		super("importCertificate");
		this.certificateAliasFromKeyFile = certificateAliasFromKeyFile;
		this.keyFilePath = keyFilePath;
		this.keyFilePassword = keyFilePassword;
		this.keyFileType = keyFileType;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Specifies the alias of the certificate to import from the keystore file.
	 */
	public String getCertificateAliasFromKeyFile() {
		return this.certificateAliasFromKeyFile;
	}

	/**
	 * Specifies the alias of the certificate to import from the keystore file.
	 */
	public void setCertificateAliasFromKeyFile(String value) {
		this.certificateAliasFromKeyFile = value;
	}

	/**
	 * Specifies the keystore path name that contains the certificate to import.
	 */
	public String getKeyFilePath() {
		return this.keyFilePath;
	}

	/**
	 * Specifies the keystore path name that contains the certificate to import.
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
