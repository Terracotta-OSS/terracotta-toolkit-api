/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
   * Returns max page size for search result retrieval
   */
  int getResultPageSize();

  /**
   * Execute this search query and return result set.
   */
  SearchQueryResultSet execute() throws SearchException;

}
