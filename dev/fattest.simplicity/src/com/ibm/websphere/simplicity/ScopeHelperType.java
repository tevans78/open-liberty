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
 * {@link ScopeHelper} types
 */
public enum ScopeHelperType {

	CELL,
	NODE,
	SERVER,
	/**
	 * An alias for "Application" scope
	 */
	DEPLOYMENT,
	SERVER_CLUSTER,
	NODE_GROUP;
	
}
