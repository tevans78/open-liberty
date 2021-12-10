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
 * Modifies the audit record encryption configuration.
 *   'autogenCert': Allow the runtime to automatically generate a certificate.
 *   'certAlias': Certificate alias name.
 *   'certAliasToImport': Certificate alias to import.
 *   'enableAuditEncryption': Enable audit encryption (true/false).
 *   'importCert': Import an existing certificate.
 *   'encryptionKeyStoreRef': Key store reference id of the keystore used for encrypting audit records.
 *   'certKeyFileName': Name of the key file where the certificate to import exists.
 *   'certKeyFilePassword': Password for the key file where the certificate to import exists.
 *   'certKeyFilePath': Path of the key file where the certificate to import exists.
 *   'certKeyFileType': Type of the key file where the certificate to import exists.
 * The required parameters are found in the constructor.
 */
public class ModifyAuditEncryptionConfig extends Command {

	private Boolean autogenCert;
	private String certAlias;
	private String certAliasToImport;
	private Boolean enableAuditEncryption;
	private Boolean importCert;
	private String encryptionKeyStoreRef;
	private String certKeyFileName;
	private String certKeyFilePassword;
	private String certKeyFilePath;
	private String certKeyFileType;

	public ModifyAuditEncryptionConfig() {
		super("modifyAuditEncryptionConfig");
	}

	/**
	 * Allow the runtime to automatically generate a certificate.
	 */
	public Boolean getAutogenCert() {
		return this.autogenCert;
	}

	/**
	 * Allow the runtime to automatically generate a certificate.
	 */
	public void setAutogenCert(Boolean value) {
		this.autogenCert = value;
	}

	/**
	 * Certificate alias name.
	 */
	public String getCertAlias() {
		return this.certAlias;
	}

	/**
	 * Certificate alias name.
	 */
	public void setCertAlias(String value) {
		this.certAlias = value;
	}

	/**
	 * Certificate alias to import.
	 */
	public String getCertAliasToImport() {
		return this.certAliasToImport;
	}

	/**
	 * Certificate alias to import.
	 */
	public void setCertAliasToImport(String value) {
		this.certAliasToImport = value;
	}

	/**
	 * Enable audit encryption (true/false).
	 */
	public Boolean getEnableAuditEncryption() {
		return this.enableAuditEncryption;
	}

	/**
	 * Enable audit encryption (true/false).
	 */
	public void setEnableAuditEncryption(Boolean value) {
		this.enableAuditEncryption = value;
	}

	/**
	 * Import an existing certificate.
	 */
	public Boolean getImportCert() {
		return this.importCert;
	}

	/**
	 * Import an existing certificate.
	 */
	public void setImportCert(Boolean value) {
		this.importCert = value;
	}

	/**
	 * Key store reference id of the keystore used for encrypting audit records.
	 */
	public String getEncryptionKeyStoreRef() {
		return this.encryptionKeyStoreRef;
	}

	/**
	 * Key store reference id of the keystore used for encrypting audit records.
	 */
	public void setEncryptionKeyStoreRef(String value) {
		this.encryptionKeyStoreRef = value;
	}

	/**
	 * Name of the key file where the certificate to import exists.
	 */
	public String getCertKeyFileName() {
		return this.certKeyFileName;
	}

	/**
	 * Name of the key file where the certificate to import exists.
	 */
	public void setCertKeyFileName(String value) {
		this.certKeyFileName = value;
	}

	/**
	 * Password for the key file where the certificate to import exists.
	 */
	public String getCertKeyFilePassword() {
		return this.certKeyFilePassword;
	}

	/**
	 * Password for the key file where the certificate to import exists.
	 */
	public void setCertKeyFilePassword(String value) {
		this.certKeyFilePassword = value;
	}

	/**
	 * Path of the key file where the certificate to import exists.
	 */
	public String getCertKeyFilePath() {
		return this.certKeyFilePath;
	}

	/**
	 * Path of the key file where the certificate to import exists.
	 */
	public void setCertKeyFilePath(String value) {
		this.certKeyFilePath = value;
	}

	/**
	 * Type of the key file where the certificate to import exists.
	 */
	public String getCertKeyFileType() {
		return this.certKeyFileType;
	}

	/**
	 * Type of the key file where the certificate to import exists.
	 */
	public void setCertKeyFileType(String value) {
		this.certKeyFileType = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.autogenCert != null) {
			ret.put("autogenCert", this.autogenCert);
		}
		if (this.certAlias != null) {
			ret.put("certAlias", this.certAlias);
		}
		if (this.certAliasToImport != null) {
			ret.put("certAliasToImport", this.certAliasToImport);
		}
		if (this.enableAuditEncryption != null) {
			ret.put("enableAuditEncryption", this.enableAuditEncryption);
		}
		if (this.importCert != null) {
			ret.put("importCert", this.importCert);
		}
		if (this.encryptionKeyStoreRef != null) {
			ret.put("encryptionKeyStoreRef", this.encryptionKeyStoreRef);
		}
		if (this.certKeyFileName != null) {
			ret.put("certKeyFileName", this.certKeyFileName);
		}
		if (this.certKeyFilePassword != null) {
			ret.put("certKeyFilePassword", this.certKeyFilePassword);
		}
		if (this.certKeyFilePath != null) {
			ret.put("certKeyFilePath", this.certKeyFilePath);
		}
		if (this.certKeyFileType != null) {
			ret.put("certKeyFileType", this.certKeyFileType);
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
