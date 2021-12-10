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
 * Use the dpManageAppliance command to add the appliance to a managed set and to start managing the appliance.
 * 'managedSetId': Specifies the ID of the managed set of interest in the DataPower appliance manager.
 * 'applianceId': Specifies the ID of the appliance of interest in the DataPower appliance manager.
 * 'asPrimary': Specifies whether to set the appliance as the primary appliance of the managed set. The first appliance added to the managed set is set as the primary appliance,
 * even if this parameter is not specified.
 * The required parameters are found in the constructor.
 */
public class DpManageAppliance extends Command {

    private String managedSetId;
    private String applianceId;
    private String asPrimary;

    public DpManageAppliance(String managedSetId, String applianceId) {
        super("dpManageAppliance");
        this.managedSetId = managedSetId;
        this.applianceId = applianceId;
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
     * Specifies the ID of the appliance of interest in the DataPower appliance manager.
     */
    public String getApplianceId() {
        return this.applianceId;
    }

    /**
     * Specifies the ID of the appliance of interest in the DataPower appliance manager.
     */
    public void setApplianceId(String value) {
        this.applianceId = value;
    }

    /**
     * Specifies whether to set the appliance as the primary appliance of the managed set. The first appliance added to the managed set is set as the primary appliance, even if
     * this
     * parameter is not specified.
     */
    public String getAsPrimary() {
        return this.asPrimary;
    }

    /**
     * Specifies whether to set the appliance as the primary appliance of the managed set. The first appliance added to the managed set is set as the primary appliance, even if
     * this
     * parameter is not specified.
     */
    public void setAsPrimary(String value) {
        this.asPrimary = value;
    }

    @Override
    public Properties __getParameters() {
        Properties ret = new Properties();
        ret.put("managedSetId", this.managedSetId);
        ret.put("applianceId", this.applianceId);
        if (this.asPrimary != null) {
            ret.put("asPrimary", this.asPrimary);
        }
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
