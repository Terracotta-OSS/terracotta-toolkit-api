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
