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

package com.ibm.websphere.simplicity.commands.idmgrrealmconfig;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Sets the user registry user or group attribute mapping for a realm.
 *   'name': Name of the realm
 *   'URAttrName': The user registry user or group attribute whose mapping is to be set. The valid values are: uniqueUserId, userDisplayName, userSecurityName, uniqueGroupId, groupDisplayName and groupSecurityName.
 *   'propertyForInput': The virtual member manager property that maps to the user registry attribute for input. The valid values are: uniqueId, uniqueName, externalId, externalName and the attributes of PersonAccount and Group entity types.
 *   'propertyForOutput': The virtual member manager property that maps to the user registry attribute for output. The valid values are: uniqueId, uniqueName, externalId, externalName and the attributes of PersonAccount and Group entity types.
 * The required parameters are found in the constructor.
 */
public class SetIdMgrRealmURAttrMapping extends Command {

	private String name;
	private String URAttrName;
	private String propertyForInput;
	private String propertyForOutput;

	public SetIdMgrRealmURAttrMapping(String URAttrName, String propertyForInput, String propertyForOutput) {
		super("setIdMgrRealmURAttrMapping");
		this.URAttrName = URAttrName;
		this.propertyForInput = propertyForInput;
		this.propertyForOutput = propertyForOutput;
	}

	/**
	 * Name of the realm
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name of the realm
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * The user registry user or group attribute whose mapping is to be set. The valid values are: uniqueUserId, userDisplayName, userSecurityName, uniqueGroupId, groupDisplayName and groupSecurityName.
	 */
	public String getURAttrName() {
		return this.URAttrName;
	}

	/**
	 * The user registry user or group attribute whose mapping is to be set. The valid values are: uniqueUserId, userDisplayName, userSecurityName, uniqueGroupId, groupDisplayName and groupSecurityName.
	 */
	public void setURAttrName(String value) {
		this.URAttrName = value;
	}

	/**
	 * The virtual member manager property that maps to the user registry attribute for input. The valid values are: uniqueId, uniqueName, externalId, externalName and the attributes of PersonAccount and Group entity types.
	 */
	public String getPropertyForInput() {
		return this.propertyForInput;
	}

	/**
	 * The virtual member manager property that maps to the user registry attribute for input. The valid values are: uniqueId, uniqueName, externalId, externalName and the attributes of PersonAccount and Group entity types.
	 */
	public void setPropertyForInput(String value) {
		this.propertyForInput = value;
	}

	/**
	 * The virtual member manager property that maps to the user registry attribute for output. The valid values are: uniqueId, uniqueName, externalId, externalName and the attributes of PersonAccount and Group entity types.
	 */
	public String getPropertyForOutput() {
		return this.propertyForOutput;
	}

	/**
	 * The virtual member manager property that maps to the user registry attribute for output. The valid values are: uniqueId, uniqueName, externalId, externalName and the attributes of PersonAccount and Group entity types.
	 */
	public void setPropertyForOutput(String value) {
		this.propertyForOutput = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.name != null) {
			ret.put("name", this.name);
		}
		ret.put("URAttrName", this.URAttrName);
		ret.put("propertyForInput", this.propertyForInput);
		ret.put("propertyForOutput", this.propertyForOutput);
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
