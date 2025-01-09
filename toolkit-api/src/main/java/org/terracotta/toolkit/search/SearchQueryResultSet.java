/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
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
