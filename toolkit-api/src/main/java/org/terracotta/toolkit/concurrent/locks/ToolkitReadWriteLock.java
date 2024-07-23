/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.concurrent.locks;

import org.terracotta.toolkit.object.ToolkitObject;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Provides a pair of Read and Write lock.
 */
public interface ToolkitReadWriteLock extends ReadWriteLock, ToolkitObject {
  /**
   * {@inheritDoc}
   * <br>
   * {@link ToolkitLock#getName()} on the returned lock will return null
   * 
   * @return the ToolkitLock used for reading.
   */
  ToolkitLock readLock();

  /**
   * {@inheritDoc}
   * <br>
   * {@link ToolkitLock#getName()} on the returned lock will return null
   * 
   * @return the ToolkitLock used for writing.
   */
  ToolkitLock writeLock();

}
