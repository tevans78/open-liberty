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

/**
 * A web (WAR) module.
 * 
 * @author SterlingBates
 *
 */
public class WebModule extends AssetModule {
	
	public WebModule(Application application, String name, String uri) {
		super(application, ArchiveType.WAR, name, uri);
	}

}
