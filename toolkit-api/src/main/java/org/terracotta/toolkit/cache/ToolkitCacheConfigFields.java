/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.cache;

import org.terracotta.toolkit.store.ToolkitStoreConfigFields;
import org.terracotta.toolkit.tck.TCKStrict;

/**
 * 
 /** Configuration fields used to configure {@link ToolkitCache}
 * 
 * @see Toolkit#getCache(String, Configuration, Class<V>)
 * @see ToolkitCache#setConfigField(String, Object)
 * @see ToolkitCacheConfigBuilder
 */
public interface ToolkitCacheConfigFields extends ToolkitStoreConfigFields {
  /**
   * Enum type representing valid values for {@link ToolkitStoreConfigFields#PINNING_STORE_FIELD_NAME} name mapping. Use
   * {@link PinningStore#name()}
   */
  @TCKStrict
  public enum PinningStore {
    INCACHE, LOCALHEAP, LOCALMEMORY, NONE
  }

  /**
   * Time to idle (in seconds) for a Cache<br>
   * 0 means Infinite.<br>
   * Valid Values are positive integers
   */
  String MAX_TTI_SECONDS_FIELD_NAME = "maxTTISeconds";
  int    DEFAULT_MAX_TTI_SECONDS    = 0;
  int    NO_MAX_TTI_SECONDS         = DEFAULT_MAX_TTI_SECONDS;

  /**
   * Time to live (in seconds) for a Cache<br>
   * 0 means Infinite.<br>
   * Valid Values are positive integers
   */
  String MAX_TTL_SECONDS_FIELD_NAME = "maxTTLSeconds";
  int    NO_MAX_TTL_SECONDS         = 0;
  int    DEFAULT_MAX_TTL_SECONDS    = NO_MAX_TTL_SECONDS;

  /**
   * Total Max count (capacity) allowed for this cache<br>
   * 0 means Infinite.<br>
   * Valid Values are positive integers
   */
  String MAX_TOTAL_COUNT_FIELD_NAME = "maxTotalCount";
  int    DEFAULT_MAX_TOTAL_COUNT    = 0;

  /**
   * Pinning store of the Map. Valid values are one of {@link PinningStore#getConfigString()}
   */
  String PINNING_STORE_FIELD_NAME   = "pinningStore";
  String DEFAULT_PINNING_STORE      = PinningStore.NONE.name();

}
