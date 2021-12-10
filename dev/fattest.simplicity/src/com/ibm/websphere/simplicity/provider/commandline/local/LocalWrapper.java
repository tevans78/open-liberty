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

package com.ibm.websphere.simplicity.provider.commandline.local;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import com.ibm.websphere.simplicity.CommandLineProviderType;
import com.ibm.websphere.simplicity.ConnectionInfo;
import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.ProgramOutput;
import com.ibm.websphere.simplicity.RemoteFile;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProvider;

public class LocalWrapper extends CommandLineProvider {

    public static String LOCAL_HOSTNAME;
    public static String LOCAL_IP_ADDRESS;
    public static String LOCAL_IP_ADDRESS2 = "127.0.0.1";
    public static final String LOCALHOST = "localhost";
    public static LocalCommandLineProvider localProvider = new LocalCommandLineProvider();
    private final CommandLineProvider remoteProvider;

    private static final Class<?> c = LocalWrapper.class;

    static {
        try {
            LOCAL_HOSTNAME = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (Exception e) {
            LOCAL_HOSTNAME = "localhost";
        }
        try {
            LOCAL_IP_ADDRESS = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            LOCAL_IP_ADDRESS = LOCAL_IP_ADDRESS2;
        }
    }

    public LocalWrapper(CommandLineProvider remoteProvider) {
        super(remoteProvider.getCommandLineType());
        this.remoteProvider = remoteProvider;
    }

    @Override
    public void connect(ConnectionInfo connInfo) throws Exception {
        if (isLocal(connInfo.getHost(), this.remoteProvider)) {
            localProvider.connect(connInfo);
        } else {
            remoteProvider.connect(connInfo);
        }
    }

    @Override
    public boolean copy(RemoteFile sourceFile, RemoteFile destFile, boolean binary) throws Exception {
        if (isLocal(sourceFile.getMachine().getHostname(), this.remoteProvider) && isLocal(destFile.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.copy(sourceFile, destFile, binary);
        } else {
            return remoteProvider.copy(sourceFile, destFile, binary);
        }
    }

    @Override
    public boolean delete(RemoteFile file) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.delete(file);
        } else {
            return remoteProvider.delete(file);
        }
    }

    @Override
    public void disconnect(ConnectionInfo connInfo) throws Exception {
        if (isLocal(connInfo.getHost(), this.remoteProvider)) {
            localProvider.disconnect(connInfo);
        } else {
            remoteProvider.disconnect(connInfo);
        }
    }

    @Override
    public ProgramOutput executeCommand(Machine machine, String cmd, String[] parameters, String workDir, Properties envVars) throws Exception {
        if (isLocal(machine.getHostname(), this.remoteProvider)) {
            return localProvider.executeCommand(machine, cmd, parameters, workDir, envVars);
        } else {
            return remoteProvider.executeCommand(machine, cmd, parameters, workDir, envVars);
        }
    }

    @Override
    public ProgramOutput executeQSHCommand(Machine machine,
                                           String cmd,
                                           String[] parameters,
                                           String workDir,
                                           Properties envVars) throws Exception {
        if (isLocal(machine.getHostname(), this.remoteProvider)) {
            return localProvider.executeQSHCommand(machine, cmd, parameters, workDir, envVars);
        } else {
            return remoteProvider.executeQSHCommand(machine, cmd, parameters, workDir, envVars);
        }
    }

    @Override
    public boolean exists(RemoteFile file) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.exists(file);
        } else {
            return remoteProvider.exists(file);
        }
    }

    @Override
    public String getOSName(Machine machine) throws Exception {
        if (isLocal(machine.getHostname(), this.remoteProvider)) {
            return localProvider.getOSName(machine);
        } else {
            return remoteProvider.getOSName(machine);
        }
    }

    @Override
    public boolean isDirectory(RemoteFile dir) throws Exception {
        if (isLocal(dir.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.isDirectory(dir);
        } else {
            return remoteProvider.isDirectory(dir);
        }
    }

    @Override
    public boolean isFile(RemoteFile file) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.isFile(file);
        } else {
            return remoteProvider.isFile(file);
        }
    }

    @Override
    public String[] list(RemoteFile file, boolean recursive) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.list(file, recursive);
        } else {
            return remoteProvider.list(file, recursive);
        }
    }

    @Override
    public boolean mkdir(RemoteFile dir) throws Exception {
        if (isLocal(dir.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.mkdir(dir);
        } else {
            return remoteProvider.mkdir(dir);
        }
    }

    @Override
    public boolean mkdirs(RemoteFile dir) throws Exception {
        if (isLocal(dir.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.mkdirs(dir);
        } else {
            return remoteProvider.mkdirs(dir);
        }
    }

    @Override
    public boolean isConnected(ConnectionInfo connInfo) throws Exception {
        if (isLocal(connInfo.getHost(), this.remoteProvider)) {
            return localProvider.isConnected(connInfo);
        } else {
            return remoteProvider.isConnected(connInfo);
        }
    }

    @Override
    public String getTempDir(ConnectionInfo connInfo) throws Exception {
        if (isLocal(connInfo.getHost(), this.remoteProvider)) {
            return localProvider.getTempDir(connInfo);
        } else {
            return remoteProvider.getTempDir(connInfo);
        }
    }

    @Override
    public void killProcess(ConnectionInfo connInfo, int processId) throws Exception {
        if (isLocal(connInfo.getHost(), this.remoteProvider)) {
            localProvider.killProcess(connInfo, processId);
        } else {
            remoteProvider.killProcess(connInfo, processId);
        }
    }

//    public static boolean isLocal(String hostname, CommandLineProvider remoteProvider) throws Exception {
//        final String method = "isLocal";
//        Log.entering(c, method, new Object[]{hostname, remoteProvider});
//        Log.finer(c, method, "LOCAL_HOSTNAME: " + LOCAL_HOSTNAME);
//        Log.finer(c, method, "LOCAL_IP_ADDRESS: " + LOCAL_IP_ADDRESS);
//        Log.finer(c, method, "LOCAL_IP_ADDRESS2: " + LOCAL_IP_ADDRESS2);
//        boolean local = ((LOCAL_HOSTNAME.equalsIgnoreCase(hostname)) || (LOCALHOST.equalsIgnoreCase(hostname))
//                || (LOCAL_IP_ADDRESS.equals(hostname)) || (LOCAL_IP_ADDRESS2.equals(hostname)));
//        if(!local && (remoteProvider != null) && (remoteProvider.getCommandLineType() == CommandLineProviderType.LOCAL)) {
//            throw new Exception("The " + CommandLineProviderType.LOCAL.getClassName() + " command line provider is being used and this is not a local command line operation.");
//        }
//        Log.exiting(c, method, local);
//        return local;
//    }

    private static final HashMap<String, Boolean> HOSTNAMES = new HashMap<String, Boolean>();

    public static boolean isLocal(String hostname, CommandLineProvider remoteProvider) throws Exception {
        final String method = "isLocal";
        Log.entering(c, method, new Object[] { hostname, remoteProvider });
        Boolean local = HOSTNAMES.get(hostname);
        if (local == null) {
            if (hostname == null) {
                local = Boolean.FALSE;
            } else {
                local = isThisMyIpAddress(hostname);
            }
            HOSTNAMES.put(hostname, local);
        }
        boolean result = local.booleanValue();
        if (!result && (remoteProvider != null) && (remoteProvider.getCommandLineType() == CommandLineProviderType.LOCAL)) {
            throw new Exception("The " + CommandLineProviderType.LOCAL.getClassName() + " command line provider is being used and this is not a local command line operation.");
        }
        Log.exiting(c, method, local);
        return result;
    }

    public static Boolean isThisMyIpAddress(String hostname) {
        try {
            for (InetAddress address : InetAddress.getAllByName(hostname)) {
                if (isThisMyIpAddress(address)) {
                    return Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            // probably UnknownHostException; log a message just in case
            Log.finer(c, "isThisMyIpAddress", e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    public static boolean isThisMyIpAddress(InetAddress addr) {
        // Check if the address is a valid special local or loop back
        if (addr.isAnyLocalAddress() || addr.isLoopbackAddress())
            return true;

        // Check if the address is defined on any interface
        try {
            return NetworkInterface.getByInetAddress(addr) != null;
        } catch (SocketException e) {
            // probably unable to communicate with the addr; log a message just in case
            Log.finer(c, "isThisMyIpAddress", e.getMessage());
            return false;
        }
    }

    public CommandLineProvider getRemoteProvider() {
        return this.remoteProvider;
    }

    @Override
    public InputStream openFileForReading(RemoteFile file) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.openFileForReading(file);
        } else {
            return remoteProvider.openFileForReading(file);
        }
    }

    @Override
    public OutputStream openFileForWriting(RemoteFile file, boolean append) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.openFileForWriting(file, append);
        } else {
            return remoteProvider.openFileForWriting(file, append);
        }
    }

    /**
     * Determines the path to an input File, if it exists.
     *
     * @param file
     *                 The file you want a String representation of
     * @return null if the input File is null, else the Canonical path to the
     *         file. If the canonical path cannot be determined, the absolute
     *         path to the File is returned.
     */
    public static final String getFilePath(final File file) {
        if (file == null) {
            return null;
        } else {
            try {
                return file.getCanonicalPath();
            } catch (IOException e) {
                return file.getAbsolutePath();
            }
        }
    }

    @Override
    public long getFileSize(RemoteFile file) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider)) {
            return localProvider.getFileSize(file);
        } else {
            return remoteProvider.getFileSize(file);
        }
    }

    @Override
    public RemoteFile ensureFileIsOnMachine(Machine target, RemoteFile file) throws Exception {
        if (isLocal(file.getMachine().getHostname(), this.remoteProvider) && isLocal(target.getHostname(), this.remoteProvider)) {
            return localProvider.ensureFileIsOnMachine(target, file);
        } else {
            return remoteProvider.ensureFileIsOnMachine(target, file);
        }
    }

    @Override
    public Date getDate(Machine machine) throws Exception {
        if (isLocal(machine.getHostname(), this.remoteProvider)) {
            return localProvider.getDate(machine);
        } else {
            return remoteProvider.getDate(machine);
        }
    }

    @Override
    public String getRawProcessorArch(Machine machine) throws Exception {
        if (isLocal(machine.getHostname(), this.remoteProvider)) {
            return localProvider.getRawProcessorArch(machine);
        } else {
            return remoteProvider.getRawProcessorArch(machine);
        }
    }

}
