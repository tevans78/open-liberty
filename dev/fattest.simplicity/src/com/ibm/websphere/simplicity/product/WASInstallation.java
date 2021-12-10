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

package com.ibm.websphere.simplicity.product;

import java.util.HashSet;
import java.util.Set;

import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.Node;
import com.ibm.websphere.simplicity.product.InstalledWASProduct.WASProductID;

/**
 * This class represents a WebSphere installation. Information about the installation can be
 * obtained from this class such as the installation root, the {@link Node}s installed under this
 * WAS installation, and the {@link InstalledWASProduct}s installed.
 */
public class WASInstallation extends Installation {
    
    private Set<Node> nodes = new HashSet<Node>();
    private Set<InstalledWASProduct> products = new HashSet<InstalledWASProduct>();
    
    /**
     * Constructor
     * @param machine The machine of this install
     * @param installRoot The installation root
     * @param installType The type of install
     */
    public WASInstallation(Machine machine, String installRoot, InstallationType installType) {
        super(machine, installRoot, installType);
    }
    
    /**
     * Add a {@link Node} to this WASInstall's Set. This Node represents a Node installed under this
     * WAS install.
     * 
     * @param node The {@link Node} to add
     */
    public void addNode(Node node) {
        this.nodes.add(node);
    }
    
    /**
     * Add {@link InstalledWASProduct} to this WASInstall's Set. The WASProduct represents one of the
     * installed product's (ND, BASE, EXPRESS, etc) installed.
     * 
     * @param product The {@link InstalledWASProduct} to add
     */
    public void addProduct(InstalledWASProduct product) {
        this.products.add(product);
    }
    
    /**
     * Get the WebSphere products installed under this WAS installation. WebSphere products examples
     * include the base product (ND, BASE) and feature packs.
     * 
     * @return The installed WAS products
     * @throws Exception
     */
    public Set<InstalledWASProduct> getWASProducts() throws Exception {
        if(products.size() == 0 && nodes.size() > 0) {
            // use the first node. the installed products will be the same for every node on the install
            Node node = nodes.iterator().next();
            this.products = InstalledWASProduct.getInstalledProducts(node);
        }
        return products;
    }
    
    /**
     * Get an installed WAS product from this WAS installation. WebSphere products examples
     * include the base product (ND, BASE) and feature packs. null is returned if the specified
     * product is not installed.
     * 
     * @param productID The ID of the product to get.
     * @return The specified product or null if the product is not installed
     * @throws Exception
     */
    public InstalledWASProduct getWASProduct(WASProductID productID) throws Exception {
        Set<InstalledWASProduct> products = getWASProducts();
        if(products != null) {
            for(InstalledWASProduct product : products) {
                if(product.getProductId().equals(productID)) {
                    return product;
                } else if(product.getProductId().equals(WASProductID.ARIESJPA) 
                    && (productID.equals(WASProductID.JPA20) || productID.equals(WASProductID.OSGIAPPS))) {
                    return new InstalledWASProduct(productID, product.getName(), product.getBuildDate(), product.getBuildLevel(), product.getVersion());
                }
            }
        }
        return null;
    }
}
