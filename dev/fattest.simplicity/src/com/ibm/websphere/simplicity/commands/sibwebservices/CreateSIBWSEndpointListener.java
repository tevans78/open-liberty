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

package com.ibm.websphere.simplicity.commands.sibwebservices;

import java.util.List;
import java.util.Properties;

import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Create an endpoint listener.
 * 'name': Name of the endpoint listener.
 * 'urlRoot': Root of the endpoint address URL for Web services accessed using this endpoint listener.
 * 'wsdlUrlRoot': Root of the HTTP URL where WSDL associated with this endpoint listener is located.
 * 'earFile': Location of the endpoint listener application EAR file.
 * The required parameters are found in the constructor.
 */
public class CreateSIBWSEndpointListener extends Command {

    private com.ibm.websphere.simplicity.ConfigIdentifier __target;
    private String name;
    private String urlRoot;
    private String wsdlUrlRoot;
    //private com.ibm.websphere.management.cmdframework.UploadFile earFile;

    public CreateSIBWSEndpointListener(com.ibm.websphere.simplicity.ConfigIdentifier commandTarget, String name, String urlRoot, String wsdlUrlRoot) {
        super("createSIBWSEndpointListener");
        this.__target = commandTarget;
        this.name = name;
        this.urlRoot = urlRoot;
        this.wsdlUrlRoot = wsdlUrlRoot;
    }

    /**
     * Name of the endpoint listener.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Name of the endpoint listener.
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Root of the endpoint address URL for Web services accessed using this endpoint listener.
     */
    public String getUrlRoot() {
        return this.urlRoot;
    }

    /**
     * Root of the endpoint address URL for Web services accessed using this endpoint listener.
     */
    public void setUrlRoot(String value) {
        this.urlRoot = value;
    }

    /**
     * Root of the HTTP URL where WSDL associated with this endpoint listener is located.
     */
    public String getWsdlUrlRoot() {
        return this.wsdlUrlRoot;
    }

    /**
     * Root of the HTTP URL where WSDL associated with this endpoint listener is located.
     */
    public void setWsdlUrlRoot(String value) {
        this.wsdlUrlRoot = value;
    }

//	/**
//	 * Location of the endpoint listener application EAR file.
//	 */
//	public com.ibm.websphere.management.cmdframework.UploadFile getEarFile() {
//		return this.earFile;
//	}
//
//	/**
//	 * Location of the endpoint listener application EAR file.
//	 */
//	public void setEarFile(com.ibm.websphere.management.cmdframework.UploadFile value) {
//		this.earFile = value;
//	}

    /**
     * Change the command's target (originally specified in constructor).
     */
    public void setCommandTarget(com.ibm.websphere.simplicity.ConfigIdentifier value) {
        this.__target = value;
    }

    @Override
    public Properties __getParameters() {
        Properties ret = new Properties();
        ret.put("name", this.name);
        ret.put("urlRoot", this.urlRoot);
        ret.put("wsdlUrlRoot", this.wsdlUrlRoot);
//		if (this.earFile != null) {
//			ret.put("earFile", this.earFile);
//		}
        return ret;
    }

    @Override
    public Object __getTarget() {
        return this.__target;
    }

    @Override
    public List<Command> __getSteps() {
        return null;
    }

    /**
     * Executes the command against the specified scope.
     */
    @Override
    public OperationResults<Object> run(Scope scope) throws Exception {
        return super.run(scope);
    }

}
