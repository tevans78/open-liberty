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
 * Export a personal certificate to a managed keystore in the configuration.
 *   'aliasInKeyStore': Specifies the alias name used to store the certificate in the exported keystore.
 *   'keyStorePassword': Specifies the password to open the keystore from which the certificate will be exported.
 *   'keyStoreScope': Specifies the scope of the keystore from which the certificate will be exported.
 *   'keyStoreName': Specifies the unique name to identify the keystore from which the certificate will be exported.
 *   'toKeyStoreName': The name of the keystore to which the certificate will be exported.
 *   'toKeyStoreScope': The scope name of the keystore to which the certificate will be exported.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class ExportCertToManagedKS extends Command {

	private String aliasInKeyStore;
	private String keyStorePassword;
	private String keyStoreScope;
	private String keyStoreName;
	private String toKeyStoreName;
	private String toKeyStoreScope;
	private String certificateAlias;

	public ExportCertToManagedKS(String keyStorePassword, String keyStoreName, String toKeyStoreName, String certificateAlias) {
		super("exportCertToManagedKS");
		this.keyStorePassword = keyStorePassword;
		this.keyStoreName = keyStoreName;
		this.toKeyStoreName = toKeyStoreName;
		this.certificateAlias = certificateAlias;
	}

	/**
	 * Specifies the alias name used to store the certificate in the exported keystore.
	 */
	public String getAliasInKeyStore() {
		return this.aliasInKeyStore;
	}

	/**
	 * Specifies the alias name used to store the certificate in the exported keystore.
	 */
	public void setAliasInKeyStore(String value) {
		this.aliasInKeyStore = value;
	}

	/**
	 * Specifies the password to open the keystore from which the certificate will be exported.
	 */
	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	/**
	 * Specifies the password to open the keystore from which the certificate will be exported.
	 */
	public void setKeyStorePassword(String value) {
		this.keyStorePassword = value;
	}

	/**
	 * Specifies the scope of the keystore from which the certificate will be exported.
	 */
	public String getKeyStoreScope() {
		return this.keyStoreScope;
	}

	/**
	 * Specifies the scope of the keystore from which the certificate will be exported.
	 */
	public void setKeyStoreScope(String value) {
		this.keyStoreScope = value;
	}

	/**
	 * Specifies the unique name to identify the keystore from which the certificate will be exported.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the keystore from which the certificate will be exported.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	/**
	 * The name of the keystore to which the certificate will be exported.
	 */
	public String getToKeyStoreName() {
		return this.toKeyStoreName;
	}

	/**
	 * The name of the keystore to which the certificate will be exported.
	 */
	public void setToKeyStoreName(String value) {
		this.toKeyStoreName = value;
	}

	/**
	 * The scope name of the keystore to which the certificate will be exported.
	 */
	public String getToKeyStoreScope() {
		return this.toKeyStoreScope;
	}

	/**
	 * The scope name of the keystore to which the certificate will be exported.
	 */
	public void setToKeyStoreScope(String value) {
		this.toKeyStoreScope = value;
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
		ret.put("keyStorePassword", this.keyStorePassword);
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("keyStoreName", this.keyStoreName);
		ret.put("toKeyStoreName", this.toKeyStoreName);
		if (this.toKeyStoreScope != null) {
			ret.put("toKeyStoreScope", this.toKeyStoreScope);
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
