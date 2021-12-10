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
 * Retrieve a signer certificate from a port and add it to the KeyStore.
 *   'sslConfigName': Specifies the SSL configuration used to connect to the host.
 *   'host': Specifies the name of the host where the signer certificate will be retrieved.
 *   'port': Specifies the port on the host where the signer certificate will be retrieved.
 *   'sslConfigScopeName': Specifies the scope name of the SSL configuration.
 *   'keyStoreScope': Specifies the scope of the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'certificateAlias': Specifies a unique name to identify a certificate.
 * The required parameters are found in the constructor.
 */
public class RetrieveSignerFromPort extends Command {

	private String sslConfigName;
	private String host;
	private Integer port;
	private String sslConfigScopeName;
	private String keyStoreScope;
	private String keyStoreName;
	private String certificateAlias;

	public RetrieveSignerFromPort(String host, Integer port, String keyStoreName, String certificateAlias) {
		super("retrieveSignerFromPort");
		this.host = host;
		this.port = port;
		this.keyStoreName = keyStoreName;
		this.certificateAlias = certificateAlias;
	}

	/**
	 * Specifies the SSL configuration used to connect to the host.
	 */
	public String getSslConfigName() {
		return this.sslConfigName;
	}

	/**
	 * Specifies the SSL configuration used to connect to the host.
	 */
	public void setSslConfigName(String value) {
		this.sslConfigName = value;
	}

	/**
	 * Specifies the name of the host where the signer certificate will be retrieved.
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * Specifies the name of the host where the signer certificate will be retrieved.
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * Specifies the port on the host where the signer certificate will be retrieved.
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * Specifies the port on the host where the signer certificate will be retrieved.
	 */
	public void setPort(Integer value) {
		this.port = value;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public String getSslConfigScopeName() {
		return this.sslConfigScopeName;
	}

	/**
	 * Specifies the scope name of the SSL configuration.
	 */
	public void setSslConfigScopeName(String value) {
		this.sslConfigScopeName = value;
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
		if (this.sslConfigName != null) {
			ret.put("sslConfigName", this.sslConfigName);
		}
		ret.put("host", this.host);
		ret.put("port", this.port);
		if (this.sslConfigScopeName != null) {
			ret.put("sslConfigScopeName", this.sslConfigScopeName);
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
