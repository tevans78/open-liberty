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

public class MapEnvEntryForWebModEntry extends TaskEntry {

	public MapEnvEntryForWebModEntry(String[] data, MultiEntryApplicationTask task) {
		super(data, task);
	}
	
	public String getModule() {
		return super.getWebModule();
	}
	
	public String getUri() {
		return super.getUri();
	}
	
	public String getEnvName() {
		return super.getPropName();
	}
	
	public String getEnvType() {
		return super.getPropType();
	}

	public String getEnvDesc() {
		return super.getPropDesc();
	}

	public String getEnvValue() {
		return super.getPropValue();
	}
	
	public void setEnvValue(String value) {
	    task.setModified();
		super.setPropValue(value);
	}

}
