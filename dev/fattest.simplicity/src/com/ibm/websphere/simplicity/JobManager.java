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

package com.ibm.websphere.simplicity;

import java.util.ArrayList;

import javax.management.AttributeList;

import com.ibm.websphere.simplicity.jobmanager.Jobs;

/**
 * This class represents a WebSphere job manager server. This corresponds to the
 * {@link ServerType#JOB_MANAGER} server type. The job manager allows the user to submit, schedule,
 * and track jobs to the registered nodes.
 * 
 * @see WebSphereTopologyType#FLEX
 * @see ApplicationServer
 */
public class JobManager extends ApplicationServer {
	
	public Jobs jobs;

    /**
     * Constructor
     * 
     * @param configId The {@link ConfigIdentifier} that uniquely identifies this JobManager
     * @param cell The {@link Cell} to which this JobManager belongs
     * @param node The {@link Node} to which this JobManager belongs
     */
	public JobManager(ConfigIdentifier configId, Cell cell, Node node, ArrayList<AttributeList> portInitData) throws Exception {
		super(configId, cell, node, ServerType.JOB_MANAGER, portInitData);
	}

	public Jobs getJobs() {
		if (this.jobs == null)
			this.jobs = new Jobs(this);
		return this.jobs;
	}

}
