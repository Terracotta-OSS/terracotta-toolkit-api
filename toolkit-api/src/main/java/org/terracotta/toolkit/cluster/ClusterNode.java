/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 * All rights reserved.
 */
package org.terracotta.toolkit.cluster;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * Describes a node in the cluster.
 */
public interface ClusterNode extends Serializable {

  /**
   * Returns the unique string identifier that corresponds to the node.
   * <p>
   * This identifier is unique for the life-time of the cluster. However, if the cluster is completely shut down and
   * brought back up again, these identifiers might be recycled.
   * 
   * @return string identifier for the node
   */
  public String getId();

  /**
   * Returns the IP address of the node. This is the IP address as seen by the cluster.
   * 
   * @return the IP address of the node as seen by the cluster
   */
  public InetAddress getAddress();
}
