/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.atomic;

public enum ToolkitTransactionType {
  /**
   * all changes done in a NORMAL Transaction are published atomically to the Terracotta Server Array.
   */
  NORMAL,
  /**
   * synchronously flushes enclosed changes to the Terracotta Server Array, blocking the unlocking thread until changes
   * have been acknowledged as received on Server.
   */
  SYNC

}
