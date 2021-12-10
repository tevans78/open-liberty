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

package com.ibm.websphere.simplicity.jobmanager.job;

import com.ibm.websphere.simplicity.jobmanager.Job;
import com.ibm.websphere.simplicity.jobmanager.JobType;

public class ConfigureProperties extends Job {
	
	private static final String PROPERTIES_FILE_LOCATION = "propertiesFileLocation";
	private static final String VARIABLE_MAP_LOCATION = "variableMapLocation";
	
	/**
	 * Apply a configuration properties file
	 * @param propertiesFileLocation Location of the properties file at the managed node.  This will be the destination that was given when the file was distributed to the node.
	 */
	public ConfigureProperties(String propertiesFileLocation) {
		super(JobType.CreateApplicationServer);
		setPropertiesFileLocation(propertiesFileLocation);
	}
	
	/**
	 * Location of the properties file at the managed node.  This will be the destination that was given when the file was distributed to the node.
	 * @return
	 */
	public String getPropertiesFileLocation() {
		return getJobParam(PROPERTIES_FILE_LOCATION);
	}
	
	/**
	 * Location of the properties file at the managed node.  This will be the destination that was given when the file was distributed to the node.
	 * @param value
	 */
	public void setPropertiesFileLocation(String value) {
		setJobParam(PROPERTIES_FILE_LOCATION, value);
	}
	
	/**
	 * Location of the variable map file.  This will be the destination that was given when the file was distributed to the node.
	 * @return
	 */
	public String getVariableMapLocation() {
		return getJobParam(VARIABLE_MAP_LOCATION);
	}
	
	/**
	 * Location of the variable map file.  This will be the destination that was given when the file was distributed to the node.
	 * @param value
	 */
	public void setVariableMapLocation(String value) {
		if (value != null)
			setJobParam(VARIABLE_MAP_LOCATION, value);
		else
			removeJobParam(VARIABLE_MAP_LOCATION);
	}
	
}
