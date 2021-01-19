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

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.rules.TestRule;

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
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;

/**
 * Tests for the <code>@AroundConstruct</code> lifecycle callback, defined in Interceptors 1.2.
 */
@RunWith(FATRunner.class)
public abstract class AroundConstructTestBase extends FATServletClient {

    protected static final String APP_NAME = "aroundConstructApp";

    protected static LibertyServer serverRef = null;

    public static void setUp() throws Exception {

        JavaArchive utilLib = ShrinkWrap.create(JavaArchive.class,"utilLib.jar")
                        .addClass("com.ibm.ws.cdi12.test.utils.ChainableListImpl")
                        .addClass("com.ibm.ws.cdi12.test.utils.Intercepted")
                        .addClass("com.ibm.ws.cdi12.test.utils.ChainableList")
                        .addClass("com.ibm.ws.cdi12.test.utils.Utils")
                        .addClass("com.ibm.ws.cdi12.test.utils.SimpleAbstract")
                        .addClass("com.ibm.ws.cdi12.test.utils.ForwardingList")
                        .add(new FileAsset(new File("test-applications/utilLib.jar/resources/META-INF/beans.xml")), "/META-INF/beans.xml");

        WebArchive aroundConstructApp = ShrinkWrap.create(WebArchive.class, APP_NAME+".war")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.AroundConstructLogger")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.StatelessAroundConstructLogger")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.Ejb")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.Bean")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.SuperConstructInterceptor")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.InterceptorTwoBinding")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.DirectlyIntercepted")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.InterceptorOne")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.SubConstructInterceptor")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.DirectBindingConstructInterceptor")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.NonCdiInterceptor")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.ConstructInterceptor")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.InterceptorOneBinding")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.interceptors.InterceptorTwo")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.EjbServlet")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.BeanServlet")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.AroundConstructTestServlet")
                        .addClass("com.ibm.ws.cdi12.test.aroundconstruct.StatelessEjb")
                        .add(new FileAsset(new File("test-applications/aroundConstructApp.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml")
                        .addAsLibrary(utilLib);

        WebArchive postConstructErrorMessageApp = ShrinkWrap.create(WebArchive.class, "postConstructErrorMessageApp.war")
                        .addClass("com.ibm.ws.cdi12.test.errormessage.ErrorMessageServlet")
                        .addClass("com.ibm.ws.cdi12.test.errormessage.interceptors.ErrorMessageInterceptor")
                        .addClass("com.ibm.ws.cdi12.test.errormessage.interceptors.ErrorMessageInterceptorBinding")
                        .addClass("com.ibm.ws.cdi12.test.errormessage.ErrorMessageTestEjb")
                        .add(new FileAsset(new File("test-applications/postConstructErrorMessageApp.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml")
                        .addAsLibrary(utilLib);

        ShrinkHelper.exportDropinAppToServer(serverRef, aroundConstructApp);
        ShrinkHelper.exportDropinAppToServer(serverRef, postConstructErrorMessageApp);
        serverRef.startServer();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (serverRef != null) {
            serverRef.stopServer();
        }
    }

}
