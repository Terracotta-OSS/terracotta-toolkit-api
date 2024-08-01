/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.cache;

/**
 * A listener that can be added to {@link ToolkitCache} and get notified on eviction and expiration events
 */
public interface ToolkitCacheListener<K> {

  /**
   * Called when the key gets evicted from the cache
   */
  public void onEviction(K key);

  /**
   * Called when the key gets expired from the cache
   */
  public void onExpiration(K key);
}
