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

package com.ibm.websphere.simplicity.jobmanager;

public enum ExecutionWindowUnitType {
	
	/**
	 * The job should be executed at the specified time on a daily basis.
	 */
	DAILY,
	/**
	 * The job should be executed at the specified time on a weekly basis.
	 */
	WEEKLY,
	/**
	 * The job should be executed at the specified time on a monthly basis.
	 */
	MONTHLY,
	/**
	 * The job should be executed at the specified time on a yearly basis.
	 */
	YEARLY,
	/**
	 * Default.  The job should be executed only once.
	 */
	CONNECTION;

}
