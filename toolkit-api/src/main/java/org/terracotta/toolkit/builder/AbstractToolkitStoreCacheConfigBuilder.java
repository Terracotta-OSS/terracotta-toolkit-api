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
package org.terracotta.toolkit.builder;

import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.store.ToolkitConfigFields;
import org.terracotta.toolkit.store.ToolkitConfigFields.Consistency;
import org.terracotta.toolkit.store.ToolkitStore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class AbstractToolkitStoreCacheConfigBuilder {
  private int                                 concurrency;
  private Consistency                         consistency;
  private long                                maxBytesLocalHeap;
  private long                                maxBytesLocalOffheap;
  private int                                 maxCountLocalHeap;
  private boolean                             localCacheEnabled;
  private boolean                             offheapEnabled;

  private boolean                             compressionEnabled;
  private boolean                             copyOnReadEnabled;
  private boolean                             pinnedInLocalMemory;

  private final List<ConfigFieldMapping> fieldMappings = new ArrayList<ConfigFieldMapping>();

  protected void addFieldToApply(String name, Serializable value) {
    fieldMappings.add(new ConfigFieldMapping(name, value));
  }

  /**
   * Concurrency of the store
   * 
   * @return Concurrency of the store
   */
  public int getConcurrency() {
    return concurrency;
  }

  /**
   * Getter for consistency
   * 
   * @return {@link Consistency} of the key-value store
   */
  public Consistency getConsistency() {
    return this.consistency;
  }

  /**
   * Gets the max bytes local heap
   * 
   * @return max bytes local heap
   */
  public long getMaxBytesLocalHeap() {
    return this.maxBytesLocalHeap;
  }

  /**
   * Gets the max bytes local offheap
   * 
   * @return max bytes local offheap
   */
  public long getMaxBytesLocalOffheap() {
    return maxBytesLocalOffheap;
  }

  /**
   * Gets the max count local heap
   * 
   * @return max count local heap
   */
  public long getMaxCountLocalHeap() {
    return this.maxCountLocalHeap;
  }

  /**
   * Returns true if offheap is enabled
   * 
   * @return true if offheap is enabled, otherwise false
   */
  public boolean isOffheapEnabled() {
    return offheapEnabled;
  }

  /**
   * Query whether local cache is enabled or not
   * 
   * @return true if local cache is enabled, otherwise false
   */
  public boolean isLocalCacheEnabled() {
    return localCacheEnabled;
  }

  /**
   * Compression enabled or not getter
   * 
   * @return whether compression is enabled
   */
  public boolean isCompressionEnabled() {
    return compressionEnabled;
  }

  /**
   * Sets whether entries should be pinned in local memory
   */
  public void setPinnedInLocalMemory(boolean pinnedInLocalMemory) {
    this.pinnedInLocalMemory = pinnedInLocalMemory;
    addFieldToApply(ToolkitConfigFields.PINNED_IN_LOCAL_MEMORY_FIELD_NAME, this.pinnedInLocalMemory);
  }

  public boolean isPinnedInLocalMemory() {
    return pinnedInLocalMemory;
  }

  /**
   * copy-on-read enabled or not getter
   * 
   * @return true if copy on read is enabled, otherwise false
   */
  public boolean isCopyOnReadEnabled() {
    return copyOnReadEnabled;
  }

  protected void setConcurrency(int concurrencyParam) throws IllegalArgumentException {
    this.concurrency = concurrencyParam;
    addFieldToApply(ToolkitConfigFields.CONCURRENCY_FIELD_NAME, this.concurrency);
  }

  /**
   * Sets the {@link Consistency} of the key-value store
   */
  protected void setConsistency(Consistency consistencyParam) {
    this.consistency = consistencyParam;
    addFieldToApply(ToolkitConfigFields.CONSISTENCY_FIELD_NAME, this.consistency.name());
  }

  /**
   * Sets the maxBytesLocalHeap
   * 
   * @throws IllegalArgumentException for negative values
   */
  protected void setMaxBytesLocalHeap(long maxBytesLocalHeapParam) throws IllegalArgumentException {

    this.maxBytesLocalHeap = maxBytesLocalHeapParam;
    addFieldToApply(ToolkitConfigFields.MAX_BYTES_LOCAL_HEAP_FIELD_NAME, this.maxBytesLocalHeap);
  }

  /**
   * Sets the max bytes local offheap
   * 
   * @throws IllegalArgumentException for negative values
   */
  protected void setMaxBytesLocalOffheap(long maxBytesLocalOffheapParam) throws IllegalArgumentException {
    this.maxBytesLocalOffheap = maxBytesLocalOffheapParam;
    addFieldToApply(ToolkitConfigFields.MAX_BYTES_LOCAL_OFFHEAP_FIELD_NAME, this.maxBytesLocalOffheap);
  }

  /**
   * Sets the max count local heap
   * 
   * @throws IllegalArgumentException for negative values
   */
  protected void setMaxCountLocalHeap(int maxCountLocalHeapParam) throws IllegalArgumentException {
    this.maxCountLocalHeap = maxCountLocalHeapParam;
    addFieldToApply(ToolkitConfigFields.MAX_COUNT_LOCAL_HEAP_FIELD_NAME, this.maxCountLocalHeap);
  }

  /**
   * Sets offheap enabled
   */
  protected void setOffheapEnabled(boolean offheapEnabledParam) {
    this.offheapEnabled = offheapEnabledParam;
    addFieldToApply(ToolkitConfigFields.OFFHEAP_ENABLED_FIELD_NAME, this.offheapEnabled);
  }

  /**
   * Sets local cache enabled
   */
  protected void setLocalCacheEnabled(boolean localCacheEnabledParam) {
    this.localCacheEnabled = localCacheEnabledParam;
    addFieldToApply(ToolkitConfigFields.LOCAL_CACHE_ENABLED_FIELD_NAME, this.localCacheEnabled);
  }

  /**
   * Sets compression enabled
   */
  protected void setCompressionEnabled(boolean compressionEnabledParam) {
    this.compressionEnabled = compressionEnabledParam;
    addFieldToApply(ToolkitConfigFields.COMPRESSION_ENABLED_FIELD_NAME, this.compressionEnabled);
  }

  /**
   * Sets copy on read enabled
   */
  protected void setCopyOnReadEnabled(boolean copyOnReadEnabledParam) {
    this.copyOnReadEnabled = copyOnReadEnabledParam;
    addFieldToApply(ToolkitConfigFields.COPY_ON_READ_ENABLED_FIELD_NAME, this.copyOnReadEnabled);
  }

  protected void setConfigField(String fieldName, Serializable value) {
    addFieldToApply(fieldName, value);
  }

  /**
   * Builds a {@link Configuration} for {@link ToolkitStore} by filling in appropriate mappings. Only adds mappings for
   * values which were set explicitly in this builder, and doesn’t fills in default values in the returned config.
   * Consult {@link ToolkitConfigFields} for the various configs supported and its default values
   */
  public Configuration build() {
    ConfigurationImpl configuration = new ConfigurationImpl();
    for (ConfigFieldMapping field : fieldMappings) {
      field.updateConfig(configuration);
    }
    return configuration;
  }

  /**
   * Apply changes of this builder to the {@link ToolkitStore} parameter. The changes are the ones between each apply.
   * <p>
   * If the store's configuration has {@link ToolkitConfigFields#MAX_BYTES_LOCAL_HEAP_FIELD_NAME} property set then
   * {@link AbstractToolkitStoreCacheConfigBuilder#setMaxCountLocalHeap(int)} would result in an error.
   * <p>
   * If the store's configuration has {@link ToolkitConfigFields#MAX_COUNT_LOCAL_HEAP_FIELD_NAME} property set then
   * {@link AbstractToolkitStoreCacheConfigBuilder#setMaxBytesLocalHeap(long)} would result in an error.
   */
  public void apply(ToolkitStore store) {
    for (Iterator<ConfigFieldMapping> iter = fieldMappings.iterator(); iter.hasNext();) {
      ConfigFieldMapping field = iter.next();
      field.apply(store);
      iter.remove();
    }
  }

  /**
   * Apply changes of this builder to the {@link ToolkitStore} parameter. The changes are the ones between each apply.
   * <p>
   * If the store's configuration has {@link ToolkitConfigFields#MAX_BYTES_LOCAL_HEAP_FIELD_NAME} property set then
   * {@link AbstractToolkitStoreCacheConfigBuilder#setMaxCountLocalHeap(int)} would result in an error.
   * <p>
   * If the store's configuration has {@link ToolkitConfigFields#MAX_COUNT_LOCAL_HEAP_FIELD_NAME} property set then
   * {@link AbstractToolkitStoreCacheConfigBuilder#setMaxBytesLocalHeap(long)} would result in an error.
   */
  public void apply(ToolkitCache cache) {
    for (Iterator<ConfigFieldMapping> iter = fieldMappings.iterator(); iter.hasNext();) {
      ConfigFieldMapping field = iter.next();
      field.apply(cache);
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

    void apply(ToolkitCache map) {
      map.setConfigField(fieldName, value);
    }

    void updateConfig(ConfigurationImpl configuration) {
      configuration.internalSetConfigMapping(fieldName, value);
    }
  }
}
