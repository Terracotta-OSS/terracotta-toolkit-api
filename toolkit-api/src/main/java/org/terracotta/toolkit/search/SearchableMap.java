/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search;

import org.terracotta.toolkit.search.attribute.ToolkitAttributeExtractor;

public interface SearchableMap<K, V> {

  /**
   * Set indexed attribute extractor. This store is considered searchable if this method has been called at least once.
   */
  void setAttributeExtractor(ToolkitAttributeExtractor<K, V> attrExtractor);

  /**
   * Create a new query builder to construct a search query tied to this store
   */
  QueryBuilder createQueryBuilder();
}
