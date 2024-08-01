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

import org.terracotta.toolkit.search.expression.BooleanClause.Operator;

/**
 * Base class for all search clauses
 */
public abstract class BaseClause implements Clause {

  /**
   * Output separator
   */
  protected final static String SEP = " ";

  @Override
  public BooleanClause and(Clause other) {
    return new BooleanClause(Operator.AND, this, other);
  }

  @Override
  public BooleanClause or(Clause other) {
    return new BooleanClause(Operator.OR, this, other);
  }

  @Override
  public BooleanClause not() {
    return new BooleanClause(Operator.NOT, this);
  }

}
