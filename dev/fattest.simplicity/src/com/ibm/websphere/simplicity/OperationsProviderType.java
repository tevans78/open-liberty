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


public enum OperationsProviderType {
	
	JMX("com.ibm.websphere.simplicity.provider.jmx.JmxCommandProvider"),
    WSADMIN("com.ibm.websphere.simplicity.provider.websphere.wsadmin.WsadminOperationsProvider");
	
	public static OperationsProviderType fromString(String s) {
		for (OperationsProviderType type : OperationsProviderType.values())
			if (type.name().equalsIgnoreCase(s))
				return type;
		return null;
	}
	
	private String clsname = null;
	
	private OperationsProviderType(String clsname) {
		this.clsname = clsname;
	}
	
	public String getClassName() {
		return this.clsname;
	}

}
