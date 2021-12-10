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
 * Modify a descriptive property under an object.
 *   'hoverHelpKey': Specifies the Hover Help Key of the descriptive property.
 *   'nlsRangeKey': Specifies the NLS Range Key of the descriptive property.
 *   'displayNameKey': Specifies the display name key of the descriptive property.
 *   'firstClass': Specifies the firstclass of the descriptive property.
 *   'inclusive': Specifies the inclusive of the descriptive property.
 *   'parentScopeName': Specifies the management scope of the parent object.
 *   'name': Specifies the name of the descriptive property.
 *   'range': Specifies the range of the descriptive property.
 *   'type': Specifies the type of the descriptive property.
 *   'value': Specifies the value of the descriptive property.
 *   'parentDataType': Specify the parent object data type of the descriptive property. Valid values are keyStores, trustStores, keyManagers and trustManagers.
 *   'parentClassName': Specify the parent object name of the descriptive property.
 * The required parameters are found in the constructor.
 */
public class ModifyDescriptiveProp extends Command {

	private String hoverHelpKey;
	private String nlsRangeKey;
	private String displayNameKey;
	private Boolean firstClass;
	private Boolean inclusive;
	private String parentScopeName;
	private String name;
	private String range;
	private String type;
	private String value;
	private String parentDataType;
	private String parentClassName;

	public ModifyDescriptiveProp(String name, String parentDataType, String parentClassName) {
		super("modifyDescriptiveProp");
		this.name = name;
		this.parentDataType = parentDataType;
		this.parentClassName = parentClassName;
	}

	/**
	 * Specifies the Hover Help Key of the descriptive property.
	 */
	public String getHoverHelpKey() {
		return this.hoverHelpKey;
	}

	/**
	 * Specifies the Hover Help Key of the descriptive property.
	 */
	public void setHoverHelpKey(String value) {
		this.hoverHelpKey = value;
	}

	/**
	 * Specifies the NLS Range Key of the descriptive property.
	 */
	public String getNlsRangeKey() {
		return this.nlsRangeKey;
	}

	/**
	 * Specifies the NLS Range Key of the descriptive property.
	 */
	public void setNlsRangeKey(String value) {
		this.nlsRangeKey = value;
	}

	/**
	 * Specifies the display name key of the descriptive property.
	 */
	public String getDisplayNameKey() {
		return this.displayNameKey;
	}

	/**
	 * Specifies the display name key of the descriptive property.
	 */
	public void setDisplayNameKey(String value) {
		this.displayNameKey = value;
	}

	/**
	 * Specifies the firstclass of the descriptive property.
	 */
	public Boolean getFirstClass() {
		return this.firstClass;
	}

	/**
	 * Specifies the firstclass of the descriptive property.
	 */
	public void setFirstClass(Boolean value) {
		this.firstClass = value;
	}

	/**
	 * Specifies the inclusive of the descriptive property.
	 */
	public Boolean getInclusive() {
		return this.inclusive;
	}

	/**
	 * Specifies the inclusive of the descriptive property.
	 */
	public void setInclusive(Boolean value) {
		this.inclusive = value;
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
	 * Specifies the name of the descriptive property.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Specifies the name of the descriptive property.
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Specifies the range of the descriptive property.
	 */
	public String getRange() {
		return this.range;
	}

	/**
	 * Specifies the range of the descriptive property.
	 */
	public void setRange(String value) {
		this.range = value;
	}

	/**
	 * Specifies the type of the descriptive property.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Specifies the type of the descriptive property.
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Specifies the value of the descriptive property.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Specifies the value of the descriptive property.
	 */
	public void setValue(String value) {
		this.value = value;
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

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.hoverHelpKey != null) {
			ret.put("hoverHelpKey", this.hoverHelpKey);
		}
		if (this.nlsRangeKey != null) {
			ret.put("nlsRangeKey", this.nlsRangeKey);
		}
		if (this.displayNameKey != null) {
			ret.put("displayNameKey", this.displayNameKey);
		}
		if (this.firstClass != null) {
			ret.put("firstClass", this.firstClass);
		}
		if (this.inclusive != null) {
			ret.put("inclusive", this.inclusive);
		}
		if (this.parentScopeName != null) {
			ret.put("parentScopeName", this.parentScopeName);
		}
		ret.put("name", this.name);
		if (this.range != null) {
			ret.put("range", this.range);
		}
		if (this.type != null) {
			ret.put("type", this.type);
		}
		if (this.value != null) {
			ret.put("value", this.value);
		}
		ret.put("parentDataType", this.parentDataType);
		ret.put("parentClassName", this.parentClassName);
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
