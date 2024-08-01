/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.toolkit.cache;

import org.terracotta.toolkit.bulkload.ToolkitBulkLoadObject;
import org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitObject;
import org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException;
import org.terracotta.toolkit.search.SearchableMap;
import org.terracotta.toolkit.store.ToolkitConfigFields;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * A toolkit cache. A toolkit cache can be configured using various configs available in {@link ToolkitConfigFields}.
 * Consult {@link org.terracotta.toolkit.Toolkit#getCache(String, Configuration, Class)} for more info on various
 * configs.
 * <p>
 * Consult the {@link org.terracotta.toolkit.Toolkit class level docs} for more info on behavior regarding destroy.
 * <p>
 * Trying to add values that are not serializable will throw {@link NotSerializableRuntimeException}
 */
public interface ToolkitCache<K, V> extends ConcurrentMap<K, V>, Destroyable, SearchableMap<K, V>,
    ToolkitBulkLoadObject {
  /**
   * Behaves the same as the standard {@link #remove(Object)} method except that the previous value is not returned.
   * This may provide significant performance improvements when the old value is not required.
   * 
   * @param key the key of the entry to remove
   */
  void removeNoReturn(Object key);

  /**
   * Behaves the same as the standard {@link #put(Object, Object)} method except that the previous value is not
   * returned. This may provide significant performance improvements when old value is not required.
   * 
   * @param key the key of the entry
   * @param value the value of the entry
   */
  void putNoReturn(K key, V value);

  /**
   * Perform get for the given set of keys. Keys which are not present in the Cache will have null values associated
   * with them in the returned map. The returned map is unmodifiable.
   * 
   * @param keys the collection of keys to lookup
   * @return a map of keys and the value mapped to the given key (but not necessarily the current mapping)
   */
  Map<K, V> getAll(final Collection<? extends K> keys);

  /**
   * Returns the configuration of this cache.
   * 
   * @return the configuration of this cache
   */
  Configuration getConfiguration();

  /**
   * Updates the configuration of the Cache using passed in value. Throws {@link IllegalArgumentException} if the config
   * field {@code name} is not dynamic and cannot be changed at runtime
   */
  void setConfigField(String name, Serializable value);

  /**
   * Creates a {@link ToolkitReadWriteLock} for the given key.
   * <p>
   * <b>NOTE</b>: {@link ToolkitObject#getName()} on the {@code ToolkitReadWriteLock},
   * {@code ToolkitReadWriteLock.readLock()} and {@code ToolkitReadWriteLock.writeLock()} will return null
   * 
   * @param key the key for which a lock will be returned
   * @return an instance of {@link ToolkitReadWriteLock} that can be used to perform primitive locking operations on the
   *         key
   */
  ToolkitReadWriteLock createLockForKey(K key);

  /**
   * Same as {@link ToolkitCache#get(Object)} but does not update the lastAccessedTime
   * 
   * @param key the key
   * @return value mapped to the key or null otherwise
   */
  V getQuiet(Object key);

  /**
   * Similar to {@link ToolkitCache#getAll(Collection)}, but doesn't update lastAccessedTime
   * 
   * @param keys the collection of keys to lookup
   * @return a map of keys and the value mapped to the given key (but not necessarily the current mapping)
   */
  Map<K, V> getAllQuiet(final Collection<K> keys);

  /**
   * Similar to {@link ToolkitCache#putNoReturn(Object, Object)} but with ability to specify creation time, tti, ttl etc
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
   * @return the previous value associated with the specified key, or <tt>null</tt> if there was no mapping for the key.
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
