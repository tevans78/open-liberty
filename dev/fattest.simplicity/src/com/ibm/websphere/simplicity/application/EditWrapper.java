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

package com.ibm.websphere.simplicity.application;

import java.util.List;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.application.tasks.ApplicationTask;

public class EditWrapper extends ApplicationOptions {
	
	private Application application;
	private boolean appEdit;
	private AssetModule module;
	private ApplicationOptions originalOptions;

	public EditWrapper(Application app, List<ApplicationTask> tasks, Cell cell, AssetModule module) throws Exception {
		super(tasks, cell);
		this.module = module;
		appEdit = (this.module == null);

		this.application = app;
		this.originalOptions = app.getApplicationOptions();
	}
	
	public Application getApplication() {
		return this.application;
	}
	
	public AssetModule getModule() {
		return this.module;
	}
	
	public boolean isFullApplicationEdit() {
		return appEdit;
	}
	
	public ApplicationOptions getOriginalOptions() {
		return this.originalOptions;
	}

}
