/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.cluster;

/**
 * A listener interface that can be implemented to be notified about cluster events.
 * <p>
 * Listeners can be registered through the {@link ClusterInfo#addClusterListener(ClusterListener) addClusterListener}
 * method and removed through the {@link ClusterInfo#removeClusterListener(ClusterListener) removeClusterListener}
 * method of a {@code ClusterInfo} instance.
 * <p>
 * The ordering and the timing of the events isn't guaranteed across the cluster. It is however guaranteed that the
 * events can only appear in the following order on each individual node:
 * <ol>
 * <li>node joined</li>
 * <li>operations enabled</li>
 * <li>operations disabled</li>
 * <li>node left</li>
 * </ol>
 * <p>
 * The {@code node joined} and {@code node left} events are sent to all the nodes in the cluster and happen once for the
 * lifetime of a node.
 * <p>
 * The {@code operations enabled} and {@code operations disabled} events are repeatable and indicate temporary
 * situations that may resolve themselves automatically over time. Only the current node will receive events concerning
 * its own cluster operations. Nodes in the cluster don't get cluster operation events about other nodes.
 */
public interface ClusterListener {
  /**
   * This method is called whenever a {@link ClusterEvent} occurs.
   * 
   * @param event details about the event
   */
  void onClusterEvent(ClusterEvent event);
}
