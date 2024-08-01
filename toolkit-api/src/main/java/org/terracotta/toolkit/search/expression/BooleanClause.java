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

public class BooleanClause extends BaseClause implements CompositeClause {

  private final Clause[] members;
  private final Operator op;

  public enum Operator {
    AND, OR, NOT
  }

  public BooleanClause(Operator action, Clause... clauses) {
    if (clauses == null) throw new NullPointerException();
    if (action == Operator.NOT) {
      if (clauses.length != 1) { throw new IllegalArgumentException("Expecting exactly one clause"); }
    } else if (clauses.length < 2) { throw new IllegalArgumentException("Expecting at least two clauses"); }
    members = clauses;
    op = action;
  }

  @Override
  public Clause[] getMembers() {
    return members;
  }

  public Operator type() {
    return op;
  }

  @Override
  public String toString() {
    int i = 0;
    StringBuilder sb = new StringBuilder();
    if (op == Operator.NOT) {
      sb.append(op).append(SEP);
    }
    boolean go = true;
    while (go) {
      sb.append("(").append(members[i]).append(")");
      if (++i < members.length) {
        sb.append(SEP).append(op).append(SEP);
      } else go = false;
    }
    return sb.toString();
  }
}
