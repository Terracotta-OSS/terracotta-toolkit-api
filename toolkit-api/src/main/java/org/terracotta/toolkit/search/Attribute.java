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
package org.terracotta.toolkit.search;

import org.terracotta.toolkit.search.expression.Clause;
import org.terracotta.toolkit.search.expression.Equals;
import org.terracotta.toolkit.search.expression.Exists;
import org.terracotta.toolkit.search.expression.Matches;
import org.terracotta.toolkit.search.expression.OneOf;
import org.terracotta.toolkit.search.expression.Range;
import org.terracotta.toolkit.search.expression.RelationalClause;

import java.util.Collection;

/**
 * Represents search attribute
 */
public class Attribute<T> {
  private final String attributeName;

  /**
   * Construct a new attribute instance
   * 
   * @param attributeName the name of search attribute
   */
  public Attribute(String attributeName) {
    if (attributeName == null) { throw new NullPointerException(); }
    this.attributeName = attributeName;
  }

  /**
   * Get the attribute name
   * 
   * @return the attribute name
   */
  public String getAttributeName() {
    return attributeName;
  }

  /**
   * Create a range search clause between the given min/max (inclusive). This is the same as calling
   * <code>between(min, max, true, true)</code>
   * 
   * @param min the minimum value in the range
   * @param max the maximum value in the range
   * @return clause instance
   */
  public Clause range(T min, T max) {
    return range(min, max, true, true);
  }

  /**
   * Create a range clause between the given min/max with specified inclusiveness
   * 
   * @param min the minimum value in the range
   * @param max the maximum value in the range
   * @param minInclusive is the minimum inclusive in the range
   * @param maxInclusive is the maximum inclusive in the range
   * @return clause instance
   */
  public Clause range(T min, T max, boolean minInclusive, boolean maxInclusive) {
    return new Range(attributeName, min, max, minInclusive, maxInclusive);
  }

  /**
   * Create a clause where the value of this attribute must be one of the given values.
   * 
   * @param values
   * @return clause instance
   */
  public Clause oneOf(Collection<? extends T> values) {
    return new OneOf(attributeName, values);
  }

  /**
   * Create a clause where this attribute is not equal to the given value
   * 
   * @param value
   * @return clause instance
   */
  public Clause ne(T value) {
    return new Equals(attributeName, value).not();
  }
  
   /**
   * Create a clause where this attribute is less than the given value
   *
   * @param value
   * @return clause instance
   */
   public Clause lt(T value) {
    return RelationalClause.lt(attributeName, value);
   }

  /**
   * Create a clause where this attribute is less than or equal to the given value
   * 
   * @param value
   * @return clause instance
   */
  public Clause le(T value) {
    return RelationalClause.lte(attributeName, value);
  }

  /**
   * Create a clause where this attribute is greater than the given value
   * 
   * @param value
   * @return clause instance
   */
  public Clause gt(T value) {
    return RelationalClause.gt(attributeName, value);
  }

   /**
   * Create a clause where this attribute is greater than or equal to the given value
   *
   * @param value
   * @return clause instance
   */
   public Clause ge(T value) {
    return RelationalClause.gte(attributeName, value);
   }
  
   /**
   * Create a clause where this attribute is equal to the given value
   *
   * @param value
   * @return clause instance
   */
   public Clause eq(T value) {
   return new Equals(attributeName, value);
   }

  /**
   * Create a clause that tests for presence of value for this attribute
   */
   public Clause exists() {
    return new Exists(attributeName);
   }
  
   /**
   * Create a clause where this attribute's toString() matches the given expression See
   * {@link Matches} for the expression syntax
   *
   * @param regex
   * @return clause instance
   */
   public Clause matches(String regex) {
   return new Matches(attributeName, regex);
   }

  /**
   * Request a count aggregation of this attribute
   * 
   * @return count aggregator
   */
  public AggregateFunction count() {
    return AggregateFunction.count();
  }

  /**
   * Request a maximum value aggregation of this attribute
   * 
   * @return max aggregator
   */
  public AggregateFunction max() {
    return AggregateFunction.max(attributeName);
  }

  /**
   * Request a minimum value aggregation of this attribute
   * 
   * @return min aggregator
   */
  public AggregateFunction min() {
    return AggregateFunction.min(attributeName);
  }

  /**
   * Request a sum aggregation of this attribute
   * 
   * @return sum aggregator
   */
  public AggregateFunction sum() {
    return AggregateFunction.sum(attributeName);
  }

  /**
   * Request an average value aggregation of this attribute
   * 
   * @return average aggregator
   */
  public AggregateFunction average() {
    return AggregateFunction.average(attributeName);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return attributeName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return attributeName.hashCode();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Attribute) {
      Attribute other = (Attribute) obj;
      return attributeName.equals(other.attributeName);
    }
    return false;
  }

}
