/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
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
