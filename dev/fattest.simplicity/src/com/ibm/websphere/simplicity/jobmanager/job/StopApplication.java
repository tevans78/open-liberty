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

public class StopApplication extends Job {
	
	private static final String APPLICATION_NAME = "applicationName";
	
	/**
	 * Stop an application.
	 * @param applicationName Name of the application to stop.
	 */
	public StopApplication(String applicationName) {
		super(JobType.StopApplication);
		setApplicationName(applicationName);
	}
	
	/**
	 * Name of the application to stop.
	 * @return
	 */
	public String getApplicationName() {
		return getJobParam(APPLICATION_NAME);
	}
	
	/**
	 * Name of the application to stop.
	 * @param value
	 */
	public void setApplicationName(String value) {
		setJobParam(APPLICATION_NAME, value);
	}

}
