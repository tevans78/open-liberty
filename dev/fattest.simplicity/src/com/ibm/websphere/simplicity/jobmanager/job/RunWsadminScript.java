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

public class RunWsadminScript extends Job {
	
	public static final String SCRIPT_FILE_LOCATION = "scriptFileLocation";
	public static final String PROFILE_LOCATION = "profileLocation";
	public static final String SCRIPT_PARAMETERS = "scriptParameters";
	
	/**
	 * Run a wsadmin script at a managed node.
	 * @param scriptFileLocation Location of the script file.  This will be the destination that was given when the file was distributed to the node.
	 */
	public RunWsadminScript(String scriptFileLocation) {
		super(JobType.RunWsadminScript);
		setScriptFileLocation(scriptFileLocation);
	}
	
	/**
	 * Location of the script file.  This will be the destination that was given when the file was distributed to the node.
	 * @return
	 */
	public String getScriptFileLocation() {
		return getJobParam(SCRIPT_FILE_LOCATION);
	}
	
	/**
	 * Location of the profile.  This will be the destination that was given when the file was distributed to the node.
	 * @return
	 */
	public String getProfileLocation() {
		return getJobParam(PROFILE_LOCATION);
	}
	
	/**
	 * Script parameters for the script file.  If a parameter contains any spaces, the parameter must be in quotes.  If a quoted parameter contains imbedded quotes, the imbedded quotes must be escaped with a backslash.
	 * @return
	 */
	public String getScriptParameters() {
		return getJobParam(SCRIPT_PARAMETERS);
	}
	
	/**
	 * Location of the script file.  This will be the destination that was given when the file was distributed to the node.
	 * @param value
	 */
	public void setScriptFileLocation(String value) {
		setJobParam(SCRIPT_FILE_LOCATION, value);
	}

	/**
	 * Location of the profile.  This will be the destination that was given when the file was distributed to the node.
	 * @param value
	 */
	public void setProfileLocation(String value) {
		if (value != null)
			setJobParam(PROFILE_LOCATION, value);
		else
			removeJobParam(PROFILE_LOCATION);
	}

	/**
	 * Script parameters for the script file.  If a parameter contains any spaces, the parameter must be in quotes.  If a quoted parameter contains embedded quotes, the embedded quotes must be escaped with a backslash.
	 * @param value
	 */
	public void setScriptParameters(String value) {
		if (value != null)
			setJobParam(SCRIPT_PARAMETERS, value);
		else
			removeJobParam(SCRIPT_PARAMETERS);
	}

}
