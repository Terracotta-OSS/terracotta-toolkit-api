package org.terracotta.toolkit.internal.cache;

/**
 * @author Eugene Shelestovich
 */
public interface VersionUpdateListener<K, V> {

  void onLocalPut(K key, V value, long version);

  void onLocalRemove(K key, long version);
}
