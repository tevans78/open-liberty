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
import org.junit.runner.RunWith;

import java.io.File;
import java.util.logging.Logger;

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
import componenttest.topology.utils.HttpUtils;
import componenttest.topology.impl.LibertyServer;

/**
 * Asynchronous CDI tests with EJB Timers and Scheduled Tasks
 */
@RunWith(FATRunner.class)
public class EjbTimerTest {

    private static final Logger LOG = Logger.getLogger(EjbTimerTest.class.getName());

    @Server("cdi12EJB32Server")
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception {
        WebArchive ejbTimer = ShrinkWrap.create(WebArchive.class, "ejbTimer.war")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.IncrementCountersRunnableTask")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.SessionScopedCounter")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.TestEjbTimerTimeOutServlet")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.RequestScopedCounter")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.EjbSessionBean2")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.view.EjbSessionBeanLocal")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.view.SessionBeanLocal")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.view.EjbSessionBean2Local")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.ApplicationScopedCounter")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.SessionBean")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.TestEjbNoTimerServlet")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.RequestScopedBean")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.TestEjbTimerServlet")
                        .addClass("com.ibm.ws.cdi12.test.ejb.timer.EjbSessionBean")
                        .add(new FileAsset(new File("test-applications/ejbTimer.war/resources/META-INF/permissions.xml")), "/META-INF/permissions.xml")
                        .add(new FileAsset(new File("test-applications/ejbTimer.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml");

        ShrinkHelper.exportDropinAppToServer(server, ejbTimer);
        server.startServer();
    }


    /**
     * Verifies that a Session Scoped counter works correctly when incremented via either a
     * EJB Timer (i.e asynchronously)
     *
     * @throws Exception
     *             if counter is wrong, or if an unexpected error occurs
     */
    @Test
    public void testCDIScopeViaEJBTimer() throws Exception {
        WebBrowser wb = WebBrowserFactory.getInstance().createWebBrowser();
        //the count values returned are from BEFORE the increment occurs
        //request count should always be 0 since it should be a new request each time

        //first couple of times is synchronous (no timer or task)
        verifyResponse(wb, server, "/ejbTimer/NoTimer", "session = 0 request = 0");
        verifyResponse(wb, server, "/ejbTimer/NoTimer", "session = 1 request = 0");

        //the next couple start a timer which will increment asynchronously after 1 second
        //only one timer can be active at a time so subsequent calls will block until the previous timers have finished
        verifyResponse(wb, server, "/ejbTimer/Timer", "session = 2 request = 0");
        verifyResponse(wb, server, "/ejbTimer/Timer", "session = 3 request = 0");
        verifyResponse(wb, server, "/ejbTimer/NoTimer", "session = 4 request = 0");

        //this time do the same as above but injecting a RequestScoped bean to make sure
        //we are using the Weld SessionBeanInterceptor to set up the Request scope.
        verifyResponse(wb, server, "/ejbTimer/timerTimeOut", "counter = 0");
        verifyResponse(wb, server, "/ejbTimer/timerTimeOut", "counter = 1");
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
