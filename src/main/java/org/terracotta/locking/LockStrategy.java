/*
 * All content copyright (c) Terracotta, Inc., except as may otherwise be noted in a separate copyright notice. All
 * rights reserved.
 */
package org.terracotta.locking;

public interface LockStrategy<K> {

  /**
   * Generate the terracotta lock identifier used when performing operations for the given key.
   * 
   * @param instanceQualifier A unique identifier for the map being operated on. To avoid lock collisions with other
   *        maps, this identifier should be part of the return lockId
   * @param key
   * @return lock identifier
   */
  String generateLockIdForKey(String instanceQualifier, K key);

  void beginLock(String lockID, int type);

  void pinLock(String lockId);

  void unpinLock(String lock);

  void commitLock(String lockID, int type);

  boolean tryBeginLock(String lockID, int type, long nanos) throws InterruptedException;
}
