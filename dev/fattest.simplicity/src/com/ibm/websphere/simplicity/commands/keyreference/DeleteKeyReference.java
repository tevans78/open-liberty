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
 * Delete an existing Key Reference from a keySet.
 *   'keySetName': Specifies the name that uniquely identifies a key set.
 *   'keySetScope': Specifies the scope name of the key set.
 *   'keyAlias': Specifies the unique name that identifies the key.
 * The required parameters are found in the constructor.
 */
public class DeleteKeyReference extends Command {

	private String keySetName;
	private String keySetScope;
	private String keyAlias;

	public DeleteKeyReference(String keySetName, String keyAlias) {
		super("deleteKeyReference");
		this.keySetName = keySetName;
		this.keyAlias = keyAlias;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("keySetName", this.keySetName);
		if (this.keySetScope != null) {
			ret.put("keySetScope", this.keySetScope);
		}
		ret.put("keyAlias", this.keyAlias);
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
