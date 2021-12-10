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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ibm.websphere.simplicity.CommandLineProviderType;
import com.ibm.websphere.simplicity.ConnectionInfo;
import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.OperatingSystem;
import com.ibm.websphere.simplicity.ProgramOutput;
import com.ibm.websphere.simplicity.RemoteFile;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.commandline.CommandLineProvider;

public class LocalCommandLineProvider extends CommandLineProvider {

    private static final Class<?> c = LocalCommandLineProvider.class;

    public LocalCommandLineProvider() {
        super(CommandLineProviderType.LOCAL);
    }

    @Override
    public boolean copy(RemoteFile sourceFile, RemoteFile destFile, boolean binary) throws Exception {
        File src = new File(sourceFile.getAbsolutePath());
        File dest = new File(destFile.getAbsolutePath());
        if (dest.exists() && dest.isDirectory()) {
            dest = new File(destFile.getAbsolutePath() + File.separatorChar + src.getName());
        } else if (!dest.exists())
            dest.getParentFile().mkdirs();
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        int read;
        try {
            byte[] buffer = new byte[8192];
            while ((read = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, read);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
                // let it go
            }
            try {
                fos.close();
            } catch (Exception e) {
                // let it go
            }
        }

        return dest.exists();
    }

    @Override
    public boolean delete(RemoteFile file) throws Exception {
        File f = new File(file.getAbsolutePath());
        if (f.isFile())
            return f.delete();
        else {
            // recursive delete
            deleteFolder(f);
            return !f.exists();
        }
    }

    private void deleteFolder(File folder) throws Exception {
        if (!folder.exists())
            return;

        for (File f : folder.listFiles()) {
            if (f.isFile())
                f.delete();
            else
                deleteFolder(f);
        }
        folder.delete();
    }

    @Override
    public ProgramOutput executeCommand(Machine machine, String cmd, String[] parameters, String workDir, Properties envVars) throws Exception {
        ByteArrayOutputStream bufferOut = new ByteArrayOutputStream();
        ByteArrayOutputStream bufferErr = new ByteArrayOutputStream();
        int rc = execute(machine, cmd, parameters, envVars, workDir, bufferOut, bufferErr, false);
        ProgramOutput ret = new ProgramOutput(cmd, rc, bufferOut.toString(), bufferErr.toString());
        return ret;
    }

    @Override
    public ProgramOutput executeQSHCommand(Machine machine,
                                           String cmd,
                                           String[] parameters,
                                           String workDir,
                                           Properties envVars) throws Exception {
        ByteArrayOutputStream bufferOut = new ByteArrayOutputStream();
        ByteArrayOutputStream bufferErr = new ByteArrayOutputStream();
        int rc = execute(machine, cmd, parameters, envVars, workDir, bufferOut, bufferErr, true);
        ProgramOutput ret = new ProgramOutput(cmd, rc, bufferOut.toString(), bufferErr.toString());
        return ret;
    }

    private int execute(Machine machine, final String command, final String[] parameterArray, Properties envp, final String workDir, final OutputStream stdOutStream,
                        final OutputStream stdErrStream, boolean isQSH) throws Exception {
        final String method = "execute";
        Log.entering(c, method, new Object[] { machine, command, parameterArray, envp, workDir, stdOutStream, stdErrStream });
        if (command == null) {
            throw new IllegalArgumentException("command cannot be null.");
        }
        String cmd = command;
        if (parameterArray != null) {
            for (int i = 0; i < parameterArray.length; i++) {
                cmd += (" " + parameterArray[i]);
            }
        }
        Log.finer(c, method, "cmd: " + cmd);

        /*
         * Windows does not permit execution of batch files directly through Runtime.exec.
         * We have to wrap the call to the batch file with a call to "cmd /c".
         */
        if (machine.getOperatingSystem() == OperatingSystem.WINDOWS && !cmd.startsWith("cmd")) {
            cmd = "cmd /c " + cmd;
            Log.finer(c, method, "cmd: " + cmd);
        }

        // By default, the subprocess should inherit the working directory of the current process
        File dir = null;
        if (workDir != null) {
            dir = new File(workDir);
            if (!dir.isDirectory()) {
                dir = null;
            }
        }
        Log.finer(c, method, "workDir: " + dir);

        /*
         * make sure SystemRoot is defined. For some reason on WindowsXP this disappears when
         * passing in evn variables causing socket issues
         */
        if (envp != null && machine.getOperatingSystem() == OperatingSystem.WINDOWS) {
            Log.finer(c, method, "Setting SystemRoot for Windows.");
            boolean systemRootFound = false;
            for (Object p : envp.keySet()) {
                // first check if the user defined it. most likely not
                if (envp.get(p) != null && ((String) envp.get(p)).startsWith("SystemRoot")) {
                    systemRootFound = true;
                    break;
                }
            }
            if (!systemRootFound) {
                // not user defined, so lets make sure it stays set. most likely scenario
                String systemRoot = System.getenv("SystemRoot");
                envp.setProperty("SystemRoot", systemRoot);
            }
        }

        // convert the Properties Object to a String array
        String[] envVars = null;
        if (envp != null) {
            Map<String, String> tmp = new HashMap<String, String>();
            tmp.put("SimplicityEnvVariable", "SimplicityEnvVariable");
            for (Map.Entry<Object, Object> p : envp.entrySet()) {
                tmp.put((String) p.getKey(), (String) p.getValue());
            }

            envVars = new String[tmp.entrySet().size()];
            int i = 0;
            for (Map.Entry<String, String> p : tmp.entrySet()) {
                envVars[i] = p.getKey() + "=" + p.getValue();
                ++i;
            }
        }

        if (machine.getOperatingSystem() == OperatingSystem.ISERIES) {
            if (isQSH)
                System.setProperty("os400.runtime.exec", "QSHELL");
            else
                System.setProperty("os400.runtime.exec", "EXEC");
        }

        // execute the command
        Log.finer(c, method, "cmd: " + cmd + ", envVars: " + envVars + ", dir: " + dir);
        Process proc = Runtime.getRuntime().exec(cmd, envVars, dir);
        StreamGobbler outputGobbler = null;
        StreamGobbler errorGobbler = null;
        if (machine.getOperatingSystem() == OperatingSystem.ISERIES && isQSH) {
            outputGobbler = new StreamGobbler(proc.getInputStream(), stdOutStream, false, Charset.forName("IBM037"));
            errorGobbler = new StreamGobbler(proc.getErrorStream(), stdErrStream, false, Charset.forName("IBM037"));
        } else {
            outputGobbler = new StreamGobbler(proc.getInputStream(), stdOutStream, false);
            errorGobbler = new StreamGobbler(proc.getErrorStream(), stdErrStream, false);
        }

        // listen to subprocess output
        outputGobbler.start();
        errorGobbler.start();

        // wait till completion
        proc.waitFor();
        // let the streams catch up (critical step)
        outputGobbler.join();
        errorGobbler.join();

        if (machine.getOperatingSystem() == OperatingSystem.ISERIES) {
            System.setProperty("os400.runtime.exec", "EXEC");
        }

        int exitValue = proc.exitValue();
        Log.exiting(c, method, exitValue);
        return exitValue;
    }

    @Override
    public boolean exists(RemoteFile file) throws Exception {
        File f = new File(file.getAbsolutePath());
        return f.exists();
    }

    @Override
    public String getOSName(Machine machine) throws Exception {
        return System.getProperty("os.name");
    }

    @Override
    public boolean isDirectory(RemoteFile dir) throws Exception {
        File f = new File(dir.getAbsolutePath());
        return f.isDirectory();
    }

    @Override
    public boolean isFile(RemoteFile file) throws Exception {
        File f = new File(file.getAbsolutePath());
        return f.isFile();
    }

    @Override
    public String[] list(RemoteFile file, boolean recursive) throws Exception {
        File f = new File(file.getAbsolutePath());
        List<String> list = new ArrayList<String>();
        String[] children = listDirectory(f);
        for (int i = 0; i < children.length; i++) {
            File child = new File(f, children[i]);
            list.add(child.getAbsolutePath());
            if (recursive && child.isDirectory()) {
                RemoteFile childKey = new RemoteFile(file.getMachine(), child.getAbsolutePath());
                String[] grandchildren = list(childKey, recursive);
                for (int k = 0; k < grandchildren.length; ++k) {
                    list.add(grandchildren[k]);
                }
            }
        }
        return list.toArray(new String[0]);
    }

    private final String[] listDirectory(File directory) {
        File[] files = directory.listFiles();
        String[] result = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            result[i] = files[i].getName();
        }
        return result;
    }

    @Override
    public boolean mkdir(RemoteFile dir) throws Exception {
        File f = new File(dir.getAbsolutePath());
        return f.mkdir();
    }

    @Override
    public boolean mkdirs(RemoteFile dir) throws Exception {
        File f = new File(dir.getAbsolutePath());
        return f.mkdirs();
    }

    @Override
    public void connect(ConnectionInfo connInfo) throws Exception {
        // do nothing
    }

    @Override
    public void disconnect(ConnectionInfo connInfo) throws Exception {
        // do nothing
    }

    @Override
    public boolean isConnected(ConnectionInfo connInfo) throws Exception {
        return true;
    }

    @Override
    public String getTempDir(ConnectionInfo connInfo) throws Exception {
        return System.getProperty("java.io.tmpdir");
    }

    @Override
    public long getFileSize(RemoteFile file) throws Exception {
        File f = new File(file.getAbsolutePath());
        return f.length();
    }

    @Override
    public InputStream openFileForReading(RemoteFile file) throws Exception {
        return new FileInputStream(file.getAbsolutePath());
    }

    @Override
    public OutputStream openFileForWriting(RemoteFile file, boolean append) throws Exception {
        return new FileOutputStream(file.getAbsolutePath(), append);
    }

    @Override
    // TODO make sure this works on iSeries
    public void killProcess(ConnectionInfo connInfo, int processId) throws Exception {
        final String method = "killProcess";
        Log.entering(c, method, new Object[] { connInfo, processId });
        Machine localMachine = Machine.getLocalMachine();
        String cmd = null;
        String[] parameters = null;
        if (localMachine.getOperatingSystem() != OperatingSystem.WINDOWS) {
            cmd = "kill";
            parameters = new String[] { "-9", "" + processId };
        } else {
            cmd = "taskkill";
            parameters = new String[] { "/F", "/PID", "" + processId };
        }
        Log.finer(c, method, cmd, parameters);
        this.executeCommand(localMachine, cmd, parameters, null, null);
        Log.exiting(c, method);
    }

    @Override
    public RemoteFile ensureFileIsOnMachine(Machine target, RemoteFile file) throws Exception {
        if ((target.getHostname() != null && !LocalWrapper.isLocal(target.getHostname(), null))
            || (file.getMachine().getHostname() != null && !LocalWrapper.isLocal(file.getMachine().getHostname(), null)))
            throw new Exception("A remote provider is required to transfer files between physical machines.");
        // If we're here, the file already exists on the local machine
        return file;
    }

    @Override
    public Date getDate(Machine machine) throws Exception {
        return new Date(System.currentTimeMillis());
    }

    @Override
    public String getRawProcessorArch(Machine machine) throws Exception {
        return System.getProperty("os.arch");
    }

}
