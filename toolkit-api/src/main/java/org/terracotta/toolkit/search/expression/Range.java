/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

import org.terracotta.toolkit.search.SearchException;
import org.terracotta.toolkit.search.attribute.ToolkitAttributeType;

/**
 * Clause that represents a range constraint. Open, half-open, and closed ranges are all supported. Values that define
 * the range must implement {@link Comparable}
 */
public class Range extends BaseClause {
  
  private final String     attributeName;
  private final Comparable min;
  private final Comparable max;
  private final boolean minInclusive;
  private final boolean maxInclusive;

  public Range(String attributeName, Object min, Object max, boolean minInclusive, boolean maxInclusive) {
    verifyType(attributeName, min, max);
    this.attributeName = attributeName;
    this.min = (Comparable) min;
    this.max = (Comparable) max;
    this.minInclusive = minInclusive;
    this.maxInclusive = maxInclusive;
  }
  
  private void verifyType(String attrName, Object minValue, Object maxValue) {
    if ((minValue == null) || (maxValue == null)) { throw new NullPointerException(); }

    ToolkitAttributeType minType = ToolkitAttributeType.typeFor(attrName, minValue);
    ToolkitAttributeType maxType = ToolkitAttributeType.typeFor(attrName, maxValue);

    if (minType != maxType) { throw new SearchException("Different types for min (" + minType + ") and max (" + maxType
                                                        + ")"); }
  }

  public Comparable getMin() {
    return min;
  }

  public Comparable getMax() {
    return max;
  }

  public boolean isMinInclusive() {
    return minInclusive;
  }

  public boolean isMaxInclusive() {
    return maxInclusive;
  }

  public String getAttributeName() {
    return attributeName;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(min).append(SEP).append(minInclusive ? "<=" : "<");
    sb.append(SEP).append(attributeName).append(SEP);
    sb.append(maxInclusive ? "<=" : "<").append(SEP).append(max);
    return sb.toString();
  }
}
