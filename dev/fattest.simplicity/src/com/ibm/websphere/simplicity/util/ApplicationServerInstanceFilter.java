/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.util;

import com.ibm.websphere.simplicity.ApplicationServer;
import com.ibm.websphere.simplicity.Server;
import com.ibm.websphere.simplicity.ServerType;

/**
 * This filter can be used to filter Servers based on {@link ApplicationServer}.
 */
public class ApplicationServerInstanceFilter implements Filter<Server> {

    /**
     * This method returns true if a {@link Server} is not an instance of
     * {@link ApplicationServer}. This method can be used to filter out
     * non-ApplicationServer instances
     * 
     * @return true if the Server does not have type
     *         {@link ServerType#APPLICATION_SERVER}
     */
    @Override
    public boolean filterOut(Server object) {
        return !(object instanceof ApplicationServer);
    }

}
