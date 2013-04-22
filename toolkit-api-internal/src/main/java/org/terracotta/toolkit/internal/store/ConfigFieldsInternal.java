/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.store;

public interface ConfigFieldsInternal {
  /**
   * Local store Manager name
   */
  String LOCAL_STORE_MANAGER_NAME_NAME    = "localStoreManagerName";
  /**
   * Is blank string by default. Uses a default local store manager name per toolkit unless specified
   */
  String DEFAULT_LOCAL_STORE_MANAGER_NAME = "";
  /**
   * lock strategy used for toolkit store/cache
   */
  String LOCK_STRATEGY_NAME               = "LOCK_STRATEGY";

  public enum LOCK_STRATEGY {
    LONG_LOCK_STRATEGY, STRING_LOCK_STRATEGY, OBJECT_LOCK_STRATEGY
  }

}
