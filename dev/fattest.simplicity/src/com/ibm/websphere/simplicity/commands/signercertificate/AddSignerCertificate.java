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

package com.ibm.websphere.simplicity.commands.signercertificate;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Add a signer certificates from a certificate file to a keystore.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 *   'certificateFilePath': Specifies the fully-qualified path for the certificate file.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'base64Encoded': Specify true for a Base64 encoded ASCII data file type or false for a binary DER data file type.
 * The required parameters are found in the constructor.
 */
public class AddSignerCertificate extends Command {

	private String certificateAlias;
	private String certificateFilePath;
	private String keyStoreScope;
	private String keyStoreName;
	private Boolean base64Encoded = true;

	public AddSignerCertificate(String certificateAlias, String certificateFilePath, String keyStoreName, Boolean base64Encoded) {
		super("addSignerCertificate");
		this.certificateAlias = certificateAlias;
		this.certificateFilePath = certificateFilePath;
		this.keyStoreName = keyStoreName;
		this.base64Encoded = base64Encoded;
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

	/**
	 * Specifies the fully-qualified path for the certificate file.
	 */
	public String getCertificateFilePath() {
		return this.certificateFilePath;
	}

	/**
	 * Specifies the fully-qualified path for the certificate file.
	 */
	public void setCertificateFilePath(String value) {
		this.certificateFilePath = value;
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
	 * Specify true for a Base64 encoded ASCII data file type or false for a binary DER data file type.
	 */
	public Boolean getBase64Encoded() {
		return this.base64Encoded;
	}

	/**
	 * Specify true for a Base64 encoded ASCII data file type or false for a binary DER data file type.
	 */
	public void setBase64Encoded(Boolean value) {
		this.base64Encoded = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("certificateAlias", this.certificateAlias);
		ret.put("certificateFilePath", this.certificateFilePath);
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("keyStoreName", this.keyStoreName);
		ret.put("base64Encoded", this.base64Encoded);
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
