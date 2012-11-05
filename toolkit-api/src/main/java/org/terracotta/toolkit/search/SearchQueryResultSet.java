/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search;

import java.util.List;

/**
 * Result of executing {@link SearchExecutor#executeQuery(ToolkitSearchQuery, int)}
 */
public interface SearchQueryResultSet {
  final int DEFAULT_RESULTS_BATCH_SIZE = 500;

  /**
   * Returns result of running requested aggregators
   */
  List<Object> getAggregatorResults();

  /**
   * TODO: return implementation similar to ClusteredResultsList that will take care of all the prefetching/iteration
   * details. Then remove the next method here.
   */
  List<SearchResult> getResults();

  /**
   * Internal use only
   */
  boolean isFirstBatchPrefetched();

  /**
   * Internal use only; returns <code>true</code> if the query that returned this result set matched anything.
   */
  boolean anyCriteriaMatched();

}
