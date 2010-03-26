/*
 * All content copyright (c) 2003-2008 Terracotta, Inc., except as may otherwise be noted in a separate copyright
 * notice. All rights reserved.
 */
package org.terracotta.cluster;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * The {@code TerracottaCluster} interface provides access to Terracotta cluster events and meta data.
 * <p>
 * Note that only terracotta client nodes are taken into account for the cluster events and meta data, information about
 * server nodes is not available.
 * <p>
 * See {@link TerracottaClusterListener} for more information about the events themselves.
 */
public interface TerracottaCluster {
  /**
   * Adds a cluster events listener.
   * <p>
   * If the cluster events listener instance has already been registered before, this method will not register it again.
   * <p>
   * When the cluster is already joined or the operations have already been enabled, those events will be immediately
   * triggered on the listener when it's registered.
   * 
   * @param listener the cluster listener instance that will be registered
   */
  public void addClusterListener(TerracottaClusterListener listener);

  /**
   * Removes a cluster events listener.
   * <p>
   * If the cluster events listener instance was not registered before, this method will have no effect.
   * 
   * @param listener the cluster listener instance that will be unregistered
   */
  public void removeClusterListener(TerracottaClusterListener listener);

  /**
   * Retrieves a view of the topology of the cluster, as seen from the current node.
   * <p>
   * Note that the returned topology instance will be updated internally as nodes joined and leave the cluster. If you
   * want a snapshot of the current nodes in the cluster, you should use the
   * {@link TerracottaClusterTopology#getNodes()} method.
   * 
   * @return an instance of the cluster topology as seen from the current node
   */
  public TerracottaClusterTopology getClusterTopology();

  /**
   * Retrieves the {@code TerracottaNode} instance that corresponds to the current node.
   * 
   * @return the {@code TerracottaNode} instance that corresponds to the current node
   */
  public TerracottaNode getCurrentNode();

  /**
   * Indicates whether the current node has joined the cluster.
   * 
   * @return {@code true} if the current node has joined the cluster; {@code false} otherwise
   */
  public boolean isNodeJoined();

  /**
   * Indicates whether operations are enabled on the current node.
   * 
   * @return {@code true} if operations are enabled on the current node; {@code false} otherwise
   */
  public boolean areOperationsEnabled();

  /**
   * Determine on which nodes a particular object is faulted.
   * 
   * @param object the object that will be checked
   * @throws UnclusteredObjectException when the object isn't clustered
   * @return the set of nodes where the object is faulted;
   *         <p>
   *         this never returns {@code null}, so null checks aren't needed
   */
  public Set<TerracottaNode> getNodesWithObject(Object object) throws UnclusteredObjectException;

  /**
   * Determine where a series of clustered objects is faulted.
   * <p>
   * Each object will be a key in the map that is returned, with sets of nodes as values that indicate where the objects
   * are faulted.
   * 
   * @param objects the objects that will be checked
   * @throws UnclusteredObjectException when any of the objects isn't clustered
   * @return the map of nodes where the objects are faulted;
   *         <p>
   *         this never returns {@code null}, so null checks aren't needed
   */
  public Map<?, Set<TerracottaNode>> getNodesWithObjects(final Object... objects) throws UnclusteredObjectException;

  /**
   * Determine where a collection of clustered objects is faulted.
   * <p>
   * Each object will be a key in the map that is returned, with sets of nodes as values that indicate where the objects
   * are faulted.
   * 
   * @param objects the objects that will be checked
   * @throws UnclusteredObjectException when any of the objects isn't clustered
   * @return the map of nodes where the objects are faulted;
   *         <p>
   *         this never returns {@code null}, so null checks aren't needed
   */
  public Map<?, Set<TerracottaNode>> getNodesWithObjects(Collection<?> objects) throws UnclusteredObjectException;

  /**
   * Retrieve a set of keys for map values that are not faulted anywhere out of a clustered map for which partialness is
   * supported.
   * 
   * @param map the map with the values that will be checked
   * @throws UnclusteredObjectException when the map isn't clustered
   * @return the set of keys for the values that are faulted nowhere;
   *         <p>
   *         an empty set if the map doesn't support partialness;
   *         <p>
   *         this never returns {@code null}, so null checks aren't needed
   */
  public <K> Set<K> getKeysForOrphanedValues(Map<K, ?> map) throws UnclusteredObjectException;

  /**
   * Retrieve a set of keys for map values that are faulted on the current node out of a clustered map for which
   * partialness is supported.
   * 
   * @param map the map with the values that will be checked
   * @throws UnclusteredObjectException when the map isn't clustered
   * @return the set of keys for the values that are faulted on the current node;
   *         <p>
   *         an empty set if the map doesn't support partialness;
   *         <p>
   *         this never returns {@code null}, so null checks aren't needed
   */
  public <K> Set<K> getKeysForLocalValues(Map<K, ?> map) throws UnclusteredObjectException;
}