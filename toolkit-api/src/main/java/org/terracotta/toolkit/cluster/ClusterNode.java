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
