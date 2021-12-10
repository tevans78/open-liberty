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

public class MapEnvEntryForEJBModTask extends MultiEntryApplicationTask {

	public MapEnvEntryForEJBModTask(String[][] taskData) {
		super(AppConstants.MapEnvEntryForEJBModTask, taskData);
		for (int i=1; i < taskData.length; i++) {
			String[] data = taskData[i];
			this.entries.add(new MapEnvEntryForEJBModEntry(data, this));
		}
	}

	public MapEnvEntryForEJBModTask(String[] columns) {
		super(AppConstants.MapEnvEntryForEJBModTask, columns);
	}

	@Override
	public MapEnvEntryForEJBModEntry get(int i) {
		if (i >= size())
			throw new ArrayIndexOutOfBoundsException(i);
		return (MapEnvEntryForEJBModEntry)entries.get(i);
	}

}
