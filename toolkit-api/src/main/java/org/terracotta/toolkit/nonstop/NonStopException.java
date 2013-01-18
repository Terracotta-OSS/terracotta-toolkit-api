/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
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
