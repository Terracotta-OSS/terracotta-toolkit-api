/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit;

/**
 * An exception that is thrown when a toolkit cannot be instantiated because of configuration error
 * 
 * @author Abhishek Sanoujam
 */
public class InvalidToolkitConfigException extends ToolkitInstantiationException {

  public InvalidToolkitConfigException() {
    super();
  }

  public InvalidToolkitConfigException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidToolkitConfigException(String message) {
    super(message);
  }

  public InvalidToolkitConfigException(Throwable cause) {
    super(cause);
  }

}
