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
package org.terracotta.toolkit.bulkload;

import org.terracotta.toolkit.object.ToolkitObject;

public interface ToolkitBulkLoadObject extends ToolkitObject {

  /**
   * Returns true if at least one node in the cluster is in bulk-load mode. Returns false otherwise.
   */
  public boolean isBulkLoadEnabled();

  /**
   * Returns true if the current node is in bulk-load mode. Returns false otherwise.
   */
  public boolean isNodeBulkLoadEnabled();

  /**
   * Enable/disable bulk-load mode in this node for this cache.
   */
  public void setNodeBulkLoadEnabled(boolean enabledBulkLoad);

  /**
   * This method waits until all the connected nodes have disabled bulk-load. Or in other words, calling this method
   * will block until all connected nodes in the cluster disables bulk-load. If none of the nodes did not enable
   * bulk-load this method will return immediately
   */
  public void waitUntilBulkLoadComplete() throws InterruptedException;

}
