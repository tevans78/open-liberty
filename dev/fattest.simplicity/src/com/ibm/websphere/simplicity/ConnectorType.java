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

package com.ibm.websphere.simplicity;

/**
 * A connector type corresponds to a communication protocol with a running
 * WebSphere instance.  They are somewhat self-explanatory; RMI is a standard remote-
 * method-invocation protocol, while JSR160RMI is RMI based on the public JSR 160
 * standard.  IPC is a strictly localhost-only protocol, and is used for high-performance
 * communication.
 */
public enum ConnectorType {
	JSR160RMI("BOOTSTRAP_ADDRESS"),
	RMI("BOOTSTRAP_ADDRESS"),
	IPC("IPC_CONNECTOR_ADDRESS"),
	SOAP("SOAP_CONNECTOR_ADDRESS"),
    NONE("NONE");
	
    /**
     * Convert a <code>String</code> value to a <code>ConnectorType</code>
     * 
     * @param s The <code>String</code> to convert
     * @return The converted <code>String</code>
     */
	public static ConnectorType fromString(String s) {
		for (ConnectorType type : ConnectorType.values())
			if (type.name().equalsIgnoreCase(s))
				return type;
		return null;
	}
	
    /**
     * Check if a <code>String</code> represents a valid <code>ConnectorType</code>
     * 
     * @param s The <code>String</code> to check
     * @return true if the <code>String</code> is a valid <code>ConnectorType</code>
     */
	public static boolean isValidConnectorType(String s) {
		return (fromString(s) != null);
	}

    /**
     * Check if a <code>String</code> represents a valid connector endpoint name. The 
     * endpoint name is the name of the port for a WebSphere connector type.
     * 
     * @param s The <code>String</code> to check
     * @return true if the <code>String</code> is a valid connector endpoint name
     */
	public static boolean isValidEndpointName(String s) {
		/*
		 * Admin Agent subsystems have their own twist on the names, so
		 * just validate the first part of the string.
		 */
		for (ConnectorType c : ConnectorType.values())
			if (c.getEndpointName().startsWith(s))
				return true;
		return false;
	}
	
	private String endpointName;
	
	private ConnectorType(String endpointName) {
		this.endpointName = endpointName;
	}
	
    /**
     * Get the endoint name of this <code>ConnectorType</code>. The endpoint name is the name of
     * the port used to make a connection of this type.
     * 
     * @return The endpoint name
     */
	public String getEndpointName() {
		return this.endpointName;
	}
}
