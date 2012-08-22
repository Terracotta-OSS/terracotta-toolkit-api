/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.cache;

import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.internal.meta.MetaData;
import org.terracotta.toolkit.internal.search.SearchBuilder;

import java.util.Collection;
import java.util.Map;

/**
 * A {@link ToolkitCache} that supports MetaData while mutating the map
 */
public interface ToolkitCacheWithMetadata<K, V> extends ToolkitCache<K, V> {
  /**
   * Creates a MetaData with specified category
   */
  MetaData createMetaData(String category);

  /**
   * Creates an instance of {@link EntryWithMetaData}
   */
  EntryWithMetaData<K, V> createEntryWithMetaData(K key, V value, MetaData metaData);

  /**
   * Sets the callback for this clustered cache
   */
  void setMetaDataCallback(ToolkitCacheMetaDataCallback callback);

  /**
   * putNoReturn with meta data
   */
  void putNoReturnWithMetaData(K key, V value, MetaData metaData);

  /**
   * putNoReturn with meta data and custom tti/ttl
   */
  void putNoReturnWithMetaData(K key, V value, int createTimeInSecs, int customMaxTTISeconds, int customMaxTTLSeconds,
                               MetaData metaData);

  /**
   * putIfAbsent with meta data
   */
  V putIfAbsentWithMetaData(K key, V value, MetaData metaData);

  /**
   * putIfAbsent with meta data and custom tti/ttl
   */
  V putIfAbsentWithMetaData(K key, V value, int createTimeInSecs, int customMaxTTISeconds, int customMaxTTLSeconds,
                            MetaData metaData);

  /**
   * clear with meta data
   */
  void clearWithMetaData(MetaData metaData);

  /**
   * removeNoReturn with meta data
   */
  void removeNoReturnWithMetaData(Object key, MetaData metaData);

  /**
   * remove with meta data
   */
  V removeWithMetaData(Object key, MetaData metaData);

  /**
   * remove with two arguments and meta data
   */
  boolean removeWithMetaData(Object key, Object value, MetaData metaData);

  /**
   * Process meta-data. Only supported in enterprise version
   */
  SearchBuilder createSearchBuilder();

  /**
   * put with meta data
   */
  V putWithMetaData(K key, V value, MetaData metaData);

  /**
   * put with meta data
   */
  V putWithMetaData(K key, V value, int createTimeInSecs, int customMaxTTISeconds, int customMaxTTLSeconds,
                    MetaData metaData);

  /**
   * Puts all entries from the passed in collections
   */
  void putAllWithMetaData(Collection<EntryWithMetaData<K, V>> entries);

  /**
   * Removes all entries using keys from the passed in collection. The value in each entry in the collection is ignored
   */
  void removeAllWithMetaData(Collection<EntryWithMetaData<K, V>> entries);

  /**
   * A {@link Entry} which is also associated with a metaData
   */
  public interface EntryWithMetaData<K, V> extends Map.Entry<K, V> {
    /**
     * Returns the {@link MetaData} associated with this entry
     * 
     * @return the {@link MetaData} associated with this entry
     */
    MetaData getMetaData();

    /**
     * This method is not supported and always throws {@link UnsupportedOperationException}
     */
    @Override
    V setValue(V value);
  }

}
