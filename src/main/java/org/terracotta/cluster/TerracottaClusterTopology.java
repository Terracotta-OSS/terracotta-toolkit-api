/*
 * All content copyright (c) 2003-2008 Terracotta, Inc., except as may otherwise be noted in a separate copyright
 * notice. All rights reserved.
 */
package org.terracotta.cluster;

import java.util.Collection;

/**
 * Provides access to the topology of the cluster, viewed from the current node.
 * <p>
 * This only takes client nodes into account, Terracotta server nodes are not included in this topology view.
 */
public interface TerracottaClusterTopology {
  /**
   * Returns a collection that contains a snapshot of the nodes that are part of the cluster at the time of the method
   * call.
   * 
   * @return the snapshot of the nodes in the cluster
   */
  public Collection<TerracottaNode> getNodes();
}