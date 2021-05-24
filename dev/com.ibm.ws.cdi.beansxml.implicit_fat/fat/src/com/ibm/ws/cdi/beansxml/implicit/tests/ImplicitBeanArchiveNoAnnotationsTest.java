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
package com.ibm.ws.cdi.beansxml.implicit.tests;

import static componenttest.rules.repeater.EERepeatTests.EEVersion.EE7_FULL;
import static componenttest.rules.repeater.EERepeatTests.EEVersion.EE9;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.ShrinkHelper.DeployOptions;
import com.ibm.ws.cdi.beansxml.implicit.apps.ejbFieldInjection.FieldInjectionServlet;
import com.ibm.ws.cdi.beansxml.implicit.apps.ejbXtorInjection.ConstructorInjectionServlet;
import com.ibm.ws.cdi.beansxml.implicit.apps.noannotations.ejbInJar.ImplicitBeanArchiveNoAnnotationsServlet;
import com.ibm.ws.cdi.beansxml.implicit.apps.noannotations.ejbInWar.EjbJarInWarServlet;
import com.ibm.ws.cdi.beansxml.implicit.apps.noannotations.ejbs.ApplicationScopedEjbBean;
import com.ibm.ws.cdi.beansxml.implicit.apps.noannotations.ejbs.DependentEjbBean;

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.annotation.TestServlets;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.rules.repeater.EERepeatTests;
import componenttest.rules.repeater.RepeatTests;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;

@RunWith(FATRunner.class)
public class ImplicitBeanArchiveNoAnnotationsTest extends FATServletClient {

    public static final String SERVER_NAME = "cdi12EjbDefInXmlServer";

    public static final String EJB_CONSTRUCTOR_INJECTION_NO_BEANS_XML_APP_NAME = "ejbConstructorInjectionNoBeansXML";
    public static final String EJB_FIELD_INJECTION_NO_BEANS_XML_APP_NAME = "ejbFieldInjectionNoBeansXML";
    public static final String EJB_ARCHIVE_WITH_NO_ANNO_APP_NAME = "ejbArchiveWithNoAnnotations";
    public static final String EJB_JAR_IN_WAR_NO_ANNO_APP_NAME = "ejbJarInWarNoAnnotations";

    //not bothering to repeat with EE8 ... the EE9 version is mostly a transformed version of the EE8 code
    @ClassRule
    public static RepeatTests r = EERepeatTests.with(SERVER_NAME, EE9, EE7_FULL);

    @Server(SERVER_NAME)
    @TestServlets({
                    @TestServlet(servlet = FieldInjectionServlet.class, contextRoot = EJB_FIELD_INJECTION_NO_BEANS_XML_APP_NAME), //LITE
                    @TestServlet(servlet = ConstructorInjectionServlet.class, contextRoot = EJB_CONSTRUCTOR_INJECTION_NO_BEANS_XML_APP_NAME), //LITE
                    @TestServlet(servlet = ImplicitBeanArchiveNoAnnotationsServlet.class, contextRoot = EJB_ARCHIVE_WITH_NO_ANNO_APP_NAME), //FULL
                    @TestServlet(servlet = EjbJarInWarServlet.class, contextRoot = EJB_JAR_IN_WAR_NO_ANNO_APP_NAME) }) //FULL
    public static LibertyServer server;

    @BeforeClass
    public static void buildShrinkWrap() throws Exception {

        WebArchive ejbFieldInjection = ShrinkWrap.create(WebArchive.class, EJB_FIELD_INJECTION_NO_BEANS_XML_APP_NAME + ".war")
                                                 .addPackage(FieldInjectionServlet.class.getPackage())
                                                 .addAsWebInfResource(FieldInjectionServlet.class.getPackage(), "ejb-jar.xml", "ejb-jar.xml");

        WebArchive ejbConstructorInjection = ShrinkWrap.create(WebArchive.class, EJB_CONSTRUCTOR_INJECTION_NO_BEANS_XML_APP_NAME + ".war")
                                                       .addPackage(ConstructorInjectionServlet.class.getPackage())
                                                       .addAsWebInfResource(ConstructorInjectionServlet.class.getPackage(), "ejb-jar.xml", "ejb-jar.xml");

        WebArchive ejbArchiveWithNoAnnotations1 = ShrinkWrap.create(WebArchive.class, EJB_ARCHIVE_WITH_NO_ANNO_APP_NAME + ".war")
                                                            .addClass(ImplicitBeanArchiveNoAnnotationsServlet.class);

        JavaArchive ejbArchiveWithNoAnnotations2 = ShrinkWrap.create(JavaArchive.class, EJB_ARCHIVE_WITH_NO_ANNO_APP_NAME + ".jar")
                                                             .addClass(ApplicationScopedEjbBean.class)
                                                             .addClass(DependentEjbBean.class)
                                                             .addAsManifestResource(ApplicationScopedEjbBean.class.getPackage(), "ejb-jar.xml", "ejb-jar.xml");

        EnterpriseArchive ejbArchiveWithNoAnnotations = ShrinkWrap.create(EnterpriseArchive.class, EJB_ARCHIVE_WITH_NO_ANNO_APP_NAME + ".ear")
                                                                  .setApplicationXML(ImplicitBeanArchiveNoAnnotationsServlet.class.getPackage(), "application.xml")
                                                                  .addAsModule(ejbArchiveWithNoAnnotations1)
                                                                  .addAsModule(ejbArchiveWithNoAnnotations2);

        //same as ejbArchiveWithNoAnnotations2 but no ejb-jar.xml in the jar ... it is in the war instead
        JavaArchive ejbJarInWarNoAnnotationsJar = ShrinkWrap.create(JavaArchive.class, EJB_JAR_IN_WAR_NO_ANNO_APP_NAME + ".jar")
                                                            .addClass(DependentEjbBean.class)
                                                            .addClass(ApplicationScopedEjbBean.class);

        WebArchive ejbJarInWarNoAnnotations = ShrinkWrap.create(WebArchive.class, EJB_JAR_IN_WAR_NO_ANNO_APP_NAME + ".war")
                                                        .addClass(EjbJarInWarServlet.class)
                                                        .addAsManifestResource(EjbJarInWarServlet.class.getPackage(), "ejb-jar.xml", "ejb-jar.xml")
                                                        .addAsLibrary(ejbJarInWarNoAnnotationsJar);

        EnterpriseArchive ejbJarInWarNoAnnotationsEar = ShrinkWrap.create(EnterpriseArchive.class, EJB_JAR_IN_WAR_NO_ANNO_APP_NAME + ".ear")
                                                                  .setApplicationXML(EjbJarInWarServlet.class.getPackage(), "application.xml")
                                                                  .addAsModule(ejbJarInWarNoAnnotations);

        ShrinkHelper.exportDropinAppToServer(server, ejbFieldInjection, DeployOptions.SERVER_ONLY);
        ShrinkHelper.exportDropinAppToServer(server, ejbConstructorInjection, DeployOptions.SERVER_ONLY);
        ShrinkHelper.exportDropinAppToServer(server, ejbArchiveWithNoAnnotations, DeployOptions.SERVER_ONLY);
        ShrinkHelper.exportDropinAppToServer(server, ejbJarInWarNoAnnotationsEar, DeployOptions.SERVER_ONLY);
        server.startServer();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stopServer();
    }
}
