/*
 * All content copyright (c) 2003-2008 Terracotta, Inc., except as may otherwise be noted in a separate copyright
 * notice. All rights reserved.
 */
package org.terracotta.cluster;

/**
 * This exception is thrown when an operation was performed on an object that is expected to be clustered in Terracotta
 */
public class UnclusteredObjectException extends RuntimeException {

  private final Object unclusteredObject;

  public UnclusteredObjectException(final Object unclusteredObject) {
    this.unclusteredObject = unclusteredObject;
  }

  /**
   * Returns the unclustered object
   * 
   * @return the unclustered object
   */
  public Object getUnclusteredObject() {
    return unclusteredObject;
  }
}