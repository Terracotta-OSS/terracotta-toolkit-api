/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.cluster;

import java.util.Set;

/**
 * The {@code ClusterInfo} interface provides access to cluster events and metadata.
 * <p>
 * Note that only client nodes are taken into account for the cluster events and meta data, information about server
 * nodes is not available.
 * <p>
 * See {@link ClusterListener} for more information about the events themselves.
 */
public interface ClusterInfo {

  /**
   * Adds a cluster events listener.
   * <p>
   * If the cluster events listener instance has already been registered before, this method will not register it again.
   * <p>
   * If the node has already joined the cluster, and additionally if operations have already been enabled on this node,
   * then the corresponding events will be fired immediately
   * 
   * @param listener the cluster listener instance that will be registered
   */
  public void addClusterListener(ClusterListener listener);

  /**
   * Removes a cluster events listener.
   * <p>
   * If the cluster events listener instance was not registered before, this method will have no effect.
   * 
   * @param listener the cluster listener instance that will be unregistered
   */
  public void removeClusterListener(ClusterListener listener);

  /**
   * Retrieves the {@code ClusterNode} instance that corresponds to the current node.
   * 
   * @return the {@code ClusterNode} instance that corresponds to the current node, will return null cluster not
   *         initialized
   */
  public ClusterNode getCurrentNode();

  /**
   * Indicates whether any operations involving transfer of network data are enabled on the current node.
   * 
   * @return {@code true} if network operations are enabled on the current node; {@code false} otherwise
   */
  public boolean areOperationsEnabled();

  /**
   * Returns a collection that contains a snapshot of the nodes that are part of the cluster at the time of the method
   * call. The returned Set is not mutable.
   * 
   * @return the snapshot of the nodes in the cluster
   */
  public Set<ClusterNode> getNodes();
}
