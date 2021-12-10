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

package com.ibm.websphere.simplicity.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.management.Attribute;
import javax.management.AttributeList;

import com.ibm.websphere.simplicity.Server;
import com.ibm.websphere.simplicity.commands.server.SetJVMProperties;
import com.ibm.websphere.simplicity.commands.server.ShowJVMProperties;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.websphere.simplicity.provider.OperationsProviderFactory;

/**
 * Provides a concrete API for modifying JVM settings in a server's server.xml file
 */
public class JavaVirtualMachine {
    
    public static final Class c = JavaVirtualMachine.class;
    
    private static Map<Server, JavaVirtualMachine> instances = new HashMap<Server, JavaVirtualMachine>();

    /**
     * A factory method for obtaining an instance of {@link JavaVirtualMachine} for a particular server.
     * @param server The server who's JVM properties will be managed
     * @return A {@link JavaVirtualMachine} instance of the specified server
     */
    public static JavaVirtualMachine getInstance(Server server) {
        JavaVirtualMachine jvm = instances.get(server);
        if(jvm == null) {
            jvm = new JavaVirtualMachine(server);
            instances.put(server, jvm);
        }
        return jvm;
    }
    
    private Server server;

    private JavaVirtualMachine(Server server) {
        this.server = server;
    }
    
    /**
     * Get whether to use verbose debug output for class loading
     * @return Whether to use verbose debug output for class loading
     * @throws Exception
     */
    public boolean getVerboseModeClass() throws Exception {
        return getBooleanJVMProperty("verboseModeClass");
    }
    
    /**
     * Set whether to use verbose debug output for class loading
     * @param verbose true if verbose debug output should be used; false otherwise
     * @throws Exception
     */
    public void setVerboseModeClass(boolean verbose) throws Exception {
        setJVMProperty("verboseModeClass", verbose);
    }
    
    /**
     * Get whether to use verbose debug output for garbage collection. The default is not to enable
     * verbose garbage collection. If verbose garbage collection is enabled, the debug output is
     * sent to one of the native process logs.
     * 
     * @return Whether to use verbose debug output for garbage collection
     * @throws Exception
     */
    public boolean getVerboseModeGarbageCollection() throws Exception {
        return getBooleanJVMProperty("verboseModeGarbageCollection");
    }
    
    /**
     * Set whether to use verbose debug output for garbage collection. If verbose garbage collection
     * is enabled, the debug output is sent to one of the native process logs.
     * 
     * @param verbose true to enable verbose debug output for garbage collection
     * @throws Exception
     */
    public void setVerboseModeGarbageCollection(boolean verbose) throws Exception {
        setJVMProperty("verboseModeGarbageCollection", verbose);
    }
    
    /**
     * Get whether to use verbose debug output for native method invocation. The default is not to
     * enable verbose Java Native Interface (JNI) activity.
     * 
     * @return Whether to use verbose debug output for native method invocation
     * @throws Exception
     */
    public boolean getVerboseModeJNI() throws Exception {
        return getBooleanJVMProperty("verboseModeJNI");
    }
    
    /**
     * Set whether to use verbose debug output for native method invocation.
     * 
     * @param value true to enable verbose output for native method invocation
     * @throws Exception
     */
    public void setVerboseModeJNI(boolean value) throws Exception {
        setJVMProperty("verboseModeJNI", value);
    }
    
    /**
     * Get whether to use HProf profiler support. The default is not to enable HProf profiler
     * support.
     * 
     * @return true if HProf support is enabled
     * @throws Exception
     */
    public boolean getRunHProf() throws Exception {
        return getBooleanJVMProperty("runHProf");
    }
    
    /**
     * Specifies whether to use HProf profiler support.
     * 
     * @param value true to use HProf profile support
     * @throws Exception
     */
    public void setRunHProf(boolean value) throws Exception {
        setJVMProperty("runHProf", value);
    }
    
    /**
     * Get the command-line profiler arguments to pass to the JVM code that starts the application
     * server process.
     * 
     * @return The command-line profiler arguments or null if not defined
     * @throws Exception
     */
    public String getHprofArguments() throws Exception {
        return getStringJVMProperty("hprofArguments");
    }
    
    /**
     * Set the command-line profiler arguments to pass to the JVM code that starts the application
     * server process.
     * 
     * @param args The arguments to set
     * @throws Exception
     */
    public void setHprofArguments(String args) throws Exception {
        setJVMProperty("hprofArguments", args);
    }
    
    /**
     * Get whether to run the JVM in debug mode. The default is to not enable debug mode support.
     * 
     * @return true if debug mode support is enabled
     * @throws Exception
     */
    public boolean getDebugMode() throws Exception {
        return getBooleanJVMProperty("debugMode");
    }
    
    /**
     * Set whether to run the JVM in debug mode. The default is to not enable debug mode support.
     * 
     * @param debugMode true to enable debug mode support; false otherwise
     * @throws Exception
     */
    public void setDebugMode(boolean debugMode) throws Exception {
        setJVMProperty("debugMode", debugMode);
    }
    
    /**
     * Get the command-line debug arguments to pass to the JVM code that starts the application
     * server process.
     * 
     * @return The command-line debug arguments
     * @throws Exception
     */
    public String getDebugArgs() throws Exception {
        return getStringJVMProperty("debugArgs");
    }
    
    /**
     * Set the command-line debug arguments to pass to the JVM code that starts the application
     * server process.
     * 
     * @param args The command-line arguments to set
     * @throws Exception
     */
    public void setDebugArgs(String args) throws Exception {
        setJVMProperty("debugArgs", args);
    }
    
    /**
     * Get the command-line arguments to pass to the Java virtual machine code that starts the
     * application server process.
     * 
     * @return The command-line arguments to pass to the jvm or null if not defined
     * @throws Exception
     */
    public String getGenericJvmArguments() throws Exception {
        return getStringJVMProperty("genericJvmArguments");
    }
    
    /**
     * Set the command-line arguments to pass to the Java virtual machine code that starts the
     * application server process.
     * 
     * @param args The args to set. If you enter more than one argument, enter a space between each
     *            argument.
     * @throws Exception
     */
    public void setGenericJvmArguments(String args) throws Exception {
        setJVMProperty("genericJvmArguments", args);
    }
    
    /**
     * Get the bootstrap classes and resources for JVM code. This option is only available for JVM
     * instructions that support bootstrap classes and resources.
     * 
     * @return The bootstrap classpath or null if one is not defined
     * @throws Exception
     */
    public String[] getBootClasspath() throws Exception {
        final String method = "getBootClasspath";
        Log.entering(c, method);
        List<String> classpath = getListJVMProperty("bootClasspath");
        String[] ret = classpath.toArray(new String[]{});
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Set the bootstrap classes and resources for JVM code. This option is only available for JVM
     * instructions that support bootstrap classes and resources.
     * 
     * @param classpath The classpath to set. Each element in the String array is a classpath entry
     * @throws Exception
     */
    public void setBootClasspath(String[] classpath) throws Exception {
        // first we need to clear the classpath otherwise WAS appends the new values
        ConfigObject jvm = ConfigObject.getConfigObject(this.server, this.server.getConfigId(), "JavaVirtualMachine");
        AttributeList list = new AttributeList();
        list.add(new Attribute("bootClasspath", ""));
        OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().unsetAttributes(this.server, this.server.getActiveSession(), jvm.getConfigIdentifier() , list);
        setJVMProperty("bootClasspath", classpath);
    }
    
    /**
     * Get the standard class path in which the Java virtual machine code looks for classes.
     * 
     * @return The classpath or null if one is not defined
     * @throws Exception
     */
    public String[] getClasspath() throws Exception {
        final String method = "getClasspath";
        Log.entering(c, method);
        List<String> classpath = getListJVMProperty("classpath");
        String[] ret = classpath.toArray(new String[]{});
        Log.exiting(c, method, ret);
        return ret;
    }
    
    /**
     * Set the standard class path in which the Java virtual machine code looks for classes.
     * 
     * @param classpath The classpath to set
     * @throws Exception 
     */
    public void setClasspath(String[] classpath) throws Exception {
        // first we need to clear the classpath otherwise WAS appends the new values
        ConfigObject jvm = ConfigObject.getConfigObject(this.server, this.server.getConfigId(), "JavaVirtualMachine");
        AttributeList list = new AttributeList();
        list.add(new Attribute("classpath", ""));
        OperationsProviderFactory.getProvider().getConfigurationOperationsProvider().unsetAttributes(this.server, this.server.getActiveSession(), jvm.getConfigIdentifier() , list);
        setJVMProperty("classpath", classpath);
    }
    
    /**
     * Get, in megabytes, the initial heap size available to the JVM code.
     * 
     * @return The initial heap size in megabytes or null if one is not defined
     * @throws Exception
     */
    public int getInitialHeapSize() throws Exception {
        return getIntegerJVMProperty("initialHeapSize");
    }
    
    /**
     * Set, in megabytes, the initial heap size available to the JVM code.
     *  
     * @param size The initial heap size to set
     * @throws Exception
     */
    public void setInitialHeapSize(int size) throws Exception {
        setJVMProperty("initialHeapSize", size);
    }
    
    /**
     * Get, in megabytes, the maximum heap size that is available to the JVM code.
     * 
     * @return The maximum heap size or null if not defined
     * @throws Exception
     */
    public int getMaximumHeapSize() throws Exception {
        return getIntegerJVMProperty("maximumHeapSize");
    }
    
    /**
     * Set, in megabytes, the maximum heap size that is available to the JVM code.
     * 
     * @param size The maxmimum heap size to set
     * @throws Exception
     */
    public void setMaximumHeapSize(int size) throws Exception {
        setJVMProperty("maximumHeapSize", size);
    }
    
    /**
     * Get the path name for an executable JAR file that the JVM code uses.
     * 
     * @return The executable jar file path name or null if not defined
     * @throws Exception
     */
    public String getExecutableJarFileName() throws Exception {
        return getStringJVMProperty("executableJarFileName");
    }
    
    /**
     * Get the full path name for an executable JAR file that the JVM code uses.
     * 
     * @param name The full path name for the executable to set
     * @throws Exception
     */
    public void setExecutableJarFileName(String name) throws Exception {
        setJVMProperty("executableJarFileName", name);
    }
    
    /**
     * Get whether to disable the just-in-time (JIT) compiler option of the JVM code.
     * 
     * @return true if JIT is disabled, false if not, or null if not defined
     * @throws Exception
     */
    public Boolean getDisableJIT() throws Exception {
        return getBooleanJVMProperty("disableJIT");
    }
    
    /**
     * Set whether to disable the just-in-time (JIT) compiler option of the JVM code. If you disable
     * the JIT compiler, throughput decreases noticeably. Therefore, for performance reasons, keep
     * JIT enabled.
     * 
     * @param disableJIT true to disable JIT
     * @throws Exception
     */
    public void setDisableJIT(boolean disableJIT) throws Exception {
        setJVMProperty("disableJIT", disableJIT);
    }
    
    /**
     * Get the JVM operating system name
     * 
     * @return The operating system name
     * @throws Exception
     */
    public String getOSName() throws Exception {
        return getStringJVMProperty("osName");
    }
    
    /**
     * Set the JVM operating system name
     * @param name The operating system name to set
     * @throws Exception
     */
    public void setOSName(String name) throws Exception {
        setJVMProperty("osName", name);
    }
    
    /**
     * Internal Class Access Mode
     * 
     * @return the Internal Class Access Mode
     * @throws Exception
     */
    public InternalClassAccessMode getInternalClassAccessMode()  throws Exception {
    	return InternalClassAccessMode.valueOf(getStringJVMProperty("internalClassAccessMode"));
    }
    
    /**
     * Internal Class Access Mode
     * 
     * @param mode The mode to set
     * @throws Exception
     */
    public void setInternalClassAccessMode(InternalClassAccessMode mode) throws Exception {
    	setJVMProperty("internalClassAccessMode", mode.toString());
    }
    
    /**
     * Get the system properties for the jvm
     * 
     * @return A Set containing the jvm system properties
     * @throws Exception
     */
    public Set<SystemProperty> getSystemProperties() throws Exception {
        ConfigObject jvm = getJVM();
        List<ConfigObject> sysProps = jvm.getChildObjectListByName("systemProperties");
        Set<SystemProperty> props = new HashSet<SystemProperty>();
        for(ConfigObject sysProp : sysProps) {
            props.add(getSystemProperty(sysProp));
        }
        return props;
    }
    
    /**
     * Get a {@link SystemProperty} for the JVM
     * 
     * @param name The name of the {@link SystemProperty} to get
     * @return A SystemProperty with the specified name or null if none exists
     * @throws Exception
     */
    public SystemProperty getSystemProperty(String name) throws Exception {
        if(name == null)
            throw new IllegalArgumentException("name parameter cannot be null.");
        ConfigObject jvm = getJVM();
        List<ConfigObject> sysProps = jvm.getChildObjectListByName("systemProperties");
        SystemProperty ret = null;
        for(ConfigObject sysProp : sysProps) {
            if(sysProp.getAttributeByName("name").getValueAsString().equals(name)) {
                ret = getSystemProperty(sysProp);
                break;
            }
        }
        return ret;
    }
    
    /**
     * This method can be used to create or alter a system property. If a system property with the
     * specified name does not yet exist, it will be created. Otherwise the attributes will be
     * updated.
     * 
     * @param name The name of the property to create or update
     * @param value The value of the property
     * @param description The description of the property
     * @throws Exception
     */
    public void setSystemProperty(String name, String value, String description) throws Exception {
        if(name == null)
            throw new IllegalArgumentException("name parameter cannot be null.");
        if(value == null)
            throw new IllegalArgumentException("value parameter cannot be null.");
        SystemProperty prop = getSystemProperty(name);
        if(prop != null) {
            ConfigObject configObj = prop.getConfigObj();
            configObj.getAttributeByName("value").setValue(value);
            if(description != null)
                configObj.getAttributeByName("description").setValue(description);
        } else {
            ConfigObject jvm = getJVM();
            ConfigObject configObj = ConfigObject.createConfigObject(this.server, "Property", jvm);
            configObj.getAttributeByName("name").setValue(name);
            configObj.getAttributeByName("value").setValue(value);
            configObj.getAttributeByName("required").setValue(false);
            if(description != null)
                configObj.getAttributeByName("description").setValue(description);
        }
    }
    
    /**
     * Delete a system property
     * 
     * @param name The name of the property to delete
     * @throws Exception
     */
    public void deleteSystemProperty(String name) throws Exception {
        SystemProperty prop = getSystemProperty(name);
        if(prop == null)
            throw new IllegalArgumentException("A system property with name " + name + " does not exist.");
        prop.getConfigObj().delete();
    }
    
    private SystemProperty getSystemProperty(ConfigObject prop) throws Exception {
        SystemProperty ret = null;
        if(prop != null) {
            ret = new SystemProperty();
            ret.setName(prop.getAttributeByName("name").getValueAsString());
            ret.setValue(prop.getAttributeByName("value").getValueAsString());
            ret.setDescription(prop.getAttributeByName("description").getValueAsString());
            ret.setConfigObj(prop);
        }
        return ret;
    }
    
    private void setJVMProperty(String property, Object value) throws Exception {
        final String method = "setJVMProperty";
        Log.entering(c, method, new Object[]{property, value});
        SetJVMProperties task = new SetJVMProperties(null);
        task.setServerName(this.server.getName());
        task.setNodeName(this.server.getNodeName());
        if("classpath".equals(property))
            task.setClasspath((String[])value);
        else if("bootClasspath".equals(property))
            task.setBootClasspath((String[])value);
        else if("verboseModeClass".equals(property))
            task.setVerboseModeClass((Boolean)value);
        else if("verboseModeGarbageCollection".equals(property))
            task.setVerboseModeGarbageCollection((Boolean)value);
        else if("verboseModeJNI".equals(property))
            task.setVerboseModeJNI((Boolean)value);
        else if("initialHeapSize".equals(property))
            task.setInitialHeapSize((Integer)value);
        else if("maximumHeapSize".equals(property))
            task.setMaximumHeapSize((Integer)value);
        else if("runHProf".equals(property))
            task.setRunHProf((Boolean)value);
        else if("hprofArguments".equals(property))
            task.setHprofArguments((String)value);
        else if("debugMode".equals(property))
            task.setDebugMode((Boolean)value);
        else if("debugArgs".equals(property))
            task.setDebugArgs((String)value);
        else if("genericJvmArguments".equals(property))
            task.setGenericJvmArguments((String)value);
        else if("executableJarFileName".equals(property))
            task.setExecutableJarFileName((String)value);
        else if("disableJIT".equals(property))
            task.setDisableJIT((Boolean)value);
        else if("osName".equals(property))
            task.setOsName((String)value);
        else if("internalClassAccessMode".equals(property))
        	task.setInternalClassAccessMode((String)value);
        
        task.run(this.server);
        Log.exiting(c, method);
    }
    
    private Object getJVMProperty(String property) throws Exception {
        final String method = "getJVMProperty";
        Log.entering(c, method, property);
        ShowJVMProperties task = new ShowJVMProperties(null);
        task.setServerName(this.server.getName());
        task.setNodeName(this.server.getNodeName());
        task.setPropertyName(property);
        Object result = task.run(this.server).getResult();
        Log.exiting(c, method, result);
        return result;
    }
    
    private boolean getBooleanJVMProperty(String property) throws Exception {
        Object result = getJVMProperty(property);
        if(result instanceof String)
            return Boolean.parseBoolean((String)result);
        else
            return (Boolean)result;
    }
    
    private String getStringJVMProperty(String property) throws Exception {
        String val = (String)getJVMProperty(property);
        if(val != null && val.length() == 0)
            val = null;
        return val;
    }
    
    @SuppressWarnings("unchecked")
    private List<String> getListJVMProperty(String property) throws Exception {
        Object result = getJVMProperty(property);
        List ret = null;
        if(result != null && result instanceof String) {
            StringTokenizer st = new StringTokenizer((String)result, "\r\n\t\f");
            ret = new ArrayList<String>(st.countTokens());
            while(st.hasMoreTokens())
                ret.add(st.nextToken());
        } else
            ret = (List<String>)result;
        return ret;
    }
    
    private Integer getIntegerJVMProperty(String property) throws Exception {
        Object result = getJVMProperty(property);
        if(result instanceof String)
            return Integer.parseInt((String)result);
        else
            return (Integer) result;
    }
    
    private ConfigObject getJVM() throws Exception {
        ConfigObject ret = ConfigObject.getConfigObject(this.server, this.server.getConfigId(), "JavaVirtualMachine");
        return ret;
    }
    
    public class SystemProperty {
        private String name;
        private String value;
        private String description;
        private ConfigObject configObj;
        
        public String getDescription() {
            return description;
        }
        protected void setDescription(String description) {
            this.description = description;
        }
        public String getName() {
            return name;
        }
        protected void setName(String name) {
            this.name = name;
        }
        public String getValue() {
            return value;
        }
        protected void setValue(String value) {
            this.value = value;
        }
        protected ConfigObject getConfigObj() {
            return configObj;
        }
        protected void setConfigObj(ConfigObject configObj) {
            this.configObj = configObj;
        }
        
        
    }
    
    public enum InternalClassAccessMode {
    	ALLOW,
    	RESTRICT;
    }
}
