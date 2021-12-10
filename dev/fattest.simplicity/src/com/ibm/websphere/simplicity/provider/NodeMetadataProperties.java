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

package com.ibm.websphere.simplicity.provider;

/**
 * Properties found within node-metadata.properties
 */
public enum NodeMetadataProperties {
    
    BASE_PRODUCT_SHORT_NAME ("com.ibm.websphere.baseProductShortName"),
    WSFP_PRODUCT_SHORT_NAME ("com.ibm.websphere.WebServicesFeaturePackProductShortName"),
    SAML_PRODUCT_SHORT_NAME ("com.ibm.websphere.SamlFeaturePackProductShortName"),
    EJB3_PRODUCT_SHORT_NAME ("com.ibm.websphere.EJB3FeaturePackProductShortName"),
    SCA_PRODUCT_SHORT_NAME ("com.ibm.websphere.SCAFeaturePackProductShortName"),
    XML_PRODUCT_SHORT_NAME ("com.ibm.websphere.XMLFeaturePackProductShortName"),
    CEA_PRODUCT_SHORT_NAME ("com.ibm.websphere.CEAFeaturePackProductShortName"),
    JPA_PRODUCT_SHORT_NAME ("com.ibm.websphere.JPAFeaturePackProductShortName"),
    OSGI_PRODUCT_SHORT_NAME ("com.ibm.websphere.AriesFeaturePackProductShortName"),
    WXDOP_PRODUCT_SHORT_NAME ("com.ibm.websphere.wxdopProductShortName"),
    WXS_PRODUCT_SHORT_NAME ("com.ibm.websphere.xsProductShortName"),
    BATCH_PRODUCT_SHORT_NAME ("com.ibm.websphere.BATFeaturePackProductShortName");
    
    private String property;
    
    private NodeMetadataProperties(String property) {
        this.property = property;
    }

    public String getPropertyName() {
        return this.property;
    }
}
