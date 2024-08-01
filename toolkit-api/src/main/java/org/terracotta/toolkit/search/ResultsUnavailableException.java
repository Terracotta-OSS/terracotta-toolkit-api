/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search;

public class ResultsUnavailableException extends SearchException {

  public ResultsUnavailableException(String message, Throwable cause) {
    super(message, cause);
  }

  public ResultsUnavailableException(String message) {
    super(message);
  }

  public ResultsUnavailableException(Throwable cause) {
    super(cause);
  }

}
