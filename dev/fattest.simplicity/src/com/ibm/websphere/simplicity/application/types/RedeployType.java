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

public enum RedeployType {
	
	DEFAULT(""),
	IGNORE_OLD_BINDINGS(AppConstants.APPREDEPL_IGNORE_OLDBND),
	IGNORE_NEW_BINDINGS(AppConstants.APPREDEPL_IGNORE_NEWBND);
	
	private String value;
	
	private RedeployType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
