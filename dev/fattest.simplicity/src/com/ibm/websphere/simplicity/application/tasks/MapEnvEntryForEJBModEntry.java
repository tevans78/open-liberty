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

package com.ibm.websphere.simplicity.application.tasks;

import com.ibm.websphere.simplicity.application.AppConstants;

public class MapEnvEntryForEJBModEntry extends TaskEntry {

	public MapEnvEntryForEJBModEntry(String[] data, MultiEntryApplicationTask task) {
		super(data, task);
	}
	
	public String getAppVersion() throws Exception {
		return super.getAppVersion();
	}
	
	public String getModuleVersion() throws Exception {
		return super.getModuleVersion();
	}
	
	public String getEjbModule() {
		return super.getEjbModule();
	}
	
	public String getUri() {
		return super.getUri();
	}
	
	public String getEjb() {
		return super.getEjb();
	}
	
	public String getPropName() {
		return super.getPropName();
	}
	
	public String getPropType() {
		return super.getPropType();
	}
	
	public String getPropDesc() {
		return super.getPropDesc();
	}
	
	public String getPropValue() {
		return super.getPropValue();
	}
	
	public void setPropValue(String value) {
	    task.setModified();
		super.setPropValue(value);
	}
	
	public String getInjectionRequested() {
		return super.getItem(AppConstants.APPDEPL_INJECTION_REQUESTED);
	}

}
