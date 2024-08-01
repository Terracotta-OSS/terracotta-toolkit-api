/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.search;

import org.terracotta.toolkit.ToolkitRuntimeException;

public class SearchException extends ToolkitRuntimeException {

  public SearchException() {
    super();
  }

  public SearchException(String message, Throwable cause) {
    super(message, cause);
  }

  public SearchException(String message) {
    super(message);
  }

  public SearchException(Throwable cause) {
    super(cause);
  }

}
