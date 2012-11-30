/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.rejoin;

public class RejoinException extends RuntimeException {

  public RejoinException() {
    super();
  }

  public RejoinException(String msg) {
    super(msg);
  }

  public RejoinException(Throwable cause) {
    super(cause);
  }

  public RejoinException(String message, Throwable cause) {
    super(message, cause);
  }

}
