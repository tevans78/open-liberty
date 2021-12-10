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

public class Transaction {
    
    private TransactionState state;
    private String[] changes;
    
    protected Transaction() {
        this.state = TransactionState.OPEN;
    }

    public static enum TransactionState {
        OPEN,
        DIRTY,
        CLOSED;
    }

    protected void setDirty() {
        this.state = TransactionState.DIRTY;
//      if (this.autocommit)
//          this.save();
    }
    
    public String[] getChanges() {
        return this.changes;
    }
    
    public TransactionState getState() {
        return this.state;
    }
    
    protected void close(String[] changes) {
        this.changes = changes;
        this.state = TransactionState.CLOSED;
    }
}
