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

import java.util.List;

public class JobParameterMetadata {
	
	private String name;
	private String type;
	private String labelKey;
	private String descriptionKey;
	private boolean optional;
	List<Object> usage;		// don't know what this is
	
	public JobParameterMetadata() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getLabelKey() {
		return labelKey;
	}
	
	public String getDescriptionKey() {
		return descriptionKey;
	}

	public boolean isOptional() {
		return optional;
	}

}
