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

package com.ibm.websphere.simplicity.runtime;

import com.ibm.websphere.simplicity.ApplicationServer;

public class RuntimeServices {
	
	private MBeans mbeans;
	private com.ibm.websphere.simplicity.ApplicationServer scope;
	private TraceServiceMBean trace;
    private NodeSyncMBean sync;
    private JVMMBean jvm;
	
	public RuntimeServices(ApplicationServer scope) {
		this.scope = scope;
	}

	public MBeans getMBeans() throws Exception {
		if (this.mbeans == null)
			this.mbeans = new MBeans(this.scope);
		return this.mbeans;
	}

	public TraceServiceMBean getTraceService() throws Exception {
		if (this.trace == null)
			this.trace = new TraceServiceMBean(this.scope);
		return this.trace;
	}
	
    public NodeSyncMBean getNodeSync() throws Exception {
        if(this.sync == null) {
            this.sync = new NodeSyncMBean(this.scope);
        }
        return this.sync;
    }
    
    public JVMMBean getJVM() throws Exception {
    	if (this.jvm == null)
    		this.jvm = new JVMMBean(this.scope);
    	return this.jvm;
    }
}
