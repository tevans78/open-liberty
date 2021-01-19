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

import java.io.File;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
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

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.ws.fat.util.browser.WebBrowser;
import com.ibm.ws.fat.util.browser.WebBrowserFactory;
import com.ibm.ws.fat.util.browser.WebResponse;

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.HttpUtils;

import componenttest.annotation.ExpectedFFDC;

/**
 * All CDI tests with all applicable server features enabled.
 */
@RunWith(FATRunner.class)
public class StatefulSessionBeanInjectionTest {

    private static final Logger LOG = Logger.getLogger(StatefulSessionBeanInjectionTest.class.getName());

    @Server("cdi12StatefulSessionBeanServer")
    public static LibertyServer server;


    @BeforeClass
    public static void setUp() throws Exception {
        JavaArchive statefulSessionBeanInjection = ShrinkWrap.create(JavaArchive.class,"statefulSessionBeanInjection.jar")
                        .addClass("com.ibm.ws.cdi12.test.implicitEJB.InjectedEJBImpl")
                        .addClass("com.ibm.ws.cdi12.test.implicitEJB.InjectedEJB")
                        .addClass("com.ibm.ws.cdi12.test.implicitEJB.InjectedBean1")
                        .addClass("com.ibm.ws.cdi12.test.implicitEJB.InjectedBean2")
                        .add(new FileAsset(new File("test-applications/statefulSessionBeanInjection.jar/resources/META-INF/beans.xml")), "/META-INF/beans.xml");

        WebArchive statefulSessionBeanInjectionWar = ShrinkWrap.create(WebArchive.class, "statefulSessionBeanInjection.war")
                        .addClass("com.ibm.ws.cdi12.test.implicitEJB.servlet.RemoveServlet")
                        .addClass("com.ibm.ws.cdi12.test.implicitEJB.servlet.TestServlet")
                        .add(new FileAsset(new File("test-applications/statefulSessionBeanInjection.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml")
                        .addAsLibrary(statefulSessionBeanInjection);

        ShrinkHelper.exportDropinAppToServer(server, statefulSessionBeanInjectionWar);
        server.startServer();

    }

    @Test
    @ExpectedFFDC("javax.ejb.NoSuchEJBException")
    public void testStatefulEJBRemoveMethod() throws Exception {
        WebBrowser wb = WebBrowserFactory.getInstance().createWebBrowser();

        verifyResponse(wb, server, 
                            "/statefulSessionBeanInjection/",
                            "Test Sucessful! - STATE1");

        verifyResponse(wb, server, 
                            "/statefulSessionBeanInjection/",
                            "Test Sucessful! - STATE2");

        verifyResponse(wb, server, 
                            "/statefulSessionBeanInjection/remove",
                            "EJB Removed!");

        verifyResponse(wb, server, 
                            "/statefulSessionBeanInjection/",
                            "NoSuchEJBException");
        // TODO Note that we stop the server in the test so that the expected FFDC on shutdown
        // happens in the testcase.  It is questionable that this FFDC is produced here.
        // It makes for the appearance of some leak with removed EJBs in the weld session
        server.stopServer();
    }

    private WebResponse verifyResponse(WebBrowser webBrowser, LibertyServer server, String resource, String expectedResponse) throws Exception {
        String url = this.createURL(server, resource);
        WebResponse response = webBrowser.request(url);
        LOG.info("Response from webBrowser: " + response.getResponseBody());
        response.verifyResponseBodyContains(expectedResponse);
        return response;
    }

    private static String createURL(LibertyServer server, String path) {
        if (!path.startsWith("/"))
            path = "/" + path;
        return "http://" + server.getHostname() + ":" + server.getHttpDefaultPort() + path;
    }


}
