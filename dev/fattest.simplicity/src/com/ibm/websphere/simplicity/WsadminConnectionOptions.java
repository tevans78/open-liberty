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

package com.ibm.websphere.simplicity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ibm.websphere.simplicity.log.Log;

/**
 * These are options specific to a WebSphere wsadmin connection. For details on these options, run
 * the WAS wsadmin script with the -help parameter.<br>
 * Ex: wadmin.bat -help<br>
 * <br>
 * The option names are named the same here as they are used with the wsadmin executable. Note that
 * the -c and -f wsadmin options are not supported. These can be simulated by opening a
 * {@link Wsadmin} session, executing the desired command or script, and then closing the session.
 * <br>
 * Using this class to specify the connection options will result in the wsadmin process being
 * opened and run on a JVM on the machine of the server that is being connected to. If the server is
 * not local, a remote process will be launched.
 */
public class WsadminConnectionOptions extends ConnectionInfo {

    public static final Class<?> c = WsadminConnectionOptions.class;

    protected String ipchost;
    protected List<File> p;
    protected List<File> profile;
    protected List<String> javaoptions;
    protected String lang;
    protected String wsadmin_classpath;
    protected String profileName;
    protected String jobid;
    protected String tracefile;
    protected Boolean appendtrace = false;
    protected List<String> scriptParameters;
    protected ConnectionInfo machineConnectionInfo;
    protected ApplicationServer wsadminServer;
    protected String workingDirectory;

    /**
     * Constructor to make a wsadmin connection to the manager of the specified {@link Cell}. A
     * connType will not be specified when making the wsadmin connection resulting in the default
     * being used.
     *
     * @param cell The cell to administer. A wsadmin connection will be made to the cell manager
     *                 resolved using {@link Cell#getManager()}
     * @throws Exception
     */
    public WsadminConnectionOptions(Cell cell) throws Exception {
        super(cell.getManager().getNode().getHostname(), cell.getManager().getConnInfo().getUser(), cell.getManager().getConnInfo().getPassword());
        this.profileDir = cell.getManager().getNode().getProfileDir();
        this.machineConnectionInfo = cell.getManager().getNode().getMachine().getConnInfo();
        this.wsadminServer = cell.getManager();
    }

    /**
     * Constructor to make a wsadmin connection to the manager of the specified {@link Cell} using a
     * specified connector type.
     *
     * @param cell     The cell to administer. A wsadmin connection will be made to the cell manager
     *                     resolved using {@link Cell#getManager()}
     * @param connType The type of connection to make
     * @throws Exception
     */
    public WsadminConnectionOptions(Cell cell, ConnectorType connType) throws Exception {
        super(connType, cell.getManager().getNode().getHostname(), getPortNumber(cell.getManager(),
                                                                                 connType), cell.getManager().getConnInfo().getUser(), cell.getManager().getConnInfo().getPassword());
        this.profileDir = cell.getManager().getNode().getProfileDir();
        this.machineConnectionInfo = cell.getManager().getNode().getMachine().getConnInfo();
        this.wsadminServer = cell.getManager();
    }

    /**
     * Constructor to make a wsadmin connection to a specified {@link ApplicationServer}. A connType will not
     * be specified when making the wsadmin connection resulting in the default being used.
     *
     * @param server The server to administer
     * @throws Exception
     */
    public WsadminConnectionOptions(ApplicationServer server) throws Exception {
        super(server.getNode().getHostname(), server.getConnInfo().getUser(), server.getConnInfo().getPassword());
        this.profileDir = server.getNode().getProfileDir();
        this.machineConnectionInfo = server.getNode().getMachine().getConnInfo();
        this.wsadminServer = server;
    }

    /**
     * Constructor to make a wsadmin connection to a specified {@link ApplicationServer} using a specified
     * connector type.
     *
     * @param server   The server to administer
     * @param connType The type of connection to make
     * @throws Exception
     */
    public WsadminConnectionOptions(ApplicationServer server, ConnectorType connType) throws Exception {
        super(connType, server.getNode().getHostname(), getPortNumber(server, connType), server.getConnInfo().getUser(), server.getConnInfo().getPassword());
        this.profileDir = server.getNode().getProfileDir();
        this.machineConnectionInfo = server.getNode().getMachine().getConnInfo();
        this.wsadminServer = server;
    }

    /**
     * Constructor to explicity specify the information needed to make a remote wsadmin connection.
     *
     * @param connType              The type of connection to make
     * @param host                  The host of the server to connect to
     * @param port                  The port to connect to
     * @param user                  The WAS administrative user id to use for the connection
     * @param password              The WAS administrative password to use for the connection
     * @param profileDir            The directory of the profile that contains the wsadmin executable to use
     * @param machineConnectionInfo The {@link ConnectionInfo} for the remote machine
     * @throws Exception
     */
    public WsadminConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password, String profileDir,
                                    ConnectionInfo machineConnectionInfo) throws Exception {
        super(connType, host, port, user, password, profileDir);
        this.machineConnectionInfo = machineConnectionInfo;
    }

    /**
     * Basic constructor to init parent attributes
     *
     * @param connType The {@link ConnectorType} to use in the connection
     * @param host     The host to connect to
     * @param port     The port to connect to
     * @param user     The username to use in the connection
     * @param password The password to use in the connection
     */
    protected WsadminConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password) {
        super(connType, host, port, user, password);
    }

    public Boolean getAppendtrace() {
        return appendtrace;
    }

    public void setAppendtrace(Boolean appendtrace) {
        this.appendtrace = appendtrace;
    }

    public List<String> getJavaoptions() {
        return javaoptions;
    }

    public void setJavaoptions(List<String> javaoptions) {
        this.javaoptions = javaoptions;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<File> getP() {
        return p;
    }

    public void setP(List<File> p) {
        this.p = p;
    }

    public List<File> getProfile() {
        return profile;
    }

    public void setProfile(List<File> profile) {
        this.profile = profile;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public List<String> getScriptParameters() {
        return scriptParameters;
    }

    public void setScriptParameters(List<String> scriptParameters) {
        this.scriptParameters = scriptParameters;
    }

    public String getTracefile() {
        return tracefile;
    }

    public void setTracefile(String tracefile) {
        this.tracefile = tracefile;
    }

    public String getWsadmin_classpath() {
        return wsadmin_classpath;
    }

    public void setWsadmin_classpath(String wsadmin_classpath) {
        this.wsadmin_classpath = wsadmin_classpath;
    }

    public ConnectionInfo getMachineConnectionInfo() {
        return machineConnectionInfo;
    }

    public String getIpchost() {
        return ipchost;
    }

    public void setIpchost(String ipchost) {
        this.ipchost = ipchost;
    }

    void setMachineConnectionInfo(ConnectionInfo machineConnectionInfo) {
        this.machineConnectionInfo = machineConnectionInfo;
    }

    public ApplicationServer getWsadminServer() {
        return this.wsadminServer;
    }

    /**
     * Set the working directory for the wsadmin process. The directory correpsonds to a location on
     * the machine where the wsadmin process is launched from.
     *
     * @param workingDirectory The working directory for the wsadmin process
     */
    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    /**
     * Get the working directory for the wsadmin process. The directory correpsonds to a location on
     * the machine where the wsadmin process is launched from.
     *
     * @return The working directory for the wsadmin process
     */
    public String getWorkingDirectory() {
        return this.workingDirectory;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        final String method = "clone";
        Log.entering(c, method);
        WsadminConnectionOptions connInfo = (WsadminConnectionOptions) super.clone();
        if (this.p != null) {
            List<File> ptemp = new ArrayList<File>();
            for (File f : p) {
                ptemp.add(new File(f.getAbsolutePath()));
            }
            connInfo.setP(ptemp);
        }
        if (this.profile != null) {
            List<File> profileTemp = new ArrayList<File>();
            for (File f : profile) {
                profileTemp.add(new File(f.getAbsolutePath()));
            }
            connInfo.setProfile(profileTemp);
        }
        if (this.javaoptions != null) {
            connInfo.setJavaoptions(new ArrayList<String>(this.javaoptions));
        }
        if (this.tracefile != null) {
            connInfo.setTracefile(this.tracefile);
        }
        if (this.appendtrace != null) {
            connInfo.setAppendtrace(this.appendtrace.booleanValue());
        }
        if (this.scriptParameters != null) {
            connInfo.setScriptParameters(new ArrayList<String>(scriptParameters));
        }
        if (this.machineConnectionInfo != null) {
            connInfo.setMachineConnectionInfo((ConnectionInfo) machineConnectionInfo.clone());
        }
        if (this.workingDirectory != null) {
            connInfo.setWorkingDirectory(this.workingDirectory);
        }
        Log.exiting(c, method, connInfo);
        return connInfo;
    }

    /**
     * Custom clone method to clone all values except those specified in the method headar
     *
     * @param connType The connection type to use
     * @param port     The port to connect to
     * @param user     The user name to use when connecting
     * @param password The password to use when connecting
     * @return A clone of this WsadminConnectionInfo
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone(ConnectorType connType, int port, String user, String password) throws CloneNotSupportedException {
        WsadminConnectionOptions nci = (WsadminConnectionOptions) this.clone();
        if (connType != null)
            nci.setConnType(connType);
        if (port != 0)
            nci.setPort(port);
        if (user != null)
            nci.setUser(user);
        if (password != null)
            nci.setPassword(password);
        return nci;
    }

    /**
     * Two WsadminConnectionOptions are equal if all their member data is equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof WsadminConnectionOptions)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        WsadminConnectionOptions other = (WsadminConnectionOptions) o;
        if (((this.profileDir == null) && (other.profileDir != null)) || ((this.profileDir != null) && (!this.profileDir.equals(other.profileDir)))
            || ((this.ipchost == null) && (other.ipchost != null)) || ((this.ipchost != null) && (!this.ipchost.equals(other.ipchost)))
            || ((this.appendtrace == null) && (other.appendtrace != null)) || ((this.appendtrace != null) && (!this.appendtrace.equals(other.appendtrace)))
            || ((this.javaoptions == null) && (other.javaoptions != null)) || ((this.javaoptions != null) && (!this.javaoptions.equals(other.javaoptions)))
            || ((this.jobid == null) && (other.jobid != null)) || ((this.jobid != null) && (!this.jobid.equals(other.jobid)))
            || ((this.lang == null) && (other.lang != null)) || ((this.lang != null) && (!this.lang.equals(other.lang)))
            || ((this.p == null) && (other.p != null)) || ((this.p != null) && (!this.p.equals(other.p)))
            || ((this.profile == null) && (other.profile != null)) || ((this.profile != null) && (!this.profile.equals(other.profile)))
            || ((this.profileName == null) && (other.profileName != null)) || ((this.profileName != null) && (!this.profileName.equals(other.profileName)))
            || ((this.scriptParameters == null) && (other.scriptParameters != null)) || ((this.scriptParameters != null) && (!this.scriptParameters.equals(other.scriptParameters)))
            || ((this.tracefile == null) && (other.tracefile != null)) || ((this.tracefile != null) && (!this.tracefile.equals(other.tracefile)))
            || ((this.wsadmin_classpath == null) && (other.wsadmin_classpath != null))
            || ((this.wsadmin_classpath != null) && (!this.wsadmin_classpath.equals(other.wsadmin_classpath)))
            || ((this.machineConnectionInfo == null) && (other.machineConnectionInfo != null))
            || ((this.machineConnectionInfo != null) && (!this.machineConnectionInfo.equals(other.machineConnectionInfo)))) {
            return false;
        }

        return true;
    }

    protected static Integer getPortNumber(ApplicationServer server, ConnectorType connType) throws Exception {
        if (connType != null && connType != ConnectorType.NONE) {
            return server.getPortNumber(connType);
        }
        return null;
    }
}
