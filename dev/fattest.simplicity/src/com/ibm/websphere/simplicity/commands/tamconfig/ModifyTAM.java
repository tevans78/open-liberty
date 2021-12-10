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

package com.ibm.websphere.simplicity.commands.tamconfig;

import java.util.List;
import java.util.Properties;

import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * This command modifies the configuration for embedded Tivoli Access Manager on the WebSphere Application Server node or nodes specified.
 * 'nodeName': Specifies the target WebSphere Application Server node or nodes. Specify all nodes by entering '*'.
 * 'adminUid': Specifies the Tivoli Access Manager administrator's user name.
 * 'adminPasswd': Specifies the Tivoli Access Manager administrator's user password.
 * The required parameters are found in the constructor.
 */
public class ModifyTAM extends Command {

    private String nodeName = "*";
    private String adminUid;
    private String adminPasswd;

    public ModifyTAM(String adminPasswd) {
        super("modifyTAM");
        this.adminPasswd = adminPasswd;
    }

    /**
     * Specifies the target WebSphere Application Server node or nodes. Specify all nodes by entering '*'.
     */
    public String getNodeName() {
        return this.nodeName;
    }

    /**
     * Specifies the target WebSphere Application Server node or nodes. Specify all nodes by entering '*'.
     */
    public void setNodeName(String value) {
        this.nodeName = value;
    }

    /**
     * Specifies the Tivoli Access Manager administrator's user name.
     */
    public String getAdminUid() {
        return this.adminUid;
    }

    /**
     * Specifies the Tivoli Access Manager administrator's user name.
     */
    public void setAdminUid(String value) {
        this.adminUid = value;
    }

    /**
     * Specifies the Tivoli Access Manager administrator's user password.
     */
    public String getAdminPasswd() {
        return this.adminPasswd;
    }

    /**
     * Specifies the Tivoli Access Manager administrator's user password.
     */
    public void setAdminPasswd(String value) {
        this.adminPasswd = value;
    }

    @Override
    public Properties __getParameters() {
        Properties ret = new Properties();
        if (this.nodeName != null) {
            ret.put("nodeName", this.nodeName);
        }
        if (this.adminUid != null) {
            ret.put("adminUid", this.adminUid);
        }
        ret.put("adminPasswd", this.adminPasswd);
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
