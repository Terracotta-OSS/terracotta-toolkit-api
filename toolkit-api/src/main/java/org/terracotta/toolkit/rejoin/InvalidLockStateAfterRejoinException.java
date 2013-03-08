/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.rejoin;


/**
 * Unused -- will be removed in a future version
 * 
 * @deprecated
 */
@Deprecated
public class InvalidLockStateAfterRejoinException extends RejoinException {
  public InvalidLockStateAfterRejoinException() {
    super();
  }

  public InvalidLockStateAfterRejoinException(String msg) {
    super(msg);
  }

  public InvalidLockStateAfterRejoinException(final Throwable cause) {
    super(cause);
  }

  public InvalidLockStateAfterRejoinException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
