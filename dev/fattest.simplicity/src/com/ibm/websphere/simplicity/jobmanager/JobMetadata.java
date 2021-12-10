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

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.WebSphereVersion;

public class JobMetadata {
	
	private String name;
	private String labelKey;
	private String descriptionKey;
	private WebSphereVersion version;
	private String resourceBundle;
//	private List<JobParameterMetadata> parameters;
//	private List<JobPropertiesMetadata> properties;
//	private List<JobParameterGroupsMetadata> groups;
	
	public JobMetadata(AttributeList attributes) {
		init(attributes);
	}
	
	public String getName() {
		return name;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public String getDescriptionKey() {
		return descriptionKey;
	}

	public WebSphereVersion getVersion() {
		return version;
	}

	public String getResourceBundle() {
		return resourceBundle;
	}

	private void init(AttributeList attributes) {
		for (Object o : attributes) {
			Attribute attrib = (Attribute)o;
			String key = attrib.getName();
			String value = null;
			if (attrib.getValue() instanceof String)
				value = (String)attrib.getValue();
			if (key.equalsIgnoreCase("name"))
				this.name = value;
			else if (key.equalsIgnoreCase("labelKey"))
				this.labelKey = value;
			else if (key.equalsIgnoreCase("descriptionKey"))
				this.descriptionKey = value;
			else if (key.equalsIgnoreCase("version"))
				this.version = new WebSphereVersion(value);
			else if (key.equalsIgnoreCase("resourceBundle"))
				this.resourceBundle = value;
			else if (key.equalsIgnoreCase("job-parameters"))
				buildParameters(attrib.getValue());
			else if (key.equalsIgnoreCase("job-properties"))
				buildProperties(attrib.getValue());
			else if (key.equalsIgnoreCase("job-parameter-groups"))
				buildParameterGroups(attrib.getValue());
		}
	}
	
	private void buildParameters(Object o) {
		
	}
	
	private void buildProperties(Object o) {
		
	}
	
	private void buildParameterGroups(Object o) {
		
	}

}
