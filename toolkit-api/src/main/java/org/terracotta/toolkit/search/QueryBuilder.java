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

import org.terracotta.toolkit.search.expression.Clause;

/**
 * This class encapsulates query building functionality. It can be thought of as a reusable factory to create queries
 * from given specifications. Once created, however, search queries can no longer be modified.
 * 
 * @see ToolkitSearchQuery
 */
public interface QueryBuilder {

  QueryBuilder includeKeys(boolean choice);

  QueryBuilder includeValues(boolean choice);

  QueryBuilder maxResults(int max);

  QueryBuilder includeAttribute(Attribute<?>... attr);

  QueryBuilder addGroupBy(Attribute<?>... attr);

  QueryBuilder addOrderBy(Attribute<?> attr, SortDirection dir);

  QueryBuilder includeAggregator(AggregateFunction... aggregators);

  QueryBuilder resultPageSize(int size);

  /**
   * Add a constraining clause to query to be built by this builder
   */
  QueryBuilder addClause(Clause clause);

  /**
   * Build the (immutable) query instance
   */
  ToolkitSearchQuery build();

}