/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit;

/**
 * Super class of all runtime exceptions thrown from toolkit
 */
public class ToolkitRuntimeException extends RuntimeException {

  public ToolkitRuntimeException() {
    super();
  }

  public ToolkitRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

  public ToolkitRuntimeException(String message) {
    super(message);
  }

  public ToolkitRuntimeException(Throwable cause) {
    super(cause);
  }

}
