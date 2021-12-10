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

public class DistributeFile extends Job {
	
	private static final String SOURCE = "source";
	private static final String DESTINATION = "destination";
	private static final String DISTRIBUTION_PROVIDER = "distributionProvider";
	
	/**
	 * Distribute a file to managed nodes.
	 * @param source The source file URL.  For the default distribution provider this is a file URL relative to the job manager profile's config/temp/JobManager directory.  For example, place the file to be distributed at config/temp/JobManager/MyApp.ear and specify file:/MyApp.ear as the source parameter.  Other distribution providers may treat this parameter differently.
	 * @param destination The destination for the file.  The default distribution provider has a directory tree for downloaded content.  This parameter gives the location relative to that directory.  For example, MyApp.ear.  Other distribution providers may treat this parameter differently.  You will also use this value in subsequent jobs that need to reference this file, like Install Application or Remove File.
	 */
	public DistributeFile(String source, String destination) {
		super(JobType.DistributeFile);
		setSource(source);
		setDestination(destination);
	}
	
	/**
	 * The source file URL.  For the default distribution provider this is a file URL relative to the job manager profile's config/temp/JobManager directory.  For example, place the file to be distributed at config/temp/JobManager/MyApp.ear and specify file:/MyApp.ear as the source parameter.  Other distribution providers may treat this parameter differently.
	 * @return
	 */
	public String getSource() {
		return getJobParam(SOURCE);
	}
	
	/**
	 * The destination for the file.  The default distribution provider has a directory tree for downloaded content.  This parameter gives the location relative to that directory.  For example, MyApp.ear.  Other distribution providers may treat this parameter differently.  You will also use this value in subsequent jobs that need to reference this file, like Install Application or Remove File.
	 * @return
	 */
	public String getDestination() {
		return getJobParam(DESTINATION);
	}
	
	/**
	 * Name of distribution provider.  Use this parameter to indicate a custom distribution provider.
	 * @return
	 */
	public String getDistributionProvider()	 {
		return getJobParam(DISTRIBUTION_PROVIDER);
	}
	
	/**
	 * The source file URL.  For the default distribution provider this is a file URL relative to the job manager profile's config/temp/JobManager directory.  For example, place the file to be distributed at config/temp/JobManager/MyApp.ear and specify file:/MyApp.ear as the source parameter.  Other distribution providers may treat this parameter differently.
	 * @param value
	 */
	public void setSource(String value) {
		setJobParam(SOURCE, value);
	}
	
	/**
	 * The destination for the file.  The default distribution provider has a directory tree for downloaded content.  This parameter gives the location relative to that directory.  For example, MyApp.ear.  Other distribution providers may treat this parameter differently.  You will also use this value in subsequent jobs that need to reference this file, like Install Application or Remove File.
	 * @param value
	 */
	public void setDestination(String value) {
		setJobParam(DESTINATION, value);
	}
	
	/**
	 * Name of distribution provider.  Use this parameter to indicate a custom distribution provider.
	 * @param value
	 */
	public void setDistributionProvider(String value) {
		if (value != null)
			setJobParam(DISTRIBUTION_PROVIDER, value);
		else
			removeJobParam(DISTRIBUTION_PROVIDER);
	}
	
}
