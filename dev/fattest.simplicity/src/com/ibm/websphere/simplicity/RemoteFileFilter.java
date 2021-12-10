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

/**
 * A filter for remote files.<br>
 * <br>
 * Instances of this interface may be passed to the {@link RemoteFile#list(RemoteFileFilter, boolean)} method
 * as a means to search a file system based on the custom filter.
 * 
 */
public interface RemoteFileFilter {

	/**
     * Tests whether or not the specified abstract pathname should be included in a pathname list.
     * 
     * @param file The remote file to be tested
     * @return true if and only if <code>file</code> should be included
     */
	public boolean accept(RemoteFile file);
	
}
