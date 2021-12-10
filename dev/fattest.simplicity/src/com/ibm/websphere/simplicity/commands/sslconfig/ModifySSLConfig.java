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

package com.ibm.websphere.simplicity.commands.sslconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a SSL configuration.
 *   'trustManagerObjectNames': Specifies a colon separated list of trust manager object names.
 *   'trustStoreName': Specifies a reference to a specific TrustStore for JSSE purposes.
 *   'alias': Specifies alias that uniquely identifies a SSL configuration.
 *   'jsseProvider': Specifies the JSSE provider for the SSL configuration.
 *   'sslProtocol': Specifies the SSL protocol.
 *   'enabledCiphers': Specifies the ciphers enabled for this SSL Configuration.
 *   'ssslKeyRingName': Specifies the keyring file name for a System SSL (SSSL) configuration type.
 *   'scopeName': Specifies the management scope.
 *   'keyManagerName': Specifies the name of the Key Manager.
 *   'clientKeyAlias': Specifies the name of the client key.
 *   'serverKeyAlias': Specifies the name of the server key.
 *   'keyManagerScopeName': Specifies the scope of the key manager.
 *   'keyStoreScopeName': Specifies the scope of the keystore.
 *   'trustStoreScopeName': Specifies the scope of the trust store.
 *   'securityLevel': Specifies the security level of the SSL configuration, HIGH, MEDIUM, LOW, or CUSTOM.
 *   'v3timeout': Specifies the time out in seconds for System SSL configuration types.  Value ranges from 1-86400.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'clientAuthentication': Specify true if client authentication is desired and false otherwise.
 *   'clientAuthenticationSupported': Specify true if client authentication is supported and false otherwise.
 * The required parameters are found in the constructor.
 */
public class ModifySSLConfig extends Command {

	private String trustManagerObjectNames;
	private String trustStoreName;
	private String alias;
	private String jsseProvider;
	private String sslProtocol;
	private String enabledCiphers;
	private String ssslKeyRingName;
	private String scopeName;
	private String keyManagerName;
	private String clientKeyAlias;
	private String serverKeyAlias;
	private String keyManagerScopeName;
	private String keyStoreScopeName;
	private String trustStoreScopeName;
	private String securityLevel;
	private Integer v3timeout;
	private String keyStoreName;
	private Boolean clientAuthentication;
	private Boolean clientAuthenticationSupported;

	public ModifySSLConfig(String alias) {
		super("modifySSLConfig");
		this.alias = alias;
	}

	/**
	 * Specifies a colon separated list of trust manager object names.
	 */
	public String getTrustManagerObjectNames() {
		return this.trustManagerObjectNames;
	}

	/**
	 * Specifies a colon separated list of trust manager object names.
	 */
	public void setTrustManagerObjectNames(String value) {
		this.trustManagerObjectNames = value;
	}

	/**
	 * Specifies a reference to a specific TrustStore for JSSE purposes.
	 */
	public String getTrustStoreName() {
		return this.trustStoreName;
	}

	/**
	 * Specifies a reference to a specific TrustStore for JSSE purposes.
	 */
	public void setTrustStoreName(String value) {
		this.trustStoreName = value;
	}

	/**
	 * Specifies alias that uniquely identifies a SSL configuration.
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Specifies alias that uniquely identifies a SSL configuration.
	 */
	public void setAlias(String value) {
		this.alias = value;
	}

	/**
	 * Specifies the JSSE provider for the SSL configuration.
	 */
	public String getJsseProvider() {
		return this.jsseProvider;
	}

	/**
	 * Specifies the JSSE provider for the SSL configuration.
	 */
	public void setJsseProvider(String value) {
		this.jsseProvider = value;
	}

	/**
	 * Specifies the SSL protocol.
	 */
	public String getSslProtocol() {
		return this.sslProtocol;
	}

	/**
	 * Specifies the SSL protocol.
	 */
	public void setSslProtocol(String value) {
		this.sslProtocol = value;
	}

	/**
	 * Specifies the ciphers enabled for this SSL Configuration.
	 */
	public String getEnabledCiphers() {
		return this.enabledCiphers;
	}

	/**
	 * Specifies the ciphers enabled for this SSL Configuration.
	 */
	public void setEnabledCiphers(String value) {
		this.enabledCiphers = value;
	}

	/**
	 * Specifies the keyring file name for a System SSL (SSSL) configuration type.
	 */
	public String getSsslKeyRingName() {
		return this.ssslKeyRingName;
	}

	/**
	 * Specifies the keyring file name for a System SSL (SSSL) configuration type.
	 */
	public void setSsslKeyRingName(String value) {
		this.ssslKeyRingName = value;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getScopeName() {
		return this.scopeName;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setScopeName(String value) {
		this.scopeName = value;
	}

	/**
	 * Specifies the name of the Key Manager.
	 */
	public String getKeyManagerName() {
		return this.keyManagerName;
	}

	/**
	 * Specifies the name of the Key Manager.
	 */
	public void setKeyManagerName(String value) {
		this.keyManagerName = value;
	}

	/**
	 * Specifies the name of the client key.
	 */
	public String getClientKeyAlias() {
		return this.clientKeyAlias;
	}

	/**
	 * Specifies the name of the client key.
	 */
	public void setClientKeyAlias(String value) {
		this.clientKeyAlias = value;
	}

	/**
	 * Specifies the name of the server key.
	 */
	public String getServerKeyAlias() {
		return this.serverKeyAlias;
	}

	/**
	 * Specifies the name of the server key.
	 */
	public void setServerKeyAlias(String value) {
		this.serverKeyAlias = value;
	}

	/**
	 * Specifies the scope of the key manager.
	 */
	public String getKeyManagerScopeName() {
		return this.keyManagerScopeName;
	}

	/**
	 * Specifies the scope of the key manager.
	 */
	public void setKeyManagerScopeName(String value) {
		this.keyManagerScopeName = value;
	}

	/**
	 * Specifies the scope of the keystore.
	 */
	public String getKeyStoreScopeName() {
		return this.keyStoreScopeName;
	}

	/**
	 * Specifies the scope of the keystore.
	 */
	public void setKeyStoreScopeName(String value) {
		this.keyStoreScopeName = value;
	}

	/**
	 * Specifies the scope of the trust store.
	 */
	public String getTrustStoreScopeName() {
		return this.trustStoreScopeName;
	}

	/**
	 * Specifies the scope of the trust store.
	 */
	public void setTrustStoreScopeName(String value) {
		this.trustStoreScopeName = value;
	}

	/**
	 * Specifies the security level of the SSL configuration, HIGH, MEDIUM, LOW, or CUSTOM.
	 */
	public String getSecurityLevel() {
		return this.securityLevel;
	}

	/**
	 * Specifies the security level of the SSL configuration, HIGH, MEDIUM, LOW, or CUSTOM.
	 */
	public void setSecurityLevel(String value) {
		this.securityLevel = value;
	}

	/**
	 * Specifies the time out in seconds for System SSL configuration types.  Value ranges from 1-86400.
	 */
	public Integer getV3timeout() {
		return this.v3timeout;
	}

	/**
	 * Specifies the time out in seconds for System SSL configuration types.  Value ranges from 1-86400.
	 */
	public void setV3timeout(Integer value) {
		this.v3timeout = value;
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
	 * Specify true if client authentication is desired and false otherwise.
	 */
	public Boolean getClientAuthentication() {
		return this.clientAuthentication;
	}

	/**
	 * Specify true if client authentication is desired and false otherwise.
	 */
	public void setClientAuthentication(Boolean value) {
		this.clientAuthentication = value;
	}

	/**
	 * Specify true if client authentication is supported and false otherwise.
	 */
	public Boolean getClientAuthenticationSupported() {
		return this.clientAuthenticationSupported;
	}

	/**
	 * Specify true if client authentication is supported and false otherwise.
	 */
	public void setClientAuthenticationSupported(Boolean value) {
		this.clientAuthenticationSupported = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.trustManagerObjectNames != null) {
			ret.put("trustManagerObjectNames", this.trustManagerObjectNames);
		}
		if (this.trustStoreName != null) {
			ret.put("trustStoreName", this.trustStoreName);
		}
		ret.put("alias", this.alias);
		if (this.jsseProvider != null) {
			ret.put("jsseProvider", this.jsseProvider);
		}
		if (this.sslProtocol != null) {
			ret.put("sslProtocol", this.sslProtocol);
		}
		if (this.enabledCiphers != null) {
			ret.put("enabledCiphers", this.enabledCiphers);
		}
		if (this.ssslKeyRingName != null) {
			ret.put("ssslKeyRingName", this.ssslKeyRingName);
		}
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		if (this.keyManagerName != null) {
			ret.put("keyManagerName", this.keyManagerName);
		}
		if (this.clientKeyAlias != null) {
			ret.put("clientKeyAlias", this.clientKeyAlias);
		}
		if (this.serverKeyAlias != null) {
			ret.put("serverKeyAlias", this.serverKeyAlias);
		}
		if (this.keyManagerScopeName != null) {
			ret.put("keyManagerScopeName", this.keyManagerScopeName);
		}
		if (this.keyStoreScopeName != null) {
			ret.put("keyStoreScopeName", this.keyStoreScopeName);
		}
		if (this.trustStoreScopeName != null) {
			ret.put("trustStoreScopeName", this.trustStoreScopeName);
		}
		if (this.securityLevel != null) {
			ret.put("securityLevel", this.securityLevel);
		}
		if (this.v3timeout != null) {
			ret.put("v3timeout", this.v3timeout);
		}
		if (this.keyStoreName != null) {
			ret.put("keyStoreName", this.keyStoreName);
		}
		if (this.clientAuthentication != null) {
			ret.put("clientAuthentication", this.clientAuthentication);
		}
		if (this.clientAuthenticationSupported != null) {
			ret.put("clientAuthenticationSupported", this.clientAuthenticationSupported);
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
