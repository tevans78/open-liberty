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

package com.ibm.websphere.simplicity.commands.dpmanager;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use the dpGetAllDomainNames command to get the names of each of the domains on a DataPower appliance.
 *   'applianceId': Specifies the ID of the appliance of interest in the DataPower appliance manager.
 *   'managed': Indicates whether to return the managed domains.  The command returns the name of each domain on the appliance if you do not specify the managed or unmanaged parameters, or if you specify both parameters.
 *   'unmanaged': Indicates whether the command returns the unmanaged domains.  The command returns the name of each domain on the appliance if you do not specify the managed or unmanaged parameters, or if you specify both parameters.
 * The required parameters are found in the constructor.
 */
public class DpGetAllDomainNames extends Command {

	private String applianceId;
	private String managed;
	private String unmanaged;

	public DpGetAllDomainNames(String applianceId) {
		super("dpGetAllDomainNames");
		this.applianceId = applianceId;
	}

	/**
	 * Specifies the ID of the appliance of interest in the DataPower appliance manager.
	 */
	public String getApplianceId() {
		return this.applianceId;
	}

	/**
	 * Specifies the ID of the appliance of interest in the DataPower appliance manager.
	 */
	public void setApplianceId(String value) {
		this.applianceId = value;
	}

	/**
	 * Indicates whether to return the managed domains.  The command returns the name of each domain on the appliance if you do not specify the managed or unmanaged parameters, or if you specify both parameters.
	 */
	public String getManaged() {
		return this.managed;
	}

	/**
	 * Indicates whether to return the managed domains.  The command returns the name of each domain on the appliance if you do not specify the managed or unmanaged parameters, or if you specify both parameters.
	 */
	public void setManaged(String value) {
		this.managed = value;
	}

	/**
	 * Indicates whether the command returns the unmanaged domains.  The command returns the name of each domain on the appliance if you do not specify the managed or unmanaged parameters, or if you specify both parameters.
	 */
	public String getUnmanaged() {
		return this.unmanaged;
	}

	/**
	 * Indicates whether the command returns the unmanaged domains.  The command returns the name of each domain on the appliance if you do not specify the managed or unmanaged parameters, or if you specify both parameters.
	 */
	public void setUnmanaged(String value) {
		this.unmanaged = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("applianceId", this.applianceId);
		if (this.managed != null) {
			ret.put("managed", this.managed);
		}
		if (this.unmanaged != null) {
			ret.put("unmanaged", this.unmanaged);
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
