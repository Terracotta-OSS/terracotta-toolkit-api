/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.feature;

import org.terracotta.toolkit.ToolkitRuntimeException;

/**
 * Exception that is thrown when trying to use a certain feature that is not supported by current toolkit runtime
 */
public class FeatureNotSupportedException extends ToolkitRuntimeException {

  public FeatureNotSupportedException() {
    super();
  }

  public FeatureNotSupportedException(String message, Throwable cause) {
    super(message, cause);
  }

  public FeatureNotSupportedException(String message) {
    super(message);
  }

  public FeatureNotSupportedException(Throwable cause) {
    super(cause);
  }

}
