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
import java.util.StringTokenizer;

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.config.ConfigObject;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;
import com.ibm.websphere.simplicity.provider.websphere.ConfigurationOperationsProvider;
import com.ibm.websphere.simplicity.runtime.PluginCfgGeneratorMBean;
import com.ibm.websphere.simplicity.runtime.ProcessStatus;
import com.ibm.websphere.simplicity.runtime.WebServerMBean;

public class WebServer extends Server {

    private static final Class<?> c = WebServer.class;

    private WebServerMBean mbean;
    private PluginCfgGeneratorMBean cfgmbean;
    private String installRoot;
    private String pluginInstallRoot;
    private String configPath;
    private ConfigObject processDef;
    protected String startCommand;
    protected String[] startCommandArgs;
    protected String stopCommand;
    protected String[] stopCommandArgs;

    protected WebServer(ConfigIdentifier configId,
                        Cell cell,
                        Node node,
                        ArrayList<AttributeList> portInitData) throws Exception {
        super(configId, cell, node, ServerType.WEB_SERVER, portInitData);

        // pre load the commands and args
        getStartStopCommandsAndArgs();
    }

    protected WebServer(ConfigIdentifier configId,
                        Cell cell,
                        Node node,
                        ArrayList<AttributeList> portInitData,
                        String startCmd,
                        String[] startArgs,
                        String stopCmd,
                        String[] stopArgs) throws Exception {
        super(configId, cell, node, ServerType.WEB_SERVER, portInitData);
        this.startCommand = startCmd;
        this.startCommandArgs = startArgs;
        this.stopCommand = stopCmd;
        this.stopCommandArgs = stopArgs;
    }

    @Override
    public ProcessStatus getServerStatus() throws Exception {
        final String method = "getServerStatus";
        Log.entering(c, method);

        ProcessStatus ret = null;
        try {
            getMBeans();
            ret = mbean.status();
        } catch (Exception e) {
            Log.finer(c, method, "Unable to determine the status using MBeans.");
            ret = ProcessStatus.UNKOWN;
        }

        Log.exiting(c, method, ret);
        return ret;
    }

    public String getPluginConfigPath() throws Exception {
        if (configPath == null) {
            ConfigObject props = ConfigObject.getConfigObject(this, "PluginProperties");
            ConfigObject attrib = props.getAttributeByName("RemoteConfigFilename");
            if (attrib != null)
                configPath = attrib.getValueAsString();
            else
                throw new Exception("Unable to find install root");
        }
        return configPath;
    }

    protected void setPluginConfigPath(String path) {
        this.configPath = path;
    }

    /**
     * Generate the plugin configuration file.
     *
     * @param propagate Propagate the config file.
     * @throws Exception
     */
    public void generatePluginConfigFile(boolean propagate) throws Exception {
        getMBeans();
        cfgmbean.generate(propagate);
    }

    /**
     * Generate the plugin configuration file.
     *
     * @param outputFileName The name of the plugin cfg file.
     * @throws Exception
     */
    public void generatePluginConfigFile(String outputFileName) throws Exception {
        getMBeans();
        cfgmbean.generate(outputFileName);
    }

    /**
     * Generate the plugin configuration file.
     *
     * @param outputFileName  The name of the plugin cfg file.
     * @param destinationRoot An alternate root directory for the log file
     *                            location and the keyfile/stashfiles.
     * @param destinationOS   The operating system of the destination system.
     * @throws Exception
     */
    public void generatePluginConfigFile(String outputFileName,
                                         String destinationRoot,
                                         String destinationOS) throws Exception {
        getMBeans();
        cfgmbean.generate(outputFileName, destinationRoot, destinationOS);
    }

    /**
     * Propagate the config file.
     *
     * @throws Exception
     */
    public void propagatePluginConfigFile() throws Exception {
        getMBeans();
        cfgmbean.propagate();
    }

    public String getPluginInstallRoot() throws Exception {
        if (pluginInstallRoot == null) {
            ConfigObject props = ConfigObject.getConfigObject(this, "PluginProperties");
            ConfigObject attrib = props.getAttributeByName("PluginInstallRoot");
            if (attrib != null)
                pluginInstallRoot = attrib.getValueAsString();
            else
                throw new Exception("Unable to find plugin install root");
        }
        return pluginInstallRoot;
    }

    protected void setPluginInstallRoot(String installRoot) {
        this.pluginInstallRoot = installRoot;
    }

    public String getInstallRoot() throws Exception {
        if (installRoot == null) {
            ConfigObject props = ConfigObject.getConfigObject(this, "WebServer");
            ConfigObject attrib = props.getAttributeByName("webserverInstallRoot");
            if (attrib != null)
                installRoot = attrib.getValueAsString();
            else
                throw new Exception("Unable to find web server install root");
        }
        return installRoot;
    }

    protected void setInstallRoot(String installRoot) {
        this.installRoot = installRoot;
    }

    @Override
    public void start() throws Exception {
        start(10);
    }

    @Override
    public void start(int mbeanWaitDuration) throws Exception {
        final String method = "start";
        Log.entering(c, method, mbeanWaitDuration);

        start(mbeanWaitDuration, false);

        Log.exiting(c, method);
    }

    @Override
    protected void start(int mbeanWaitDuration, boolean async) throws Exception {
        final String method = "start";
        Log.entering(c, method, new Object[] { mbeanWaitDuration, async });

        if (this.getServerStatus().equals(ProcessStatus.RUNNING)) {
            Log.finer(c, method, "Web server " + this.getName() + " is already running.");
            return;
        }

        if (async && OperationsProviderFactory.getProvider().getOperationsType().equals(OperationsProviderType.WSADMIN)) {
            // only need to do this for the wsadmin provider to achieve an
            // asynchronous start
            commandLineStart(async);
        } else {
            try {
                getMBeans();
                this.mbean.start();
            } catch (Exception e) {
                Log.finer(c, method, "An error occurred starting web server " + this.getName()
                                     + " using MBeans. Attempting to use the command line.");
                commandLineStart(false);
            }
        }

        try {
            getMBeans();
            this.mbean.start();
        } catch (Exception e) {
            Log.finer(c, method, "An error occurred starting web server " + this.getName()
                                 + " using MBeans. Attempting to use the command line.");
            getStartStopCommandsAndArgs();
            if (startCommand.trim().length() == 0)
                throw new Exception("Could not start the server, no start command known.");
            this.getNode().getMachine().execute(startCommand, startCommandArgs);
        }

        // Make sure that when we get here the server really did start
        if (this.getServerStatus().equals(ProcessStatus.STOPPED)) { // allow
            // unknown
            throw new Exception("The server failed to start, but no exceptions were thrown in the process.");
        }

        Log.exiting(c, method);
    }

    private void commandLineStart(boolean async) throws Exception {
        final String method = "commandLineStart";
        Log.entering(c, method, async);
        if (startCommand.trim().length() == 0)
            throw new Exception("Could not start the server, no start command known.");
        if (!async)
            this.getNode().getMachine().execute(startCommand, startCommandArgs);
        else {
            AsyncProgramOutput po = this.getNode().getMachine().executeAsync(startCommand, startCommandArgs);
            if (po.getStderr() != null && po.getStderr().trim().length() != 0) {
                throw new Exception(po.getStderr());
            }
        }
        Log.exiting(c, method);
    }

    private void commandLineStop(boolean async) throws Exception {
        final String method = "commandLineStop";
        Log.entering(c, method, async);
        if (stopCommand.trim().length() == 0)
            throw new Exception("Could not stop the server, no stop command known.");
        if (!async)
            this.getNode().getMachine().execute(stopCommand, stopCommandArgs);
        else {
            AsyncProgramOutput po = this.getNode().getMachine().executeAsync(stopCommand, stopCommandArgs);
            if (po.getStderr() != null && po.getStderr().trim().length() != 0) {
                throw new Exception(po.getStderr());
            }
        }
        Log.exiting(c, method);
    }

    private ConfigObject getProcessDef() throws Exception {
        if (processDef == null) {
            processDef = ConfigObject.getConfigObject(this.getNode(), this.getConfigId(), "ProcessDef");
        }
        return processDef;
    }

    protected void getStartStopCommandsAndArgs() throws Exception {
        if (startCommand != null)
            return;

        final String method = "getStartStopCommand";
        Log.entering(c, method);

        ConfigurationOperationsProvider provider = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider();
        AttributeList attributes = provider.getAttributes(this,
                                                          getActiveSession(),
                                                          getProcessDef().getConfigIdentifier(),
                                                          new String[] { "startCommand", "startCommandArgs", "stopCommand",
                                                                         "stopCommandArgs" },
                                                          false);
        for (Object o : attributes) {
            Attribute a = (Attribute) o;
            if (a.getName().equalsIgnoreCase("startCommand")) {
                startCommand = (String) a.getValue();
                startCommand = expandCommand(startCommand);
            } else if (a.getName().equalsIgnoreCase("startCommandArgs"))
                startCommandArgs = ((ArrayList<String>) a.getValue()).toArray(new String[] {});
            else if (a.getName().equalsIgnoreCase("stopCommand")) {
                stopCommand = (String) a.getValue();
                stopCommand = expandCommand(stopCommand);
            } else if (a.getName().equalsIgnoreCase("stopCommandArgs"))
                stopCommandArgs = ((ArrayList<String>) a.getValue()).toArray(new String[] {});
        }
        Log.exiting(c, method);
    }

    protected void setStartCommand(String cmd, String[] args) {
        this.startCommand = cmd;
        this.startCommandArgs = args;
    }

    protected void setStopCommand(String cmd, String[] args) {
        this.stopCommand = cmd;
        this.stopCommandArgs = args;
    }

    protected String expandCommand(String cmd) throws Exception {
        if (cmd.trim().length() == 0)
            return "";
        String command = cmd.replace('\\', '/');
        String ret;
        if (command.startsWith("/"))
            ret = "/";
        else
            ret = "";
        boolean hasVars = false;
        StringTokenizer st = new StringTokenizer(command, "\r\n\t\f\\/");
        String next = null;
        while (st.hasMoreTokens()) {
            next = st.nextToken();
            if ((next.startsWith("${") && next.endsWith("}")) || (next.startsWith("$(") && next.endsWith(")"))) {
                hasVars = true;
                next = OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().expandVariable(this,
                                                                                                                   next.substring(2, next.length() - 1),
                                                                                                                   this.getActiveSession());
            }
            ret += (next + "/");
        }
        ret = ret.substring(0, ret.length() - 1);
        if (hasVars)
            return expandCommand(ret);
        else
            return ret;
    }

//    private List<String> argsToList(Object args) {
//        List<String> ret = new ArrayList<String>();
//        if (args instanceof String) {
//            StringTokenizer st = new StringTokenizer((String)args, "\r\n\t\f;[], ");
//            while (st.hasMoreTokens()) {
//                String next = st.nextToken();
//                String[] arguments = next.split(" ");
//                for (int i = 0; i < arguments.length; ++i)
//                    ret.add(arguments[i]);
//            }
//            return ret;
//        } else if (args instanceof AttributeList) {
//            AttributeList l = (AttributeList)args;
//            for (Object o : l) {
//                String[] arguments = ((String)o).split(" ");
//                for (int i = 0; i < arguments.length; ++i)
//                    ret.add(arguments[i]);
//            }
//        }
//        return ret;
//    }

    @Override
    public void stop() throws Exception {
        stop(10);
    }

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
        if (this.getServerStatus().equals(ProcessStatus.STOPPED)) {
            Log.exiting(c, method, "Server already stopped");
            return;
        }

        if (async && OperationsProviderFactory.getProvider().getOperationsType().equals(OperationsProviderType.WSADMIN)) {
            // only need this to achieve wsadmin async stop
            commandLineStop(async);
        }
        try {
            getMBeans();
            this.mbean.stop();
        } catch (Exception e) {
            Log.finer(c, method, "An error occurred stopping web server " + this.getName()
                                 + " using MBeans. Attempting to use the command line.");
            getStartStopCommandsAndArgs();
            if (stopCommand.trim().length() == 0)
                throw new Exception("Could not stop the server, no stop command known.");
            this.getNode().getMachine().execute(stopCommand, stopCommandArgs);
        }

        while (this.getServerStatus().equals(ProcessStatus.RUNNING) && --timeout > 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        Thread.sleep(10 * 1000);
        Log.exiting(c, method);
    }

    private synchronized void getMBeans() throws Exception {
        if (this.cfgmbean == null) {
            ApplicationServer mgr = this.getCell().getManager();
            this.cfgmbean = new PluginCfgGeneratorMBean(mgr, this);
            this.mbean = new WebServerMBean(mgr, this);
        }
    }

    @Override
    public void resetServer() throws Exception {
        super.resetServer();
        this.mbean = null;
        this.cfgmbean = null;
        this.installRoot = null;
        this.pluginInstallRoot = null;
        this.configPath = null;
    }

    /**
     * Returns the String used by WebSphere to target entities such as
     * application modules to the WebServer
     *
     * @return The WebServer target mapping String
     */
    public String getMappingName() {
        return "WebSphere:cell=" + getCellName()
               + ",node="
               + getNode().getName()
               + ",server="
               + getName();
    }

}
