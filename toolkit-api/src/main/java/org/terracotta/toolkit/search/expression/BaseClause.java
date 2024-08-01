/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
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
