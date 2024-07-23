/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

public class Exists extends BaseClause {

  private final String attributeName;

  public Exists(String attrName) {
    if (attrName == null) { throw new NullPointerException(); }
    attributeName = attrName;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getAttributeName()).append("?");
    return sb.toString();
  }

  public String getAttributeName() {
    return attributeName;
  }

}
