/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
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
