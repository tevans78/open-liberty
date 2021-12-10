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

package com.ibm.websphere.simplicity.commands.trustmanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a trust manager.
 *   'name': Name of the trust manager.
 *   'algorithm': Specifies the algorithm name of the TrustManager or KeyManager.
 *   'trustManagerClass': Specifies the custom class that implements the javax.net.ssl.TrustManager interface.
 *   'scopeName': Specifies the management scope.
 *   'provider': Specifies the provider.
 * The required parameters are found in the constructor.
 */
public class ModifyTrustManager extends Command {

	private String name;
	private String algorithm;
	private String trustManagerClass;
	private String scopeName;
	private String provider;

	public ModifyTrustManager(String name) {
		super("modifyTrustManager");
		this.name = name;
	}

	/**
	 * Name of the trust manager.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the trust manager.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the algorithm name of the TrustManager or KeyManager.
	 */
	public String getAlgorithm() {
		return this.algorithm;
	}

	/**
	 * Specifies the algorithm name of the TrustManager or KeyManager.
	 */
	public void setAlgorithm(String value) {
		this.algorithm = value;
	}

	/**
	 * Specifies the custom class that implements the javax.net.ssl.TrustManager interface.
	 */
	public String getTrustManagerClass() {
		return this.trustManagerClass;
	}

	/**
	 * Specifies the custom class that implements the javax.net.ssl.TrustManager interface.
	 */
	public void setTrustManagerClass(String value) {
		this.trustManagerClass = value;
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
	 * Specifies the provider.
	 */
	public String getProvider() {
		return this.provider;
	}

	/**
	 * Specifies the provider.
	 */
	public void setProvider(String value) {
		this.provider = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("name", this.name);
		if (this.algorithm != null) {
			ret.put("algorithm", this.algorithm);
		}
		if (this.trustManagerClass != null) {
			ret.put("trustManagerClass", this.trustManagerClass);
		}
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		if (this.provider != null) {
			ret.put("provider", this.provider);
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
