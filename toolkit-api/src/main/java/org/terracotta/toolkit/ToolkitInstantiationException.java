/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

/**
 * An exception that is thrown when a toolkit cannot be instantiated
 * 
 * @author Abhishek Sanoujam
 */
public class ToolkitInstantiationException extends Exception {

  public ToolkitInstantiationException() {
    super();
  }

  public ToolkitInstantiationException(String message, Throwable cause) {
    super(message, cause);
  }

  public ToolkitInstantiationException(String message) {
    super(message);
  }

  public ToolkitInstantiationException(Throwable cause) {
    super(cause);
  }

}
