/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.object.serialization;

import org.terracotta.toolkit.ToolkitRuntimeException;

/**
 * A runtime exception that is thrown when objects cannot be serialized. Its similar to java.io.NotSerializableException
 * in intent, but is an unchecked exception.
 */
public class NotSerializableRuntimeException extends ToolkitRuntimeException {

  public NotSerializableRuntimeException() {
    super();
  }

  public NotSerializableRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotSerializableRuntimeException(String message) {
    super(message);
  }

  public NotSerializableRuntimeException(Throwable cause) {
    super(cause);
  }

}
