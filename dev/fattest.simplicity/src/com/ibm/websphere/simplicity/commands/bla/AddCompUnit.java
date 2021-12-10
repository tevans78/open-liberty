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

package com.ibm.websphere.simplicity.commands.bla;

import java.util.List;
import java.util.Properties;

import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Add a composition unit, based on an asset or another business-level application, to a business-level application.
 * 'blaID': ID for the business-level application in any of the following forms: &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or
 * WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;. The edition does not need to be specified unless there is more than one edition.
 * 'cuSourceID': The composition unit source ID is the ID of the object which is being added to the business-level application. The ID can be an asset ID or the ID of another
 * business-level application.
 * 'deplUnits': Optional list of deployable units for this composition unit. Applies only if the source ID is an asset ID. By default, all deployable units for the asset are
 * selected.
 * 'cuConfigStrategyFile': Specify a file name which contains custom strategy data.
 * 'defaultBindingOptions': Specify default binding options to use to configure a Java EE asset as a composition unit.
 * The required parameters are found in the constructor.
 */
public class AddCompUnit extends Command {

    private String blaID;
    private String cuSourceID;
    private String deplUnits;
    //private com.ibm.websphere.management.cmdframework.UploadFile cuConfigStrategyFile;
    private String defaultBindingOptions;

    public AddCompUnit(String blaID, String cuSourceID) {
        super("addCompUnit");
        this.blaID = blaID;
        this.cuSourceID = cuSourceID;
    }

    /**
     * ID for the business-level application in any of the following forms: &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or
     * WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;. The edition does not need to be specified unless there is more than one edition.
     */
    public String getBlaID() {
        return this.blaID;
    }

    /**
     * ID for the business-level application in any of the following forms: &lt;bla name&gt;; blaname=&lt;bla name&gt;; WebSphere:blaname=&lt;bla name&gt;; or
     * WebSphere:blaname=&lt;bla name&gt;,blaedition=&lt;bla edition&gt;. The edition does not need to be specified unless there is more than one edition.
     */
    public void setBlaID(String value) {
        this.blaID = value;
    }

    /**
     * The composition unit source ID is the ID of the object which is being added to the business-level application. The ID can be an asset ID or the ID of another business-level
     * application.
     */
    public String getCuSourceID() {
        return this.cuSourceID;
    }

    /**
     * The composition unit source ID is the ID of the object which is being added to the business-level application. The ID can be an asset ID or the ID of another business-level
     * application.
     */
    public void setCuSourceID(String value) {
        this.cuSourceID = value;
    }

    /**
     * Optional list of deployable units for this composition unit. Applies only if the source ID is an asset ID. By default, all deployable units for the asset are selected.
     */
    public String getDeplUnits() {
        return this.deplUnits;
    }

    /**
     * Optional list of deployable units for this composition unit. Applies only if the source ID is an asset ID. By default, all deployable units for the asset are selected.
     */
    public void setDeplUnits(String value) {
        this.deplUnits = value;
    }

//	/**
//	 * Specify a file name which contains custom strategy data.
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getCuConfigStrategyFile() {
//		return this.cuConfigStrategyFile;
//	}
//
//	/**
//	 * Specify a file name which contains custom strategy data.
//	 */
//	public void setCuConfigStrategyFile(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.cuConfigStrategyFile = value;
//	}

    /**
     * Specify default binding options to use to configure a Java EE asset as a composition unit.
     */
    public String getDefaultBindingOptions() {
        return this.defaultBindingOptions;
    }

    /**
     * Specify default binding options to use to configure a Java EE asset as a composition unit.
     */
    public void setDefaultBindingOptions(String value) {
        this.defaultBindingOptions = value;
    }

    @Override
    public Properties __getParameters() {
        Properties ret = new Properties();
        ret.put("blaID", this.blaID);
        ret.put("cuSourceID", this.cuSourceID);
        if (this.deplUnits != null) {
            ret.put("deplUnits", this.deplUnits);
        }
//		if (this.cuConfigStrategyFile != null) {
//			ret.put("cuConfigStrategyFile", this.cuConfigStrategyFile);
//		}
        if (this.defaultBindingOptions != null) {
            ret.put("defaultBindingOptions", this.defaultBindingOptions);
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
