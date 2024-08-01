/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search;

public class AggregateFunction {

  public static enum Type {
    MIN, MAX, AVG, SUM, COUNT
  }

  private final String attributeName;
  private final Type   type;

  public AggregateFunction(String attr, Type t) {
    this.attributeName = attr;
    this.type = t;
  }

  public static AggregateFunction min(String attrName) {
    return new AggregateFunction(attrName, Type.MIN);
  }

  public static AggregateFunction max(String attrName) {
    return new AggregateFunction(attrName, Type.MAX);
  }

  public static AggregateFunction average(String attrName) {
    return new AggregateFunction(attrName, Type.AVG);
  }

  public static AggregateFunction sum(String attrName) {
    return new AggregateFunction(attrName, Type.SUM);
  }

  public static AggregateFunction count() {
    return new AggregateFunction(null, Type.COUNT);
  }

  public String getAttributeName() {
    return attributeName;
  }

  public Type getType() {
    return type;
  }

}
