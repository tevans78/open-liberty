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

package com.ibm.websphere.simplicity;



/**
 * Wraps a transacted operation without having to sprinkle our code with transactions.
 * Of course, some may say the alternative is just as bad, but it *is* extensible.
 * 
 * @author SterlingBates
 *
 */
public abstract class TransactedOperation {
	
	private Workspace t;
	
	public Object run(Scope scope) throws Exception {
		Object ret = null;
		t = scope.getWorkspace();
		try {
			ret = executeOperation();
            t.save();
//			t.setDirty();
			return ret;
		}
		catch(Exception e) {
//			if (t.isAutoCommit())
//				t.discard();
			throw e;
		}
	}
	
	public AbstractSession getSession() {
		return t.getSession();
	}
	
	public abstract Object executeOperation() throws Exception;

}
