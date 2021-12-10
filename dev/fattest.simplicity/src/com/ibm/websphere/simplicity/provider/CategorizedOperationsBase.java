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

package com.ibm.websphere.simplicity.provider;

import com.ibm.websphere.simplicity.provider.websphere.WebSphereOperationsProvider;

public abstract class CategorizedOperationsBase {
	
	protected WebSphereOperationsProvider parent;
	
	public CategorizedOperationsBase(WebSphereOperationsProvider parent) {
		this.parent = parent;
	}
	
	protected WebSphereOperationsProvider getParent() {
		return this.parent;
	}

}
