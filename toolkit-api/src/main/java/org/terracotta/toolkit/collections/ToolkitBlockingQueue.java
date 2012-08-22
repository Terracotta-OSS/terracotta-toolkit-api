/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.collections;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitLockedObject;
import org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException;

import java.util.concurrent.BlockingQueue;

/**
 * A bounded toolkit {@link BlockingQueue}. The queue performs all mutative operations under the write lock from
 * {@link ToolkitLockedObject#getReadWriteLock()} and all read operations under the read lock from the same.
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 * <p>
 * Trying to add values that are not serializable will throw {@link NotSerializableRuntimeException}
 */
public interface ToolkitBlockingQueue<E> extends BlockingQueue<E>, ToolkitLockedObject, Destroyable {
  /**
   * Returns the capacity of this clustered blocking queue
   * 
   * @return capacity of the queue
   */
  public int getCapacity();
}
