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

package com.ibm.websphere.simplicity.commands.certificaterequest;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Extract a certificate request to a file.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 *   'certificateRequestFilePath': Specifies the full path name to the file where the certificate request is extracted.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 * The required parameters are found in the constructor.
 */
public class ExtractCertificateRequest extends Command {

	private String certificateAlias;
	private String certificateRequestFilePath;
	private String keyStoreScope;
	private String keyStoreName;

	public ExtractCertificateRequest(String certificateAlias, String certificateRequestFilePath, String keyStoreName) {
		super("extractCertificateRequest");
		this.certificateAlias = certificateAlias;
		this.certificateRequestFilePath = certificateRequestFilePath;
		this.keyStoreName = keyStoreName;
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
	 * Specifies the full path name to the file where the certificate request is extracted.
	 */
	public String getCertificateRequestFilePath() {
		return this.certificateRequestFilePath;
	}

	/**
	 * Specifies the full path name to the file where the certificate request is extracted.
	 */
	public void setCertificateRequestFilePath(String value) {
		this.certificateRequestFilePath = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("certificateAlias", this.certificateAlias);
		ret.put("certificateRequestFilePath", this.certificateRequestFilePath);
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
