/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.store;

import org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder;
import org.terracotta.toolkit.cache.ToolkitCache;
import org.terracotta.toolkit.tck.TCKStrict;

/**
 * Details of Configuration fields used to configure {@link ToolkitStore} & {@link ToolkitCache}
 * 
 * @see ToolkitStoreConfigBuilder & ToolkitCacheConfigBuilder
 */
public interface ToolkitConfigFields {

  /**
   * Enum type representing valid values for {@link ToolkitConfigFields#CONSISTENCY_FIELD_NAME} name mapping. Use
   * {@link Consistency#name()}
   */
  @TCKStrict
  public enum Consistency {
    /**
     * Strong consistency with sync-write locks
     */
    SYNCHRONOUS_STRONG,
    /**
     * Strong consistency with write locks
     */
    STRONG,
    /**
     * Eventual consistency with concurrent locks
     */
    EVENTUAL
  }

  /**
   * Specifies concurrency of the key value Store. Valid values are positive integers. Default value is
   * {@link ToolkitConfigFields#DEFAULT_CONCURRENCY}. Paramater name in config
   */
  String  CONCURRENCY_FIELD_NAME             = "concurrency";
  int     DEFAULT_CONCURRENCY                = 256;

  /**
   * Valid value can only be one of the {@link Consistency#name()}
   */
  String  CONSISTENCY_FIELD_NAME             = "consistency";
  String  DEFAULT_CONSISTENCY                = Consistency.EVENTUAL.name();

  /**
   * Valid values are positive integers
   */
  String  MAX_COUNT_LOCAL_HEAP_FIELD_NAME    = "maxCountLocalHeap";
  int     DEFAULT_MAX_COUNT_LOCAL_HEAP       = 0;

  /**
   * Valid value are Strings like "1024", "1024m", "1g"
   */
  String  MAX_BYTES_LOCAL_HEAP_FIELD_NAME    = "maxBytesLocalHeap";
  long    DEFAULT_MAX_BYTES_LOCAL_HEAP       = 0;

  /**
   * Valid value are Strings like "1024", "1024m", "1g"
   */
  String  MAX_BYTES_LOCAL_OFFHEAP_FIELD_NAME = "maxBytesLocalOffHeap";
  long    DEFAULT_MAX_BYTES_LOCAL_OFFHEAP    = 0;

  /**
   * Valid value are true or false
   */
  String  OFFHEAP_ENABLED_FIELD_NAME         = "offheapEnabled";
  boolean DEFAULT_OFFHEAP_ENABLED            = false;

  /**
   * Valid value are true or false
   */
  String  LOCAL_CACHE_ENABLED_FIELD_NAME     = "localCacheEnabled";
  boolean DEFAULT_LOCAL_CACHE_ENABLED        = true;

  /**
   * Valid value are true or false
   */
  String  COMPRESSION_ENABLED_FIELD_NAME     = "compressionEnabled";
  boolean DEFAULT_COMPRESSION_ENABLED        = false;

  /**
   * Valid value are true or false
   */
  String  COPY_ON_READ_ENABLED_FIELD_NAME    = "copyOnReadEnabled";
  boolean DEFAULT_COPY_ON_READ_ENABLED       = false;

  /**
   * Enum type representing valid values for {@link ToolkitConfigFields#PINNING_STORE_FIELD_NAME} name mapping. Use
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