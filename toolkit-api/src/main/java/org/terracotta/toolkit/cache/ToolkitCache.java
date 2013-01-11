/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.cache;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException;
import org.terracotta.toolkit.store.ToolkitStore;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * A toolkit cache. Its extends from {@link ToolkitStore} and has additional functionalities as a cache. The main
 * difference between a store and a cache is that eviction can happen on caches, while it won't in case of key-value
 * stores. A toolkit cache can be configured using various configs available in {@link ToolkitCacheConfigFields}.
 * Consult {@link Toolkit#getCache(String, Configuration, Class<V>)} for more info on various configs.
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 * <p>
 * Trying to add values that are not serializable will throw {@link NotSerializableRuntimeException}
 */
public interface ToolkitCache<K, V> extends ToolkitStore<K, V> {

  /**
   * Same as {@link ToolkitStore#get(Object)} but does not update the lastAccessedTime
   * 
   * @param key the key
   * @return value mapped to the key or null otherwise
   */
  V getQuiet(Object key);

  /**
   * Similar to {@link ToolkitStore#getAll(Collection)}, but doesn't update lastAccessedTime
   * 
   * @param keys the collection of keys to lookup
   * @return a map of keys and the value mapped to the given key (but not necessarily the current mapping)
   */
  Map<K, V> getAllQuiet(final Collection<K> keys);

  /**
   * Similar to {@link ToolkitStore#putNoReturn(Object, Object)} but with ability to specify creation time, tti, ttl etc
   * 
   * @param key the key
   * @param value the value
   * @param createTimeInSecs creation time in seconds since epoch
   * @param maxTTISeconds tti of the entry
   * @param maxTTLSeconds ttl of the entry
   */
  void putNoReturn(K key, V value, long createTimeInSecs, int maxTTISeconds, int maxTTLSeconds);

  /**
   * Similar to {@link ConcurrentMap#putIfAbsent(Object, Object)} but with ability to specify creation time, tti, ttl
   * etc.
   * 
   * @param key the key
   * @param value the value
   * @param createTimeInSecs creation time in seconds since epoch
   * @param maxTTISeconds tti of the entry
   * @param maxTTLSeconds ttl of the entry
   */
  V putIfAbsent(K key, V value, long createTimeInSecs, int maxTTISeconds, int maxTTLSeconds);

  /**
   * Adds a listener to this cache - the listener will not be added again if it's already registered. Listeners are
   * notified in the order they are added.
   */
  void addListener(ToolkitCacheListener<K> listener);

  /**
   * Removes a registered listener from this cache. Does nothing if the {@code listener} is not registered already
   */
  void removeListener(ToolkitCacheListener<K> listener);
}
