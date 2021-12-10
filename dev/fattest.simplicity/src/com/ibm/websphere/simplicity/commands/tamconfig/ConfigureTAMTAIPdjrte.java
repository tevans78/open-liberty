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
 * This command performs the tasks necessary to fully configure the Tivoli Access Manager Runtime for Java. The specific tasks run are PDJrteCfg and SvrSslCfg.
 * 'policySvr': Specifies the host name and port of the policy server as an entry of the format 'policy-server-host-name:policy-server-port'.
 * 'authSvrs': Specifies the hostname, port and priority of one or more authorization servers as comma-separated entries of the format
 * 'auth-server-host-name:policy-server-port:priority'.
 * 'adminUid': Specifies the Tivoli Access Manager administrator's user name.
 * 'adminPasswd': Specifies the Tivoli Access Manager administrator's user password.
 * 'secDomain': Specifies the Tivoli Access Manager security domain where policy is stored.
 * 'defer': Specifies whether to defer the execution of this command at the connected WebSphere Application Server instance until next restart.
 * The required parameters are found in the constructor.
 */
public class ConfigureTAMTAIPdjrte extends Command {

    private String policySvr;
    private String authSvrs;
    private String adminUid;
    private String adminPasswd;
    private String secDomain = "Default";
    private String defer = "no";

    public ConfigureTAMTAIPdjrte(String policySvr, String authSvrs, String adminPasswd) {
        super("configureTAMTAIPdjrte");
        this.policySvr = policySvr;
        this.authSvrs = authSvrs;
        this.adminPasswd = adminPasswd;
    }

    /**
     * Specifies the host name and port of the policy server as an entry of the format 'policy-server-host-name:policy-server-port'.
     */
    public String getPolicySvr() {
        return this.policySvr;
    }

    /**
     * Specifies the host name and port of the policy server as an entry of the format 'policy-server-host-name:policy-server-port'.
     */
    public void setPolicySvr(String value) {
        this.policySvr = value;
    }

    /**
     * Specifies the hostname, port and priority of one or more authorization servers as comma-separated entries of the format 'auth-server-host-name:policy-server-port:priority'.
     */
    public String getAuthSvrs() {
        return this.authSvrs;
    }

    /**
     * Specifies the hostname, port and priority of one or more authorization servers as comma-separated entries of the format 'auth-server-host-name:policy-server-port:priority'.
     */
    public void setAuthSvrs(String value) {
        this.authSvrs = value;
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
     * Specifies the Tivoli Access Manager security domain where policy is stored.
     */
    public String getSecDomain() {
        return this.secDomain;
    }

    /**
     * Specifies the Tivoli Access Manager security domain where policy is stored.
     */
    public void setSecDomain(String value) {
        this.secDomain = value;
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
        ret.put("policySvr", this.policySvr);
        ret.put("authSvrs", this.authSvrs);
        if (this.adminUid != null) {
            ret.put("adminUid", this.adminUid);
        }
        ret.put("adminPasswd", this.adminPasswd);
        if (this.secDomain != null) {
            ret.put("secDomain", this.secDomain);
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
