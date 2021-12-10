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
 * Replace a Certificate with a different certificate.
 *   'replacementCertificateAlias': Specifies the certificate that will replace the old certificate.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'deleteOldCert': Specifies true to delete the old certificate, false to retain the old certificate.
 *   'deleteOldSigners': Specify true to delete the old signers associated with the old certificate, false to retain the old signers.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class ReplaceCertificate extends Command {

	private String replacementCertificateAlias;
	private String keyStoreScope;
	private String keyStoreName;
	private Boolean deleteOldCert = false;
	private Boolean deleteOldSigners = false;
	private String certificateAlias;

	public ReplaceCertificate(String replacementCertificateAlias, String keyStoreName, String certificateAlias) {
		super("replaceCertificate");
		this.replacementCertificateAlias = replacementCertificateAlias;
		this.keyStoreName = keyStoreName;
		this.certificateAlias = certificateAlias;
	}

	/**
	 * Specifies the certificate that will replace the old certificate.
	 */
	public String getReplacementCertificateAlias() {
		return this.replacementCertificateAlias;
	}

	/**
	 * Specifies the certificate that will replace the old certificate.
	 */
	public void setReplacementCertificateAlias(String value) {
		this.replacementCertificateAlias = value;
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
	 * Specifies true to delete the old certificate, false to retain the old certificate.
	 */
	public Boolean getDeleteOldCert() {
		return this.deleteOldCert;
	}

	/**
	 * Specifies true to delete the old certificate, false to retain the old certificate.
	 */
	public void setDeleteOldCert(Boolean value) {
		this.deleteOldCert = value;
	}

	/**
	 * Specify true to delete the old signers associated with the old certificate, false to retain the old signers.
	 */
	public Boolean getDeleteOldSigners() {
		return this.deleteOldSigners;
	}

	/**
	 * Specify true to delete the old signers associated with the old certificate, false to retain the old signers.
	 */
	public void setDeleteOldSigners(Boolean value) {
		this.deleteOldSigners = value;
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
		ret.put("replacementCertificateAlias", this.replacementCertificateAlias);
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("keyStoreName", this.keyStoreName);
		if (this.deleteOldCert != null) {
			ret.put("deleteOldCert", this.deleteOldCert);
		}
		if (this.deleteOldSigners != null) {
			ret.put("deleteOldSigners", this.deleteOldSigners);
		}
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
