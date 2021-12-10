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
import java.util.StringTokenizer;

import javax.management.Attribute;
import javax.management.ObjectName;

import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.ConnectorType;
import com.ibm.websphere.simplicity.Node;
import com.ibm.websphere.simplicity.WebSphereVersion;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.ConfigAttribute;
import com.ibm.websphere.simplicity.provider.ObjectNameHelper;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.MBeanOperationsProvider;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;

/**
 * This represents a WebSphere product. It provides access to WAS product information such as
 * the product name, build level, and build date. WebSphere products examples are ND, BASE, and
 * Express.
 */
public class InstalledWASProduct {
    
    private static Class<?> c = InstalledWASProduct.class;
    
    /**
     * Represents the product ID for an installed WAS product
     */
    public enum WASProductID {
    	ARIESJPA,
        BASE,
        BATCH,
        CEA,
        EJB3,
        EXPRESS,
        HV,
        IMP,
        JPA,
        JPA20,
        ND,
        OSGIAPPS,
        SAML,
        SCA,
        WEB2FEP,
        WEBSERVICES,
        WXDOP,
        WXS,
        XML;
        
        public static WASProductID shortNameToProductID(String productShortName) {
            final String method = "shortNameToProductID";
            Log.entering(c, method, productShortName);
            
            WASProductID ret = null;
            if("ND".equals(productShortName)) {
                ret = WASProductID.ND;
            } else if("Base".equals(productShortName)) {
                ret = WASProductID.BASE;
            } else if("WS FEP".equals(productShortName)) {
                ret = WASProductID.WEBSERVICES;
            } else if("EJB 3.0".equals(productShortName)) {
                ret = WASProductID.EJB3;
            } else if("SAML FEP".equals(productShortName)) {
                ret = WASProductID.SAML;
            } else if("SCA FEP".equals(productShortName)) {
                ret = WASProductID.SCA;
            } else if("XML FEP".equals(productShortName)) {
                ret = WASProductID.XML;
            } else if("CEA FEP".equals(productShortName)) {
                ret = WASProductID.CEA;
            } else if("Express".equals(productShortName)) {
                ret = WASProductID.EXPRESS;
            } else if("JPA FEP".equals(productShortName)) {
            	ret = WASProductID.JPA;
            } else if("ARIESJPA".equals(productShortName)) {
            	return WASProductID.ARIESJPA;
            } else if("JPA 2.0 Feature".equals(productShortName)) {
                return WASProductID.JPA20;
            } else if("OSGi Apps Feature".equals(productShortName)) {
                return WASProductID.OSGIAPPS;
            } else if("WXDOP".equals(productShortName)) {
                return WASProductID.WXDOP;
            } else if ("BATCH FEP".equals(productShortName)) {
            	return WASProductID.BATCH;
            } else if ("WXS".equals(productShortName)) {
            	return WASProductID.WXS;
            }
            else {
                Log.finer(c, method, "Unknown product short name " + productShortName);
            }
            
            Log.exiting(c, method, ret);
            return ret;
        }
    }
    
    /**
     * Constructor
     * 
     * @param productId The product ID
     * @param name The name of the product
     * @param buildDate The build date of the product
     * @param buildLevel The build level of the product
     * @param version The version of the product
     */
    public InstalledWASProduct(WASProductID productId, String name, String buildDate, String buildLevel, WebSphereVersion version) {
        this.productId = productId;
        this.name = name;
        this.buildDate = buildDate;
        this.buildLevel = buildLevel;
        this.version = version;
    }

    private String name;
    private String buildDate;
    private String buildLevel;
    private WASProductID productId;
    private WebSphereVersion version;
    
    /**
     * Get the product build date. The build date is the date on which the this particular build
     * level was created. ex: 4/23/08
     * 
     * @return The build date for this product
     */
    public String getBuildDate() {
        return buildDate;
    }

    /**
     * Get the build level ex: xx0824.44
     * 
     * @return The build level
     */
    public String getBuildLevel() {
        return buildLevel;
    }

    /**
     * Get the name for this product. The product name (along with ID) uniquely identifies a
     * WebSphere product. ex: IBM WebSphere Application Server
     * 
     * @return The product name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the product ID. The product ID (along with product name) uniquely identifies a WebSphere
     * product. ex: ND, BASE
     * 
     * @return The product ID
     */
    public WASProductID getProductId() {
        return productId;
    }

    /**
     * Get the version of this product (ex: 7.0.0.0). The product version determines the
     * functionality level of the WAS servers.
     * 
     * @return The product version
     */
    public WebSphereVersion getVersion() {
        return version;
    }
    
    /**
     * Get a Set of installed products for a particular node. This method returns all the products
     * for the WAS installation that the Node is a part of.
     * 
     * @param node The node to get the installed products for
     * @return A Set of {@link InstalledWASProduct}s
     * @throws Exception
     */
    public static Set<InstalledWASProduct> getInstalledProducts(Node node) throws Exception {
        final String method = "getInstalledProducts";
        Log.entering(c, method);
        String installedProductsString = null;
        if(node.getManager().getServerStatus() == ProcessStatus.RUNNING && node.getConnInfo().getConnType() != ConnectorType.NONE) { // if manager is running
            Log.finer(c, method, "Found a running server. Using that to find the installed products.");
            // need to get this from a server mbean since a node has no mbean
            MBeanOperationsProvider mbeanProvider = OperationsProviderFactory.getProvider().getMBeanOperationsProvider();
            ApplicationServer manager = node.getManager();
            ObjectNameHelper objNameHelper = ObjectNameHelper.getServer(manager.getServerType(), manager.getCellName(), manager.getNode().getName());
            // should only be one
            ObjectName objName = mbeanProvider.queryNames(manager, objNameHelper.toObjectName())[0];
            installedProductsString = (String)((Attribute)(mbeanProvider.getMBeanAttributes(manager, objName, new String[]{ConfigAttribute.SERVER_VERSION.getAttribute()}).get(0))).getValue();
        } else {
            Log.finer(c, method, "Using the command line provider to run versionInfo");
            String cmd = node.getProfileDir() + "/bin/versionInfo" + node.getMachine().getOperatingSystem().getDefaultScriptSuffix();
            installedProductsString = CommandLineProviderFactory.getProvider().executeCommand(node.getMachine(), cmd, null, null, null).getStdout();
        }
        Log.finer(c, method, installedProductsString);
        Set<InstalledWASProduct> installedProducts = processInstalledProducts(installedProductsString);
        Log.exiting(c, method, installedProducts);
        return installedProducts;
    }
    
    /**
     * This method parses the product install String returned by versionInfo and the server mbean.
     * It is of the form:<br>
     * IBM WebSphere Application Server Version Report<br>
     * Installed Product<br>
     * ----------------------------------------------------------<br>
     * <br>
     * Name IBM WebSphere Application Server<br>
     * Version 6.1.0.17<br>
     * ID BASE<br>
     * Build Level cf170817.27<br>
     * Build Date 5/3/08<br>
     * 
     * @param productString The installed product string
     */
    private static Set<InstalledWASProduct> processInstalledProducts(String productString) {
        final String method = "processInstalledProducts";
        Log.entering(c, method, productString);
        Set<InstalledWASProduct> productSet = new HashSet<InstalledWASProduct>();
        StringTokenizer st = new StringTokenizer(productString, "\t\n\r\f");
        String name = null;
        String version = null;
        String id = null;
        String buildLevel = null;
        String buildDate = null;
        String newLine = null;
        InstalledWASProduct product = null;
        if(st.hasMoreTokens()) {
            newLine = st.nextToken();
        }
        while (st.hasMoreTokens()) {
            Log.finest(c, method, "Processing: " + newLine);
            // Did we find an installed product?
            if (newLine.startsWith("Installed Product")) {
                Log.finer(c, method, "Found an installed product.");
                // Get the values for this product
                while (st.hasMoreTokens()) {
                    newLine = st.nextToken();
                    Log.finest(c, method, "Processing: " + newLine);
                    if (newLine.startsWith("Name")) {
                        name = newLine.replaceFirst("Name", "").trim();
                        Log.finer(c, method, "name=" + name);
                    } else if (newLine.startsWith("Version")) {
                        version = newLine.replaceFirst("Version", "").trim();
                        Log.finer(c, method, "version=" + version);
                    } else if (newLine.startsWith("ID")) {
                        id = newLine.replaceFirst("ID", "").trim();
                        Log.finer(c, method, "id=" + id);
                    } else if (newLine.startsWith("Build Level")) {
                        buildLevel = newLine.replaceFirst("Build Level", "").trim();
                        Log.finer(c, method, "buildLevel=" + buildLevel);
                    } else if (newLine.startsWith("Build Date")) {
                        buildDate = newLine.replaceFirst("Build Date", "").trim();
                        Log.finer(c, method, "buildDate=" + buildDate);
                    }
                    // Oops, hit another product, exit so we can start again
                    else if (newLine.startsWith("Installed Product")) {
                        break;
                    }
                } 
                // add this product to the set, then move on
                Log.finest(c, method, "Creating the InstalledWASProduct Object.");
                WASProductID prodID = WASProductID.valueOf(id);
                product = new InstalledWASProduct(prodID, name, buildDate, buildLevel, new WebSphereVersion(version));
                productSet.add(product);
            } else {
                newLine = st.nextToken();
            }
        }
        Log.exiting(c, method, productSet);
        return productSet;
    }
}
