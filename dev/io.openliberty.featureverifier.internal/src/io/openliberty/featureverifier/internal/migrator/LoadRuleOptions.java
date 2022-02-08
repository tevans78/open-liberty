/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.featureverifier.internal.migrator;

/**
 *
 */
public class LoadRuleOptions {

    private final boolean onlyForLoadRules;
    private final boolean allowUnusedForLoadRules;

    LoadRuleOptions(String only, String allow) {
        onlyForLoadRules = Boolean.valueOf(only);
        allowUnusedForLoadRules = Boolean.valueOf(allow);
    }

    @Override
    public String toString() {
        return " onlyForLoadRules=\"" + onlyForLoadRules + "\" allowUnusedForLoadRules=\"" + allowUnusedForLoadRules + "\"";
    }
}
