/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.websphere.simplicity.provider.commandline;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import com.ibm.websphere.simplicity.Cell;
import com.ibm.websphere.simplicity.CommandLineProviderType;
import com.ibm.websphere.simplicity.ConnectionInfo;
import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.OperatingSystem;
import com.ibm.websphere.simplicity.ProgramOutput;
import com.ibm.websphere.simplicity.RemoteFile;
import com.ibm.websphere.simplicity.Server;
import com.ibm.websphere.simplicity.Topology;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.Provider;

public abstract class CommandLineProvider extends Provider {
    
    private static final Class<?> c = CommandLineProvider.class;
    
    public CommandLineProvider(CommandLineProviderType type) {
        super(type);
    }

    public abstract boolean copy(RemoteFile sourceFile, RemoteFile destFile, boolean binary) throws Exception;
    public abstract boolean delete(RemoteFile file) throws Exception ;
    public abstract boolean isDirectory(RemoteFile dir) throws Exception;
    public abstract boolean isFile(RemoteFile file) throws Exception;
    public abstract boolean exists(RemoteFile file) throws Exception;
    public abstract String[] list(RemoteFile file, boolean recursive) throws Exception;
    public abstract boolean mkdir(RemoteFile dir) throws Exception;
    public abstract boolean mkdirs(RemoteFile dir) throws Exception;
    public abstract String getOSName(Machine machine) throws Exception;
    public abstract ProgramOutput executeCommand(Machine machine, String cmd, String[] parameters, String workDir, Properties envVars) throws Exception ;
    public abstract ProgramOutput executeQSHCommand(Machine machine, String cmd, String[] parameters, String workDir, Properties envVars) throws Exception ;
    public abstract void connect(ConnectionInfo connInfo) throws Exception;
    public abstract void disconnect(ConnectionInfo connInfo) throws Exception;
    public abstract boolean isConnected(ConnectionInfo connInfo) throws Exception;
    public abstract String getTempDir(ConnectionInfo connInfo) throws Exception;
    public abstract void killProcess(ConnectionInfo connInfo, int processId) throws Exception;
    public abstract Date getDate(Machine machine) throws Exception;
    public abstract long getFileSize(RemoteFile file) throws Exception;
    public abstract String getRawProcessorArch(Machine machine) throws Exception;

    /**
     * Transfers the file, if necessary, to the target machine for use on that machine.
     * @param target
     * @param file
     * @return The RemoteFile after it has been transferred
     * @throws Exception
     */
    public abstract RemoteFile ensureFileIsOnMachine(Machine target, RemoteFile file) throws Exception;
    public abstract InputStream openFileForReading(RemoteFile file) throws Exception;
    public abstract OutputStream openFileForWriting(RemoteFile file, boolean append) throws Exception;

    public String startServer(Server server) throws Exception {
        Log.entering(c, "startServer", server);
        String result = startStopServer("startServer", server);
        Log.exiting(c, "startServer", result);
        return result;
    }
    
    public String stopServer(Server server) throws Exception {
        Log.entering(c, "stopServer", server);
        String result = startStopServer("stopServer", server);
        Log.exiting(c, "stopServer", result);
        return result;
    }
    
    private String startStopServer(String operation, Server server) throws Exception {
        final String method = "startStopServer";
        Log.entering(c, method, new Object[]{operation, server});
        
        Machine machine = null;
        String profileDir = null;
        try {
        	machine = server.getNode().getMachine();
        	profileDir = server.getNode().getProfileDir();
        }
        catch(Exception e) {
        	// A connection to the server is probably not available
            Log.finer(c, method, "An Exception was thrown trying to get the machine and profile directory. Attempting to retrieve from the connectionInfo.");
        	Cell c = server.getCell();
            c.disconnect();
        	if (c.getManager().equals(server)) {
        		// Then we can use connInfo values to populate
        		String host = c.getConnInfo().getHost();
        		ConnectionInfo connInfo = Topology.getBootstrapFileOps().getMachineConnectionInfo(host);
                machine = Machine.getMachine(connInfo);
                profileDir = c.getConnInfo().getProfileDir();
        	} else
        		// Otherwise, we're stuck, and can't move forward
        		throw e;
        }
        String scriptFile = profileDir + "/bin/" + operation + machine.getOperatingSystem().getDefaultScriptSuffix();
        Log.finer(c, method, operation + " scriptFile: " + scriptFile);
        String[] parameters = null;
        if("stopServer".equals(operation)
        		&& (server.getConnInfo().getUser() != null && server.getConnInfo().getPassword() != null)) {
            parameters = new String[5];
            parameters[1] = "-username";
            parameters[2] = server.getConnInfo().getUser();
            parameters[3] = "-password";
            parameters[4] = server.getConnInfo().getPassword();
        } else {
            parameters = new String[1];
        }
        parameters[0] = server.getName();
        
        Log.finer(c, method, "cmd: " + parameters.length);
        ProgramOutput output = null;
        if(machine.getOperatingSystem().equals(OperatingSystem.ISERIES))
            output = this.executeQSHCommand(machine, scriptFile, parameters, null, null);
        else
            output = this.executeCommand(machine, scriptFile, parameters, null, null);
        
        String result = null;
        if (output.getStderr().length() > 0)
        	result = output.getStderr();
        else
        	result = output.getStdout();
        
        Log.exiting(c, method, result);
        return result;
    }
    
}
