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

public class CollectFile extends Job {
	
	private static final String SOURCE = "source";
	private static final String DESTINATION = "destination";
	private static final String DISTRIBUTION_PROVIDER = "distributionProvider";
	
	/**
	 * Collect a file from managed nodes.
	 * @param source The source location of the file or directory to collect. If this is a directory, a zip file of the directory contents will be collected.  The source parameter will be taken as relative to the profile root of the target managed node.  For example, to collect the logs directory tree use &quot;logs&quot;.
	 */
	public CollectFile(String source) {
		super(JobType.CollectFile);
		setSource(source);
	}
	
	/**
	 * Collect a file from managed nodes.
	 * @param source The source location of the file or directory to collect. If this is a directory, a zip file of the directory contents will be collected.  The source parameter will be taken as relative to the profile root of the target managed node.  For example, to collect the logs directory tree use &quot;logs&quot;.
	 * @param destination The destination for the collected file.    The default value is the name of the collected file in a directory named JobManager/<jobToken>/<nodeName> under the config/temp directory of the job manager profile.  For example, <jobManagerProfile>/config/temp/JobManager/<jobToken>/<nodeName>/logs.zip.  If a destination parameter is given to the default distribution provider it only affects the name of the file created in the directory given above.  Other distribution providers may treat this parameter differently.
	 */
	public CollectFile(String source, String destination) {
		super(JobType.CollectFile);
		setSource(source);
		setDestination(destination);
	}
	
	/**
	 * The source location of the file or directory to collect. If this is a directory, a zip file of the directory contents will be collected.  The source parameter will be taken as relative to the profile root of the target managed node.  For example, to collect the logs directory tree use &quot;logs&quot;.
	 * @return
	 */
	public String getSource() {
		return getJobParam(SOURCE);
	}

	/**
	 * The destination for the collected file.    The default value is the name of the collected file in a directory named JobManager/<jobToken>/<nodeName> under the config/temp directory of the job manager profile.  For example, <jobManagerProfile>/config/temp/JobManager/<jobToken>/<nodeName>/logs.zip.  If a destination parameter is given to the default distribution provider it only affects the name of the file created in the directory given above.  Other distribution providers may treat this parameter differently.
	 * @return
	 */
	public String getDestination() {
		return getJobParam(DESTINATION);
	}
	
	/**
	 * Name of distribution provider.
	 * @return
	 */
	public String getDistributionProvider()	 {
		return getJobParam(DISTRIBUTION_PROVIDER);
	}
	
	/**
	 * The source location of the file or directory to collect. If this is a directory, a zip file of the directory contents will be collected.  The source parameter will be taken as relative to the profile root of the target managed node.  For example, to collect the logs directory tree use &quot;logs&quot;.
	 * @param value
	 */
	public void setSource(String value) {
		setJobParam(SOURCE, value);
	}

	/**
	 * The destination for the collected file.    The default value is the name of the collected file in a directory named JobManager/<jobToken>/<nodeName> under the config/temp directory of the job manager profile.  For example, <jobManagerProfile>/config/temp/JobManager/<jobToken>/<nodeName>/logs.zip.  If a destination parameter is given to the default distribution provider it only affects the name of the file created in the directory given above.  Other distribution providers may treat this parameter differently.
	 * Optional.
	 * @param value
	 */
	public void setDestination(String value) {
		if (value != null)
			setJobParam(DESTINATION, value);
		else
			removeJobParam(DESTINATION);
	}
	
	/**
	 * Name of distribution provider.
	 * <p>
	 * Optional.
	 * @param value
	 */
	public void setDistributionProvider(String value) {
		if (value != null)
			setJobParam(DISTRIBUTION_PROVIDER, value);
		else
			removeJobParam(DISTRIBUTION_PROVIDER);
	}
	
}
