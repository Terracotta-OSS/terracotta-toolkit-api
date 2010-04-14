package org.terracotta.locking;

import java.util.concurrent.TimeUnit;

public interface TerracottaLock {

  /**
   * Lock the underlying data structure for this lock's granularity using its lock type.
   */
  public void lock();

  /**
   * Lock the underlying data structure for this lock's granularity using its lock type only if the lock is not
   * held by another thread at the time of invocation.
   *
   * @return {@code true} if the lock was successfully acquired; or {@code false) otherwise
   */
  public boolean tryLock();

  /**
   * Lock the underlying data structure for this lock's granularity using its lock type only if the lock is not
   * held by another thread within a given time.
   *
   * @param timeout the time to wait
   * @param unit the time unit of the timeout argument
   * @return {@code true} if the lock was successfully acquired; or {@code false) otherwise
   */
  public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException;

  /**
   * Unlocks the underlying data structure for this lock's granularity using its lock type.
   */
  public void unlock();

  /**
   * Indicates whether the current thread is holding a lock that corresponds to this granularity and its lock type.
   *
   * @return {@code true} if the current thread is holding the lock; or {@code false} otherwise
   */
  public boolean isHeldByCurrentThread();

}