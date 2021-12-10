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

package com.ibm.websphere.simplicity.config;

public enum ConfigObjectConfigType {
	
	Attribute,
	Object;
	
	public static ConfigObjectConfigType getValueType(String dataType) {
		String[] primitives = {
				"String",
				"boolean",
				"int",
				"Enum"
		};
		for (String prim : primitives)
			if (dataType.equalsIgnoreCase(prim))
				return Attribute;
		
		return Object;
	}

}
