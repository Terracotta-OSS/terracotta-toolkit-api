/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.toolkit.cluster;

/**
 * Indicates that the state of a node in the cluster has changed.
 */
public interface ClusterEvent {
  static enum Type {
    /**
     * Sent when a node joined the cluster, including the current node.
     * <p>
     * This event happens once for the lifetime of a node.
     */
    NODE_JOINED,

    /**
     * Sent when a node left the cluster, including the current node.
     * <p>
     * This event happens once for the lifetime of a node.
     * <p>
     * Note that this event might never be triggered for the node in question, other nodes in the cluster will however
     * always receive this event about nodes that have permanently left the cluster.
     */
    NODE_LEFT,

    /**
     * Sent when cluster operations are enabled on a node, any operations will go through and propagate through the
     * cluster.
     * <p>
     * This event can be repeated as many times as appropriate, but you're guaranteed to have always received a
     * {@code node joined} or {@code operations disabled} event before.
     * <p>
     * Only the current node will receive events concerning its own cluster operations.
     * 
     * @see ClusterInfo#areOperationsEnabled()
     */
    OPERATIONS_ENABLED,

    /**
     * Sent when cluster operations are disabled on a node, no cluster operations can go through.
     * <p>
     * They might propagate through the cluster if the operations are enabled again afterwards, however it's also
     * possible that the nodes is forced to leave the cluster instead.
     * <p>
     * This event can be repeated as many times as appropriate, but you're guaranteed to have always received an
     * {@code operations enabled} event before.
     * <p>
     * Only the current node will receive events concerning its own cluster operations.
     * 
     * @see ClusterInfo#areOperationsEnabled()
     */
    OPERATIONS_DISABLED,
    /**
     * When a node rejoins the cluster. {@link ClusterEvent#getNode()} will return the new node id after rejoin. This
     * event type is local and will be notified only in the current node.
     */
    NODE_REJOINED,
    /**
     * Event type representing an irrecoverable error in the current node. This event type is local and will be notified
     * only in the current node.
     */
    NODE_ERROR
  }

  /**
   * Retrieves the node that this event talks about.
   * 
   * @return the instance of the related node
   */
  ClusterNode getNode();

  /**
   * Retrieves the type of this event.
   * 
   * @return event type
   */
  Type getType();

  /**
   * Get the detailed message associated with the event
   * 
   * @return detailed message of the event
   */
  String getDetailedMessage();

}
