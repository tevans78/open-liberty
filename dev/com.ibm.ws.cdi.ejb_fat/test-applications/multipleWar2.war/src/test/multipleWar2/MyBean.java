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
package test.multipleWar2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 */
@Named("myNotSameBean")
@ApplicationScoped
public class MyBean {
    public static final String NAME = "myWar2Bean";

    public String getName() {
        return NAME;
    }
}
