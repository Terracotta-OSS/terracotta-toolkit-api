/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.store;

public interface ToolkitStoreConfigFieldsInternal {
  /**
   * Local store Manager name
   */
  String LOCAL_STORE_MANAGER_NAME_NAME         = "localStoreManagerName";
  /**
   * Is blank string by default. Uses a default local store manager name per toolkit unless specified
   */
  String DEFAULT_LOCAL_STORE_MANAGER_NAME = "";
}
