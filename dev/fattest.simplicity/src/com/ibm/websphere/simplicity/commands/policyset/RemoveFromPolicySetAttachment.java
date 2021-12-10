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

package com.ibm.websphere.simplicity.commands.policyset;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * The removeFromPolicySetAttachment command removes resources that apply to a policy set attachment.
 *   'applicationName': Specifies the name of the application. This parameter applies to application and client attachments.  It is not applicable to trust service attachments. (String)
 *   'attachmentId': Specifies the ID of the attachment. (String)
 *   'resources': Specifies the names of the application or trust service resources. (String)
 *   'attachmentType': Specifies the type of policy set attachments. The value for this parameter must be application, client, or system/trust. The default value is application. (String)
 *   'attachmentProperties': The attachment specific properties (Properties)
 * The required parameters are found in the constructor.
 */
public class RemoveFromPolicySetAttachment extends Command {

	private String applicationName;
	private String attachmentId;
	private java.lang.String[] resources;
	private String attachmentType;
	private java.util.Properties attachmentProperties;

	public RemoveFromPolicySetAttachment(String attachmentId, java.lang.String[] resources) {
		super("removeFromPolicySetAttachment");
		this.attachmentId = attachmentId;
		this.resources = resources;
	}

	/**
	 * Specifies the name of the application. This parameter applies to application and client attachments.  It is not applicable to trust service attachments. (String)
	 */
	public String getApplicationName() {
		return this.applicationName;
	}

	/**
	 * Specifies the name of the application. This parameter applies to application and client attachments.  It is not applicable to trust service attachments. (String)
	 */
	public void setApplicationName(String value) {
		this.applicationName = value;
	}

	/**
	 * Specifies the ID of the attachment. (String)
	 */
	public String getAttachmentId() {
		return this.attachmentId;
	}

	/**
	 * Specifies the ID of the attachment. (String)
	 */
	public void setAttachmentId(String value) {
		this.attachmentId = value;
	}

	/**
	 * Specifies the names of the application or trust service resources. (String)
	 */
	public java.lang.String[] getResources() {
		return this.resources;
	}

	/**
	 * Specifies the names of the application or trust service resources. (String)
	 */
	public void setResources(java.lang.String[] value) {
		this.resources = value;
	}

	/**
	 * Specifies the type of policy set attachments. The value for this parameter must be application, client, or system/trust. The default value is application. (String)
	 */
	public String getAttachmentType() {
		return this.attachmentType;
	}

	/**
	 * Specifies the type of policy set attachments. The value for this parameter must be application, client, or system/trust. The default value is application. (String)
	 */
	public void setAttachmentType(String value) {
		this.attachmentType = value;
	}

	/**
	 * The attachment specific properties (Properties)
	 */
	public java.util.Properties getAttachmentProperties() {
		return this.attachmentProperties;
	}

	/**
	 * The attachment specific properties (Properties)
	 */
	public void setAttachmentProperties(java.util.Properties value) {
		this.attachmentProperties = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.applicationName != null) {
			ret.put("applicationName", this.applicationName);
		}
		ret.put("attachmentId", this.attachmentId);
		ret.put("resources", this.resources);
		if (this.attachmentType != null) {
			ret.put("attachmentType", this.attachmentType);
		}
		if (this.attachmentProperties != null) {
			ret.put("attachmentProperties", this.attachmentProperties);
		}
		return ret;
	}

	public Object __getTarget() {
		return null;
	}

	public List<Command> __getSteps() {
		return null;
	}

	/**
	 * Executes the command against the specified scope.
	 */
	public OperationResults<Object> run(Scope scope) throws Exception {
		return super.run(scope);
	}

}
