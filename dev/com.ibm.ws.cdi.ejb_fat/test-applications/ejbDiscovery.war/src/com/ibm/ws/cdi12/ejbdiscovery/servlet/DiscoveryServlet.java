/*******************************************************************************
 * Copyright (c) 2016, 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.cdi12.ejbdiscovery.servlet;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Type;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import org.junit.Test;

import com.ibm.ws.cdi12.ejbdiscovery.extension.DiscoveryExtension;

import componenttest.app.FATServlet;

@SuppressWarnings("serial")
@WebServlet("/")
public class DiscoveryServlet extends FATServlet {

    @Inject
    private DiscoveryExtension extension;

    @SuppressWarnings("unchecked")
    @Test
    public void testAnnotatedTypesDiscovered() throws Exception {
        Set<Class<?>> types = extension.getObservedTypes();
        assertThat(types, contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessBean.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testDeploymentDescriptorTypesDiscovered() throws Exception {
        Set<Class<?>> types = extension.getObservedTypes();
        assertThat(types, contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonDdBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulDdBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessDdBean.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAnnotatedBeansDiscovered() throws Exception {
        Set<Class<?>> beans = extension.getObservedBeans();
        assertThat(beans, contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessBean.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testDeploymentDescriptorBeansDiscovered() throws Exception {
        Set<Class<?>> beans = extension.getObservedBeans();
        assertThat(beans, contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonDdBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulDdBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessDdBean.class));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testNoInterfaceTypesDiscovered() throws Exception {
        Set<Class<?>> beans = extension.getObservedBeans();
        assertThat(beans, contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.SingletonDdBean.class,
                                   com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatefulDdBean.class));
    }

    @Test
    public void testInterfaceTypesDiscovered() throws Exception {
        Set<Type> beanTypes = extension.getObservedBeanTypes();
        // The two stateless beans have a local interface defined
        assertThat(beanTypes, contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.interfaces.StatelessLocal.class,
                                       com.ibm.ws.cdi12.ejbdiscovery.ejbs.interfaces.StatelessDdLocal.class));

        // The actual bean type should not be visible
        assertThat(beanTypes, not(contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessBean.class)));
        assertThat(beanTypes, not(contains(com.ibm.ws.cdi12.ejbdiscovery.ejbs.StatelessDdBean.class)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testModeNoneNotDiscovered() throws Exception {
        Set<Class<?>> beans = extension.getObservedBeans();
        // There is a stateless bean that should not be discovered because the .jar has discovery-mode=none
        assertThat(beans, not(contains(com.ibm.ws.cdi12.ejbdiscovery.none.StatelessBean.class)));
    }

}
