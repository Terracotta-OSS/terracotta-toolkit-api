/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.search.expression;

/**
 * Marker for always match type clause
 */
public class Always extends BaseClause {
  @Override
  public String toString() {
    return "ALL";
  }
}
