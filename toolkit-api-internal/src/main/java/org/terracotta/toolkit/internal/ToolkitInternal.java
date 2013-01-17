/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.ToolkitFeature;
import org.terracotta.toolkit.ToolkitFeatureTypeInternal;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.internal.concurrent.locks.ToolkitLockTypeInternal;

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
   * Returns the {@link ToolkitFeature} implementation identified by <code>type</code> associated with the
   * {@link Toolkit}.
   * 
   * @param type the type identifying the feature.
   * @return returns the feature identified by <code>type</code>.
   * @see ToolkitFeatureTypeInternal
   */
  <T extends ToolkitFeature> T getFeature(ToolkitFeatureTypeInternal<T> type);
}
