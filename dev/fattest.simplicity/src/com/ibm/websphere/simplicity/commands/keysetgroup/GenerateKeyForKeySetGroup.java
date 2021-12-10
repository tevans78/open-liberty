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

package com.ibm.websphere.simplicity.commands.keysetgroup;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Generate new keys for all the keys within a keySet Group.
 *   'keySetGroupScope': Specifies the management scope.
 *   'keySetGroupName': Specifies the name that uniquely identifies the key set group.
 *   'keySetGroupSaveConfig': Update the runtime to use the newly generated keys.
 *   'keySetGroupUpdateRuntime': Update the runtime to use the newly generated keys.
 * The required parameters are found in the constructor.
 */
public class GenerateKeyForKeySetGroup extends Command {

	private String keySetGroupScope;
	private String keySetGroupName;
	private Boolean keySetGroupSaveConfig;
	private Boolean keySetGroupUpdateRuntime;

	public GenerateKeyForKeySetGroup(String keySetGroupName) {
		super("generateKeyForKeySetGroup");
		this.keySetGroupName = keySetGroupName;
	}

	/**
	 * Specifies the management scope.
	 */
	public String getKeySetGroupScope() {
		return this.keySetGroupScope;
	}

	/**
	 * Specifies the management scope.
	 */
	public void setKeySetGroupScope(String value) {
		this.keySetGroupScope = value;
	}

	/**
	 * Specifies the name that uniquely identifies the key set group.
	 */
	public String getKeySetGroupName() {
		return this.keySetGroupName;
	}

	/**
	 * Specifies the name that uniquely identifies the key set group.
	 */
	public void setKeySetGroupName(String value) {
		this.keySetGroupName = value;
	}

	/**
	 * Update the runtime to use the newly generated keys.
	 */
	public Boolean getKeySetGroupSaveConfig() {
		return this.keySetGroupSaveConfig;
	}

	/**
	 * Update the runtime to use the newly generated keys.
	 */
	public void setKeySetGroupSaveConfig(Boolean value) {
		this.keySetGroupSaveConfig = value;
	}

	/**
	 * Update the runtime to use the newly generated keys.
	 */
	public Boolean getKeySetGroupUpdateRuntime() {
		return this.keySetGroupUpdateRuntime;
	}

	/**
	 * Update the runtime to use the newly generated keys.
	 */
	public void setKeySetGroupUpdateRuntime(Boolean value) {
		this.keySetGroupUpdateRuntime = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.keySetGroupScope != null) {
			ret.put("keySetGroupScope", this.keySetGroupScope);
		}
		ret.put("keySetGroupName", this.keySetGroupName);
		if (this.keySetGroupSaveConfig != null) {
			ret.put("keySetGroupSaveConfig", this.keySetGroupSaveConfig);
		}
		if (this.keySetGroupUpdateRuntime != null) {
			ret.put("keySetGroupUpdateRuntime", this.keySetGroupUpdateRuntime);
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
