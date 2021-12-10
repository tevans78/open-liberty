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
 * Use the dpGetBestFirmware command to get the firmware that best matches the parameters.
 *   'applianceType': Specifies the appliance type of the DataPower appliance for which to get the firmware.
 *   'modelType': Specifies the model type of the DataPower appliance for which to get the firmware.
 *   'applianceFeatures': Specifies the appliance features of the DataPower appliance for which to get the firmware.
 *   'level': Specifies the firmware version level for which to get the firmware.
 * The required parameters are found in the constructor.
 */
public class DpGetBestFirmware extends Command {

	private String applianceType;
	private String modelType;
	private String applianceFeatures;
	private String level;

	public DpGetBestFirmware(String applianceType, String modelType, String applianceFeatures) {
		super("dpGetBestFirmware");
		this.applianceType = applianceType;
		this.modelType = modelType;
		this.applianceFeatures = applianceFeatures;
	}

	/**
	 * Specifies the appliance type of the DataPower appliance for which to get the firmware.
	 */
	public String getApplianceType() {
		return this.applianceType;
	}

	/**
	 * Specifies the appliance type of the DataPower appliance for which to get the firmware.
	 */
	public void setApplianceType(String value) {
		this.applianceType = value;
	}

	/**
	 * Specifies the model type of the DataPower appliance for which to get the firmware.
	 */
	public String getModelType() {
		return this.modelType;
	}

	/**
	 * Specifies the model type of the DataPower appliance for which to get the firmware.
	 */
	public void setModelType(String value) {
		this.modelType = value;
	}

	/**
	 * Specifies the appliance features of the DataPower appliance for which to get the firmware.
	 */
	public String getApplianceFeatures() {
		return this.applianceFeatures;
	}

	/**
	 * Specifies the appliance features of the DataPower appliance for which to get the firmware.
	 */
	public void setApplianceFeatures(String value) {
		this.applianceFeatures = value;
	}

	/**
	 * Specifies the firmware version level for which to get the firmware.
	 */
	public String getLevel() {
		return this.level;
	}

	/**
	 * Specifies the firmware version level for which to get the firmware.
	 */
	public void setLevel(String value) {
		this.level = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		ret.put("applianceType", this.applianceType);
		ret.put("modelType", this.modelType);
		ret.put("applianceFeatures", this.applianceFeatures);
		if (this.level != null) {
			ret.put("level", this.level);
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
