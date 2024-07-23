/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
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
