/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.locking;

import java.util.concurrent.TimeUnit;

import org.terracotta.api.LockType;

/**
 * Provides primitive lock operations for the granularity that was used to create an instance of this lock. At the
 * creation of a {@code FinegrainedLock} instance a default lock type is also store, which is corresponds to the default
 * lock type of the underlying data structure.
 * <p>
 * IMPORTANT: an instance of {@code FinegrainedLock) is not supposed to be cached or stored in any field or data
 * structure since the state of the underlying data structure can have changed in the meantime. Each time a locking
 * operation is performed a new instance of {@code FinegrainedLock} needs to be obtained.
 */
public interface FinegrainedLock {
  /**
   * Lock the underlying data structure for this lock's granularity using the default lock type.
   */
  public void lock();

  /**
   * Lock the underlying data structure for this lock's granularity with a specified lock type.
   *
   * @param lockType the type of lock that needs to be locked
   */
  public void lock(LockType lockType);

  /**
   * Lock the underlying data structure for this lock's granularity using the default lock type only if the lock is not
   * held by another thread at the time of invocation.
   *
   * @return {@code true} if the lock was successfully acquired; or {@code false) otherwise
   */
  public boolean tryLock();

  /**
   * Lock the underlying data structure for this lock's granularity with a specified lock type only if the lock is not
   * held by another thread at the time of invocation.
   *
   * @param lockType the type of lock that needs to be locked
   * @return {@code true} if the lock was successfully acquired; or {@code false) otherwise
   */
  public boolean tryLock(LockType lockType);

  /**
   * Lock the underlying data structure for this lock's granularity using the default lock type only if the lock is not
   * held by another thread within a given time.
   *
   * @param timeout the time to wait
   * @param unit the time unit of the timeout argument
   * @return {@code true} if the lock was successfully acquired; or {@code false) otherwise
   */
  public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException;

  /**
   * Lock the underlying data structure for this lock's granularity with a specified lock type only if the lock is not
   * held by another thread within a given time.
   *
   * @param lockType the type of lock that needs to be locked
   * @param timeout the time to wait
   * @param unit the time unit of the timeout argument
   * @return {@code true} if the lock was successfully acquired; or {@code false) otherwise
   */
  public boolean tryLock(LockType lockType, long timeout, TimeUnit unit) throws InterruptedException;

  /**
   * Unlocks the underlying data structure for this lock's granularity using the default lock type.
   */
  public void unlock();

  /**
   * Unlocks the underlying data structure for this lock's granularity using the specified lock type.
   *
   * @param lockType the type of lock that needs to be unlocked
   */
  public void unlock(LockType lockType);

  /**
   * Indicates whether the current thread is holding a lock that corresponds to this granularity and default lock type.
   *
   * @return {@code true} if the current thread is holding the lock; or {@code false} otherwise
   */
  public boolean isHeldByCurrentThread();

  /**
   * Indicates whether the current thread is holding a lock that corresponds to this granularity and specified lock type.
   *
   * @param lockType the type of lock that needs to be checked
   * @return {@code true} if the current thread is holding the lock; or {@code false} otherwise
   */
  public boolean isHeldByCurrentThread(LockType lockType);
}