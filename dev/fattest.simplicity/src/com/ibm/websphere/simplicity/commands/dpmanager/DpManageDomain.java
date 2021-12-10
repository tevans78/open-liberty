/*******************************************************************************
 * Copyright (c) 2011, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.commands.dpmanager;

import java.util.List;
import java.util.Properties;

import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Use the dpManageDomain command to add the domain to a managed set, and to start managing the domain.
 * 'managedSetId': Specifies the ID of the managed set of interest in the DataPower appliance manager.
 * 'domain': Specifies the name of the domain on the primary appliance to manage.
 * The required parameters are found in the constructor.
 */
public class DpManageDomain extends Command {

    private String managedSetId;
    private String domain;

    public DpManageDomain(String managedSetId, String domain) {
        super("dpManageDomain");
        this.managedSetId = managedSetId;
        this.domain = domain;
    }

    /**
     * Specifies the ID of the managed set of interest in the DataPower appliance manager.
     */
    public String getManagedSetId() {
        return this.managedSetId;
    }

    /**
     * Specifies the ID of the managed set of interest in the DataPower appliance manager.
     */
    public void setManagedSetId(String value) {
        this.managedSetId = value;
    }

    /**
     * Specifies the name of the domain on the primary appliance to manage.
     */
    public String getDomain() {
        return this.domain;
    }

    /**
     * Specifies the name of the domain on the primary appliance to manage.
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    @Override
    public Properties __getParameters() {
        Properties ret = new Properties();
        ret.put("managedSetId", this.managedSetId);
        ret.put("domain", this.domain);
        return ret;
    }

    @Override
    public Object __getTarget() {
        return null;
    }

    @Override
    public List<Command> __getSteps() {
        return null;
    }

    /**
     * Executes the command against the specified scope.
     */
    @Override
    public OperationResults<Object> run(Scope scope) throws Exception {
        return super.run(scope);
    }

}
