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

package com.ibm.websphere.simplicity.commands;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Migrates WMM UserRegistry properties information to virtual member manager realm configuration.
 *   'groupDisplayNameProperty': The virtual member manager property for groupDisplayName(default: cn).
 *   'groupSecurityNameProperty': The virtual member manager property for groupSecurityName(default: cn).
 *   'uniqueGroupIdProperty': The virtual member manager property for uniqueGroupId(default: uniqueName).
 *   'uniqueUserIdProperty': The virtual member manager property for uniqueUserId(default: uniqueName).
 *   'userDisplayNameProperty': The virtual member manager property for userDisplayName(default: principalName).
 *   'userSecurityNameProperty': The virtual member manager property for userSecurityName(default: principalName).
 *   'wmmurFile': The location of wmmur.xml file. e.g. c:\WAS5\config\wmm\xml\wmmur.xml
 * The required parameters are found in the constructor.
 */
public class MigrateWMMUR extends Command {

	private String groupDisplayNameProperty = "cn";
	private String groupSecurityNameProperty = "cn";
	private String uniqueGroupIdProperty = "uniqueName";
	private String uniqueUserIdProperty = "uniqueName";
	private String userDisplayNameProperty = "principalName";
	private String userSecurityNameProperty = "principalName";
	private String wmmurFile;

	public MigrateWMMUR(String wmmurFile) {
		super("migrateWMMUR");
		this.wmmurFile = wmmurFile;
	}

	/**
	 * The virtual member manager property for groupDisplayName(default: cn).
	 */
	public String getGroupDisplayNameProperty() {
		return this.groupDisplayNameProperty;
	}

	/**
	 * The virtual member manager property for groupDisplayName(default: cn).
	 */
	public void setGroupDisplayNameProperty(String value) {
		this.groupDisplayNameProperty = value;
	}

	/**
	 * The virtual member manager property for groupSecurityName(default: cn).
	 */
	public String getGroupSecurityNameProperty() {
		return this.groupSecurityNameProperty;
	}

	/**
	 * The virtual member manager property for groupSecurityName(default: cn).
	 */
	public void setGroupSecurityNameProperty(String value) {
		this.groupSecurityNameProperty = value;
	}

	/**
	 * The virtual member manager property for uniqueGroupId(default: uniqueName).
	 */
	public String getUniqueGroupIdProperty() {
		return this.uniqueGroupIdProperty;
	}

	/**
	 * The virtual member manager property for uniqueGroupId(default: uniqueName).
	 */
	public void setUniqueGroupIdProperty(String value) {
		this.uniqueGroupIdProperty = value;
	}

	/**
	 * The virtual member manager property for uniqueUserId(default: uniqueName).
	 */
	public String getUniqueUserIdProperty() {
		return this.uniqueUserIdProperty;
	}

	/**
	 * The virtual member manager property for uniqueUserId(default: uniqueName).
	 */
	public void setUniqueUserIdProperty(String value) {
		this.uniqueUserIdProperty = value;
	}

	/**
	 * The virtual member manager property for userDisplayName(default: principalName).
	 */
	public String getUserDisplayNameProperty() {
		return this.userDisplayNameProperty;
	}

	/**
	 * The virtual member manager property for userDisplayName(default: principalName).
	 */
	public void setUserDisplayNameProperty(String value) {
		this.userDisplayNameProperty = value;
	}

	/**
	 * The virtual member manager property for userSecurityName(default: principalName).
	 */
	public String getUserSecurityNameProperty() {
		return this.userSecurityNameProperty;
	}

	/**
	 * The virtual member manager property for userSecurityName(default: principalName).
	 */
	public void setUserSecurityNameProperty(String value) {
		this.userSecurityNameProperty = value;
	}

	/**
	 * The location of wmmur.xml file. e.g. c:\WAS5\config\wmm\xml\wmmur.xml
	 */
	public String getWmmurFile() {
		return this.wmmurFile;
	}

	/**
	 * The location of wmmur.xml file. e.g. c:\WAS5\config\wmm\xml\wmmur.xml
	 */
	public void setWmmurFile(String value) {
		this.wmmurFile = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.groupDisplayNameProperty != null) {
			ret.put("groupDisplayNameProperty", this.groupDisplayNameProperty);
		}
		if (this.groupSecurityNameProperty != null) {
			ret.put("groupSecurityNameProperty", this.groupSecurityNameProperty);
		}
		if (this.uniqueGroupIdProperty != null) {
			ret.put("uniqueGroupIdProperty", this.uniqueGroupIdProperty);
		}
		if (this.uniqueUserIdProperty != null) {
			ret.put("uniqueUserIdProperty", this.uniqueUserIdProperty);
		}
		if (this.userDisplayNameProperty != null) {
			ret.put("userDisplayNameProperty", this.userDisplayNameProperty);
		}
		if (this.userSecurityNameProperty != null) {
			ret.put("userSecurityNameProperty", this.userSecurityNameProperty);
		}
		ret.put("wmmurFile", this.wmmurFile);
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
