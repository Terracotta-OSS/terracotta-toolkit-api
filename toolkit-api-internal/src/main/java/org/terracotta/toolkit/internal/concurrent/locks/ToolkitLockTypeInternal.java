/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.concurrent.locks;

import org.terracotta.toolkit.concurrent.locks.ToolkitLockType;

public enum ToolkitLockTypeInternal {
  /**
   * Exclusive write lock.
   */
  WRITE,

  /**
   * Shared read lock.
   */
  READ,
  /**
   * Exclusive write lock.
   * <p>
   * For Terracotta clustered toolkits, synchronously flushes enclosed changes to the Terracotta Server Array, blocking
   * the unlocking thread until changes have been acknowledged as committed.
   */
  SYNCHRONOUS_WRITE,
  /**
   * Shared write lock.
   * <p>
   * No-op lock level that provides no exclusion guarantees. For Terracotta clustered toolkits, does provide transaction
   * boundaries. Use at your own risk.
   */
  CONCURRENT;

  public ToolkitLockType getToolkitLockType() {
    switch (this) {
      case WRITE:
        return ToolkitLockType.WRITE;
      case READ:
        return ToolkitLockType.READ;
      case SYNCHRONOUS_WRITE:
        return ToolkitLockType.WRITE;
      case CONCURRENT:
        throw new UnsupportedOperationException();
    }
    throw new AssertionError();
  }
}
