/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

/**
 * A clause is a constraining boolean statement for use in search queries.
 */
public interface Clause {
  /**
   * Produce a clause that is the boolean "and" of this and the other given clause
   * 
   * @param other
   * @return and clause
   */
  Clause and(Clause other);

  /**
   * Produce a clause that is the boolean "or" of this and the other given clause
   * 
   * @param other
   * @return or clause
   */
  Clause or(Clause other);

  /**
   * Produce a clause that is the boolean "not" of this
   * 
   * @return not clause
   */
  Clause not();

}
