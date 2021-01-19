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

import org.junit.BeforeClass;
import org.junit.Test;
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
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.HttpUtils;

@RunWith(FATRunner.class)
public class EjbConstructorInjectionTest {

    @Server("cdi12EjbConstructorInjectionServer")
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception {
        WebArchive ejbConstructorInjection = ShrinkWrap.create(WebArchive.class, "ejbConstructorInjection.war")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.Servlet")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.BeanTwo")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.BeanThree")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.MyQualifier")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.MyForthQualifier")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.MyThirdQualifier")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.Iface")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.BeanFourWhichIsEJB")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.MySecondQualifier")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.BeanOne")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.BeanEJB")
                        .addClass("com.ibm.ws.cdi.ejb.constructor.test.StaticState")
                        .add(new FileAsset(new File("test-applications/ejbConstructorInjection.war/resources/META-INF/permissions.xml")), "/META-INF/permissions.xml")
                        .add(new FileAsset(new File("test-applications/ejbConstructorInjection.war/resources/WEB-INF/web.xml")), "/WEB-INF/web.xml");

        ShrinkHelper.exportDropinAppToServer(server, ejbConstructorInjection);
        server.startServer();
    }

    @Test
    public void testTransientReferenceOnEjbConstructor() throws Exception {
        HttpUtils.findStringInUrl(server, "/ejbConstructorInjection/Servlet", new String[] { "destroy called",
                                                                               "First bean message: foo",
                                                                               "Second bean message: bar",
                                                                               "Third bean message: spam",
                                                                               "Forth bean message: eggs" });
    }

}
