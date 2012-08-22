/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.store;

import org.terracotta.toolkit.tck.TCKStrict;

/**
 * Details of Configuration fields used to configure {@link ToolkitStore}
 * 
 * @see Toolkit#getStore(String, Configuration, Class<V>)
 * @see ToolkitStoreConfigBuilder
 */
public interface ToolkitStoreConfigFields {

  /**
   * Enum type representing valid values for {@link ToolkitStoreConfigFields#CONSISTENCY_FIELD_NAME} name mapping. Use
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
   * {@link ToolkitStoreConfigFields#DEFAULT_CONCURRENCY}. Paramater name in config
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
}