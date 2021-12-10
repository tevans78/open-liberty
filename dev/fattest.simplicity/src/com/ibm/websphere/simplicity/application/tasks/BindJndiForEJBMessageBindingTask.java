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

import java.util.List;

import com.ibm.websphere.simplicity.application.AppConstants;
import com.ibm.websphere.simplicity.application.AssetModule;
import com.ibm.websphere.simplicity.exception.TaskEntryNotFoundException;

public class BindJndiForEJBMessageBindingTask extends MultiEntryApplicationTask {
    
	public BindJndiForEJBMessageBindingTask(String[][] taskData) {
		super(AppConstants.BindJndiForEJBMessageBindingTask, taskData);
		for (int i=1; i < taskData.length; i++) {
			String[] data = taskData[i];
			this.entries.add(new BindJndiForEJBMessageBindingEntry(data, this));
		}
	}
	
	public BindJndiForEJBMessageBindingTask(String[] columns) {
		super(AppConstants.BindJndiForEJBMessageBindingTask, columns);
	}

	@Override
	public BindJndiForEJBMessageBindingEntry get(int i) {
		if (i >= size())
			throw new ArrayIndexOutOfBoundsException(i);
		return (BindJndiForEJBMessageBindingEntry)entries.get(i);
	}
	
	public boolean hasModule(AssetModule module) {
		return getEntry(AppConstants.APPDEPL_URI, module.getURI()) != null;
	}

	/**
	 * Returns only the first-matched binding for the specified module.  Please
	 * use getAllBindingsForModule instead.
	 * @param module
	 * @return
	 */
	@Deprecated
	public BindJndiForEJBMessageBindingEntry getBindingsForModule(AssetModule module) {
		BindJndiForEJBMessageBindingEntry entry = (BindJndiForEJBMessageBindingEntry)getEntry(AppConstants.APPDEPL_URI, module.getURI());
		return entry;
	}
	
	public List<BindJndiForEJBMessageBindingEntry> getAllBindingsForModule(AssetModule module) {
		return (List<BindJndiForEJBMessageBindingEntry>)getEntries(AppConstants.APPDEPL_URI, module.getURI());
	}
	
	/**
	 * This method assumes a single binding per module, which is incorrect.
	 * Please use the setter methods on individual binding objects returned from
	 * getAllBindingsForModule.
	 * @param module
	 * @param jndiName
	 * @param jndiDestination
	 * @param port
	 * @throws Exception
	 */
	@Deprecated
	public void setBindingsForModule(AssetModule module, String jndiName, String jndiDestination, int port) throws Exception {
		if (!hasModule(module))
			throw new TaskEntryNotFoundException();
        modified = true;
		BindJndiForEJBMessageBindingEntry entry = getBindingsForModule(module);
		entry.setJndiName(jndiName);
		entry.setJndiDestination(jndiDestination);
		entry.setListenerPort(port);
	}
}
