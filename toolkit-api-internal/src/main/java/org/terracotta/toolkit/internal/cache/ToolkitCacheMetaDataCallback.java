/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.cache;

import org.terracotta.toolkit.internal.meta.MetaData;

/**
 * A callback for {@link ToolkitCacheWithMetadata}
 */
public interface ToolkitCacheMetaDataCallback {

  /**
   * Return MetaData to be used on remove due to eviction. May return null.
   */
  MetaData getEvictRemoveMetaData();
}
