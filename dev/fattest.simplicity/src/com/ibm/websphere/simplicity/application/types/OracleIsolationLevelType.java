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

public enum OracleIsolationLevelType {

	None(0),
	ReadUncommitted(1),
	ReadCommitted(2),
	RepeatableRead(4),
	Serializable(8);
	
	public static OracleIsolationLevelType getByValue(int value) {
		for (OracleIsolationLevelType type : OracleIsolationLevelType.values())
			if (type.getValue() == value)
				return type;
		return null;
	}
	
	private int value = 0;
	
	private OracleIsolationLevelType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
