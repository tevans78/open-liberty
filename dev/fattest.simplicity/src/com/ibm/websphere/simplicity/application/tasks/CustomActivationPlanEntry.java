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

public class CustomActivationPlanEntry extends TaskEntry {

	public CustomActivationPlanEntry(String[] data, MultiEntryApplicationTask task) {
		super(data, task);
	}
	
	public String getModule() {
		return super.getModule();
	}
	
	public String getUri() {
		return super.getUri();
	}
	
	public String getAddPlan() {
		return super.getString(AppConstants.APPDEPL_ACTIVATION_PLAN_ADD);
	}
	
	public void setAddPlan(String value) {
		super.setItem(AppConstants.APPDEPL_ACTIVATION_PLAN_ADD, value);
	}
	
	public String getRemovePlan() {
		return super.getString(AppConstants.APPDEPL_ACTIVATION_PLAN_REMOVE);
	}
	
	public void setRemovePlan(String value) {
	    task.setModified();
		super.setItem(AppConstants.APPDEPL_ACTIVATION_PLAN_REMOVE, value);
	}

}
