/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.concurrent.locks;

/**
 * Lock types supported by the toolkit.
 */
public enum ToolkitLockType {
  /**
   * Exclusive write lock.
   */
  WRITE,

  /**
   * Shared read lock.
   */
  READ,

}
