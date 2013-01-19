/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.builder;

import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.store.ToolkitConfigFields;
import org.terracotta.toolkit.store.ToolkitConfigFields.Consistency;

import java.io.Serializable;

/**
 * A helper to build a {@link Configuration} for {@link ToolkitCache}. Builds up configuration based on
 * {@link ToolkitConfigFields}
 */
public final class ToolkitCacheConfigBuilder extends AbstractToolkitStoreCacheConfigBuilder {

  private int          maxTTISeconds;
  private int          maxTTLSeconds;
  private int          maxTotalCount;
  private boolean      pinnedInLocalMemory;
  private boolean      evictionEnabled;

  /**
   * Sets the concurrency config to the new value and returns {@code this}
   * 
   * @param concurrencyParam new value of concurrency.
   * @return same instance
   * @throws IllegalArgumentException for non-positive <tt>concurrency</tt> params
   */
  public ToolkitCacheConfigBuilder concurrency(int concurrencyParam) throws IllegalArgumentException {
    setConcurrency(concurrencyParam);
    return this;
  }

  /**
   * Sets the {@link Consistency} of the key-value store
   * 
   * @return same instance
   */
  public ToolkitCacheConfigBuilder consistency(Consistency consistencyParam) {
    setConsistency(consistencyParam);
    return this;
  }

  /**
   * Sets the maxBytesLocalHeap
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative values
   */
  public ToolkitCacheConfigBuilder maxBytesLocalHeap(long maxBytesLocalHeapParam)
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
  public ToolkitCacheConfigBuilder maxBytesLocalOffheap(long maxBytesLocalOffheapParam)
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
  public ToolkitCacheConfigBuilder maxCountLocalHeap(int maxCountLocalHeapParam)
      throws IllegalArgumentException {
    setMaxCountLocalHeap(maxCountLocalHeapParam);
    return this;
  }

  /**
   * Sets offheap enabled
   * 
   * @return same instance
   */
  public ToolkitCacheConfigBuilder offheapEnabled(boolean offheapEnabledParam) {
    setOffheapEnabled(offheapEnabledParam);
    return this;
  }

  /**
   * Sets local cache enabled
   * 
   * @return same instance
   */
  public ToolkitCacheConfigBuilder localCacheEnabled(boolean localCacheEnabledParam) {
    setLocalCacheEnabled(localCacheEnabledParam);
    return this;
  }

  /**
   * Sets compression enabled
   * 
   * @return same instance
   */
  public ToolkitCacheConfigBuilder compressionEnabled(boolean compressionEnabledParam) {
    setCompressionEnabled(compressionEnabledParam);
    return this;
  }

  /**
   * Sets copy on read enabled
   * 
   * @return same instance
   */
  public ToolkitCacheConfigBuilder copyOnReadEnabled(boolean copyOnReadEnabledParam) {
    setCopyOnReadEnabled(copyOnReadEnabledParam);
    return this;
  }

  /**
   * Sets whether entries should be pinned in local memory
   *
   * @return same instance
   */
  public ToolkitCacheConfigBuilder pinnedInLocalMemory(boolean pinnedInLocalMemory) {
    this.pinnedInLocalMemory = pinnedInLocalMemory;
    addFieldToApply(ToolkitConfigFields.PINNED_IN_LOCAL_MEMORY_FIELD_NAME, pinnedInLocalMemory);
    return this;
  }

  /**
   * Return whether entries are pinned in local memory.
   *
   * @return true for pinning in local memory
   */
  public boolean isPinnedInLocalMemory() {
    return pinnedInLocalMemory;
  }

  /**
   * Max TTI in seconds for the map. Zero means no TTI
   * 
   * @return max tti
   */
  public int getMaxTTISeconds() {
    return maxTTISeconds;
  }

  /**
   * Sets the TTI in seconds for the config to the new value and returns <tt>this</tt>. Zero means no TTI.
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative parameters
   */
  public ToolkitCacheConfigBuilder maxTTISeconds(int maxTTISecondsParam) throws IllegalArgumentException {
    this.maxTTISeconds = maxTTISecondsParam;
    addFieldToApply(ToolkitConfigFields.MAX_TTI_SECONDS_FIELD_NAME, maxTTISeconds);
    return this;
  }

  /**
   * Max TTL in seconds for the map. Zero means no TTL
   * 
   * @return max ttl
   */
  public int getMaxTTLSeconds() {
    return maxTTLSeconds;
  }

  /**
   * Sets the TTL in seconds for the config to the new value and returns <tt>this</tt>. Zero means no TTL.
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative parameters
   */
  public ToolkitCacheConfigBuilder maxTTLSeconds(int maxTTLSecondsParam) throws IllegalArgumentException {
    this.maxTTLSeconds = maxTTLSecondsParam;
    addFieldToApply(ToolkitConfigFields.MAX_TTL_SECONDS_FIELD_NAME, maxTTLSeconds);
    return this;
  }

  /**
   * Returns max total count
   * 
   * @return max total count
   */
  public int getMaxTotalCount() {
    return maxTotalCount;
  }

  /**
   * Sets max total count
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative parameters
   */
  public ToolkitCacheConfigBuilder maxTotalCount(int maxTotalCountParam) throws IllegalArgumentException {
    this.maxTotalCount = maxTotalCountParam;
    addFieldToApply(ToolkitConfigFields.MAX_TOTAL_COUNT_FIELD_NAME, maxTotalCount);
    return this;
  }

  /**
   * Returns eviction enabled
   *
   * @return eviction enabled
   */
  public boolean isEvictionEnabled() {
    return evictionEnabled;
  }

  /**
   * Sets eviction enabled/disabled
   *
   * @return same instance
   */
  public ToolkitCacheConfigBuilder evictionEnabled(boolean evictionEnabledParam) {
    this.evictionEnabled = evictionEnabledParam;
    addFieldToApply(ToolkitConfigFields.EVICTION_ENABLED_FIELD_NAME, evictionEnabled);
    return this;
  }

  public ToolkitCacheConfigBuilder configField(String fieldName, Serializable value) {
    setConfigField(fieldName, value);
    return this;
  }

  /**
   * Builds a {@link Configuration} for {@link ToolkitCache} by filling in appropriate mappings. Only adds mappings for
   * values which were set explicitly in this builder, and doesn’t fills in default values in the returned config.
   * Consult {@link ToolkitConfigFields}, {@link ToolkitConfigFields} for the various configs supported and its default
   * values
   */
  @Override
  public Configuration build() {
    return super.build();
  }

  /**
   * Applies the current changes from the builder to the {@link ToolkitCache}. The changes are the ones between each
   * apply.
   */
  @Override
  public void apply(ToolkitCache cache) {
    super.apply(cache);
  }
}