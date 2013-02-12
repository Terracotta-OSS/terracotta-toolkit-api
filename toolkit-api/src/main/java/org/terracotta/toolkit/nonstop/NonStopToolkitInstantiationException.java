/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

/**
 * An exception that is thrown when the asynchronous initialization of Toolkit fails.
 * 
 * @author Nishant
 */
public class NonStopToolkitInstantiationException extends NonStopException {
  public NonStopToolkitInstantiationException() {
    super();
  }

  public NonStopToolkitInstantiationException(String msg) {
    super(msg);
  }

  public NonStopToolkitInstantiationException(final Throwable cause) {
    super(cause);
  }

  public NonStopToolkitInstantiationException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
