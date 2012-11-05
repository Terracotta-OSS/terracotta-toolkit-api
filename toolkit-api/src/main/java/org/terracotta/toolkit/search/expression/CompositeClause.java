/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

/**
 * A clause comprised of multiple sub-clauses
 */
public interface CompositeClause extends Clause {
  /**
   * Returns array of sub-clauses this clause is composed of.
   */
  Clause[] getMembers();
}
