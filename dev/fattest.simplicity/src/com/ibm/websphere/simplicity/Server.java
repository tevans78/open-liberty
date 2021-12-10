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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.commands.port.ModifyServerPort;
import com.ibm.websphere.simplicity.config.Configurable;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.ConfigType;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.ConfigurationOperationsProvider;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;

/**
 * This abstract class is the parent for all Servers in the Topology. This
 * includes application servers, web servers, and generic servers.
 */
public abstract class Server extends Scope implements Configurable {

    private static final Class c = Server.class;
    private static final String CHANGE_KEY_PORTS = "ports";

    protected Node node = null;
    protected ServerType serverType = null;
    protected String configPath;
    private Map<PortType, Port> ports = new HashMap<PortType, Port>();
    private ArrayList<AttributeList> portInitData = null;

    /**
     * Constructor to create an existing instance
     *
     * @param configId The {@link ConfigIdentifier} for the Server
     * @param cell     The {@link Cell} that this Server belongs to
     * @param node     The {@link Node} that the Server belongs to
     */
    protected Server(ConfigIdentifier configId, Cell cell, Node node) {
        super(configId, node, cell);
        this.node = node;
    }

    /**
     * Constructor to create a new Server
     *
     * @param configId The {@link ConfigIdentifier} for the Server
     * @param cell     The {@link Cell} that this Server belongs to
     * @param node     The {@link Node} that the Server belongs to
     */
    protected Server(ConfigIdentifier configId, Cell cell, Node node, ServerType serverType, ArrayList<AttributeList> portInitData) throws Exception {
        super(configId, node, cell);
        this.node = node;
        this.serverType = serverType;
        this.portInitData = portInitData;

        // if we're using topology caching we'll init them from the cache
        if (!Topology.isTopologyCachingEnabled() || !Topology.getBootstrapFileOps().cacheComplete(getCell().getBootstrapFileKey()))
            initPorts();
    }

    @Override
    public String getObjectNameFragment() {
        return this.node.getObjectNameFragment() + ",process=" + this.getName();
    }

    @Override
    public ScopeHelper getScopeHelper() {
        return new ScopeHelper(this);
    }

    @Override
    public String getConfigPath() throws Exception {
        if (this.configPath == null) {
            this.configPath = this.node.getConfigPath() + "servers/" + this.getName() + "/";
        }
        return this.configPath;
    }

    /**
     * Set the path to the config directory for this Server
     *
     * @param configPath The path to the Server's configuration directory
     */
    protected void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    /**
     * Get the name of the parent {@link Cell} for this Server
     *
     * @return The name of the parent {@link Cell} of this Server
     */
    public String getCellName() {
        return this.cell.getName();
    }

    /**
     * Get the parent {@link Node} for this Server
     *
     * @return The parent {@link Node} of this Server
     */
    public Node getNode() {
        return this.node;
    }

    /**
     * Get the name of the parent {@link Node} for this Server
     *
     * @return The name of the parent {@link Node} of this Server
     */
    public String getNodeName() {
        return this.node.getName();
    }

    /**
     * Translates a predefined variable into its corresponding string value.
     *
     * @param variable The variable to translate.
     * @return The value of the variable, or null if it does not exist.
     * @throws Exception
     */
    public String expandVariable(VariableType variable) throws Exception {
        return expandVariable(variable.getValue());
    }

    /**
     * Translates a custom variable into its corresponding string value.
     *
     * @param variable The variable name to translate.
     * @return The value of the variable, or null if it does not exist.
     * @throws Exception
     */
    public String expandVariable(String variable) throws Exception {
        // Remove the standard prefix & postfix, if any
        variable = variable.replace("${", "").replace("$(", "").replace("}", "").replace(")", "");
        return OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().expandVariable(this, variable, this.getActiveSession());
    }

    /**
     * Recursively expands all variables in the string to the corresponding
     * value from the server, and replaces backslashes with forward slashes. The
     * resulting string does not contain any variables.
     *
     * @param str A string that contains zero or more variables.
     * @return The fully-expanded version of the string.
     * @throws Exception
     */
    public String expandString(String str) throws Exception {
        return Scope.expandString(this, str);
    }

    /**
     * This method starts the Server
     *
     * @throws Exception
     */
    public abstract void start() throws Exception;

    /**
     * This method starts the Server
     *
     * @param mbeanWaitDuration The maximum time to wait (in seconds) for the
     *                              server to activate mbeans (slower servers take longer)
     * @throws Exception
     */
    public abstract void start(int mbeanWaitDuration) throws Exception;

    /**
     * This method starts the Server
     *
     * @param mbeanWaitDuration The maximum time to wait (in seconds) for the
     *                              server to activate mbeans (slower servers take longer)
     * @param async             True if this is an asynchronous start
     * @throws Exception
     */
    protected abstract void start(int mbeanWaitDuration, boolean async) throws Exception;

    /**
     * This method stops the Server
     *
     * @throws Exception
     */
    public abstract void stop() throws Exception;

    /**
     * This method stops the Server
     *
     * @param timeout The time to wait (in seconds)
     * @throws Exception
     */
    public abstract void stop(long timeout) throws Exception;

    /**
     * This method stops the Server
     *
     * @param timeout The time to wait (in seconds)
     * @param true    to do an asynchronous stop
     * @throws Exception
     */
    protected abstract void stop(long timeout, boolean async) throws Exception;

    /**
     * Get the {@link ServerType} of this Server. The server type determines the
     * capibilities of the Server. For example, a {@link Dmgr} server manages
     * the nodes within a {@link Cell}.
     *
     * @return The type of this Server
     */
    public ServerType getServerType() {
        return this.serverType;
    }

    /**
     * This method clears all cached data for this Server. Further requests for
     * information will be loaded fresh from the WAS instance.
     * <p>
     * Deprecated in favor of resetServer().
     *
     * @throws Exception
     * @deprecated
     */
    @Deprecated
    public void resetServerState() throws Exception {
        resetServer();
    }

    /**
     * This method clears all cached data for this Server. Further requests for
     * information will be loaded fresh from the WAS instance.
     * <p>
     * WARNING!!! Calling this method invalidates all pointers to any Simplicity
     * objects obtained from the Server and its children. Only call this method
     * if you absolutely want to reset the object model underneath this Server.
     *
     * @throws Exception
     */
    public void resetServer() throws Exception {
        final String method = "resetServerState";
        Log.entering(c, method);

        this.configPath = null;
        this.ports = null;

        if (Topology.isTopologyCachingEnabled()) {
            Topology.getBootstrapFileOps().cache(this.getCell());
        }

        Log.exiting(c, method);
    }

    /**
     * Get the port number value for a {@link ConnectorType} for this Server
     *
     * @param connectorType The {@link ConnectorType} port value to get
     * @return An Integer representation of the port value
     * @throws Exception
     */
    public Integer getPortNumber(ConnectorType connectorType) throws Exception {
        final String method = "getPortNumber";
        Log.entering(c, method, connectorType);
        Log.finer(c, method, "server is " + this.getNodeName() + ", " + this.getName());
        PortType port = PortType.valueOf(connectorType.getEndpointName());
        Integer portNumber = getPortNumber(port);
        Log.exiting(c, method, portNumber);
        return portNumber;
    }

    /**
     * Get a port value for a port for this Server
     *
     * @param port The port to get
     * @return An Integer representation of the port value
     * @throws Exception
     */
    public Integer getPortNumber(PortType port) throws Exception {
        final String method = "getPortNumber";
        Log.entering(c, method, port);
        Log.finer(c, method, "server is " + this.getNodeName() + ", " + this.getName());
        if (this.ports == null || this.ports.size() == 0) {
            initPorts();
        }
        if (port == null) {
            throw new IllegalArgumentException("Unable to determine a port value because the input PortType is null");
        }
        // if(!this.ports.containsKey(port)) {
        // throw new
        // IllegalArgumentException("Server="+this.getName()+" Node="+this.getNodeName()+" Cell="+this.getCellName()+" does not have a port named "+port.getPortName());
        // }

        Port p = this.ports.get(port);
        Log.finer(c, method, "Port: " + p);
        Integer portNum = null;
        if (p != null)
            portNum = p.getValue();
        else
            portNum = null;
        Log.exiting(c, method, portNum);
        return portNum;
    }

    /**
     * Get the host that the {@link ConnectorType} is bound to
     *
     * @param connectorType The {@link ConnectorType} to get the host for
     * @return The host of the port
     * @throws Exception
     */
    public String getPortHost(ConnectorType connectorType) throws Exception {
        PortType port = PortType.valueOf(connectorType.getEndpointName());
        return getPortHost(port);
    }

    /**
     * Get the host that the {@link PortType} is bound to
     *
     * @param connectorType The {@link PortType} to get the host for
     * @return The host of the port
     * @throws Exception
     */
    public String getPortHost(PortType port) throws Exception {
        if (this.ports == null || this.ports.size() == 0) {
            initPorts();
        }
        if (port == null) {
            throw new IllegalArgumentException("Unable to determine a port value because the input PortType is null");
        }
        // if(!this.ports.containsKey(port)) {
        // throw new
        // IllegalArgumentException("Server="+this.getName()+" Node="+this.getNodeName()+" Cell="+this.getCellName()+" does not have a port named "+port.getPortName());
        // }
        Port p = this.ports.get(port);
        if (p != null)
            return p.getHost();
        return null;
    }

    /**
     * This method returns the {@link ProcessStatus} of the Server. This method
     * can be used to determine whether or not a server is running. There are
     * cases where the status of a server may not be able to be determined. In
     * these cases a status of {@link ProcessStatus#STOPPED} is returned.
     *
     * @return The status of the server
     * @throws Exception
     */
    public abstract ProcessStatus getServerStatus() throws Exception;

    /**
     * Set a port for this ApplicationServer
     *
     * @param portType The port to set
     * @param port     The Port to set
     */
    protected void setPort(PortType portType, Port port) {
        if (this.ports == null)
            this.ports = new HashMap<PortType, Port>();
        this.ports.put(portType, port);
    }

    /**
     * Determine whether or not the target port is currently listening. This
     * method is useful for determining if the server is really ready to accept
     * requests on its ports. Occasionally, a port is not ready immediately
     * after the server is started. If a request to a server port is made before
     * it is ready, unexpected failures can occur.
     *
     * @param port The port whose status you want to check
     * @return true if the port is listening, otherwise false
     * @throws Exception if port status cannot be established
     */
    public boolean isPortListening(PortType port) throws Exception {
        final String method = "portIsListening";
        Log.entering(c, method, port);
        int portNumber = this.getPortNumber(port).intValue();
        Socket socket = null;
        boolean connected = false;
        String host = getPortHost(port);
        if (host != null) {
            if (host.equals("*") || host.trim().length() == 0)
                host = node.getMachine().getHostname();
            if (host != null) {
                Log.finest(c, method, "Opening a socket on host " + host
                                      + " at port "
                                      + portNumber
                                      + " ("
                                      + port.name()
                                      + ")");
                try {
                    Log.finest(c, method, "Constructing a socket");
                    /*- Implementation note:
                     *  DO NOT directly connect to server with Socket constructor.
                     *  If an exception is thrown while the socket connects,
                     *  you lose the reference to the Socket object.  As a result,
                     *  the Socket can be left in an invalid state, and you can't
                     *  reference the Socket to call the close() operation.
                     *  This invalid state can cause problems for WebSphere
                     *  on Linux, and perhaps other operating systems.
                     */
                    socket = new Socket();
                    Log.finest(c, method, "SO_KEEPALIVE  =" + socket.getKeepAlive());
                    Log.finest(c, method, "OOBINLINE     =" + socket.getOOBInline());
                    Log.finest(c, method, "SO_REUSEADDR  =" + socket.getReuseAddress());
                    Log.finest(c, method, "SO_SNDBUF     =" + socket.getSendBufferSize());
                    Log.finest(c, method, "SO_RCVBUF     =" + socket.getReceiveBufferSize());
                    Log.finest(c, method, "SO_LINGER     =" + socket.getSoLinger());
                    Log.finest(c, method, "SO_TIMEOUT    =" + socket.getSoTimeout());
                    Log.finest(c, method, "TCP_NODELAY   =" + socket.getTcpNoDelay());
                    Log.finest(c, method, "traffic class =" + socket.getTrafficClass());
                    Log.finest(c, method, "socket.isConnected()=" + socket.isConnected());
                    Log.finest(c, method, "socket.isBound()=" + socket.isBound());
                    Log.finest(c, method, "socket.isClosed()=" + socket.isClosed());
                    Log.finest(c, method, "socket.isInputShutdown()=" + socket.isInputShutdown());
                    Log.finest(c, method, "socket.isOutputShutdown()=" + socket.isOutputShutdown());
                    Log.finest(c, method, "Constructing an InetSocketAddress on host " + host
                                          + " at port "
                                          + portNumber
                                          + " ("
                                          + port.name()
                                          + ")");
                    InetSocketAddress address = new InetSocketAddress(host, portNumber);
                    Log.finest(c, method, "Connecting to the address mentioned above");
                    socket.connect(address, 5000);
                    Log.finest(c, method, "socket.isConnected()=" + socket.isConnected());
                    Log.finest(c, method, "socket.isBound()=" + socket.isBound());
                    Log.finest(c, method, "socket.isClosed()=" + socket.isClosed());
                    Log.finest(c, method, "socket.isInputShutdown()=" + socket.isInputShutdown());
                    Log.finest(c, method, "socket.isOutputShutdown()=" + socket.isOutputShutdown());
                    if (socket.isConnected()) {
                        connected = true;
                    }
                } catch (IOException e) {
                    Log.finest(c, method, "Unable to connect to the " + port.getPortName()
                                          + " port on Server="
                                          + this.getName()
                                          + " Node="
                                          + this.getNodeName()
                                          + " Cell="
                                          + this.getCellName()
                                          + ": "
                                          + e.getMessage());
                } finally {
                    Log.finest(c,
                               method,
                               "About to close the socket, checking if the socket object is null");
                    if (socket != null) {
                        Log.finest(c, method, "socket.getLocalPort()=" + socket.getLocalPort());
                        Log.finest(c, method, "socket.getLocalAddress()=" + socket.getLocalAddress());
                        Log.finest(c, method, "socket.getInetAddress()=" + socket.getInetAddress());
                        Log.finest(c, method, "socket.getPort()=" + socket.getPort());
                        try {
                            Log.finest(c, method, "Calling socket.close()");
                            socket.close();
                            Log.finest(c, method, "socket.close() did not throw an exception");
                        } catch (IOException e) {
                            Log.finest(c,
                                       method,
                                       "WARNING!  socket.close() threw an exception: " + e.getMessage());
                        }
                        Log.finest(c, method, "socket.isConnected()=" + socket.isConnected());
                        Log.finest(c, method, "socket.isBound()=" + socket.isBound());
                        Log.finest(c, method, "socket.isClosed()=" + socket.isClosed());
                        Log.finest(c, method, "socket.isInputShutdown()=" + socket.isInputShutdown());
                        Log.finest(c, method, "socket.isOutputShutdown()=" + socket.isOutputShutdown());
                    } else {
                        Log.finest(c, method, "The socket object is null");
                    }
                }
            }
        }
        Log.exiting(c, method, connected);
        return connected;
    }

    /**
     * Determine whether or not the target ports are currently listening.
     *
     * @param ports The ports whose status you want to check
     * @return true if the ports are listening, otherwise false
     * @throws Exception if port status cannot be established
     */
    public boolean isPortListening(Set<PortType> ports) throws Exception {
        final String method = "isPortListening";
        Log.entering(c, method, ports);
        if (ports == null) {
            throw new IllegalArgumentException("Unable to determine if ports are listening since the input Set of PortType objects was null");
        }
        for (PortType portType : ports) {
            if (!this.isPortListening(portType)) {
                Log.exiting(c, method, false);
                return false;
            }
        }
        Log.exiting(c, method, true);
        return true;
    }

    protected void setPortInitData(ArrayList<AttributeList> data) {
        this.portInitData = data;
    }

    /**
     * Initialize the ports for this Server
     */
    private void initPorts() throws Exception {
        if (this.portInitData == null)
            queryPortInitData();
        initPortsConfig();
        // Admin agent uses the RMI port for JSR160RMI
//        if ((this instanceof AdminAgent) && getPortNumber(ConnectorType.JSR160RMI) == null)
//            setPort(PortType.JSR160RMI_CONNECTOR_ADDRESS,
//                    new Port(getPortHost(ConnectorType.RMI), getPortNumber(ConnectorType.RMI)));
    }

    private void queryPortInitData() throws Exception {
        final String method = "queryPortInitData";
        Log.entering(c, method);
        ConfigurationOperationsProvider provider = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider();

        AbstractSession session = getWorkspace().getSession();
        // get the server entries
        Log.finer(c, method, "Getting the serverEntries from serverindex.xml");
        ConfigIdentifier[] serverEntries = provider.queryConfigObjects(getNode(),
                                                                       session,
                                                                       getNode().getConfigId(),
                                                                       ConfigType.SERVER_ENTRY.getType());
        // find the one for this server
        ConfigIdentifier serverEntry = null;
        Log.finer(c, method, "Finding the server entry for this Server, " + this.getName() + ".");
        for (int i = 0; i < serverEntries.length; ++i) {
            Log.finest(c, method, "current entry is " + serverEntries[i].getDisplayName());
            if (serverEntries[i].getDisplayName().equals(this.getName())) {
                Log.finest(c, method, "Found a matching entry.");
                serverEntry = serverEntries[i];
                break;
            }
        }

        AttributeList list = provider.getAttributes(getNode(),
                                                    session,
                                                    serverEntry,
                                                    new String[] { "specialEndpoints" },
                                                    true);
        Attribute epvalue = null;
        for (Object o : list) {
            Attribute a = (Attribute) o;
            if (a.getName().equalsIgnoreCase("specialEndpoints")) {
                epvalue = a;
                break;
            }
        }

        if (epvalue == null)
            throw new Exception("No port endpoints for server?");

        portInitData = (ArrayList<AttributeList>) epvalue.getValue();
        Log.exiting(c, method);
    }

    private void initPortsConfig() throws Exception {
        final String method = "initPortsConfig";
        Log.entering(c, method);

        for (AttributeList endpoint : portInitData) {
            String endpointName = null;
            AttributeList attribs = null;
            for (Object o : endpoint) {
                Attribute attrib = (Attribute) o;
                if (attrib.getName().equalsIgnoreCase("endPointName"))
                    endpointName = (String) attrib.getValue();
                else if (attrib.getName().equalsIgnoreCase("endPoint"))
                    attribs = (AttributeList) attrib.getValue();
            }

            if (endpointName != null) {
                PortType port = null;
                try {
                    port = PortType.valueOf(endpointName);
                } catch (Exception e) {
                    Log.warning(c, "Unknown endpoint name: " + endpointName);
                    continue;
                }
                Integer portNum = null;
                String host = null;
                for (Object o : attribs) {
                    Attribute attrib = (Attribute) o;
                    if (attrib.getName().equalsIgnoreCase("host"))
                        host = (String) attrib.getValue();
                    else if (attrib.getName().equalsIgnoreCase("port")) {
                        Object portValue = attrib.getValue();
                        if (portValue instanceof String) {
                            portNum = new Integer((String) portValue);
                        } else if (portValue instanceof Integer) {
                            portNum = (Integer) portValue;
                        }
                    }
                }
                setPort(port, new Port(host, portNum));
            }
        }
        Log.exiting(c, method);
    }

    /**
     * Modify a port for this Server
     *
     * @param port         The port to modify
     * @param host         The hostname to set for the port
     * @param value        The value to set for the port
     * @param modifyShared
     * @throws Exception
     */
    public void modifyServerPort(PortType port, String host, Integer value, Boolean modifyShared) throws Exception {
        final String method = "modifyServerPort";
        Log.entering(c, method, new Object[] { host, value, modifyShared });

        if (port == null)
            throw new IllegalArgumentException("The port cannot be null.");
        if (host == null && value == null && modifyShared == null)
            throw new IllegalArgumentException("At least one of the values, host, value, or modifyShared, must be specified.");

        if (this.ports == null || this.ports.size() == 0)
            initPorts();
        getWorkspace().registerConfigChange(this,
                                            CHANGE_KEY_PORTS,
                                            new HashMap<PortType, Port>(this.ports));

        ModifyServerPort task = new ModifyServerPort(this.getName(), port.getPortName());
        task.setNodeName(this.getNodeName());
        if (host != null)
            task.setHost(host);
        if (value != null)
            task.setPort(value);
        if (modifyShared != null)
            task.setModifyShared(modifyShared);
        task.run(this);

        Port p = this.ports.get(port);
        if (host != null)
            p.setHost(host);
        if (value != null)
            p.setValue(value);

        if (Topology.isTopologyCachingEnabled())
            Topology.getBootstrapFileOps().cache(this.getCell());

        Log.exiting(c, method);
    }

    @Override
    public void commit(HashMap<String, Object> values) throws Exception {
    }

    @Override
    @SuppressWarnings("unchecked")
    public void rollback(HashMap<String, Object> values) throws Exception {
        if (values.get(CHANGE_KEY_PORTS) != null)
            this.ports = (HashMap<PortType, Port>) values.get(CHANGE_KEY_PORTS);
    }
}

/**
 * Represents a Port
 */
class Port {
    String host;
    Integer value;

    public Port(String host, Integer portValue) {
        this.host = host;
        this.value = portValue;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}

class StartStopServerCallable implements Callable<Object> {

    private Server server;

    private Integer timeout;

    private String op;

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setOperation(String op) {
        this.op = op;
    }

    @Override
    public Object call() throws Exception {
        if ("start".equals(op))
            this.server.start(timeout, true);
        else
            this.server.stop(timeout, true);
        return null;
    }
}
