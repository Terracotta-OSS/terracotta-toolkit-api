/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.atomic;

import org.terracotta.toolkit.ToolkitFeature;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;

/**
 * A Controller for {@link ToolkitTransaction}
 */

public interface ToolkitTransactionController extends ToolkitFeature {

  /**
   * Creates a ToolkitTransaction. This transaction will be current transaction up to
   * {@link ToolkitTransaction#commit()} is called by the same thread. User should use {@link ToolkitLock} with
   * {@link ToolkitTransaction} for visibility.
   */
  public ToolkitTransaction beginTransaction();

  /**
   * Creates a {@link ToolkitLock} with transaction capabilities. The very first {@link ToolkitLock#lock()} will create
   * a transaction with this lock and the very last {@link ToolkitLock#unlock()} will
   * {@link ToolkitTransaction#commit()} that transaction.
   */
  public <T extends ToolkitLock> T createTransactionalLock(T lock);

}
