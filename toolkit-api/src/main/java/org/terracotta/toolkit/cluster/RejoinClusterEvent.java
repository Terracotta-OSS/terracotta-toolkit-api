/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.cluster;

public interface RejoinClusterEvent extends ClusterEvent {

  /**
   * Get the node before rejoin
   */
  ClusterNode getNodeBeforeRejoin();

  /**
   * Get the node after rejoin. This is same as {@link ClusterEvent#getNode()}
   */
  ClusterNode getNodeAfterRejoin();
}
