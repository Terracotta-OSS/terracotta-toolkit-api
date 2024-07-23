/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.rejoin;

import org.terracotta.toolkit.ToolkitRuntimeException;

/**
 * This exception is thrown when data-structures don't work anymore because a rejoin happened. For example, sublists in
 * ToolkitList, iterators etc won't work after rejoin. This exception is also thrown when threads are inside the
 * platform but rejoin is in progress.
 */
public class RejoinException extends ToolkitRuntimeException {

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
