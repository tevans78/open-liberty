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

package com.ibm.websphere.simplicity.application.types;

import com.ibm.websphere.simplicity.application.AppConstants;

public enum UpdateType {
	
	/**
	 * Allows one or more files to be added to the existing application.  The file
	 * can either be a standalone (i.e. single), or a compound (i.e. zip) file.
	 * When this option is specified with a compound file, it's critical that none
	 * of the files stored in the compound file conflict with existing files in the
	 * installed application.
	 */
	ADD(AppConstants.APPUPDATE_ADD),
	/**
	 * Allows files to be both updated and added.  This option does not require
	 * that files be either updated or added; users can specify only files for
	 * updating or only files for adding.  Like the ADD option, either a single
	 * standalone file or a compound (zip) file can be specified.
	 * <p>
	 * Note that, for compound files, this option implies that conflicting files
	 * in the installed application will be overwritten.
	 */
	ADD_UPDATE(AppConstants.APPUPDATE_ADDUPDATE),
	/**
	 * Allows one or more files to be updated on the existing application.  The file
	 * can either be a standalone (i.e. single), or a compound (i.e. zip) file.
	 * When this option is specified with a compound file, it's critical that all
	 * of the files stored in the compound file exist in the installed application.
	 */
	UPDATE(AppConstants.APPUPDATE_UPDATE),
	/**
	 * The delete option requires only one parameter: the content URI of the file
	 * to delete.  This is not cominable with other options, so that deletions
	 * are done in isolation from adds and updates.
	 */
	DELETE(AppConstants.APPUPDATE_DELETE);
	
	private String value;
	
	private UpdateType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
