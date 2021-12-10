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

package com.ibm.websphere.simplicity.commands.keyreference;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create a Key Reference for a keySet.
 *   'keySetName': Specifies the name that uniquely identifies a key set.
 *   'keyPassword': Specifies the password for the key.
 *   'keyPasswordVerify': Specifies the password used to confirm the key password.
 *   'keySetScope': Specifies the scope name of the key set.
 *   'keyAlias': Specifies the unique name that identifies the key.
 *   'version': Specifies the version of the key reference.
 *   'keyReferenceSaveConfig': Specifies whether to save the configuration after adding the key reference.
 * The required parameters are found in the constructor.
 */
public class CreateKeyReference extends Command {

	private String keySetName;
	private String keyPassword;
	private String keyPasswordVerify;
	private String keySetScope;
	private String keyAlias;
	private Integer version;
	private Boolean keyReferenceSaveConfig;

	public CreateKeyReference(String keySetName) {
		super("createKeyReference");
		this.keySetName = keySetName;
	}

	/**
	 * Specifies the name that uniquely identifies a key set.
	 */
	public String getKeySetName() {
		return this.keySetName;
	}

	/**
	 * Specifies the name that uniquely identifies a key set.
	 */
	public void setKeySetName(String value) {
		this.keySetName = value;
	}

	/**
	 * Specifies the password for the key.
	 */
	public String getKeyPassword() {
		return this.keyPassword;
	}

	/**
	 * Specifies the password for the key.
	 */
	public void setKeyPassword(String value) {
		this.keyPassword = value;
	}

	/**
	 * Specifies the password used to confirm the key password.
	 */
	public String getKeyPasswordVerify() {
		return this.keyPasswordVerify;
	}

	/**
	 * Specifies the password used to confirm the key password.
	 */
	public void setKeyPasswordVerify(String value) {
		this.keyPasswordVerify = value;
	}

	/**
	 * Specifies the scope name of the key set.
	 */
	public String getKeySetScope() {
		return this.keySetScope;
	}

	/**
	 * Specifies the scope name of the key set.
	 */
	public void setKeySetScope(String value) {
		this.keySetScope = value;
	}

	/**
	 * Specifies the unique name that identifies the key.
	 */
	public String getKeyAlias() {
		return this.keyAlias;
	}

	/**
	 * Specifies the unique name that identifies the key.
	 */
	public void setKeyAlias(String value) {
		this.keyAlias = value;
	}

	/**
	 * Specifies the version of the key reference.
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * Specifies the version of the key reference.
	 */
	public void setVersion(Integer value) {
		this.version = value;
	}

	/**
	 * Specifies whether to save the configuration after adding the key reference.
	 */
	public Boolean getKeyReferenceSaveConfig() {
		return this.keyReferenceSaveConfig;
	}

	/**
	 * Specifies whether to save the configuration after adding the key reference.
	 */
	public void setKeyReferenceSaveConfig(Boolean value) {
		this.keyReferenceSaveConfig = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("keySetName", this.keySetName);
		if (this.keyPassword != null) {
			ret.put("keyPassword", this.keyPassword);
		}
		if (this.keyPasswordVerify != null) {
			ret.put("keyPasswordVerify", this.keyPasswordVerify);
		}
		if (this.keySetScope != null) {
			ret.put("keySetScope", this.keySetScope);
		}
		if (this.keyAlias != null) {
			ret.put("keyAlias", this.keyAlias);
		}
		if (this.version != null) {
			ret.put("version", this.version);
		}
		if (this.keyReferenceSaveConfig != null) {
			ret.put("keyReferenceSaveConfig", this.keyReferenceSaveConfig);
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
