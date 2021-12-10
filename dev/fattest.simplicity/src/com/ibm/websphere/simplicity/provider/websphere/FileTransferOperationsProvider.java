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

package com.ibm.websphere.simplicity.provider.websphere;

import com.ibm.websphere.simplicity.provider.CategorizedOperationsBase;

public abstract class FileTransferOperationsProvider extends CategorizedOperationsBase {

	public FileTransferOperationsProvider(WebSphereOperationsProvider parent) {
		super(parent);
	}
	
	public abstract void upload(String src, String dest) throws Exception;
	public abstract void download(String src, String dest) throws Exception;

}
