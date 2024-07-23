/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

import org.terracotta.toolkit.search.SearchException;
import org.terracotta.toolkit.search.attribute.ToolkitAttributeType;

/**
 * Clause that represents relation between two values. Supported clauses are:
 * <ul>
 * <li>&lt;</li>
 * <li>&gt;</li>
 * <li>&lt;=</li>
 * <li>&gt;=</li>
 * </ul>
 * Static factory methods are available for convenience.
 */
public abstract class RelationalClause extends BaseClause {
  private final String     attributeName;
  private final String     tag;
  private final Comparable value;

  public static final class LessThan extends RelationalClause {
    public LessThan(String attributeName, Object value) {
      super(attributeName, "<", value);
    }
  }

  public static final class GreaterThan extends RelationalClause {
    public GreaterThan(String attributeName, Object value) {
      super(attributeName, ">", value);
    }

  }

  public static final class LessThanOrEqual extends RelationalClause {
    public LessThanOrEqual(String attributeName, Object value) {
      super(attributeName, "<=", value);
    }

  }

  public static final class GreaterThanOrEqual extends RelationalClause {
    public GreaterThanOrEqual(String attributeName, Object value) {
      super(attributeName, ">=", value);
    }
  }

  /**
   * Constructor
   * 
   * @param attributeName attribute name
   * @param value comparable value (used to infer type)
   */
  protected RelationalClause(String attributeName, String tag, Object value) {
    ToolkitAttributeType type = ToolkitAttributeType.typeFor(attributeName, value);

    if (!type.isComparable()) { throw new SearchException("Illegal (non-comparable) type for comparsion (" + type + ")"); }
    this.attributeName = attributeName;
    this.tag = tag;
    this.value = (Comparable) value;
  }

  public Comparable getValue() {
    return value;
  }

  public String getAttributeName() {
    return attributeName;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getAttributeName()).append(SEP).append(tag).append(SEP).append(getValue());
    return sb.toString();
  }

  public static RelationalClause lt(String name, Object value) {
    return new LessThan(name, value);
  }

  public static RelationalClause gt(String name, Object value) {
    return new GreaterThan(name, value);
  }

  public static RelationalClause lte(String name, Object value) {
    return new LessThanOrEqual(name, value);
  }

  public static RelationalClause gte(String name, Object value) {
    return new GreaterThanOrEqual(name, value);
  }
}
