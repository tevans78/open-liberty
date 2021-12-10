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

public class MapJaspiProviderEntry extends TaskEntry {

	public MapJaspiProviderEntry(String[] data, MultiEntryApplicationTask task) {
		super(data, task);
	}

	public String getModule() {
		return super.getModule();
	}
	
	public void setModule(String value) {
		task.setModified();
		super.setModule(value);
	}
	
	public String getUri() {
		return super.getUri();
	}
	
	public void setUri(String value) {
		task.setModified();
		super.setUri(value);
	}
	
	public String getUseJaspi() {
		return getString(AppConstants.APPDEPL_USE_JASPI);
	}
	
	public void setUseJaspi(String value) {
		task.setModified();
		setItem(AppConstants.APPDEPL_USE_JASPI, value);
	}
	
	public String getProviderName() {
		return getString(AppConstants.APPDEPL_PROVIDER_NAME);
	}
	
	public void setProviderName(String value) {
		task.setModified();
		setItem(AppConstants.APPDEPL_PROVIDER_NAME, value);
	}
	
	public String getMsgLayer() {
		return getString(AppConstants.APPDEPL_MSG_LAYER);
	}
	
	public void setMsgLayer(String value) {
		task.setModified();
		setItem(AppConstants.APPDEPL_MSG_LAYER, value);
	}
}
