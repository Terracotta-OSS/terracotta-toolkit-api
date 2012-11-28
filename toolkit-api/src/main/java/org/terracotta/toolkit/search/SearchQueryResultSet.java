/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
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

}
