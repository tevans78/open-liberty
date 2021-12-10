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

package com.ibm.websphere.simplicity.provider.util;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Utils {
    
    /**
     * Get the stack of the Throwable Object in String format
     * so that it can be logged.
     * 
     * @param e The Throwable to get the stack for
     * @return A String representation of the stack that can be logged
     */
    public static String getDebugStack(Throwable e) {
        StringWriter sw = new StringWriter();
        BufferedWriter bw = new BufferedWriter(sw);
        PrintWriter pw = new PrintWriter(bw);
        e.printStackTrace(pw);
        pw.close();
        String text = sw.getBuffer().toString();
        text = text.replaceAll("at ", "DEBUG_FRAME = ");
        return text;
    }

}
