/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.store;

import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.concurrent.locks.ToolkitReadWriteLock;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.object.Destroyable;
import org.terracotta.toolkit.object.ToolkitObject;
import org.terracotta.toolkit.object.serialization.NotSerializableRuntimeException;
import org.terracotta.toolkit.search.SearchableMap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * A Key-Value store used for storing key-value mappings. No eviction can happen on a Store. A key-value store can be
 * configured using various configs available in {@link ToolkitConfigFields}. Consult
 * {@link Toolkit#getStore(String, Configuration, Class)} for more info on various configs.
 * <p>
 * Consult the {@linkplain Toolkit Toolkit class level docs} for more info on behavior regarding destroy.
 * <p>
 * Trying to add values that are not serializable will throw {@link NotSerializableRuntimeException}.
 */
public interface ToolkitStore<K, V> extends ConcurrentMap<K, V>, Destroyable, ToolkitObject, SearchableMap<K, V> {
  /**
   * Check if the value is contained in the store. Optional operation, some implementation may throw
   * {@code UnsupportedOperationException}
   * 
   * @return Check if the value is contained in the store.
   */
  @Override
  public boolean containsValue(Object value);

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
   * Perform get for the given set of keys. Keys which are not present in the Store will have null values associated
   * with them in the returned map. The returned map is unmodifiable.
   * 
   * @param keys the collection of keys to lookup
   * @return a map of keys and the value mapped to the given key (but not necessarily the current mapping)
   */
  Map<K, V> getAll(final Collection<? extends K> keys);

  /**
   * Returns the configuration of this key-value store.
   * 
   * @return the configuration of this key-value store
   */
  Configuration getConfiguration();

  /**
   * Updates the configuration of the Store using passed in value. Throws {@link IllegalArgumentException} if the config
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
}
