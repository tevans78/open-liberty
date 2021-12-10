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
 * This enum contains the various user role types supported by WebSphere. In WebSphere, a user 
 * can be assigned these roles which define what that user is allowed access to. For example, 
 * the administrator role gives a user full access to administer WebSphere whereas a monitor 
 * cannot change any configuration or runtime settings.
 */
public enum RoleType {

	ADMINISTRATOR,
	ADMIN_SECURITY_MANAGER,
	AUDITOR,
	CONFIGURATOR,
	OPERATOR,
	DEPLOYER,
	MONITOR,
	NO_ROLE;
	
	public static RoleType fromRoleString(String role) {
		for (RoleType r : RoleType.values()) {
			if (r.name().toLowerCase().equals(role))
				return r;
		}
		return null;
	}
	
	public String toRoleString() {
		return this.name().toLowerCase();
	}
	
}
