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

package com.ibm.websphere.simplicity.commands.centralizedinstallcmds;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Shows the license agreement and license information associated with the specified install package.
 *   'packageName': Specifies the short name of the software package.
 *   'showLicenseInfoOnly': Specifies that only the license information file be shown.  Default is false.
 * The required parameters are found in the constructor.
 */
public class ShowLicenseAgreement extends Command {

	private String packageName;
	private Boolean showLicenseInfoOnly = false;

	public ShowLicenseAgreement(String packageName) {
		super("showLicenseAgreement");
		this.packageName = packageName;
	}

	/**
	 * Specifies the short name of the software package.
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * Specifies the short name of the software package.
	 */
	public void setPackageName(String value) {
		this.packageName = value;
	}

	/**
	 * Specifies that only the license information file be shown.  Default is false.
	 */
	public Boolean getShowLicenseInfoOnly() {
		return this.showLicenseInfoOnly;
	}

	/**
	 * Specifies that only the license information file be shown.  Default is false.
	 */
	public void setShowLicenseInfoOnly(Boolean value) {
		this.showLicenseInfoOnly = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("packageName", this.packageName);
		if (this.showLicenseInfoOnly != null) {
			ret.put("showLicenseInfoOnly", this.showLicenseInfoOnly);
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
