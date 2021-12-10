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

public class MapJaspiProviderTask extends MultiEntryApplicationTask {
	

	public MapJaspiProviderTask(String[] columns) {
		super(AppConstants.MapJaspiProvider, columns);
	}

	public MapJaspiProviderTask(String[][] taskData) {
		super(AppConstants.MapJaspiProvider, taskData);
		for (int i=1; i < taskData.length; i++) {
			String[] data = taskData[i];
			this.entries.add(new MapJaspiProviderEntry(data, this));
		}
	}

	@Override
	public MapJaspiProviderEntry get(int i) {
		if (i >= size())
			throw new ArrayIndexOutOfBoundsException(i);
		return (MapJaspiProviderEntry)entries.get(i);
	}

	public MapJaspiProviderEntry get(String module, String uri) {
		String[] columns = new String[]{AppConstants.APPDEPL_MODULE, AppConstants.APPDEPL_URI};
		String values[] = new String[]{module, uri};
		return (MapJaspiProviderEntry)getEntry(columns, values);
	}
}
