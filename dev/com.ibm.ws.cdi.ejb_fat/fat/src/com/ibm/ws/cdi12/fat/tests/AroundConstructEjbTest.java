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

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.AssertionFailedError;

import com.ibm.ws.fat.util.browser.WebBrowser;
import com.ibm.ws.fat.util.browser.WebBrowserException;
import com.ibm.ws.fat.util.browser.WebResponse;

import componenttest.annotation.AllowedFFDC;
import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.annotation.TestServlets;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.HttpUtils;

public class AroundConstructEjbTest extends AroundConstructTestBase {

    @Server("cdi12EJB32Server")
    @TestServlets({
                    @TestServlet(servlet = com.ibm.ws.cdi12.test.aroundconstruct.BeanServlet.class, contextRoot = APP_NAME) 
    })
    public static LibertyServer server;

    @Test
    public void testStatelessAroundConstruct() {}

    @BeforeClass
    public static void setUp() throws Exception {
        serverRef = server;
        AroundConstructTestBase.setUp();
    }

    @Test
    @AllowedFFDC({ "javax.ejb.EJBException", "java.lang.reflect.UndeclaredThrowableException", "java.lang.IllegalStateException" })
    public void testPostConstructErrorMessage() {
        int errMsgCount = 0;

        try {
            HttpUtils.findStringInUrl(server, "/postConstructErrorMessageApp/errorMessageTestServlet", " "); //Just to poke the url
        } catch (Throwable e1) {
            //The request fails with HTTP status 500, that triggers an AssertionFailedError in HttpUtils. Since we're looking for an error in the logs I believe a status 500 is expected behaviour. 
        }
        try {
            errMsgCount = server.findStringsInLogs("CWOWB2001E(?=.*POST_CONSTRUCT)(?=.*java.lang.IllegalStateException)").size();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // Do you need FFDC here? Remember FFDC instrumentation and @FFDCIgnore
            // http://was.pok.ibm.com/xwiki/bin/view/Liberty/LoggingFFDC
            e.printStackTrace();
        }

        assertTrue("The expected error message stating that an interceptor lifecycle callback threw an exception did not appear", errMsgCount > 0);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (server != null && server.isStarted()) {
            server.stopServer("CWOWB2001E", "CNTR0019E", "SRVE0777E", "SRVE0315E");
        }
    }

}
