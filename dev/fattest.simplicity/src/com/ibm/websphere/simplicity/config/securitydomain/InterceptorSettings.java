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

import java.util.Map;

/**
 * Wrapper class to hold {@link Interceptor} settings needed to configure
 * an {@link Interceptor}
 */
public class InterceptorSettings {

    private String className;
    private Map<String, String> customProps;
    
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public Map<String, String> getCustomProps() {
        return customProps;
    }
    public void setCustomProps(Map<String, String> customProps) {
        this.customProps = customProps;
    }
}
