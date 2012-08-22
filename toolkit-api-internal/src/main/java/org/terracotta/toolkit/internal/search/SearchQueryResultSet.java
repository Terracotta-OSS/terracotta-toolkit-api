/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.search;

import java.util.List;

/**
 * Result of executing {@link SearchBuilder#executeQuery(String, int)}
 */
public interface SearchQueryResultSet {
  List<Object> getAggregatorResults();

  List<SearchResult> getResults();

  boolean isFirstBatchPrefetched();

  boolean anyCriteriaMatched();
}
