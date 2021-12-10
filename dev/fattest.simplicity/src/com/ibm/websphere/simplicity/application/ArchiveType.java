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
 * J2EE Module Type 			Deployment Descriptor Filename in Module 	XML Schema for Deployment Descriptor
 * Web Application (WAR) 		WEB-INF/web.xml 							web-app_2_4.xsd
 * Enterprise Application (EAR) META-INF/application.xml 					application_1_4.xsd
 * Enterprise Java Beans (JAR) 	META-INF/ejb-jar.xml 						ejb-jar_2_1.xsd
 * J2EE Connectors (RAR) 		META-INF/ra.xml 							connector_1_5.xsd
 * Client Application 			META-INF/application-client.xml 			application-client_1_4.xsd 
 * 
 * @author SterlingBates
 *
 */
public enum ArchiveType {
	EAR("META-INF/application.xml"),
	WAR("WEB-INF/web.xml"),
	JAR("META-INF/ejb-jar.xml"),
	RAR("META-INF/ra.xml"),
	SAR("WEB-INF/sip.xml"),
	UNKNOWN("");
	
	public static ArchiveType fromExtension(String ddURI) {
		if (ddURI == null)
			return UNKNOWN;
		
		ArchiveType[] values = ArchiveType.values();
        for(int i = 0; i < values.length; ++i) {
            if(values[i].getDescriptorLocation().equals(ddURI)) {
                return values[i];
            }
        }
        return UNKNOWN;
	}
	
	private String descriptorLocation;
	
	private ArchiveType(String descriptorLocation) {
		this.descriptorLocation = descriptorLocation;
	}
	
	public String getDescriptorLocation() {
		return this.descriptorLocation;
	}
	
	public String toFileExtension() {
		return "."+this.name().toLowerCase();
	}
}
