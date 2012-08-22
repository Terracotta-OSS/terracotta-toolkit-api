/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.events;

import org.terracotta.toolkit.cluster.ClusterNode;

/**
 * An notification event used by {@link ToolkitNotifier}
 */
public interface ToolkitNotificationEvent<T> {

  /**
   * Get the message associated with the event
   * 
   * @return the message
   */
  T getMessage();

  /**
   * Get the remote node that initiated the event.
   * 
   * @return the remote node, origin of the message
   */
  ClusterNode getRemoteNode();

}
