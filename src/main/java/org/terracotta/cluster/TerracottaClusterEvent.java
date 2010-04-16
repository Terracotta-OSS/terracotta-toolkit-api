/*
 * All content copyright (c) 2003-2008 Terracotta, Inc., except as may otherwise be noted in a separate copyright
 * notice. All rights reserved.
 */
package org.terracotta.cluster;

/**
 * Indicates that the state of a node in the cluster has changed.
 * <p>
 * Instances of the {@code TerracottaClusterEvent} are provided as arguments of the {@link TerracottaClusterListener}
 * methods.
 */
public interface TerracottaClusterEvent {
  /**
   * Retrieves the node that this event talks about.
   * 
   * @return the instance of the related node
   */
  public TerracottaNode getNode();
}