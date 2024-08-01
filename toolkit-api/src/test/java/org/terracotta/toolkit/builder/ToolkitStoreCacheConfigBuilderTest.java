/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */

package org.terracotta.toolkit.builder;

import org.junit.Test;
import org.terracotta.toolkit.config.Configuration;
import org.terracotta.toolkit.store.ToolkitConfigFields;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Eugene Shelestovich
 */
public class ToolkitStoreCacheConfigBuilderTest {

  @Test
  public void testSetGetStoreConfigurationOptions() {
    final Configuration config = new ToolkitStoreConfigBuilder()
        .concurrency(256)
        .consistency(ToolkitConfigFields.Consistency.EVENTUAL).build();
    assertEquals(ToolkitConfigFields.Consistency.EVENTUAL.name(),
        config.getObjectOrNull(ToolkitConfigFields.CONSISTENCY_FIELD_NAME));
    assertEquals(256, config.getInt(ToolkitConfigFields.CONCURRENCY_FIELD_NAME));
    assertFalse(config.hasField(ToolkitConfigFields.EVICTION_ENABLED_FIELD_NAME));
  }

  @Test
  public void testSetGetCacheConfigurationOptions() {
    final Configuration config = new ToolkitCacheConfigBuilder()
        .maxTotalCount(1000)
        .evictionEnabled(false).build();
    assertEquals(1000, config.getInt(ToolkitConfigFields.MAX_TOTAL_COUNT_FIELD_NAME));
    assertFalse(config.getBoolean(ToolkitConfigFields.EVICTION_ENABLED_FIELD_NAME));
  }
}
