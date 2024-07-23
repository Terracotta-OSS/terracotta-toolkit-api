/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

import org.terracotta.toolkit.search.SearchException;
import org.terracotta.toolkit.search.attribute.ToolkitAttributeType;

import java.util.Collection;
import java.util.Iterator;

/**
 * Clause for constraining an attribute to choice of discrete values
 */
public class OneOf extends BaseClause {
  private final String        attributeName;
  private final Collection<?>        values;

  public OneOf(String attributeName, Collection<?> values) {
    if (attributeName == null || values == null) { throw new NullPointerException(); }
    this.attributeName = attributeName;
    this.values = values;

    if (!values.isEmpty()) {
      verifyCommonType();
    }
  }

  private void verifyCommonType() {
    if (values.isEmpty()) { throw new AssertionError(); }

    ToolkitAttributeType rv = null;
    for (Object value : values) {
      if (value == null) { throw new NullPointerException("null element in set"); }

      ToolkitAttributeType at = ToolkitAttributeType.typeFor(attributeName, value);
      if (rv == null) {
        rv = at;
      } else if (at != rv) { throw new SearchException("Multiple types detected in collection: " + at + " and " + rv); }
    }
  }

  public String getAttributeName() {
    return attributeName;
  }

  public Collection<?> values() {
    return values;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(attributeName).append(SEP).append("IN").append(SEP).append("{");
    Iterator<?> itr = values.iterator();
    boolean go = itr.hasNext();
    while (go) {
      sb.append(itr.next());
      go = itr.hasNext();
      if (go) {
        sb.append(",").append(SEP);
      }
    }
    sb.append("}");
    return sb.toString();
  }

}
