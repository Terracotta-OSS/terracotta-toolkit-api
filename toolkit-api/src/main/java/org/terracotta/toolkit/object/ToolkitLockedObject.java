/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.object;

import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock;

/**
 * A {@link ToolkitObject} which exposes a {@link ToolkitReadWriteLock}. Mutative operations are performed under the
 * write-lock and reads are performed under the read-lock of the {@code ToolkitReadWriteLock}
 */
public interface ToolkitLockedObject extends ToolkitObject {
  /**
   * Returns the lock under which mutations are done - can be used to lock externally to execute compound operations.
   * <p>
   * NOTE: Calling {@link ToolkitReadWriteLock#getName()} on the returned instance will return null. Same for the
   * {@link ToolkitLock#getName()} on the read and write locks from the returned {@code ToolkitReadWriteLock}
   */
  public ToolkitReadWriteLock getReadWriteLock();
}
