///*******************************************************************************
// * Copyright (c) 2011 IBM Corporation and others.
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *     IBM Corporation - initial API and implementation
// *******************************************************************************/
//
//package com.ibm.websphere.simplicity.wsadmin;
//
//import java.io.File;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.management.ObjectName;
//
//import com.ibm.websphere.simplicity.ApplicationServer;
//import com.ibm.websphere.simplicity.Cell;
//import com.ibm.websphere.simplicity.ConnectionInfo;
//import com.ibm.websphere.simplicity.ConnectorType;
//import com.ibm.websphere.simplicity.Machine;
//import com.ibm.websphere.simplicity.OperationsProviderType;
//import com.ibm.websphere.simplicity.Topology;
//import com.ibm.websphere.simplicity.WsadminConnectionOptions;
//import com.ibm.websphere.simplicity.WsadminThinClientConnectionOptions;
//import com.ibm.websphere.simplicity.log.Log;
//import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
//import com.ibm.websphere.simplicity.provider.websphere.wsadmin.WsadminOperationsProvider;
//
///**
// * This class provides access to wsadmin. The wsadmin tool provides support for WebSphere
// * administration via scripting. You can use the wsadmin tool to manage WebSphere Application Server
// * as well as the configuration, application deployment, and server run-time operations. This class
// * provides access to persistent, interactive wsadmin sessions. When a Wsadmin instance is requested
// * using the {@link #getInstance(WsadminConnectionOptions)} method, a local cache is checked for an
// * existing instance using the provided {@link WsadminConnectionOptions}. If one is found, the
// * cached instance is returned. If not, a new instance is created. This allows sessions to be reused
// * without incurring the cost of starting a new wsadmin session. If a new clean session is desired,
// * invoke the {@link #reset()} method prior to invoking commands or running scripts. Note that this
// * class does not support the -c and -f wsadmin options. These can be simulated by opening a
// * session, executing the desired command or script, and then closing the session. Be warned that
// * any WAS configuration changes made here WILL NOT be reflected in the Simplicity Object model.
// */
//public class Wsadmin {
//
//    private static Set<Wsadmin> sessionCache = new HashSet<Wsadmin>();
//    private static final Class c = Wsadmin.class;
//
//    private WsadminConnectionOptions options;
//    private WsadminOperationsProvider provider;
//    private boolean isProviderWsadmin;
//    private ApplicationServer wsadminServer;
//
//    /**
//     * Constructor
//     *
//     * @param options The wsadmin options for this Wsadmin
//     * @throws Exception
//     */
//    private Wsadmin(WsadminConnectionOptions options, boolean isProviderWsadmin) throws Exception {
//        this.options = options;
//        this.provider = (WsadminOperationsProvider)OperationsProviderFactory.getProvider(OperationsProviderType.WSADMIN);
//        this.isProviderWsadmin = isProviderWsadmin;
//        this.wsadminServer = options.getWsadminServer();
//    }
//
//    /**
//     * Opens a wsadmin interactive session. This should be called prior to executing wsadmin
//     * commands or scripts.
//     *
//     * @throws Exception
//     */
//    public void openSession() throws Exception {
//        if(!isSessionOpen()) {
//            if(!isProviderWsadmin) {
//                provider.openWsadmin(this.options);
//            } else {
//                provider.openProviderWsadmin(this.options);
//            }
//        }
//    }
//
//    /**
//     * Closes an open wsadmin interactive session.
//     *
//     * @throws Exception
//     */
//    public void closeSession() throws Exception {
//        if(isSessionOpen()) {
//            if(!isProviderWsadmin) {
//                provider.closeWsadmin(this.options);
//            } else {
//                provider.closeProviderWsadmin(this.options);
//            }
//        }
//    }
//
//    /**
//     * Reset the connection. This will close the session if open and reopen it.
//     *
//     * @throws Exception
//     */
//    public void reset() throws Exception {
//        closeSession();
//        openSession();
//    }
//
//    /**
//     * Returns true if the interactive session represented by this Wsadmin is currently open.
//     *
//     * @return true if the session is open
//     * @throws Exception
//     */
//    public boolean isSessionOpen() throws Exception {
//        if(!isProviderWsadmin) {
//            return provider.isSessionOpen(this.options);
//        } else {
//            return provider.isProviderSessionOpen(this.options);
//        }
//    }
//
//    /**
//     * Execute a wsadmin command.
//     *
//     * @param cmd The command to execute
//     * @return The result of the command
//     * @throws Exception
//     */
//    public String executeCommand(String cmd) throws Exception {
//        if(!isProviderWsadmin) {
//            return provider.executeWsadminCommand(this.options, cmd).getSystemOut();
//        } else {
//            return provider.executeProviderWsadminCommand(this.options, cmd).getSystemOut();
//        }
//    }
//
//    /**
//     * Execute a wsadmin script file.
//     *
//     * @param file The wsadmin script to execute
//     * @return The result of the script
//     * @throws Exception
//     */
//    public String executeScriptFile(File file) throws Exception {
//        if(!isProviderWsadmin) {
//            return provider.executeWsadminScript(this.options, file);
//        } else {
//            return provider.executeProviderWsadminScript(this.options, file);
//        }
//    }
//
//    /**
//     * Set the timeout value for executing wsadmin commands and scripts.
//     * If a command or script executes for longer than the timeout period,
//     * the wsadmin implementation will stop listening for a result. The default
//     * timeout value is 3600000L milliseconds.
//     *
//     * @param timeout The timeout value to set in milliseconds
//     */
//    public void setTimeout(long timeout) throws Exception {
//    	provider.setWsadminTimeout(this.options, timeout);
//    }
//
//    /**
//     * Returns the {@link WsadminConnectionOptions} used to open the interactive wsadmin session.
//     * Changing the values of these options does NOT change them for this wsadmin instance. This
//     * method is purely to query the options for this instance. To run wsadmin with new options,
//     * obtain a new instance with the desired options set.
//     *
//     * @return The {@link WsadminConnectionOptions} used to open the interactive wsadmin session.
//     */
//    public WsadminConnectionOptions getOptions() {
//        try {
//            return (WsadminConnectionOptions)options.clone();
//        } catch (CloneNotSupportedException e) {
//            return null;
//        }
//    }
//
//    /**
//     * Two Wsadmin instances are equal if the {@link WsadminConnectionOptions} used to instantiate
//     * them are equal.
//     */
//    public boolean equals(Object o) {
//        if(o == null) {
//            return false;
//        }
//        if(!(o instanceof Wsadmin)) {
//            return false;
//        }
//
//        Wsadmin other = (Wsadmin)o;
//        if(((this.options == null) && (other.options != null)) || ((this.options != null) && (!this.options.equals(other.options)))) {
//            return false;
//        }
//
//        return true;
//    }
//
//    /**
//     * Get the Machine that the wsadmin process was launched from and is running on. It is possible
//     * that this is not the local machine. If a {@link WsadminThinClientConnectionOptions} was not
//     * used to initialize this Wsadmin instance, and Wsadmin is pointed to a remote WAS install, the
//     * wsadmin process will be running remotely.
//     *
//     * @return The {@link Machine} where Wsadmin is running
//     * @throws Exception
//     */
//    public Machine getLaunchMachine() throws Exception {
//        if(this.options instanceof WsadminThinClientConnectionOptions) {
//            return Machine.getLocalMachine();
//        } else {
//            return Machine.getMachine(this.options.getMachineConnectionInfo());
//        }
//    }
//
//    /**
//     * Get the {@link ApplicationServer} which this Wsadmin process is connected to. This is the Server that
//     * the connection is made to and commands are run against. If the connType used is NONE, null is
//     * returned since this Wsadmin is not connected to any Server by definition.
//     *
//     * @return The {@link ApplicationServer} which is target of the wsadmin connection.
//     */
//    public ApplicationServer getTargetServer() throws Exception {
//        final String method = "getWsadminServer";
//        Log.entering(c, method);
//        if(options.getConnType() != null && options.getConnType() == ConnectorType.NONE) {
//          Log.finer(c, method, "connType NONE was used. We aren't connected to a Server");
//          Log.exiting(c, method, null);
//          return null;
//        }
//
//        if(this.wsadminServer == null) {
//            String cmd = null;
//            String lang = null;
//            if(this.options.getLang() == null) {
//                // this isn't elegant but we need to figure out what scripting language our env is
//                // try jython first
//                cmd = "print \'Hello\'";
//                try {
//                    this.provider.executeWsadminCommand(this.options, cmd);
//                    Log.finer(c, method, "Successfully ran a jython command.");
//                    lang = "jython";
//                } catch(Exception e) {
//                    Log.finer(c, method, "Error running a jython command: " + e.getMessage() + ". Trying jacl.");
//                    // then jacl
//                    cmd = "puts Hello";
//                    try {
//                        this.provider.executeWsadminCommand(this.options, cmd);
//                        Log.finer(c, method, "Successfully ran a jacl command.");
//                        lang = "jacl";
//                    } catch(Exception e1) {
//                        throw new Exception("Unable to determine scripting language for the Wsadmin session.", e1);
//                    }
//                }
//            } else {
//                lang = this.options.getLang();
//                Log.finer(c, method, "lang is " + lang);
//            }
//
//            boolean isJython = "jython".equals(lang);
//            // see if the admin client is present
//            if(isJython) {
//                cmd = "adminClient = AdminControl.getAdminClient()";
//            } else {
//                cmd = "set adminClient [$AdminControl getAdminClient]";
//            }
//            String result = this.provider.executeWsadminCommand(this.options, cmd).getSystemOut();
//            if(isJython) {
//                cmd = "print adminClient";
//                result = this.provider.executeWsadminCommand(this.options, cmd).getSystemOut();
//            }
//            if(result.trim().length() == 0) {
//                Log.finer(c, method, "AdminClient was not present. We are not connected to a server.");
//                Log.exiting(c, method, null);
//                return null;
//            }
//
//            if(isJython) {
//                cmd = "print adminClient.getServerMBean()";
//            } else {
//                cmd = "$adminClient getServerMBean";
//            }
//            result = this.provider.executeWsadminCommand(this.options, cmd).getSystemOut();
//            Log.finer(c, method, "Server mbean: " + result);
//            ObjectName objName = new ObjectName(result);
//            String cellName = objName.getKeyProperty("cell");
//            String nodeName = objName.getKeyProperty("node");
//            String serverName = objName.getKeyProperty("process");
//
//            this.wsadminServer = (ApplicationServer)Topology.getCellByName(cellName).getNodeByName(nodeName).getServerByName(serverName);
//        }
//        Log.exiting(c, method, this.wsadminServer);
//        return this.wsadminServer;
//    }
//
//    /**
//     * Generates an interactive {@link Wsadmin} instance. Using an interactive session, users are
//     * able to open a persistent wsadmin session through which wsadmin commands and script files can
//     * be executed consecutively and programmitcally without multiple wsadmin invocations which are
//     * costly. This is the same as opening wsadmin in interactive mode on the command line. The
//     * {@link WsadminConnectionOptions} Object supplied is checked against a cache. If an existing
//     * session exists that session is returned. Othewise a new instance is created.
//     *
//     * @param options The wsadmin options that identify the session and that should be used to open the session.
//     * @return A {@link Wsadmin}
//     */
//    public static Wsadmin getInstance(WsadminConnectionOptions options) throws Exception {
//        return getCachedSession(new Wsadmin(options, false));
//    }
//
//    /**
//     * Generates an interactive {@link Wsadmin} instance. This method will return the same session
//     * used to bootstrap the specified {@link Cell}. This allows you to execute commands and
//     * scripts all in the same session used to interact with the Simplicity Object model. Be aware
//     * that any configuration changes made using the Wsadmin class WILL NOT be reflected in the
//     * Object model. Using an interactive session, users are able to open a persistent wsadmin
//     * session through which wsadmin commands and script files can be executed consecutively and
//     * programmitcally without multiple wsadmin invocations which are costly. This is the same as
//     * opening wsadmin in interactive mode on the command line.
//     *
//     * @param cell The {@link Cell} to get the wsadmin session from
//     * @return A {@link Wsadmin}
//     * @throws Exception
//     */
//    public static Wsadmin getProviderInstance(Cell cell) throws Exception {
//       ConnectionInfo connInfo = cell.getConnInfo();
//       if(!(connInfo instanceof WsadminConnectionOptions)) {
//           throw new IllegalArgumentException("The cell was not instantiated using a WsadminConnectionOptions. A WsadminConnectionOptions is required to make a wsadmin connection.");
//       }
//
//       WsadminConnectionOptions wsadminOptions = (WsadminConnectionOptions)cell.getConnInfo();
//       wsadminOptions.setLang("jython");
//       return new Wsadmin(wsadminOptions, true);
//    }
//
//    /**
//     * Get a cached session
//     *
//     * @param session The session to get
//     * @return The cached Wsadmin session
//     */
//    private static Wsadmin getCachedSession(Wsadmin session) {
//        final String method = "getCachedSession";
//        Log.entering(c, method, session);
//
//        for(Wsadmin cachedSession : sessionCache) {
//            if(cachedSession.equals(session)) {
//                Log.finer(c, method, "Found a matching session in the cache. Returning cached session.");
//                Log.exiting(c, "getCachedSession", cachedSession);
//                return cachedSession;
//            }
//        }
//
//        Log.finer(c, method, "A cached session was not found matching the requested session. Caching requested session.");
//        sessionCache.add(session);
//        Log.exiting(c, method, session);
//        return session;
//    }
//}
