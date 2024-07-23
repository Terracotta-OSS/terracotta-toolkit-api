/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.builder;

import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.store.ToolkitConfigFields;
import org.terracotta.toolkit.store.ToolkitConfigFields.Consistency;
import org.terracotta.toolkit.store.ToolkitStore;

import java.io.Serializable;

/**
 * A helper to build a {@link Configuration} for {@link ToolkitStore}. Builds up configuration based on
 * {@link ToolkitConfigFields}
 */
public final class ToolkitStoreConfigBuilder extends AbstractToolkitStoreCacheConfigBuilder {

  /**
   * Sets the concurrency config to the new value and returns {@code this}
   * 
   * @return same instance
   * @throws IllegalArgumentException for non-positive <tt>concurrency</tt> params
   */
  public ToolkitStoreConfigBuilder concurrency(int concurrencyParam) throws IllegalArgumentException {
    setConcurrency(concurrencyParam);
    return this;
  }

  /**
   * Sets the {@link Consistency} of the key-value store
   * 
   * @return same instance
   */
  public ToolkitStoreConfigBuilder consistency(Consistency consistencyParam) {
    setConsistency(consistencyParam);
    return this;
  }

  /**
   * Sets whether entries should be pinned in local memory
   *
   * @return same instance
   */
  public ToolkitStoreConfigBuilder pinnedInLocalMemory(boolean pinnedInLocalMemory) {
    setPinnedInLocalMemory(pinnedInLocalMemory);
    return this;
  }

  /**
   * Sets the maxBytesLocalHeap
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative values
   */
  public ToolkitStoreConfigBuilder maxBytesLocalHeap(long maxBytesLocalHeapParam)
      throws IllegalArgumentException {

    setMaxBytesLocalHeap(maxBytesLocalHeapParam);
    return this;
  }

  /**
   * Sets the max bytes local offheap
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative values
   */
  public ToolkitStoreConfigBuilder maxBytesLocalOffheap(long maxBytesLocalOffheapParam)
      throws IllegalArgumentException {
    setMaxBytesLocalOffheap(maxBytesLocalOffheapParam);
    return this;
  }

  /**
   * Sets the max count local heap
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative values
   */
  public ToolkitStoreConfigBuilder maxCountLocalHeap(int maxCountLocalHeapParam)
      throws IllegalArgumentException {
    setMaxCountLocalHeap(maxCountLocalHeapParam);
    return this;
  }

  /**
   * Sets offheap enabled
   * 
   * @return same instance
   */
  public ToolkitStoreConfigBuilder offheapEnabled(boolean offheapEnabledParam) {
    setOffheapEnabled(offheapEnabledParam);
    return this;
  }

  /**
   * Sets local cache enabled
   * 
   * @return same instance
   */
  public ToolkitStoreConfigBuilder localCacheEnabled(boolean localCacheEnabledParam) {
    setLocalCacheEnabled(localCacheEnabledParam);
    return this;
  }

  /**
   * Sets compression enabled
   * 
   * @return same instance
   */
  public ToolkitStoreConfigBuilder compressionEnabled(boolean compressionEnabledParam) {
    setCompressionEnabled(compressionEnabledParam);
    return this;
  }

  /**
   * Sets copy on read enabled
   * 
   * @return same instance
   */
  public ToolkitStoreConfigBuilder copyOnReadEnabled(boolean copyOnReadEnabledParam) {
    setCopyOnReadEnabled(copyOnReadEnabledParam);
    return this;
  }

  public ToolkitStoreConfigBuilder configField(String fieldName, Serializable value) {
    setConfigField(fieldName, value);
    return this;
  }

}
