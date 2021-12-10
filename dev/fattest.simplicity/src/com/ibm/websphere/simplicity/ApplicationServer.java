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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.management.AttributeList;

import com.ibm.websphere.simplicity.config.securitydomain.SecurityDomain;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProvider;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.ConfigurationOperationsProvider;
import com.ibm.websphere.simplicity.runtime.NodeAgentMBean;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;
import com.ibm.websphere.simplicity.runtime.RuntimeServices;
import com.ibm.websphere.simplicity.runtime.ServerMBean;

/**
 * This class represents a WebSphere application server. This is the parent
 * class for specialized application servers such as {@link Dmgr}.
 */
public class ApplicationServer extends Server {

    protected static final String SERVER_STARTED = "ADMU3000I";
    protected static final String SERVER_ALREADY_STARTED = "ADMU3027E";
    protected static final String SERVER_ALREADY_STARTED_DMGR_I = "CWNATV00I";
    protected static final String SERVER_ALREADY_STARTED_SERVER_I = "CWNATV01I";
    protected static final String SERVER_STOPPED = "ADMU4000I";
    protected static final String SERVER_ALREADY_STOPPED = "ADMU0509I";

    private static final Class<?> c = ApplicationServer.class;

    private RuntimeServices runtime = null;
    private ServerMBean serverMBean;
    private NodeAgentMBean nodeAgentMBean; // admin-agent

    // only

    /**
     * Constructor to create an existing instance
     *
     * @param configId The {@link ConfigIdentifier} for the ApplicationServer
     * @param cell     The {@link Cell} that this ApplicationServer belongs to
     * @param node     The {@link Node} that the ApplicationServer belongs to
     */
    protected ApplicationServer(ConfigIdentifier configId, Cell cell, Node node) throws Exception {
        this(configId, cell, node, ServerType.APPLICATION_SERVER, null);
    }

    /**
     * Constructor to create a new ApplicationServer
     *
     * @param configId   The {@link ConfigIdentifier} for the ApplicationServer
     * @param cell       The {@link Cell} that this ApplicationServer belongs to
     * @param node       The {@link Node} that the ApplicationServer belongs to
     * @param serverType The type of server
     */
    protected ApplicationServer(ConfigIdentifier configId,
                                Cell cell,
                                Node node,
                                ServerType serverType,
                                ArrayList<AttributeList> portInitData) throws Exception {
        super(configId, cell, node, serverType, portInitData);
    }

    /**
     * Returns the String used by WebSphere to target entities such as
     * application modules to the ApplicationServer
     *
     * @return The ApplicationServer target mapping String
     */
    public String getMappingName() {
        return "WebSphere:cell=" + getCellName()
               + ",node="
               + getNode().getName()
               + ",server="
               + getName();
    }

    /**
     * Starts the ApplicationServer.
     * <p>
     * If this instance represents a managed node (ND), or registered node
     * (Admin Agent), the server will start via the node agent mbean.
     * <p>
     * If the node agent mbean is not available, or the server is not managed
     * and not registered, then the startServer script file will be used to
     * start the server. If the Simplicity execution JVM is not on the same
     * machine as the target server, a command line provider with remote
     * execution capabilities must be available (ex: RXA).
     *
     * @throws Exception If the server did not start successfully and is not
     *                       already started.
     */
    @Override
    public void start() throws Exception {
        final String method = "start";
        Log.entering(c, method);
        start(120);
        Log.exiting(c, method);
    }

    /**
     * Starts the ApplicationServer.
     * <p>
     * If this instance represents a managed node (ND), or registered node
     * (Admin Agent), the server will start via the node agent mbean.
     * <p>
     * If the node agent mbean is not available, or the server is not managed
     * and not registered, then the startServer script file will be used to
     * start the server. If the Simplicity execution JVM is not on the same
     * machine as the target server, a command line provider with remote
     * execution capabilities must be available (ex: RXA).
     *
     * @param timeout The maximum time to wait (in seconds) for the server to
     *                    activate mbeans (slower servers take longer)
     * @throws Exception If the server did not start successfully and is not
     *                       already started.
     */
    public void start(long timeout) throws Exception {
        start((int) timeout);
    }

    /**
     * Starts the ApplicationServer.
     * <p>
     * If this instance represents a managed node (ND), or registered node
     * (Admin Agent), the server will start via the node agent mbean.
     * <p>
     * If the node agent mbean is not available, or the server is not managed
     * and not registered, then the startServer script file will be used to
     * start the server. If the Simplicity execution JVM is not on the same
     * machine as the target server, a command line provider with remote
     * execution capabilities must be available (ex: RXA).
     *
     * @param timeout The maximum time to wait (in seconds) for the server to
     *                    activate mbeans (slower servers take longer)
     * @throws Exception If the server did not start successfully and is not
     *                       already started.
     */
    @Override
    public void start(int timeout) throws Exception {
        final String method = "start";
        Log.entering(c, method);

        start(timeout, false);

        Log.exiting(c, method);
    }

    @Override
    protected void start(int timeout, boolean async) throws Exception {
        final String method = "startServer";
        Log.entering(c, method, new Object[] { timeout, async });

        Log.finer(c, method, "Starting ApplicationServer " + this.getName()
                             + " on Node "
                             + this.getNodeName()
                             + " on Cell "
                             + this.getCellName());
        if (this.getServerStatus().equals(ProcessStatus.RUNNING)) {
            Log.exiting(c, method, "Server already running");
            return;
        }

        if (async && OperationsProviderFactory.getProvider().getOperationsType().equals(OperationsProviderType.WSADMIN)) {
            // only need to do this for the wsadmin provider to achieve an
            // asynchronous start
            commandLineStart();
        } else if (this.getCell().getTopologyType().equals(WebSphereTopologyType.ND)
                   && (this.getServerType().equals(ServerType.APPLICATION_SERVER) || this.getServerType().equals(ServerType.PROXY_SERVER))) {
            try {
                NodeAgent na = (NodeAgent) this.getNode().getManager();
                if (!na.start(this))
                    // The nodeagent is up, but for some reason the call failed
                    throw new Exception("Server failed to start");
            } catch (Exception e) {
                // Pass the !na.start exception through; if the na couldn't
                // start it, let the user know
                // Be careful, sometimes either |e| or e.getMessage() is null
                if (e != null && e.getMessage() != null
                    && e.getMessage().indexOf("Server failed to start") != -1)
                    throw e;
                // For all other exceptions we try the command-line
                Log.finer(c,
                          method,
                          "Failed to start the server using MBeans. Trying the command line provider.",
                          e);
                commandLineStart();
            }
        } else if (this.getNode().isRegisteredToAdminAgent()) {
            // The agent subsystem has a nodeagent mbean to manage the
            // registered node
            try {
                if (!getNodeAgentMBean().launchProcess(this)) {
                    throw new Exception("Server failed to start");
                }
            } catch (Exception e) {
                Log.finer(c,
                          method,
                          "Failed to start the server using MBeans. Trying the command line provider.",
                          e);
                commandLineStart();
            }
        } else {
            // Not a managed node, see if we can talk directly to the server
            commandLineStart();
        }

        // Make sure that when we get here the server really did start
        ProcessStatus status = this.getServerStatus();
        while (!status.equals(ProcessStatus.RUNNING) && timeout > 0) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
            }
            status = this.getServerStatus();
            timeout -= 10;
        }
        try {
            Thread.sleep(10000); // give the server time to allow mbeans to
            // update
        } catch (Exception e) {
        }
        if (!status.equals(ProcessStatus.RUNNING)) {
            throw new Exception("The server failed to start, but no exceptions were thrown in the process. The current server status is " + status
                                + ".");
        }

        Log.finer(c, method, "ApplicationServer " + this.getName()
                             + " on Node "
                             + this.getNodeName()
                             + " on Cell "
                             + this.getCellName()
                             + " is started");

        Log.exiting(c, method);
    }

    /**
     * Start this server using the command line provider
     *
     * @throws Exception
     */
    protected void commandLineStart() throws Exception {
        CommandLineProvider clp = CommandLineProviderFactory.getProvider();

        String result = clp.startServer(this);
        // throw an Exception if the server did not start and is not already
        // started.
        if (result.indexOf(SERVER_STARTED) == -1 && result.indexOf(SERVER_ALREADY_STARTED) == -1
            && result.indexOf(SERVER_ALREADY_STARTED_DMGR_I) == -1
            && result.indexOf(SERVER_ALREADY_STARTED_SERVER_I) == -1) {
            throw new Exception("Server " + this.getName()
                                + " on node "
                                + this.getNode().getName()
                                + " failed to start.\n"
                                + result);
        }
    }

    /**
     * Stop this ApplicationServer. If this is a manager server (ex:
     * DeploymentManager) or a stand-alone base server, or the manager server
     * for the node is not running, the stopServer script file will be used to
     * stop the server. If the script is not local, a command line provider with
     * remote execution capabilities must be available (ex: RXA). If this is not
     * a manager server or stand-alone base server, and the manager server for
     * the node is running, the server will be stopped using it's mbean. If the
     * server is already stopped, the WebSphere error that is reported for
     * trying to stop an already stopped server is ignored.
     * <p>
     * If this server is the cell manager, you must have a command-line provider
     * available to execute the startServer script file on the machine itself.
     *
     * @throws Exception If the server did not stop successfully and is not
     *                       already stopped.
     */
    @Override
    public void stop() throws Exception {
        final String method = "stop";
        Log.entering(c, method);
        stop(600);
        Log.exiting(c, method);
    }

    /**
     * Stop this ApplicationServer. If this is a manager server (ex:
     * DeploymentManager) or a stand-alone base server, or the manager server
     * for the node is not running, the stopServer script file will be used to
     * stop the server. If the script is not local, a command line provider with
     * remote execution capabilities must be available (ex: RXA). If this is not
     * a manager server or stand-alone base server, and the manager server for
     * the node is running, the server will be stopped using it's mbean. If the
     * server is already stopped, the WebSphere error that is reported for
     * trying to stop an already stopped server is ignored.
     * <p>
     * If this server is the cell manager, you must have a command-line provider
     * available to execute the startServer script file on the machine itself.
     *
     * @param stop The time to wait (in seconds)
     * @throws Exception If the server did not stop successfully and is not
     *                       already stopped.
     */
    @Override
    public void stop(long timeout) throws Exception {
        final String method = "stop";
        Log.entering(c, method, timeout);

        stop(timeout, false);

        Log.exiting(c, method);
    }

    @Override
    protected void stop(long timeout, boolean async) throws Exception {
        final String method = "stop";
        Log.entering(c, method, new Object[] { timeout, async });
        Log.finer(c, method, "Stopping ApplicationServer " + this.getName()
                             + " on Node "
                             + this.getNodeName()
                             + " on Cell "
                             + this.getCellName());

        if (async && OperationsProviderFactory.getProvider().getOperationsType().equals(OperationsProviderType.WSADMIN)) {
            // we only need to do this to achieve asynchronous stop for wsadmin
            commandLineStop();
        } else {
            try {
                if (this.getServerStatus().equals(ProcessStatus.STOPPED)) {
                    Log.exiting(c, method, "Server already stopped");
                    return;
                }

                if (this.getCell().getTopologyType().equals(WebSphereTopologyType.ND) && !this.getCell().getManager().equals(this)) {
                    // Force a precache of data to start this back up again
                    this.getNode().getProfileDir();
                    this.getNode().getHostname();
                    this.getNode().getMachine();
                }

                this.getServerMBean().stop();
                while (this.getServerStatus().equals(ProcessStatus.RUNNING) && --timeout > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }

                // When we get here the server is not yet finished; it has
                // simply
                // shut down
                // the TCP ports. Wait a bit more time to make sure it has time
                // to
                // completely exit.
                Thread.sleep(10 * 1000);
            } catch (Exception e) {
                Log.finer(c,
                          method,
                          "Unable to stop the server using mbeans. Trying with the CommandLineProvider.");
                commandLineStop();
                // No need to wait here.
            }
        }

        if (this.getServerStatus().equals(ProcessStatus.RUNNING)) {
            throw new Exception("Server did not stop within " + timeout + " seconds");
        }

        Log.finer(c, method, "ApplicationServer " + this.getName()
                             + " on Node "
                             + this.getNodeName()
                             + " on Cell "
                             + this.getCellName()
                             + " is stopped");
        Log.exiting(c, method);
    }

    /**
     * Stop this server using the command line provider
     *
     * @throws Exception
     */
    protected void commandLineStop() throws Exception {
        CommandLineProvider clp = CommandLineProviderFactory.getProvider();

        String result = clp.stopServer(this);
        // throw an Exception if the server did not stop and is not already
        // stopped.
        if (result.indexOf(SERVER_STOPPED) == -1 && result.indexOf(SERVER_ALREADY_STOPPED) == -1) {
            throw new Exception("Server " + this.getName()
                                + " on node "
                                + this.getNode().getName()
                                + " failed to stop.\n"
                                + result);
        }
    }

    /**
     * Invokes the server MBean's restart method, and waits for the server to
     * both stop and start. If it does not start within the specified timeout,
     * an exception is thrown. This method has a default timeout of 15 minutes.
     *
     * @throws Exception
     */
    public void restart() throws Exception {
        restart(1000 * 60 * 15); // 15 minutes
    }

    /**
     * Invokes the server MBean's restart method, and waits for the server to
     * both stop and start. If it does not start within the specified timeout,
     * an exception is thrown.
     *
     * @param timeout The duration (in milliseconds) to wait for the server to
     *                    restart.
     * @throws Exception
     */
    public void restart(long timeout) throws Exception {
        final String method = "restart";
        Log.entering(c, method);
        try {
            this.stop(timeout);
            if (!this.getServerStatus().equals(ProcessStatus.STOPPED))
                throw new Exception("Server failed to stop -- reverting to command-line variation");
            this.start(timeout);
        } catch (Exception e) {
            Log.finer(c,
                      method,
                      "Failed to restart the server using MBeans. Trying the command line provider.");
            commandLineStop();
            commandLineStart();
        }

        if (!this.getServerStatus().equals(ProcessStatus.RUNNING))
            throw new Exception("Server did not restart within the specified timeout");

        Log.exiting(c, method);
    }

    /**
     * This method returns a Set of {@link Cluster}s that this server is a
     * member of
     *
     * @return The {@link Cluster}s that this server is a member of
     * @throws Exception
     */
    public Set<Cluster> getClusters() throws Exception {
        Set<Cluster> ret = new HashSet<Cluster>();
        for (Cluster c : getCell().getClusters()) {
            for (Server s : c.getMembers())
                if (s.equals(this)) {
                    ret.add(c);
                    break;
                }
        }
        return ret;
    }

    public ServerMBean getServerMBean() throws Exception {
        if (this.serverMBean == null) {
            this.serverMBean = new ServerMBean(this);
        }
        return this.serverMBean;
    }

    /**
     * Get the {@link RuntimeServices} for this ApplicationServer. The
     * {@link RuntimeServices} provide access to Server Mbean operations such as
     * enabling runtime server trace.
     *
     * @return The {@link RuntimeServices} for this ApplicationServer.
     */
    public RuntimeServices getRuntimeServices() {
        if (this.runtime == null)
            this.runtime = new RuntimeServices(this);
        return this.runtime;
    }

    @Override
    public ProcessStatus getServerStatus() throws Exception {
        final String method = "getServerStatus";
        Log.entering(c, method);

        ProcessStatus ret = null;
        try {
            if (this.getCell().getTopologyType().equals(WebSphereTopologyType.ND) && this.getServerType().equals(ServerType.APPLICATION_SERVER)) {
                NodeAgent na = (NodeAgent) this.getNode().getManager();
                ret = na.getProcessStatus(this);
            } else if (this.getNode().isRegisteredToAdminAgent() && this.getNode().getAdminAgent().getManager().getServerStatus().equals(ProcessStatus.RUNNING)) {
                ret = getNodeAgentMBean().getProcessStatus(this);
            }
        } catch (Exception e) {
            Log.finer(c, method, e.getMessage());
            Log.finer(c,
                      method,
                      "Non-fatal error getting the appserver status. Will try by connecting to the server.");
        }

        // Either we're not a managed node, or we need to make a direct
        // connection to determine status
        if (ret == null) {
//            if (isPortListening(PortType.SOAP_CONNECTOR_ADDRESS))
//                return ProcessStatus.RUNNING;
//            else
            return ProcessStatus.STOPPED;
        }

        Log.exiting(c, method, ret);
        return ret;
    }

    @Override
    public SecurityDomain getSecurityDomain() throws Exception {
        return super.getSecurityDomain();
    }

    /**
     * Get the short name of this server. This name can contain one to eight
     * uppercase alphanumeric characters, but it cannot start with a numeral.
     * This field only applies to the z/OS(R) platform. On other platforms, this
     * method will typically return null.
     *
     * @return The process ID
     */
    public String getShortName() throws Exception {
        final String method = "getShortName";
        Log.entering(c, method);
        String name;
        try {
            ConfigurationOperationsProvider provider = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider();
            AbstractSession session = getWorkspace().getSession();
            ConfigIdentifier configId = this.getConfigId();
            Object attribute = provider.getAttribute(getNode(), session, configId, "shortName");
            name = (String) attribute;
        } catch (Exception e) {
            throw new Exception("Unable to detect the shortName of the Server named " + this.getName(), e);
        }
        Log.exiting(c, method, name);
        return name;
    }

    /**
     * @deprecated
     * @see #getProcessIdString()
     */
    @Deprecated
    public int getProcessID() throws Exception {
        final String method = "getProcessID";
        Log.entering(c, method);
        int pid = this.getServerMBean().getProcessId();
        Log.exiting(c, method, pid);
        return pid;
    }

    /**
     * Get the OS process ID for this ApplicationServer.
     *
     * @return The process ID
     */
    public String getProcessIdString() throws Exception {
        final String method = "getProcessIdString";
        Log.entering(c, method);
        String pid = this.getServerMBean().getProcessIdString();
        Log.exiting(c, method, pid);
        return pid;
    }

    @Override
    public void resetServerState() throws Exception {
        final String method = "reset";
        Log.entering(c, method);

        this.runtime = null;

        super.resetServer();

        Log.exiting(c, method);
    }

    /**
     * Causes the current Thread to sleep until a specific set of ports
     * associated with this Server are listening.
     *
     * @param timeout      The number of milliseconds to wait for port activation
     *                         before timing out
     * @param pollInterval The number of milliseconds to wait between each round
     *                         of status checking
     * @param ports        The ports to wait for
     * @return true if all ports started listening before the timeout expired,
     *         otherwise false
     * @throws Exception if port status cannot be established, or if this thread
     *                       is interrupted
     */
    public boolean waitForPortActivation(long timeout, long pollInterval, Set<PortType> ports) throws Exception {
        final String method = "waitForPortActivation";
        Log.entering(c, method, new Object[] { timeout, pollInterval, ports });
        if (ports == null) {
            throw new IllegalArgumentException("Unable to determine if ports are listening since the input Set of PortType objects was null");
        }
        long start = System.currentTimeMillis();
        while ((System.currentTimeMillis() - start) < timeout) {
            if (this.isPortListening(ports)) {
                Log.exiting(c, method, true);
                return true;
            }
            Thread.sleep(pollInterval);
            Log.finer(c, method, "This thread has waited " + (System.currentTimeMillis() - start)
                                 + " milliseconds for the ports to become active.  Will wait up to "
                                 + timeout
                                 + " milliseconds.");
        }
        Log.exiting(c, method, false);
        return false;
    }

    /**
     * This method is only applicable to nodes registered to an admin agent. The
     * node agent mbean is assigned to the app server's node (technically it
     * belongs to the subsystem), and is not an endpoint, merely an mbean.
     *
     * @return the node agent mbean
     */
    private NodeAgentMBean getNodeAgentMBean() throws Exception {
        if (this.nodeAgentMBean == null)
            this.nodeAgentMBean = new NodeAgentMBean(this);
        return this.nodeAgentMBean;
    }
}
