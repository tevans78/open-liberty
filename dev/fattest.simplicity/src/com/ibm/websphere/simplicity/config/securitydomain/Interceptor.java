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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.config.Configurable;

public class Interceptor implements Configurable {
    
    private static String CHANGE_KEY_CUSTOMPROPERTIES = "customProperties";

    private String className;
    private Map<String, String> customProperties;
    private TrustAssociation parent;
    private ConfigObject configObj;
    
    protected Interceptor(TrustAssociation parent, InterceptorSettings wrapper) {
        this.className = wrapper.getClassName(); // can't be null
        this.customProperties = wrapper.getCustomProps();
        if(this.customProperties == null)
            this.customProperties = new HashMap<String, String>();
        this.parent = parent;
    }
    
    protected Interceptor(TrustAssociation parent, ConfigObject configObj) {
        this.parent = parent;
        this.configObj = configObj;
    }
    
    /**
     * Get the class name of the Interceptor
     * 
     * @return The class name
     * @throws Exception
     */
    public String getClassName() throws Exception {
        if(this.className == null)
            this.className = this.configObj.getAttributeByName("interceptorClassName").getValueAsString();
        return this.className;
    }
    
    public Map<String, String> getCustomProperties() throws Exception {
        if(this.customProperties == null) {
            this.customProperties = new HashMap<String, String>();
            List<ConfigObject> properties = this.configObj.getChildObjectsByDataType("Property");
            String name = null;
            String value = null;
            for(ConfigObject prop : properties) {
                name = prop.getAttributeByName("name").getValueAsString();
                value = prop.getAttributeByName("value").getValueAsString();
                this.customProperties.put(name, value);
            }
        }
        return new HashMap<String, String>(this.customProperties);
    }
    
    /**
     * Set a custom property
     * 
     * @param property The property name
     * @param value The property value
     */
    public void setCustomProperty(String property, String value) throws Exception {
        this.parent.getSecurityDomain().getCell().getWorkspace().registerConfigChange(this, CHANGE_KEY_CUSTOMPROPERTIES, getCustomProperties());
        InterceptorSettings settings = new InterceptorSettings();
        settings.setClassName(this.className);
        HashMap<String, String> properties = new HashMap<String, String>();
        properties.put(property, value);
        settings.setCustomProps(properties);
        this.parent.configureInterceptor(settings);
        this.customProperties.put(property, value);
    }
    
    /**
     * Remove a custom property
     * 
     * @param property The property to remove
     * @throws Exception
     */
    public void removeCustomProperty(String property) throws Exception {
        if(getCustomProperties().get(property) == null)
            throw new Exception("Cutom property " + property + " does not exist.");
        setCustomProperty(property, null);
        this.customProperties.remove(property);
    }
    
    /**
     * Get the parent {@link TrustAssociation} Object
     * 
     * @return The parent {@link TrustAssociation} of this Interceptor
     */
    public TrustAssociation getParent() {
        return this.parent;
    }
    
    protected ConfigObject getConfigObject() {
        return this.configObj;
    }

    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        for(Map.Entry<String, Object> entry : values.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            
            if(key.equals(CHANGE_KEY_CUSTOMPROPERTIES))
                this.customProperties = (Map)value;
        }
    }
    
}
