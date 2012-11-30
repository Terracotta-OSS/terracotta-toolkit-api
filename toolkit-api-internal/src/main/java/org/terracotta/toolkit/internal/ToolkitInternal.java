/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.internal.concurrent.locks.ToolkitLockTypeInternal;
import org.terracotta.toolkit.internal.nonstop.NonStopManager;

public interface ToolkitInternal extends Toolkit {

  /**
   * Get a lock with specified internal lock type
   */
  ToolkitLock getLock(String name, ToolkitLockTypeInternal lockType);

  /**
   * Registers a {@link Runnable} that will be executed before the Toolkit shuts down
   */
  void registerBeforeShutdownHook(Runnable hook);

  /**
   * Waits until all transactions are complete
   */
  void waitUntilAllTransactionsComplete();

  /**
   * Returns a new {@link ToolkitLogger} for the given name
   */
  ToolkitLogger getLogger(String name);

  /**
   * Return the uuid of this client used in mbean names
   */
  String getClientUUID();

  /**
   * Return properties of this toolkit
   */
  ToolkitProperties getProperties();

  /**
   * Expose non stop manager
   */
  NonStopManager getNonStopManager();
}
