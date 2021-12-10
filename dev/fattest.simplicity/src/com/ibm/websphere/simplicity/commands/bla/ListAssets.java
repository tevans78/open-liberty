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

package com.ibm.websphere.simplicity.commands.bla;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * List assets which have been imported into the product configuration repository.
 *   'assetID': ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
 *   'includeDescription': Controls whether or not the description is included in list output.  Specify a value of "true" to include descriptions, or "false" to omit them.  The default is "false".
 *   'includeDeplUnit': Include deployable units in listing.
 * The required parameters are found in the constructor.
 */
public class ListAssets extends Command {

	private String assetID;
	private String includeDescription;
	private String includeDeplUnit;

	public ListAssets() {
		super("listAssets");
	}

	/**
	 * ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
	 */
	public String getAssetID() {
		return this.assetID;
	}

	/**
	 * ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
	 */
	public void setAssetID(String value) {
		this.assetID = value;
	}

	/**
	 * Controls whether or not the description is included in list output.  Specify a value of "true" to include descriptions, or "false" to omit them.  The default is "false".
	 */
	public String getIncludeDescription() {
		return this.includeDescription;
	}

	/**
	 * Controls whether or not the description is included in list output.  Specify a value of "true" to include descriptions, or "false" to omit them.  The default is "false".
	 */
	public void setIncludeDescription(String value) {
		this.includeDescription = value;
	}

	/**
	 * Include deployable units in listing.
	 */
	public String getIncludeDeplUnit() {
		return this.includeDeplUnit;
	}

	/**
	 * Include deployable units in listing.
	 */
	public void setIncludeDeplUnit(String value) {
		this.includeDeplUnit = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.assetID != null) {
			ret.put("assetID", this.assetID);
		}
		if (this.includeDescription != null) {
			ret.put("includeDescription", this.includeDescription);
		}
		if (this.includeDeplUnit != null) {
			ret.put("includeDeplUnit", this.includeDeplUnit);
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
