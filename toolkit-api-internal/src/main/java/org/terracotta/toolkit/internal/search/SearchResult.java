/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.internal.search;

import java.util.List;
import java.util.Map;

/**
 * A part of {@link SearchQueryResultSet}
 */
public interface SearchResult {
  String getKey();

  Object getValue();

  void preFetchValue();

  Map<String, Object> getAttributes();

  Object[] getSortAttributes();

  Map<String, Object> getGroupByValues();

  List<Object> getAggregatorResults();
}
