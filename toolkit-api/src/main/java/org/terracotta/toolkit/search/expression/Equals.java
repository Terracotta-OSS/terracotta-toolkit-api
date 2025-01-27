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
