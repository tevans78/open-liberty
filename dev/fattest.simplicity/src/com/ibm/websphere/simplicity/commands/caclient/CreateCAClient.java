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

package com.ibm.websphere.simplicity.commands.caclient;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Creates a certificate authority (CA) client configurator object.
 *   'customProperties': Specifies a comma separated list of attribute=value custom property pairs to be added to the CAClient object.
 *   'frequencyCheck': Specifies the frequency, in minutes, for how often to check to see if a certificate has been created.
 *   'host': Specifies the host name of the certificate authority (CA).
 *   'pkiClientImplClass': Specifies the implementation class used to access the certificate authority (CA).
 *   'scopeName': Specifies the management scope.
 *   'caClientName': Specifies the name that uniquely identifies the certificate authority (CA) configurator.
 *   'retryCheck': Specifies the number of times to check with the certificate authority (CA) to see if the certificate is created.
 *   'password': Specifies the password of the user use to authenticate to the certificate authority (CA).
 *   'port': Specifies port used to connect to the certificate authority (CA).
 *   'userName': Specifies the user name to authenticate to the certificate authority (CA).
 * The required parameters are found in the constructor.
 */
public class CreateCAClient extends Command {

	private String customProperties;
	private String frequencyCheck;
	private String host;
	private String pkiClientImplClass;
	private String scopeName;
	private String caClientName;
	private String retryCheck;
	private String password;
	private String port;
	private String userName;

	public CreateCAClient(String pkiClientImplClass, String caClientName) {
		super("createCAClient");
		this.pkiClientImplClass = pkiClientImplClass;
		this.caClientName = caClientName;
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the CAClient object.
	 */
	public String getCustomProperties() {
		return this.customProperties;
	}

	/**
	 * Specifies a comma separated list of attribute=value custom property pairs to be added to the CAClient object.
	 */
	public void setCustomProperties(String value) {
		this.customProperties = value;
	}

	/**
	 * Specifies the frequency, in minutes, for how often to check to see if a certificate has been created.
	 */
	public String getFrequencyCheck() {
		return this.frequencyCheck;
	}

	/**
	 * Specifies the frequency, in minutes, for how often to check to see if a certificate has been created.
	 */
	public void setFrequencyCheck(String value) {
		this.frequencyCheck = value;
	}

	/**
	 * Specifies the host name of the certificate authority (CA).
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * Specifies the host name of the certificate authority (CA).
	 */
	public void setHost(String value) {
		this.host = value;
	}

	/**
	 * Specifies the implementation class used to access the certificate authority (CA).
	 */
	public String getPkiClientImplClass() {
		return this.pkiClientImplClass;
	}

	/**
	 * Specifies the implementation class used to access the certificate authority (CA).
	 */
	public void setPkiClientImplClass(String value) {
		this.pkiClientImplClass = value;
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
	 * Specifies the name that uniquely identifies the certificate authority (CA) configurator.
	 */
	public String getCaClientName() {
		return this.caClientName;
	}

	/**
	 * Specifies the name that uniquely identifies the certificate authority (CA) configurator.
	 */
	public void setCaClientName(String value) {
		this.caClientName = value;
	}

	/**
	 * Specifies the number of times to check with the certificate authority (CA) to see if the certificate is created.
	 */
	public String getRetryCheck() {
		return this.retryCheck;
	}

	/**
	 * Specifies the number of times to check with the certificate authority (CA) to see if the certificate is created.
	 */
	public void setRetryCheck(String value) {
		this.retryCheck = value;
	}

	/**
	 * Specifies the password of the user use to authenticate to the certificate authority (CA).
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Specifies the password of the user use to authenticate to the certificate authority (CA).
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Specifies port used to connect to the certificate authority (CA).
	 */
	public String getPort() {
		return this.port;
	}

	/**
	 * Specifies port used to connect to the certificate authority (CA).
	 */
	public void setPort(String value) {
		this.port = value;
	}

	/**
	 * Specifies the user name to authenticate to the certificate authority (CA).
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * Specifies the user name to authenticate to the certificate authority (CA).
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.customProperties != null) {
			ret.put("customProperties", this.customProperties);
		}
		if (this.frequencyCheck != null) {
			ret.put("frequencyCheck", this.frequencyCheck);
		}
		if (this.host != null) {
			ret.put("host", this.host);
		}
		ret.put("pkiClientImplClass", this.pkiClientImplClass);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("caClientName", this.caClientName);
		if (this.retryCheck != null) {
			ret.put("retryCheck", this.retryCheck);
		}
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.port != null) {
			ret.put("port", this.port);
		}
		if (this.userName != null) {
			ret.put("userName", this.userName);
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
