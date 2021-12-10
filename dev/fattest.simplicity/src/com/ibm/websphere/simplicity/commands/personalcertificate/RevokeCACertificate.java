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
 * Sends a request to a certificate authority (CA) to revoke the certificate.
 *   'revocationPassword': Password needed to revoke a certificate.
 *   'revocationReason': Reason for revoking the certificate.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class RevokeCACertificate extends Command {

	private String revocationPassword;
	private String revocationReason = "unspecified";
	private String keyStoreScope;
	private String keyStoreName;
	private String certificateAlias;

	public RevokeCACertificate(String revocationPassword, String keyStoreName, String certificateAlias) {
		super("revokeCACertificate");
		this.revocationPassword = revocationPassword;
		this.keyStoreName = keyStoreName;
		this.certificateAlias = certificateAlias;
	}

	/**
	 * Password needed to revoke a certificate.
	 */
	public String getRevocationPassword() {
		return this.revocationPassword;
	}

	/**
	 * Password needed to revoke a certificate.
	 */
	public void setRevocationPassword(String value) {
		this.revocationPassword = value;
	}

	/**
	 * Reason for revoking the certificate.
	 */
	public String getRevocationReason() {
		return this.revocationReason;
	}

	/**
	 * Reason for revoking the certificate.
	 */
	public void setRevocationReason(String value) {
		this.revocationReason = value;
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
		ret.put("revocationPassword", this.revocationPassword);
		if (this.revocationReason != null) {
			ret.put("revocationReason", this.revocationReason);
		}
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
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
