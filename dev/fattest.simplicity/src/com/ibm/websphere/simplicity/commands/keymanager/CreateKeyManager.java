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

package com.ibm.websphere.simplicity.commands.keymanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a key manager.
 *   'name': Specifies a name to uniquely identify a key manager.
 *   'algorithm': Specifies the algorithm name of the TrustManager or KeyManager.
 *   'keyManagerClass': Specifies the custom class that implements the KeyManager interface.
 *   'scopeName': Specifies the management scope.
 *   'provider': Specifies the provider.
 * The required parameters are found in the constructor.
 */
public class CreateKeyManager extends Command {

	private String name;
	private String algorithm;
	private String keyManagerClass;
	private String scopeName;
	private String provider;

	public CreateKeyManager(String name) {
		super("createKeyManager");
		this.name = name;
	}

	/**
	 * Specifies a name to uniquely identify a key manager.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies a name to uniquely identify a key manager.
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
	 * Specifies the custom class that implements the KeyManager interface.
	 */
	public String getKeyManagerClass() {
		return this.keyManagerClass;
	}

	/**
	 * Specifies the custom class that implements the KeyManager interface.
	 */
	public void setKeyManagerClass(String value) {
		this.keyManagerClass = value;
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
		if (this.keyManagerClass != null) {
			ret.put("keyManagerClass", this.keyManagerClass);
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
