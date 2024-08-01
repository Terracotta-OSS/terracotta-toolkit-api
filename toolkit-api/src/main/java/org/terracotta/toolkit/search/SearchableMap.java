/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search;

import org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor;

public interface SearchableMap<K, V> {

  /**
   * Set indexed attribute extractor. This map is considered searchable if this method has been called at least once.
   */
  void setAttributeExtractor(ToolkitAttributeExtractor<K, V> attrExtractor);

  /**
   * Create a new query builder to construct a search query tied to this map
   */
  QueryBuilder createQueryBuilder();
}
