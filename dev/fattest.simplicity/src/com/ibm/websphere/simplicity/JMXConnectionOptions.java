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
 * These are connection options specific to a WebSphere JMX connection
 */
public class JMXConnectionOptions extends ConnectionInfo {
	
	public JMXConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password) {
		super(connType, host, port, user, password);
	}

	public JMXConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password, String profileDir) {
		super(connType, host, port, user, password, profileDir);
	}

}
