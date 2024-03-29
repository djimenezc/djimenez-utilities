/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007 Sun Microsystems Inc. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * https://opensso.dev.java.net/public/CDDLv1.0.html or
 * opensso/legal/CDDLv1.0.txt
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at opensso/legal/CDDLv1.0.txt.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * $Id: ShutdownManager.java,v 1.7 2008-10-04 00:36:44 veiming Exp $
 *
 */

package com.sun.identity.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * ShutdownManager is a static instance which is used to trigger all the
 * ShutdownListener to call shutdown function.
 */

public class ShutdownManager {
    
    protected static ShutdownManager instance;
    
    protected Set[] listeners;

    protected boolean shutdownCalled;

    protected Object currentOwner;

    protected int acquireCount;

    protected int waitCount;

    private ShutdownListener appSSOTokenDestroyer;

    /**
     * Constructor of ShutdownManager.
     */
    
    protected ShutdownManager() {
        shutdownCalled = false;
        currentOwner = null;
        acquireCount = 0;
        waitCount = 0;
        int size = ShutdownPriority.HIGHEST.getIntValue();
        listeners = new HashSet[size];
        for (int i = 0; i < size; i++) {
            listeners[i] = new HashSet();
        }
        // add the trigger for stand alone application to shutdown.
        Runtime.getRuntime().addShutdownHook(new Thread(
            new Runnable() {
                public void run() {
                    ShutdownManager shutdownMan =
                        ShutdownManager.getInstance();
                    if (shutdownMan.acquireValidLock()) {
                        try {
                            shutdown();
                        } finally {
                            shutdownMan.releaseLockAndNotify();
                        }
                    }
                }
            }, "ShutdownThread"));
    }

    /**
     * Acquire the lock of this ShutdownManager. The function will block if
     * other thread is holding the lock or return false if shutdown is called.
     *
     * @return a boolean to indicate whether it success.
     */
    public synchronized boolean acquireValidLock() {
        if (shutdownCalled) {
            return false;
        } else {
            if (currentOwner == null) {
                currentOwner = Thread.currentThread();
                acquireCount = 1;
            } else {
                if (currentOwner == Thread.currentThread()) {
                    acquireCount++;
                } else {
                    try {
                        waitCount++;
                        this.wait();
                        waitCount--;
                    } catch (InterruptedException ex) {
                        //ignored
                    }
                    if (shutdownCalled) {
                        return false;
                    } else {
                        currentOwner = Thread.currentThread();
                        acquireCount = 1;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Release the lock of this ShutdownManager. IllegalMonitorStateException
     * will be thrown if the current thread is not holding the lock.
     */
    public synchronized void releaseLockAndNotify() throws
        IllegalMonitorStateException {
        if (currentOwner == Thread.currentThread()) {
            if (acquireCount > 1) {
                acquireCount--;
            } else {
                currentOwner = null;
                acquireCount = 0;
                if (waitCount > 0) {
                    if (shutdownCalled) {
                        this.notifyAll();
                    } else {
                        this.notify();
                    }
                }
            }
        } else {
            throw new IllegalMonitorStateException(
                "The calling thread is not the owner of the lock!");
        }
    }
    
    /**
     * Returns the static instance of ShutdownManager in the VM.
     *
     * @return The static instance of ShutdownManager
     */
    
    public static synchronized ShutdownManager getInstance() {
        if (instance == null) {
            instance = new ShutdownManager();
        }
        return instance;
    }
    
    /**
     * Adds a ShutdownListener to this ShutdownManager.
     *
     * @param listener The listener to be added
     */
    
    public void addShutdownListener(ShutdownListener listener) throws
        IllegalMonitorStateException {
        addShutdownListener(listener, ShutdownPriority.DEFAULT);
    }
    
    /**
     * Adds a ShutdownListener to this ShutdownManager with indicated level.
     *
     * @param listener The listener to be added
     * @param priority The priority to shutdown for the shutdown listener
     */
    
    public void addShutdownListener(ShutdownListener listener,
        ShutdownPriority priority) throws IllegalMonitorStateException {
        if (currentOwner == Thread.currentThread()) {
            removeShutdownListener(listener);
            listeners[priority.getIntValue() - 1].add(listener);
        } else {
            throw new IllegalMonitorStateException(
                "The calling thread is not the owner of the lock!");
        }
    }
    
    /**
     * Removes a ShutdownListener from this ShutdownManager.
     *
     * @param listener The listener to be removed
     */
    
    public void removeShutdownListener(ShutdownListener listener) throws 
        IllegalMonitorStateException {
        if (currentOwner == Thread.currentThread()) {
            List priorities = ShutdownPriority.getPriorities();
            for (Iterator i = priorities.iterator(); i.hasNext();) {
                int index = ((ShutdownPriority) i.next()).getIntValue();
                if (listeners[index - 1].remove(listener)) {
                    break;
                }
            }
        } else {
            throw new IllegalMonitorStateException(
                "The calling thread is not the owner of the lock!");
        }
    }

    /**
     * Shuts down all the listeners in this ShutdownManager.
     */
    
    public void shutdown() throws IllegalMonitorStateException {
        if (currentOwner == Thread.currentThread()) {
            shutdownCalled = true;
            List priorities = ShutdownPriority.getPriorities();
            for (Iterator i = priorities.iterator(); i.hasNext();) {
                int index = ((ShutdownPriority) i.next()).getIntValue();
                for (Iterator j = listeners[index - 1].iterator();
                    j.hasNext();) {
                    ShutdownListener element = (ShutdownListener) j.next();
                    element.shutdown();
                    // remove the components which have been shutdown to avoid
                    // problem when the shutdown function is called twice.
                    j.remove();
                }
            }
            if (appSSOTokenDestroyer != null) {
                appSSOTokenDestroyer.shutdown();
                appSSOTokenDestroyer = null;
            }
        } else {
            throw new IllegalMonitorStateException(
                "The calling thread is not the owner of the lock!");
        }
    }

    /**
     * Adds application single-sign-on token destroyer.
     *
     * @param listener Listener object.
     */
    public void addApplicationSSOTokenDestoryer(ShutdownListener listener) {
        appSSOTokenDestroyer = listener;
    }
} 
