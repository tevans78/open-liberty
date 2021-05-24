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
package com.ibm.ws.cdi.beansxml.implicit.tests;

import static componenttest.rules.repeater.EERepeatTests.EEVersion.EE7_FULL;
import static componenttest.rules.repeater.EERepeatTests.EEVersion.EE9;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.CDIArchiveHelper;
import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.ShrinkHelper.DeployOptions;
import com.ibm.websphere.simplicity.beansxml.BeansAsset.DiscoveryMode;

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.annotation.TestServlets;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.rules.repeater.EERepeatTests;
import componenttest.rules.repeater.RepeatTests;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;

/**
 * Test that library jars inside a war can be implicit bean archives.
 */
@Mode(TestMode.FULL)
@RunWith(FATRunner.class)
public class ImplicitWarLibJarsTest extends FATServletClient {

    private static final String APP_NAME_IMPLICIT_BEAN_DISCOVERY = "implicitBeanDiscovery";

    public static final String SERVER_NAME = "cdi12ImplicitServer";

    //not bothering to repeat with EE8 ... the EE9 version is mostly a transformed version of the EE8 code
    @ClassRule
    public static RepeatTests r = EERepeatTests.with(SERVER_NAME, EE9, EE7_FULL);

    @Server(SERVER_NAME)
    @TestServlets({
                    @TestServlet(servlet = com.ibm.ws.cdi.beansxml.implicit.apps.implicitJarInWar.ImplicitWarLibJarsServlet.class, contextRoot = APP_NAME_IMPLICIT_BEAN_DISCOVERY), //FULL
    })
    public static LibertyServer server;

    @BeforeClass
    public static void buildShrinkWrap() throws Exception {

        //annotated mode beans.xml, annotated bean
        JavaArchive implicitBeanAnnotatedMode = ShrinkWrap.create(JavaArchive.class, "implicitBeanAnnotatedMode.jar")
                                                          .addClass(com.ibm.ws.cdi.beansxml.implicit.apps.implicitJarInWar.AnnotatedModeBean.class);
        CDIArchiveHelper.addBeansXML(implicitBeanAnnotatedMode, DiscoveryMode.ANNOTATED);

        //no beans.xml, annotated bean
        JavaArchive implicitBeanNoBeansXml = ShrinkWrap.create(JavaArchive.class, "implicitBeanNoBeansXml.jar")
                                                       .addClass(com.ibm.ws.cdi.beansxml.implicit.apps.implicitJarInWar.NoBeansXmlBean.class);

        //all mode beans.xml, annotated bean
        JavaArchive implicitBeanExplicitArchive = ShrinkWrap.create(JavaArchive.class, "implicitBeanExplicitArchive.jar")
                                                            .addClass(com.ibm.ws.cdi.beansxml.implicit.apps.implicitJarInWar.InExplicitBeanArchive.class);
        CDIArchiveHelper.addBeansXML(implicitBeanExplicitArchive, DiscoveryMode.ALL);

        //empty beans.xml
        JavaArchive utilLib = ShrinkWrap.create(JavaArchive.class, "utilLib.jar")
                                        .addClass(com.ibm.ws.cdi.beansxml.implicit.utils.ChainableListImpl.class)
                                        .addClass(com.ibm.ws.cdi.beansxml.implicit.utils.ChainableList.class)
                                        .addClass(com.ibm.ws.cdi.beansxml.implicit.utils.SimpleAbstract.class)
                                        .addClass(com.ibm.ws.cdi.beansxml.implicit.utils.ForwardingList.class);
        CDIArchiveHelper.addEmptyBeansXML(utilLib);

        //all mode beans.xml
        WebArchive implicitBeanDiscovery = ShrinkWrap.create(WebArchive.class, APP_NAME_IMPLICIT_BEAN_DISCOVERY + ".war")
                                                     .addClass(com.ibm.ws.cdi.beansxml.implicit.apps.implicitJarInWar.ImplicitWarLibJarsServlet.class)
                                                     .addAsLibrary(implicitBeanAnnotatedMode)
                                                     .addAsLibrary(implicitBeanNoBeansXml)
                                                     .addAsLibrary(implicitBeanExplicitArchive)
                                                     .addAsLibrary(utilLib);
        CDIArchiveHelper.addBeansXML(implicitBeanDiscovery, DiscoveryMode.ALL);

        ShrinkHelper.exportDropinAppToServer(server, implicitBeanDiscovery, DeployOptions.SERVER_ONLY);
        server.startServer();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (server != null) {
            server.stopServer();
        }
    }

}
