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
 * Import a personal certificate from managed keystore in the configuration.
 *   'fromKeyStoreName': Keystore from which the certificate will be imported.
 *   'fromKeyStorePassword': Password of the keystore from which the certificate will be imported.
 *   'certificateAliasFromKeyStore': Specifies the alias of the certificate to import from the keystore.
 *   'keyStoreScope': Specifies the scope of the keystore to which the certificate will be imported.
 *   'keyStoreName': Specifies the unique name to identify the keystore to which the certificate will be imported.
 *   'fromKeyStoreScope': The scope name of the keystore from which the certificate will be imported.
 *   'certificateAlias': Unique name used to identify the certificate in the keystore.
 * The required parameters are found in the constructor.
 */
public class ImportCertFromManagedKS extends Command {

	private String fromKeyStoreName;
	private String fromKeyStorePassword;
	private String certificateAliasFromKeyStore;
	private String keyStoreScope;
	private String keyStoreName;
	private String fromKeyStoreScope;
	private String certificateAlias;

	public ImportCertFromManagedKS(String fromKeyStoreName, String fromKeyStorePassword, String certificateAliasFromKeyStore, String keyStoreName) {
		super("importCertFromManagedKS");
		this.fromKeyStoreName = fromKeyStoreName;
		this.fromKeyStorePassword = fromKeyStorePassword;
		this.certificateAliasFromKeyStore = certificateAliasFromKeyStore;
		this.keyStoreName = keyStoreName;
	}

	/**
	 * Keystore from which the certificate will be imported.
	 */
	public String getFromKeyStoreName() {
		return this.fromKeyStoreName;
	}

	/**
	 * Keystore from which the certificate will be imported.
	 */
	public void setFromKeyStoreName(String value) {
		this.fromKeyStoreName = value;
	}

	/**
	 * Password of the keystore from which the certificate will be imported.
	 */
	public String getFromKeyStorePassword() {
		return this.fromKeyStorePassword;
	}

	/**
	 * Password of the keystore from which the certificate will be imported.
	 */
	public void setFromKeyStorePassword(String value) {
		this.fromKeyStorePassword = value;
	}

	/**
	 * Specifies the alias of the certificate to import from the keystore.
	 */
	public String getCertificateAliasFromKeyStore() {
		return this.certificateAliasFromKeyStore;
	}

	/**
	 * Specifies the alias of the certificate to import from the keystore.
	 */
	public void setCertificateAliasFromKeyStore(String value) {
		this.certificateAliasFromKeyStore = value;
	}

	/**
	 * Specifies the scope of the keystore to which the certificate will be imported.
	 */
	public String getKeyStoreScope() {
		return this.keyStoreScope;
	}

	/**
	 * Specifies the scope of the keystore to which the certificate will be imported.
	 */
	public void setKeyStoreScope(String value) {
		this.keyStoreScope = value;
	}

	/**
	 * Specifies the unique name to identify the keystore to which the certificate will be imported.
	 */
	public String getKeyStoreName() {
		return this.keyStoreName;
	}

	/**
	 * Specifies the unique name to identify the keystore to which the certificate will be imported.
	 */
	public void setKeyStoreName(String value) {
		this.keyStoreName = value;
	}

	/**
	 * The scope name of the keystore from which the certificate will be imported.
	 */
	public String getFromKeyStoreScope() {
		return this.fromKeyStoreScope;
	}

	/**
	 * The scope name of the keystore from which the certificate will be imported.
	 */
	public void setFromKeyStoreScope(String value) {
		this.fromKeyStoreScope = value;
	}

	/**
	 * Unique name used to identify the certificate in the keystore.
	 */
	public String getCertificateAlias() {
		return this.certificateAlias;
	}

	/**
	 * Unique name used to identify the certificate in the keystore.
	 */
	public void setCertificateAlias(String value) {
		this.certificateAlias = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("fromKeyStoreName", this.fromKeyStoreName);
		ret.put("fromKeyStorePassword", this.fromKeyStorePassword);
		ret.put("certificateAliasFromKeyStore", this.certificateAliasFromKeyStore);
		if (this.keyStoreScope != null) {
			ret.put("keyStoreScope", this.keyStoreScope);
		}
		ret.put("keyStoreName", this.keyStoreName);
		if (this.fromKeyStoreScope != null) {
			ret.put("fromKeyStoreScope", this.fromKeyStoreScope);
		}
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
