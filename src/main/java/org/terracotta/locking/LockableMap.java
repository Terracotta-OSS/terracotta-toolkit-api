/*
 * All content copyright (c) Terracotta, Inc., except as may otherwise be noted in a separate copyright notice. All
 * rights reserved.
 */
package org.terracotta.locking;

/**
 * Instances of LockableMap can have their individual entries independently locked and unlocked. This allows the
 * implementation of atomic operations with arbitrary contents.
 *
 * @author Chris Dennis
 * @param <K> key type
 */
public interface LockableMap<K> {
  /**
   * Obtain a fine-grained lock instance for a particular key.
   *
   * @param key the key for which a fine-grained lock has to be constructed
   * @return an instance of fine-grained lock that can be used to perform primitive locking operations on a key
   */
  public FinegrainedLock createFinegrainedLock(K key);

  /**
   * Lock the entry corresponding to this key.
   *
   * @param key the key for which all entry accesses have to be locked
   */
  public void lockEntry(K key);

  /**
   * Unlock the entry corresponding to this key
   *
   * @param key the key for which all entry accesses have to be unlocked
   */
  public void unlockEntry(K key);
}
