/*******************************************************************************
 * Copyright (c) 2014, 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.cdi12.fat.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import java.io.File;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.ibm.websphere.simplicity.ShrinkHelper;

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.annotation.TestServlets;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;

import componenttest.topology.utils.FATServletClient;

/**
 * Tests for having one EJB implementation class with two different {@code ejb-name}s declared in {@code ejb-jar.xml}.
 */
@RunWith(FATRunner.class)
public class MultipleNamedEJBTest extends FATServletClient {

    private static final String APP_NAME = "multipleEJBsSingleClass";

    @Server("cdi12EJB32Server")
    @TestServlets({
                    @TestServlet(servlet = com.ibm.ws.cdi12.test.multipleNamedEJBs.TestServlet.class, contextRoot = APP_NAME) 
    })
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception {
        WebArchive multipleEJBsSingleClass = ShrinkWrap.create(WebArchive.class, APP_NAME+".war")
                        .addClass("com.ibm.ws.cdi12.test.multipleNamedEJBs.SimpleEJBImpl")
                        .addClass("com.ibm.ws.cdi12.test.multipleNamedEJBs.SimpleEJBLocalInterface2")
                        .addClass("com.ibm.ws.cdi12.test.multipleNamedEJBs.TestServlet")
                        .addClass("com.ibm.ws.cdi12.test.multipleNamedEJBs.SimpleManagedBean")
                        .addClass("com.ibm.ws.cdi12.test.multipleNamedEJBs.SimpleEJBLocalInterface1")
                        .add(new FileAsset(new File("test-applications/multipleEJBsSingleClass.war/resources/WEB-INF/ejb-jar.xml")), "/WEB-INF/ejb-jar.xml")
                        .add(new FileAsset(new File("test-applications/multipleEJBsSingleClass.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml");

        ShrinkHelper.exportDropinAppToServer(server, multipleEJBsSingleClass);
        server.startServer();
    }

}
