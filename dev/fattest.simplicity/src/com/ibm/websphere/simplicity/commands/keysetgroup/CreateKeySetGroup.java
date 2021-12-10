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
 * Create a key set group.
 *   'keySetObjectNames': Colon separated list of key set object names that are included in the key set group.
 *   'scopeName': Specifies the management scope.
 *   'name': Specifies the name that uniquely identifies the key set group.
 *   'wsScheduleName': Specifies the schedule to use when if keys are auto generated.
 *   'autoGenerate': Specify true to automatically regenerate keys in the key set group, false otherwise.
 * The required parameters are found in the constructor.
 */
public class CreateKeySetGroup extends Command {

	private String keySetObjectNames;
	private String scopeName;
	private String name;
	private String wsScheduleName;
	private Boolean autoGenerate;

	public CreateKeySetGroup(String keySetObjectNames, String name, String wsScheduleName, Boolean autoGenerate) {
		super("createKeySetGroup");
		this.keySetObjectNames = keySetObjectNames;
		this.name = name;
		this.wsScheduleName = wsScheduleName;
		this.autoGenerate = autoGenerate;
	}

	/**
	 * Colon separated list of key set object names that are included in the key set group.
	 */
	public String getKeySetObjectNames() {
		return this.keySetObjectNames;
	}

	/**
	 * Colon separated list of key set object names that are included in the key set group.
	 */
	public void setKeySetObjectNames(String value) {
		this.keySetObjectNames = value;
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
	 * Specifies the name that uniquely identifies the key set group.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies the name that uniquely identifies the key set group.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the schedule to use when if keys are auto generated.
	 */
	public String getWsScheduleName() {
		return this.wsScheduleName;
	}

	/**
	 * Specifies the schedule to use when if keys are auto generated.
	 */
	public void setWsScheduleName(String value) {
		this.wsScheduleName = value;
	}

	/**
	 * Specify true to automatically regenerate keys in the key set group, false otherwise.
	 */
	public Boolean getAutoGenerate() {
		return this.autoGenerate;
	}

	/**
	 * Specify true to automatically regenerate keys in the key set group, false otherwise.
	 */
	public void setAutoGenerate(Boolean value) {
		this.autoGenerate = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("keySetObjectNames", this.keySetObjectNames);
		if (this.scopeName != null) {
			ret.put("scopeName", this.scopeName);
		}
		ret.put("name", this.name);
		ret.put("wsScheduleName", this.wsScheduleName);
		ret.put("autoGenerate", this.autoGenerate);
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
