/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
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
