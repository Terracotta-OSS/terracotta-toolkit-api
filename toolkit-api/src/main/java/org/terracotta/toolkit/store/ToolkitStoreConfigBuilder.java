/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.store;

import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.store.ToolkitStoreConfigFields.Consistency;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A helper to build a {@link Configuration} for {@link ToolkitStore}. Builds up configuration based on
 * {@link ToolkitStoreConfigFields}
 */
public class ToolkitStoreConfigBuilder {

  private int                                 concurrency;
  private Consistency                         consistency;
  private long                                maxBytesLocalHeap;
  private long                                maxBytesLocalOffheap;
  private int                                 maxCountLocalHeap;
  private boolean                             localCacheEnabled;
  private boolean                             offheapEnabled;

  private final ArrayList<ConfigFieldMapping> fieldMappings = new ArrayList<ConfigFieldMapping>();

  private boolean                             compressionEnabled;
  private boolean                             copyOnReadEnabled;

  protected void addFieldToApply(String name, Serializable value) {
    fieldMappings.add(new ConfigFieldMapping(name, value));
  }

  /**
   * Concurrency of the store
   * 
   * @return Concurrency of the store
   */
  public synchronized int getConcurrency() {
    return concurrency;
  }

  /**
   * Sets the concurrency config to the new value and returns {@code this}
   * 
   * @param concurrency new value of concurrency.
   * @return same instance
   * @throws IllegalArgumentException for non-positive <tt>concurrency</tt> params
   */
  public synchronized ToolkitStoreConfigBuilder concurrency(int concurrencyParam) throws IllegalArgumentException {
    this.concurrency = concurrencyParam;
    addFieldToApply(ToolkitStoreConfigFields.CONCURRENCY_FIELD_NAME, this.concurrency);
    return this;
  }

  /**
   * Getter for consistency
   * 
   * @return {@link Consistency} of the key-value store
   */
  public synchronized Consistency getConsistency() {
    return this.consistency;
  }

  /**
   * Sets the {@link Consistency} of the key-value store
   * 
   * @return same instance
   */
  public synchronized ToolkitStoreConfigBuilder consistency(Consistency consistencyParam) {
    this.consistency = consistencyParam;
    addFieldToApply(ToolkitStoreConfigFields.CONSISTENCY_FIELD_NAME, this.consistency.name());
    return this;
  }

  /**
   * Gets the max bytes local heap
   * 
   * @return max bytes local heap
   */
  public synchronized long getMaxBytesLocalHeap() {
    return this.maxBytesLocalHeap;
  }

  /**
   * Sets the maxBytesLocalHeap
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative values
   */
  public synchronized ToolkitStoreConfigBuilder maxBytesLocalHeap(long maxBytesLocalHeapParam)
      throws IllegalArgumentException {

    this.maxBytesLocalHeap = maxBytesLocalHeapParam;
    addFieldToApply(ToolkitStoreConfigFields.MAX_BYTES_LOCAL_HEAP_FIELD_NAME, this.maxBytesLocalHeap);
    return this;
  }

  /**
   * Gets the max bytes local offheap
   * 
   * @return max bytes local offheap
   */
  public synchronized long getMaxBytesLocalOffheap() {
    return maxBytesLocalOffheap;
  }

  /**
   * Sets the max bytes local offheap
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative values
   */
  public synchronized ToolkitStoreConfigBuilder maxBytesLocalOffheap(long maxBytesLocalOffheapParam)
      throws IllegalArgumentException {
    this.maxBytesLocalOffheap = maxBytesLocalOffheapParam;
    addFieldToApply(ToolkitStoreConfigFields.MAX_BYTES_LOCAL_OFFHEAP_FIELD_NAME, this.maxBytesLocalOffheap);
    return this;
  }

  /**
   * Gets the max count local heap
   * 
   * @return max count local heap
   */
  public synchronized long getMaxCountLocalHeap() {
    return this.maxCountLocalHeap;
  }

  /**
   * Sets the max count local heap
   * 
   * @return same instance
   * @throws IllegalArgumentException for negative values
   */
  public synchronized ToolkitStoreConfigBuilder maxCountLocalHeap(int maxCountLocalHeapParam)
      throws IllegalArgumentException {
    this.maxCountLocalHeap = maxCountLocalHeapParam;
    addFieldToApply(ToolkitStoreConfigFields.MAX_COUNT_LOCAL_HEAP_FIELD_NAME, this.maxCountLocalHeap);
    return this;
  }

  /**
   * Returns true if offheap is enabled
   * 
   * @return true if offheap is enabled, otherwise false
   */
  public synchronized boolean isOffheapEnabled() {
    return offheapEnabled;
  }

  /**
   * Sets offheap enabled
   * 
   * @return same instance
   */
  public synchronized ToolkitStoreConfigBuilder offheapEnabled(boolean offheapEnabledParam) {
    this.offheapEnabled = offheapEnabledParam;
    addFieldToApply(ToolkitStoreConfigFields.OFFHEAP_ENABLED_FIELD_NAME, this.offheapEnabled);
    return this;
  }

  /**
   * Query whether local cache is enabled or not
   * 
   * @return true if local cache is enabled, otherwise false
   */
  public synchronized boolean isLocalCacheEnabled() {
    return localCacheEnabled;
  }

  /**
   * Sets local cache enabled
   * 
   * @return same instance
   */
  public synchronized ToolkitStoreConfigBuilder localCacheEnabled(boolean localCacheEnabledParam) {
    this.localCacheEnabled = localCacheEnabledParam;
    addFieldToApply(ToolkitStoreConfigFields.LOCAL_CACHE_ENABLED_FIELD_NAME, this.localCacheEnabled);
    return this;
  }

  /**
   * Compression enabled or not getter
   * 
   * @return whether compression is enabled
   */
  public synchronized boolean isCompressionEnabled() {
    return compressionEnabled;
  }

  /**
   * Sets compression enabled
   * 
   * @return same instance
   */
  public synchronized ToolkitStoreConfigBuilder compressionEnabled(boolean compressionEnabledParam) {
    this.compressionEnabled = compressionEnabledParam;
    addFieldToApply(ToolkitStoreConfigFields.COMPRESSION_ENABLED_FIELD_NAME, this.compressionEnabled);
    return this;
  }

  /**
   * copy-on-read enabled or not getter
   * 
   * @return true if copy on read is enabled, otherwise false
   */
  public synchronized boolean isCopyOnReadEnabled() {
    return copyOnReadEnabled;
  }

  /**
   * Sets copy on read enabled
   * 
   * @return same instance
   */
  public synchronized ToolkitStoreConfigBuilder copyOnReadEnabled(boolean copyOnReadEnabledParam) {
    this.copyOnReadEnabled = copyOnReadEnabledParam;
    addFieldToApply(ToolkitStoreConfigFields.COPY_ON_READ_ENABLED_FIELD_NAME, this.copyOnReadEnabled);
    return this;
  }

  /**
   * Builds a {@link Configuration} for {@link ToolkitStore} by filling in appropriate mappings. Only adds mappings for
   * values which were set explicitly in this builder, and doesn’t fills in default values in the returned config.
   * Consult {@link ToolkitStoreConfigFields} for the various configs supported and its default values
   */
  public synchronized Configuration build() {
    ConfigurationImpl configuration = new ConfigurationImpl();
    for (ConfigFieldMapping field : fieldMappings) {
      field.updateConfig(configuration);
    }
    return configuration;
  }

  /**
   * Apply changes of this builder to the {@link ToolkitStore} parameter. The changes are the ones between each apply.
   * <p>
   * If the store's configuration has {@link ToolkitStoreConfigFields#MAX_BYTES_LOCAL_HEAP_FIELD_NAME} property set then
   * {@link ToolkitStoreConfigBuilder#maxCountLocalHeap(long)} would result in an error.
   * <p>
   * If the store's configuration has {@link ToolkitStoreConfigFields#MAX_COUNT_LOCAL_HEAP_FIELD_NAME} property set then
   * {@link ToolkitStoreConfigBuilder#maxBytesLocalHeap(long)} would result in an error.
   */
  public synchronized void apply(ToolkitStore store) {
    for (Iterator<ConfigFieldMapping> iter = fieldMappings.iterator(); iter.hasNext();) {
      ConfigFieldMapping field = iter.next();
      field.apply(store);
      iter.remove();
    }
  }

  private static class ConfigFieldMapping {
    private final String       fieldName;
    private final Serializable value;

    public ConfigFieldMapping(String fieldName, Serializable value) {
      this.fieldName = fieldName;
      this.value = value;
    }

    void apply(ToolkitStore map) {
      map.setConfigField(fieldName, value);
    }

    void updateConfig(ConfigurationImpl configuration) {
      configuration.internalSetConfigMapping(fieldName, value);
    }
  }
}
