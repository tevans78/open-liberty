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

package com.ibm.websphere.simplicity.commands.wim;

import java.util.Properties;
import java.util.List;
import com.ibm.websphere.simplicity.Scope;
import com.ibm.websphere.simplicity.OperationResults;
import com.ibm.websphere.simplicity.commands.Command;

/**
 * NOTE: Please do not use this command unless a Simplicity API does not already exist.
 * Searches groups.
 *   'cn': The common name of the entity.
 *   'countLimit': The maximum number of entities to return.
 *   'description': A description of a group.
 *   'timeLimit': A maximum amount of time, in milliseconds, to run a search.
 * The required parameters are found in the constructor.
 */
public class SearchGroups extends Command {

	private String cn;
	private Integer countLimit = 0;
	private String description;
	private Integer timeLimit = 0;

	public SearchGroups() {
		super("searchGroups");
	}

	/**
	 * The common name of the entity.
	 */
	public String getCn() {
		return this.cn;
	}

	/**
	 * The common name of the entity.
	 */
	public void setCn(String value) {
		this.cn = value;
	}

	/**
	 * The maximum number of entities to return.
	 */
	public Integer getCountLimit() {
		return this.countLimit;
	}

	/**
	 * The maximum number of entities to return.
	 */
	public void setCountLimit(Integer value) {
		this.countLimit = value;
	}

	/**
	 * A description of a group.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * A description of a group.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * A maximum amount of time, in milliseconds, to run a search.
	 */
	public Integer getTimeLimit() {
		return this.timeLimit;
	}

	/**
	 * A maximum amount of time, in milliseconds, to run a search.
	 */
	public void setTimeLimit(Integer value) {
		this.timeLimit = value;
	}

	public Properties __getParameters() {
		Properties ret = new Properties();
		if (this.cn != null) {
			ret.put("cn", this.cn);
		}
		if (this.countLimit != null) {
			ret.put("countLimit", this.countLimit);
		}
		if (this.description != null) {
			ret.put("description", this.description);
		}
		if (this.timeLimit != null) {
			ret.put("timeLimit", this.timeLimit);
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
