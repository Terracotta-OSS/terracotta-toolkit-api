/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

/**
 * A simple clause that represents equality of attribute of given name to specified value
 */
public class Equals extends BaseClause {
  private final String attributeName;
  private final Object value;

  public Equals(String attributeName, Object value) {
    if (value == null || attributeName == null) { throw new NullPointerException(); }

    this.attributeName = attributeName;
    this.value = value;
  }

  public Object getValue() {
    return value;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getAttributeName()).append(SEP).append("==").append(SEP).append(value);
    return sb.toString();
  }

  public String getAttributeName() {
    return attributeName;
  }
}
