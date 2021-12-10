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
 * Generate all the keys in a KeySet.
 *   'keySetScope': Specifies the management scope.
 *   'keySetName': Specifies the name that uniquely identifies a key set.
 *   'keySetSaveConfig': Specify true to automatically save the configuration after adding the key reference, false to save to the configuration with a seperate command.
 * The required parameters are found in the constructor.
 */
public class GenerateKeyForKeySet extends Command {

	private String keySetScope;
	private String keySetName;
	private Boolean keySetSaveConfig;

	public GenerateKeyForKeySet(String keySetName) {
		super("generateKeyForKeySet");
		this.keySetName = keySetName;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getKeySetScope() {
		return this.keySetScope;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setKeySetScope(String value) {
		this.keySetScope = value;
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
	 * Specify true to automatically save the configuration after adding the key reference, false to save to the configuration with a seperate command.
	 */
	public Boolean getKeySetSaveConfig() {
		return this.keySetSaveConfig;
	}

	/**
	 * Specify true to automatically save the configuration after adding the key reference, false to save to the configuration with a seperate command.
	 */
	public void setKeySetSaveConfig(Boolean value) {
		this.keySetSaveConfig = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.keySetScope != null) {
			ret.put("keySetScope", this.keySetScope);
		}
		ret.put("keySetName", this.keySetName);
		if (this.keySetSaveConfig != null) {
			ret.put("keySetSaveConfig", this.keySetSaveConfig);
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
