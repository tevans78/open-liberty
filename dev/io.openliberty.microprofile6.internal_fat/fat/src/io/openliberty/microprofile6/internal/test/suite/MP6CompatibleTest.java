/*******************************************************************************
 * Copyright (c) 2020, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.microprofile6.internal.test.suite;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.topology.impl.LibertyServer;

@RunWith(FATRunner.class)
@Mode(TestMode.LITE)
public class MP6CompatibleTest extends MPCompatibilityTestUtils {

    private static final String MP6_SERVER_NAME = "MP6CompatibleServer";

    @Server(MP6_SERVER_NAME)
    public static LibertyServer mp6Server;

    @BeforeClass
    public static void setUp() throws Exception {
        setUp(mp6Server);
    }

    /**
     * Just microProfile-6.0 ... Should always pass, a test
     *
     * @throws Exception
     */
    @Test
    @Mode(TestMode.LITE)
    public void testMicroProfile60() throws Exception {
        try {
            mp6Server.setServerConfigurationFromFilePath("MP60.xml");
            mp6Server.startServer();
            runGetMethod(mp6Server, 200, "/helloworld/helloworld", MESSAGE);
        } finally {
            mp6Server.stopServer("CWMOT0010W"); //CWMOT0010W: OpenTracing cannot track JAX-RS requests because an OpentracingTracerFactory class was not provided or client libraries for tracing backend are not in the class path.
        }
    }
}
