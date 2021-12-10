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
 * This command performs the tasks necessary to unconfigure the Tivoli Access Manager Runtime for Java. The specific tasks run are PDJrteCfg and SvrSslCfg.
 * 'adminUid': Specifies the Tivoli Access Manager administrator's user name.
 * 'adminPasswd': Specifies the Tivoli Access Manager administrator's user password.
 * 'force': Specifies whether to ignore errors that might occur during embedded Tivoli Access Manager disablement. Specify this option when the configured Tivoli Access Manager
 * security domain no longer exists or is in a corrupted state.
 * 'defer': Specifies whether to defer the execution of this command at the connected WebSphere Application Server instance until next restart.
 * The required parameters are found in the constructor.
 */
public class UnconfigureTAMTAIPdjrte extends Command {

    private String adminUid;
    private String adminPasswd;
    private String force = "no";
    private String defer = "no";

    public UnconfigureTAMTAIPdjrte(String adminPasswd) {
        super("unconfigureTAMTAIPdjrte");
        this.adminPasswd = adminPasswd;
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

    /**
     * Specifies whether to ignore errors that might occur during embedded Tivoli Access Manager disablement. Specify this option when the configured Tivoli Access Manager security
     * domain no longer exists or is in a corrupted state.
     */
    public String getForce() {
        return this.force;
    }

    /**
     * Specifies whether to ignore errors that might occur during embedded Tivoli Access Manager disablement. Specify this option when the configured Tivoli Access Manager security
     * domain no longer exists or is in a corrupted state.
     */
    public void setForce(String value) {
        this.force = value;
    }

    /**
     * Specifies whether to defer the execution of this command at the connected WebSphere Application Server instance until next restart.
     */
    public String getDefer() {
        return this.defer;
    }

    /**
     * Specifies whether to defer the execution of this command at the connected WebSphere Application Server instance until next restart.
     */
    public void setDefer(String value) {
        this.defer = value;
    }

    @Override
    public Properties __getParameters() {
        Properties ret = new Properties();
        if (this.adminUid != null) {
            ret.put("adminUid", this.adminUid);
        }
        ret.put("adminPasswd", this.adminPasswd);
        if (this.force != null) {
            ret.put("force", this.force);
        }
        if (this.defer != null) {
            ret.put("defer", this.defer);
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
