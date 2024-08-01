/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.ToolkitRuntimeException;

public class NonStopException extends ToolkitRuntimeException {
  public NonStopException() {
    super();
  }

  public NonStopException(String msg) {
    super(msg);
  }

  public NonStopException(final Throwable cause) {
    super(cause);
  }

  public NonStopException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
