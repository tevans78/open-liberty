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

public enum MethodProtectionType {
	
	DENY_ALL_PERMISSION(AppConstants.APPDEPL_METHOD_DENYALL_ACCESS_PERMISSION),
	UNCHECK(AppConstants.APPDEPL_METHOD_PROTECTION_UNCHECK),
	EXCLUDE(AppConstants.APPDEPL_METHOD_PROTECTION_EXCLUDE);
	
	public static MethodProtectionType fromValue(String value) {
		for (MethodProtectionType type : MethodProtectionType.values())
			if (type.getValue().equalsIgnoreCase(value))
				return type;
		return null;
	}
	
	private String value;
	
	private MethodProtectionType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

}
