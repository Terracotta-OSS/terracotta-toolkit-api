/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.search;

import org.terracotta.toolkit.search.SearchException;

/**
 * A builder that can be used for building and executing queries
 */
public interface SearchBuilder {
  SearchBuilder includeKeys(boolean include);

  SearchBuilder includeValues(boolean include);

  SearchBuilder attributeAscending(String attributeName);

  SearchBuilder attributeDescending(String attributeName);

  SearchBuilder attribute(String attributeName);

  SearchBuilder all();

  SearchBuilder and();

  SearchBuilder or();

  SearchBuilder beginGroup();

  SearchBuilder endGroup();

  SearchBuilder ilike(String name, Object value);

  SearchBuilder notIlike(String name, String regex);

  SearchBuilder greaterThan(String name, Object value);

  SearchBuilder greaterThanEqual(String name, Object value);

  SearchBuilder lessThan(String name, Object value);

  SearchBuilder lessThanEqual(String name, Object value);

  SearchBuilder between(String name1, Object value1, String name2, Object value2, boolean minInclusive,
                        boolean maxInclusive);

  SearchBuilder term(String attributeName, Object value);

  SearchBuilder notEqualTerm(String attributeName, Object value);

  SearchBuilder count();

  SearchBuilder sum(String attributeName);

  SearchBuilder average(String attributeName);

  SearchBuilder max(String attributeName);

  SearchBuilder min(String attributeName);

  SearchBuilder maxResults(int max);

  SearchQueryResultSet executeQuery(String cachename, int batchSize) throws SearchException;

  SearchBuilder groupBy(String name);

}
