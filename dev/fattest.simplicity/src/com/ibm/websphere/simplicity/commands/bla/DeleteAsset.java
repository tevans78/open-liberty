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
 * Delete an asset which was imported into the product configuration repository.
 *   'assetID': ID for the asset in any of the following forms:  &lt;asset name&gt;; assetname=&lt;asset name&gt;; WebSphere:assetname=&lt;asset name&gt;; or WebSphere:assetname=&lt;asset name&gt;,assetversion=&lt;asset version&gt;.  The version does not need to be specified unless there is more than one version.
 *   'force': A value of "true" removes all dependency relationships that other assets declare on this asset.  A value of "false" allows the asset to be deleted only if no other assets declare a dependency on this asset.  The default is "false".
 * The required parameters are found in the constructor.
 */
public class DeleteAsset extends Command {

	private String assetID;
	private String force;

	public DeleteAsset(String assetID) {
		super("deleteAsset");
		this.assetID = assetID;
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
	 * A value of "true" removes all dependency relationships that other assets declare on this asset.  A value of "false" allows the asset to be deleted only if no other assets declare a dependency on this asset.  The default is "false".
	 */
	public String getForce() {
		return this.force;
	}

	/**
	 * A value of "true" removes all dependency relationships that other assets declare on this asset.  A value of "false" allows the asset to be deleted only if no other assets declare a dependency on this asset.  The default is "false".
	 */
	public void setForce(String value) {
		this.force = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("assetID", this.assetID);
		if (this.force != null) {
			ret.put("force", this.force);
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
