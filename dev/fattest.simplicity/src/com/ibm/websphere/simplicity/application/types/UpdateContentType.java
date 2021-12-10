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

package com.ibm.websphere.simplicity.application.types;

import com.ibm.websphere.simplicity.application.AppConstants;

public enum UpdateContentType {

	FILE(AppConstants.APPUPDATE_CONTENT_FILE),
	MODULE(AppConstants.APPUPDATE_CONTENT_MODULEFILE),
	PARTIAL_APP(AppConstants.APPUPDATE_CONTENT_PARTIALAPP),
	FULL_APP(AppConstants.APPUPDATE_CONTENT_APP);
	
	private String value;
	
	private UpdateContentType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
