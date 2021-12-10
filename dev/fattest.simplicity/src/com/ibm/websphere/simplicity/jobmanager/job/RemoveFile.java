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

public class RemoveFile extends Job {
	
	private static final String LOCATION = "location";
	private static final String DISTRIBUTION_PROVIDER = "distributionProvider";
	
	/**
	 * Remove a distributed file from managed nodes.
	 * @param path The location of file to remove.  Give the same value here as you previously gave for the destination parameter when the file was distributed.
	 */
	public RemoveFile(String path) {
		super(JobType.RemoveFile);
		setPath(path);
	}
	
	/**
	 * The location of file to remove.  Give the same value here as you previously gave for the destination parameter when the file was distributed.
	 * @return
	 */
	public String getPath() {
		return getJobParam(LOCATION);
	}
	
	/**
	 * Name of distribution provider.
	 * @return
	 */
	public String getDistributionProvider()	 {
		return getJobParam(DISTRIBUTION_PROVIDER);
	}
	
	/**
	 * The location of file to remove.  Give the same value here as you previously gave for the destination parameter when the file was distributed.
	 * @param value
	 */
	public void setPath(String value) {
		setJobParam(LOCATION, value);
	}

	/**
	 * Name of distribution provider.
	 * @param value
	 */
	public void setDistributionProvider(String value) {
		if (value != null)
			setJobParam(DISTRIBUTION_PROVIDER, value);
		else
			removeJobParam(DISTRIBUTION_PROVIDER);
	}
	
}
