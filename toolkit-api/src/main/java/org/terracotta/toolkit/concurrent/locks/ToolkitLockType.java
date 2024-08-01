/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
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
