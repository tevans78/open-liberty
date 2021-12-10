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
 * This command configures embedded Tivoli Access Manager on the WebSphere Application Server node or nodes specified.
 * 'nodeName': Specifies the target WebSphere Application Server node or nodes. Specify all nodes by entering '*'.
 * 'policySvr': Specifies the host name and port of the policy server as an entry of the format 'policy-server-host-name:policy-server-port'.
 * 'authSvrs': Specifies the hostname, port and priority of one or more authorization servers as comma-separated entries of the format
 * 'auth-server-host-name:policy-server-port:priority'.
 * 'wasAdminDN': Specifies the WebSphere Application Server administrator's distinguished name.
 * 'dnSuffix': Specifies the common distinguished name suffix for all users and groups.
 * 'adminUid': Specifies the Tivoli Access Manager administrator's user name.
 * 'adminPasswd': Specifies the Tivoli Access Manager administrator's user password.
 * 'secDomain': Specifies the Tivoli Access Manager security domain where policy is stored.
 * 'portSet': Specifies the TCP/IP ports available as listening ports for embedded Tivoli Access Manager. The ports are entered as a list of comma-separated entries. A range of
 * ports may be specified by separating the range values by a colon. An example entry is, 7999,9000:9999.
 * 'defer': Specifies whether to defer the execution of this command at the connected WebSphere Application Server instance until next restart.
 * The required parameters are found in the constructor.
 */
public class ConfigureTAM extends Command {

    private String nodeName = "*";
    private String policySvr;
    private String authSvrs;
    private String wasAdminDN;
    private String dnSuffix;
    private String adminUid;
    private String adminPasswd;
    private String secDomain = "Default";
    private String portSet = "8900:8999";
    private String defer = "no";

    public ConfigureTAM(String policySvr, String authSvrs, String wasAdminDN, String dnSuffix, String adminPasswd) {
        super("configureTAM");
        this.policySvr = policySvr;
        this.authSvrs = authSvrs;
        this.wasAdminDN = wasAdminDN;
        this.dnSuffix = dnSuffix;
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
     * Specifies the WebSphere Application Server administrator's distinguished name.
     */
    public String getWasAdminDN() {
        return this.wasAdminDN;
    }

    /**
     * Specifies the WebSphere Application Server administrator's distinguished name.
     */
    public void setWasAdminDN(String value) {
        this.wasAdminDN = value;
    }

    /**
     * Specifies the common distinguished name suffix for all users and groups.
     */
    public String getDnSuffix() {
        return this.dnSuffix;
    }

    /**
     * Specifies the common distinguished name suffix for all users and groups.
     */
    public void setDnSuffix(String value) {
        this.dnSuffix = value;
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
     * Specifies the TCP/IP ports available as listening ports for embedded Tivoli Access Manager. The ports are entered as a list of comma-separated entries. A range of ports may
     * be specified by separating the range values by a colon. An example entry is, 7999,9000:9999.
     */
    public String getPortSet() {
        return this.portSet;
    }

    /**
     * Specifies the TCP/IP ports available as listening ports for embedded Tivoli Access Manager. The ports are entered as a list of comma-separated entries. A range of ports may
     * be specified by separating the range values by a colon. An example entry is, 7999,9000:9999.
     */
    public void setPortSet(String value) {
        this.portSet = value;
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
        if (this.nodeName != null) {
            ret.put("nodeName", this.nodeName);
        }
        ret.put("policySvr", this.policySvr);
        ret.put("authSvrs", this.authSvrs);
        ret.put("wasAdminDN", this.wasAdminDN);
        ret.put("dnSuffix", this.dnSuffix);
        if (this.adminUid != null) {
            ret.put("adminUid", this.adminUid);
        }
        ret.put("adminPasswd", this.adminPasswd);
        if (this.secDomain != null) {
            ret.put("secDomain", this.secDomain);
        }
        if (this.portSet != null) {
            ret.put("portSet", this.portSet);
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
