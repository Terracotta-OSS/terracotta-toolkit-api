/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.object;

/**
 * An object that can be destroyed
 */
public interface Destroyable {
  /**
   * Query whether already destroyed or not
   * 
   * @return true if already destroyed
   */
  boolean isDestroyed();

  /**
   * Destroys the object. Subsequent calls are no-ops after invoking this method one time. In case of distributed
   * toolkits, calling destroy in one node destroys the instance in all the other nodes in the cluster.
   */
  void destroy();
}
