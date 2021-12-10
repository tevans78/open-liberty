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

package com.ibm.websphere.simplicity.commands.descriptiveprop;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List descriptive properties under an object.
 *   'parentScopeName': Specifies the management scope of the parent object.
 *   'parentClassName': Specify the parent object name of the descriptive property.
 *   'parentDataType': Specify the parent object data type of the descriptive property. Valid values are keyStores, trustStores, keyManagers and trustManagers.
 *   'displayObjectName': Specify true to display the list output as ObjectNames and false to return SSL configuration alias names.
 * The required parameters are found in the constructor.
 */
public class ListDescriptiveProps extends Command {

	private String parentScopeName;
	private String parentClassName;
	private String parentDataType;
	private Boolean displayObjectName = false;

	public ListDescriptiveProps(String parentClassName, String parentDataType) {
		super("listDescriptiveProps");
		this.parentClassName = parentClassName;
		this.parentDataType = parentDataType;
	}

	/**
	 * Specifies the management scope of the parent object.
	 */
	public String getParentScopeName() {
		return this.parentScopeName;
	}

	/**
	 * Specifies the management scope of the parent object.
	 */
	public void setParentScopeName(String value) {
		this.parentScopeName = value;
	}

	/**
	 * Specify the parent object name of the descriptive property.
	 */
	public String getParentClassName() {
		return this.parentClassName;
	}

	/**
	 * Specify the parent object name of the descriptive property.
	 */
	public void setParentClassName(String value) {
		this.parentClassName = value;
	}

	/**
	 * Specify the parent object data type of the descriptive property. Valid values are keyStores, trustStores, keyManagers and trustManagers.
	 */
	public String getParentDataType() {
		return this.parentDataType;
	}

	/**
	 * Specify the parent object data type of the descriptive property. Valid values are keyStores, trustStores, keyManagers and trustManagers.
	 */
	public void setParentDataType(String value) {
		this.parentDataType = value;
	}

	/**
	 * Specify true to display the list output as ObjectNames and false to return SSL configuration alias names.
	 */
	public Boolean getDisplayObjectName() {
		return this.displayObjectName;
	}

	/**
	 * Specify true to display the list output as ObjectNames and false to return SSL configuration alias names.
	 */
	public void setDisplayObjectName(Boolean value) {
		this.displayObjectName = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.parentScopeName != null) {
			ret.put("parentScopeName", this.parentScopeName);
		}
		ret.put("parentClassName", this.parentClassName);
		ret.put("parentDataType", this.parentDataType);
		if (this.displayObjectName != null) {
			ret.put("displayObjectName", this.displayObjectName);
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
