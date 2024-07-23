/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
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