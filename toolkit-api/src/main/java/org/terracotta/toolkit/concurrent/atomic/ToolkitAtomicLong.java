/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.concurrent.atomic;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitObject;

/**
 * A toolkit atomic long that can be used to maintain counters in the toolkit in a thread-safe manner across the toolkit
 * implementation platform.
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 */
public interface ToolkitAtomicLong extends Destroyable, ToolkitObject {

  /**
   * Atomically add the supplied value to the current value.
   * 
   * @param delta the value to add
   * @return the new value
   */
  long addAndGet(long delta);

  /**
   * Atomically set the value to the new value if the current value == the given value.
   * 
   * @param expect the expected value
   * @param update the new value
   * @return true if successful, false if the comparison failed
   */
  boolean compareAndSet(long expect, long update);

  /**
   * Atomically decrement the current value by one.
   * 
   * @return the new value
   */
  long decrementAndGet();

  /**
   * Get the current value.
   * 
   * @return the current value
   */
  long get();

  /**
   * Atomically add the supplied value to the current value.
   * 
   * @param delta the value to add
   * @return the previous value
   */
  long getAndAdd(long delta);

  /**
   * Atomically decrement the current value.
   * 
   * @return the previous value
   */
  long getAndDecrement();

  /**
   * Atomically increment the current value.
   * 
   * @return the previous value
   */
  long getAndIncrement();

  /**
   * Atomically: set to the given value and return the previous value.
   * 
   * @param newValue the new value
   * @return the previous value
   */
  long getAndSet(long newValue);

  /**
   * Atomically increment the current value
   * 
   * @return the new value
   */
  long incrementAndGet();

  /**
   * Set to the given value
   * 
   * @param newValue the new value
   */
  void set(long newValue);

  /**
   * {@link Number#byteValue()}
   */
  byte byteValue();

  /**
   * {@link Number#shortValue()}
   */
  short shortValue();

  /**
   * {@link Number#intValue()}
   */
  int intValue();

  /**
   * {@link Number#longValue()}
   */
  long longValue();

  /**
   * {@link Number#floatValue()}
   */
  float floatValue();

  /**
   * {@link Number#doubleValue()}
   */
  double doubleValue();
}
