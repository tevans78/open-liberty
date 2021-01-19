/*******************************************************************************
 * Copyright (c) 2015, 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.cdi12.fat.tests;

import static componenttest.custom.junit.runner.Mode.TestMode.FULL;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.ibm.ws.fat.util.LoggingTest;
import com.ibm.ws.fat.util.ShrinkWrapSharedServer;
import com.ibm.ws.fat.util.browser.WebBrowser;

import com.ibm.websphere.simplicity.ShrinkHelper;

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.HttpUtils;


/**
 * Scope tests for EJBs
 */
@Mode(FULL)
@RunWith(FATRunner.class)
public class EjbMiscTest {

    @Server("cdi12EjbConstructorInjectionServer")
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception  {
       
        JavaArchive multipleWarEmbeddedJar = ShrinkWrap.create(JavaArchive.class,"multipleWarEmbeddedJar.jar")
                    .addClass("com.ibm.ws.cdi.lib.MyEjb");

        WebArchive multipleWarOne = ShrinkWrap.create(WebArchive.class, "multipleWar1.war")
                    .addClass("test.multipleWar1.TestServlet")
                    .addClass("test.multipleWar1.MyBean")
                    .add(new FileAsset(new File("test-applications/multipleWar1.war/resources/WEB-INF/ejb-jar.xml")), "/WEB-INF/ejb-jar.xml")
                    .add(new FileAsset(new File("test-applications/multipleWar1.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml")
                    .addAsLibrary(multipleWarEmbeddedJar);

        WebArchive multipleWarTwo = ShrinkWrap.create(WebArchive.class, "multipleWar2.war")
                    .addClass("test.multipleWar2.TestServlet")
                    .addClass("test.multipleWar2.MyBean")
                    .add(new FileAsset(new File("test-applications/multipleWar2.war/resources/WEB-INF/ejb-jar.xml")), "/WEB-INF/ejb-jar.xml")
                    .add(new FileAsset(new File("test-applications/multipleWar2.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml")
                    .addAsLibrary(multipleWarEmbeddedJar);

        WebArchive ejbScope = ShrinkWrap.create(WebArchive.class, "ejbScope.war")
                    .addClass("com.ibm.ws.cdi12.test.ejb.scope.PostConstructingStartupBean")
                    .addClass("com.ibm.ws.cdi12.test.ejb.scope.PostConstructScopeServlet")
                    .addClass("com.ibm.ws.cdi12.test.ejb.scope.RequestScopedBean");

        ShrinkHelper.exportDropinAppToServer(server, multipleWarOne);
        ShrinkHelper.exportDropinAppToServer(server, multipleWarTwo);
        ShrinkHelper.exportDropinAppToServer(server, ejbScope);

        server.startServer();
    }

    /**
     * Test that the request scope is active during postConstruct for an eager singleton bean.
     *
     * @throws Exception
     */
    @Test
    public void testPostConstructRequestScope() throws Exception {

        HttpUtils.findStringInUrl(server, "/ejbScope/PostConstructScope", "true");
    }

    @Test
    public void testDupEJBClassNames() throws Exception {

        HttpUtils.findStringInUrl(server, "/multipleWar1", "MyEjb myWar1Bean");
        HttpUtils.findStringInUrl(server, "/multipleWar2", "MyEjb myWar2Bean");
    }

}
