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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.stream.Collectors;

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

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.utils.HttpUtils;
import componenttest.topology.impl.LibertyServer;

/**
 * Test to ensure that we correctly discover and fire events for types and beans which are EJBs
 */
@RunWith(FATRunner.class)
public class EjbDiscoveryTest {

    @Server("cdi12EjbDiscoveryServer")
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception {
        WebArchive ejbDiscovery = ShrinkWrap.create(WebArchive.class, "ejbDiscovery.war")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.extension.DiscoveryExtension")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.servlet.DiscoveryServlet")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonDdBean")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessBean")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.interfaces.StatelessLocal")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.interfaces.StatelessDdLocal")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessDdBean")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulDdBean")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonBean")
                        .addClass("com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulBean")
                        .add(new FileAsset(new File("test-applications/ejbDiscovery.war/resources/WEB-INF/ejb-jar.xml")), "/WEB-INF/ejb-jar.xml")
                        .add(new FileAsset(new File("test-applications/ejbDiscovery.war/resources/WEB-INF/beans.xml")), "/WEB-INF/beans.xml")
                        .add(new FileAsset(new File("test-applications/ejbDiscovery.war/resources/META-INF/services/javax.enterprise.inject.spi.Extension")), "/META-INF/services/javax.enterprise.inject.spi.Extension");

        ShrinkHelper.exportDropinAppToServer(server, ejbDiscovery);
        server.startServer();
    }

    private String getObservations() throws Exception {
        return HttpUtils.getResponseBody(HttpUtils.getHttpConnection(server, "/ejbDiscovery")).lines().collect(Collectors.joining());
    }

    @Test
    public void testAnnotatedTypesDiscovered() throws Exception {
        String observations = getObservations();
        assertThat(observations, containsString("Observed type: com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonBean"));
        assertThat(observations, containsString("Observed type: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulBean"));
        assertThat(observations, containsString("Observed type: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessBean"));
    }

    @Test
    public void testDeploymentDescriptorTypesDiscovered() throws Exception {
        String observations = getObservations();
        assertThat(observations, containsString("Observed type: com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonDdBean"));
        assertThat(observations, containsString("Observed type: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulDdBean"));
        assertThat(observations, containsString("Observed type: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessDdBean"));
    }

    @Test
    public void testAnnotatedBeansDiscovered() throws Exception {
        String observations = getObservations();
        assertThat(observations, containsString("Observed bean: com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonBean"));
        assertThat(observations, containsString("Observed bean: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulBean"));
        assertThat(observations, containsString("Observed bean: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessBean"));
    }

    @Test
    public void testDeploymentDescriptorBeansDiscovered() throws Exception {
        String observations = getObservations();
        assertThat(observations, containsString("Observed bean: com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonDdBean"));
        assertThat(observations, containsString("Observed bean: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulDdBean"));
        assertThat(observations, containsString("Observed bean: com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessDdBean"));
    }

    @Test
    public void testNoInterfaceTypesDiscovered() throws Exception {
        String observations = getObservations();
        // The singleton and stateful beans have a no-interface view
        assertThat(observations, containsString("Observed bean type: class com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonBean"));
        assertThat(observations, containsString("Observed bean type: class com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulBean"));
        assertThat(observations, containsString("Observed bean type: class com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonDdBean"));
        assertThat(observations, containsString("Observed bean type: class com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulDdBean"));
    }

    @Test
    public void testInterfaceTypesDiscovered() throws Exception {
        String observations = getObservations();
        // The two stateless beans have a local interface defined
        assertThat(observations, containsString("Observed bean type: interface com.ibm.ws.cdi12.ejbdiscovery.ejbs.interfaces.StatelessLocal"));
        assertThat(observations, containsString("Observed bean type: interface com.ibm.ws.cdi12.ejbdiscovery.ejbs.interfaces.StatelessDdLocal"));

        // The actual bean type should not be visible
        assertThat(observations, not(containsString("Observed bean type: class com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessBean")));
        assertThat(observations, not(containsString("Observed bean type: class com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessDdBean")));
    }

    @Test
    public void testModeNoneNotDiscovered() throws Exception {
        String observations = getObservations();
        // There is a stateless bean that should not be discovered because the .war has discovery-mode=none
        assertThat(observations, not(containsString("Observed bean type: class com.ibm.ws.cdi12.ejbdiscovery.none.ejbs.StatelessBean")));
        assertThat(observations, not(containsString("Observed bean: com.ibm.ws.cdi12.ejbdiscovery.none.ejbs.StatelessBean")));
    }

}
