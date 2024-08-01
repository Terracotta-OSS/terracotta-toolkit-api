/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search;

import java.util.List;

/**
 * Result of executing {@link ToolkitSearchQuery}
 */
public interface SearchQueryResultSet {

  /**
   * Returns result of running requested aggregators
   */
  List<Object> getAggregatorResults();

  /**
   * Returns list of individual search results
   */
  List<SearchResult> getResults();

  /**
   * Returns <code>true</code> if the query that returned this result set matched anything.
   */
  boolean anyCriteriaMatched();

  /**
   * Closes this result set. This frees up all resources associated with this set and makes it unavailable for future
   * interactions.
   */
  void close();

  /**
   * @return true if this result set has been closed
   */
  boolean isClosed();
}
