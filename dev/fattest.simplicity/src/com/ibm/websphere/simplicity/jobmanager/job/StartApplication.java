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

public class StartApplication extends Job {
	
	private static final String APPLICATION_NAME = "applicationName";
	
	/**
	 * Start an application.
	 * @param applicationName The name of the application to start.
	 */
	public StartApplication(String applicationName) {
		super(JobType.StartApplication);
		setApplicationName(applicationName);
	}
	
	/**
	 * The name of the application to start.
	 * @return
	 */
	public String getApplicationName() {
		return getJobParam(APPLICATION_NAME);
	}
	
	/**
	 * The name of the application to start.
	 * @param value
	 */
	public void setApplicationName(String value) {
		setJobParam(APPLICATION_NAME, value);
	}

}
