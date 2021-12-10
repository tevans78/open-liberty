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

package com.ibm.websphere.simplicity.jobmanager;

public enum JobStatusType {
	
	ASYNC_IN_PROGRESS,
	DISTRIBUTED,
	FAIL,
	NOT_ATTEMPTED,
	PARTIALLY_SUCCEEDED,
	REJECTED,
	SUCCESS,
	;
	
	public static JobStatusType fromTypeName(String name) {
		for (JobStatusType jst : JobStatusType.values())
			if (jst.name().equalsIgnoreCase(name))
				return jst;
		return null;
	}

}
