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

package com.ibm.websphere.simplicity.commands.sslmigration;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Converts self-signed certificates to chained certificate in a keystore, all keystore, or the default keystores.  The new chained certificate will be signed with root certificate specified or the default root if one is not specified.  All keystores in the configuration will be searched for the self-signed certificate's signer certificate and it will be replaced with the signer of the default root certificate.
 *   'keyStoreName': Name of the keystore where self signed certificates are to be replaced with chained certificates.
 *   'rootCertificateAlias': Specifies a unique name to identify the root certificate used for signing.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'certificateReplacementOption': Specify ALL_CERTIFICATES to look for self-signed certificates in all keystores within the specified keyStoreScope parameter.  Specify DEFAULT_CERTIFICATES to look for self-signed certificates in the default keystores, CellDefaultKeyStore and NodeDefaultKeyStore, within the specified keyStoreScope parameter.  Specify KEYSTORE_CERTIFICATES to look for self-signed certificate in one particular keystore specified with the keyStoreName parameter.  Any self-signed certificate found will be replace with a chained certificate signed with a root from the default root keystore.
 * The required parameters are found in the constructor.
 */
public class ConvertSelfSignedCertificatesToChained extends Command {

	private String keyStoreName;
	private String rootCertificateAlias = "root";
	private String keyStoreScope;
	private String certificateReplacementOption;

	public ConvertSelfSignedCertificatesToChained(String certificateReplacementOption) {
		super("convertSelfSignedCertificatesToChained");
		this.certificateReplacementOption = certificateReplacementOption;
	}

	/**
	 * Name of the keystore where self signed certificates are to be replaced with chained certificates.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Name of the keystore where self signed certificates are to be replaced with chained certificates.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	/**
	 * Specifies a unique name to identify the root certificate used for signing.
	 */
	public String getRootCertificateAlias() {
		return this.rootCertificateAlias;
	}

	/**
	 * Specifies a unique name to identify the root certificate used for signing.
	 */
	public void setRootCertificateAlias(String value) {
		this.rootCertificateAlias = value;
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
	 * Specify ALL_CERTIFICATES to look for self-signed certificates in all keystores within the specified keyStoreScope parameter.  Specify DEFAULT_CERTIFICATES to look for self-signed certificates in the default keystores, CellDefaultKeyStore and NodeDefaultKeyStore, within the specified keyStoreScope parameter.  Specify KEYSTORE_CERTIFICATES to look for self-signed certificate in one particular keystore specified with the keyStoreName parameter.  Any self-signed certificate found will be replace with a chained certificate signed with a root from the default root keystore.
	 */
	public String getCertificateReplacementOption() {
		return this.certificateReplacementOption;
	}

	/**
	 * Specify ALL_CERTIFICATES to look for self-signed certificates in all keystores within the specified keyStoreScope parameter.  Specify DEFAULT_CERTIFICATES to look for self-signed certificates in the default keystores, CellDefaultKeyStore and NodeDefaultKeyStore, within the specified keyStoreScope parameter.  Specify KEYSTORE_CERTIFICATES to look for self-signed certificate in one particular keystore specified with the keyStoreName parameter.  Any self-signed certificate found will be replace with a chained certificate signed with a root from the default root keystore.
	 */
	public void setCertificateReplacementOption(String value) {
		this.certificateReplacementOption = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.keyStoreName != null) {
			ret.put("keyStoreName", this.keyStoreName);
		}
		if (this.rootCertificateAlias != null) {
			ret.put("rootCertificateAlias", this.rootCertificateAlias);
		}
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("certificateReplacementOption", this.certificateReplacementOption);
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
