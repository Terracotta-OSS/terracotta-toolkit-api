/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.concurrent.locks;

import org.terracotta.toolkit.tck.TCKStrict;

/**
 * Lock types supported by the toolkit.
 */
@TCKStrict
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
