/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.search;

import org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor;

import java.util.Map;

public interface ToolkitAttributeExtractorInternal<K, V> extends ToolkitAttributeExtractor<K, V> {

  /**
   * Returns initial attribute type schema for cases when it is desired to pre-define data types for some or all of the
   * attributes to be indexed.
   */
  Map<String, Class<?>> getInitialTypeSchema();
}
