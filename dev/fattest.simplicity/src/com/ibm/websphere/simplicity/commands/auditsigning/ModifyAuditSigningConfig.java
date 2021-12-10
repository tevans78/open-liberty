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

package com.ibm.websphere.simplicity.commands.auditsigning;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modifies the audit record signing configuration.
 *   'autogenCert': Allow the runtime to automatically generate a certificate.
 *   'certAlias': Certificate alias name.
 *   'certAliasToImport': Certificate alias to import.
 *   'enableAuditSigning': Enable audit signing to true or false.
 *   'importCert': Import an existing certificate.
 *   'signingKeyStoreRef': Key store reference id of the keystore used for signing audit records.
 *   'certKeyFileName': Name of the key file where the certificate to import exists.
 *   'certKeyFilePassword': Password for the key file where the certificate to import exists.
 *   'certKeyFilePath': Path of the key file where the certificate to import exists.
 *   'useEncryptionCert': Reuse the same certificate used to encrypt audit records.
 *   'certKeyFileType': Type of the key file where the certificate to import exists.
 * The required parameters are found in the constructor.
 */
public class ModifyAuditSigningConfig extends Command {

	private Boolean autogenCert;
	private String certAlias;
	private String certAliasToImport;
	private Boolean enableAuditSigning;
	private Boolean importCert;
	private String signingKeyStoreRef;
	private String certKeyFileName;
	private String certKeyFilePassword;
	private String certKeyFilePath;
	private Boolean useEncryptionCert;
	private String certKeyFileType;

	public ModifyAuditSigningConfig(Boolean enableAuditSigning) {
		super("modifyAuditSigningConfig");
		this.enableAuditSigning = enableAuditSigning;
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
	 * Enable audit signing to true or false.
	 */
	public Boolean getEnableAuditSigning() {
		return this.enableAuditSigning;
	}

	/**
	 * Enable audit signing to true or false.
	 */
	public void setEnableAuditSigning(Boolean value) {
		this.enableAuditSigning = value;
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
	 * Key store reference id of the keystore used for signing audit records.
	 */
	public String getSigningKeyStoreRef() {
		return this.signingKeyStoreRef;
	}

	/**
	 * Key store reference id of the keystore used for signing audit records.
	 */
	public void setSigningKeyStoreRef(String value) {
		this.signingKeyStoreRef = value;
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
	 * Reuse the same certificate used to encrypt audit records.
	 */
	public Boolean getUseEncryptionCert() {
		return this.useEncryptionCert;
	}

	/**
	 * Reuse the same certificate used to encrypt audit records.
	 */
	public void setUseEncryptionCert(Boolean value) {
		this.useEncryptionCert = value;
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
		ret.put("enableAuditSigning", this.enableAuditSigning);
		if (this.importCert != null) {
			ret.put("importCert", this.importCert);
		}
		if (this.signingKeyStoreRef != null) {
			ret.put("signingKeyStoreRef", this.signingKeyStoreRef);
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
		if (this.useEncryptionCert != null) {
			ret.put("useEncryptionCert", this.useEncryptionCert);
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
