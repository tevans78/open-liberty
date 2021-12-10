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

public enum JobType {

	CollectFile("collectFile"),
	ConfigureProperties("configureProperties"),
	CreateApplicationServer("createApplicationServer"),
	CreateCluster("createCluster"),
	CreateClusterMember("createClusterMember"),
	CreateProxyServer("createProxyServer"),
	DeleteApplicationServer("deleteApplicationServer"),
	DeleteCluster("deleteCluster"),
	DeleteClusterMember("deleteClusterMember"),
	DeleteProxyServer("deleteProxyServer"),
	DistributeFile("distributeFile"),
	InstallApplication("installApplication"),
	Inventory("inventory"),
	RemoveFile("removeFile"),
	RunWsadminScript("runWsadminScript"),
	StartApplication("startApplication"),
	StartCluster("startCluster"),
	StartServer("startServer"),
	StopApplication("stopApplication"),
	StopCluster("stopCluster"),
	StopServer("stopServer"),
	Status("status"),
	UninstallApplication("uninstallApplication"),
	/**
	 * Internal use only.
	 */
	Unknown(""),
	UpdateApplication("updateApplication"),
	;
	
	public static JobType getByJobName(String name) {
		for (JobType jt : JobType.values())
			if (jt.getJobName().equalsIgnoreCase(name))
				return jt;
		return null;
	}
	
	private String jobName;
	
	private JobType(String jobName) {
		this.jobName = jobName;
	}
	
	public String getJobName() {
		return this.jobName;
	}

}
