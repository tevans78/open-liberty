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

import java.io.File;

import org.junit.BeforeClass;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;

import componenttest.annotation.Server;
import componenttest.annotation.SkipForRepeat;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.HttpUtils;

/**
 * This test requires the ejb-3.2 feature. I started with it merged into EjbTimerTest, but
 * that test depends on ejbLite-3.2, and/or there's something funny about the way it uses
 * SHARED_SERVER... either way, EjbTimerTest hard to add new tests to.
 */
// Skip this class for EE8 features (cdi-2.0) because Weld tightened up its EJB checks and we get the following error:
// WELD-000088: Observer method must be static or local business method:  [EnhancedAnnotatedMethodImpl] public com.ibm.ws.cdi12test.remoteEjb.ejb.TestObserver.observeRemote(@Observes EJBEvent)
@SkipForRepeat({SkipForRepeat.EE8_FEATURES, SkipForRepeat.EE9_FEATURES})
@RunWith(FATRunner.class)
public class EJB32Test {

    @Server("cdi12EJB32FullServer")
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception {
        WebArchive ebjMisc = ShrinkWrap.create(WebArchive.class, "ejbMisc.war")
                .addClass("com.ibm.ws.cdi12test.remoteEjb.web.AServlet")
                .addClass("com.ibm.ws.cdi12test.remoteEjb.ejb.TestObserver")
                .addClass("com.ibm.ws.cdi12test.remoteEjb.api.RemoteInterface")
                .addClass("com.ibm.ws.cdi12test.remoteEjb.api.EJBEvent")
                .add(new FileAsset(new File("test-applications/ejbMisc.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml");

        ShrinkHelper.exportDropinAppToServer(server, ebjMisc);
        server.startServer();
    }

    @Test
    public void testRemoteEJBsWorkWithCDI() throws Exception {
        HttpUtils.findStringInUrl(server, "/ejbMisc/AServlet", "observed=true");
    }
}
