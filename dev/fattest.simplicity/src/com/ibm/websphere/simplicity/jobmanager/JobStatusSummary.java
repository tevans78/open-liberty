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

package com.ibm.websphere.simplicity.jobmanager;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Map.Entry;

public class JobStatusSummary {
	
	private Hashtable<JobStatusType, Integer> values = new Hashtable<JobStatusType, Integer>();
	private OverallJobStatusType overallStatus;
	private int totalJobs = 0;
	
	protected JobStatusSummary(Properties p) {
		for (Entry<Object, Object> entry : p.entrySet()) {
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			
			if (JobStatusType.fromTypeName(key) != null) {
				values.put(JobStatusType.fromTypeName(key), Integer.parseInt(value));
			} else if (key.equalsIgnoreCase("STATE")) {
				overallStatus = OverallJobStatusType.fromTypeName(value);
			} else if (key.equalsIgnoreCase("TOTAL_RESULTS")) {
				totalJobs = Integer.parseInt(value);
			}
		}
	}

	public int getNumberByStatus(JobStatusType status) {
		return values.get(status);
	}
	
	public OverallJobStatusType getOverallStatus() {
		return overallStatus;
	}
	
	public int getTotalJobs() {
		return this.totalJobs;
	}

}

