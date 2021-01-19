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

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.annotation.TestServlets;
import componenttest.topology.impl.LibertyServer;

public class AroundConstructBeanTest extends AroundConstructTestBase {

    @Server("cdi12EJB32Server")
    @TestServlets({
                    @TestServlet(servlet = com.ibm.ws.cdi12.test.aroundconstruct.BeanServlet.class, contextRoot = APP_NAME) 
    })
    public static LibertyServer server;

    @BeforeClass
    public static void setUp() throws Exception {
        serverRef = server;
        AroundConstructTestBase.setUp();
    }

}
