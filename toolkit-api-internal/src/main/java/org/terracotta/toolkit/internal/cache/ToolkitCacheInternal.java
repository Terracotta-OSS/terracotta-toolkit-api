/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.cache;

import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.cluster.ClusterNode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Internal api for ToolkitCache
 */
public interface ToolkitCacheInternal<K, V> extends ToolkitCache<K, V> {

  /**
   * Returns set of nodes which has the corresponding key in its local jvm
   */
  Map<Object, Set<ClusterNode>> getNodesWithKeys(Set portableKeys);

  /**
   * Performs an unlocked put. Its up to the user to take locks and create transactions.
   * 
   * @param map input map
   */
  void unlockedPutNoReturn(K k, V v, int createTime, int customTTI, int customTTL);

  /**
   * Performs an unlocked remove. Its up to the user to take locks and create transactions.
   * 
   * @param map input map
   */
  void unlockedRemoveNoReturn(Object k);

  /**
   * Performs an unlocked get.
   * 
   * @param map input map
   */
  V unlockedGet(Object k, boolean quiet);

  Map<K, V> unlockedGetAll(Collection<K> keys, boolean quiet);

  /**
   * Clear the local cache
   */
  void clearLocalCache();

  /**
   * Perform a local unlocked read for the given key.
   * <p>
   * This method performs no locking and thus provides absolutely no visibility guarantees. If the value is not local it
   * will NOT be looked up from elsewhere and null is returned instead - thus one cannot distinguish between a
   * non-existent mapping from one where its present elsewhere. USE WITH CAUTION.
   * 
   * @param key The key to lookup
   * @return value mapped to {@code key} if present locally in the current node, otherwise null.
   */
  V unsafeLocalGet(Object key);

  /**
   * Query whether key is present locally or not
   * 
   * @return true if key is local, otherwise false
   */
  boolean containsLocalKey(Object key);

  /**
   * Return the count of local entries. <br>
   * The count returned might not be very accurate if maxEntriesLocalHeap is set to small values.
   * 
   * @return count of local entries
   */
  int localSize();

  /**
   * Returns a Set containing keys in the Store which are present in the node locally. The returned set is immutable.
   * 
   * @return Set of keys which are present in the node locally.
   */
  Set<K> localKeySet();

  /**
   * Return the on-heap size in bytes present locally in current node.<br>
   * 
   * @return the on-heap size in bytes present locally in current node.
   */
  long localOnHeapSizeInBytes();

  /**
   * Return the off-heap size in bytes present locally in current node.
   * 
   * @return the off-heap size in bytes present locally in current node.
   */
  long localOffHeapSizeInBytes();

  /**
   * Return the number of elements present locally on-heap in current node.<br>
   * The count returned might not be very accurate if maxEntriesLocalHeap is set to small values.
   * 
   * @return the number of elements present locally on-heap in current node.
   */
  int localOnHeapSize();

  /**
   * Return the number of elements present locally in off-heap of current node.
   * 
   * @return the number of elements present locally in off-heap of current node.
   */
  int localOffHeapSize();

  /**
   * Returns true if the key is present on-heap in current node.
   * 
   * @return true if the key is present on-heap in current node otherwise false.
   */
  boolean containsKeyLocalOnHeap(Object key);

  /**
   * Returns true if the key is present off-heap in current node.
   * 
   * @return true if the key is present off-heap in current node otherwise false.
   */
  boolean containsKeyLocalOffHeap(Object key);

  V put(K key, V value, int createTimeInSecs, int customMaxTTISeconds, int customMaxTTLSeconds);

  /**
   * Dispose the Store from this node. If present elsewhere, the key-value store is still usable. Trying to use the
   * store after disposing locally will throw {@code IllegalStateException}.
   */
  public void disposeLocally();

  public void removeAll(Set<K> keys);
}
