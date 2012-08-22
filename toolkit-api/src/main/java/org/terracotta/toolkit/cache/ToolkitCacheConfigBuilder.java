/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.cache;

import org.terracotta.toolkit.cache.ToolkitCacheConfigFields.PinningStore;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.store.ToolkitStoreConfigBuilder;
import org.terracotta.toolkit.store.ToolkitStoreConfigFields;
import org.terracotta.toolkit.store.ToolkitStoreConfigFields.Consistency;

/**
 * A helper to build a {@link Configuration} for {@link ToolkitCache}. Builds up configuration based on
 * {@link ToolkitCacheConfigFields}
 */
public class ToolkitCacheConfigBuilder extends ToolkitStoreConfigBuilder {

  private int          maxTTISeconds;
  private int          maxTTLSeconds;
  private int          maxTotalCount;
  private PinningStore pinningStore;

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder concurrency(int concurrencyParam) throws IllegalArgumentException {
    super.concurrency(concurrencyParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder consistency(Consistency consistencyParam) {
    super.consistency(consistencyParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder maxBytesLocalHeap(long maxBytesLocalHeapParam) throws IllegalArgumentException {
    super.maxBytesLocalHeap(maxBytesLocalHeapParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder maxBytesLocalOffheap(long maxBytesLocalOffheapParam) throws IllegalArgumentException {
    super.maxBytesLocalOffheap(maxBytesLocalOffheapParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder maxCountLocalHeap(int maxCountLocalHeapParam) throws IllegalArgumentException {
    super.maxCountLocalHeap(maxCountLocalHeapParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder offheapEnabled(boolean offheapEnabledParam) {
    super.offheapEnabled(offheapEnabledParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder localCacheEnabled(boolean localCacheEnabledParam) {
    super.localCacheEnabled(localCacheEnabledParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder copyOnReadEnabled(boolean copyOnReadEnabledParam) {
    super.copyOnReadEnabled(copyOnReadEnabledParam);
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ToolkitCacheConfigBuilder compressionEnabled(boolean compressionEnabledParam) {
    super.compressionEnabled(compressionEnabledParam);
    return this;
  }

  /**
   * Set the pinning store config
   * 
   * @return same instance
   */
  public synchronized ToolkitCacheConfigBuilder pinningStore(PinningStore pinningStoreParam) {
    pinningStore = pinningStoreParam;
    addFieldToApply(ToolkitCacheConfigFields.PINNING_STORE_FIELD_NAME, pinningStoreParam.name());
    return this;
  }

  /**
   * Getter for pinning store
   * 
   * @return the pinning store
   */
  public synchronized PinningStore getPinningStore() {
    return pinningStore;
  }

  /**
   * Max TTI in seconds for the map. Zero means no TTI
   * 
   * @return max tti
   */
  public synchronized int getMaxTTISeconds() {
    return maxTTISeconds;
  }

  /**
   * Sets the TTI in seconds for the config to the new value and returns <tt>this</tt>. Zero means no TTI.
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative parameters
   */
  public synchronized ToolkitCacheConfigBuilder maxTTISeconds(int maxTTISecondsParam) throws IllegalArgumentException {
    this.maxTTISeconds = maxTTISecondsParam;
    addFieldToApply(ToolkitCacheConfigFields.MAX_TTI_SECONDS_FIELD_NAME, maxTTISeconds);
    return this;
  }

  /**
   * Max TTL in seconds for the map. Zero means no TTL
   * 
   * @return max ttl
   */
  public synchronized int getMaxTTLSeconds() {
    return maxTTLSeconds;
  }

  /**
   * Sets the TTL in seconds for the config to the new value and returns <tt>this</tt>. Zero means no TTL.
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative parameters
   */
  public synchronized ToolkitCacheConfigBuilder maxTTLSeconds(int maxTTLSecondsParam) throws IllegalArgumentException {
    this.maxTTLSeconds = maxTTLSecondsParam;
    addFieldToApply(ToolkitCacheConfigFields.MAX_TTL_SECONDS_FIELD_NAME, maxTTLSeconds);
    return this;
  }

  /**
   * Returns max total count
   * 
   * @return max total count
   */
  public synchronized int getMaxTotalCount() {
    return maxTotalCount;
  }

  /**
   * Sets max total count
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative parameters
   */
  public synchronized ToolkitCacheConfigBuilder maxTotalCount(int maxTotalCountParam) throws IllegalArgumentException {
    this.maxTotalCount = maxTotalCountParam;
    addFieldToApply(ToolkitCacheConfigFields.MAX_TOTAL_COUNT_FIELD_NAME, maxTotalCount);
    return this;
  }

  /**
   * Builds a {@link Configuration} for {@link ToolkitCache} by filling in appropriate mappings. Only adds mappings for
   * values which were set explicitly in this builder, and doesn’t fills in default values in the returned config.
   * Consult {@link ToolkitCacheConfigFields}, {@link ToolkitStoreConfigFields} for the various configs supported and
   * its default values
   */
  @Override
  public Configuration build() {
    return super.build();
  }

  /**
   * Applies the current changes from the builder to the {@link ToolkitCache}. The changes are the ones between each
   * apply.
   */
  public void apply(ToolkitCache cache) {
    super.apply(cache);
  }
}