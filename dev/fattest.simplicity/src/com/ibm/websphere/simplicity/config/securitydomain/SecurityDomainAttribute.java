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

package com.ibm.websphere.simplicity.config.securitydomain;


/**
 * This is the parent class for security domain attributes
 */
public abstract class SecurityDomainAttribute {
    
	protected SecurityDomain domain;
	
    /**
     * Constructor
     * 
     * @param domain The {@link SecurityDomain} parent
     */
	protected SecurityDomainAttribute(SecurityDomain domain) {
		this.domain = domain;
	}
    
    /**
     * Returns true if there is no configuration for these attributes in the domain. By default,
     * WebSphere uses the {@link GlobalSecurityDomain} attributes for domain attributes that do not
     * have configurations specified in a domain.
     * 
     * @return true if there is no configuration for this attribute in the domain or if this is an
     *         attribute of the {@link GlobalSecurityDomain}
     * @throws Exception
     */
    public abstract boolean globalSettingsInUse() throws Exception;
    
    /**
     * Returns the parent {@link SecurityDomain} Object
     * 
     * @return The parent {@link SecurityDomain}
     */
	public SecurityDomain getSecurityDomain() {
		return this.domain;
	}

    /**
     * This method removes the attributes represented by this class from the domain. Removing the
     * attributes causes WebSphere to default to the attributes of the {@link GlobalSecurityDomain}.
     * If this is the {@link GlobalSecurityDomain}, this method does nothing.
     * 
     * @throws Exception
     */
    public abstract void useGlobalDomainSettings() throws Exception;
    
}