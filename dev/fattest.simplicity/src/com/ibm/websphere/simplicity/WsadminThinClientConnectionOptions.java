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

import com.ibm.websphere.simplicity.configuration.ConfigurationProvider;
import com.ibm.websphere.simplicity.log.Log;

/**
 * These are options specific to a local WebSphere wsadmin connection. For details on these options, run
 * the WAS wsadmin script with the -help parameter.<br>
 * Ex: wadmin.bat -help<br>
 * <br>
 * The option names are named the same here as they are used with the wsadmin executable. Note that
 * the -c and -f wsadmin options are not supported. These can be simulated by opening a
 * {@link Wsadmin} session, executing the desired command or script, and then closing the session.
 * <br>
 * Using this class to specify the connection options will result in the wsadmin process being
 * opened and run on a JVM on the local machine. Either the local wsadmin executable file must be
 * specified, or the bootstrapping property file property
 * {@link BootStrappingProperty#LOCAL_WSADMIN} must be specified. If the file does not exit, a thin
 * client wsadmin executable is created. The thin client runs using a smaller JVM footprint than the
 * typical wsadmin process.
 */
public class WsadminThinClientConnectionOptions extends WsadminConnectionOptions {

    private static final Class clazz = WsadminThinClientConnectionOptions.class;

    protected File localWsadmin;
    protected String wasInstallRoot;

    /**
     * Constructor to make a wsadmin connection to the manager of the specified {@link Cell}. A
     * connType will not be specified when making the wsadmin connection resulting in the default
     * being used.
     *
     * @param cell         The cell to administer. A wsadmin connection will be made to the cell manager
     *                         resolved using {@link Cell#getManager()}
     * @param localWsadmin The local wsadmin executable file to use. If this file does not exist, a
     *                         thin client wsadmin executable will be created.
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(Cell cell, File localWsadmin) throws Exception {
        super(cell);
        this.localWsadmin = localWsadmin;
        this.wasInstallRoot = cell.getManager().getNode().getWASInstall().getInstallRoot();
    }

    /**
     * Constructor to make a wsadmin connection to the manager of the specified {@link Cell}. A
     * connType will not be specified when making the wsadmin connection resulting in the default
     * being used. The local wsadmin executable path is obtained from the bootstrapping properties
     * file using the property {@link BootStrappingProperty#LOCAL_WSADMIN}. If the executable does
     * not exist, a thin client wsadmin executable will be created.
     *
     * @param cell The cell to administer. A wsadmin connection will be made to the cell manager
     *                 resolved using {@link Cell#getManager()}
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(Cell cell) throws Exception {
        super(cell);
        this.wasInstallRoot = cell.getManager().getNode().getWASInstall().getInstallRoot();
        this.localWsadmin = new File(getLocalWsadminFromBootstrapping());
        if (this.localWsadmin == null) {
            throw new Exception("The " + BootStrappingProperty.LOCAL_WSADMIN
                                + " property must be set in the boostrapping file to use the WsadminThinClientConnectionOptions(Cell) constructor.");
        }
    }

    /**
     * Constructor to make a wsadmin connection to the manager of the specified {@link Cell} using a
     * specified connector type.
     *
     * @param cell         The cell to administer. A wsadmin connection will be made to the cell manager
     *                         resolved using {@link Cell#getManager()}
     * @param connType     The type of connection to make
     * @param localWsadmin The local wsadmin executable file to use. If this file does not exist, a
     *                         thin client wsadmin executable will be created.
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(Cell cell, ConnectorType connType, File localWsadmin) throws Exception {
        super(cell, connType);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.localWsadmin = localWsadmin;
        this.wasInstallRoot = cell.getManager().getNode().getWASInstall().getInstallRoot();
    }

    /**
     * Constructor to make a wsadmin connection to the manager of the specified {@link Cell} using a
     * specified connector type. The local wsadmin executable path is obtained from the
     * bootstrapping properties file using the property {@link BootStrappingProperty#LOCAL_WSADMIN}.
     * If the executable does not exist, a thin client wsadmin executable will be created.
     *
     * @param cell     The cell to administer. A wsadmin connection will be made to the cell manager
     *                     resolved using {@link Cell#getManager()}
     * @param connType The type of connection to make
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(Cell cell, ConnectorType connType) throws Exception {
        super(cell, connType);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.wasInstallRoot = cell.getManager().getNode().getWASInstall().getInstallRoot();
        this.localWsadmin = new File(getLocalWsadminFromBootstrapping());
        if (this.localWsadmin == null) {
            throw new Exception("The " + BootStrappingProperty.LOCAL_WSADMIN
                                + " property must be set in the boostrapping file to use the WsadminThinClientConnectionOptions(Cell, ConnectorType) constructor.");
        }
    }

    /**
     * Constructor to make a wsadmin connection to a specified {@link ApplicationServer}. A connType will not
     * be specified when making the wsadmin connection resulting in the default being used.
     *
     * @param server       The server to administer
     * @param localWsadmin The local wsadmin executable file to use. If this file does not exist, a
     *                         thin client wsadmin executable will be created.
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ApplicationServer server, File localWsadmin) throws Exception {
        super(server);
        this.localWsadmin = localWsadmin;
        this.wasInstallRoot = server.getNode().getWASInstall().getInstallRoot();
    }

    /**
     * Constructor to make a wsadmin connection to a specified {@link ApplicationServer}. A connType will not
     * be specified when making the wsadmin connection resulting in the default being used. The
     * local wsadmin executable path is obtained from the bootstrapping properties file using the
     * property {@link BootStrappingProperty#LOCAL_WSADMIN}. If the executable does not exist, a
     * thin client wsadmin executable will be created.
     *
     * @param server The server to administer
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ApplicationServer server) throws Exception {
        super(server);
        this.wasInstallRoot = server.getNode().getWASInstall().getInstallRoot();
        this.localWsadmin = new File(getLocalWsadminFromBootstrapping());
        if (this.localWsadmin == null) {
            throw new Exception("The " + BootStrappingProperty.LOCAL_WSADMIN
                                + " property must be set in the boostrapping file to use the WsadminThinClientConnectionOptions(Server) constructor.");
        }
    }

    /**
     * Constructor to make a wsadmin connection to a specified {@link ApplicationServer} using a specified
     * connector type.
     *
     * @param server       The server to administer
     * @param connType     The type of connection to make
     * @param localWsadmin The local wsadmin executable file to use. If this file does not exist, a
     *                         thin client wsadmin executable will be created.
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ApplicationServer server, ConnectorType connType, File localWsadmin) throws Exception {
        super(server, connType);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.localWsadmin = localWsadmin;
        this.wasInstallRoot = server.getNode().getWASInstall().getInstallRoot();
    }

    /**
     * Constructor to make a wsadmin connection to a specified {@link ApplicationServer} using a specified
     * connector type. The local wsadmin executable path is obtained from the bootstrapping
     * properties file using the property {@link BootStrappingProperty#LOCAL_WSADMIN}. If the
     * executable does not exist, a thin client wsadmin executable will be created.
     *
     * @param server   The server to administer
     * @param connType The type of connection to make
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ApplicationServer server, ConnectorType connType) throws Exception {
        super(server, connType);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.wasInstallRoot = server.getNode().getWASInstall().getInstallRoot();
        this.localWsadmin = new File(getLocalWsadminFromBootstrapping());
        if (this.localWsadmin == null) {
            throw new Exception("The " + BootStrappingProperty.LOCAL_WSADMIN
                                + " property must be set in the boostrapping file to use the WsadminThinClientConnectionOptions(Server, ConnectorType) constructor.");
        }

    }

    /**
     * Constructor to explicity specify the information needed to make a local wsadmin connection.
     * If the executable does not exist, a thin client wsadmin executable will be created using the
     * specified profile directory and WAS installation root.
     *
     * @param connType              The type of connection to make
     * @param host                  The host of the server to connect to
     * @param port                  The port to connect to
     * @param user                  The WAS administrative user id to use for the connection
     * @param password              The WAS administrative password to use for the connection
     * @param localWsadmin          The local wsadmin executable file to use. If this file does not exist, a
     *                                  thin client wsadmin executable will be created using the specified profile
     *                                  directory and was installation root.
     * @param profileDir            The directory of the profile that contains the wsadmin executable to use
     * @param wasInstallRoot        The install root of the server being administered
     * @param machineConnectionInfo The connection information to connect to the machine that has
     *                                  the WAS install. This will be used, along with the profileDir and wasInstallRoot,
     *                                  to create the localWsadmin executable thinclient if the File passed in does not
     *                                  yet exist.
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password, File localWsadmin, String profileDir,
                                              String wasInstallRoot, ConnectionInfo machineConnectionInfo) throws Exception {
        super(connType, host, port, user, password, profileDir, machineConnectionInfo);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.localWsadmin = localWsadmin;
        this.wasInstallRoot = wasInstallRoot;
    }

    /**
     * Constructor to explicity specify the information needed to make a local wsadmin connection.
     * The local wsadmin executable path is obtained from the bootstrapping properties file using
     * the property {@link BootStrappingProperty#LOCAL_WSADMIN}. If the executable does not exist,
     * a thin client wsadmin executable will be created using the specified profile directory and
     * WAS installation root.
     *
     * @param connType              The type of connection to make
     * @param host                  The host of the server to connect to
     * @param port                  The port to connect to
     * @param user                  The WAS administrative user id to use for the connection
     * @param password              The WAS administrative password to use for the connection
     * @param profileDir            The directory of the profile that contains the wsadmin executable to use
     * @param wasInstallRoot        The install root of the server being administered
     * @param machineConnectionInfo The connection information to connect to the machine that has
     *                                  the WAS install. This will be used, along with the profileDir and wasInstallRoot,
     *                                  to create the localWsadmin executable thinclient if the File passed in does not
     *                                  yet exist.
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password, String profileDir, String wasInstallRoot,
                                              ConnectionInfo machineConnectionInfo) throws Exception {
        super(connType, host, port, user, password, profileDir, machineConnectionInfo);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.wasInstallRoot = wasInstallRoot;
        this.localWsadmin = new File(getLocalWsadminFromBootstrapping());
        if (this.localWsadmin == null) {
            throw new Exception("The " + BootStrappingProperty.LOCAL_WSADMIN
                                + " property must be set in the boostrapping file to use the WsadminThinClientConnectionOptions(ConnectorType, String, Integer, String, String, String, String) constructor.");
        }
    }

    /**
     * Constructor to explicity specify the information needed to make a local wsadmin connection.
     * The localWsadmin file specified MUST EXIST on the local machine when using this constructor.
     *
     * @param connType     The type of connection to make
     * @param host         The host of the server to connect to
     * @param port         The port to connect to
     * @param user         The WAS administrative user id to use for the connection
     * @param password     The WAS administrative password to use for the connection
     * @param localWsadmin The local wsadmin executable file to use. This file MUST EXIST on the
     *                         local machine
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password, File localWsadmin) throws Exception {
        super(connType, host, port, user, password);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.localWsadmin = localWsadmin;
        if (this.localWsadmin == null || !this.localWsadmin.exists()) {
            throw new Exception("The local wsadmin executable specified, " + this.localWsadmin + ", does not exist.");
        }
        this.machineConnectionInfo = Machine.getLocalMachine().getConnInfo();
    }

    /**
     * Constructor to explicity specify the information needed to make a local wsadmin connection.
     * The localWsadmin file specified MUST EXIST on the local machine when using this constructor.
     *
     * @param connType     The type of connection to make
     * @param host         The host of the server to connect to
     * @param port         The port to connect to
     * @param user         The WAS administrative user id to use for the connection
     * @param password     The WAS administrative password to use for the connection
     * @param profileDir   The directory of the profile that contains the wsadmin executable to use
     * @param localWsadmin The local wsadmin executable file to use. This file MUST EXIST on the
     *                         local machine
     * @throws Exception
     */
    protected WsadminThinClientConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password, String profileDir,
                                                 File localWsadmin) throws Exception {
        super(connType, host, port, user, password, profileDir, null);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.localWsadmin = localWsadmin;
        if (this.localWsadmin == null || !this.localWsadmin.exists()) {
            throw new Exception("The local wsadmin executable specified, " + this.localWsadmin + ", does not exist.");
        }
        this.machineConnectionInfo = Machine.getLocalMachine().getConnInfo();
    }

    /**
     * Constructor to explicity specify the information needed to make a local wsadmin connection.
     * The local wsadmin executable path is obtained from the bootstrapping properties file using
     * the property {@link BootStrappingProperty#LOCAL_WSADMIN}. The local wsadmin executable MUST
     * EXIST on the local machine when using this constructor.
     *
     * @param connType The type of connection to make
     * @param host     The host of the server to connect to
     * @param port     The port to connect to
     * @param user     The WAS administrative user id to use for the connection
     * @param password The WAS administrative password to use for the connection
     * @throws Exception
     */
    public WsadminThinClientConnectionOptions(ConnectorType connType, String host, Integer port, String user, String password) throws Exception {
        super(connType, host, port, user, password);
        if (connType == ConnectorType.NONE) {
            throw new IllegalArgumentException("ConnType NONE is not allowed when using the WsadminThinClientConnectionOptions.");
        }
        this.localWsadmin = new File(getLocalWsadminFromBootstrapping());
        this.machineConnectionInfo = Machine.getLocalMachine().getConnInfo();
        if (this.localWsadmin == null || !this.localWsadmin.exists()) {
            throw new Exception("The " + BootStrappingProperty.LOCAL_WSADMIN + " property must be set in the boostrapping file and the file must exist.");
        }
    }

    /**
     * Get the local wsadmin executable being used to make a wsadmin connection.
     *
     * @return The local wsadmin executable.
     */
    public File getLocalWsadmin() {
        return localWsadmin;
    }

    /**
     * Get the WAS installation root being used to create the wsadmin thin client executable.
     *
     * @return The WAS installation root
     */
    public String getWasInstallRoot() {
        return wasInstallRoot;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof WsadminThinClientConnectionOptions)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        WsadminThinClientConnectionOptions other = (WsadminThinClientConnectionOptions) o;
        if (((this.localWsadmin == null) && (other.localWsadmin != null)) || ((this.localWsadmin != null) && (!this.localWsadmin.equals(other.localWsadmin)))
            || ((this.wasInstallRoot == null) && (other.wasInstallRoot != null)) || ((this.wasInstallRoot != null) && (!this.wasInstallRoot.equals(other.wasInstallRoot)))) {
            return false;
        }

        return true;
    }

    /**
     * Read the local executable from the bootstrapping file using the
     * {@link BootStrappingProperty#LOCAL_WSADMIN} property.
     *
     * @return The local wsadmin executable path
     * @throws Exception
     */
    private String getLocalWsadminFromBootstrapping() throws Exception {
        final String method = "getLocalWsadminFromBootstrapping";
        Log.entering(clazz, method);
        String localWsadmin = null;
        ConfigurationProvider configProvider = Topology.getBootstrapFileOps().getConfigurationProvider();
        if (configProvider != null) {
            Log.finer(clazz, method, "Reading " + BootStrappingProperty.LOCAL_WSADMIN + " property from bootstrapping file.");
            localWsadmin = configProvider.getProperty(BootStrappingProperty.LOCAL_WSADMIN.toString());
        } else {
            Log.finer(clazz, method, "No configuration provider available for the bootstrapping file. A bootstrapping file may not be in use.");
        }
        Log.exiting(clazz, method, localWsadmin);
        return localWsadmin;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        final String method = "clone";
        Log.entering(clazz, method);
        WsadminThinClientConnectionOptions connInfo = (WsadminThinClientConnectionOptions) super.clone();
        if (this.localWsadmin != null) {
            connInfo.localWsadmin = new File(this.localWsadmin.getAbsolutePath());
        }
        Log.exiting(clazz, method, connInfo);
        return connInfo;
    }

    /**
     * Custom clone method to clone all values except those specified in the method headar
     *
     * @param connType The connection type to use
     * @param port     The port to connect to
     * @param user     The user name to use when connecting
     * @param password The password to use when connecting
     * @return A clone of this WsadminThinClientConnectionOptions
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone(ConnectorType connType, int port, String user, String password) throws CloneNotSupportedException {
        WsadminThinClientConnectionOptions nci = (WsadminThinClientConnectionOptions) this.clone();
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
}
