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

package com.ibm.websphere.simplicity.commands.template;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Add feature pack or stack product information to product info.
 *   'featureShortName': Feature Pack or Stack Product Short Name
 *   'featurePropertyName': Feature pack or stack product property name
 *   'featureVersion': Feature pack or stack product version
 *   'featureStartVersion': Compatible Feature pack or stack product start version
 *   'featureEndVersion': Compatible Feature pack or stack product end version
 *   'baseStartVersion': Compatible Base product start version
 *   'baseEndVersion': Compatible Base product end version
 * The required parameters are found in the constructor.
 */
public class AddProductInfo extends Command {

	private String featureShortName;
	private String featurePropertyName;
	private String featureVersion;
	private String featureStartVersion;
	private String featureEndVersion;
	private String baseStartVersion;
	private String baseEndVersion;

	public AddProductInfo(String featureShortName, String featurePropertyName, String featureVersion, String featureStartVersion, String baseStartVersion) {
		super("addProductInfo");
		this.featureShortName = featureShortName;
		this.featurePropertyName = featurePropertyName;
		this.featureVersion = featureVersion;
		this.featureStartVersion = featureStartVersion;
		this.baseStartVersion = baseStartVersion;
	}

	/**
	 * Feature Pack or Stack Product Short Name
	 */
	public String getFeatureShortName() {
		return this.featureShortName;
	}

	/**
	 * Feature Pack or Stack Product Short Name
	 */
	public void setFeatureShortName(String value) {
		this.featureShortName = value;
	}

	/**
	 * Feature pack or stack product property name
	 */
	public String getFeaturePropertyName() {
		return this.featurePropertyName;
	}

	/**
	 * Feature pack or stack product property name
	 */
	public void setFeaturePropertyName(String value) {
		this.featurePropertyName = value;
	}

	/**
	 * Feature pack or stack product version
	 */
	public String getFeatureVersion() {
		return this.featureVersion;
	}

	/**
	 * Feature pack or stack product version
	 */
	public void setFeatureVersion(String value) {
		this.featureVersion = value;
	}

	/**
	 * Compatible Feature pack or stack product start version
	 */
	public String getFeatureStartVersion() {
		return this.featureStartVersion;
	}

	/**
	 * Compatible Feature pack or stack product start version
	 */
	public void setFeatureStartVersion(String value) {
		this.featureStartVersion = value;
	}

	/**
	 * Compatible Feature pack or stack product end version
	 */
	public String getFeatureEndVersion() {
		return this.featureEndVersion;
	}

	/**
	 * Compatible Feature pack or stack product end version
	 */
	public void setFeatureEndVersion(String value) {
		this.featureEndVersion = value;
	}

	/**
	 * Compatible Base product start version
	 */
	public String getBaseStartVersion() {
		return this.baseStartVersion;
	}

	/**
	 * Compatible Base product start version
	 */
	public void setBaseStartVersion(String value) {
		this.baseStartVersion = value;
	}

	/**
	 * Compatible Base product end version
	 */
	public String getBaseEndVersion() {
		return this.baseEndVersion;
	}

	/**
	 * Compatible Base product end version
	 */
	public void setBaseEndVersion(String value) {
		this.baseEndVersion = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("featureShortName", this.featureShortName);
		ret.put("featurePropertyName", this.featurePropertyName);
		ret.put("featureVersion", this.featureVersion);
		ret.put("featureStartVersion", this.featureStartVersion);
		if (this.featureEndVersion != null) {
			ret.put("featureEndVersion", this.featureEndVersion);
		}
		ret.put("baseStartVersion", this.baseStartVersion);
		if (this.baseEndVersion != null) {
			ret.put("baseEndVersion", this.baseEndVersion);
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
