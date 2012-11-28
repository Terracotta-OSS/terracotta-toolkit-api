/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search;

import java.util.List;
import java.util.Map;

/**
 * A part of {@link SearchQueryResultSet}
 */
public interface SearchResult {
  /**
   * Get result key.
   */
  String getKey();

  /**
   * Get requested value from this result.
   */
  Object getValue();

  /**
   * Map of attribute names requested with the query to their respective values.
   */
  Map<String, Object> getAttributes();

  /**
   * Values of attributes to order by
   */
  Object[] getSortAttributes();

  /**
   * Map of group by attribute names requested with the query to their respective values.
   */
  Map<String, Object> getGroupByValues();

  /**
   * Aggregator results associated with this result. This list will be empty unless it is a grouped result.
   */
  List<Object> getAggregatorResults();
}
