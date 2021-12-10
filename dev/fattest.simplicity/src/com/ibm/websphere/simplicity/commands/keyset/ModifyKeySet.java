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

package com.ibm.websphere.simplicity.commands.keyset;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Modify a Key Sets attributes.
 *   'keyGenerationClass': Specifies the class used to generate keys.
 *   'aliasPrefix': Specifies the key alias prefix name.
 *   'scopeName': Specifies the management scope.
 *   'maxKeyReferences': Specifies the maximum number of keys Stored.
 *   'name': Specifies the name that uniquely identifies a key set.
 *   'password': Specifies the password for the key.
 *   'keyStoreScopeName': Specifies the scope of the keystore.
 *   'keyStoreName': Specifies the unique name to identify the keystore.
 *   'isKeyPair': Specify true if the key set is a key pair, false otherwise.
 *   'deleteOldKeys': Specify true to delete old keys during key generation, false to retain old keys.
 * The required parameters are found in the constructor.
 */
public class ModifyKeySet extends Command {

	private String keyGenerationClass;
	private String aliasPrefix;
	private String scopeName;
	private Integer maxKeyReferences;
	private String name;
	private String password;
	private String keyStoreScopeName;
	private String keyStoreName;
	private Boolean isKeyPair;
	private Boolean deleteOldKeys = true;

	public ModifyKeySet(String name) {
		super("modifyKeySet");
		this.name = name;
	}

	/**
	 * Specifies the class used to generate keys.
	 */
	public String getKeyGenerationClass() {
		return this.keyGenerationClass;
	}

	/**
	 * Specifies the class used to generate keys.
	 */
	public void setKeyGenerationClass(String value) {
		this.keyGenerationClass = value;
	}

	/**
	 * Specifies the key alias prefix name.
	 */
	public String getAliasPrefix() {
		return this.aliasPrefix;
	}

	/**
	 * Specifies the key alias prefix name.
	 */
	public void setAliasPrefix(String value) {
		this.aliasPrefix = value;
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
	 * Specifies the maximum number of keys Stored.
	 */
	public Integer getMaxKeyReferences() {
		return this.maxKeyReferences;
	}

	/**
	 * Specifies the maximum number of keys Stored.
	 */
	public void setMaxKeyReferences(Integer value) {
		this.maxKeyReferences = value;
	}

	/**
	 * Specifies the name that uniquely identifies a key set.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies the name that uniquely identifies a key set.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the password for the key.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Specifies the password for the key.
	 */
	public void setPassword(String value) {
		this.password = value;
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
	 * Specify true if the key set is a key pair, false otherwise.
	 */
	public Boolean getIsKeyPair() {
		return this.isKeyPair;
	}

	/**
	 * Specify true if the key set is a key pair, false otherwise.
	 */
	public void setIsKeyPair(Boolean value) {
		this.isKeyPair = value;
	}

	/**
	 * Specify true to delete old keys during key generation, false to retain old keys.
	 */
	public Boolean getDeleteOldKeys() {
		return this.deleteOldKeys;
	}

	/**
	 * Specify true to delete old keys during key generation, false to retain old keys.
	 */
	public void setDeleteOldKeys(Boolean value) {
		this.deleteOldKeys = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.keyGenerationClass != null) {
			ret.put("keyGenerationClass", this.keyGenerationClass);
		}
		if (this.aliasPrefix != null) {
			ret.put("aliasPrefix", this.aliasPrefix);
		}
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		if (this.maxKeyReferences != null) {
			ret.put("maxKeyReferences", this.maxKeyReferences);
		}
		ret.put("name", this.name);
		if (this.password != null) {
			ret.put("password", this.password);
		}
		if (this.keyStoreScopeName != null) {
			ret.put("keyStoreScopeName", this.keyStoreScopeName);
		}
		if (this.keyStoreName != null) {
			ret.put("keyStoreName", this.keyStoreName);
		}
		if (this.isKeyPair != null) {
			ret.put("isKeyPair", this.isKeyPair);
		}
		if (this.deleteOldKeys != null) {
			ret.put("deleteOldKeys", this.deleteOldKeys);
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
