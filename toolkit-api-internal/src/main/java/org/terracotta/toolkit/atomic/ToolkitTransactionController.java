/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.atomic;

import org.terracotta.toolkit.ToolkitFeature;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;

/**
 * A Controller for {@link ToolkitTransaction}. <br>
 * Write Locks taken inside the toolkit transaction will be released only after the transaction is commited. Accessing
 * multiple locks or Locked Objects inside a transaction should be done in a fixed order in order to avoid deadlocks.
 */

public interface ToolkitTransactionController extends ToolkitFeature {

  /**
   * Creates a ToolkitTransaction. This transaction will be current transaction up to
   * {@link ToolkitTransaction#commit()} is called by the same thread. User should use {@link ToolkitLock} with
   * {@link ToolkitTransaction} for visibility.
   */
  public ToolkitTransaction beginTransaction(ToolkitTransactionType type);

}
