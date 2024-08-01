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
