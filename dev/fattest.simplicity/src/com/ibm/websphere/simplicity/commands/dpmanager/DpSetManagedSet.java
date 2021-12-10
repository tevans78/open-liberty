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
 * Use the dpSetManagedSet command to modify a DataPower appliance manager managed set.
 * 'managedSetId': Specifies the ID of the managed set of interest in the DataPower appliance manager.
 * 'primaryApplianceId': Specifies the ID of the appliance to set as the primary appliance for the managed set.
 * 'desiredFirmwareVersionId': Specifies the ID of the firmware version to synchronize to each appliance in the managed set.
 * The required parameters are found in the constructor.
 */
public class DpSetManagedSet extends Command {

    private String managedSetId;
    private String primaryApplianceId;
    private String desiredFirmwareVersionId;

    public DpSetManagedSet(String managedSetId) {
        super("dpSetManagedSet");
        this.managedSetId = managedSetId;
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
     * Specifies the ID of the appliance to set as the primary appliance for the managed set.
     */
    public String getPrimaryApplianceId() {
        return this.primaryApplianceId;
    }

    /**
     * Specifies the ID of the appliance to set as the primary appliance for the managed set.
     */
    public void setPrimaryApplianceId(String value) {
        this.primaryApplianceId = value;
    }

    /**
     * Specifies the ID of the firmware version to synchronize to each appliance in the managed set.
     */
    public String getDesiredFirmwareVersionId() {
        return this.desiredFirmwareVersionId;
    }

    /**
     * Specifies the ID of the firmware version to synchronize to each appliance in the managed set.
     */
    public void setDesiredFirmwareVersionId(String value) {
        this.desiredFirmwareVersionId = value;
    }

    @Override
    public Properties __getParameters() {
        Properties ret = new Properties();
        ret.put("managedSetId", this.managedSetId);
        if (this.primaryApplianceId != null) {
            ret.put("primaryApplianceId", this.primaryApplianceId);
        }
        if (this.desiredFirmwareVersionId != null) {
            ret.put("desiredFirmwareVersionId", this.desiredFirmwareVersionId);
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
