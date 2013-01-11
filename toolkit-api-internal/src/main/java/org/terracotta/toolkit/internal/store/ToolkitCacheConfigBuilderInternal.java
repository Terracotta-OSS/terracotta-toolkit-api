/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.store;

import org.terracotta.toolkit.cache.ToolkitCacheConfigBuilder;

/**
 * TODO FINAL ANYONE ?!
 */
public class ToolkitCacheConfigBuilderInternal extends ToolkitCacheConfigBuilder {

  private String localStoreManagerName;

  /**
   * Sets the local store manager name
   * 
   * @return same instance
   */

  public synchronized ToolkitCacheConfigBuilderInternal localStoreManagerName(String name) {
    this.localStoreManagerName = name;
    addFieldToApply(ToolkitStoreConfigFieldsInternal.LOCAL_STORE_MANAGER_NAME_NAME, this.localStoreManagerName);
    return this;
  }

  /**
   * Get the local store manager name
   * 
   * @return local store manager name
   */
  public synchronized String getLocalStoreManagerName() {
    return this.localStoreManagerName;
  }

}
