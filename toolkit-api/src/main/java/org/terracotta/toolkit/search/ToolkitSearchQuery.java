/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search;

import java.util.List;
import java.util.Set;

/**
 * Specifies search query parameters
 */
public interface ToolkitSearchQuery {

  /**
   * Returns set of attributes requested with each result.
   */
  <T> Set<T> getAttributes();

  /**
   * Returns set of group by attributes requested with each result.
   */
  <T> Set<T> getGroupByAttributes();

  /**
   * Returns list of attributes result set will be ordered on.
   */
  <T> List<T> getSortAttributes();

  /**
   * Returns aggregators requested in result set.
   */
  <T> List<T> getAggregators();

  /**
   * Returns maximum desired number of results.
   */
  int getMaxResults();

  /**
   * Returns true if this query requests keys in result, false otherwise.
   */
  boolean requestsKeys();

  /**
   * Returns true if this query requests values in result, false otherwise.
   */
  boolean requestsValues();

  /**
   * Execute this search query and return result set.
   */
  SearchQueryResultSet execute() throws SearchException;

}
