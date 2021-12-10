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

package com.ibm.websphere.simplicity.commands.rsatoken;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Command that modifies the role propagation authorization mechanism
 *   'adminCertAlias': Alias name of the RSA token certificate.
 *   'adminCertKeyStore': The name of the key store used for RSA token authorization.
 *   'adminCertTrustStore': The name of the trust store used for RSA token authorization.
 *   'adminCertKeyStoreScope': The scope of the RSA token key store.
 *   'adminCertTrustStoreScope': The trust store scope name.
 *   'nonceCacheTimeout': The time in minutes when nonce value will time out.
 *   'tokenExpiration': The time in minutes when the token is to expire.
 * The required parameters are found in the constructor.
 */
public class ConfigureRSATokenAuthorization extends Command {

	private String adminCertAlias;
	private String adminCertKeyStore;
	private String adminCertTrustStore;
	private String adminCertKeyStoreScope;
	private String adminCertTrustStoreScope;
	private Long nonceCacheTimeout;
	private Long tokenExpiration;

	public ConfigureRSATokenAuthorization() {
		super("configureRSATokenAuthorization");
	}

	/**
	 * Alias name of the RSA token certificate.
	 */
	public String getAdminCertAlias() {
		return this.adminCertAlias;
	}

	/**
	 * Alias name of the RSA token certificate.
	 */
	public void setAdminCertAlias(String value) {
		this.adminCertAlias = value;
	}

	/**
	 * The name of the key store used for RSA token authorization.
	 */
	public String getAdminCertKeyStore() {
		return this.adminCertKeyStore;
	}

	/**
	 * The name of the key store used for RSA token authorization.
	 */
	public void setAdminCertKeyStore(String value) {
		this.adminCertKeyStore = value;
	}

	/**
	 * The name of the trust store used for RSA token authorization.
	 */
	public String getAdminCertTrustStore() {
		return this.adminCertTrustStore;
	}

	/**
	 * The name of the trust store used for RSA token authorization.
	 */
	public void setAdminCertTrustStore(String value) {
		this.adminCertTrustStore = value;
	}

	/**
	 * The scope of the RSA token key store.
	 */
	public String getAdminCertKeyStoreScope() {
		return this.adminCertKeyStoreScope;
	}

	/**
	 * The scope of the RSA token key store.
	 */
	public void setAdminCertKeyStoreScope(String value) {
		this.adminCertKeyStoreScope = value;
	}

	/**
	 * The trust store scope name.
	 */
	public String getAdminCertTrustStoreScope() {
		return this.adminCertTrustStoreScope;
	}

	/**
	 * The trust store scope name.
	 */
	public void setAdminCertTrustStoreScope(String value) {
		this.adminCertTrustStoreScope = value;
	}

	/**
	 * The time in minutes when nonce value will time out.
	 */
	public Long getNonceCacheTimeout() {
		return this.nonceCacheTimeout;
	}

	/**
	 * The time in minutes when nonce value will time out.
	 */
	public void setNonceCacheTimeout(Long value) {
		this.nonceCacheTimeout = value;
	}

	/**
	 * The time in minutes when the token is to expire.
	 */
	public Long getTokenExpiration() {
		return this.tokenExpiration;
	}

	/**
	 * The time in minutes when the token is to expire.
	 */
	public void setTokenExpiration(Long value) {
		this.tokenExpiration = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.adminCertAlias != null) {
			ret.put("adminCertAlias", this.adminCertAlias);
		}
		if (this.adminCertKeyStore != null) {
			ret.put("adminCertKeyStore", this.adminCertKeyStore);
		}
		if (this.adminCertTrustStore != null) {
			ret.put("adminCertTrustStore", this.adminCertTrustStore);
		}
		if (this.adminCertKeyStoreScope != null) {
			ret.put("adminCertKeyStoreScope", this.adminCertKeyStoreScope);
		}
		if (this.adminCertTrustStoreScope != null) {
			ret.put("adminCertTrustStoreScope", this.adminCertTrustStoreScope);
		}
		if (this.nonceCacheTimeout != null) {
			ret.put("nonceCacheTimeout", this.nonceCacheTimeout);
		}
		if (this.tokenExpiration != null) {
			ret.put("tokenExpiration", this.tokenExpiration);
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
