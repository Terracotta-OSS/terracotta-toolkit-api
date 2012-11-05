/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search;


/**
 * Objects of this type can be used to execute toolkit search queries
 */
public interface SearchExecutor {

  /**
   * Execute given search query
   * 
   * @param query query to run
   * @param desired size for result batching
   * @return search query results
   */
  SearchQueryResultSet executeQuery(ToolkitSearchQuery query, int batchSize) throws SearchException;

}
